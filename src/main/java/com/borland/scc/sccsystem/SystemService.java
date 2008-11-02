/**
 * SystemService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.scc.sccsystem;

public interface SystemService extends java.rmi.Remote {
    public long logonUser(java.lang.String username, java.lang.String plainPwd) throws java.rmi.RemoteException;
    public java.lang.String convertToReadableTime(long time) throws java.rmi.RemoteException;
    public long convertFromReadableTime(java.lang.String time) throws java.rmi.RemoteException;
    public com.borland.scc.AppModule[] getApplicationModules(long sessionId) throws java.rmi.RemoteException;
    public com.borland.scc.ExtendedAppModule[] getExtendedApplicationModules(long sessionId) throws java.rmi.RemoteException;
    public java.lang.String encryptPassword(long sessionId, java.lang.String plainPwd) throws java.rmi.RemoteException;
    public java.lang.String getRepositoryInstanceID(long sessionId) throws java.rmi.RemoteException;
}
