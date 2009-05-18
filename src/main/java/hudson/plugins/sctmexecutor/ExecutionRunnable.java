package hudson.plugins.sctmexecutor;

import hudson.plugins.sctmexecutor.exceptions.SCTMException;
import hudson.plugins.sctmexecutor.service.ISCTMService;

import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.borland.tm.webservices.tmexecution.ExecutionHandle;
import com.borland.tm.webservices.tmexecution.ExecutionResult;

final class ExecutionRunnable implements Runnable {
  private static final int MAX_SLEEP = 60;
  private static final Logger LOGGER = Logger.getLogger("hudson.plugins.sctmexecutor"); //$NON-NLS-1$
  private static final int MAX_RETRY_COUNT = 2;

  private final int buildNumber;
  private final int execDefId;
  private final ISCTMService service;
  private final ITestResultWriter writer;
  private final PrintStream consolenLogger;
  private long resultCollectingDelay;
  private int retries;

  ExecutionRunnable(final ISCTMService service, final int execDefId, final int buildNumber, final ITestResultWriter writer, final PrintStream logger) {
    this.resultCollectingDelay = 5; // in seconds
    this.consolenLogger = logger;
    this.execDefId = execDefId;
    this.writer = writer;
    this.service = service;
    this.buildNumber = buildNumber;

    this.retries = MAX_RETRY_COUNT;
  }

  /**
   * used only to make unit testing quicker
   * 
   * @param sleep
   */
  void setResultCollectingDelay(long sleep) {
    resultCollectingDelay = sleep;
  }

  @Override
  public void run() {
    Collection<ExecutionHandle> handles;
    this.consolenLogger.println(MessageFormat.format("INFO: Start execution definiton {0}.", this.execDefId));
    try {
      if (this.buildNumber <= 0) // don't care about a build number
        handles = service.start(this.execDefId);
      else
        handles = service.start(this.execDefId, String.valueOf(this.buildNumber));

      if (writer != null) { // continue without collecting results
        for (ExecutionHandle executionHandle : handles) {
          collectExecutionResult(executionHandle);
        }
      }
    } catch (SCTMException e) {
      this.consolenLogger.println(MessageFormat.format(
          "ERROR: Cannot start execution defintion/folder {0}. SCTM reports: {1}", this.execDefId, e.getMessage()));
    }
  }

  private void collectExecutionResult(ExecutionHandle handle) {
    consolenLogger.println(MessageFormat.format("INFO: Waiting for result of execution definition {0}.", handle
        .getExecDefId()));
    ExecutionResult result = null;
    try {
      do {
        Thread.sleep(resultCollectingDelay * 1000); // because sometime SCTM is too slow and the run is not created when we ask for a
        // result
        if (service.isFinished(handle)) {
          result = service.getExecutionResult(handle);
          consolenLogger.println(MessageFormat.format(
              Messages.getString("ResultCollectorThread.log.resultReceived"), handle.getExecDefId())); //$NON-NLS-1$
        } else if (resultCollectingDelay < MAX_SLEEP) {
          resultCollectingDelay *= 2;
          if (resultCollectingDelay > MAX_SLEEP)
            resultCollectingDelay = MAX_SLEEP;
        }
      } while (result == null);

      this.writer.write(result);
    } catch (SCTMException e) {
      LOGGER.log(Level.SEVERE, e.getMessage());
      if (e.getMessage().contains("Logon failed."))
        consolenLogger.println("ERROR: Session for SCTM call lost and cannot be restored. Execution aborted.");
      else
        consolenLogger.println(MessageFormat.format("ERROR: Execution definition {0} failed.", handle.getExecDefId()));
    } catch (InterruptedException e) {
      consolenLogger.println(MessageFormat.format("INFO: Collecting results for execution definition {0} aborted.",
          handle.getExecDefId()));
      LOGGER.log(Level.INFO, e.getMessage());
    }
  }
}
