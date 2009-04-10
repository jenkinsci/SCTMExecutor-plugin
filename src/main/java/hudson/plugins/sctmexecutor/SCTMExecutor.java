package hudson.plugins.sctmexecutor;

import hudson.FilePath;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.BuildListener;
import hudson.model.Descriptor;
import hudson.plugins.sctmexecutor.exceptions.EncryptionException;
import hudson.plugins.sctmexecutor.exceptions.SCTMException;
import hudson.plugins.sctmexecutor.service.ISCTMService;
import hudson.plugins.sctmexecutor.service.SCTMServiceFactory;
import hudson.tasks.Builder;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.rpc.ServiceException;

import org.kohsuke.stapler.DataBoundConstructor;

import com.borland.scc.sccsystem.SystemService;
import com.borland.scc.sccsystem.SystemServiceServiceLocator;
import com.borland.tm.webservices.tmexecution.ExecutionHandle;
import com.borland.tm.webservices.tmexecution.ExecutionWebService;
import com.borland.tm.webservices.tmexecution.ExecutionWebServiceServiceLocator;

/**
 * Executes a specified execution definition on Borland's SilkCentral Test Manager.
 * 
 * @author Thomas Fuerer
 * 
 */
public class SCTMExecutor extends Builder {
  public static final SCTMExecutorDescriptor DESCRIPTOR = new SCTMExecutorDescriptor();
  private static final Logger LOGGER = Logger.getLogger("hudson.plugins.sctmexecutor"); //$NON-NLS-1$

  private static int resultNoForLastBuild = 0;

  private final int projectId;
  private final String execDefIds;

  @DataBoundConstructor
  public SCTMExecutor(int projectId, String execDefIds) {
    this.projectId = projectId;
    this.execDefIds = execDefIds;

  }

  public Descriptor<Builder> getDescriptor() {
    return DESCRIPTOR;
  }

  public String getExecDefIds() {
    return execDefIds;
  }

  public int getProjectId() {
    return projectId;
  }

  @Override
  public boolean perform(AbstractBuild<?, ?> build, Launcher launcher, BuildListener listener) throws InterruptedException, IOException {
    ISCTMService service = null;
    String serviceURL = DESCRIPTOR.getServiceURL();
    try {
      service = SCTMServiceFactory.getInstance().getService(serviceURL, DESCRIPTOR.getUser(), DESCRIPTOR.getPassword(), true);
      listener.getLogger().println(Messages.getString("SCTMExecutor.log.successfulLogin")); //$NON-NLS-1$
    } catch (SCTMException e) {
      listener.error(e.getMessage());
      return false;
    }

    Queue<ExecutionHandle> execHandles = startExecutions(listener, service);
    
    collectResults(build, listener, service, execHandles);
  
    return true;
  }

  private void collectResults(AbstractBuild<?, ?> build, BuildListener listener, ISCTMService service, Queue<ExecutionHandle> execHandles) {
    try {
      FilePath rootDir = build.getProject().getWorkspace();
      if (rootDir == null) {
        LOGGER.severe("Cannot write the result file because slave is not connected.");
        listener.error(Messages.getString("SCTMExecutor.log.slaveNotConnected")); //$NON-NLS-1$
        throw new RuntimeException();
      }
      rootDir = createResultDir(rootDir, build.number);
      ExecutorService tp = DESCRIPTOR.getExecutorPool();
      List<Future<?>> results = new ArrayList<Future<?>>(execHandles.size());
      for (ExecutionHandle executionHandle : execHandles) {
        Runnable resultCollector = new ResultCollectorRunnable(service, listener.getLogger(), executionHandle, new StdXMLResultWriter(rootDir,
            DESCRIPTOR.getServiceURL()));
        results.add(tp.submit(resultCollector));
      }

      for (Future<?> res : results) {
        res.get();
      }
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      listener.error("Cannot create directory for the testresults in the hudson workspace. Check permissions and diskspace.");
      throw new RuntimeException();
    }
  }

  private Queue<ExecutionHandle> startExecutions(BuildListener listener, ISCTMService service) {
    Queue<ExecutionHandle> execHandles = new LinkedList<ExecutionHandle>();
    for (Integer execDefId : csvToIntList(execDefIds)) {
      Collection<ExecutionHandle> result = null;
      try {
        result = service.start(execDefId);
        if (result == null || result.size() <= 0) {
          listener.error(Messages.getString(Messages.getString("SCTMExecutor.err.execDefNotFound"), execDefId)); //$NON-NLS-1$
        } else {
          listener.getLogger().println(MessageFormat.format(Messages.getString("SCTMExecutor.log.successfulStartExecution"), execDefId));
          execHandles.addAll(result);
        }
      } catch (SCTMException e) {
        listener.error(e.getMessage());
      }
    }
    return execHandles;
  }

  private static FilePath createResultDir(FilePath rootDir, int currentBuildNo) throws IOException, InterruptedException {
    rootDir = new FilePath(rootDir, "SCTMResults"); //$NON-NLS-1$
    if (resultNoForLastBuild != currentBuildNo) {
      if (rootDir.exists())
        rootDir.deleteRecursive();
      rootDir.mkdirs();
      resultNoForLastBuild = currentBuildNo;
    }
    return rootDir;
  }

  private List<Integer> csvToIntList(String execDefIds) {
    List<Integer> list = new LinkedList<Integer>();
    if (execDefIds.contains(",")) { //$NON-NLS-1$
      String[] ids = execDefIds.split(","); //$NON-NLS-1$
      for (String str : ids) {
        list.add(Integer.valueOf(str));
      }
    } else {
      list.add(Integer.valueOf(execDefIds));
    }
    return list;
  }
}
