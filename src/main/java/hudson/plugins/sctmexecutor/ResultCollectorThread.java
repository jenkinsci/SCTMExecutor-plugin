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
  private static final Logger LOGGER = Logger.getLogger("hudson.plugins.sctmexecutor"); //$NON-NLS-1$
  
  private ExecutionHandle handle;
  private ExecutionWebService service;
  private long sessionId;
  private long sleep = 5; // in s
  private ITestResultWriter writer;
  private PrintStream consolenLogger;

  public ResultCollectorThread(PrintStream logger, ExecutionWebService service, long sessionId, ExecutionHandle handle, ITestResultWriter writer) {
    super("SCTMExecutor.resultcollector"+handle.getExecDefId()); //$NON-NLS-1$
    this.consolenLogger = logger;
    this.handle = handle;
    this.service = service;
    this.sessionId = sessionId;
    this.writer = writer;
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
        int stateOfExecution = service.getStateOfExecution(sessionId, handle);
        if (stateOfExecution == -1) {
          result = service.getExecutionResult(sessionId, handle);
          consolenLogger.println(MessageFormat.format(Messages.getString("ResultCollectorThread.log.resultReceived"), handle.getExecDefId())); //$NON-NLS-1$
        } else if (sleep < MAX_SLEEP) {
          sleep *= 2;
          if (sleep > MAX_SLEEP)
            sleep = MAX_SLEEP;
        }
      } while (result == null);
      
      this.writer.write(result);
    } catch (RemoteException e) {
      LOGGER.log(Level.SEVERE, "Remote call to SCTM failed during result collection."); //$NON-NLS-1$
      LOGGER.log(Level.INFO, e.getMessage());
      throw new RuntimeException(Messages.getString("ResultCollectorThread.err.collectingResultFailed"), e); //$NON-NLS-1$
    } catch (InterruptedException e) {
      LOGGER.log(Level.SEVERE, "Collecting results aborted."); //$NON-NLS-1$
      LOGGER.log(Level.INFO, e.getMessage());
      interrupt();
      throw new RuntimeException(Messages.getString("ResultCollectorThread.err.collectionResultAborted"), e); //$NON-NLS-1$
    }
  }
}
