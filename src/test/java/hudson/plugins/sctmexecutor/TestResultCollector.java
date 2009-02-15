package hudson.plugins.sctmexecutor;

import static org.junit.Assert.assertTrue;

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
  public void collectingResults() throws IOException {
    ExecutionWebService serviceMock = createServiceMock();
    ExecutionResult result = createDummyResult();
    EasyMock.expect(serviceMock.getExecutionResult(EasyMock.gt((long)1), (ExecutionHandle)EasyMock.notNull())).andReturn(result);
    
    ITestResultWriter resultWriterMock = EasyMock.createStrictMock(ITestResultWriter.class);
    resultWriterMock.write(result);
    
    ExecutionHandle handle = new ExecutionHandle(2, 100);
    
    ISessionHandler sessionHandlerMock = EasyMock.createStrictMock(ISessionHandler.class);
    EasyMock.expect(sessionHandlerMock.getSessionId(EasyMock.lt(0l))).andReturn(Long.valueOf(10));
    
    ResultCollectorThread aut = new ResultCollectorThread(new PrintStream("test.log"), serviceMock, sessionHandlerMock, handle, resultWriterMock);
    aut.setSleep(1);
    
    EasyMock.replay(serviceMock);
    EasyMock.replay(resultWriterMock);
    EasyMock.replay(sessionHandlerMock);
    aut.run();
    EasyMock.verify(serviceMock);
    EasyMock.verify(resultWriterMock);
    EasyMock.verify(sessionHandlerMock);
  }
  
  @Test
  public void runCollectorThread() throws IOException {
    ExecutionWebService serviceMock = EasyMock.createStrictMock(ExecutionWebService.class);
    EasyMock.expect(serviceMock.getStateOfExecution(EasyMock.gt((long)1), (ExecutionHandle) EasyMock.notNull())).andReturn(2);
    EasyMock.expectLastCall().times(2).andReturn(2);
    EasyMock.expectLastCall().andReturn(-1);
    ExecutionResult result = createDummyResult();
    EasyMock.expect(serviceMock.getExecutionResult(EasyMock.gt((long)1), (ExecutionHandle)EasyMock.notNull())).andReturn(result);
    
    ITestResultWriter resultWriterMock = EasyMock.createStrictMock(ITestResultWriter.class);
    resultWriterMock.write(result);
    
    ExecutionHandle handle = new ExecutionHandle(2, 100);
    
    ISessionHandler sessionHandlerMock = EasyMock.createStrictMock(ISessionHandler.class);
    EasyMock.expect(sessionHandlerMock.getSessionId(EasyMock.lt(0l))).andReturn(Long.valueOf(10));
    ResultCollectorThread aut = new ResultCollectorThread(new PrintStream("test.log"), serviceMock, sessionHandlerMock, handle, resultWriterMock);
    aut.setSleep(1);
    
    EasyMock.replay(serviceMock);
    EasyMock.replay(resultWriterMock);
    EasyMock.replay(sessionHandlerMock);
    long start = System.currentTimeMillis();
    aut.run();
    long duration = (System.currentTimeMillis()-start)/1000;
    assertTrue(duration > 8 && duration < 16);
    EasyMock.verify(serviceMock);
    EasyMock.verify(resultWriterMock);
    EasyMock.verify(sessionHandlerMock);
  }
  
  @Test(expected=RuntimeException.class)
  public void testBadRun() throws Exception {
    ExecutionWebService serviceMock = EasyMock.createStrictMock(ExecutionWebService.class);
    EasyMock.expect(serviceMock.getStateOfExecution(EasyMock.gt((long)1), (ExecutionHandle) EasyMock.notNull())).andThrow(new RemoteException());
    
    ExecutionHandle handle = new ExecutionHandle(2, 100);
    
    ISessionHandler sessionHandlerMock = EasyMock.createStrictMock(ISessionHandler.class);
    EasyMock.expect(sessionHandlerMock.getSessionId(EasyMock.lt(0l))).andReturn(Long.valueOf(10));
    ResultCollectorThread aut = new ResultCollectorThread(new PrintStream("test.log"), serviceMock, sessionHandlerMock, handle, null);
    aut.setSleep(1);
    
    EasyMock.replay(serviceMock);
    EasyMock.replay(sessionHandlerMock);
    aut.run();
    EasyMock.verify(serviceMock);
    EasyMock.verify(sessionHandlerMock);
  }
  
  @Test(expected=RuntimeException.class)
  public void testBadResult() throws Exception {
    ExecutionWebService serviceMock = createServiceMock();
    EasyMock.expect(serviceMock.getExecutionResult(EasyMock.gt((long)1), (ExecutionHandle)EasyMock.notNull())).andThrow(new RemoteException());
    EasyMock.expect(serviceMock.getStateOfExecution(EasyMock.gt((long)1), (ExecutionHandle) EasyMock.notNull())).andReturn(-1);
    EasyMock.expect(serviceMock.getExecutionResult(EasyMock.gt((long)1), (ExecutionHandle)EasyMock.notNull())).andThrow(new RemoteException());
    EasyMock.expect(serviceMock.getStateOfExecution(EasyMock.gt((long)1), (ExecutionHandle) EasyMock.notNull())).andReturn(-1);
    EasyMock.expect(serviceMock.getExecutionResult(EasyMock.gt((long)1), (ExecutionHandle)EasyMock.notNull())).andThrow(new RemoteException());
    EasyMock.expect(serviceMock.getStateOfExecution(EasyMock.gt((long)1), (ExecutionHandle) EasyMock.notNull())).andReturn(-1);
    
    ExecutionHandle handle = new ExecutionHandle(2, 100);
    
    ISessionHandler sessionHandlerMock = EasyMock.createStrictMock(ISessionHandler.class);
    EasyMock.expect(sessionHandlerMock.getSessionId(EasyMock.lt(0l))).times(2).andReturn(Long.valueOf(10));
    ResultCollectorThread aut = new ResultCollectorThread(new PrintStream("test.log"), serviceMock, sessionHandlerMock, handle, null);
    aut.setSleep(1);
    
    EasyMock.replay(serviceMock);
    EasyMock.replay(sessionHandlerMock);
    aut.run();
    EasyMock.verify(serviceMock);
    EasyMock.verify(sessionHandlerMock);
  }
  
  @Test
  public void testLostExecutionResult() throws Exception {
    ExecutionWebService serviceMock = createServiceMock();
    EasyMock.expect(serviceMock.getExecutionResult(EasyMock.gt((long)1), (ExecutionHandle)EasyMock.notNull())).andThrow(new RemoteException());
    EasyMock.expect(serviceMock.getStateOfExecution(EasyMock.gt((long)1), (ExecutionHandle) EasyMock.notNull())).andReturn(-1);

    ExecutionResult result = createDummyResult();
    EasyMock.expect(serviceMock.getExecutionResult(EasyMock.gt((long)1), (ExecutionHandle)EasyMock.notNull())).andReturn(result);
    
    ITestResultWriter resultWriterMock1 = createTestResultWriterMock(result);
    
    ExecutionHandle handle1 = new ExecutionHandle(2, 100);
    
    ISessionHandler sessionHandlerMock = EasyMock.createStrictMock(ISessionHandler.class);
    EasyMock.expect(sessionHandlerMock.getSessionId(EasyMock.eq(-1l))).andReturn(Long.valueOf(10l));
    EasyMock.expectLastCall().andReturn(Long.valueOf(10l));
    
    ResultCollectorThread aut1 = new ResultCollectorThread(new PrintStream("test.log"), serviceMock, sessionHandlerMock, handle1, resultWriterMock1);
    aut1.setSleep(1);
    
    EasyMock.replay(serviceMock);
    EasyMock.replay(resultWriterMock1);
    EasyMock.replay(sessionHandlerMock);
    aut1.run();
    EasyMock.verify(serviceMock);
    EasyMock.verify(resultWriterMock1);
    EasyMock.verify(sessionHandlerMock);
  }
  
  @Test
  public void testLostSession() throws Exception {
    ExecutionWebService serviceMock = EasyMock.createStrictMock(ExecutionWebService.class);
    EasyMock.expect(serviceMock.getStateOfExecution(EasyMock.gt((long)0), (ExecutionHandle) EasyMock.notNull())).andThrow(new RemoteException("Invalid identifier. Not logged in."));
    
    EasyMock.expect(serviceMock.getStateOfExecution(EasyMock.gt((long)0), (ExecutionHandle) EasyMock.notNull())).andReturn(-1);
    ExecutionResult result = createDummyResult();
    EasyMock.expect(serviceMock.getExecutionResult(EasyMock.gt((long)0), (ExecutionHandle)EasyMock.notNull())).andReturn(result);
    
    ITestResultWriter resultWriterMock1 = createTestResultWriterMock(result);
    
    ExecutionHandle handle1 = new ExecutionHandle(2, 100);
    
    ISessionHandler sessionHandlerMock = EasyMock.createStrictMock(ISessionHandler.class);
    EasyMock.expect(sessionHandlerMock.getSessionId(EasyMock.eq(-1l))).andReturn(Long.valueOf(10l));
    EasyMock.expect(sessionHandlerMock.getSessionId(EasyMock.eq(10l))).andReturn(Long.valueOf(20l));
    EasyMock.expect(sessionHandlerMock.getSessionId(EasyMock.eq(-1l))).andReturn(Long.valueOf(20l));
    
    ResultCollectorThread aut1 = new ResultCollectorThread(new PrintStream("test.log"), serviceMock, sessionHandlerMock, handle1, resultWriterMock1);
    aut1.setSleep(1);
    
    EasyMock.replay(serviceMock);
    EasyMock.replay(resultWriterMock1);
    EasyMock.replay(sessionHandlerMock);
    aut1.run();
    EasyMock.verify(serviceMock);
    EasyMock.verify(resultWriterMock1);
    EasyMock.verify(sessionHandlerMock);
  }
  
  private ExecutionResult createDummyResult() {
    TestDefinitionResult cleanUp = new TestDefinitionResult(1, 0, 1, "test", "", 1, 1, 1, 1, 0);
    TestDefinitionResult setup = new TestDefinitionResult(1, 0, 1, "test", "", 1, 1, 1, 1, 0);
    TestDefinitionResult[] results = new TestDefinitionResult[] {
        new TestDefinitionResult(1, 0, 1, "test", "", 1, 1, 1, 1, 0),
        new TestDefinitionResult(1, 0, 1, "test", "", 1, 1, 1, 1, 0)
    };
    ExecutionResult result = new ExecutionResult("test", cleanUp, 10, "testExecDef", "unknown", new String[] {"unknown"}, "", setup, results);
    return result;
  }

  private ExecutionWebService createServiceMock() throws RemoteException {
    ExecutionWebService serviceMock = EasyMock.createStrictMock(ExecutionWebService.class);
    EasyMock.expect(serviceMock.getStateOfExecution(EasyMock.gt((long)0), (ExecutionHandle) EasyMock.notNull())).andReturn(2);
    EasyMock.expectLastCall().andReturn(-1);
    return serviceMock;
  }

  private ITestResultWriter createTestResultWriterMock(ExecutionResult result) {
    ITestResultWriter resultWriterMock = EasyMock.createStrictMock(ITestResultWriter.class);
    resultWriterMock.write(result);
    return resultWriterMock;
  }

}
