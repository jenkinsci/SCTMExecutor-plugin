package hudson.plugins.sctmexecutor.publisher;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSCTMTestResult {

  private static SCTMTestResult dummyResult;

  @BeforeClass
  public static void setUp() throws Exception {
    dummyResult = new SCTMTestResult(TestState.NOTESTS, 0, "");
  }

  @Test
  public void testEmptyTestResult() throws Exception {
    SCTMTestResult result = dummyResult;

    Assert.assertEquals(0, result.getFailWidth());
    Assert.assertEquals(0, result.getSkipWidth());
    Assert.assertEquals(0, result.getPassWidth());
    Assert.assertEquals(0, result.getFailWidth() + result.getSkipWidth() + result.getPassWidth());
  }

  @Test
  public void testNotModifiedTestResult() throws Exception {
    SCTMTestResult result = new SCTMTestResult(dummyResult);
    result.addSubTestCounts(1, 1, 1);
    result.calculateBar();

    Assert.assertEquals(33, result.getFailWidth());
    Assert.assertEquals(33, result.getSkipWidth());
    Assert.assertEquals(33, result.getPassWidth());
    Assert.assertEquals(99, result.getFailWidth() + result.getSkipWidth() + result.getPassWidth());
  }

  @Test
  public void testNotModifiedTestResultWithNoFaild() throws Exception {
    SCTMTestResult result = new SCTMTestResult(dummyResult);
    result.addSubTestCounts(80, 20, 0);
    result.calculateBar();

    Assert.assertEquals(0, result.getFailWidth());
    Assert.assertEquals(20, result.getSkipWidth());
    Assert.assertEquals(80, result.getPassWidth());
    Assert.assertEquals(100, result.getFailWidth() + result.getSkipWidth() + result.getPassWidth());
  }

  @Test
  public void testNotModifiedTestResultWithNoSkiped() throws Exception {
    SCTMTestResult result = new SCTMTestResult(dummyResult);
    result.addSubTestCounts(80, 0, 20);
    result.calculateBar();

    Assert.assertEquals(20, result.getFailWidth());
    Assert.assertEquals(0, result.getSkipWidth());
    Assert.assertEquals(80, result.getPassWidth());
    Assert.assertEquals(100, result.getFailWidth() + result.getSkipWidth() + result.getPassWidth());
  }

  @Test
  public void testNotModifiedTestResultWithNoPassed() throws Exception {
    SCTMTestResult result = new SCTMTestResult(dummyResult);
    result.addSubTestCounts(0, 20, 80);
    result.calculateBar();

    Assert.assertEquals(80, result.getFailWidth());
    Assert.assertEquals(20, result.getSkipWidth());
    Assert.assertEquals(0, result.getPassWidth());
    Assert.assertEquals(100, result.getFailWidth() + result.getSkipWidth() + result.getPassWidth());
  }

  @Test
  public void testModifiedFailWidth() throws Exception {
    SCTMTestResult result = new SCTMTestResult(dummyResult);
    result.addSubTestCounts(80, 19, 1);
    result.calculateBar();

    Assert.assertEquals(5, result.getFailWidth());
    Assert.assertEquals(19, result.getSkipWidth());
    Assert.assertEquals(76, result.getPassWidth());
    Assert.assertEquals(100, result.getFailWidth() + result.getSkipWidth() + result.getPassWidth());
  }

  @Test
  public void testModifiedFailWidth2() throws Exception {
    SCTMTestResult result = new SCTMTestResult(dummyResult);
    result.addSubTestCounts(108, 0, 1);
    result.calculateBar();

    Assert.assertEquals(5, result.getFailWidth());
    Assert.assertEquals(0, result.getSkipWidth());
    Assert.assertEquals(95, result.getPassWidth());
    Assert.assertEquals(100, result.getFailWidth() + result.getSkipWidth() + result.getPassWidth());
  }

  @Test
  public void testModifiedSkipWidth() throws Exception {
    SCTMTestResult result = new SCTMTestResult(dummyResult);
    result.addSubTestCounts(80, 1, 19);
    result.calculateBar();

    Assert.assertEquals(19, result.getFailWidth());
    Assert.assertEquals(5, result.getSkipWidth());
    Assert.assertEquals(76, result.getPassWidth());
    Assert.assertEquals(100, result.getFailWidth() + result.getSkipWidth() + result.getPassWidth());
  }

  @Test
  public void testModifiedPassWidth() throws Exception {
    SCTMTestResult result = new SCTMTestResult(dummyResult);
    result.addSubTestCounts(1, 80, 19);
    result.calculateBar();

    Assert.assertEquals(19, result.getFailWidth());
    Assert.assertEquals(76, result.getSkipWidth());
    Assert.assertEquals(5, result.getPassWidth());
    Assert.assertEquals(100, result.getFailWidth() + result.getSkipWidth() + result.getPassWidth());
  }

  @Test
  public void testMultibleAddSubTests() throws Exception {
    SCTMTestResult result = new SCTMTestResult(dummyResult);
    result.addSubTestCounts(1, 1, 1);
    result.calculateBar();
    Assert.assertEquals(33, result.getFailWidth());
    Assert.assertEquals(33, result.getSkipWidth());
    Assert.assertEquals(33, result.getPassWidth());
    Assert.assertEquals(99, result.getFailWidth() + result.getSkipWidth() + result.getPassWidth());

    result.addSubTestCounts(0, 39, 10);
    result.addSubTestCounts(0, 1, 0);
    result.addSubTestCounts(0, 30, 0);
    result.addSubTestCounts(0, 9, 8);
    result.calculateBar();
    Assert.assertEquals(19, result.getFailWidth());
    Assert.assertEquals(76, result.getSkipWidth());
    Assert.assertEquals(5, result.getPassWidth());
    Assert.assertEquals(100, result.getFailWidth() + result.getSkipWidth() + result.getPassWidth());

  }
}
