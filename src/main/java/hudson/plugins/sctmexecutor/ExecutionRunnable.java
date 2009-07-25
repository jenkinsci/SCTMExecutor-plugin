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

  private final int buildNumber;
  private final int execDefId;
  private final ISCTMService service;
  private final ITestResultWriter writer;
  private final PrintStream consolenLogger;
  private long resultCollectingDelay;

  ExecutionRunnable(final ISCTMService service, final int execDefId, final int buildNumber, final ITestResultWriter writer, final PrintStream logger) {
    this.resultCollectingDelay = 5; // in seconds
    this.consolenLogger = logger;
    this.execDefId = execDefId;
    this.writer = writer;
    this.service = service;
    this.buildNumber = buildNumber;
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
    this.consolenLogger.println(MessageFormat.format(Messages.getString("ExecutionRunnable.msg.startExecDef"), this.execDefId)); //$NON-NLS-1$
    try {
      if (this.buildNumber <= 0) // don't care about a build number
        handles = service.start(this.execDefId);
      else {
        if (!this.service.buildNumberExists(this.buildNumber))
          this.service.addBuildNumber(this.buildNumber);
        handles = service.start(this.execDefId, String.valueOf(this.buildNumber));
      }

      if (writer != null) { // continue without collecting results
        for (ExecutionHandle executionHandle : handles) {
          collectExecutionResult(executionHandle);
        }
      }
    } catch (SCTMException e) {
      this.consolenLogger.println(MessageFormat.format(
          Messages.getString("ExecutionRunnable.err.startExecDefFailed"), this.execDefId, e.getMessage())); //$NON-NLS-1$
    }
  }
  
  private void collectExecutionResult(ExecutionHandle handle) {
    consolenLogger.println(MessageFormat.format(Messages.getString("ExecutionRunnable.msg.waitForResult"), handle //$NON-NLS-1$
        .getExecDefId()));
    ExecutionResult result = null;
    try {
      do {
        Thread.sleep(resultCollectingDelay * 1000);
     // because sometime SCTM is too slow and the run is not created when we ask for a result
        if (service.isFinished(handle)) {
          result = service.getExecutionResult(handle);
          consolenLogger.println(MessageFormat.format(
              Messages.getString("ExecutionRunnable.log.resultReceived"), handle.getExecDefId())); //$NON-NLS-1$
        } else if (resultCollectingDelay < MAX_SLEEP) {
          resultCollectingDelay *= 2;
          if (resultCollectingDelay > MAX_SLEEP)
            resultCollectingDelay = MAX_SLEEP;
        }
      } while (result == null);

      this.writer.write(result);
    } catch (SCTMException e) {
      LOGGER.log(Level.SEVERE, e.getMessage());
      if (e.getMessage().contains("Logon failed.")) //$NON-NLS-1$
        consolenLogger.println(MessageFormat.format(Messages.getString("ExecutionRunnable.err.sessionLost"), e.getMessage())); //$NON-NLS-1$
      else
        consolenLogger.println(MessageFormat.format(Messages.getString("ExecutionRunnable.err.collectingResultsFailed"), handle.getExecDefId(), e.getMessage())); //$NON-NLS-1$
    } catch (InterruptedException e) {
      consolenLogger.println(MessageFormat.format(Messages.getString("ExecutionRunnable.warn.abortCollectingResults"), //$NON-NLS-1$
          handle.getExecDefId()));
      LOGGER.log(Level.INFO, e.getMessage());
    }
  }
}
