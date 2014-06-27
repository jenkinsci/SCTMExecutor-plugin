package hudson.plugins.sctmexecutor;

import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.model.FreeStyleProject;
import hudson.model.Hudson;
import hudson.plugins.sctmexecutor.validators.NumberListSingleFieldValidator;
import hudson.plugins.sctmexecutor.validators.ParameterListSingleFieldValidator;
import hudson.plugins.sctmexecutor.validators.TestConnectionValidator;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Builder;
import hudson.util.FormValidation;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.logging.Logger;

import javax.servlet.ServletException;

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
  @SuppressWarnings("unused")
  private static final Logger LOGGER = Logger.getLogger("hudson.plugins.sctmexecutor"); //$NON-NLS-1$
  private String serviceURL;
  private String user;
  private String password;

  // private transients ISCTMService service;

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
    int projectId = formData.optInt("projectId"); //$NON-NLS-1$
    String execDefIds = formData.getString("execDefIds"); //$NON-NLS-1$
    String params = formData.getString("params");    
    int delay = formData.optInt("delay"); //$NON-NLS-1$        
    boolean contOnErr = formData.getBoolean("continueOnError"); //$NON-NLS-1$
    boolean collectResults = formData.getBoolean("collectResults"); //$NON-NLS-1$
    boolean ignoreSetupCleanup = formData.getBoolean("ignoreSetupCleanup"); //$NON-NLS-1$
    String jobName = ""; //$NON-NLS-1$
    JSONObject buildNumberUsageOption = formData.optJSONObject("buildNumberUsageOption"); //$NON-NLS-1$
    int optValue;
    if (buildNumberUsageOption == null)
      optValue = SCTMExecutor.OPT_NO_BUILD_NUMBER;
    else
      optValue = buildNumberUsageOption.getInt("value");//$NON-NLS-1$

    if (optValue == SCTMExecutor.OPT_USE_SPECIFICJOB_BUILDNUMBER) {
      jobName = buildNumberUsageOption.getString("jobName"); //$NON-NLS-1$    
    }

    return new SCTMExecutor(projectId, execDefIds, delay, params, optValue, jobName, contOnErr, collectResults, ignoreSetupCleanup);
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
    if (password != null && !password.equals("")) //$NON-NLS-1$
      return PwdCrypt.decode(password, Hudson.getInstance().getSecretKey());
    else
      return ""; //$NON-NLS-1$
  }

  public void setUser(String user) {
    this.user = user;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public FormValidation doCheckServiceURL(StaplerRequest req, StaplerResponse rsp,
      @QueryParameter("value") final String value) throws IOException, ServletException {

    return new FormValidation.URLCheck() {
      @Override
      protected FormValidation check() throws IOException, ServletException {
        if (value == null
            || (value != null && !value
                .matches("http(s)?://(((\\d{1,3}.){3}\\d{1,3})?|([\\p{Alnum}-_.])*)(:\\d{0,5})?(/([\\p{Alnum}-_.])*)?/services"))) { //$NON-NLS-1$
          return FormValidation.error(Messages.getString("SCTMExecutorDescriptor.validate.msg.noValidURL")); //$NON-NLS-1$
        }
        try {
          URL url = new URL(value);
          BufferedReader reader = open(url);
          if (findText(reader, "tmexecution")) //$NON-NLS-1$
            return FormValidation.ok();
          else
            return FormValidation.warning(Messages.getString("SCTMExecutorDescriptor.validate.msg.noServiceFound")); //$NON-NLS-1$
        } catch (IOException e) {
          return handleIOException(value, e);
        } catch (IllegalArgumentException e) {
          return FormValidation.error(Messages.getString("SCTMExecutorDescriptor.validate.msg.noValidURL")); //$NON-NLS-1$
        }
      }
    }.check();
  }

  public Collection<String> getAllJobs() {
    return Hudson.getInstance().getJobNames();
  }

  public Collection<String> getAllVersions(String execdefIds) {
    // try {
    // int execDefId = Utils.csvToIntList(execdefIds).get(0);
    // return this.service.getAllVersions(execDefId);
    // } catch (SCTMException e) {
    // LOGGER.warning("No versions available for product.");
    // }
    return Collections.emptyList();
  }

  public FormValidation doCheckUser(@QueryParameter final String value) {
    return FormValidation.validateRequired(value);
  }

  public FormValidation doCheckPassword(@QueryParameter final String value) {
    return FormValidation.validateRequired(value);
  }

  public FormValidation doCheckExecDefIds(@QueryParameter final String value) {
    FormValidation requiredness = FormValidation.validateRequired(value);
    if (requiredness.kind != FormValidation.Kind.OK) {
      return requiredness;
    }
    return new NumberListSingleFieldValidator().check(value);
  }

  public FormValidation doCheckProjectId(@QueryParameter final String value) {
    FormValidation requiredness = FormValidation.validateRequired(value);
    if (requiredness.kind != FormValidation.Kind.OK) {
      return requiredness;
    }
    return FormValidation.validateNonNegativeInteger(value);
  }
  
  public FormValidation doCheckParams(@QueryParameter final String value) {
    return new ParameterListSingleFieldValidator().check(value);
  }

  public FormValidation doCheckDelay(@QueryParameter final String value) {
    return FormValidation.validateNonNegativeInteger(value);
  }

  public FormValidation doTestConnection(StaplerRequest req, StaplerResponse rsp,
      @QueryParameter("serviceURL") final String serviceURL, @QueryParameter("user") final String user,
      @QueryParameter("password") final String password) {
    return new TestConnectionValidator().check(serviceURL, user, password);
  }  

  @SuppressWarnings("rawtypes")
  @Override
  public boolean isApplicable(Class<? extends AbstractProject> jobType) {
    return (FreeStyleProject.class.equals(jobType));
  }
}