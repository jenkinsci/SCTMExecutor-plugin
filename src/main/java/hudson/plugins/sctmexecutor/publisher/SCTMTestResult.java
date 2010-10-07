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
  
  public SCTMTestResult(int failCount, int skipCount, int passCount) {
    super();
    this.failedCount = failCount;
    this.skippedCount = skipCount;
    this.passedCount = passCount;
    
    if (failCount > 0)
      state = TestState.FAILED;
    else if (passCount > 0)
      state = TestState.PASSED;
    else if (skipCount > 0)
      state = TestState.SKIPPED;
    else
      state = TestState.NOTESTS;
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
