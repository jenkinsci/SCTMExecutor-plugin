package hudson.plugins.sctmexecutor;

import hudson.model.Descriptor;
import hudson.model.Hudson;
import hudson.tasks.Builder;
import hudson.util.FormFieldValidator;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.xml.rpc.ServiceException;

import net.sf.json.JSONObject;

import org.kohsuke.stapler.QueryParameter;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

import com.borland.scc.sccsystem.SystemService;
import com.borland.scc.sccsystem.SystemServiceServiceLocator;

/**
 * 
 * @author Thomas Fuerer
 *
 */
public final class SCTMExecutorDescriptor extends Descriptor<Builder> {
  private String serviceURL;
  private String user;
  private String password;

  SCTMExecutorDescriptor() {
    super(SCTMExecutor.class);
    load();
  }

  @Override
  public String getDisplayName() {
    return ""; //$NON-NLS-1$
  }

  @Override
  public Builder newInstance(StaplerRequest req, JSONObject formData) throws FormException {
    String execDefIds = formData.getString("execDefId"); //$NON-NLS-1$
    String str = formData.getString("projectId"); //$NON-NLS-1$
    int projectId = Integer.parseInt(str);
    return new SCTMExecutor(projectId, execDefIds);
  }
  
  @Override
  public boolean configure(StaplerRequest req, JSONObject json) throws hudson.model.Descriptor.FormException {
    serviceURL = json.getString("serviceURL"); //$NON-NLS-1$
    user = json.getString("user"); //$NON-NLS-1$
    password = PwdCrypt.encode(json.getString("password"), Hudson.getInstance().getSecretKey()); //$NON-NLS-1$
    
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
    return PwdCrypt.decode(password, Hudson.getInstance().getSecretKey());
  }

  public void setUser(String user) {
    this.user = user;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  
  public void doTestConnection(StaplerRequest req, StaplerResponse rsp, @QueryParameter("serviceURL") final String serviceURL, @QueryParameter("user") final String user) throws IOException, ServletException {
    System.out.println("test connection"); //$NON-NLS-1$
    //    new FormFieldValidator(req, rsp, true) {
//      @Override
//      protected void check() throws IOException, ServletException {
//        try {
//          SystemService systemService = new SystemServiceServiceLocator().getsccsystem(new URL(serviceURL + "/sccsystem?wsdl"));
//          systemService.logonUser(user, password);
//          ok();
//        } catch (ServiceException e) {
//          error("Cannot connect to Borlands SilkCentral Test Manager. Please review the entered settings.");
//        }
//      }
//    }.process();
  }
  
  public void doCheckProjectId(StaplerRequest req, StaplerResponse rsp) {
    System.out.println("checked"); //$NON-NLS-1$
  }
}