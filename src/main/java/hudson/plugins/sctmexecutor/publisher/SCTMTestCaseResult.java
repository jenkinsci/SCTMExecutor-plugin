package hudson.plugins.sctmexecutor.publisher;

import hudson.model.AbstractBuild;
import hudson.tasks.test.TestObject;
import hudson.tasks.test.TestResult;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class SCTMTestCaseResult extends TestResult implements Comparable<SCTMTestCaseResult> {
  private static final long serialVersionUID = 120696130376606962L;

  private AbstractBuild<?,?> owner;
  private TestObject parent;
  private String name;
  private Map<String, SCTMTestResult> configurationResults;
  
  public SCTMTestCaseResult(String name, AbstractBuild<?,?> owner) {
    this(name, owner, new HashMap<String, SCTMTestResult>());
  }
  
  SCTMTestCaseResult(String name, AbstractBuild<?,?> owner, Map<String, SCTMTestResult> configurationResults) {    
    this.owner = owner;
    this.name = name;
    this.configurationResults = configurationResults;
  }
  
  private int getXCount(SCTMTestResult.TestState state) {
    int count = 0;
    for (SCTMTestResult result : this.configurationResults.values()) {
      switch (state) {
        case PASSED:
          count += result.getPassedCount();
          break;
        case SKIPPED:
          count += result.getSkippedCount();
          break;
        case FAILED:
          count += result.getFailedCount();
          break;
      }
    }
    return count;
  }

  Map<String, SCTMTestResult> getConfigurationResult() {
    return this.configurationResults;
  }

  @Override
  public int getPassCount() {
    return getXCount(SCTMTestResult.TestState.PASSED);
  }

  @Override
  public int getSkipCount() {
    return getXCount(SCTMTestResult.TestState.SKIPPED);
  }

  @Override
  public int getFailCount() {
    return getXCount(SCTMTestResult.TestState.FAILED);
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

  public void addConfigurationResult(String configuration, SCTMTestResult testResult) {
    this.configurationResults.put(configuration, testResult);
  }
}
