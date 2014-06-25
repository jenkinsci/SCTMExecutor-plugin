package hudson.plugins.sctmexecutor.validators;

import hudson.util.FormValidation;

public class NumberListSingleFieldValidator {
        
  protected boolean validate(String value) {
    return value.matches("((\\d+ *[ ,] *)*(\\d+))?"); //$NON-NLS-1$
  }
  
  public FormValidation check(String value) {
    return validate(value) ? FormValidation.ok() : FormValidation.error(Messages.getString("NumberListSingleFieldValidator.msg.invalidProperty")); //$NON-NLS-1$
  }
}
