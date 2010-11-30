package hudson.plugins.sctmexecutor.publisher;

import hudson.XmlFile;
import hudson.model.AbstractBuild;
import hudson.tasks.junit.CaseResult;
import hudson.tasks.junit.SuiteResult;
import hudson.tasks.test.AbstractTestResultAction;
import hudson.tasks.test.TestResult;
import hudson.util.HeapSpaceStringConverter;
import hudson.util.XStream2;

import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.kohsuke.stapler.StaplerProxy;

import com.thoughtworks.xstream.XStream;

public class SCTMResultAction extends AbstractTestResultAction<SCTMResultAction> implements StaplerProxy {
  private static final Logger LOGGER = Logger.getLogger("hudson.plugins.sctmexecutor.publisher");
  private static final XStream XSTREAM = new XStream2();

  static {
      XSTREAM.alias("suite",SCTMTestSuiteResult.class);
      XSTREAM.alias("case",SCTMTestCaseResult.class);
      XSTREAM.registerConverter(new HeapSpaceStringConverter(),100);
  }
  
//  private WeakReference<TestResult> testResult;
  private TestResult testResult;

  private int failCount;
  private int skipCount;
  private Integer totalCount;

  protected SCTMResultAction(AbstractBuild<?, ?> owner, TestResult testResult) {
    super(owner);
//    this.testResult = new WeakReference<TestResult>(testResult);
    this.testResult = testResult;

    SCTMTestSuiteResult sctmTestSuiteResult = (SCTMTestSuiteResult) this.testResult; //.get();
    failCount = sctmTestSuiteResult.getFailCount();
    skipCount = sctmTestSuiteResult.getSkipCount();
    totalCount = sctmTestSuiteResult.getTotalCount();
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
    TestResult result = this.testResult; //.get();
    if (result instanceof SCTMTestCaseResult)
      return ((SCTMTestCaseResult) result).getConfigurations();
    else if (result instanceof SCTMTestSuiteResult)
      return ((SCTMTestSuiteResult) result).getConfigurations();
    else
      throw new IllegalStateException("Unknown result type.");
  }

  @Override
  public int getFailCount() {
    return failCount;
  }

  @Override
  public int getTotalCount() {
    return totalCount;
  }

  @Override
  public TestResult getResult() {
    TestResult r;
//    if (testResult == null) {
//      r = load();
//      testResult = new WeakReference<TestResult>(r);
//    } else {
      r = testResult; //.get();
//    }

    if (totalCount == null) {
      totalCount = r.getTotalCount();
      failCount = r.getFailCount();
      skipCount = r.getSkipCount();
    }
    return r;
  }

//  private TestResult load() {
//    TestResult r;
//    try {
//      r = (TestResult) getDataFile().read();
//    } catch (IOException e) {
//      LOGGER.log(Level.WARNING, "Failed to load " + getDataFile(), e);
//      r = new SCTMTestCaseResult("dummy", null); // return a dummy
//    }
//    r.freeze(this);
//    return r;
//  }

  private XmlFile getDataFile() {
    return new XmlFile(XSTREAM, new File(owner.getRootDir(), "junitResult.xml"));
  }

  @Override
  public Object getTarget() {
    return getResult();
  }

}
