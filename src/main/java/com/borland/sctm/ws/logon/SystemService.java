/**
 * SystemService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.sctm.ws.logon;

public interface SystemService extends java.rmi.Remote {
    public boolean keepAlive(long sessionId) throws java.rmi.RemoteException;
    public long logonUser(java.lang.String username, java.lang.String plainPwd) throws java.rmi.RemoteException;
    public com.borland.sctm.ws.common.entities.AppModule[] getApplicationModules(long sessionId) throws java.rmi.RemoteException;
    public long convertFromReadableTime(java.lang.String time) throws java.rmi.RemoteException;
    public java.lang.String getRepositoryInstanceID(long sessionId) throws java.rmi.RemoteException;
    public java.lang.String getTMVersionInfo() throws java.rmi.RemoteException;
    public com.borland.sctm.ws.common.entities.ExtendedAppModule[] getExtendedApplicationModules(long sessionId) throws java.rmi.RemoteException;
    public java.lang.String convertToReadableTime(long time) throws java.rmi.RemoteException;
    public java.lang.String encryptPassword(long sessionId, java.lang.String plainPwd) throws java.rmi.RemoteException;
}
