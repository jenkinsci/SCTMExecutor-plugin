package hudson.plugins.sctmexecutor;

import com.borland.sctm.ws.execution.entities.ExecutionResult;

public interface ITestResultWriter {
  void write(ExecutionResult result);
}
