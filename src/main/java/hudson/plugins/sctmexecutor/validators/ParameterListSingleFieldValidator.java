package hudson.plugins.sctmexecutor.validators;

import hudson.util.FormValidation;

public class ParameterListSingleFieldValidator {
  
  public boolean validate(final String value) {
    return value.matches("((\\w+ *=[^\t\n\r\f\\v]*\n *)*(\\w+ *=[^\t\n\r\f\\v]*))?");
  }
  
  public FormValidation check(String value) {
    return validate(value) ? FormValidation.ok() : FormValidation.error(Messages.getString("ParameterListSingleFieldValidator.msg.invalidProperty")); //$NON-NLS-1$
  }

}
