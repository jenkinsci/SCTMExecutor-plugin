package hudson.plugins.sctmexecutor.publisher;

import hudson.model.AbstractBuild;
import hudson.tasks.test.TabulatedResult;
import hudson.tasks.test.TestObject;
import hudson.tasks.test.TestResult;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

public final class SCTMTestSuiteResult extends TabulatedResult implements Comparable<SCTMTestSuiteResult> {
  private static final long serialVersionUID = -5725371200267573341L;

  private AbstractBuild<?, ?> owner;
  private TestObject parent;
  private String name;
  private Collection<TestResult> childResults;
  private Map<String, SCTMTestResult> configurationResults;

  private int passCount = 0;
  private int skipCount = 0;
  private int failCount = 0;

  public SCTMTestSuiteResult(String name, AbstractBuild<?, ?> owner, Map<String, SCTMTestResult> configurationResults,
      Collection<TestResult> children) {
    this.owner = owner;
    this.name = name;
    this.configurationResults = configurationResults;
    this.childResults = children;
    for (TestResult result : children) {
      result.setParent(this);
      passCount += result.getPassCount();
      skipCount += result.getSkipCount();
      failCount += result.getFailCount();
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

  public Collection<String> getConfigurations() {
    return configurationResults.keySet();
  }

  @Override
  public Collection<? extends TestResult> getChildren() {
    return this.childResults;
  }

  public SCTMTestResult getTestResultForConfiguration(String configuration) {
    return this.configurationResults.get(configuration);
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
}
