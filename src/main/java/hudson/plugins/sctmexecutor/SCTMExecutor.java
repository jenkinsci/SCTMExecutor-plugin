package hudson.plugins.sctmexecutor;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.DataBoundSetter;

import hudson.FilePath;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.BuildListener;
import hudson.model.Cause;
import hudson.model.Run;
import hudson.model.TaskListener;
import hudson.model.Cause.UpstreamCause;
import hudson.plugins.sctmexecutor.exceptions.SCTMException;
import hudson.plugins.sctmexecutor.service.ISCTMService;
import hudson.plugins.sctmexecutor.service.SCTMReRunProxy;
import hudson.plugins.sctmexecutor.service.SCTMService;
import hudson.tasks.Builder;
import hudson.util.Secret;
import jenkins.model.Jenkins;
import jenkins.tasks.SimpleBuildStep;

/**
 * Executes a specified execution plan on Micro Focus Silk Central.
 * 
 * @author Thomas Fuerer
 * 
 */
public final class SCTMExecutor extends Builder implements SimpleBuildStep {
  static final int OPT_NO_BUILD_NUMBER = 1;
  static final int OPT_USE_THIS_BUILD_NUMBER = 2;
  static final int OPT_USE_SPECIFICJOB_BUILDNUMBER = 3;
  static final int OPT_USE_LATEST_SCTM_BUILDNUMBER = 4;
  private static final Logger LOGGER = Logger.getLogger("hudson.plugins.sctmexecutor"); //$NON-NLS-1$

  private final int projectId;
  private final String execDefIds;
  private String jobName;
  private int delay;
  private int buildNumberUsageOption;
  private boolean contOnErr;
  private boolean collectResults;
  private boolean ignoreSetupCleanup;
  private boolean useSpecificInstance;
  private String specificServiceURL;
  private String specificUser;
  private Secret specificPassword;

  @DataBoundConstructor
  public SCTMExecutor(int projectId, String execDefIds) {
    this.projectId = projectId;
    this.execDefIds = execDefIds;
    delay = 0;
    buildNumberUsageOption = OPT_NO_BUILD_NUMBER;
    jobName = null;
    contOnErr = false;
    collectResults = false;
    ignoreSetupCleanup = false;
    
    useSpecificInstance = false;
    specificServiceURL = null;
    specificUser = null;
    specificPassword = null;
  }

  @DataBoundSetter
  public void setBuildNumberUsageOption(int buildNumberUsageOption) {
    this.buildNumberUsageOption = buildNumberUsageOption;
  }
  @DataBoundSetter
  public void setJobName(String jobName) {
    this.jobName = jobName;
  }
  @DataBoundSetter
  public void setDelay(int delay) {
    this.delay = delay;
  }
  @DataBoundSetter
  public void setContOnErr(boolean contOnErr) {
    this.contOnErr = contOnErr;
  }
  @DataBoundSetter
  public void setCollectResults(boolean collectResults) {
    this.collectResults = collectResults;
  }
  @DataBoundSetter
  public void setIgnoreSetupCleanup(boolean ignoreSetupCleanup) {
    this.ignoreSetupCleanup = ignoreSetupCleanup;
  }
  @DataBoundSetter
  public void setUseSpecificInstance(boolean useSpecificInstance) {
    this.useSpecificInstance = useSpecificInstance;
  }
  @DataBoundSetter
  public void setSpecificServiceURL(String specificServiceURL) {
    this.specificServiceURL = specificServiceURL;
  }
  @DataBoundSetter
  public void setSpecificUser(String specificUser) {
    this.specificUser = specificUser;
  }
  @DataBoundSetter
  public void setSpecificPassword(String specificPassword) {
    this.specificPassword = Secret.fromString(specificPassword);
  }

  private ISCTMService createSctmService(int projectId) throws SCTMException {
    SCTMExecutorDescriptor descriptor = getDescriptor();
    String serviceURL = useSpecificInstance ? specificServiceURL : descriptor.getServiceURL();
    String user = useSpecificInstance ? specificUser : descriptor.getUser();
    String password = useSpecificInstance ? getSpecificPassword() : descriptor.getPassword();
    return new SCTMReRunProxy(new SCTMService(serviceURL, user, password, projectId));
  }

  @Override
  public SCTMExecutorDescriptor getDescriptor() {
    return (SCTMExecutorDescriptor) Jenkins.getInstance().getDescriptor(getClass());
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
    return buildNumberUsageOption;
  }

  public String getJobName() {
    return jobName;
  }

  public boolean isContOnErr() {
    return contOnErr;
  }

  public boolean isIgnoreSetupCleanup() {
    return ignoreSetupCleanup;
  }

  public boolean isCollectResults() {
    return collectResults;
  }
  
  public boolean isUseSpecificInstance() {
    return useSpecificInstance;
  }
  
  public String getSpecificServiceURL() {
    return specificServiceURL;
  }
  
  public String getSpecificUser() {
    return specificUser;
  }
  
  public String getSpecificPassword() {
    return Secret.toString(specificPassword);
  }
  
  @Override
  public void perform(Run<?, ?> run, FilePath filePath, Launcher launcher, TaskListener listener) throws InterruptedException, IOException {
    perform(run, filePath, listener);
  }
  
