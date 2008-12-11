package hudson.plugins.sctmexecutor;

import hudson.FilePath;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Date;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import com.borland.tm.webservices.tmexecution.ExecutionResult;
import com.borland.tm.webservices.tmexecution.TestDefinitionResult;

final class StdXMLResultWriter implements ITestResultWriter {
  private static final int NOT_EXECUTED = 3;
  private static final int FAILED = 2;
  
  private static String sctmHost;
  
  private FilePath rootDir;
  
  public StdXMLResultWriter(FilePath rootDir) {
    this.rootDir = rootDir;
    initSctmHost();
  }
  
  private static void initSctmHost() {
    if (sctmHost == null || (sctmHost != null && sctmHost.equals(""))) {
      String serviceURL = SCTMExecutor.DESCRIPTOR.getServiceURL();
      sctmHost = serviceURL.substring(0, serviceURL.indexOf("/", "http://".length())) + "/silk/DEF";
    }
  }

  public void write(ExecutionResult result) {
    int done = 3;
    String resultFileName = "TEST-"+result.getExecDefName();
    while (done > 0) {
      try {
        FilePath resultFile = rootDir.createTempFile(resultFileName,".xml");
        OutputStream fos = resultFile.write();
        XMLSerializer serializer = new XMLSerializer(fos, new OutputFormat("XML", "UTF-8", true));
        ContentHandler handler = serializer.asContentHandler();
        handler.startDocument();
        writeTestSuite(handler, result);
        handler.endDocument();
        fos.close();
        done = 0;
      } catch (IOException e) {
        resultFileName = resultFileName + "["+ DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(new Date(System.currentTimeMillis()))+"]";
        if (--done <= 0)
          System.err.println("[ERROR] Cannot write result file."); // TODO: use logging
      } catch (SAXException e) {
        // FIXME: do something
        e.printStackTrace();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  private void writeTestSuite(ContentHandler handler, ExecutionResult result) throws SAXException {
    int errors = 0;
    int failures = 0;
    double duration = 0;
    
    for (TestDefinitionResult testResult : result.getTestDefResult()) {
      if (testResult.getStatus() == FAILED) failures++;
      else if (testResult.getStatus() == NOT_EXECUTED) errors++;
      duration += testResult.getDuration()/100;
    }
    AttributesImpl atts = new AttributesImpl();
    atts.addAttribute("", "", "errors", "CDATA", String.valueOf(errors));
    atts.addAttribute("", "", "failures", "CDATA", String.valueOf(failures));
    atts.addAttribute("", "", "hostname", "CDATA", result.getExecServerName());
    atts.addAttribute("", "", "name", "CDATA", result.getExecDefName());
    atts.addAttribute("", "", "time", "CDATA", String.valueOf(duration));
    atts.addAttribute("", "", "tests", "CDATA", String.valueOf(result.getTestDefResult().length));
    atts.addAttribute("", "", "timestamp", "CDATA", DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(new Date(System.currentTimeMillis())));
    handler.startElement("", "", "testsuite", atts);
    if (result.getSetupTestDef() != null)
      writeTestResult(handler, result.getSetupTestDef());
    for (TestDefinitionResult testResult : result.getTestDefResult()) {
      writeTestResult(handler, testResult);      
    }
    if (result.getCleanupTestDef() != null)
      writeTestResult(handler, result.getCleanupTestDef());
    handler.endElement("", "", "testsuite");
  }

  private void writeTestResult(ContentHandler handler, TestDefinitionResult testResult) throws SAXException {
    AttributesImpl atts = new AttributesImpl();
    atts.addAttribute("", "", "classname", "CDATA", testResult.getName());
    atts.addAttribute("", "", "name", "CDATA", testResult.getName()+"#test");
    atts.addAttribute("", "", "time", "CDATA", String.valueOf(testResult.getDuration()/100));
    handler.startElement("", "", "testcase", atts);
    if (testResult.getStatus() == FAILED)
      writeFailure(handler, testResult.getResultURL());
    else if (testResult.getStatus() == NOT_EXECUTED)
      writeError(handler, testResult.getResultURL());
    handler.endElement("", "", "testcase");
  }

  private void writeError(ContentHandler handler, String resultURL) throws SAXException {
    AttributesImpl atts = new AttributesImpl();
    atts.addAttribute("", "", "message", "CDATA", sctmHost+resultURL);
    atts.addAttribute("", "", "type", "CDATA", "SCTMError");
    handler.startElement("", "", "error", atts);
    handler.endElement("", "", "error");
  }

  private void writeFailure(ContentHandler handler, String resultURL) throws SAXException {
    AttributesImpl atts = new AttributesImpl();
    atts.addAttribute("", "", "message", "CDATA", sctmHost+resultURL);
    atts.addAttribute("", "", "type", "CDATA", "SCTMFailure");
    handler.startElement("", "", "failure", atts);
    handler.endElement("", "", "failure");
  }
}
