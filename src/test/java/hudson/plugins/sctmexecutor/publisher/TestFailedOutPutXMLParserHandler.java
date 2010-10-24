package hudson.plugins.sctmexecutor.publisher;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import hudson.plugins.sctmexecutor.publisher.handler.OutputXMLParserHandler;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestFailedOutPutXMLParserHandler {

  private static final String TESTRESULTS_ROOTPATH = "src/test/resources/hudson/plugins/sctmexecutor/publisher/";
  private SCTMTestSuiteResult rootSuite;

  @Before
  public void setUp() throws Exception {
    SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
    rootSuite = new SCTMTestSuiteResult("root", null);
    OutputXMLParserHandler handler = new OutputXMLParserHandler(rootSuite , "config1");
    parser.parse(new File(TESTRESULTS_ROOTPATH+"failedTestResult/output.xml"), handler);
  }
  
  @Test
  public void testParsedStructure() throws Exception {
    assertEquals(3, this.rootSuite.getTotalCount());
    assertEquals(1, this.rootSuite.getChildren().size());
    
    SCTMTestSuiteResult plan = this.rootSuite.getChildSuiteByName("plan.pln");
    assertNotNull(plan);
    assertEquals("plan.pln", plan.getName());
    assertEquals(3, plan.getTotalCount());
    assertEquals(3, plan.getChildren().size());
    
    SCTMTestSuiteResult suite = plan.getChildSuiteByName("codeField.t");
    assertNotNull(suite);
    assertEquals("codeField.t", suite.getName());
    assertEquals(1, suite.getTotalCount());
    assertEquals(1, suite.getChildren().size());
    
    SCTMTestCaseResult test = suite.getChildTestByName("codeField"); 
    assertNotNull(test);
    assertEquals("codeField", test.getName());
    assertEquals(1, test.getTotalCount());
    
    suite = plan.getChildSuiteByName("window.t");
    assertNotNull(suite);
    assertEquals("window.t", suite.getName());
    assertEquals(1, suite.getTotalCount());
    assertEquals(1, suite.getChildren().size());
    
    test = suite.getChildTestByName("WindowTest"); 
    assertNotNull(test);
    assertEquals("WindowTest", test.getName());
    assertEquals(1, test.getTotalCount());
    
    suite = plan.getChildSuiteByName("table.t");
    assertNotNull(suite);
    assertEquals("table.t", suite.getName());
    assertEquals(1, suite.getTotalCount());
    assertEquals(1, suite.getChildren().size());
    
    test = suite.getChildTestByName("TableTest"); 
    assertNotNull(test);
    assertEquals("TableTest", test.getName());
    assertEquals(1, test.getTotalCount());
  }
  
  @Test
  public void testFailedTestRun() throws Exception {   
    assertEquals(2, rootSuite.getFailCount());
    assertEquals(0, rootSuite.getSkipCount());
    assertEquals(1, rootSuite.getPassCount());
    assertEquals(60000.0, rootSuite.getDuration(), 0.1);
    
    SCTMTestSuiteResult suite = rootSuite.getChildSuiteByName("plan.pln").getChildSuiteByName("codeField.t");
    assertEquals(1, suite.getFailCount());
    assertEquals(0, suite.getSkipCount());
    assertEquals(0, suite.getPassCount());
    assertEquals(21000.0, suite.getDuration(), 0.1);
    
    SCTMTestCaseResult test = suite.getChildTestByName("codeField");
    assertEquals(1, test.getFailCount());
    assertEquals(0, test.getSkipCount());
    assertEquals(0, test.getPassCount());
    assertEquals(21000.0, test.getDuration(), 0.1);
  }
  
  @Test @Ignore
  public void testErrorMessage() throws Exception {
    SCTMTestCaseResult test = this.rootSuite.getChildSuiteByName("plan.pln").getChildSuiteByName("codeField.t").getChildTestByName("codeField");
    assertNotNull(test);
    SCTMTestResult configurationResult = test.getTestResultForConfiguration("config1");
    assertNotNull(configurationResult);
    String errormsg = configurationResult.getErrorMessage();
    assertEquals("<b>Error: </b><br/>"+
        "Log Error: Could not find object '//Tree[@automationId='shellcont/shell']'"+
        "<b>Stacktrace: </b><br/>"+
        "Print: Occurred in Find&#xD;"+
        "Print: Called from CodeField at CodeField.t(6)"+
        "<b>Error: </b><br/>"+
        "Log Error: &lt;&lt;&lt;&lt; Click to View Bitmap of Error cmd /C\" start C:\\DOCUME~1\\ADMINI~1\\LOCALS~1\\Temp\\SCC_ExecServer_19124_19125\\PerfProjects\\PerfPrj_45_1270803017013\\CodeField105147.bmp\""+
        "<b>Error: </b><br/>"+
        "Print: Occurred in CaptureDesktop at ..\\common.inc(150)&#xD;"+
        "Print: Called from TestCaseExit at frame.inc(16)&#xD;"+
        "Print: Called from CodeField at CodeField.t(6)", errormsg);
  }

}
