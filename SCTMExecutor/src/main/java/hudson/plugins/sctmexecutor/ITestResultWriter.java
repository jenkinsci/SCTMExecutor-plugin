package hudson.plugins.sctmexecutor;

import com.borland.tm.webservices.tmexecution.ExecutionResult;

public interface ITestResultWriter {
  void write(ExecutionResult result);
}
