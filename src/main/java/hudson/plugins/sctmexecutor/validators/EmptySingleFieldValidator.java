package hudson.plugins.sctmexecutor.validators;

import hudson.plugins.sctmexecutor.Messages;
import hudson.util.FormFieldValidator;

import java.io.IOException;

import javax.servlet.ServletException;

public class EmptySingleFieldValidator extends FormFieldValidator {
  private String value;
  private String errMsg;

  public EmptySingleFieldValidator(String value) {
    this(value, Messages.getString("EmptySingleFieldValidator.msg.emptyProperty")); //$NON-NLS-1$
  }

  public EmptySingleFieldValidator(String value, String errMsg) {
    super(null);
    this.value = value;
    this.errMsg = errMsg;
  }



  @Override
  protected final void check() throws IOException, ServletException {
    if (value != null && !value.equals("") && validate()) //$NON-NLS-1$
      ok();
    else
      error(errMsg);
  }

  /**
   * Override this method when you inherit a new class and specify the rule to validate
   * @return
   */
  protected boolean validate() {
    return true;
  }

  protected String getValue() {
    return value;
  }

}
