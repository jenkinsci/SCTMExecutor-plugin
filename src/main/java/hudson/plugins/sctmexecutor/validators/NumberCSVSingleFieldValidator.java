package hudson.plugins.sctmexecutor.validators;

public class NumberCSVSingleFieldValidator extends EmptySingleFieldValidator {
  @Override
  protected boolean validate(String value) {
    return super.validate(value) && value.matches("(\\d+,{1})*(\\d+){1}"); //$NON-NLS-1$
  }
}
