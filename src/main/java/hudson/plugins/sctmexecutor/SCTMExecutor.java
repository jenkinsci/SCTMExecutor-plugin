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
  static final class SCTMExecutorDescriptor extends Descriptor<Builder> {   
    private String serviceURL;
    private String user;
    private String password;
    
    SCTMExecutorDescriptor() {
      super(SCTMExecutor.class);
    }

    @Override
    public String getDisplayName() {
      return Messages.getString("SCTMExecutorDescriptor.plugin.title"); //$NON-NLS-1$
    }

    @Override
    public Builder newInstance(StaplerRequest req, JSONObject formData) throws FormException {
      String execDefIds = req.getParameter("sctmexecutor.execDefId"); //$NON-NLS-1$
      String str = req.getParameter("sctmexecutor.projectId"); //$NON-NLS-1$
      int projectId = Integer.parseInt(str);
      try {
        return new SCTMExecutor(projectId, execDefIds);
      } catch (Exception e) {
        throw new FormException(e, Messages.getString("SCTMExecutorDescriptor.err.service.connectionfailed")); //$NON-NLS-1$
      }
    }
    
    @Override
    public boolean configure(StaplerRequest req, JSONObject json) throws hudson.model.Descriptor.FormException {
      serviceURL = req.getParameter("sctmexecutor.serviceURL"); //$NON-NLS-1$
      user = req.getParameter("sctmexecutor.user"); //$NON-NLS-1$
//      try {
        password = req.getParameter("sctmexecutor.password"); //new PwdCrypt(Hudson.getInstance().getSecretKey()).encrypt(req.getParameter("sctmexecutor.password"));
//      } catch (UnsupportedEncodingException e) {
//        throw new RuntimeException(e);
//      }
      
      save();
      return super.configure(req, json);
    }

    public void setServiceURL(String serviceURL) {
      this.serviceURL = serviceURL;
    }

    public String getServiceURL() {
      return serviceURL;
    }
    
    public String getUser() {
      return user;
    }

    public String getPassword() {
      return password;
    }
  }
  
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

      String cryptedPwd = DESCRIPTOR.getPassword(); // new PwdCrypt(Hudson.getInstance().getSecretKey()).decrypt(DESCRIPTOR.getPassword());
      long sessionId = systemService.logonUser(DESCRIPTOR.getUser(), cryptedPwd);
      execService.setCurrentProject(sessionId, projectId);
      List<ExecutionHandle> execHandles = new ArrayList<ExecutionHandle>();
      for (Integer execDefId : csvToList(execDefIds)) {
        ExecutionHandle[] execHandleArr = execService.startExecution(sessionId, execDefId);
        if (execHandleArr.length <= 0 ||
            execHandleArr[0] == null ||
            (execHandleArr[0] != null && execHandleArr[0].getTimeStamp() <= 0)) {
          listener.error(Messages.getString("SCTMExecutor.err.execDefNotFound", execDefId));
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
      throw new InterruptedException(e.getLocalizedMessage());
    }
  }

  private List<Integer> csvToList(String execDefIds) {
    List<Integer> list = new LinkedList<Integer>();
    if (execDefIds.contains(",")) {
      String[] ids = execDefIds.split(",");
      for (String str : ids) {
        list.add(Integer.valueOf(str));
      }
    } else {
      list.add(Integer.valueOf(execDefIds));
    }
    return list;
  }
}
