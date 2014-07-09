package hudson.plugins.sctmexecutor;

import hudson.FilePath;
import hudson.Launcher;
import hudson.model.BuildListener;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.Hudson;
import hudson.plugins.sctmexecutor.exceptions.SCTMException;
import hudson.plugins.sctmexecutor.service.ISCTMService;
import hudson.plugins.sctmexecutor.service.SCTMReRunProxy;
import hudson.plugins.sctmexecutor.service.SCTMService;
import hudson.tasks.Builder;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jenkinsci.plugins.tokenmacro.MacroEvaluationException;
import org.jenkinsci.plugins.tokenmacro.TokenMacro;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 * Executes a specified execution definition on Borland's SilkCentral Test Manager.
 * 
 * @author Thomas Fuerer
 * 
 */
public final class SCTMExecutor extends Builder {
  static final int OPT_NO_BUILD_NUMBER = 1;
  static final int OPT_USE_THIS_BUILD_NUMBER = 2;
  static final int OPT_USE_SPECIFICJOB_BUILDNUMBER = 3;
  static final int OPT_USE_LATEST_SCTM_BUILDNUMBER = 4;
  static final int OPT_USE_CUSTOM_BUILDNUMBER = 5;
  private static final Logger LOGGER = Logger.getLogger("hudson.plugins.sctmexecutor"); //$NON-NLS-1$

  private final int projectId;
  private final String execDefIds;
  private final int delay;
  private final String params;
  private final int buildNumberUsageOption;
  private final String jobName;
  private final String customBuildNumber;
  private final boolean continueOnError;
  private final boolean collectResults;
  private final boolean ignoreSetupCleanup;
  
  private boolean succeed;
  private String product;
  private String productVersion;

  @DataBoundConstructor
  public SCTMExecutor(final int projectId, final String execDefIds, final String params, final int delay, final int buildNumberUsageOption, 
      final String jobName, final String customBuildNumber, final boolean contOnErr, final boolean collectResults, final boolean ignoreSetupCleanup) {
    this.projectId = projectId;
    this.execDefIds = execDefIds;
    this.params = params;
    this.delay = delay;
    this.buildNumberUsageOption = buildNumberUsageOption;
    this.jobName = jobName;
    this.customBuildNumber = customBuildNumber;
    this.continueOnError = contOnErr;
    this.collectResults = collectResults;
    this.ignoreSetupCleanup = ignoreSetupCleanup;    
  }

  private ISCTMService createSctmService(final int projectId, List<Integer> execDefIdList) throws SCTMException {
    SCTMExecutorDescriptor descriptor = getDescriptor();
    String serviceURL = descriptor.getServiceURL();
    ISCTMService service = null;
    service = new SCTMReRunProxy(new SCTMService(serviceURL, descriptor.getUser(), descriptor.getPassword(), projectId));
    
    int firstExecDefId = execDefIdList.get(0); //used to collect global definitions for all executions
    this.product = service.getProductName(firstExecDefId);
    this.productVersion = service.getProductVersion(firstExecDefId);
    
    return service;
  }

  @Override
  public SCTMExecutorDescriptor getDescriptor() {
    return (SCTMExecutorDescriptor) Hudson.getInstance().getDescriptor(getClass());
  }

  public String getExecDefIds() {
    return execDefIds;
  }

  public int getProjectId() {
    return projectId;
  }

  public int getDelay() {
    return delay;
  }

  public int getBuildNumberUsageOption() {
    return this.buildNumberUsageOption;
  }

  public String getJobName() {
    return this.jobName;
  }  

  public String getParams() {
    return params;
  }  

  public String getCustomBuildNumber() {
    return customBuildNumber;
  }

  public boolean isContinueOnError() {
    return this.continueOnError;
  }

  public boolean isIgnoreSetupCleanup() {
    return this.ignoreSetupCleanup;
  }

  public boolean isCollectResults() {
    return this.collectResults;
  } 
  
  @Override
  public boolean perform(AbstractBuild<?, ?> build, Launcher launcher, BuildListener listener) throws InterruptedException, IOException {
    SCTMExecutorDescriptor descriptor = getDescriptor();
    String serviceURL = descriptor.getServiceURL();
    
    if(projectId == 0 || execDefIds == null || execDefIds.isEmpty()) {
      listener.getLogger().println(Messages.getString("SCTMExecutor.err.invalidConfig"));
      return false;
    }
    
    List<Integer> execDefIdList = Utils.splitToIntList(this.execDefIds);        
    //Replace macros from input
    Map<String, String> paramsMap = Utils.splitToMap(expandMacros(build, listener, this.params));
        
    try {
      ISCTMService service = createSctmService(projectId, execDefIdList);
      listener.getLogger().println(Messages.getString("SCTMExecutor.log.successfulLogin")); //$NON-NLS-1$
      FilePath rootDir = createResultDir(build.number, build, listener);

      Collection<Thread> executions = new ArrayList<Thread>(execDefIdList.size());
      String buildNumber = null;
      buildNumber = getOrAddBuildNumber(build, listener, service);
      for (Integer execDefId : execDefIdList) {
        ITestResultWriter resultWriter = null;
        if (collectResults) {
//          resultWriter = new StdXMLResultWriter(rootDir, serviceURL, String.valueOf(build.number),
//              this.ignoreSetupCleanup);
          resultWriter = new SCTMResultWriter(rootDir, service, ignoreSetupCleanup);
        }
        
        Runnable resultCollector = new ExecutionRunnable(service, execDefId, paramsMap, buildNumber, resultWriter, listener.getLogger());

        Thread t = new Thread(resultCollector);
        executions.add(t);
        t.start();
        if (delay > 0 && execDefIdList.size() > 1) {
          Thread.sleep(delay * 1000);
        }
      }

      for (Thread t : executions) {
        t.join();
      }

      succeed = true;
    } catch (SCTMException e) {
      LOGGER.log(Level.SEVERE, MessageFormat.format(
          "Creating a remote connection to SCTM host ({0}) failed.", serviceURL), e); //$NON-NLS-1$
      listener.fatalError(e.getMessage());
      succeed = false;
    }
    return continueOnError || succeed;
  }

