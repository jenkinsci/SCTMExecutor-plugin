package com.borland.tm.webservices.tmexecution;

public class ExecutionWebServiceProxy implements com.borland.tm.webservices.tmexecution.ExecutionWebService {
  private String _endpoint = null;
  private com.borland.tm.webservices.tmexecution.ExecutionWebService executionWebService = null;
  
  public ExecutionWebServiceProxy() {
    _initExecutionWebServiceProxy();
  }
  
  public ExecutionWebServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initExecutionWebServiceProxy();
  }
  
  private void _initExecutionWebServiceProxy() {
    try {
      executionWebService = (new com.borland.tm.webservices.tmexecution.ExecutionWebServiceServiceLocator()).gettmexecution();
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
  
  public com.borland.tm.webservices.tmexecution.ExecutionWebService getExecutionWebService() {
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    return executionWebService;
  }
  
  public com.borland.tm.webservices.tmexecution.ExecutionNode[] getChildNodes(long sessionId, int parentNodeId) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    return executionWebService.getChildNodes(sessionId, parentNodeId);
  }
  
  public com.borland.tm.webservices.tmexecution.ExecutionNode getNode(long sessionId, int nodeId) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    return executionWebService.getNode(sessionId, nodeId);
  }
  
  public int addNode(long sessionId, com.borland.tm.webservices.tmexecution.ExecutionNode node, int parentId) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    return executionWebService.addNode(sessionId, node, parentId);
  }
  
  public com.borland.tm.webservices.tmexecution.PropertyMetaInfo getPropertyInfo(long sessionId, int kind, java.lang.String id) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    return executionWebService.getPropertyInfo(sessionId, kind, id);
  }
  
  public com.borland.tm.webservices.tmexecution.ExecutionResult getExecutionResult(long sessionId, com.borland.tm.webservices.tmexecution.ExecutionHandle handle) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    return executionWebService.getExecutionResult(sessionId, handle);
  }
  
  public void deleteNode(long sessionId, int nodeId) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    executionWebService.deleteNode(sessionId, nodeId);
  }
  
  public void updateNode(long sessionId, com.borland.tm.webservices.tmexecution.ExecutionNode node) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    executionWebService.updateNode(sessionId, node);
  }
  
  public java.lang.String[] getPropertyIds(long sessionId, int kind) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    return executionWebService.getPropertyIds(sessionId, kind);
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
  
  public com.borland.tm.webservices.tmexecution.ExecutionNode getExecutionRootNode(long sessionId, int projectId) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    return executionWebService.getExecutionRootNode(sessionId, projectId);
  }
  
  public com.borland.tm.webservices.tmexecution.ExecutionNode[] getNodes(long sessionId, java.lang.String name) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    return executionWebService.getNodes(sessionId, name);
  }
  
  public int getStateOfExecution(long sessionId, com.borland.tm.webservices.tmexecution.ExecutionHandle handle) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    return executionWebService.getStateOfExecution(sessionId, handle);
  }
  
  public com.borland.tm.webservices.tmexecution.ExecutionHandle[] startExecution(long sessionId, int nodeId, java.lang.String build, int option, java.lang.String sinceBuild) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    return executionWebService.startExecution(sessionId, nodeId, build, option, sinceBuild);
  }
  
  public com.borland.tm.webservices.tmexecution.ExecutionHandle[] startExecution(long sessionId, int nodeId) throws java.rmi.RemoteException{
    if (executionWebService == null)
      _initExecutionWebServiceProxy();
    return executionWebService.startExecution(sessionId, nodeId);
  }
  
  
}