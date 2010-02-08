package com.borland.sctm.ws.execution;

public class ExecutionWebServiceProxy implements com.borland.sctm.ws.execution.ExecutionWebService {
  private String _endpoint = null;
  private com.borland.sctm.ws.execution.ExecutionWebService executionWebService = null;
  
  public ExecutionWebServiceProxy() {
    _initExecutionWebServiceProxy();
  }
  
  public ExecutionWebServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initExecutionWebServiceProxy();
  }
  
  private void _initExecutionWebServiceProxy() {
    try {
      executionWebService = (new com.borland.sctm.ws.execution.ExecutionWebServiceServiceLocator()).gettmexecution();
      if (executionWebService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)executionWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)executionWebService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (executionWebService != null)
      ((javax.xml.rpc.Stub)executionWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.borland.sctm.ws.execution.ExecutionWebService getExecutionWebService() {
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    return executionWebService;
  }
  
  public com.borland.sctm.ws.execution.entities.ExecutionNode[] getChildNodes(long sessionId, int parentNodeId) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    return executionWebService.getChildNodes(sessionId, parentNodeId);
  }
  
  public com.borland.sctm.ws.execution.entities.PropertyMetaInfo getPropertyInfo(long sessionId, int kind, java.lang.String id) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    return executionWebService.getPropertyInfo(sessionId, kind, id);
  }
  
  public com.borland.sctm.ws.execution.entities.ExecutionNode getNode(long sessionId, int nodeId) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    return executionWebService.getNode(sessionId, nodeId);
  }
  
  public int addNode(long sessionId, com.borland.sctm.ws.execution.entities.ExecutionNode node, int parentId) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    return executionWebService.addNode(sessionId, node, parentId);
  }
  
  public com.borland.sctm.ws.execution.entities.ExecutionNode[] getNodes(long sessionId, java.lang.String name) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    return executionWebService.getNodes(sessionId, name);
  }
  
  public com.borland.sctm.ws.execution.entities.ExecutionResult getExecutionResult(long sessionId, com.borland.sctm.ws.execution.entities.ExecutionHandle handle) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    return executionWebService.getExecutionResult(sessionId, handle);
  }
  
  public com.borland.sctm.ws.execution.entities.ManualTester[] getManualTesters(long sessionId, int projectId) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    return executionWebService.getManualTesters(sessionId, projectId);
  }
  
  public void deleteNode(long sessionId, int nodeId) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    executionWebService.deleteNode(sessionId, nodeId);
  }
  
  public int getSetupTestDefinition(long sessionId, int execDefnId) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    return executionWebService.getSetupTestDefinition(sessionId, execDefnId);
  }
  
  public void setSetupTestDefinition(long sessionId, int execDefnId, int testDefnId) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    executionWebService.setSetupTestDefinition(sessionId, execDefnId, testDefnId);
  }
  
  public int getCleanupTestDefinition(long sessionId, int execDefnId) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    return executionWebService.getCleanupTestDefinition(sessionId, execDefnId);
  }
  
  public void setCleanupTestDefinition(long sessionId, int execDefnId, int testDefnId) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    executionWebService.setCleanupTestDefinition(sessionId, execDefnId, testDefnId);
  }
  
  public void updateNode(long sessionId, com.borland.sctm.ws.execution.entities.ExecutionNode node) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    executionWebService.updateNode(sessionId, node);
  }
  
  public int getCurrentProject(long sessionId) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    return executionWebService.getCurrentProject(sessionId);
  }
  
  public void setCurrentProject(long sessionId, int projectId) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    executionWebService.setCurrentProject(sessionId, projectId);
  }
  
  public com.borland.sctm.ws.execution.entities.ExecutionHandle[] startExecution(long sessionId, int nodeId) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    return executionWebService.startExecution(sessionId, nodeId);
  }
  
  public com.borland.sctm.ws.execution.entities.ExecutionHandle[] startExecution(long sessionId, int nodeId, java.lang.String build, int option, java.lang.String sinceBuild) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    return executionWebService.startExecution(sessionId, nodeId, build, option, sinceBuild);
  }
  
  public java.lang.String[] getPropertyIds(long sessionId, int kind) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    return executionWebService.getPropertyIds(sessionId, kind);
  }
  
  public com.borland.sctm.ws.execution.entities.ExecutionNode getExecutionRootNode(long sessionId, int projectId) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    return executionWebService.getExecutionRootNode(sessionId, projectId);
  }
  
  public int getStateOfExecution(long sessionId, com.borland.sctm.ws.execution.entities.ExecutionHandle handle) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    return executionWebService.getStateOfExecution(sessionId, handle);
  }
  
  
}