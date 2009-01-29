package hudson.plugins.sctmexecutor.validators;

import hudson.plugins.sctmexecutor.Messages;

public class NumberCSVSingleFieldValidator extends EmptySingleFieldValidator {

  public NumberCSVSingleFieldValidator(String value) {
    super(value, Messages.getString("NumberCSVSingleFieldValidator.msg.notANumberOrCSV")); //$NON-NLS-1$
  }
  
  @Override
  protected boolean validate() {
    return getValue().matches("(\\d+,{1})*(\\d+){1}"); //$NON-NLS-1$
  }

}
