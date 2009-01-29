package hudson.plugins.sctmexecutor.validators;

public class NumberCSVSingleFieldValidator extends EmptySingleFieldValidator {

  public NumberCSVSingleFieldValidator(String value) {
    super(value, "Not a number or a comma separated sequence of numbers.");
  }
  
  @Override
  protected boolean validate() {
    return getValue().matches("(\\d+,{1})*(\\d+){1}");
  }

}
