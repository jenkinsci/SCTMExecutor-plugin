package hudson.plugins.sctmexecutor.service;

import java.rmi.RemoteException;

import com.borland.scc.sccsystem.SystemService;

class SessionHandler {
  private long sessionId = -1;
  private SystemService service;
  private String pwd;
  private String user;
  
  public SessionHandler(SystemService service, String user, String pwd) {
    this.service = service;
    this.user = user;
    this.pwd = pwd;
  }
    
  public synchronized long getSessionId(long oldSessionId) throws RemoteException {
    if (oldSessionId == this.sessionId) {
      this.sessionId = service.logonUser(this.user, this.pwd);
    }
    return this.sessionId;
  }
}
