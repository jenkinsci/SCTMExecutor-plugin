package hudson.plugins.sctmexecutor;

import java.io.PrintStream;
import java.rmi.RemoteException;
import java.text.MessageFormat;

import com.borland.tm.webservices.tmexecution.ExecutionHandle;
import com.borland.tm.webservices.tmexecution.ExecutionResult;
import com.borland.tm.webservices.tmexecution.ExecutionWebService;

public class ResultCollectorThread extends Thread {
  private ExecutionHandle handle;
  private ExecutionWebService service;
  private long sessionId;
  private long sleep = 10000; // in ms
  private ITestResultWriter writer;
  private PrintStream logger;

  public ResultCollectorThread(PrintStream logger, ExecutionWebService service, long sessionId, ExecutionHandle handle, ITestResultWriter writer) {
    super("SCTMExecutor.resultcollector"+handle.getExecDefId());
    this.logger = logger;
    this.handle = handle;
    this.service = service;
    this.sessionId = sessionId;
    this.writer = writer;
  }
  
  public void setSleep(long sleep) {
    this.sleep = sleep;
  }
  
  @Override
  public void run() {
    ExecutionResult result = null;
    try {
      Thread.sleep(5000); // because sometime SCTM is too slow and the run is not created when we ask for a result
      while (result == null) {
        int stateOfExecution = service.getStateOfExecution(sessionId, handle);
        if (stateOfExecution == -1) {
          result = service.getExecutionResult(sessionId, handle);
          logger.println(MessageFormat.format("Received result for execution definition {0}.", handle.getExecDefId()));
        }
        else
          Thread.sleep(sleep);
      }
      
      this.writer.write(result);
    } catch (RemoteException e) {
      throw new RuntimeException("Collecting results failed: ", e);
    } catch (InterruptedException e) {
      interrupt();
      throw new RuntimeException("Collecting result aborted: ", e);
    }
  }
}
