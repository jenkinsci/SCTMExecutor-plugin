package hudson.plugins.sctmexecutor;

import hudson.FilePath;

import java.io.File;

import org.junit.Test;

import com.borland.tm.webservices.tmexecution.ExecutionResult;
import com.borland.tm.webservices.tmexecution.TestDefinitionResult;

public class TestStdResultWriter {

  @Test
  public void testWrite() {
    StdXMLResultWriter w = new StdXMLResultWriter(new FilePath(new File("C:\\tmp")), "http://localhost:19120/Service1.0/services");
    ExecutionResult result = new ExecutionResult();
    result.setExecDefName("TestExecDef");
    result.setExecServerName("MyVirtualExecSrv");
    TestDefinitionResult goodTestDefResult = new TestDefinitionResult(5, 0, 42, "GoodTestDef", "http://www.borland.com", 0, 17, 1234, 1, 0);
    TestDefinitionResult badTestDefResult = new TestDefinitionResult(5, 1, 43, "BadTestDef", "http://www.borland.com", 1, 4, 1235, 1, 0);
    result.setTestDefResult(new TestDefinitionResult[] {goodTestDefResult, badTestDefResult});
    w.write(result);
  }

}
