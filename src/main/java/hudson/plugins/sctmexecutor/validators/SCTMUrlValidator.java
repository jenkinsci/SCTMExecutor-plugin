package hudson.plugins.sctmexecutor.validators;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;

import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

import hudson.plugins.sctmexecutor.Messages;
import hudson.util.FormFieldValidator.URLCheck;

public class SCTMUrlValidator extends URLCheck {

  private String url;

  public SCTMUrlValidator(StaplerRequest req, StaplerResponse rsp, String url) {
    super(req, rsp);
    this.url = url;
  }

  @Override
  protected void check() throws IOException, ServletException {
    if (url == null ||
        (url != null && !url.matches("http(s)?://(((\\d{1,3}.){3}\\d{1,3})?|([\\p{Alnum}-_.])*)(:\\d{0,5})?(/([\\p{Alnum}-_.])*)?/services"))) { //$NON-NLS-1$
      error(Messages.getString("SCTMUrlValidator.msg.noValidURL")); //$NON-NLS-1$
      return;
    }
    try {
      findText(open(new  URL(this.url)), "tmexecution");      
    } catch (IOException e) {
      handleIOException(this.url, e);
    }
  }
}
