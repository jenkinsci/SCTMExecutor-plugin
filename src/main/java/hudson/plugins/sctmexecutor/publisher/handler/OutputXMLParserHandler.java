package hudson.plugins.sctmexecutor.publisher.handler;

import java.util.Stack;

import hudson.plugins.sctmexecutor.publisher.SCTMTestCaseResult;
import hudson.plugins.sctmexecutor.publisher.SCTMTestResult;
import hudson.plugins.sctmexecutor.publisher.SCTMTestResult.TestState;
import hudson.plugins.sctmexecutor.publisher.SCTMTestSuiteResult;
import hudson.tasks.test.TestResult;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class OutputXMLParserHandler extends DefaultHandler {

  private SCTMTestSuiteResult rootSuiteResult;
  private Stack<TestResult> resultStack;
  private Stack<String> cdataStack;
  private final String configuration;
  private boolean pushCData;
  
  public OutputXMLParserHandler(SCTMTestSuiteResult suiteResult, String configuration) {
    this.rootSuiteResult = suiteResult;
    this.configuration = configuration;
    this.resultStack = new Stack<TestResult>();
    this.cdataStack = new Stack<String>();
    
    this.resultStack.push(rootSuiteResult);
  }
  
  @Override
  public void startDocument() throws SAXException {
    
  }
  
  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    pushCData = false;
    if ("TestSuite".equals(qName)) {
      String name = attributes.getValue("TestItem");
      SCTMTestSuiteResult temp = (SCTMTestSuiteResult)this.resultStack.peek();
      SCTMTestSuiteResult child = temp.getChildSuiteByName(name);
      if (child == null) {
        child = new SCTMTestSuiteResult(name, temp.getOwner());
        temp.addChild(child);
        child.setParent(temp);
      }
      this.resultStack.push(child);
    } else if ("Test".equals(qName)) {
      String name = attributes.getValue("TestItem");
      SCTMTestSuiteResult suite = (SCTMTestSuiteResult)this.resultStack.peek();
      SCTMTestCaseResult child = suite.getChildTestByName(name);
      if (child == null) {
        child = new SCTMTestCaseResult(name, suite.getOwner());
        suite.addChild(child);
        child.setParent(suite);
      }
      
      this.resultStack.push(child);
    } else if ("RunCount".equals(qName)) {
    } else if ("Timer".equals(qName)) {
      pushCData = true;
    } else if ("WasSuccess".equals(qName)) {
      pushCData = true;
    }
  }
  
  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    if (pushCData) {
      String item = new String(ch, start, length);
      this.cdataStack.push(item);
    }
    pushCData = false;
  }
  
  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    if ("TestSuite".equals(qName)) {
      this.resultStack.pop();
    } else if ("Test".equals(qName)) {
      SCTMTestCaseResult result = (SCTMTestCaseResult) this.resultStack.pop();
      boolean success = popBooleanFromCDataStack();
      float duration = popFloatFromCDataStack();
      
      result.addConfigurationResult(this.configuration, new SCTMTestResult(success ? TestState.PASSED: TestState.FAILED, duration));
    } else if ("RunCount".equals(qName)) {
    } else if ("Timer".equals(qName)) {
    } else if ("WasSuccess".equals(qName)) {
    }
  }

  private float popFloatFromCDataStack() {
    String string = this.cdataStack.pop();
    return Float.parseFloat(string);
  }

  private  boolean popBooleanFromCDataStack() {
    String string = this.cdataStack.pop();
    return Boolean.parseBoolean(string);
  }

}
