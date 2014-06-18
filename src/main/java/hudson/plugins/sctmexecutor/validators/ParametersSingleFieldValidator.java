package hudson.plugins.sctmexecutor.validators;

import hudson.util.FormValidation;

public class ParametersSingleFieldValidator {
  
  public boolean validate(final String value) {
    return value.matches("((\\w+ *= *[A-Za-zÀ-ü0-9_]+( +[A-Za-zÀ-ü0-9_]+)* *[,\n] *)*(\\w+ *= *[A-Za-zÀ-ü0-9_]+( +[A-Za-zÀ-ü0-9_]+)*))?");
  }
  
  public FormValidation check(String value) {
    return validate(value) ? FormValidation.ok() : FormValidation.error(Messages.getString("ParametersSingleFieldValidator.msg.invalidProperty")); //$NON-NLS-1$
  }

}
