package hudson.plugins.sctmexecutor.publisher;

import hudson.Util;

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
  private int failCount;
  private int skipCount;
  private int passCount;
  private float duration;
  private String errorMessage;
  
  public SCTMTestResult(TestState state, float duration, String errormsg) {
    super();
    this.state = state;
    this.duration = duration;
    this.errorMessage = errormsg;
    
    switch (state) {
      case PASSED:
        passCount = 1;
        break;
      case SKIPPED:
        skipCount = 1;
        break;
      case FAILED:
        failCount = 1;
    }
  }

  public SCTMTestResult(SCTMTestResult value) {
    this.failCount = value.getFailCount();
    this.skipCount = value.getSkipCount();
    this.passCount = value.getPassCount();
    this.duration = value.getDuration();
    this.errorMessage = value.getErrorMessage();
    
    calculateState();
  }

  private void calculateState() {
    if (this.failCount > 0)
      state = TestState.FAILED;
    else if (this.passCount > 0)
      state = TestState.PASSED;
    else if (this.skipCount > 0)
      state = TestState.SKIPPED;
    else
      state = TestState.NOTESTS;
  }
  
  synchronized void addSubTestCounts(int passed, int skipped, int failed) {
    this.passCount += passed;
    this.skipCount += skipped;
    this.failCount += failed;
    calculateState();
  }

  synchronized void addSubDuration(float duration) {
    this.duration += duration;
  }
  
  @Override
  public String toString() {
    return String.format("%s in %fms", this.state, this.duration);
  }

  public int getTotalCount() {
    return failCount+skipCount+passCount;
  }

  public synchronized int getFailCount() {
    return failCount;
  }
  
  public synchronized int getSkipCount() {
    return skipCount;
  }
  
  public synchronized int getPassCount() {
    return passCount;
  }

  public TestState getState() {
    return state;
  }

  public synchronized float getDuration() {
    return duration;
  }
  
  public String getDurationString() {
    return Util.getTimeSpanString((long)duration);
  }

  public String getErrorMessage() {
    return errorMessage;
  }

}
