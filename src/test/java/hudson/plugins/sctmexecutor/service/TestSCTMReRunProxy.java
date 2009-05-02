package hudson.plugins.sctmexecutor.service;

import static org.junit.Assert.*;

import java.util.ArrayList;

import hudson.plugins.sctmexecutor.exceptions.SCTMException;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.borland.tm.webservices.tmexecution.ExecutionHandle;
import com.borland.tm.webservices.tmexecution.ExecutionResult;

public class TestSCTMReRunProxy {
  
  private ISCTMService proxy;
  private ISCTMService mockService;

  @Before
  public void setUp() throws Exception {
    mockService = EasyMock.createStrictMock(ISCTMService.class);
    proxy = new SCTMReRunProxy(mockService);
  }

  @After
  public void tearDown() throws Exception {
    EasyMock.verify(mockService);
    proxy = null;
    mockService = null;
  }

  @Test
  public void testGetExecutionResult() throws SCTMException {
    EasyMock.expect(mockService.getExecutionResult((ExecutionHandle)EasyMock.notNull())).andThrow(new SCTMException(""));
    EasyMock.expectLastCall().andThrow(new SCTMException(""));
    EasyMock.expectLastCall().andReturn(new ExecutionResult());   
    EasyMock.replay(mockService);
    assertNotNull(proxy.getExecutionResult(new ExecutionHandle()));
    EasyMock.verify(mockService);
  }
  
  @Test(expected=SCTMException.class)
  public void testGetExecutionResultReRunFailed() throws SCTMException {
    EasyMock.expect(mockService.getExecutionResult((ExecutionHandle)EasyMock.notNull())).andThrow(new SCTMException(""));
    for (int i=0; i<SCTMReRunProxy.MAXRERUN; i++)
      EasyMock.expectLastCall().andThrow(new SCTMException(""));
    
    EasyMock.replay(mockService);
    assertNotNull(proxy.getExecutionResult(new ExecutionHandle()));
  }

  @Test
  public void testIsFinished() throws SCTMException {
    EasyMock.expect(mockService.isFinished((ExecutionHandle)EasyMock.notNull())).andThrow(new SCTMException(""));
    EasyMock.expectLastCall().andThrow(new SCTMException(""));
    EasyMock.expectLastCall().andReturn(true);
    EasyMock.replay(mockService);
    assertTrue(proxy.isFinished(new ExecutionHandle()));
  }
  
  @Test(expected=SCTMException.class)
  public void testIsFinishedReRunFailed() throws SCTMException {
    EasyMock.expect(mockService.isFinished((ExecutionHandle)EasyMock.notNull())).andThrow(new SCTMException(""));
    for (int i=0; i<SCTMReRunProxy.MAXRERUN; i++)
      EasyMock.expectLastCall().andThrow(new SCTMException(""));
    
    EasyMock.replay(mockService);
    assertTrue(proxy.isFinished(new ExecutionHandle()));
  }

  @Test
  public void testStartInt() throws SCTMException {
    EasyMock.expect(mockService.start((Integer)EasyMock.gt(0))).andThrow(new SCTMException(""));
    EasyMock.expectLastCall().andThrow(new SCTMException(""));
    EasyMock.expectLastCall().andReturn(new ArrayList<ExecutionHandle>());
    EasyMock.replay(mockService);
    assertNotNull(proxy.start(12345));
  }
  
  @Test(expected=SCTMException.class)
  public void testStartIntReRunFailed() throws SCTMException {
    EasyMock.expect(mockService.start((Integer)EasyMock.gt(0))).andThrow(new SCTMException(""));
    for (int i=0; i<SCTMReRunProxy.MAXRERUN; i++)
      EasyMock.expectLastCall().andThrow(new SCTMException(""));

    EasyMock.replay(mockService);
    assertNotNull(proxy.start(12345));
  }

  @Test
  public void testStartIntString() throws SCTMException {
    EasyMock.expect(mockService.start((Integer)EasyMock.gt(0), (String)EasyMock.notNull())).andThrow(new SCTMException(""));
    EasyMock.expectLastCall().andThrow(new SCTMException(""));
    EasyMock.expectLastCall().andReturn(new ArrayList<ExecutionHandle>());
    EasyMock.replay(mockService);
    assertNotNull(proxy.start(12345, ""));
  }
  
  @Test(expected=SCTMException.class)
  public void testStartIntStringReRunFailed() throws SCTMException {
    EasyMock.expect(mockService.start((Integer)EasyMock.gt(0), (String)EasyMock.notNull())).andThrow(new SCTMException(""));
    for (int i=0; i<SCTMReRunProxy.MAXRERUN; i++)
      EasyMock.expectLastCall().andThrow(new SCTMException(""));

    EasyMock.replay(mockService);
    assertNotNull(proxy.start(12345, ""));
  }

}
