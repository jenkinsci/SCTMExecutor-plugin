package com.borland.sctm.ws.logon;

public class SystemServiceProxy implements com.borland.sctm.ws.logon.SystemService {
  private String _endpoint = null;
  private com.borland.sctm.ws.logon.SystemService systemService = null;
  
  public SystemServiceProxy() {
    _initSystemServiceProxy();
  }
  
  public SystemServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initSystemServiceProxy();
  }
  
  private void _initSystemServiceProxy() {
    try {
      systemService = (new com.borland.sctm.ws.logon.SystemServiceServiceLocator()).getsccsystem();
      if (systemService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)systemService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)systemService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (systemService != null)
      ((javax.xml.rpc.Stub)systemService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.borland.sctm.ws.logon.SystemService getSystemService() {
    if (systemService == null)
      _initSystemServiceProxy();
    return systemService;
  }
  
  public long logonUser(java.lang.String username, java.lang.String plainPwd) throws java.rmi.RemoteException{
    if (systemService == null)
      _initSystemServiceProxy();
    return systemService.logonUser(username, plainPwd);
  }
  
  public java.lang.String convertToReadableTime(long time) throws java.rmi.RemoteException{
    if (systemService == null)
      _initSystemServiceProxy();
    return systemService.convertToReadableTime(time);
  }
  
  public long convertFromReadableTime(java.lang.String time) throws java.rmi.RemoteException{
    if (systemService == null)
      _initSystemServiceProxy();
    return systemService.convertFromReadableTime(time);
  }
  
  public com.borland.sctm.ws.common.AppModule[] getApplicationModules(long sessionId) throws java.rmi.RemoteException{
    if (systemService == null)
      _initSystemServiceProxy();
    return systemService.getApplicationModules(sessionId);
  }
  
  public com.borland.sctm.ws.common.ExtendedAppModule[] getExtendedApplicationModules(long sessionId) throws java.rmi.RemoteException{
    if (systemService == null)
      _initSystemServiceProxy();
    return systemService.getExtendedApplicationModules(sessionId);
  }
  
  public java.lang.String encryptPassword(long sessionId, java.lang.String plainPwd) throws java.rmi.RemoteException{
    if (systemService == null)
      _initSystemServiceProxy();
    return systemService.encryptPassword(sessionId, plainPwd);
  }
  
  public java.lang.String getRepositoryInstanceID(long sessionId) throws java.rmi.RemoteException{
    if (systemService == null)
      _initSystemServiceProxy();
    return systemService.getRepositoryInstanceID(sessionId);
  }
  
  
}