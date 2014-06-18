/**
 * PlanningService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.sctm.ws.planning;

public interface PlanningService extends java.rmi.Remote {
    public com.borland.sctm.ws.performer.PropertyValue getProperty(long sessionId, java.lang.String nodeId, java.lang.String propertyId) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.performer.Attribute[] getAttributes(long sessionId, int projectId) throws java.rmi.RemoteException;
    public java.lang.String[] getPropertyIds(long sessionId, java.lang.String nodeTypeId, java.lang.String propertyTypeId) throws java.rmi.RemoteException;
    public java.lang.String[] getPropertyIds(long sessionId) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.performer.Attribute[] updateAttributes(long sessionId, int projectId, com.borland.sctm.ws.performer.Attribute[] attributes) throws java.rmi.RemoteException;
    public long login(java.util.HashMap loginProperties) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.performer.TestPlanningNode getNode(long sessionId, java.lang.String nodeId) throws java.rmi.RemoteException;
    public void deleteAttributeOptions(long sessionId, int projectId, java.lang.String attributeName, com.borland.sctm.ws.performer.AttributeOption[] options) throws java.rmi.RemoteException;
    public void addAttributeOptions(long sessionId, int projectId, java.lang.String attributeName, com.borland.sctm.ws.performer.AttributeOption[] options) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.performer.TestDefinitionResult[] getExecutionResult(long sessionId, int executionDefId, long executionTimestamp, java.lang.String execServerHostName, int execServerPort) throws java.rmi.RemoteException;
    public boolean updateNode(long sessionId, com.borland.sctm.ws.performer.TestPlanningNode node) throws java.rmi.RemoteException;
    public boolean deleteProperty(long sessionId, com.borland.sctm.ws.performer.PropertyValue property) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.performer.TestPlanningNode[] getChildNodes(long id, int projectId, int parentNodeId, com.borland.sctm.ws.performer.NodeFilter filter) throws java.rmi.RemoteException;
    public int addNode(long sessionId, int parentNodeId, com.borland.sctm.ws.performer.TestPlanningNode node, boolean throwErrorOnDuplicate) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.performer.PropertyMetaInfo getPropertyInfo(long sessionId, java.lang.String nodeTypeId, java.lang.String propertyId) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.common.entities.NamedEntity[] getTestContainers(long sessionId, int projectId) throws java.rmi.RemoteException;
    public void deleteAttributes(long sessionId, int projectId, com.borland.sctm.ws.performer.Attribute[] attributes) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.performer.Project getProject(long sessionId, java.lang.String projectId) throws java.rmi.RemoteException;
    public int getIntegrationDefaultFolderId(long sessionId, int projectId) throws java.rmi.RemoteException;
    public boolean updateProperty(long sessionId, com.borland.sctm.ws.performer.PropertyValue property) throws java.rmi.RemoteException;
    public java.lang.String getExecutionResultURL(long sessionId, int executionDefId, long executionTimestamp, java.lang.String execServerHostName, int execServerPort) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.performer.AttributeWithOptionValues[] getAttributesWithOptionValues(long sessionId, int projectId) throws java.rmi.RemoteException;
    public void deleteManualTestStep(long sessionId, int testId, int stepPos) throws java.rmi.RemoteException;
    public void addManualTestStep(long sessionId, int testId, com.borland.sctm.ws.performer.ManualTestStep step) throws java.rmi.RemoteException;
    public long queueExecution(long sessionId, int executionDefId, java.lang.String version, java.lang.String build, java.lang.String execServerHostName, int execServerPort, java.util.HashMap runProperties) throws java.rmi.RemoteException;
    public boolean updatePropertyValue(long sessionId, int nodeId, java.lang.String propertyName, java.lang.String propertyValue) throws java.rmi.RemoteException;
    public boolean uploadTestPlan(long sessionId, int projectId, java.lang.String content) throws java.rmi.RemoteException;
    public java.lang.String[] getNodeTypeIds(long sessionId) throws java.rmi.RemoteException;
    public java.lang.String[] getPropertyTypeIds(long sessionId, java.lang.String nodeTypeId) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.performer.DataSet[] getDataSetForDataSource(long sessionId, int dataSourceId) throws java.rmi.RemoteException;
    public int[] getLibraryIdsForProject(long sessionId, int projectId) throws java.rmi.RemoteException;
    public java.lang.String[] getLibraryNamesForProject(long sessionId, int projectId) throws java.rmi.RemoteException;
    public void updateManualTestStep(long sessionId, int testId, com.borland.sctm.ws.performer.ManualTestStep step) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.performer.CustomStepProperty[] getCustomStepPropertyNames(long id, int projectId) throws java.rmi.RemoteException;
    public int addCustomStepProperty(long id, int projectId, int sequenceID, java.lang.String propertyName) throws java.rmi.RemoteException;
    public int deleteCustomStepProperty(long id, int projectId, int propertyId) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.performer.DataSource[] getDataSourcesForProject(long sessionId, java.lang.String projectId) throws java.rmi.RemoteException;
    public void setIntegrationDefaultFolder(long sessionId, int projectId, int folderId) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.performer.Attribute2[] getAttributes2(long sessionId, int projectId) throws java.rmi.RemoteException;
    public int addManualTest(long sessionId, int testContainerId, java.lang.String name, java.lang.String description, com.borland.sctm.ws.performer.ManualTestStep[] steps, com.borland.sctm.ws.performer.NodeParameter[] params) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.performer.ManualTestStep[] getManualTestSteps(long sessionId, int testId) throws java.rmi.RemoteException;
    public void setCurrentProject(long sessionId, java.lang.String projectId) throws java.rmi.RemoteException;
    public boolean startExecution(long sessionId, int executionDefId, java.lang.String version, java.lang.String build, java.lang.String execServerHostName, int execServerPort) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.performer.Project getCurrentProject(long sessionId) throws java.rmi.RemoteException;
    public boolean updateProperties(long sessionId, com.borland.sctm.ws.performer.PropertyValue[] properties) throws java.rmi.RemoteException;
    public java.lang.String[] getNodeIds(long sessionId, com.borland.sctm.ws.performer.PropertyValue property) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.performer.Attribute2[] addAttributes2(long sessionId, int projectId, com.borland.sctm.ws.performer.Attribute2[] attributes) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.performer.AttributeWithOptionValues[] addAttributesWithOptionValues(long sessionId, int projectId, com.borland.sctm.ws.performer.AttributeWithOptionValues[] attributes) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.performer.AttributeWithOptionValues[] updateAttributesWithOptionValues(long sessionId, int projectId, com.borland.sctm.ws.performer.AttributeWithOptionValues[] attributes) throws java.rmi.RemoteException;
    public void deleteAttributesWithOptionValues(long sessionId, int projectId, com.borland.sctm.ws.performer.AttributeWithOptionValues[] attributes) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.performer.Project[] getProjects(long sessionId) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.performer.Attribute[] addAttributes(long sessionId, int projectId, com.borland.sctm.ws.performer.Attribute[] attributes) throws java.rmi.RemoteException;
    public void uploadTestPackageResult(long sessionId, int packageNodeId, java.lang.String xmlPackage) throws java.rmi.RemoteException;
    public int createTestPackage(long sessionId, int packageParentNodeId, java.lang.String xmlPackage) throws java.rmi.RemoteException;
    public void updateTestPackage(long sessionId, int packageNodeId, java.lang.String xmlPackage) throws java.rmi.RemoteException;
    public boolean deleteNode(long id, int nodeId) throws java.rmi.RemoteException;
}
