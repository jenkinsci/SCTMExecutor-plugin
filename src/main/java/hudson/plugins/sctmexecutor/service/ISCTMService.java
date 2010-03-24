package hudson.plugins.sctmexecutor.service;

import hudson.FilePath;
import hudson.plugins.sctmexecutor.exceptions.SCTMException;

import java.util.Collection;

import com.borland.sctm.ws.execution.entities.ExecutionHandle;
import com.borland.sctm.ws.execution.entities.ExecutionResult;
import com.borland.sctm.ws.performer.SPNamedEntity;

public interface ISCTMService {

  public Collection<ExecutionHandle> start(int executionId) throws SCTMException;

  public Collection<ExecutionHandle> start(int executionId, String buildNumber) throws SCTMException;

  public boolean isFinished(ExecutionHandle handle) throws SCTMException;

  public ExecutionResult getExecutionResult(ExecutionHandle handle) throws SCTMException;

  public boolean buildNumberExists(int buildNumber, int nodeId) throws SCTMException;

  public boolean addBuildNumber(int buildNumber, int nodeId) throws SCTMException;

  public int getLatestSCTMBuildnumber(int nodeId) throws SCTMException;

  public String getExecDefinitionName(int execDefId) throws SCTMException;
  
  public SPNamedEntity[] getResultFiles(int testDefRunId) throws SCTMException;
  
  public FilePath loadResultFile(int fileId, String fileName);

}