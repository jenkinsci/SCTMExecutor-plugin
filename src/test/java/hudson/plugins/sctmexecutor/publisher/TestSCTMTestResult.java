package hudson.plugins.sctmexecutor.publisher;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSCTMTestResult {

  private static SCTMTestConfigurationResult dummyResult;

  @BeforeClass
  public static void setUp() throws Exception {
    dummyResult = new SCTMTestConfigurationResult("", TestState.NOTESTS, 0, "");
  }

  @Test
  public void testEmptyTestResult() throws Exception {
    SCTMTestConfigurationResult result = dummyResult;

    Assert.assertEquals(0, result.getFailWidth());
    Assert.assertEquals(0, result.getSkipWidth());
    Assert.assertEquals(0, result.getPassWidth());
    Assert.assertEquals(0, result.getFailWidth() + result.getSkipWidth() + result.getPassWidth());
  }

  @Test
  public void testNotModifiedTestResult() throws Exception {
    SCTMTestConfigurationResult result = new SCTMTestConfigurationResult(dummyResult);
    result.addSubTests(1, 1, 1, 0);
    result.calculateBar();

    Assert.assertEquals(33, result.getFailWidth());
    Assert.assertEquals(33, result.getSkipWidth());
    Assert.assertEquals(33, result.getPassWidth());
    Assert.assertEquals(99, result.getFailWidth() + result.getSkipWidth() + result.getPassWidth());
  }

  @Test
  public void testNotModifiedTestResultWithNoFaild() throws Exception {
    SCTMTestConfigurationResult result = new SCTMTestConfigurationResult(dummyResult);
    result.addSubTests(80, 20, 0, 0.5f);
    result.calculateBar();

    Assert.assertEquals(0, result.getFailWidth());
    Assert.assertEquals(20, result.getSkipWidth());
    Assert.assertEquals(80, result.getPassWidth());
    Assert.assertEquals(100, result.getFailWidth() + result.getSkipWidth() + result.getPassWidth());
    Assert.assertEquals(0.5f, result.getDuration(), 0.01f);
  }

  @Test
  public void testNotModifiedTestResultWithNoSkiped() throws Exception {
    SCTMTestConfigurationResult result = new SCTMTestConfigurationResult(dummyResult);
    result.addSubTests(80, 0, 20, 0);
    result.calculateBar();

    Assert.assertEquals(20, result.getFailWidth());
    Assert.assertEquals(0, result.getSkipWidth());
    Assert.assertEquals(80, result.getPassWidth());
    Assert.assertEquals(100, result.getFailWidth() + result.getSkipWidth() + result.getPassWidth());
  }

  @Test
  public void testNotModifiedTestResultWithNoPassed() throws Exception {
    SCTMTestConfigurationResult result = new SCTMTestConfigurationResult(dummyResult);
    result.addSubTests(0, 20, 80, 0);
    result.calculateBar();

    Assert.assertEquals(80, result.getFailWidth());
    Assert.assertEquals(20, result.getSkipWidth());
    Assert.assertEquals(0, result.getPassWidth());
    Assert.assertEquals(100, result.getFailWidth() + result.getSkipWidth() + result.getPassWidth());
  }

  @Test
  public void testModifiedFailWidth() throws Exception {
    SCTMTestConfigurationResult result = new SCTMTestConfigurationResult(dummyResult);
    result.addSubTests(80, 19, 1, 0);
    result.calculateBar();

    Assert.assertEquals(5, result.getFailWidth());
    Assert.assertEquals(19, result.getSkipWidth());
    Assert.assertEquals(76, result.getPassWidth());
    Assert.assertEquals(100, result.getFailWidth() + result.getSkipWidth() + result.getPassWidth());
  }

  @Test
  public void testModifiedFailWidth2() throws Exception {
    SCTMTestConfigurationResult result = new SCTMTestConfigurationResult(dummyResult);
    result.addSubTests(108, 0, 1, 0);
    result.calculateBar();

    Assert.assertEquals(5, result.getFailWidth());
    Assert.assertEquals(0, result.getSkipWidth());
    Assert.assertEquals(95, result.getPassWidth());
    Assert.assertEquals(100, result.getFailWidth() + result.getSkipWidth() + result.getPassWidth());
  }

  @Test
  public void testModifiedSkipWidth() throws Exception {
    SCTMTestConfigurationResult result = new SCTMTestConfigurationResult(dummyResult);
    result.addSubTests(80, 1, 19, 0);
    result.calculateBar();

    Assert.assertEquals(19, result.getFailWidth());
    Assert.assertEquals(5, result.getSkipWidth());
    Assert.assertEquals(76, result.getPassWidth());
    Assert.assertEquals(100, result.getFailWidth() + result.getSkipWidth() + result.getPassWidth());
  }

  @Test
  public void testModifiedPassWidth() throws Exception {
    SCTMTestConfigurationResult result = new SCTMTestConfigurationResult(dummyResult);
    result.addSubTests(1, 80, 19, 0);
    result.calculateBar();

    Assert.assertEquals(19, result.getFailWidth());
    Assert.assertEquals(76, result.getSkipWidth());
    Assert.assertEquals(5, result.getPassWidth());
    Assert.assertEquals(100, result.getFailWidth() + result.getSkipWidth() + result.getPassWidth());
  }

  @Test
  public void testMultibleAddSubTests() throws Exception {
    SCTMTestConfigurationResult result = new SCTMTestConfigurationResult(dummyResult);
    result.addSubTests(1, 1, 1, 0);
    result.calculateBar();
    Assert.assertEquals(33, result.getFailWidth());
    Assert.assertEquals(33, result.getSkipWidth());
    Assert.assertEquals(33, result.getPassWidth());
    Assert.assertEquals(99, result.getFailWidth() + result.getSkipWidth() + result.getPassWidth());

    result.addSubTests(0, 39, 10, 0);
    result.addSubTests(0, 1, 0, 0);
    result.addSubTests(0, 30, 0, 0);
    result.addSubTests(0, 9, 8, 0);
    result.calculateBar();
    Assert.assertEquals(19, result.getFailWidth());
    Assert.assertEquals(76, result.getSkipWidth());
    Assert.assertEquals(5, result.getPassWidth());
    Assert.assertEquals(100, result.getFailWidth() + result.getSkipWidth() + result.getPassWidth());

  }
}
