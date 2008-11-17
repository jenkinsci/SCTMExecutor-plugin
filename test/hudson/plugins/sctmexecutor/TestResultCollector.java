package hudson.plugins.sctmexecutor;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Test;

import com.borland.tm.webservices.tmexecution.ExecutionHandle;
import com.borland.tm.webservices.tmexecution.ExecutionResult;
import com.borland.tm.webservices.tmexecution.ExecutionWebService;
import com.borland.tm.webservices.tmexecution.TestDefinitionResult;

public class TestResultCollector {
  
  @Test
  public void testRun() throws RemoteException {
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
    
    List<ExecutionHandle> handles = new ArrayList<ExecutionHandle>();
    handles.add(new ExecutionHandle(2, 100));
    
    ResultCollectorThread aut = new ResultCollectorThread("test", serviceMock, 10, handles);
    aut.setSleep(1);
    
    EasyMock.replay(serviceMock);
    
    assertFalse(aut.isFinished());
    aut.run();
    assertTrue(aut.isFinished());
    
    EasyMock.verify(serviceMock);
  }
  
  @Test(expected=RuntimeException.class)
  public void testBadRun() throws Exception {
    ExecutionWebService serviceMock = EasyMock.createStrictMock(ExecutionWebService.class);
    EasyMock.expect(serviceMock.getStateOfExecution(EasyMock.gt((long)1), (ExecutionHandle) EasyMock.notNull())).andThrow(new RemoteException());
    
    List<ExecutionHandle> handles = new ArrayList<ExecutionHandle>();
    handles.add(new ExecutionHandle(2, 100));
    
    ResultCollectorThread aut = new ResultCollectorThread("test", serviceMock, 10, handles);
    aut.setSleep(1);
    
    EasyMock.replay(serviceMock);
    
    assertFalse(aut.isFinished());
    aut.run();
    
    EasyMock.verify(serviceMock);
  }

}