  @Override
  public boolean perform(AbstractBuild<?, ?> build, Launcher launcher, BuildListener listener)
      throws InterruptedException, IOException {
    return perform(build, build.getWorkspace(), listener);
  }

  private boolean perform(Run<?, ?> build, FilePath rootDir, TaskListener listener) throws IOException, InterruptedException {
    SCTMExecutorDescriptor descriptor = getDescriptor();
    String serviceURL = descriptor.getServiceURL();
    List<Integer> execDefIdList = Utils.csvToIntList(execDefIds);
    boolean succeed;
    try {
      ISCTMService service = createSctmService(projectId);
      listener.getLogger().println(Messages.getString("SCTMExecutor.log.successfulLogin")); //$NON-NLS-1$
      FilePath resultDir = createResultDir(build.number, rootDir, listener);

      Collection<Thread> executions = new ArrayList<>(execDefIdList.size());
      int buildNumber = getOrAddBuildNumber(build, listener, execDefIdList.get(0), service);
      for (Integer execDefId : execDefIdList) {
        ITestResultWriter resultWriter = null;
        if (collectResults) {
          resultWriter = new SCTMResultWriter(resultDir, service, ignoreSetupCleanup);
        }
        Runnable resultCollector = new ExecutionRunnable(service, execDefId, buildNumber, resultWriter, listener
            .getLogger());

        Thread t = new Thread(resultCollector);
        executions.add(t);
        t.start();
        if (delay > 0 && execDefIdList.size() > 1) {
          Thread.sleep(delay * 1000L);
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
    return contOnErr || succeed;
  }

  private int getOrAddBuildNumber(Run<?, ?> build, TaskListener listener, int nodeId, ISCTMService service) throws SCTMException {
    switch (buildNumberUsageOption) {
    case OPT_USE_THIS_BUILD_NUMBER:
    case OPT_USE_SPECIFICJOB_BUILDNUMBER:
      int buildnumber = -1;
      if (buildNumberUsageOption == OPT_USE_THIS_BUILD_NUMBER) {
        buildnumber = build.number;
      } else if (buildNumberUsageOption == OPT_USE_SPECIFICJOB_BUILDNUMBER) {
        Map<AbstractProject, Integer> upstreamBuilds = null;
        if (build instanceof AbstractBuild) {
          upstreamBuilds = ((AbstractBuild)build).getUpstreamBuilds();
        }
        if(upstreamBuilds != null && !upstreamBuilds.isEmpty()){
        	buildnumber = getBuildNumberFromUpStreamProject(jobName, upstreamBuilds , listener);
        }
        else {
        	buildnumber = findTriggerInCauses(build.getCauses(), jobName);
        }
      }
      try {
        service.addBuildNumberIfNotExists(nodeId, buildnumber);
      } catch (IllegalArgumentException e) {
        listener.error(e.getMessage());
        buildnumber = -1;
      }
      return buildnumber;
    case OPT_USE_LATEST_SCTM_BUILDNUMBER:
      return service.getLatestSCTMBuildnumber(nodeId);
    default:
      return -1;
    }
  }

	private int findTriggerInCauses(List<Cause> causes, String project) {
		for (Cause cause : causes) {
			if(cause instanceof UpstreamCause) {
				UpstreamCause usCause = (UpstreamCause) cause;
				if(usCause.getUpstreamProject().equals(project)) {
					return usCause.getUpstreamBuild();
				}
				else {
					return findTriggerInCauses(usCause.getUpstreamCauses(), project);
				}
			}
		}
		return -1;
	}

  @SuppressWarnings("rawtypes")
  private int getBuildNumberFromUpStreamProject(String projectName, Map<AbstractProject, Integer> map,
      TaskListener listener) {
    for (Entry<AbstractProject, Integer> project : map.entrySet()) {
      if (project.getKey().getName().equals(projectName)) {
        return project.getValue();
      }
    }
    listener.error(MessageFormat.format(Messages.getString("SCTMExecutor.err.notAUpstreamJob"), projectName)); //$NON-NLS-1$
    return -1;
  }

  private FilePath createResultDir(int currentBuildNo, FilePath rootDir, TaskListener listener)
      throws IOException, InterruptedException {
    if (rootDir == null) {
      LOGGER.severe("Cannot write the result file because slave is not connected."); //$NON-NLS-1$
      listener.error(Messages.getString("SCTMExecutor.log.slaveNotConnected")); //$NON-NLS-1$
      throw new RuntimeException();
    }

    final String buildNo = String.valueOf(currentBuildNo);
    rootDir = new FilePath(rootDir, "SCTMResults"); //$NON-NLS-1$
    FilePath buildResults = new FilePath(rootDir, buildNo);
    if (rootDir.exists()) {
      boolean found = false;
      for (FilePath file : rootDir.list()) {
        if (!file.getName().equals(buildNo)) {
          file.deleteRecursive();
        } else {
          found = true;
        }
      }
      if (!found) {
        buildResults.mkdirs();
      }
    } else {
      buildResults.mkdirs();
    }
    return buildResults;
  }

}

