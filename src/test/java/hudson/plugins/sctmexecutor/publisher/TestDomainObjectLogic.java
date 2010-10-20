package hudson.plugins.sctmexecutor.publisher;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestDomainObjectLogic {
  private SCTMTestSuiteResult rootSuite;

  @Before
  public void setup() {
    rootSuite = new SCTMTestSuiteResult("root", null);
    SCTMTestSuiteResult suite1 = new SCTMTestSuiteResult("suite1", null);
    SCTMTestCaseResult test1 = new SCTMTestCaseResult("case1", null);
    test1.addConfigurationResult("config1", new SCTMTestResult(SCTMTestResult.TestState.PASSED));
    test1.addConfigurationResult("config2", new SCTMTestResult(SCTMTestResult.TestState.SKIPPED));
    test1.addConfigurationResult("config3", new SCTMTestResult(SCTMTestResult.TestState.FAILED));
    suite1.addChild(test1);
    rootSuite.addChild(suite1);
    SCTMTestSuiteResult suite2 = new SCTMTestSuiteResult("suite2", null);
    SCTMTestSuiteResult subsuite = new SCTMTestSuiteResult("suite2.1", null);
    SCTMTestCaseResult test2 = new SCTMTestCaseResult("case2", null);
    test2.addConfigurationResult("config1", new SCTMTestResult(SCTMTestResult.TestState.PASSED));
    test2.addConfigurationResult("config2", new SCTMTestResult(SCTMTestResult.TestState.SKIPPED));
    test2.addConfigurationResult("config3", new SCTMTestResult(SCTMTestResult.TestState.FAILED));
    subsuite.addChild(test2);
    SCTMTestCaseResult test3 = new SCTMTestCaseResult("case3", null);
    test3.addConfigurationResult("config1", new SCTMTestResult(SCTMTestResult.TestState.PASSED));
    test3.addConfigurationResult("config2", new SCTMTestResult(SCTMTestResult.TestState.SKIPPED));
    test3.addConfigurationResult("config3", new SCTMTestResult(SCTMTestResult.TestState.FAILED));
    subsuite.addChild(test3);
    suite2.addChild(subsuite);
    rootSuite.addChild(suite2);
    SCTMTestSuiteResult suite3 = new SCTMTestSuiteResult("suite3", null);
    rootSuite.addChild(suite3);
    
  }
  
  @Test
  public void testTest1Result() throws Exception {
    SCTMTestCaseResult test1 = rootSuite.getChildSuiteByName("suite1").getChildTestByName("case1");
    assertEquals("case1", test1.getName());
    SCTMTestResult result = test1.getTestResultForConfiguration("config1");
    assertEquals(1, result.getPassedCount());
    assertEquals(0, result.getSkippedCount());
    assertEquals(0, result.getFailedCount());
    assertEquals(SCTMTestResult.TestState.PASSED, result.getState());
    
    result = test1.getTestResultForConfiguration("config2");
    assertEquals(0, result.getPassedCount());
    assertEquals(1, result.getSkippedCount());
    assertEquals(0, result.getFailedCount());
    assertEquals(SCTMTestResult.TestState.SKIPPED, result.getState());
    
    result = test1.getTestResultForConfiguration("config3");
    assertEquals(0, result.getPassedCount());
    assertEquals(0, result.getSkippedCount());
    assertEquals(1, result.getFailedCount());
    assertEquals(SCTMTestResult.TestState.FAILED, result.getState());
  }
  
  @Test
  public void testSuite1Result() throws Exception {
    SCTMTestSuiteResult suite1 = rootSuite.getChildSuiteByName("suite1");
    assertEquals("suite1", suite1.getName());
    SCTMTestResult result = suite1.getTestResultForConfiguration("config1");
    assertEquals(1, result.getPassedCount());
    assertEquals(0, result.getSkippedCount());
    assertEquals(0, result.getFailedCount());
    assertEquals(SCTMTestResult.TestState.PASSED, result.getState());
    
    result = suite1.getTestResultForConfiguration("config2");
    assertEquals(0, result.getPassedCount());
    assertEquals(1, result.getSkippedCount());
    assertEquals(0, result.getFailedCount());
    assertEquals(SCTMTestResult.TestState.SKIPPED, result.getState());
    
    result = suite1.getTestResultForConfiguration("config3");
    assertEquals(0, result.getPassedCount());
    assertEquals(0, result.getSkippedCount());
    assertEquals(1, result.getFailedCount());
    assertEquals(SCTMTestResult.TestState.FAILED, result.getState());
  }
  
  @Test
  public void testRootResult() throws Exception {
    SCTMTestResult result = this.rootSuite.getTestResultForConfiguration("config1");
    assertEquals(3, result.getPassedCount());
    assertEquals(0, result.getSkippedCount());
    assertEquals(0, result.getFailedCount());
    assertEquals(SCTMTestResult.TestState.PASSED, result.getState());
    
    result = this.rootSuite.getTestResultForConfiguration("config2");
    assertEquals(0, result.getPassedCount());
    assertEquals(3, result.getSkippedCount());
    assertEquals(0, result.getFailedCount());
    assertEquals(SCTMTestResult.TestState.SKIPPED, result.getState());
    
    result = this.rootSuite.getTestResultForConfiguration("config3");
    assertEquals(0, result.getPassedCount());
    assertEquals(0, result.getSkippedCount());
    assertEquals(3, result.getFailedCount());
    assertEquals(SCTMTestResult.TestState.FAILED, result.getState());
  }
  
  @Test
  public void testEmptySuiteResult() throws Exception {
    SCTMTestSuiteResult suite3 = this.rootSuite.getChildSuiteByName("suite3");
    assertEquals("suite3", suite3.getName());
    SCTMTestResult result = suite3.getTestResultForConfiguration("config1");
    assertNull(result);
    
    result = suite3.getTestResultForConfiguration("config2");
    assertNull(result);
    
    result = suite3.getTestResultForConfiguration("config3");
    assertNull(result);
  }
}
