package hudson.plugins.sctmexecutor.service;

import hudson.plugins.sctmexecutor.exceptions.SCTMException;

import java.io.InputStream;
import java.util.Collection;

import com.borland.sctm.ws.execution.entities.ExecutionHandle;
import com.borland.sctm.ws.execution.entities.ExecutionResult;
import com.borland.sctm.ws.performer.SPNamedEntity;

public interface ISCTMService {

  public Collection<ExecutionHandle> start(int executionId) throws SCTMException;

  public Collection<ExecutionHandle> start(int executionId, String buildNumber) throws SCTMException;

  public boolean isFinished(ExecutionHandle handle) throws SCTMException;

  public ExecutionResult getExecutionResult(ExecutionHandle handle) throws SCTMException;

  public boolean buildNumberExists(String productName, String version, int buildNumber) throws SCTMException;

  public boolean addBuildNumber(String productName, String version, int buildNumber) throws SCTMException;

  public int getLatestSCTMBuildnumber(String productName, String version) throws SCTMException;

  public String getExecDefinitionName(int execDefId) throws SCTMException;
  
  public SPNamedEntity[] getResultFiles(int testDefRunId) throws SCTMException;
  
  public InputStream loadResultFile(int fileId);

  public Collection<String> getAllVersions(int execDefId) throws SCTMException;

  public String getProductName(int integer) throws SCTMException;

}