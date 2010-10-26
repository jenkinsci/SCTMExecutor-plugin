package hudson.plugins.sctmexecutor.publisher.model;


public class SCTMTestResult {
  public static enum TestState {
    FAILED("failed"),
    SKIPPED("skipped"),
    PASSED("passed"),
    NOTESTS("no tests found");
    
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
  
  private TestState state = TestState.NOTESTS;
  private int failedCount;
  private int skippedCount;
  private int passedCount;
  private float duration;
  private String errorMessage;
  
  public SCTMTestResult(TestState state, float duration, String errormsg) {
    super();
    this.state = state;
    this.duration = duration;
    this.errorMessage = errormsg;
    
    switch (state) {
      case PASSED:
        passedCount = 1;
        break;
      case SKIPPED:
        skippedCount = 1;
        break;
      case FAILED:
        failedCount = 1;
    }
  }

  public SCTMTestResult(SCTMTestResult value) {
    this.failedCount = value.getFailedCount();
    this.skippedCount = value.getSkippedCount();
    this.passedCount = value.getPassedCount();
    this.duration = value.getDuration();
    this.errorMessage = value.getErrorMessage();
    
    calculateState();
  }

  private void calculateState() {
    if (this.failedCount > 0)
      state = TestState.FAILED;
    else if (this.passedCount > 0)
      state = TestState.PASSED;
    else if (this.skippedCount > 0)
      state = TestState.SKIPPED;
    else
      state = TestState.NOTESTS;
  }
  
  void addSubTestCounts(int passed, int skipped, int failed) {
    this.passedCount += passed;
    this.skippedCount += skipped;
    this.failedCount += failed;
    calculateState();
  }

  void addSubDuration(float duration) {
    this.duration += duration;
  }
  
  @Override
  public String toString() {
    return String.format("%s in %fms", this.state, this.duration);
  }

  public int getFailedCount() {
    return failedCount;
  }
  
  public int getSkippedCount() {
    return skippedCount;
  }
  
  public int getPassedCount() {
    return passedCount;
  }

  public TestState getState() {
    return state;
  }

  public float getDuration() {
    return duration;
  }

  public String getErrorMessage() {
    return errorMessage;
  }
}
