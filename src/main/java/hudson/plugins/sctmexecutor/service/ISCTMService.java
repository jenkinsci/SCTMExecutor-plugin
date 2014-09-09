package hudson.plugins.sctmexecutor.service;

import hudson.plugins.sctmexecutor.exceptions.SCTMException;

import java.io.InputStream;
import java.util.Collection;

import com.borland.sctm.ws.execution.ExecutionHandle;
import com.borland.sctm.ws.execution.ExecutionResult;
import com.borland.sctm.ws.performer.SPNamedEntity;

public interface ISCTMService {

  public Collection<ExecutionHandle> start(int execDefId) throws SCTMException;

  public Collection<ExecutionHandle> start(int execDefId, String buildNumber) throws SCTMException;

  public boolean isFinished(ExecutionHandle handle) throws SCTMException;

  public ExecutionResult getExecutionResult(ExecutionHandle handle) throws SCTMException;

  public boolean buildNumberExists(String productName, String version, String buildNumber) throws SCTMException;

  public boolean addBuildNumber(String productName, String version, String buildNumber) throws SCTMException;

  public String getLatestSCTMBuildnumber(String productName, String version) throws SCTMException;

  public String getExecDefinitionName(int execDefId) throws SCTMException;
  
  public SPNamedEntity[] getResultFiles(int testDefRunId) throws SCTMException;
  
  public InputStream loadResultFile(int fileId);

  public Collection<String> getAllVersions(int execDefId) throws SCTMException;

  public String getProductName(int execDefId) throws SCTMException;
  
  public String getProductVersion(int execDefId) throws SCTMException;
  
  public void setExecutionParameter(int execDefId, String parameterName, String parameterValue) throws SCTMException;

}