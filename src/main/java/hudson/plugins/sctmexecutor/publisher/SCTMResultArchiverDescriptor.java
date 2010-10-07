package hudson.plugins.sctmexecutor.publisher;

import net.sf.json.JSONObject;

import org.kohsuke.stapler.StaplerRequest;

import hudson.Extension;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Publisher;

@Extension
public final class SCTMResultArchiverDescriptor extends BuildStepDescriptor<Publisher> {

  public SCTMResultArchiverDescriptor() {
    super(SCTMResultArchiver.class);
    load();
  }
  
  @Override
  public boolean isApplicable(Class jobType) {
    return true;
  }

  @Override
  public String getDisplayName() {
    return "Collect SilkCentral Testmanager Test Results";
  }
  
  @Override
  public Publisher newInstance(StaplerRequest req, JSONObject formData) throws hudson.model.Descriptor.FormException {
    return new SCTMResultArchiver();
  }

}
