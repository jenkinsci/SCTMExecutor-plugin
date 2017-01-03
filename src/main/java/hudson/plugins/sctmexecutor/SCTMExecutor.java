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

import hudson.FilePath;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.BuildListener;
import hudson.model.Cause;
import hudson.model.Hudson;
import hudson.model.Cause.UpstreamCause;
import hudson.plugins.sctmexecutor.exceptions.SCTMException;
import hudson.plugins.sctmexecutor.service.ISCTMService;
import hudson.plugins.sctmexecutor.service.SCTMReRunProxy;
import hudson.plugins.sctmexecutor.service.SCTMService;
import hudson.tasks.Builder;

/**
 * Executes a specified execution definition on Borland's Silk Central.
 * 
 * @author Thomas Fuerer
 * 
 */
public final class SCTMExecutor extends Builder {
  static final int OPT_NO_BUILD_NUMBER = 1;
  static final int OPT_USE_THIS_BUILD_NUMBER = 2;
  static final int OPT_USE_SPECIFICJOB_BUILDNUMBER = 3;
  static final int OPT_USE_LATEST_SCTM_BUILDNUMBER = 4;
  private static final Logger LOGGER = Logger.getLogger("hudson.plugins.sctmexecutor"); //$NON-NLS-1$

  private final int projectId;
  private final String execDefIds;
  private final int delay;
  private final int buildNumberUsageOption;
  private final String jobName;
  private final boolean continueOnError;
  private final boolean collectResults;
  private final boolean ignoreSetupCleanup;

  private boolean succeed;

  @DataBoundConstructor
  public SCTMExecutor(final int projectId, final String execDefIds, final int delay, final int buildNumberUsageOption,
      final String jobName, final boolean contOnErr, final boolean collectResults, final boolean ignoreSetupCleanup) {
    this.projectId = projectId;
    this.execDefIds = execDefIds;
    this.delay = delay;
    this.buildNumberUsageOption = buildNumberUsageOption;
    this.jobName = jobName;
    continueOnError = contOnErr;
    this.collectResults = collectResults;
    this.ignoreSetupCleanup = ignoreSetupCleanup;
  }

  private ISCTMService createSctmService(final int projectId, List<Integer> execDefIdList) throws SCTMException {
    SCTMExecutorDescriptor descriptor = getDescriptor();
    String serviceURL = descriptor.getServiceURL();
    ISCTMService service = null;
    service = new SCTMReRunProxy(new SCTMService(serviceURL, descriptor.getUser(), descriptor.getPassword(), projectId));
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
    return buildNumberUsageOption;
  }

  public String getJobName() {
    return jobName;
  }

  public boolean isContinueOnError() {
    return continueOnError;
  }

  public boolean isignoreSetupCleanup() {
    return ignoreSetupCleanup;
  }

  public boolean isCollectResults() {
    return collectResults;
  }
  
  @Override
  public boolean perform(AbstractBuild<?, ?> build, Launcher launcher, BuildListener listener)
      throws InterruptedException, IOException {
    SCTMExecutorDescriptor descriptor = getDescriptor();
    String serviceURL = descriptor.getServiceURL();
    List<Integer> execDefIdList = Utils.csvToIntList(execDefIds);
    try {
      ISCTMService service = createSctmService(projectId, execDefIdList);
      listener.getLogger().println(Messages.getString("SCTMExecutor.log.successfulLogin")); //$NON-NLS-1$
      FilePath rootDir = createResultDir(build.number, build, listener);

      Collection<Thread> executions = new ArrayList<Thread>(execDefIdList.size());
      int buildNumber = -1;
      buildNumber = getOrAddBuildNumber(build, listener, execDefIdList.get(0), service);
      for (Integer execDefId : execDefIdList) {
        ITestResultWriter resultWriter = null;
        if (collectResults) {
          resultWriter = new SCTMResultWriter(rootDir, service, ignoreSetupCleanup);
        }
        Runnable resultCollector = new ExecutionRunnable(service, execDefId, buildNumber, resultWriter, listener
            .getLogger());

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

  private int getOrAddBuildNumber(AbstractBuild<?, ?> build, BuildListener listener, int nodeId, ISCTMService service) throws SCTMException {
    switch (buildNumberUsageOption) {
    case OPT_USE_THIS_BUILD_NUMBER:
    case OPT_USE_SPECIFICJOB_BUILDNUMBER:
      int buildnumber = -1;
      if (buildNumberUsageOption == OPT_USE_THIS_BUILD_NUMBER) {
        buildnumber = build.number;
      } else if (buildNumberUsageOption == OPT_USE_SPECIFICJOB_BUILDNUMBER) {
        Map<AbstractProject, Integer> upstreamBuilds = build.getUpstreamBuilds();
        if(!upstreamBuilds.isEmpty()){
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
      BuildListener listener) {
    for (Entry<AbstractProject, Integer> project : map.entrySet()) {
      if (project.getKey().equals(projectName)) {
        return project.getValue();
      }
    }
    listener.error(MessageFormat.format(Messages.getString("SCTMExecutor.err.notAUpstreamJob"), projectName)); //$NON-NLS-1$
    return -1;
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

