package hudson.plugins.sctmexecutor;

import java.rmi.RemoteException;

interface ISessionHandler {

  long getSessionId(long oldSessionId) throws RemoteException;

}
