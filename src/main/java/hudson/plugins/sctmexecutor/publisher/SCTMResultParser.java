package hudson.plugins.sctmexecutor.publisher;

import hudson.FilePath;
import hudson.model.AbstractBuild;
import hudson.plugins.sctmexecutor.publisher.handler.OutputXMLParserHandler;
import hudson.tasks.test.TestResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.io.filefilter.RegexFileFilter;
import org.xml.sax.SAXException;

public class SCTMResultParser {
  private FilePath rootPath;
  private Map<String, SCTMTestSuiteResult> resultMap;
  private final SCTMTestSuiteResult rootSuite;

  public SCTMResultParser(FilePath resultRootPath, SCTMTestSuiteResult rootSuite) {
    this.rootPath = resultRootPath;
    this.rootSuite = rootSuite;
    this.resultMap = new HashMap<String, SCTMTestSuiteResult>();
  }
  
  public TestResult createResult(AbstractBuild<?, ?> owner) {
    List<FilePath> resultFilePath = findAllResultFiles(rootPath);
    
    for (FilePath filePath : resultFilePath) {
      parseResultFile(filePath, rootSuite);
    }
    
    return null;
  }

  private void parseResultFile(FilePath filePath, SCTMTestSuiteResult suiteResult) {
    try {
      SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
      OutputXMLParserHandler handler = new OutputXMLParserHandler(suiteResult, filePath.getParent().getParent().getName());
      parser.parse(filePath.read(), handler);
    } catch (ParserConfigurationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (SAXException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  private String getSuiteName(FilePath filePath) {
   return filePath.getParent().getName();
  }

  private List<FilePath> findAllResultFiles(FilePath rootPath) {
    List<FilePath> resultFilePath = new ArrayList<FilePath>();
    try {
      if (rootPath.isDirectory()) { // just to be sure we are in a directory
        List<FilePath> list = rootPath.list(new RegexFileFilter("output.xml"));
        resultFilePath.addAll(list);
        list = rootPath.listDirectories();
        for (FilePath dirPath : list) {
          List<FilePath> childrens = findAllResultFiles(dirPath);
          resultFilePath.addAll(childrens);
        }
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return resultFilePath;
  }
}
