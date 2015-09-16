package hudson.plugins.sctmexecutor.service;

import java.io.InputStream;
import java.util.Collection;

import com.borland.sctm.ws.execution.entities.ExecutionHandle;
import com.borland.sctm.ws.execution.entities.ExecutionResult;
import com.borland.sctm.ws.performer.SPNamedEntity;

import hudson.plugins.sctmexecutor.exceptions.SCTMException;

public interface ISCTMService {

  public Collection<ExecutionHandle> start(int executionId) throws SCTMException;

  public Collection<ExecutionHandle> start(int executionId, String buildNumber) throws SCTMException;

  public boolean isFinished(ExecutionHandle handle) throws SCTMException;

  public ExecutionResult getExecutionResult(ExecutionHandle handle) throws SCTMException;

  public boolean buildNumberExists(String productName, String version, int buildNumber) throws SCTMException;

  public boolean addBuildNumberIfNotExists(int nodeId, int buildNumber) throws SCTMException;

  public int getLatestSCTMBuildnumber(int nodeId) throws SCTMException;

  public String getExecDefinitionName(int execDefId) throws SCTMException;
  
  public SPNamedEntity[] getResultFiles(int testDefRunId) throws SCTMException;
  
  public InputStream loadResultFile(int fileId);

  public Collection<String> getAllVersions(int execDefId) throws SCTMException;

  public String getProductName(int integer) throws SCTMException;

}