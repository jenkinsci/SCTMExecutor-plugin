package hudson.plugins.sctmexecutor.publisher;

import hudson.Launcher;
import hudson.model.BuildListener;
import hudson.model.AbstractBuild;
import hudson.model.Hudson;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Recorder;
import hudson.tasks.test.TestResult;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.kohsuke.stapler.DataBoundConstructor;

public class SCTMResultArchiver extends Recorder implements Serializable {

  @DataBoundConstructor
  public SCTMResultArchiver() {
  }

  @Override
  public BuildStepMonitor getRequiredMonitorService() {
    return BuildStepMonitor.NONE;
  }

  @Override
  public boolean perform(AbstractBuild<?, ?> build, Launcher launcher, BuildListener listener)
      throws InterruptedException, IOException {
    
    build.getActions().add(new SCTMResultAction(build, new SCTMTestSuiteResult("root", build, createConfigurationResult(), createSuiteResults(build))));
    return true;
  }

  private Collection<TestResult> createSuiteResults(AbstractBuild<?, ?> owner) {
    Collection<TestResult> result = new ArrayList<TestResult>();
    result.add(new SCTMTestSuiteResult("Suite1", owner, createConfigurationResult(), createChildResults(owner)));
    result.add(new SCTMTestSuiteResult("Suite2", owner, createConfigurationResult(), createChildResults(owner)));
    result.add(new SCTMTestSuiteResult("Suite3", owner, createConfigurationResult(), createChildResults(owner)));
    return result;
  }

  private Collection<TestResult> createChildResults(AbstractBuild<?,?> owner) {
    Collection<TestResult> result = new ArrayList<TestResult>();
    result.add(new SCTMTestCaseResult("Test1", owner, createConfigurationResult()));
    result.add(new SCTMTestCaseResult("Test2", owner, createConfigurationResult()));
    result.add(new SCTMTestCaseResult("Test3", owner, createConfigurationResult()));
    return result;
  }

  private Map<String, SCTMTestResult> createConfigurationResult() {
    Map<String, SCTMTestResult> results = new HashMap<String, SCTMTestResult>();
    results.put("Config1", new SCTMTestResult(1,0,0));
    results.put("Config2", new SCTMTestResult(0,1,0));
    results.put("Config3", new SCTMTestResult(0,0,1));
    
    return results;
  }

  @Override
  public SCTMResultArchiverDescriptor getDescriptor() {
    return (SCTMResultArchiverDescriptor) Hudson.getInstance().getDescriptor(this.getClass());
  }

}
