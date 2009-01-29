package hudson.plugins.sctmexecutor.validators;

import hudson.plugins.sctmexecutor.Messages;

public class NumberSingleFieldValidator extends EmptySingleFieldValidator {

  public NumberSingleFieldValidator(String value) {
    super(value, Messages.getString("NumberSingleFieldValidator.msg.notANumber")); //$NON-NLS-1$
  }
  
  @Override
  protected boolean validate() {
    return getValue().matches("\\d+"); //$NON-NLS-1$
  }

}
