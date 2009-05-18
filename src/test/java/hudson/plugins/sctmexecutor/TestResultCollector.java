package hudson.plugins.sctmexecutor;

import static org.junit.Assert.assertTrue;

import hudson.plugins.sctmexecutor.exceptions.SCTMException;
import hudson.plugins.sctmexecutor.service.ISCTMService;

import java.io.FileNotFoundException;
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
  public void collectingResults() throws SCTMException, FileNotFoundException {
    ISCTMService serviceMock = createServiceMock();
    ExecutionResult result = createDummyResult();
    EasyMock.expect(serviceMock.getExecutionResult((ExecutionHandle)EasyMock.notNull())).andReturn(result);
    
    ITestResultWriter resultWriterMock = EasyMock.createStrictMock(ITestResultWriter.class);
    resultWriterMock.write(result);
    
    ExecutionHandle handle = new ExecutionHandle(2, 100);
    
    ExecutionRunnable aut = new ExecutionRunnable(serviceMock, new PrintStream("test.log"), handle, resultWriterMock);
    aut.setSleep(1);
    
    EasyMock.replay(serviceMock);
    EasyMock.replay(resultWriterMock);
    aut.run();
    EasyMock.verify(serviceMock);
    EasyMock.verify(resultWriterMock);
  }
  
  @Test
  public void runCollectorThread() throws SCTMException, FileNotFoundException {
    ISCTMService serviceMock = EasyMock.createStrictMock(ISCTMService.class);
    EasyMock.expect(serviceMock.isFinished((ExecutionHandle) EasyMock.notNull())).andReturn(false);
    EasyMock.expectLastCall().times(2).andReturn(false);
    EasyMock.expectLastCall().andReturn(true);
    ExecutionResult result = createDummyResult();
    EasyMock.expect(serviceMock.getExecutionResult((ExecutionHandle)EasyMock.notNull())).andReturn(result);
    
    ITestResultWriter resultWriterMock = EasyMock.createStrictMock(ITestResultWriter.class);
    resultWriterMock.write(result);
    
    ExecutionHandle handle = new ExecutionHandle(2, 100);
    
    ExecutionRunnable aut = new ExecutionRunnable(serviceMock, new PrintStream("test.log"), handle, resultWriterMock);
    aut.setSleep(1);
    
    EasyMock.replay(serviceMock);
    EasyMock.replay(resultWriterMock);
    long start = System.currentTimeMillis();
    aut.run();
    long duration = (System.currentTimeMillis()-start)/1000;
    assertTrue(duration > 8 && duration < 16);
    EasyMock.verify(serviceMock);
    EasyMock.verify(resultWriterMock);
  }
  
  @Test(expected=RuntimeException.class)
  public void testBadRun() throws Exception {
    ISCTMService serviceMock = EasyMock.createStrictMock(ISCTMService.class);
    EasyMock.expect(serviceMock.isFinished((ExecutionHandle) EasyMock.notNull())).andThrow(new RemoteException());
    
    ExecutionHandle handle = new ExecutionHandle(2, 100);
    
    ExecutionRunnable aut = new ExecutionRunnable(serviceMock, new PrintStream("test.log"), handle, null);
    aut.setSleep(1);
    
    EasyMock.replay(serviceMock);
    aut.run();
    EasyMock.verify(serviceMock);
  }
  
  @Test(expected=RuntimeException.class)
  public void testBadResult() throws Exception {
    ISCTMService serviceMock = createServiceMock();
    EasyMock.expect(serviceMock.getExecutionResult((ExecutionHandle)EasyMock.notNull())).andThrow(new RemoteException());
    EasyMock.expect(serviceMock.isFinished((ExecutionHandle) EasyMock.notNull())).andReturn(true);
    EasyMock.expect(serviceMock.getExecutionResult((ExecutionHandle)EasyMock.notNull())).andThrow(new RemoteException());
    EasyMock.expect(serviceMock.isFinished((ExecutionHandle) EasyMock.notNull())).andReturn(true);
    EasyMock.expect(serviceMock.getExecutionResult((ExecutionHandle)EasyMock.notNull())).andThrow(new RemoteException());
    
    ExecutionHandle handle = new ExecutionHandle(2, 100);
    
    ExecutionRunnable aut = new ExecutionRunnable(serviceMock, new PrintStream("test.log"), handle, null);
    aut.setSleep(1);
    
    EasyMock.replay(serviceMock);
    aut.run();
    EasyMock.verify(serviceMock);
  }
  
  @Test
  public void testLostExecutionResult() throws Exception {
    ISCTMService serviceMock = createServiceMock();
    EasyMock.expect(serviceMock.getExecutionResult((ExecutionHandle)EasyMock.notNull())).andThrow(new SCTMException("dfdsf"));
    EasyMock.expect(serviceMock.isFinished((ExecutionHandle) EasyMock.notNull())).andReturn(true);
    
    ExecutionResult result = createDummyResult();
    EasyMock.expect(serviceMock.getExecutionResult((ExecutionHandle)EasyMock.notNull())).andReturn(result);
    
    ITestResultWriter resultWriterMock1 = createTestResultWriterMock(result);
    
    ExecutionHandle handle1 = new ExecutionHandle(2, 100);
    
    ExecutionRunnable aut1 = new ExecutionRunnable(serviceMock, new PrintStream("test.log"), handle1, resultWriterMock1);
    aut1.setSleep(1);
    
    EasyMock.replay(serviceMock);
    EasyMock.replay(resultWriterMock1);
    aut1.run();
    EasyMock.verify(serviceMock);
    EasyMock.verify(resultWriterMock1);
  }
  
  @Test
  public void testBadLostExecutionResult() throws Exception {
    ISCTMService serviceMock = createServiceMock();
    EasyMock.expect(serviceMock.getExecutionResult((ExecutionHandle)EasyMock.notNull())).andThrow(new SCTMException("dfdsf"));
    EasyMock.expect(serviceMock.isFinished((ExecutionHandle) EasyMock.notNull())).andReturn(true);
    EasyMock.expect(serviceMock.getExecutionResult((ExecutionHandle)EasyMock.notNull())).andThrow(new SCTMException("dfdsf"));
    EasyMock.expect(serviceMock.isFinished((ExecutionHandle) EasyMock.notNull())).andReturn(true);
    EasyMock.expect(serviceMock.getExecutionResult((ExecutionHandle)EasyMock.notNull())).andThrow(new SCTMException("dfdsf"));
    
    ITestResultWriter resultWriterMock1 = EasyMock.createStrictMock(ITestResultWriter.class);
    ExecutionHandle handle1 = new ExecutionHandle(2, 100);
    ExecutionRunnable aut1 = new ExecutionRunnable(serviceMock, new PrintStream("test.log"), handle1, resultWriterMock1);
    aut1.setSleep(1);
    
    EasyMock.replay(serviceMock);
    EasyMock.replay(resultWriterMock1);
    aut1.run();
    EasyMock.verify(serviceMock);
    EasyMock.verify(resultWriterMock1);
  }
  
  @Test
  public void testLostSession() throws Exception {
    ISCTMService serviceMock = EasyMock.createStrictMock(ISCTMService.class);
    EasyMock.expect(serviceMock.isFinished((ExecutionHandle) EasyMock.notNull())).andThrow(new SCTMException("Logon failed."));
    ITestResultWriter resultWriterMock1 = EasyMock.createStrictMock(ITestResultWriter.class);
    ExecutionHandle handle1 = new ExecutionHandle(2, 100);
    ExecutionRunnable aut1 = new ExecutionRunnable(serviceMock, new PrintStream("test.log"), handle1, resultWriterMock1);
    aut1.setSleep(1);
    
    EasyMock.replay(serviceMock);
    EasyMock.replay(resultWriterMock1);
    aut1.run();
    EasyMock.verify(serviceMock);
    EasyMock.verify(resultWriterMock1);
  }
  
  @Test
  public void testLostSession2() throws Exception {
    ISCTMService serviceMock = EasyMock.createStrictMock(ISCTMService.class);
    EasyMock.expect(serviceMock.isFinished((ExecutionHandle) EasyMock.notNull())).andReturn(true);
    EasyMock.expect(serviceMock.getExecutionResult((ExecutionHandle)EasyMock.notNull())).andThrow(new SCTMException("Logon failed."));
    ITestResultWriter resultWriterMock1 = EasyMock.createStrictMock(ITestResultWriter.class);
    ExecutionHandle handle1 = new ExecutionHandle(2, 100);
    ExecutionRunnable aut1 = new ExecutionRunnable(serviceMock, new PrintStream("test.log"), handle1, resultWriterMock1);
    aut1.setSleep(1);
    
    EasyMock.replay(serviceMock);
    EasyMock.replay(resultWriterMock1);
    aut1.run();
    EasyMock.verify(serviceMock);
    EasyMock.verify(resultWriterMock1);
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

  private ISCTMService createServiceMock() throws SCTMException {
    ISCTMService serviceMock = EasyMock.createStrictMock(ISCTMService.class);
    EasyMock.expect(serviceMock.isFinished((ExecutionHandle) EasyMock.notNull())).andReturn(false);
    EasyMock.expectLastCall().andReturn(true);
    return serviceMock;
  }

  private ITestResultWriter createTestResultWriterMock(ExecutionResult result) {
    ITestResultWriter resultWriterMock = EasyMock.createStrictMock(ITestResultWriter.class);
    resultWriterMock.write(result);
    return resultWriterMock;
  }

}
