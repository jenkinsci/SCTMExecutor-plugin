package hudson.plugins.sctmexecutor.validators;

public class NumberSingleFieldValidator extends EmptySingleFieldValidator {

  public NumberSingleFieldValidator(String value) {
    super(value, "Not a Number.");
  }
  
  @Override
  protected boolean validate() {
    return getValue().matches("\\d+");
  }

}
