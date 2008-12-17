package hudson.plugins.sctmexecutor;

import java.io.PrintStream;
import java.rmi.RemoteException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.borland.tm.webservices.tmexecution.ExecutionHandle;
import com.borland.tm.webservices.tmexecution.ExecutionResult;
import com.borland.tm.webservices.tmexecution.ExecutionWebService;

final class ResultCollectorThread extends Thread {
  private static final int MAX_SLEEP = 60;
  private static final Logger LOGGER = Logger.getLogger("hudson.plugins.sctmexecutor");
  
  private ExecutionHandle handle;
  private ExecutionWebService service;
  private long sessionId;
  private long sleep = 5; // in s
  private ITestResultWriter writer;
  private PrintStream consolenLogger;
  private boolean testing;

  public ResultCollectorThread(PrintStream logger, ExecutionWebService service, long sessionId, ExecutionHandle handle, ITestResultWriter writer) {
    super("SCTMExecutor.resultcollector"+handle.getExecDefId());
    this.consolenLogger = logger;
    this.handle = handle;
    this.service = service;
    this.sessionId = sessionId;
    this.writer = writer;
    this.testing = false;
  }
  
  /**
   * used only to make unit testing quicker 
   * @param sleep
   */
  void setSleep(long sleep) {
    this.sleep = sleep;
    this.testing = true;
  }
  
  @Override
  public void run() {
    ExecutionResult result = null;
    try {
      do {
        Thread.sleep(sleep*1000); // because sometime SCTM is too slow and the run is not created when we ask for a result
        int stateOfExecution = service.getStateOfExecution(sessionId, handle);
        if (stateOfExecution == -1) {
          result = service.getExecutionResult(sessionId, handle);
          consolenLogger.println(MessageFormat.format("Received result for execution definition {0}.", handle.getExecDefId()));
        } else if (!testing || sleep < MAX_SLEEP) {
          sleep *= 2;
          if (sleep > MAX_SLEEP)
            sleep = MAX_SLEEP;
        }
      } while (result == null);
      
      this.writer.write(result);
    } catch (RemoteException e) {
      LOGGER.log(Level.SEVERE, "Remote call to SCTM failed during result collection.");
      LOGGER.log(Level.INFO, e.getMessage());
      throw new RuntimeException("Collecting results failed: ", e);
    } catch (InterruptedException e) {
      LOGGER.log(Level.SEVERE, "Collecting results aborted.");
      LOGGER.log(Level.INFO, e.getMessage());
      interrupt();
      throw new RuntimeException("Collecting result aborted: ", e);
    }
  }
}
