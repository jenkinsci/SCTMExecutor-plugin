package hudson.plugins.sctmexecutor.publisher;

import hudson.model.AbstractBuild;
import hudson.tasks.test.AbstractTestResultAction;
import hudson.tasks.test.TestResult;

import java.util.Collection;

import org.kohsuke.stapler.StaplerProxy;

public class SCTMResultAction extends AbstractTestResultAction<SCTMResultAction> implements StaplerProxy {
  
  private TestResult testResult;

  protected SCTMResultAction(AbstractBuild<?,?> owner, TestResult testResult) {
    super(owner);
    this.testResult = testResult;
  }
  
  @Override
  public String getDisplayName() {
    return "SCTMResult";
  }

  @Override
  public String getIconFileName() {
    return "gear2.gif";
  }

  @Override
  public String getUrlName() {
    return "sctmresult";
  }
  
  public Collection<String> getConfigurations() {
    TestResult result = this.testResult;
    if (result instanceof SCTMTestCaseResult)
      return ((SCTMTestCaseResult)result).getConfigurations();
    else if (result instanceof SCTMTestSuiteResult)
      return ((SCTMTestSuiteResult)result).getConfigurations();
    else
      throw new IllegalStateException("Unknown result type.");
  }

  @Override
  public int getFailCount() {
    return testResult.getFailCount(); 
  }

  @Override
  public int getTotalCount() {
    return testResult.getTotalCount();
  }

  @Override
  public TestResult getResult() {
    return testResult;
  }

  @Override
  public Object getTarget() {
    return getResult();
  }

}
