package hudson.plugins.sctmexecutor.publisher;

import hudson.model.AbstractBuild;
import hudson.tasks.test.TestObject;
import hudson.tasks.test.TestResult;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class SCTMTestCaseResult extends TestResult implements Comparable<SCTMTestCaseResult> {
  private static final long serialVersionUID = 120696130376606962L;

  private AbstractBuild<?,?> owner;
  private TestObject parent;
  private String name;
  private Map<String, SCTMTestResult> configurationResults;
  private int passCount;
  private int skipCount;
  private int failCount;
  
  SCTMTestCaseResult(String name, AbstractBuild<?,?> owner, Map<String, SCTMTestResult> configurationResults) {
    this.owner = owner;
    this.name = name;
    this.configurationResults = configurationResults;
    for (SCTMTestResult result : configurationResults.values()) {
      passCount += result.getPassedCount();
      skipCount += result.getSkippedCount();
      failCount += result.getFailedCount();
    }
  }
  
  @Override
  public int getPassCount() {
    return passCount;
  }
  
  @Override
  public int getSkipCount() {
    return skipCount;
  }
  
  @Override
  public int getFailCount() {
    return failCount;
  }
  
  @Override
  public String getDisplayName() {
    return getName();
  }

  @Override
  public AbstractBuild<?, ?> getOwner() {
    return owner;
  }
  
  public void setParent(SCTMTestSuiteResult parent) {
    this.parent = parent;
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
  public TestResult findCorrespondingResult(String id) {
    if (id.equals(safe(getName())))
      return this;
    return null;
  }
  
  @Override
  public String getName() {
    return name;
  }

  public Collection<String> getConfigurations() {
    return this.configurationResults.keySet();
  }
  
  public SCTMTestResult getTestResultForConfiguration(String config) {
    return this.configurationResults.get(config);
  }

  @Override
  public int compareTo(SCTMTestCaseResult o) {
    if (this.name.equals(o.getName())) {
      if (parent != null)
        return ((SCTMTestSuiteResult)parent).compareTo((SCTMTestSuiteResult)o.getParent());
    }
    return -1;
  }
}
