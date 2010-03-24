/**
 * PerformerService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.sctm.ws.performer;

public interface PerformerService extends java.rmi.Remote {
    public com.borland.sctm.ws.performer.SPTestPlanningNode[] getChildNodes(long id, int iParentNodeId) throws java.rmi.RemoteException;
    public boolean removeNode(long id, int nodeId) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.performer.SPNamedEntity[] getVersions(long id, int iNodeId) throws java.rmi.RemoteException;
    public int addNode(long sessionId, int iParentNodeId, com.borland.sctm.ws.performer.SPTestPlanningNode node) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.performer.SPNamedEntity[] getBuilds(long id, int iVersionId) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.performer.SPExecution getExecution(long id, int iExecutionId) throws java.rmi.RemoteException;
    public java.lang.String getAgentClustersFile(long sessionId) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.performer.SPNodeProperty[] getNodeProperties(long id, int iNodeId) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.performer.SPTestPlanningNode[] getNodePath(long id, int nodeId) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.performer.SPNamedEntity[] getTestPlanningFilters(long id, int iProjectId) throws java.rmi.RemoteException;
    public boolean updateNode(long sessionId, com.borland.sctm.ws.performer.SPTestPlanningNode node) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.performer.SPExecution[] getExecutions(long id, int iTestDefId, int iFilterId) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.performer.SPNodeProperty[] getExecutionNodeProperties(long id, int executionId) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.performer.SPSuccessMeasure[] getExecutionSuccessMeasures(long id, int executionId) throws java.rmi.RemoteException;
    public java.lang.String[] getExecutionInfos(long id, int executionId) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.performer.SPNamedEntity[] getExecutionFiles(long id, int executionId) throws java.rmi.RemoteException;
    public int addExecution(long id, com.borland.sctm.ws.performer.SPExecution execution) throws java.rmi.RemoteException;
    public boolean removeExecution(long id, int executionId) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.performer.SPSourceControlInfo getSourceControlInfo(long id, int testDefID) throws java.rmi.RemoteException;
}
