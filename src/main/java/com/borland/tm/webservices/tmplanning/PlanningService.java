/**
 * PlanningService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.tm.webservices.tmplanning;

public interface PlanningService extends java.rmi.Remote {
    public com.borland.tm.webservices.tmplanning.entities.PropertyValue getProperty(long sessionId, java.lang.String nodeId, java.lang.String propertyId) throws java.rmi.RemoteException;
    public long login(java.util.HashMap loginProperties) throws java.rmi.RemoteException;
    public com.borland.tm.webservices.tmplanning.entities.TestPlanningNode[] getChildNodes(long id, int projectId, int parentNodeId, com.borland.tm.webservices.tmplanning.entities.NodeFilter filter) throws java.rmi.RemoteException;
    public com.borland.tm.webservices.tmplanning.entities.TestPlanningNode getNode(long sessionId, java.lang.String nodeId) throws java.rmi.RemoteException;
    public int addNode(long id, int parentNodeId, com.borland.tm.webservices.tmplanning.entities.TestPlanningNode node, boolean throwErrorOnDuplicate) throws java.rmi.RemoteException;
    public com.borland.tm.webservices.tmplanning.entities.NamedEntity[] getTestContainers(long id, int projectId) throws java.rmi.RemoteException;
    public boolean updateProperties(long sessionId, com.borland.tm.webservices.tmplanning.entities.PropertyValue[] properties) throws java.rmi.RemoteException;
    public com.borland.tm.webservices.tmplanning.entities.Project getProject(long sessionId, java.lang.String projectId) throws java.rmi.RemoteException;
    public com.borland.tm.webservices.tmplanning.entities.PropertyMetaInfo getPropertyInfo(long sessionId, java.lang.String nodeTypeId, java.lang.String propertyId) throws java.rmi.RemoteException;
    public com.borland.tm.webservices.tmplanning.entities.Project[] getProjects(long sessionId) throws java.rmi.RemoteException;
    public int createTestPackage(long sessionId, int packageParentNodeId, java.lang.String xmlPackage) throws java.rmi.RemoteException;
    public void updateTestPackage(long sessionId, int packageNodeId, java.lang.String xmlPackage) throws java.rmi.RemoteException;
    public void uploadTestPackageResult(long sessionId, int packageNodeId, java.lang.String xmlPackage) throws java.rmi.RemoteException;
    public com.borland.tm.webservices.tmplanning.entities.TestDefinitionResult[] getExecutionResult(long sessionId, int executionDefId, long executionTimestamp, java.lang.String execServerHostName, int execServerPort) throws java.rmi.RemoteException;
    public boolean deleteNode(long id, int nodeId) throws java.rmi.RemoteException;
    public boolean deleteProperty(long sessionId, com.borland.tm.webservices.tmplanning.entities.PropertyValue property) throws java.rmi.RemoteException;
    public com.borland.tm.webservices.tmplanning.entities.ManualTestStep[] getManualTestSteps(long sessionId, int testId) throws java.rmi.RemoteException;
    public int getIntegrationDefaultFolderId(long sessionId, int projectId) throws java.rmi.RemoteException;
    public boolean updateNode(long sessionId, com.borland.tm.webservices.tmplanning.entities.TestPlanningNode node) throws java.rmi.RemoteException;
    public com.borland.tm.webservices.tmplanning.entities.Project getCurrentProject(long sessionId) throws java.rmi.RemoteException;
    public void setCurrentProject(long sessionId, java.lang.String projectId) throws java.rmi.RemoteException;
    public boolean uploadTestPlan(long sessionId, int projectId, java.lang.String content) throws java.rmi.RemoteException;
    public int addManualTest(long id, int testContainerId, java.lang.String name, java.lang.String description, com.borland.tm.webservices.tmplanning.entities.ManualTestStep[] steps, com.borland.tm.webservices.tmplanning.entities.NodeParameter[] params) throws java.rmi.RemoteException;
    public void deleteManualTestStep(long sessionId, int testId, int stepPos) throws java.rmi.RemoteException;
    public void addManualTestStep(long sessionId, int testId, com.borland.tm.webservices.tmplanning.entities.ManualTestStep step) throws java.rmi.RemoteException;
    public void updateManualTestStep(long sessionId, int testId, com.borland.tm.webservices.tmplanning.entities.ManualTestStep step) throws java.rmi.RemoteException;
    public com.borland.tm.webservices.tmplanning.entities.CustomStepProperty[] getCustomStepPropertyNames(long id, int projectId) throws java.rmi.RemoteException;
    public java.lang.String getExecutionResultURL(long sessionId, int executionDefId, long executionTimestamp, java.lang.String execServerHostName, int execServerPort) throws java.rmi.RemoteException;
    public long queueExecution(long sessionId, int executionDefId, java.lang.String version, java.lang.String build, java.lang.String execServerHostName, int execServerPort, java.util.HashMap runProperties) throws java.rmi.RemoteException;
    public boolean startExecution(long sessionId, int executionDefId, java.lang.String version, java.lang.String build, java.lang.String execServerHostName, int execServerPort) throws java.rmi.RemoteException;
    public java.lang.String[] getPropertyIds(long sessionId) throws java.rmi.RemoteException;
    public java.lang.String[] getPropertyIds(long sessionId, java.lang.String nodeTypeId, java.lang.String propertyTypeId) throws java.rmi.RemoteException;
    public boolean updatePropertyValue(long sessionId, int nodeId, java.lang.String propertyName, java.lang.String propertyValue) throws java.rmi.RemoteException;
    public boolean updateProperty(long sessionId, com.borland.tm.webservices.tmplanning.entities.PropertyValue property) throws java.rmi.RemoteException;
    public java.lang.String[] getNodeTypeIds(long sessionId) throws java.rmi.RemoteException;
    public java.lang.String[] getNodeIds(long sessionId, com.borland.tm.webservices.tmplanning.entities.PropertyValue property) throws java.rmi.RemoteException;
    public java.lang.String[] getPropertyTypeIds(long sessionId, java.lang.String nodeTypeId) throws java.rmi.RemoteException;
    public com.borland.tm.webservices.tmplanning.entities.DataSet[] getDataSetForDataSource(long sessionId, int dataSourceId) throws java.rmi.RemoteException;
    public com.borland.tm.webservices.tmplanning.entities.DataSource[] getDataSourcesForProject(long sessionId, java.lang.String projectId) throws java.rmi.RemoteException;
    public void setIntegrationDefaultFolder(long sessionId, int projectId, int folderId) throws java.rmi.RemoteException;
}
