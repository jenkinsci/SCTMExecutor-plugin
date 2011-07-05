package hudson.plugins.sctmexecutor.publisher;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import hudson.plugins.sctmexecutor.publisher.handler.OutputXMLParserHandler;

import java.io.File;
import java.util.Arrays;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Before;
import org.junit.Test;

public class TestMultipleConfigurationDomainModelStructure {

  private static final String TESTRESULTS_ROOTPATH = "src/test/resources/hudson/plugins/sctmexecutor/publisher/";
  private SCTMTestSuiteResult rootSuite;

  @Before
  public void setUp() throws Exception {
    SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
    rootSuite = new SCTMTestSuiteResult("root");
    OutputXMLParserHandler handler = new OutputXMLParserHandler(rootSuite, "win7");
    parser.parse(new File(TESTRESULTS_ROOTPATH + "specialTestResult/output_Win7.xml"), handler);
    handler = new OutputXMLParserHandler(rootSuite, "winxp");
    parser.parse(new File(TESTRESULTS_ROOTPATH + "specialTestResult/output_Winxp.xml"), handler);
    this.rootSuite.calculateConfigurationResults();
  }

  @Test
  public void testWithSpecialCharsInName() throws Exception {
    assertEquals(16, this.rootSuite.getTotalCount());
    assertEquals(1, this.rootSuite.getChildren().size());
    assertEquals(2, this.rootSuite.getConfigurations().size());
    assertEquals(Arrays.asList("win7", "winxp"), this.rootSuite.getConfigurations());
    assertEquals(50000.0f, this.rootSuite.getDuration(), 0.1);

    SCTMTestConfigurationResult result = this.rootSuite.getTestResultForConfiguration("win7");
    assertEquals(8, result.getTotalCount());
    assertEquals(8, result.getPassCount());
    assertEquals(0, result.getSkipCount());
    assertEquals(0, result.getFailCount());
    assertEquals(TestState.PASSED, result.getState());
    assertEquals(25000.0f, result.getDuration(), 0.1);

    SCTMTestSuiteResult suite = this.rootSuite.getChildSuiteByName("Calculator- High/Low");
    assertNotNull(suite);
    assertEquals("Calculator- High/Low", suite.getDisplayName());
    assertEquals("Calculator- High_Low", suite.getSafeName());
    assertEquals(16, suite.getTotalCount());
    assertEquals(1, suite.getChildren().size());
    assertEquals(2, suite.getConfigurations().size());
    assertEquals(Arrays.asList("win7", "winxp"), suite.getConfigurations());
  }
}
