package hudson.plugins.sctmexecutor;

import hudson.plugins.sctmexecutor.exceptions.SCTMException;
import hudson.plugins.sctmexecutor.service.ISCTMService;

import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.borland.tm.webservices.tmexecution.ExecutionHandle;
import com.borland.tm.webservices.tmexecution.ExecutionResult;

final class ResultCollectorRunnable implements Runnable {
  private static final int MAX_SLEEP = 60;
  private static final Logger LOGGER = Logger.getLogger("hudson.plugins.sctmexecutor"); //$NON-NLS-1$
  private static final int MAX_RETRY_COUNT = 2;
  
  private ExecutionHandle handle;
  private ISCTMService service;
  private long sleep = 5; // in s
  private ITestResultWriter writer;
  private PrintStream consolenLogger;
  private int retries;
  
  public ResultCollectorRunnable(ISCTMService service, PrintStream logger, ExecutionHandle handle, ITestResultWriter writer) {
    this.consolenLogger = logger;
    this.handle = handle;
    this.writer = writer;
    this.service = service;
    
    this.retries = MAX_RETRY_COUNT;
  }
  
  /**
   * used only to make unit testing quicker 
   * @param sleep
   */
  void setSleep(long sleep) {
    this.sleep = sleep;
  }
  
  @Override
  public void run() {
    ExecutionResult result = null;
    try {
      do {
        Thread.sleep(sleep*1000); // because sometime SCTM is too slow and the run is not created when we ask for a result
        if (service.isFinished(handle)) {
          result = service.getExecutionResult(handle);
          consolenLogger.println(MessageFormat.format(Messages.getString("ResultCollectorThread.log.resultReceived"), handle.getExecDefId())); //$NON-NLS-1$
        } else if (sleep < MAX_SLEEP) {
          sleep *= 2;
          if (sleep > MAX_SLEEP)
            sleep = MAX_SLEEP;
        }
      } while (result == null);
      
      this.writer.write(result);
    } catch (SCTMException e) {
      LOGGER.log(Level.SEVERE, e.getMessage());
      if (e.getMessage().contains("Logon failed.")) {
        consolenLogger.println("Error: Session for SCTM call lost and cannot be restored. Execution aborted.");
      } else {
        if (retries > 0) {
          retries--;
          consolenLogger.println(MessageFormat.format("INFO: Remote call to SCTM failed during result collection for execution definition {0}. Try once more {1}.", handle.getExecDefId(), retries));
          run();
        } else
          consolenLogger.println(MessageFormat.format("ERROR for execution definition {0}: ", handle.getExecDefId()));
      }
    } catch (InterruptedException e) {
      consolenLogger.println(MessageFormat.format("INFO: Collecting results for execution definition {0} aborted.", handle.getExecDefId()));
      LOGGER.log(Level.INFO, e.getMessage());
    }
  }
}
