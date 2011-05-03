package hudson.plugins.sctmexecutor.publisher;

import hudson.Util;

import org.apache.commons.lang.mutable.MutableDouble;

public class SCTMTestResult {
  public static enum TestState {
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

  private static final int MIN_BAR_WIDTH = 5;

  private TestState state = TestState.NOTESTS;
  private int failCount;
  private int skipCount;
  private int passCount;
  private float duration;
  private final String errorMessage;
  private transient int passWidth;
  private transient int skipWidth;
  private transient int failWidth;

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

  public void calculateBar() {
    MutableDouble failWidth = calculateWidth(this.failCount);
    MutableDouble skipWidth = calculateWidth(this.skipCount);
    MutableDouble passWidth = calculateWidth(this.passCount);

    modifyWidthUsingMinWidth(failWidth, skipWidth, passWidth);
    modifyWidthUsingMinWidth(skipWidth, failWidth, passWidth);
    modifyWidthUsingMinWidth(passWidth, failWidth, skipWidth);

    this.failWidth = failWidth.intValue();
    this.skipWidth = skipWidth.intValue();
    this.passWidth = passWidth.intValue();
  }

  private void modifyWidthUsingMinWidth(MutableDouble toModify, MutableDouble value2, MutableDouble value3) {
    if (toModify.doubleValue() > 0 && toModify.doubleValue() < MIN_BAR_WIDTH) {
      double diffWidth = MIN_BAR_WIDTH - toModify.doubleValue();
      if (value2.doubleValue() < value3.doubleValue())
        value3.subtract(diffWidth);
      else
        value2.subtract(diffWidth);
      toModify.setValue(MIN_BAR_WIDTH);
    }
  }

  private MutableDouble calculateWidth(int testCount) {
    if (getTotalCount() <= 0)
      return new MutableDouble(0);
    double value = testCount * 100 / (double) getTotalCount();
    return new MutableDouble(value);
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
    return failCount + skipCount + passCount;
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

  public synchronized int getFailWidth() {
    return failWidth;
  }

  public synchronized int getSkipWidth() {
    return skipWidth;
  }

  public synchronized int getPassWidth() {
    return passWidth;
  }

  public TestState getState() {
    return state;
  }

  public synchronized float getDuration() {
    return duration;
  }

  public String getDurationString() {
    return Util.getTimeSpanString((long) duration);
  }

  public String getErrorMessage() {
    return errorMessage;
  }

}
