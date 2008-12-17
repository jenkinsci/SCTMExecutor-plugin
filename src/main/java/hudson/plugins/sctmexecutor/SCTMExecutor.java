package hudson.plugins.sctmexecutor;

import hudson.FilePath;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.BuildListener;
import hudson.model.Descriptor;
import hudson.model.Hudson;
import hudson.plugins.sctmexecutor.exceptions.EncryptionException;
import hudson.tasks.Builder;
import hudson.util.FormFieldValidator;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.xml.rpc.ServiceException;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

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
  private static final Logger LOGGER = Logger.getLogger("hudson.plumgins.sctmexecutor"); 

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
  public boolean perform(AbstractBuild<?, ?> build, Launcher launcher, BuildListener listener)
      throws InterruptedException, IOException {
    String serviceURL = DESCRIPTOR.getServiceURL();
    SystemService systemService;
    ExecutionWebService execService;
    try {
      systemService = new SystemServiceServiceLocator().getsccsystem(new URL(serviceURL + "/sccsystem?wsdl")); //$NON-NLS-1$
      execService = new ExecutionWebServiceServiceLocator().gettmexecution(new URL(serviceURL + "/tmexecution?wsdl")); //$NON-NLS-1$

      long sessionId = systemService.logonUser(DESCRIPTOR.getUser(), DESCRIPTOR.getPassword());
      listener.getLogger().println(Messages.getString("SCTMExecutor.log.successfulLogin")); //$NON-NLS-1$
      execService.setCurrentProject(sessionId, projectId);
      List<ExecutionHandle> execHandles = new ArrayList<ExecutionHandle>();
      for (Integer execDefId : csvToIntList(execDefIds)) {
        ExecutionHandle[] execHandleArr = execService.startExecution(sessionId, execDefId);
        if (execHandleArr.length <= 0 || execHandleArr[0] == null
            || (execHandleArr[0] != null && execHandleArr[0].getTimeStamp() <= 0)) {
          listener.error(Messages.getString("SCTMExecutor.err.execDefNotFound", execDefId)); //$NON-NLS-1$
          return false;
        } else {
          listener.getLogger().println(Messages.getString("SCTMExecutor.log.successfulStartExecution", execDefId)); //$NON-NLS-1$
          for (ExecutionHandle executionHandle : execHandleArr) {
            execHandles.add(executionHandle);
          }
        }
      }

      FilePath rootDir = build.getProject().getWorkspace();
      if (rootDir == null) {
        LOGGER.log(Level.SEVERE, "Cannot write the result file because slave is not connected.");
        listener.error("Cannot write the result file because slave is not connected.");
      }
      
      rootDir = createResultDir(rootDir, build.number);
      for (ExecutionHandle executionHandle : execHandles) {
        // TODO: use ThreadPool
        ResultCollectorThread resultCollector = new ResultCollectorThread(listener.getLogger(), execService, sessionId,
            executionHandle, new StdXMLResultWriter(rootDir, DESCRIPTOR.getServiceURL()));
        resultCollector.start();
        resultCollector.join(); // maybe it is better to work with a timeout here
      }
      return true;
    } catch (ServiceException e) {
      LOGGER.log(Level.SEVERE, MessageFormat.format("The URL {0} cannot be accessed or no service is found.", serviceURL));
      listener.error(Messages.getString("SCTMExecutor.err.wrongServiceURL")); //$NON-NLS-1$
      return false;
    } catch (RemoteException e) {
      LOGGER.log(Level.SEVERE, e.getMessage());
      listener.error(Messages.getString("SCTMExecutor.err.sctm", e.getMessage())); //$NON-NLS-1$
      return false;
    } catch (EncryptionException e){
      listener.error(Messages.getString("SCTMExecutor.err.pwdCryptFailed")); //$NON-NLS-1$
      return false;
    } catch (Exception e) {
      Hudson.getInstance().servletContext.log("Hudson SCTMExecutor-Plugin throws unknown error:", e);
      listener.error(e.getLocalizedMessage());
      return false;
    }
  }
  
  public void doCheckExecDefIds(StaplerRequest req, StaplerResponse rsp) throws IOException, ServletException {
    new FormFieldValidator(req, rsp, false) {
      @Override
      protected void check() throws IOException, ServletException {
        System.out.println("checked");
      }
    }.process();
  }
  
  public void doCheckProjectId(StaplerRequest req, StaplerResponse rsp) throws IOException, ServletException {
    new FormFieldValidator(req, rsp, false) {
      @Override
      protected void check() throws IOException, ServletException {
        try {
          Integer.parseInt(request.getParameter("value"));
        } catch (NumberFormatException e) {
          error("Entered value is not a number.");
        }
      }
    }.process();
  }

  private static FilePath createResultDir(FilePath rootDir, int currentBuildNo) throws IOException, InterruptedException {
    rootDir = new FilePath(rootDir, "SCTMResults");
    if (resultNoForLastBuild  != currentBuildNo) {
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
