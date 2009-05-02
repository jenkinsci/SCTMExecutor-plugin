package hudson.plugins.sctmexecutor;

import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.model.FreeStyleProject;
import hudson.model.Hudson;
import hudson.model.Project;
import hudson.plugins.sctmexecutor.validators.EmptySingleFieldValidator;
import hudson.plugins.sctmexecutor.validators.NumberCSVSingleFieldValidator;
import hudson.plugins.sctmexecutor.validators.TestConnectionValidator;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Builder;
import hudson.util.FormValidation;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.kohsuke.stapler.QueryParameter;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

/**
 * 
 * @author Thomas Fuerer
 * 
 */
@Extension
public final class SCTMExecutorDescriptor extends BuildStepDescriptor<Builder> {
  private String serviceURL;
  private String user;
  private String password;
  private ExecutorService threadPool;

  public SCTMExecutorDescriptor() {
    super(SCTMExecutor.class);
    load();
  }

  @Override
  public String getDisplayName() {
    return Messages.getString("SCTMExecutorDescriptor.plugin.title"); //$NON-NLS-1$
  }

  @Override
  public Builder newInstance(StaplerRequest req, JSONObject formData) throws FormException {
    String execDefIds = formData.getString("execDefIds"); //$NON-NLS-1$
    int projectId = formData.getInt("projectId"); //$NON-NLS-1$
//    JSONObject buildNumberUsageOption = (JSONObject)formData.get("buildNumberUsageOption");
    String upStreamJobName = "";
    int optValue = 1;//buildNumberUsageOption.getInt("value");
//    if (optValue == SCTMExecutor.OPT_USE_UPSTREAMJOB_BUILDNUMBER) {
//      upStreamJobName = buildNumberUsageOption.getString("upStreamJobName");
//    }
    
    return new SCTMExecutor(projectId, execDefIds, optValue, upStreamJobName);
  }

  @Override
  public boolean configure(StaplerRequest req, JSONObject formData) throws hudson.model.Descriptor.FormException {
    serviceURL = formData.getString("serviceURL"); //$NON-NLS-1$
    user = formData.getString("user"); //$NON-NLS-1$
    password = PwdCrypt.encode(formData.getString("password"), Hudson.getInstance().getSecretKey()); //$NON-NLS-1$

    save();
    return super.configure(req, formData);
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
    if (password != null && !password.equals(""))
      return PwdCrypt.decode(password, Hudson.getInstance().getSecretKey());
    else
      return "";
  }

  public void setUser(String user) {
    this.user = user;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public FormValidation doCheckServiceURL(StaplerRequest req, StaplerResponse rsp, 
      @QueryParameter("value") final String value)
      throws IOException, ServletException {
    
    return new FormValidation.URLCheck() {
      @Override
      protected FormValidation check() throws IOException, ServletException {
        if (value == null ||
            (value != null && !value.matches("http(s)?://(((\\d{1,3}.){3}\\d{1,3})?|([\\p{Alnum}-_.])*)(:\\d{0,5})?(/([\\p{Alnum}-_.])*)?/services"))) { //$NON-NLS-1$
          return FormValidation.error(Messages.getString("SCTMUrlValidator.msg.noValidURL")); //$NON-NLS-1$
        }
        try {
          URL url = new URL(value);
          BufferedReader reader = open(url);
          if (findText(reader, "tmexecution"))
            return FormValidation.ok();
          else
            return FormValidation.warning(Messages.getString("SCTMURL.Validator.msg.noServiceFound"));
        } catch (IOException e) {
          return handleIOException(value, e);
        } catch (IllegalArgumentException e) {
          return FormValidation.error(Messages.getString("SCTMUrlValidator.msg.noValidURL")); //$NON-NLS-1$
        }
      }
    }.check();
  }

  public FormValidation doCheckUser(StaplerRequest req, StaplerResponse rsp, 
      @QueryParameter("value") final String value)
      throws IOException, ServletException {
    return new EmptySingleFieldValidator().check(value);
  }

  public FormValidation doCheckPassword(StaplerRequest req, StaplerResponse rsp, 
      @QueryParameter("value") final String value)
      throws IOException, ServletException {
    return new EmptySingleFieldValidator().check(value);
  }

  public FormValidation doCheckExecDefIds(StaplerRequest req, StaplerResponse rsp, 
      @QueryParameter("value") final String value)
      throws IOException, ServletException {
    return new NumberCSVSingleFieldValidator().check(value);
  }

  public FormValidation doCheckProjectId(StaplerRequest req, StaplerResponse rsp, 
      @QueryParameter("value") final String value)
      throws IOException, ServletException {
    return FormValidation.validateNonNegativeInteger(value);
  }

  public FormValidation doTestConnection(StaplerRequest req, StaplerResponse rsp, 
      @QueryParameter("serviceURL") final String serviceURL,
      @QueryParameter("user") final String user,
      @QueryParameter("password") final String password) throws IOException, ServletException {
    return new TestConnectionValidator().check(serviceURL, user, password);
  }

  public ExecutorService getExecutorPool() {
    if (threadPool == null || threadPool.isShutdown() || threadPool.isTerminated())
      threadPool = Executors.newFixedThreadPool(8);
    return threadPool;
  }

  public void shutdown() {
    if (threadPool != null)
      threadPool.shutdown();
  }

  @Override
  public boolean isApplicable(Class<? extends AbstractProject> jobType) {
    return (FreeStyleProject.class.equals(jobType));
  }
}