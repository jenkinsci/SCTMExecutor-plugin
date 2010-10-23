package hudson.plugins.sctmexecutor.publisher;

import hudson.model.AbstractBuild;
import hudson.tasks.test.TabulatedResult;
import hudson.tasks.test.TestObject;
import hudson.tasks.test.TestResult;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

public final class SCTMTestSuiteResult extends TabulatedResult implements Comparable<SCTMTestSuiteResult> {
  private static final long serialVersionUID = -5725371200267573341L;

  private AbstractBuild<?, ?> owner;
  private TestObject parent;
  private String name;
  private Collection<TestResult> childResults;

  public SCTMTestSuiteResult(String name, AbstractBuild<?, ?> owner) {
    this(name, owner, new ArrayList<TestResult>());
  }

  SCTMTestSuiteResult(String name, AbstractBuild<?, ?> owner, Collection<TestResult> children) {
    this.name = name;
    this.owner = owner;
    this.childResults = children;
    for (TestResult result : children) {
      result.setParent(this);
    }
  }

  private int getXCount(SCTMTestResult.TestState state) {
    int count = 0;
    for (SCTMTestResult result : this.getConfigurationResult().values()) {
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
    Map<String, SCTMTestResult> suiteResult = new HashMap<String, SCTMTestResult>();
    for (TestResult result : this.childResults) {
      Map<String, SCTMTestResult> configurationResult = null;
      if (result instanceof SCTMTestCaseResult) {
        configurationResult = ((SCTMTestCaseResult)result).getConfigurationResult();
      } else if (result instanceof SCTMTestSuiteResult) {
        configurationResult = ((SCTMTestSuiteResult)result).getConfigurationResult();
      }
      if (configurationResult != null) {
        for (Entry<String, SCTMTestResult> childResult : configurationResult.entrySet()) {
          SCTMTestResult testResult = suiteResult.get(childResult.getKey());
          if (testResult == null)
            suiteResult.put(childResult.getKey(), new SCTMTestResult(childResult.getValue()));
          else {
            SCTMTestResult childTestResult = childResult.getValue();
            testResult.addSubTestCounts(childTestResult.getPassedCount(), childTestResult.getSkippedCount(), childTestResult.getFailedCount());
            testResult.addSubDuration(childTestResult.getDuration());
          }
        }
      }
    }
    return suiteResult;
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
  public float getDuration() {
    float duration = 0;
    for (TestResult child : this.childResults) {
      duration += child.getDuration();
    }
    return duration;
  }

  @Override
  public Collection<? extends TestResult> getChildren() {
    return this.childResults;
  }

  @Override
  public boolean hasChildren() {
    return this.childResults != null && !this.childResults.isEmpty();
  }

  @Override
  public AbstractBuild<?, ?> getOwner() {
    return owner;
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
  public String getDisplayName() {
    return getName();
  }

  @Override
  public String getName() {
    return name;
  }
  
  @Override
  public TestResult findCorrespondingResult(String id) {
    String myID = safe(getName());
    if (myID.equals(id))
      return this;
    else {
      TestResult testResult = null;
      for (TestResult result : this.childResults) {
         testResult = result.findCorrespondingResult(id);
         if (testResult != null)
           return testResult;
      }
    }
    return null;
  }

  @Override
  public int compareTo(SCTMTestSuiteResult o) {
    if (this.name.equals(o.getName())) {
      if (parent != null)
        return ((SCTMTestSuiteResult)parent).compareTo((SCTMTestSuiteResult)o.getParent());
    }
    return -1;
  }

  @Override
  public Object getDynamic(String token, StaplerRequest req, StaplerResponse rsp) {
    for (TestResult testResult : this.childResults) {
      if (testResult.getName().equals(token))
        return testResult;
      else
        testResult.getDynamic(token, req, rsp);
    }
    return super.getDynamic(token, req, rsp);
  }

  @Override
  public String toString() {
    return String.format("TestSuite [%s]", this.name);
  }
  
  public void addChild(TestResult test) {
    childResults.add(test);
  }

  public SCTMTestSuiteResult getChildSuiteByName(String name) {
    for (TestResult child : this.childResults) {
      if ((child instanceof SCTMTestSuiteResult) &&
          name.equals(child.getName()))
        return (SCTMTestSuiteResult)child;
    }
    return null;
  }

  public SCTMTestCaseResult getChildTestByName(String name) {
    for (TestResult child : this.childResults) {
      if ((child instanceof SCTMTestCaseResult) &&
          name.equals(child.getName()))
        return (SCTMTestCaseResult)child;
    }
    return null;
  }

  public SCTMTestResult getTestResultForConfiguration(String configuration) {
    return this.getConfigurationResult().get(configuration);
  }

  public Collection<String> getConfigurations() {
    return getConfigurationResult().keySet();
  }
}
