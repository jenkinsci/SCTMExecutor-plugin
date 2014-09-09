package hudson.plugins.sctmexecutor;

import hudson.plugins.sctmexecutor.exceptions.SCTMException;

import com.borland.sctm.ws.execution.ExecutionResult;

public interface ITestResultWriter {
  void write(ExecutionResult result) throws SCTMException;
}
