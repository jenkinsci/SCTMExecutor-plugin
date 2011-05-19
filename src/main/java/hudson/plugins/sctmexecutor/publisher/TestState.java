package hudson.plugins.sctmexecutor.publisher;

public enum TestState {
  FAILED("failed"), SKIPPED("skipped"), PASSED("passed"), NOTESTS("no tests found");

  private String state;

  private TestState(String state) {
    this.state = state;
  }

  @Override
  public String toString() {
    return state;
  }

  public String getMessage() {
    return state;
  }
}
