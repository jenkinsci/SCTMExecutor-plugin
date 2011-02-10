package hudson.plugins.sctmexecutor.publisher;

import hudson.XmlFile;
import hudson.model.BuildListener;
import hudson.model.AbstractBuild;
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
    XSTREAM.alias("suite", SCTMTestSuiteResult.class);
    XSTREAM.alias("case", SCTMTestCaseResult.class);
    XSTREAM.registerConverter(new HeapSpaceStringConverter(), 100);
  }

  private transient WeakReference<TestResult> testResult;

  private int failCount;
  private int skipCount;
  private Integer totalCount;

  protected SCTMResultAction(AbstractBuild<?, ?> owner, TestResult testResult, BuildListener listener) {
    super(owner);
    setResult(testResult, listener);
  }

  private synchronized void setResult(TestResult testResult, BuildListener listener) {
    SCTMTestSuiteResult sctmTestSuiteResult = (SCTMTestSuiteResult) testResult;
    failCount = sctmTestSuiteResult.getFailCount();
    skipCount = sctmTestSuiteResult.getSkipCount();
    totalCount = sctmTestSuiteResult.getTotalCount();

    try {
      getDataFile().write(testResult);
    } catch (IOException e) {
      String msg = "Failed to save the SCTM test result.";
      LOGGER.log(Level.SEVERE, msg, e);
      listener.fatalError(msg);
    }
    this.testResult = new WeakReference<TestResult>(testResult);
  }

  private XmlFile getDataFile() {
    return new XmlFile(XSTREAM, new File(owner.getRootDir(), "sctmResult.xml"));
  }

  private TestResult load() {
    TestResult r;
    try {
      r = (TestResult) getDataFile().read();
      r.setParentAction(this);
    } catch (IOException e) {
      LOGGER.log(Level.WARNING, "Failed to load " + getDataFile(), e);
      r = new SCTMTestCaseResult("dummy"); // return a dummy
      r.setParentAction(this);
    }
    return r;
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
    if (testResult == null) {
      r = load();
      testResult = new WeakReference<TestResult>(r);
    } else {
      r = testResult.get();
      if (r == null) {
        r = load();
        testResult = new WeakReference<TestResult>(r);
      }
    }

    if (totalCount == null) {
      totalCount = r.getTotalCount();
      failCount = r.getFailCount();
      skipCount = r.getSkipCount();
    }
    return r;
  }

  @Override
  public Object getTarget() {
    return getResult();
  }

  public Collection<String> getConfigurations() {
    TestResult result = this.testResult.get();
    if (result instanceof SCTMTestCaseResult)
      return ((SCTMTestCaseResult) result).getConfigurations();
    else if (result instanceof SCTMTestSuiteResult)
      return ((SCTMTestSuiteResult) result).getConfigurations();
    else
      throw new IllegalStateException("Unknown result type.");
  }

}
