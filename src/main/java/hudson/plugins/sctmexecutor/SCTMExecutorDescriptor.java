package hudson.plugins.sctmexecutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.logging.Logger;

import javax.servlet.ServletException;

import org.jenkinsci.Symbol;
import org.kohsuke.stapler.QueryParameter;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.model.FreeStyleProject;
import hudson.plugins.sctmexecutor.validators.EmptySingleFieldValidator;
import hudson.plugins.sctmexecutor.validators.NumberCSVSingleFieldValidator;
import hudson.plugins.sctmexecutor.validators.TestConnectionValidator;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Builder;
import hudson.util.FormValidation;
import hudson.util.Secret;
import jenkins.model.Jenkins;
import net.sf.json.JSONObject;

/**
 * 
 * @author Thomas Fuerer
 * 
 */
@Symbol("silkcentral")
@Extension
public final class SCTMExecutorDescriptor extends BuildStepDescriptor<Builder> {
  @SuppressWarnings("unused")
  private static final Logger LOGGER = Logger.getLogger("hudson.plugins.sctmexecutor"); //$NON-NLS-1$
  private String serviceURL;
  private String user;
  private Secret password;

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

    SCTMExecutor sctmExecutor = new SCTMExecutor(formData.getInt("projectId"), formData.getString("execDefIds"));
    sctmExecutor.setDelay(getOptionalIntValue(formData.getString("delay"), 0));
    sctmExecutor.setContOnErr(formData.getBoolean("continueOnError"));
    sctmExecutor.setCollectResults(formData.getBoolean("collectResults"));
    sctmExecutor.setIgnoreSetupCleanup(formData.getBoolean("ignoreSetupCleanup"));
    
    // optValue, jobName
    JSONObject useSpecificInstanceForm = (JSONObject) formData.get("useSpecificInstance"); //$NON-NLS-1$
    if (useSpecificInstanceForm != null) {
      sctmExecutor.setUseSpecificInstance(true);
      sctmExecutor.setSpecificServiceURL(useSpecificInstanceForm.getString("specificServiceURL"));
      sctmExecutor.setSpecificUser(useSpecificInstanceForm.getString("specificUser"));
      sctmExecutor.setSpecificPassword(useSpecificInstanceForm.getString("specificPassword"));
    }
    
    JSONObject buildNumberUsageJson = (JSONObject) formData.get("buildNumberUsageOption"); //$NON-NLS-1$
    int buildNumberUsageOption;
    if (buildNumberUsageJson == null) {
      buildNumberUsageOption = SCTMExecutor.OPT_NO_BUILD_NUMBER;
    }
    else {
      buildNumberUsageOption = buildNumberUsageJson.getInt("value");//$NON-NLS-1$
      if (buildNumberUsageOption == SCTMExecutor.OPT_USE_SPECIFICJOB_BUILDNUMBER) {
        sctmExecutor.setJobName(buildNumberUsageJson.getString("jobName"));
      }
    }
    sctmExecutor.setBuildNumberUsageOption(buildNumberUsageOption);

