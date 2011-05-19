package hudson.plugins.sctmexecutor.publisher;

import hudson.Util;
import hudson.model.AbstractBuild;
import hudson.tasks.test.TestObject;
import hudson.tasks.test.TestResult;

import org.apache.commons.lang.mutable.MutableDouble;

public class SCTMTestResult extends TestResult implements Comparable<SCTMTestResult> {
  private static final int MIN_BAR_WIDTH = 5;

  private TestState state = TestState.NOTESTS;
  private int failCount;
  private int skipCount;
  private int passCount;
  private float duration;
  private final String errorMessage;
  private String name;
  private transient int passWidth;
  private transient int skipWidth;
  private transient int failWidth;

  private TestObject parent;

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
    this.name = value.getName();

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

  @Override
  public int getTotalCount() {
    return failCount + skipCount + passCount;
  }

  @Override
  public synchronized int getFailCount() {
    return failCount;
  }

  @Override
  public synchronized int getSkipCount() {
    return skipCount;
  }

  @Override
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

  @Override
  public synchronized float getDuration() {
    return duration;
  }

  @Override
  public String getDurationString() {
    return Util.getTimeSpanString((long) duration);
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  @Override
  public String getDisplayName() {
    return name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getSafeName() {
    String name = getName();
    if (name == null)
      return null;
    return safe(name);
  }

  @Override
  public int compareTo(SCTMTestResult o) {
    return equals(o) ? 0 : -1;
  }

  @Override
  public AbstractBuild<?, ?> getOwner() {
    return this.parent.getOwner();
  }

  @Override
  public TestObject getParent() {
    return this.parent;
  }

  @Override
  public void setParent(TestObject parent) {
    this.parent = parent;
  }

  @Override
  public TestResult findCorrespondingResult(String id) {
    if (id.equals(this.getSafeName()))
      return this;
    return null;
  }

  void setName(String name) {
    this.name = name;
  }

}
