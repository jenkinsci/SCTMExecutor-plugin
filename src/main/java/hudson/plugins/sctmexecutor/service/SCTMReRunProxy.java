package hudson.plugins.sctmexecutor.service;

import hudson.plugins.sctmexecutor.exceptions.SCTMException;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.borland.tm.webservices.tmexecution.ExecutionHandle;
import com.borland.tm.webservices.tmexecution.ExecutionResult;

public class SCTMReRunProxy implements ISCTMService {
  private static final int MAXRERUN = 3;
  private ISCTMService target;
  private static final Logger LOGGER = Logger.getLogger("hudson.plugins.sctmexecutor.sctmservice"); //$NON-NLS-1$
  
  public SCTMReRunProxy(String serviceUrl, String user, String pwd) throws SCTMException {
    init(serviceUrl, user, pwd, MAXRERUN);
  } 
  
  private void init(String serviceUrl, String user, String pwd, int tryCount) throws SCTMException {
    try {
      this.target = SCTMServiceFactory.getInstance().getService(serviceUrl, user, pwd, true);
    } catch (SCTMException e) {
      if (tryCount > 0) {
        init(serviceUrl, user, pwd, --tryCount);
        LOGGER.log(Level.INFO, MessageFormat.format("Init SCTM Webservice failed. Try once more [{0}]", tryCount));
      } else
        throw e;
    }
  }

  @Override
  public ExecutionResult getExecutionResult(ExecutionHandle handle) throws SCTMException {
    return doGetExecutionResult(handle, MAXRERUN);
  }
  
  private ExecutionResult doGetExecutionResult(ExecutionHandle handle, int tryCount) throws SCTMException {
    try {
      return target.getExecutionResult(handle);
    } catch (SCTMException e) {
      if (tryCount > 0) {
        LOGGER.log(Level.INFO, MessageFormat.format("Fetch result for execution definition {0} failed. Try once more [{1}]", handle.getExecDefId(), tryCount));
        return doGetExecutionResult(handle, --tryCount);
      } else
        throw e;        
    }    
  }

  @Override
  public boolean isFinished(ExecutionHandle handle) throws SCTMException {
    return doIsFinished(handle, MAXRERUN);
  }
  
  private boolean doIsFinished(ExecutionHandle handle, int tryCount) throws SCTMException {
    try {
      return this.target.isFinished(handle);
    } catch (SCTMException e) {
      if (tryCount > 0) {
        LOGGER.log(Level.INFO, MessageFormat.format("Fetch state of execution for execution definition {0} failed. Try once more [{1}]", handle.getExecDefId(), tryCount));
        return doIsFinished(handle, --tryCount);
      } else
        throw e;
    }
  }

  @Override
  public Collection<ExecutionHandle> start(int executionId) throws SCTMException {
    return doStart(executionId, MAXRERUN);
  }
  
  private Collection<ExecutionHandle> doStart(int executionId, int tryCount) throws SCTMException {
    try {
      return this.target.start(executionId);
    } catch (SCTMException e) {
      if (tryCount > 0) {
        LOGGER.log(Level.INFO, MessageFormat.format("Start execution for execution definition {0} failed. Try once more [{1}]", executionId, tryCount));
        return doStart(executionId, --tryCount);
      } else
        throw e;
    }
  }

  @Override
  public Collection<ExecutionHandle> start(int executionId, String buildNumber) throws SCTMException {
    return doStart(executionId, buildNumber, MAXRERUN);
  }
  
  private Collection<ExecutionHandle> doStart(int executionId, String buildNumber, int tryCount) throws SCTMException {
    try {
      return this.target.start(executionId, buildNumber);
    } catch (SCTMException e) {
      if (tryCount > 0) {
        LOGGER.log(Level.INFO, MessageFormat.format("Start execution for execution definition {0} failed. Try once more [{1}]", executionId, tryCount));
        return doStart(executionId, buildNumber, --tryCount);
      } else
        throw e;
    }
  }

}