    return sctmExecutor;
  }

  private int getOptionalIntValue(String value, int defaultValue) {
    try {
      return Integer.parseInt(value);
    } catch (NumberFormatException e) {
      return defaultValue;
    }
  }

  @Override
  public boolean configure(StaplerRequest req, JSONObject formData) throws hudson.model.Descriptor.FormException {
    serviceURL = formData.getString("serviceURL"); //$NON-NLS-1$
    user = formData.getString("user"); //$NON-NLS-1$
    password = Secret.fromString(formData.getString("password")); //$NON-NLS-1$
    save();
    return super.configure(req, formData);
  }

  public String getServiceURL() {
    return serviceURL;
  }

  public String getUser() {
    return user;
  }

  public String getPassword() {
    return Secret.toString(password);
  }

  public FormValidation doCheckServiceURL(StaplerRequest req, StaplerResponse rsp, @QueryParameter("value") final String value) throws IOException, ServletException {
    return checkUrl(value);
  }

  public FormValidation doCheckSpecificServiceURL(StaplerRequest req, StaplerResponse rsp, @QueryParameter("value") final String value) throws IOException, ServletException {
    return checkUrl(value);
  }

  private FormValidation checkUrl(final String urlString) throws IOException, ServletException {
    return new FormValidation.URLCheck() {
      @Override
      protected FormValidation check() throws IOException, ServletException {
        if (urlString == null
            ||  !urlString.matches("http(s)?://(((\\d{1,3}.){3}\\d{1,3})?|([\\p{Alnum}-_.])*)(:\\d{0,5})?(/([\\p{Alnum}-_.])*)?/services")) { //$NON-NLS-1$
          return FormValidation.error(Messages.getString("SCTMExecutorDescriptor.validate.msg.noValidURL")); //$NON-NLS-1$
        }
        try {
          URL url = new URL(urlString);
          BufferedReader reader = open(url);
          if (findText(reader, "tmexecution")) {
            return FormValidation.ok();
          }
          else {
            return FormValidation.warning(Messages.getString("SCTMExecutorDescriptor.validate.msg.noServiceFound")); //$NON-NLS-1$
          }
        } catch (IOException e) {
          return handleIOException(urlString, e);
        } catch (IllegalArgumentException e) {
          return FormValidation.error(Messages.getString("SCTMExecutorDescriptor.validate.msg.noValidURL")); //$NON-NLS-1$
        }
      }
    }.check();
  }

  public Collection<String> getAllJobs() {
    return Jenkins.getInstance().getJobNames();
  }

  public Collection<String> getAllVersions(String execdefIds) {
    return Collections.emptyList();
  }

  public FormValidation doCheckUser(StaplerRequest req, StaplerResponse rsp, @QueryParameter("value") final String value) {
    return new EmptySingleFieldValidator().check(value);
  }

  public FormValidation doCheckPassword(StaplerRequest req, StaplerResponse rsp,
      @QueryParameter("value") final String value) {
    return new EmptySingleFieldValidator().check(value);
  }
  
  public FormValidation doCheckSpecificUser(StaplerRequest req, StaplerResponse rsp, @QueryParameter("value") final String value) {
    return new EmptySingleFieldValidator().check(value);
  }
  
  public FormValidation doCheckSpecificPassword(StaplerRequest req, StaplerResponse rsp,
      @QueryParameter("value") final String value) {
    return new EmptySingleFieldValidator().check(value);
  }

  public FormValidation doCheckExecDefIds(StaplerRequest req, StaplerResponse rsp,
      @QueryParameter("value") final String value) {
    return new NumberCSVSingleFieldValidator().check(value);
  }

  public FormValidation doCheckProjectId(StaplerRequest req, StaplerResponse rsp,
      @QueryParameter("value") final String value) {
    return FormValidation.validateNonNegativeInteger(value);
  }

  public FormValidation doCheckDelay(StaplerRequest rep, StaplerResponse rsp,
      @QueryParameter("value") final String value) {
    return FormValidation.validateNonNegativeInteger(value);
  }

  public FormValidation doTestConnection(StaplerRequest req, StaplerResponse rsp,
      @QueryParameter("serviceURL") final String serviceURL, @QueryParameter("user") final String user,
      @QueryParameter("password") final String password) {
    return new TestConnectionValidator().check(serviceURL, user, password);
  }
  
  public FormValidation doTestSpecificConnection(StaplerRequest req, StaplerResponse rsp,
      @QueryParameter("specificServiceURL") final String serviceURL, @QueryParameter("specificUser") final String user,
      @QueryParameter("specificPassword") final String password) {
    return new TestConnectionValidator().check(serviceURL, user, password);
  }

  @SuppressWarnings("rawtypes")
  @Override
  public boolean isApplicable(Class<? extends AbstractProject> jobType) {
    return FreeStyleProject.class.equals(jobType);
  }
}