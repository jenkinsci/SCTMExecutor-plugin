package hudson.plugins.sctmexecutor;

import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.BuildListener;
import hudson.model.Descriptor;
import hudson.model.Hudson;
import hudson.tasks.Builder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.xml.rpc.ServiceException;

import net.sf.json.JSONObject;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

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
      systemService = new SystemServiceServiceLocator().getsccsystem(new URL(serviceURL+"/sccsystem?wsdl")); //$NON-NLS-1$
      execService = new ExecutionWebServiceServiceLocator().gettmexecution(new URL(serviceURL+"/tmexecution?wsdl")); //$NON-NLS-1$

      String deCryptedPwd = PwdCrypt.decode(DESCRIPTOR.getPassword(), Hudson.getInstance().getSecretKey());
      long sessionId = systemService.logonUser(DESCRIPTOR.getUser(), deCryptedPwd);
      listener.getLogger().println(Messages.getString("SCTMExecutor.log.successfulLogin")); //$NON-NLS-1$
      execService.setCurrentProject(sessionId, projectId);
      List<ExecutionHandle> execHandles = new ArrayList<ExecutionHandle>();
      for (Integer execDefId : csvToList(execDefIds)) {
        ExecutionHandle[] execHandleArr = execService.startExecution(sessionId, execDefId);
        listener.getLogger().println(Messages.getString("SCTMExecutor.log.successfulStartExecution", execDefId)); //$NON-NLS-1$
        if (execHandleArr.length <= 0 ||
            execHandleArr[0] == null ||
            (execHandleArr[0] != null && execHandleArr[0].getTimeStamp() <= 0)) {
          listener.error(Messages.getString("SCTMExecutor.err.execDefNotFound", execDefId)); //$NON-NLS-1$
          return false;
        } else {
          for (ExecutionHandle executionHandle : execHandleArr) {
            execHandles.add(executionHandle);            
          }
        }
      }
      return true;
    } catch (ServiceException e) {
      listener.error(Messages.getString("SCTMExecutor.err.wrongServiceURL")); //$NON-NLS-1$
      return false;
    } catch (RemoteException e) {
      listener.error(Messages.getString("SCTMExecutor.err.sctm", e.getMessage())); //$NON-NLS-1$
      return false;
    } catch (Exception e) {
      listener.error(Messages.getString("SCTMExecutor.err.pwdCryptFailed")); //$NON-NLS-1$
      return false;
    }
  }

  private List<Integer> csvToList(String execDefIds) {
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
