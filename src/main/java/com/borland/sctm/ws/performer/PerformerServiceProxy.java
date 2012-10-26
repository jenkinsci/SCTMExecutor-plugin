package com.borland.sctm.ws.performer;

public class PerformerServiceProxy implements com.borland.sctm.ws.performer.PerformerService {
  private String _endpoint = null;
  private com.borland.sctm.ws.performer.PerformerService performerService = null;
  
  public PerformerServiceProxy() {
    _initPerformerServiceProxy();
  }
  
  public PerformerServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initPerformerServiceProxy();
  }
  
  private void _initPerformerServiceProxy() {
    try {
      performerService = (new com.borland.sctm.ws.performer.PerformerServiceServiceLocator()).gettmperformer();
      if (performerService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)performerService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)performerService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (performerService != null)
      ((javax.xml.rpc.Stub)performerService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.borland.sctm.ws.performer.PerformerService getPerformerService() {
    if (performerService == null)
      _initPerformerServiceProxy();
    return performerService;
  }
  
  public com.borland.sctm.ws.performer.SPTestPlanningNode[] getChildNodes(long id, int iParentNodeId) throws java.rmi.RemoteException{
    if (performerService == null)
      _initPerformerServiceProxy();
    return performerService.getChildNodes(id, iParentNodeId);
  }
  
  public boolean removeNode(long id, int nodeId) throws java.rmi.RemoteException{
    if (performerService == null)
      _initPerformerServiceProxy();
    return performerService.removeNode(id, nodeId);
  }
  
  public com.borland.sctm.ws.performer.SPNamedEntity[] getVersions(long id, int iNodeId) throws java.rmi.RemoteException{
    if (performerService == null)
      _initPerformerServiceProxy();
    return performerService.getVersions(id, iNodeId);
  }
  
  public int addNode(long sessionId, int iParentNodeId, com.borland.sctm.ws.performer.SPTestPlanningNode node) throws java.rmi.RemoteException{
    if (performerService == null)
      _initPerformerServiceProxy();
    return performerService.addNode(sessionId, iParentNodeId, node);
  }
  
  public com.borland.sctm.ws.performer.SPNamedEntity[] getBuilds(long id, int iVersionId) throws java.rmi.RemoteException{
    if (performerService == null)
      _initPerformerServiceProxy();
    return performerService.getBuilds(id, iVersionId);
  }
  
  public com.borland.sctm.ws.performer.SPExecution getExecution(long id, int iExecutionId) throws java.rmi.RemoteException{
    if (performerService == null)
      _initPerformerServiceProxy();
    return performerService.getExecution(id, iExecutionId);
  }
  
  public java.lang.String getAgentClustersFile(long sessionId) throws java.rmi.RemoteException{
    if (performerService == null)
      _initPerformerServiceProxy();
    return performerService.getAgentClustersFile(sessionId);
  }
  
  public com.borland.sctm.ws.performer.SPNodeProperty[] getNodeProperties(long id, int iNodeId) throws java.rmi.RemoteException{
    if (performerService == null)
      _initPerformerServiceProxy();
    return performerService.getNodeProperties(id, iNodeId);
  }
  
  public com.borland.sctm.ws.performer.SPTestPlanningNode[] getNodePath(long id, int nodeId) throws java.rmi.RemoteException{
    if (performerService == null)
      _initPerformerServiceProxy();
    return performerService.getNodePath(id, nodeId);
  }
  
  public com.borland.sctm.ws.performer.SPNamedEntity[] getTestPlanningFilters(long id, int iProjectId) throws java.rmi.RemoteException{
    if (performerService == null)
      _initPerformerServiceProxy();
    return performerService.getTestPlanningFilters(id, iProjectId);
  }
  
  public boolean updateNode(long sessionId, com.borland.sctm.ws.performer.SPTestPlanningNode node) throws java.rmi.RemoteException{
    if (performerService == null)
      _initPerformerServiceProxy();
    return performerService.updateNode(sessionId, node);
  }
  
  public com.borland.sctm.ws.performer.SPExecution[] getExecutions(long id, int iTestDefId, int iFilterId) throws java.rmi.RemoteException{
    if (performerService == null)
      _initPerformerServiceProxy();
    return performerService.getExecutions(id, iTestDefId, iFilterId);
  }
  
  public com.borland.sctm.ws.performer.SPNodeProperty[] getExecutionNodeProperties(long id, int executionId) throws java.rmi.RemoteException{
    if (performerService == null)
      _initPerformerServiceProxy();
    return performerService.getExecutionNodeProperties(id, executionId);
  }
  
  public com.borland.sctm.ws.performer.SPSuccessMeasure[] getExecutionSuccessMeasures(long id, int executionId) throws java.rmi.RemoteException{
    if (performerService == null)
      _initPerformerServiceProxy();
    return performerService.getExecutionSuccessMeasures(id, executionId);
  }
  
  public java.lang.String[] getExecutionInfos(long id, int executionId) throws java.rmi.RemoteException{
    if (performerService == null)
      _initPerformerServiceProxy();
    return performerService.getExecutionInfos(id, executionId);
  }
  
  public com.borland.sctm.ws.performer.SPNamedEntity[] getExecutionFiles(long id, int executionId) throws java.rmi.RemoteException{
    if (performerService == null)
      _initPerformerServiceProxy();
    return performerService.getExecutionFiles(id, executionId);
  }
  
  public int addExecution(long id, com.borland.sctm.ws.performer.SPExecution execution) throws java.rmi.RemoteException{
    if (performerService == null)
      _initPerformerServiceProxy();
    return performerService.addExecution(id, execution);
  }
  
  public boolean removeExecution(long id, int executionId) throws java.rmi.RemoteException{
    if (performerService == null)
      _initPerformerServiceProxy();
    return performerService.removeExecution(id, executionId);
  }
  
  public com.borland.sctm.ws.performer.SPSourceControlInfo getSourceControlInfo(long id, int testDefID) throws java.rmi.RemoteException{
    if (performerService == null)
      _initPerformerServiceProxy();
    return performerService.getSourceControlInfo(id, testDefID);
  }
  
  
}