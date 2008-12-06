package hudson.plugins.sctmexecutor;

import static org.junit.Assert.*;

import hudson.model.BuildListener;

import java.io.IOException;
import java.io.PrintStream;
import java.rmi.RemoteException;

import org.easymock.EasyMock;
import org.junit.Test;

import com.borland.tm.webservices.tmexecution.ExecutionHandle;
import com.borland.tm.webservices.tmexecution.ExecutionResult;
import com.borland.tm.webservices.tmexecution.ExecutionWebService;
import com.borland.tm.webservices.tmexecution.TestDefinitionResult;

public class TestResultCollector {
  
  @Test
  public void testRun() throws IOException {
    ExecutionWebService serviceMock = EasyMock.createStrictMock(ExecutionWebService.class);
    EasyMock.expect(serviceMock.getStateOfExecution(EasyMock.gt((long)1), (ExecutionHandle) EasyMock.notNull())).andReturn(2);
    EasyMock.expectLastCall().andReturn(-1);
    TestDefinitionResult cleanUp = new TestDefinitionResult(1, 0, 1, "test", "", 1, 1, 1, 1, 0);
    TestDefinitionResult setup = new TestDefinitionResult(1, 0, 1, "test", "", 1, 1, 1, 1, 0);
    TestDefinitionResult[] results = new TestDefinitionResult[] {
        new TestDefinitionResult(1, 0, 1, "test", "", 1, 1, 1, 1, 0),
        new TestDefinitionResult(1, 0, 1, "test", "", 1, 1, 1, 1, 0)
    };
    ExecutionResult result = new ExecutionResult("test", cleanUp, 10, "testExecDef", "unknown", new String[] {"unknown"}, "", setup, results);
    EasyMock.expect(serviceMock.getExecutionResult(EasyMock.gt((long)1), (ExecutionHandle)EasyMock.notNull())).andReturn(result);
    
    ITestResultWriter resultWriterMock = EasyMock.createStrictMock(ITestResultWriter.class);
    resultWriterMock.write(result);
    
    ExecutionHandle handle = new ExecutionHandle(2, 100);
    
    ResultCollectorThread aut = new ResultCollectorThread(new PrintStream("test.log"), serviceMock, 10, handle, resultWriterMock);
    aut.setSleep(1);
    
    EasyMock.replay(serviceMock);
    EasyMock.replay(resultWriterMock);
    aut.run();    
    EasyMock.verify(serviceMock);
    EasyMock.verify(resultWriterMock);
  }
  
  @Test(expected=RuntimeException.class)
  public void testBadRun() throws Exception {
    ExecutionWebService serviceMock = EasyMock.createStrictMock(ExecutionWebService.class);
    EasyMock.expect(serviceMock.getStateOfExecution(EasyMock.gt((long)1), (ExecutionHandle) EasyMock.notNull())).andThrow(new RemoteException());
    
    ExecutionHandle handle = new ExecutionHandle(2, 100);
    
    ResultCollectorThread aut = new ResultCollectorThread(new PrintStream("test.log"), serviceMock, 10, handle, null);
    aut.setSleep(1);
    
    EasyMock.replay(serviceMock);
    aut.run();
    EasyMock.verify(serviceMock);
  }

}
