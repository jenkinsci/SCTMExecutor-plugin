package hudson.plugins.sctmexecutor;

import hudson.FilePath;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import com.borland.tm.webservices.tmexecution.ExecutionResult;
import com.borland.tm.webservices.tmexecution.TestDefinitionResult;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

final class StdXMLResultWriter implements ITestResultWriter {
  private static final int NOT_EXECUTED = 3;
  private static final int FAILED = 2;
  private static final String DEFAULT_SCTM_PACKAGENAME = "silkcentral.testmanager.";
  private static final Logger LOGGER = Logger.getLogger("hudson.plugins.sctmexecutor");

  private String sctmHost;

  private FilePath rootDir;

  public StdXMLResultWriter(FilePath rootDir, String serviceURL) {
    this.rootDir = rootDir;
    sctmHost = serviceURL.substring(0, serviceURL.indexOf("/", "http://".length())) + "/silk/DEF";
  }

  public void write(ExecutionResult result) {
    int done = 3;
    String resultFileName = "TEST-" + result.getExecDefName();
    while (done > 0) {
      try {
        FilePath resultFile = rootDir.child(resultFileName+".xml");
        OutputStream fos = resultFile.write();
        XMLSerializer serializer = new XMLSerializer(fos, new OutputFormat("XML", "UTF-8", true));
        ContentHandler handler = serializer.asContentHandler();
        handler.startDocument();
        writeTestSuite(handler, result);
        handler.endDocument();
        fos.close();
        done = 0;
      } catch (IOException e) {
        resultFileName = resultFileName + "[" + DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(new Date(System.currentTimeMillis()))
            + "]";
        if (--done <= 0)
          LOGGER.log(Level.SEVERE, "Cannot write result file.");
      } catch (SAXException e) {
        LOGGER.log(Level.SEVERE, e.getMessage());
        e.printStackTrace();
        done = 0;
      } catch (InterruptedException e) {
        LOGGER.log(Level.SEVERE, e.getMessage());
        e.printStackTrace();
        done = 0;
      }
    }
  }

  private void writeTestSuite(ContentHandler handler, ExecutionResult result) throws SAXException {
    AttributesImpl atts = new AttributesImpl();
    String execDefName = DEFAULT_SCTM_PACKAGENAME + result.getExecDefName();
    writeTestSuiteCountAttributes(atts, result);    
    atts.addAttribute("", "", "hostname", "CDATA", result.getExecServerName());
    atts.addAttribute("", "", "name", "CDATA", execDefName);
    atts.addAttribute("", "", "timestamp", "CDATA", DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(
        new Date(System.currentTimeMillis())));
    handler.startElement("", "", "testsuite", atts);
    
    TestDefinitionResult setupTestDef = result.getSetupTestDef();
    TestDefinitionResult cleanupTestDef = result.getCleanupTestDef();
    if (setupTestDef != null)
      writeTestResult(handler, setupTestDef, execDefName);
    for (TestDefinitionResult testResult : result.getTestDefResult()) {
      writeTestResult(handler, testResult, execDefName);
    }
    if (cleanupTestDef != null)
      writeTestResult(handler, cleanupTestDef, execDefName);
    
    handler.endElement("", "", "testsuite");
  }
  
  private void writeTestSuiteCountAttributes(AttributesImpl atts, ExecutionResult result) {
    int errors = 0;
    int failures = 0;
    double duration = 0;

    for (TestDefinitionResult testResult : result.getTestDefResult()) {
      if (testResult.getStatus() == FAILED)
        failures++;
      else if (testResult.getStatus() == NOT_EXECUTED)
        errors++;
      duration += testResult.getDuration() / 1000;
    }
    TestDefinitionResult setupTestDef = result.getSetupTestDef();
    TestDefinitionResult cleanupTestDef = result.getCleanupTestDef();
    if (setupTestDef != null) {
      if (setupTestDef.getStatus() == FAILED)
        failures++;
      else if (setupTestDef.getStatus() == NOT_EXECUTED)
        failures++;
      duration += setupTestDef.getDuration() / 1000;
    }
    if (cleanupTestDef != null) {
      if (cleanupTestDef.getStatus() == FAILED)
        failures++;
      else if (cleanupTestDef.getStatus() == NOT_EXECUTED)
        failures++;
      duration += cleanupTestDef.getDuration() / 1000;
    }
    
    atts.addAttribute("", "", "tests", "CDATA", String.valueOf(countTest(result)));
    atts.addAttribute("", "", "errors", "CDATA", String.valueOf(errors));
    atts.addAttribute("", "", "failures", "CDATA", String.valueOf(failures));
    atts.addAttribute("", "", "time", "CDATA", String.valueOf(duration));
  }

  private int countTest(ExecutionResult result) {
    int testCount = result.getTestDefResult().length;
    if (result.getSetupTestDef() != null)
      testCount++;
    if (result.getCleanupTestDef() != null)
      testCount++;
    return testCount;
  }

  private void writeTestResult(ContentHandler handler, TestDefinitionResult testResult, String testsuiteName) throws SAXException {
    AttributesImpl atts = new AttributesImpl();
    atts.addAttribute("", "", "classname", "CDATA", testsuiteName);
    atts.addAttribute("", "", "name", "CDATA", testResult.getName());
    atts.addAttribute("", "", "time", "CDATA", String.valueOf(testResult.getDuration() / 1000));
    handler.startElement("", "", "testcase", atts);
    if (testResult.getStatus() == FAILED)
      writeFailure(handler, testResult.getResultURL());
    else if (testResult.getStatus() == NOT_EXECUTED)
      writeError(handler, testResult.getResultURL());
    handler.endElement("", "", "testcase");
  }

  private void writeError(ContentHandler handler, String resultURL) throws SAXException {
    AttributesImpl atts = new AttributesImpl();
    atts.addAttribute("", "", "message", "CDATA", MessageFormat.format("{0}{1}", sctmHost, resultURL));
    atts.addAttribute("", "", "type", "CDATA", "SCTMError");
    handler.startElement("", "", "error", atts);
    handler.endElement("", "", "error");
  }

  private void writeFailure(ContentHandler handler, String resultURL) throws SAXException {
    AttributesImpl atts = new AttributesImpl();
    atts.addAttribute("", "", "message", "CDATA", MessageFormat.format("{0}{1}", sctmHost, resultURL));
    atts.addAttribute("", "", "type", "CDATA", "SCTMFailure");
    handler.startElement("", "", "failure", atts);
    handler.endElement("", "", "failure");
  }
}
