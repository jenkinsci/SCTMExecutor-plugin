package hudson.plugins.sctmexecutor.publisher.handler;

import java.util.Stack;

import hudson.plugins.sctmexecutor.publisher.SCTMTestCaseResult;
import hudson.plugins.sctmexecutor.publisher.SCTMTestSuiteResult;
import hudson.tasks.test.TestResult;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class OutputXMLParserHandler extends DefaultHandler {

  private SCTMTestSuiteResult rootSuiteResult;
  private Stack<TestResult> resultStack;
  private final String configuration;
  
  public OutputXMLParserHandler(SCTMTestSuiteResult suiteResult, String configuration) {
    this.rootSuiteResult = suiteResult;
    this.configuration = configuration;
    this.resultStack.push(rootSuiteResult);
  }
  
  @Override
  public void startDocument() throws SAXException {
    
  }
  
  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
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
    } else if ("WassSuccess".equals(qName)) {
      
    }
  }
  
  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    if ("TestSuite".equals(qName) ||
        "Test".equals(qName)) {
      this.resultStack.pop();
    } // else : ignore all other tags
  }

}