  private String getOrAddBuildNumber(AbstractBuild<?, ?> build, BuildListener listener, ISCTMService service) throws SCTMException, IOException, InterruptedException {
    switch (this.buildNumberUsageOption) {
    case OPT_USE_THIS_BUILD_NUMBER:
    case OPT_USE_SPECIFICJOB_BUILDNUMBER:
    case OPT_USE_CUSTOM_BUILDNUMBER:
      String buildnumber = null;
      if (this.buildNumberUsageOption == OPT_USE_THIS_BUILD_NUMBER) {
        buildnumber = String.valueOf(build.number);
      } else if (this.buildNumberUsageOption == OPT_USE_SPECIFICJOB_BUILDNUMBER) {
        buildnumber = getBuildNumberFromUpStreamProject(jobName, build.getProject().getTransitiveUpstreamProjects(), listener);
      } else if (this.buildNumberUsageOption == OPT_USE_CUSTOM_BUILDNUMBER) {
        buildnumber = expandMacros(build, listener, customBuildNumber); //TODO implement this functionality
      }
      
      try {
        if (!service.buildNumberExists(product, productVersion, buildnumber)) {
          listener.getLogger().println(MessageFormat.format(Messages.getString("SCTMExecutor.msg.info.addBuildNumber"), buildnumber)); //$NON-NLS-1$
          if (!service.addBuildNumber(product, productVersion, buildnumber)) {
            buildnumber = null;
          }
        } else
          listener.getLogger().println(MessageFormat.format(Messages.getString("SCTMExecutor.msg.info.buildnumberExists"), buildnumber)); //$NON-NLS-1$
      } catch (IllegalArgumentException e) {
        listener.error(e.getMessage());
        buildnumber = null;
      }
      return buildnumber;
    case OPT_USE_LATEST_SCTM_BUILDNUMBER:
      return service.getLatestSCTMBuildnumber(product, productVersion);      
    default:
      return null;
    }
  }

  @SuppressWarnings("rawtypes")
  private String getBuildNumberFromUpStreamProject(String projectName, Set<AbstractProject> upstreamProjects,
      BuildListener listener) {
    for (AbstractProject<?, ?> project : upstreamProjects) {
      if (project.getName().equals(projectName))
        return String.valueOf(project.getLastSuccessfulBuild().getNumber());
    }
    listener.error(MessageFormat.format(Messages.getString("SCTMExecutor.err.notAUpstreamJob"), projectName)); //$NON-NLS-1$
    return null;
  }

  private FilePath createResultDir(int currentBuildNo, AbstractBuild<?, ?> build, BuildListener listener)
      throws IOException, InterruptedException {
    FilePath rootDir = build.getWorkspace();
    if (rootDir == null) {
      LOGGER.severe("Cannot write the result file because slave is not connected."); //$NON-NLS-1$
      listener.error(Messages.getString("SCTMExecutor.log.slaveNotConnected")); //$NON-NLS-1$
      throw new RuntimeException();
    }

    final String buildNo = String.valueOf(currentBuildNo);
    rootDir = new FilePath(rootDir, "SCTMResults"); //$NON-NLS-1$
    FilePath buildResults = new FilePath(rootDir, buildNo); //$NON-NLS-1$
    if (rootDir.exists()) {
      boolean found = false;
      for (FilePath file : rootDir.list()) {
        if (!file.getName().equals(buildNo)) // delete results of old builds
          file.deleteRecursive();
        else
          found = true;
      }
      if (!found)
        buildResults.mkdirs();
    } else
      buildResults.mkdirs();
    return buildResults;
  }  
  
  private String expandMacros(AbstractBuild<?, ?> build, BuildListener listener, final String template) throws IOException, InterruptedException {
    String result = template;
    try {
      result = TokenMacro.expandAll(build, listener, template);
    } catch (MacroEvaluationException e) {
      listener.getLogger().println(MessageFormat.format(Messages.getString("SCTMExecutor.err.expandMacros"), e.getMessage()));
    }
    return result;
  }
}
