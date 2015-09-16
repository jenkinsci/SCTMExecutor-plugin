package hudson.plugins.sctmexecutor.publisher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.kohsuke.stapler.StaplerProxy;

import com.thoughtworks.xstream.XStream;

import hudson.XmlFile;
import hudson.model.AbstractBuild;
import hudson.model.BuildListener;
import hudson.tasks.test.AbstractTestResultAction;
import hudson.tasks.test.TestResult;
import hudson.util.HeapSpaceStringConverter;
import hudson.util.XStream2;

public class SCTMResultAction extends AbstractTestResultAction<SCTMResultAction> implements StaplerProxy {
  private static final Logger LOGGER = Logger.getLogger("hudson.plugins.sctmexecutor.publisher");
  private static final XStream XSTREAM = new XStream2();

  static {
    XSTREAM.alias("suite", SCTMTestSuiteResult.class);
    XSTREAM.alias("case", SCTMTestCaseResult.class);
    XSTREAM.alias("configuration", SCTMTestConfigurationResult.class);
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
      this.testResult = new WeakReference<TestResult>(testResult);
    } catch (FileNotFoundException e) {
      this.testResult = new WeakReference<TestResult>(new SCTMTestSuiteResult("Empty Result"));
    } catch (IOException e) {
      this.testResult = new WeakReference<TestResult>(new SCTMTestSuiteResult("Empty Result"));
      String msg = "Failed to save the SCTM test result.";
      LOGGER.log(Level.SEVERE, msg, e);
      listener.fatalError(msg);
    }
  }

  private XmlFile getDataFile() {
    File resultFile = new File(owner.getRootDir(), "sctmResult.xml");
    return new XmlFile(XSTREAM, resultFile);
  }

  private TestResult load() {
    TestResult r;
    XmlFile resultFile = getDataFile();
    try {
      if (resultFile.exists()) {
        r = (TestResult) resultFile.read();
        maintainTestResult(r);
      } else {
        throw new FileNotFoundException("Cannot find a valid result file at: " + resultFile.getFile().getPath());
      }
    } catch (IOException e) {
      LOGGER.log(Level.WARNING, "Failed to load " + resultFile, e);
      r = new SCTMTestCaseResult("Empty result"); // return a dummy
      r.setParentAction(this);
    }
    return r;
  }

  private void maintainTestResult(TestResult r) {
    if (r instanceof ISCTMMultipleConfigurationTest) {
      maintainTestResult((ISCTMMultipleConfigurationTest) r);
    }
    if (r instanceof SCTMTestSuiteResult) {
      for (TestResult suite : ((SCTMTestSuiteResult) r).getChildren()) {
        maintainTestResult(suite);
      }
    }
  }

  private void maintainTestResult(ISCTMMultipleConfigurationTest r) {
    ((TestResult) r).setParentAction(this);
    for (String configurationName : r.getConfigurations()) {
      SCTMTestConfigurationResult configurationResult = r.getTestResultForConfiguration(configurationName);
      configurationResult.setConfigurationName(configurationName);
      configurationResult.setParent((TestResult) r);
      configurationResult.setParentAction(this);
    }
  }

  @Override
  public String getDisplayName() {
    return "SCTMResult";
  }

  @Override
  public String getIconFileName() {
    return "/plugin/SCTMExecutor/images/sctmresult.jpg";
  }

  @Override
  public String getUrlName() {
    return "sctmreport";
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
    TestResult result = testResult.get();
    if (result instanceof ISCTMMultipleConfigurationTest) {
      return ((ISCTMMultipleConfigurationTest) result).getConfigurations();
    } else {
      throw new IllegalStateException("Result type has not configurations as child.");
    }
  }

}
