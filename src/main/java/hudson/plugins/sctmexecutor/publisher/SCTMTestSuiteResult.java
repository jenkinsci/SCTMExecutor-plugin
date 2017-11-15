package hudson.plugins.sctmexecutor.publisher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

import hudson.Util;
import hudson.model.AbstractBuild;
import hudson.tasks.test.AbstractTestResultAction;
import hudson.tasks.test.TabulatedResult;
import hudson.tasks.test.TestObject;
import hudson.tasks.test.TestResult;

public final class SCTMTestSuiteResult extends TabulatedResult implements ISCTMMultipleConfigurationTest,
    Comparable<SCTMTestSuiteResult> {
  private static final long serialVersionUID = -5725371200267573341L;

  private TestObject parent;
  private final String name;
  private final Collection<TestResult> childResults;
  private final Map<String, SCTMTestConfigurationResult> configurationResults;

  private transient AbstractTestResultAction<SCTMResultAction> parentAction;

  public SCTMTestSuiteResult(String name) {
    this.name = name;
    childResults = new ArrayList<>();
    configurationResults = new HashMap<>();
  }

  private int getXCount(TestState state) {
    int count = 0;
    for (AbstractSCTMTest result : getConfigurationResult().values()) {
      switch (state) {
      case PASSED:
        count += result.getPassCount();
        break;
      case SKIPPED:
        count += result.getSkipCount();
        break;
      case FAILED:
        count += result.getFailCount();
        break;
      }
    }
    return count;
  }

  synchronized void calculateConfigurationResults() {
    for (TestResult result : childResults) {
      Map<String, SCTMTestConfigurationResult> configurationResult = null;
      if (result instanceof SCTMTestCaseResult) {
        configurationResult = ((SCTMTestCaseResult) result).getConfigurationResult();
      } else if (result instanceof SCTMTestSuiteResult) {
        ((SCTMTestSuiteResult) result).calculateConfigurationResults();
        configurationResult = ((SCTMTestSuiteResult) result).getConfigurationResult();
      }
      if (configurationResult != null) {
        for (Entry<String, SCTMTestConfigurationResult> childResult : configurationResult.entrySet()) {
          SCTMTestConfigurationResult testResult = configurationResults.get(childResult.getKey());
          if (testResult == null) {
            SCTMTestConfigurationResult confResult = new SCTMTestConfigurationResult(childResult.getValue());
            confResult.setParent(this);
            configurationResults.put(childResult.getKey(), confResult);
          } else {
            AbstractSCTMTest childTestResult = childResult.getValue();
            testResult.addSubTests(childTestResult.getPassCount(), childTestResult.getSkipCount(),
                childTestResult.getFailCount(), childTestResult.getDuration(), childTestResult.getErrorDetails());
          }
        }
      }
    }
  }

  synchronized Map<String, SCTMTestConfigurationResult> getConfigurationResult() {
    return configurationResults;
  }

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
  public float getDuration() {
    float duration = 0;
    for (AbstractSCTMTest conf : getConfigurationResult().values()) {
      duration += conf.getDuration();
    }
    return duration;
  }

  @Override
  public String getDurationString() {
    return Util.getTimeSpanString((long) getDuration());
  }

  @Override
  public Collection<? extends TestResult> getChildren() {
    return Collections.unmodifiableCollection(childResults);
  }

  @Override
  public boolean hasChildren() {
    return childResults != null && !childResults.isEmpty();
  }

  @Override
  public AbstractBuild<?, ?> getOwner() {
    return parentAction == null ? null : parentAction.owner;
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
    return name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getSafeName() {
    return safe(name).replaceAll("/|\\|:|\\x2A|\\x3F|<|>|\\x7c|#", "_");
  }

  @Override
  public TestResult findCorrespondingResult(String id) {
    String myID = getSafeName();
    if (myID.equals(id)) {
      return this;
    } else {
      TestResult testResult = null;
      for (TestResult result : childResults) {
        testResult = result.findCorrespondingResult(id);
        if (testResult != null) {
          return testResult;
        }
      }
    }
    return null;
  }

  @Override
  public int compareTo(SCTMTestSuiteResult o) {
    if (name.equals(o.getName())) {
      if (parent != null) {
        return ((SCTMTestSuiteResult) parent).compareTo((SCTMTestSuiteResult) o.getParent());
      }
    }
    return -1;
  }

  @Override
  public Object getDynamic(String token, StaplerRequest req, StaplerResponse rsp) {
    for (TestResult testResult : childResults) {
      if (testResult.getSafeName().equals(token)) {
        return testResult;
      } else {
        for (SCTMTestConfigurationResult configuration : configurationResults.values()) {
          if (configuration.getSafeName().equals(token)) {
            return configuration;
          }
        }
        testResult.getDynamic(token, req, rsp);
      }
    }
    return super.getDynamic(token, req, rsp);
  }

  @Override
  public String toString() {
    return String.format("TestSuite [%s]", name);
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  @Override
  public void setParentAction(AbstractTestResultAction action) {
    parentAction = action;
  }

  @Override
  public TestResult getPreviousResult() {
    AbstractBuild<?, ?> build = getOwner();
    if (build == null) {
      return null;
    }

    do {
      build = build.getPreviousBuild();
      if (build != null) {
        SCTMResultAction action = build.getAction(SCTMResultAction.class);
        if (action != null) {
          TestResult result = action.findCorrespondingResult(getId());
          if (result != null) {
            return result;
          }
        }
      }
      else {
        return null; // no more builds in the past
      }
    } while (true);
  }

  public synchronized void addChild(TestResult test) {
    childResults.add(test);
  }

  public synchronized SCTMTestSuiteResult getChildSuiteByName(String name) {
    for (TestResult child : childResults) {
      if ((child instanceof SCTMTestSuiteResult) && name.equals(child.getDisplayName())) {
        return (SCTMTestSuiteResult) child;
      }
    }
    return null;
  }

  public synchronized SCTMTestCaseResult getChildTestByName(String name) {
    for (TestResult child : childResults) {
      if ((child instanceof SCTMTestCaseResult) && name.equals(child.getDisplayName())) {
        return (SCTMTestCaseResult) child;
      }
    }
    return null;
  }

  @Override
  public String getConfigurationForResult(SCTMTestConfigurationResult configurationResult) {
    for (Entry<String, SCTMTestConfigurationResult> entry : getConfigurationResult().entrySet()) {
      if (entry.getValue().equals(configurationResult)) {
        return entry.getKey();
      }
    }
    return null;
  }

  @Override
  public SCTMTestConfigurationResult getTestResultForConfiguration(String configuration) {
    return getConfigurationResult().get(configuration);
  }

  @Override
  public Collection<String> getConfigurations() {
    List<String> list = new ArrayList<>(configurationResults.keySet());
    Collections.sort(list);
    return list;
  }
}
