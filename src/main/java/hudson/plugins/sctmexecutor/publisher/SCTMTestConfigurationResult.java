package hudson.plugins.sctmexecutor.publisher;

import hudson.tasks.test.TestResult;

import org.apache.commons.lang.mutable.MutableDouble;

public final class SCTMTestConfigurationResult extends AbstractSCTMTest {
  private static final int MIN_BAR_WIDTH = 5;

  transient private String configurationName;
  private TestState state;
  private int failCount;
  private int skipCount;
  private int passCount;
  private float duration;

  private final String errorMessage;
  private transient int passWidth;
  private transient int skipWidth;
  private transient int failWidth;

  SCTMTestConfigurationResult(SCTMTestConfigurationResult value) {
    this(value.getConfigurationName(), value.getState(), value.getDuration(), value.getErrorMessage());
    this.duration = value.getDuration();
    this.failCount = value.getFailCount();
    this.skipCount = value.getSkipCount();
    this.passCount = value.getPassCount();
  }

  public SCTMTestConfigurationResult(String configurationName, TestState state, float duration, String errormsg) {
    this.configurationName = configurationName;
    this.state = state;
    this.errorMessage = errormsg;
    this.duration = duration;

    switch (state) {
    case PASSED:
      passCount = 1;
      break;
    case SKIPPED:
      skipCount = 1;
      break;
    case FAILED:
      failCount = 1;
      break;
    }
  }

  public void calculateBar() {
    MutableDouble failWidth = calculateWidth(this.getFailCount());
    MutableDouble skipWidth = calculateWidth(this.getSkipCount());
    MutableDouble passWidth = calculateWidth(this.getPassCount());

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

  private void updateTestCount(int failCount, int skipCount, int passCount) {
    this.failCount = failCount;
    this.skipCount = skipCount;
    this.passCount = passCount;

    calculateState();
  }

  private void updateDuration(float duration) {
    this.duration = duration;
  }

  private String getConfigurationName() {
    return this.configurationName;
  }

  @Override
  protected int getXCount(TestState state) {
    switch (state) {
    case PASSED:
      return passCount;
    case SKIPPED:
      return skipCount;
    case FAILED:
      return failCount;
    default:
      return 0;
    }
  }

  void addSubTests(int passCount, int skipCount, int failCount, float duration) {
    updateTestCount(failCount + getFailCount(), skipCount + getSkipCount(), passCount + getPassCount());
    updateDuration(duration + getDuration());
  }

  @Override
  public String getDisplayName() {
    return "@" + super.getDisplayName();
  }

  @Override
  public String getName() {
    return this.configurationName;
  }

  @Override
  public float getDuration() {
    return duration;
  }

  @Override
  public TestResult findCorrespondingResult(String id) {
    if (id.equals(getSafeName()))
      return this;
    return null;
  }

  public TestState getState() {
    return state;
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

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setConfigurationName(String configurationName) {
    this.configurationName = configurationName;
  }
}
