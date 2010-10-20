package hudson.plugins.sctmexecutor.publisher;

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
  
  private int failedCount;
  private int skippedCount;

  private int passedCount;
  private TestState state;
  
  SCTMTestResult(TestState state) {
    this.state = state;
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
  
  SCTMTestResult(int failCount, int skipCount, int passCount) {
    super();
    this.failedCount = failCount;
    this.skippedCount = skipCount;
    this.passedCount = passCount;
    
    calculateState();
  }

  public SCTMTestResult(SCTMTestResult value) {
    this(value.getFailedCount(), value.getSkippedCount(), value.getPassedCount());
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
}
