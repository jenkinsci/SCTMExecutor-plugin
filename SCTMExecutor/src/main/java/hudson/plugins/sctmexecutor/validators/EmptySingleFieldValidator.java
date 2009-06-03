package hudson.plugins.sctmexecutor.validators;

import hudson.plugins.sctmexecutor.Messages;
import hudson.util.FormValidation;

public class EmptySingleFieldValidator {
  /**
   * Override this method when you inherit a new class and specify the rule to validate
   * @return
   */
  protected boolean validate(String value) {
    return value != null && !value.equals(""); //$NON-NLS-1$
  }
  
  public FormValidation check(String value) {
    return validate(value) ? FormValidation.ok() : FormValidation.error(Messages.getString("EmptySingleFieldValidator.msg.emptyProperty"));
  }
}
