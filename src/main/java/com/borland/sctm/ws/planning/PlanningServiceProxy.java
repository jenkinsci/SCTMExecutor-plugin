package com.borland.sctm.ws.planning;

public class PlanningServiceProxy implements com.borland.sctm.ws.planning.PlanningService {
  private String _endpoint = null;
  private com.borland.sctm.ws.planning.PlanningService planningService = null;
  
  public PlanningServiceProxy() {
    _initPlanningServiceProxy();
  }
  
  public PlanningServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initPlanningServiceProxy();
  }
  
  private void _initPlanningServiceProxy() {
    try {
      planningService = (new com.borland.sctm.ws.planning.PlanningServiceServiceLocator()).gettmplanning();
      if (planningService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)planningService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)planningService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (planningService != null)
      ((javax.xml.rpc.Stub)planningService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.borland.sctm.ws.planning.PlanningService getPlanningService() {
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService;
  }
  
  public com.borland.sctm.ws.planning.entities.PropertyValue getProperty(long sessionId, java.lang.String nodeId, java.lang.String propertyId) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.getProperty(sessionId, nodeId, propertyId);
  }
  
  public com.borland.sctm.ws.planning.entities.Attribute[] getAttributes(long sessionId, int projectId) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.getAttributes(sessionId, projectId);
  }
  
  public com.borland.sctm.ws.planning.entities.Attribute[] updateAttributes(long sessionId, int projectId, com.borland.sctm.ws.planning.entities.Attribute[] attributes) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.updateAttributes(sessionId, projectId, attributes);
  }
  
  public long login(java.util.HashMap loginProperties) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.login(loginProperties);
  }
  
  public com.borland.sctm.ws.planning.entities.Project getProject(long sessionId, java.lang.String projectId) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.getProject(sessionId, projectId);
  }
  
  public com.borland.sctm.ws.planning.entities.TestPlanningNode[] getChildNodes(long id, int projectId, int parentNodeId, com.borland.sctm.ws.planning.entities.NodeFilter filter) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.getChildNodes(id, projectId, parentNodeId, filter);
  }
  
  public com.borland.sctm.ws.planning.entities.PropertyMetaInfo getPropertyInfo(long sessionId, java.lang.String nodeTypeId, java.lang.String propertyId) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.getPropertyInfo(sessionId, nodeTypeId, propertyId);
  }
  
  public com.borland.sctm.ws.planning.entities.Project[] getProjects(long sessionId) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.getProjects(sessionId);
  }
  
  public com.borland.sctm.ws.planning.entities.TestPlanningNode getNode(long sessionId, java.lang.String nodeId) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.getNode(sessionId, nodeId);
  }
  
  public int addNode(long id, int parentNodeId, com.borland.sctm.ws.planning.entities.TestPlanningNode node, boolean throwErrorOnDuplicate) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.addNode(id, parentNodeId, node, throwErrorOnDuplicate);
  }
  
  public boolean updateProperties(long sessionId, com.borland.sctm.ws.planning.entities.PropertyValue[] properties) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.updateProperties(sessionId, properties);
  }
  
  public com.borland.sctm.ws.planning.entities.NamedEntity[] getTestContainers(long id, int projectId) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.getTestContainers(id, projectId);
  }
  
  public int createTestPackage(long sessionId, int packageParentNodeId, java.lang.String xmlPackage) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.createTestPackage(sessionId, packageParentNodeId, xmlPackage);
  }
  
  public void updateTestPackage(long sessionId, int packageNodeId, java.lang.String xmlPackage) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    planningService.updateTestPackage(sessionId, packageNodeId, xmlPackage);
  }
  
  public void uploadTestPackageResult(long sessionId, int packageNodeId, java.lang.String xmlPackage) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    planningService.uploadTestPackageResult(sessionId, packageNodeId, xmlPackage);
  }
  
  public void deleteAttributeOptions(long sessionId, int projectId, java.lang.String attributeName, com.borland.sctm.ws.planning.entities.AttributeOption[] options) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    planningService.deleteAttributeOptions(sessionId, projectId, attributeName, options);
  }
  
  public void addAttributeOptions(long sessionId, int projectId, java.lang.String attributeName, com.borland.sctm.ws.planning.entities.AttributeOption[] options) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    planningService.addAttributeOptions(sessionId, projectId, attributeName, options);
  }
  
  public com.borland.sctm.ws.planning.entities.Attribute[] addAttributes(long sessionId, int projectId, com.borland.sctm.ws.planning.entities.Attribute[] attributes) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.addAttributes(sessionId, projectId, attributes);
  }
  
  public void deleteAttributes(long sessionId, int projectId, com.borland.sctm.ws.planning.entities.Attribute[] attributes) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    planningService.deleteAttributes(sessionId, projectId, attributes);
  }
  
  public com.borland.sctm.ws.planning.entities.TestDefinitionResult[] getExecutionResult(long sessionId, int executionDefId, long executionTimestamp, java.lang.String execServerHostName, int execServerPort) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.getExecutionResult(sessionId, executionDefId, executionTimestamp, execServerHostName, execServerPort);
  }
  
  public boolean deleteNode(long id, int nodeId) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.deleteNode(id, nodeId);
  }
  
  public boolean updateNode(long sessionId, com.borland.sctm.ws.planning.entities.TestPlanningNode node) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.updateNode(sessionId, node);
  }
  
  public com.borland.sctm.ws.planning.entities.Project getCurrentProject(long sessionId) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.getCurrentProject(sessionId);
  }
  
  public void setCurrentProject(long sessionId, java.lang.String projectId) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    planningService.setCurrentProject(sessionId, projectId);
  }
  
  public boolean uploadTestPlan(long sessionId, int projectId, java.lang.String content) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.uploadTestPlan(sessionId, projectId, content);
  }
  
  public int addManualTest(long id, int testContainerId, java.lang.String name, java.lang.String description, com.borland.sctm.ws.planning.entities.ManualTestStep[] steps, com.borland.sctm.ws.planning.entities.NodeParameter[] params) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.addManualTest(id, testContainerId, name, description, steps, params);
  }
  
  public com.borland.sctm.ws.planning.entities.ManualTestStep[] getManualTestSteps(long sessionId, int testId) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.getManualTestSteps(sessionId, testId);
  }
  
  public void deleteManualTestStep(long sessionId, int testId, int stepPos) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    planningService.deleteManualTestStep(sessionId, testId, stepPos);
  }
  
  public void addManualTestStep(long sessionId, int testId, com.borland.sctm.ws.planning.entities.ManualTestStep step) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    planningService.addManualTestStep(sessionId, testId, step);
  }
  
  public void updateManualTestStep(long sessionId, int testId, com.borland.sctm.ws.planning.entities.ManualTestStep step) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    planningService.updateManualTestStep(sessionId, testId, step);
  }
  
  public com.borland.sctm.ws.planning.entities.CustomStepProperty[] getCustomStepPropertyNames(long id, int projectId) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.getCustomStepPropertyNames(id, projectId);
  }
  
  public int addCustomStepProperty(long id, int projectId, int sequenceID, java.lang.String propertyName) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.addCustomStepProperty(id, projectId, sequenceID, propertyName);
  }
  
  public int deleteCustomStepProperty(long id, int projectId, int propertyId) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.deleteCustomStepProperty(id, projectId, propertyId);
  }
  
  public boolean deleteProperty(long sessionId, com.borland.sctm.ws.planning.entities.PropertyValue property) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.deleteProperty(sessionId, property);
  }
  
  public java.lang.String getExecutionResultURL(long sessionId, int executionDefId, long executionTimestamp, java.lang.String execServerHostName, int execServerPort) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.getExecutionResultURL(sessionId, executionDefId, executionTimestamp, execServerHostName, execServerPort);
  }
  
  public long queueExecution(long sessionId, int executionDefId, java.lang.String version, java.lang.String build, java.lang.String execServerHostName, int execServerPort, java.util.HashMap runProperties) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.queueExecution(sessionId, executionDefId, version, build, execServerHostName, execServerPort, runProperties);
  }
  
  public boolean startExecution(long sessionId, int executionDefId, java.lang.String version, java.lang.String build, java.lang.String execServerHostName, int execServerPort) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.startExecution(sessionId, executionDefId, version, build, execServerHostName, execServerPort);
  }
  
  public java.lang.String[] getPropertyIds(long sessionId) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.getPropertyIds(sessionId);
  }
  
  public java.lang.String[] getPropertyIds(long sessionId, java.lang.String nodeTypeId, java.lang.String propertyTypeId) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.getPropertyIds(sessionId, nodeTypeId, propertyTypeId);
  }
  
  public boolean updatePropertyValue(long sessionId, int nodeId, java.lang.String propertyName, java.lang.String propertyValue) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.updatePropertyValue(sessionId, nodeId, propertyName, propertyValue);
  }
  
  public boolean updateProperty(long sessionId, com.borland.sctm.ws.planning.entities.PropertyValue property) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.updateProperty(sessionId, property);
  }
  
  public java.lang.String[] getNodeTypeIds(long sessionId) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.getNodeTypeIds(sessionId);
  }
  
  public java.lang.String[] getNodeIds(long sessionId, com.borland.sctm.ws.planning.entities.PropertyValue property) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.getNodeIds(sessionId, property);
  }
  
  public java.lang.String[] getPropertyTypeIds(long sessionId, java.lang.String nodeTypeId) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.getPropertyTypeIds(sessionId, nodeTypeId);
  }
  
  public com.borland.sctm.ws.planning.entities.DataSet[] getDataSetForDataSource(long sessionId, int dataSourceId) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.getDataSetForDataSource(sessionId, dataSourceId);
  }
  
  public com.borland.sctm.ws.planning.entities.DataSource[] getDataSourcesForProject(long sessionId, java.lang.String projectId) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.getDataSourcesForProject(sessionId, projectId);
  }
  
  public int getIntegrationDefaultFolderId(long sessionId, int projectId) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    return planningService.getIntegrationDefaultFolderId(sessionId, projectId);
  }
  
  public void setIntegrationDefaultFolder(long sessionId, int projectId, int folderId) throws java.rmi.RemoteException{
    if (planningService == null)
      _initPlanningServiceProxy();
    planningService.setIntegrationDefaultFolder(sessionId, projectId, folderId);
  }
  
  
}