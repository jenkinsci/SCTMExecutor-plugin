package hudson.plugins.sctmexecutor;

import hudson.FilePath;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.borland.tm.webservices.tmexecution.ExecutionResult;
import com.borland.tm.webservices.tmexecution.TestDefinitionResult;

final class StdXMLResultWriter implements ITestResultWriter {
  private static final int NOT_EXECUTED = 3;
  private static final int FAILED = 2;
  private static final String DEFAULT_SCTM_PACKAGENAME = "silkcentral.testmanager."; //$NON-NLS-1$
  private static final Logger LOGGER = Logger.getLogger("hudson.plugins.sctmexecutor"); //$NON-NLS-1$

  private String sctmHost;

  private FilePath rootDir;
  private String buildNumber;

  public StdXMLResultWriter(FilePath rootDir, String serviceURL, String buildNumber) {
    this.rootDir = rootDir;
    this.buildNumber = buildNumber;
    sctmHost = serviceURL.substring(0, serviceURL.indexOf("/", "http://".length())) + "/silk/DEF"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
  }

  public void write(ExecutionResult result) {
    int done = 3;
    String resultFileName = MessageFormat.format("TEST-{0}-{1}.xml",result.getExecDefName(), buildNumber); //$NON-NLS-1$
    while (done > 0) {
      try {
        FilePath resultFile = rootDir.child(resultFileName); //$NON-NLS-1$
        OutputStream fos = resultFile.write();
        XMLStreamWriter writer = XMLOutputFactory.newInstance().createXMLStreamWriter(fos);
        writer.writeStartDocument();
        writeTestSuite(writer, result);
        writer.writeEndDocument();
        fos.close();
        done = 0;
      } catch (IOException e) {
        resultFileName = resultFileName + "[" + DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(new Date(System.currentTimeMillis())) //$NON-NLS-1$
            + "]"; //$NON-NLS-1$
        if (--done <= 0)
          LOGGER.log(Level.SEVERE, "Cannot write result file."); //$NON-NLS-1$
      } catch (InterruptedException e) {
        LOGGER.log(Level.SEVERE, e.getMessage());
        done = 0;
      } catch (XMLStreamException e) {
        LOGGER.log(Level.SEVERE, e.getMessage());
        done = 0;
      } catch (FactoryConfigurationError e) {
        LOGGER.log(Level.SEVERE, e.getMessage());
        done = 0;
      }
    }
  }

  private void writeTestSuite(XMLStreamWriter writer, ExecutionResult result) throws XMLStreamException {
    String execDefName = DEFAULT_SCTM_PACKAGENAME + result.getExecDefName();
    writer.writeStartElement("testsuite"); //$NON-NLS-1$
    writeTestSuiteCountAttributes(writer, result);    
    writer.writeAttribute("hostname", result.getExecServerName()); //$NON-NLS-1$
    writer.writeAttribute("name", execDefName); //$NON-NLS-1$
    writer.writeAttribute("timestamp", DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format( //$NON-NLS-1$
        new Date(System.currentTimeMillis())));
    
    TestDefinitionResult setupTestDef = result.getSetupTestDef();
    TestDefinitionResult cleanupTestDef = result.getCleanupTestDef();
    if (setupTestDef != null)
      writeTestResult(writer, setupTestDef, execDefName);
    for (TestDefinitionResult testResult : result.getTestDefResult()) {
      writeTestResult(writer, testResult, execDefName);
    }
    if (cleanupTestDef != null)
      writeTestResult(writer, cleanupTestDef, execDefName);
    
    writer.writeEndElement();
  }
  
  private void writeTestSuiteCountAttributes(XMLStreamWriter writer, ExecutionResult result) throws XMLStreamException {
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
    
    writer.writeAttribute("tests", String.valueOf(countTest(result))); //$NON-NLS-1$
    writer.writeAttribute("errors", String.valueOf(errors)); //$NON-NLS-1$
    writer.writeAttribute("failures", String.valueOf(failures)); //$NON-NLS-1$
    writer.writeAttribute("time", String.valueOf(duration)); //$NON-NLS-1$
  }

  private int countTest(ExecutionResult result) {
    int testCount = result.getTestDefResult().length;
    if (result.getSetupTestDef() != null)
      testCount++;
    if (result.getCleanupTestDef() != null)
      testCount++;
    return testCount;
  }

  private void writeTestResult(XMLStreamWriter writer, TestDefinitionResult testResult, String testsuiteName) throws XMLStreamException {
    writer.writeStartElement("testcase"); //$NON-NLS-1$
    writer.writeAttribute("classname", testsuiteName); //$NON-NLS-1$
    writer.writeAttribute("name", testResult.getName()); //$NON-NLS-1$
    writer.writeAttribute("time", String.valueOf(testResult.getDuration() / 1000)); //$NON-NLS-1$
    if (testResult.getStatus() == FAILED)
      writeFailure(writer, testResult.getResultURL());
    else if (testResult.getStatus() == NOT_EXECUTED)
      writeError(writer, testResult.getResultURL());
    writer.writeEndElement();
  }

  private void writeError(XMLStreamWriter writer, String resultURL) throws XMLStreamException {
    writer.writeStartElement("error"); //$NON-NLS-1$
    writer.writeAttribute("message", MessageFormat.format("{0}{1}", sctmHost, resultURL)); //$NON-NLS-1$
    writer.writeAttribute("type", "SCTMError"); //$NON-NLS-1$ //$NON-NLS-2$
    writer.writeEndElement();
  }

  private void writeFailure(XMLStreamWriter writer, String resultURL) throws XMLStreamException {
    writer.writeStartElement("failure"); //$NON-NLS-1$
    writer.writeAttribute("message", MessageFormat.format("{0}{1}", sctmHost, resultURL)); //$NON-NLS-1$ //$NON-NLS-2$
    writer.writeAttribute("type", Messages.getString("StdXMLResultWriter.testresult.failure")); //$NON-NLS-1$ //$NON-NLS-2$
    writer.writeEndElement();
  }

}
