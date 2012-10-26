package hudson.plugins.sctmexecutor.publisher;

import hudson.Util;
import hudson.model.AbstractBuild;
import hudson.tasks.test.AbstractTestResultAction;
import hudson.tasks.test.TestObject;
import hudson.tasks.test.TestResult;

public abstract class AbstractSCTMTest extends TestResult implements Comparable<AbstractSCTMTest> {

  private transient AbstractTestResultAction<SCTMResultAction> parentAction;
  private TestObject parent;

  @Override
  public AbstractBuild<?, ?> getOwner() {
    return this.parentAction == null ? null : this.parentAction.owner;
  }

  @Override
  public TestObject getParent() {
    return parent;
  }

  @Override
  public void setParent(TestObject parent) {
    this.parent = parent;
  }

  @Override
  public String getSafeName() {
    return safe(getName()).replaceAll("/|\\|:|\\x2A|\\x3F|<|>|\\x7c|#", "_");
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  @Override
  public void setParentAction(AbstractTestResultAction action) {
    this.parentAction = action;
  }

  public void setParent(SCTMTestSuiteResult parent) {
    this.parent = parent;
  }

  @Override
  public String getDurationString() {
    return Util.getTimeSpanString((long) getDuration());
  }

  @Override
  public TestResult getPreviousResult() {
    AbstractBuild<?, ?> build = getOwner();
    if (build == null)
      return null;

    do {
      build = build.getPreviousBuild();
      if (build != null) {
        SCTMResultAction action = build.getAction(SCTMResultAction.class);
        if (action != null) {
          TestResult result = action.findCorrespondingResult(this.getId());
          if (result != null)
            return result;
        }
      } else
        return null; // no more builds in the past
    } while (true);
  }

  @Override
  public int compareTo(AbstractSCTMTest o) {
    if (this.getName().equals(o.getName())) {
      if (parent != null)
        return ((AbstractSCTMTest) parent).compareTo((AbstractSCTMTest) o.getParent());
    }
    return -1;
  }

  @Override
  public String toString() {
    return String.format("%s in %fms [%d|%d|%d]", this.getName(), this.getDuration(), this.getFailCount(),
        this.getSkipCount(), this.getPassCount());
  }

  @Override
  public String getDisplayName() {
    return getName();
  }

  protected abstract int getXCount(TestState passed);

  @Override
  public int getPassCount() {
    return getXCount(TestState.PASSED);
  }

  @Override
  public int getSkipCount() {
    return getXCount(TestState.SKIPPED);
  }

  @Override
  public int getFailCount() {
    return getXCount(TestState.FAILED);
  }

  @Override
  public int getTotalCount() {
    return getFailCount() + getSkipCount() + getPassCount();
  }
}