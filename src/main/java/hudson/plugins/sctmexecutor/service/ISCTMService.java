package hudson.plugins.sctmexecutor.service;

import hudson.plugins.sctmexecutor.exceptions.SCTMException;

import java.util.Collection;

import com.borland.tm.webservices.tmexecution.ExecutionHandle;
import com.borland.tm.webservices.tmexecution.ExecutionResult;

public interface ISCTMService {

  public abstract Collection<ExecutionHandle> start(int executionId) throws SCTMException;

  public abstract Collection<ExecutionHandle> start(int executionId, String buildNumber) throws SCTMException;

  public abstract boolean isFinished(ExecutionHandle handle) throws SCTMException;

  public abstract ExecutionResult getExecutionResult(ExecutionHandle handle) throws SCTMException;

}