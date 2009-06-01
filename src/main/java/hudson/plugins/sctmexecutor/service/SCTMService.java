package hudson.plugins.sctmexecutor.service;

import hudson.plugins.sctmexecutor.Messages;
import hudson.plugins.sctmexecutor.exceptions.SCTMException;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.rpc.ServiceException;

import com.borland.scc.sccsystem.SystemService;
import com.borland.scc.sccsystem.SystemServiceServiceLocator;
import com.borland.tm.webservices.tmexecution.ExecutionHandle;
import com.borland.tm.webservices.tmexecution.ExecutionResult;
import com.borland.tm.webservices.tmexecution.ExecutionWebService;
import com.borland.tm.webservices.tmexecution.ExecutionWebServiceServiceLocator;

public class SCTMService implements ISCTMService {
  private static final int MAX_LOGONRETRYCOUNT = 3;
  private static final Logger LOGGER = Logger.getLogger("hudson.plugins.sctmservice");  //$NON-NLS-1$
  
  private SystemService systemService;
  private ExecutionWebService execService;
  private long sessionId;
  private volatile int logonRetryCount;
  private String user;
  private String pwd;

  public SCTMService(String serviceURL, String user, String pwd) throws SCTMException {
    try {
      this.user = user;
      this.pwd = pwd;
      
      systemService = new SystemServiceServiceLocator().getsccsystem(new URL(serviceURL + "/sccsystem?wsdl")); //$NON-NLS-1$
      execService = new ExecutionWebServiceServiceLocator().gettmexecution(new URL(serviceURL + "/tmexecution?wsdl")); //$NON-NLS-1$
      this.sessionId = this.systemService.logonUser(this.user, this.pwd);;
    } catch (MalformedURLException e) {
      LOGGER.log(Level.SEVERE, e.getMessage(), e);
      throw new SCTMException(Messages.getString("SCTMService.err.serviceUrlWrong")); //$NON-NLS-1$
    } catch (ServiceException e) {
      LOGGER.log(Level.SEVERE, e.getMessage(), e);
      throw new SCTMException(MessageFormat.format(Messages.getString("SCTMService.err.urlOrServiceBroken"), serviceURL)); //$NON-NLS-1$
    } catch (RemoteException e) {
      LOGGER.log(Level.SEVERE, e.getMessage(), e);
      throw new SCTMException(MessageFormat.format(Messages.getString("SCTMService.err.commonFatalError"), e.getMessage())); //$NON-NLS-1$
    }
  }
  
  /* (non-Javadoc)
   * @see hudson.plugins.sctmexecutor.service.ISCTMService#start(int)
   */
  public Collection<ExecutionHandle> start(int executionId) throws SCTMException {
    try {
      ExecutionHandle[] handles = execService.startExecution(this.sessionId, executionId);
      logonRetryCount = 0;
      return convertToList(handles);
    } catch (RemoteException e) {
      if (handleLostSessionException(executionId, e))
        return start(executionId);
      LOGGER.log(Level.WARNING, e.getMessage(), e);
      throw new SCTMException(MessageFormat.format(Messages.getString("SCTMService.err.commonFatalError"), e.getMessage()));
    }
  }

  private boolean handleLostSessionException(int executionId, RemoteException e) throws SCTMException {
    if (e.getMessage().contains("Not logged in.") && logonRetryCount < MAX_LOGONRETRYCOUNT) { //$NON-NLS-1$
      logonRetryCount++;
      LOGGER.warning(Messages.getString("SCTMService.warn.SessionLostReconnect")); //$NON-NLS-1$
      try {
        this.sessionId = this.systemService.logonUser(this.user, this.pwd);
        return true;
      } catch (RemoteException e1) {
        LOGGER.log(Level.SEVERE, e.getMessage(), e);
        if (e.getMessage().contains("Not logged in")) //$NON-NLS-1$
          throw new SCTMException(Messages.getString("SCTMService.err.accessDenied")); //$NON-NLS-1$
        else
          throw new SCTMException(MessageFormat.format(Messages.getString("SCTMService.err.commonFatalError"), e.getMessage())); //$NON-NLS-1$
      }
    }
    return false;
  }

  private Collection<ExecutionHandle> convertToList(ExecutionHandle[] handles) {
    Collection<ExecutionHandle> runs = new ArrayList<ExecutionHandle>(handles.length);
    for (ExecutionHandle handle : handles) {
      runs.add(handle);
    }
    return runs;
  }
  
  /* (non-Javadoc)
   * @see hudson.plugins.sctmexecutor.service.ISCTMService#start(int, java.lang.String)
   */
  public Collection<ExecutionHandle> start(int executionId, String buildNumber) throws SCTMException {
    try {
      ExecutionHandle[] handles = execService.startExecution(this.sessionId, executionId, buildNumber, 1, null);
      return convertToList(handles);
    } catch (RemoteException e) {
      if (handleLostSessionException(executionId, e)) {
        return start(executionId, buildNumber);
      }
      LOGGER.log(Level.WARNING, e.getMessage(), e);
      throw new SCTMException(MessageFormat.format(Messages.getString("SCTMService.err.commonFatalError"), e.getMessage())); //$NON-NLS-1$
    }
  }
  
  /* (non-Javadoc)
   * @see hudson.plugins.sctmexecutor.service.ISCTMService#isFinished(com.borland.tm.webservices.tmexecution.ExecutionHandle)
   */
  public boolean isFinished(ExecutionHandle handle) throws SCTMException {
    try {
      return execService.getStateOfExecution(sessionId, handle) < 0;
    } catch (RemoteException e) {
      if (handleLostSessionException(handle.getExecDefId(), e))
        return isFinished(handle);
      LOGGER.log(Level.SEVERE, e.getMessage(), e);
      throw new SCTMException(MessageFormat.format(Messages.getString("SCTMService.err.commonFatalError"), e.getMessage())); //$NON-NLS-1$
    }
  }
  
  /* (non-Javadoc)
   * @see hudson.plugins.sctmexecutor.service.ISCTMService#getExecutionResult(com.borland.tm.webservices.tmexecution.ExecutionHandle)
   */
  public ExecutionResult getExecutionResult(ExecutionHandle handle) throws SCTMException {
    try {
      return execService.getExecutionResult(this.sessionId, handle);
    } catch (RemoteException e) {
      if (handleLostSessionException(handle.getExecDefId(), e))
        return getExecutionResult(handle);
      LOGGER.log(Level.SEVERE, e.getMessage(), e);
      throw new SCTMException(MessageFormat.format(Messages.getString("SCTMService.err.commonFatalError"), e.getMessage())); //$NON-NLS-1$
    }
  }
}
