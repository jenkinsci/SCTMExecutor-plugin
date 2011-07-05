package hudson.plugins.sctmexecutor.publisher;

import hudson.tasks.test.TestResult;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

public final class SCTMTestCaseResult extends AbstractSCTMTest implements ISCTMMultipleConfigurationTest {
  private static final long serialVersionUID = 120696130376606962L;

  private final String name;
  final Map<String, SCTMTestConfigurationResult> configurationResults;

  public SCTMTestCaseResult(String name) {
    this(name, new HashMap<String, SCTMTestConfigurationResult>());
  }

  SCTMTestCaseResult(String name, Map<String, SCTMTestConfigurationResult> configurationResults) {
    this.name = name;
    this.configurationResults = configurationResults;
  }

  Map<String, SCTMTestConfigurationResult> getConfigurationResult() {
    return this.configurationResults;
  }

  @Override
  protected int getXCount(TestState state) {
    int count = 0;
    for (AbstractSCTMTest result : this.configurationResults.values()) {
      count += result.getXCount(state);
    }
    return count;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public float getDuration() {
    float duration = 0f;
    for (AbstractSCTMTest result : this.configurationResults.values()) {
      duration += result.getDuration();
    }
    return duration;
  }

  @Override
  public String toString() {
    return String.format("TestCase [%s]", this.getName());
  }

  public void addConfigurationResult(String configuration, SCTMTestConfigurationResult testResult) {
    testResult.setParent(this);
    this.configurationResults.put(configuration, testResult);

  }

  @Override
  public SCTMTestConfigurationResult getTestResultForConfiguration(String config) {
    return this.configurationResults.get(config);
  }

  @Override
  public Collection<String> getConfigurations() {
    List<String> list = new ArrayList<String>(this.configurationResults.keySet());
    Collections.sort(list);
    return list;
  }

  @Override
  public String getConfigurationForResult(SCTMTestConfigurationResult configurationResult) {
    for (Entry<String, SCTMTestConfigurationResult> entry : this.getConfigurationResult().entrySet()) {
      if (entry.getValue().equals(configurationResult))
        return entry.getKey();
    }
    return null;
  }

  @Override
  public TestResult findCorrespondingResult(String id) {
    if (id.equals(getSafeName()))
      return this;
    else {
      TestResult testResult = null;
      for (TestResult result : this.configurationResults.values()) {
        testResult = result.findCorrespondingResult(id);
        if (testResult != null)
          return testResult;
      }
    }
    return null;
  }

  @Override
  public Object getDynamic(String token, StaplerRequest req, StaplerResponse rsp) {
    for (SCTMTestConfigurationResult configuration : this.configurationResults.values()) {
      if (configuration.getSafeName().equals(token))
        return configuration;
      else
        configuration.getDynamic(token, req, rsp);
    }
    return super.getDynamic(token, req, rsp);
  }
}
