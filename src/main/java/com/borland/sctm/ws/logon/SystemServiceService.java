/**
 * SystemServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.sctm.ws.logon;

public interface SystemServiceService extends javax.xml.rpc.Service {
    public java.lang.String getsccsystemAddress();

    public com.borland.sctm.ws.logon.SystemService getsccsystem() throws javax.xml.rpc.ServiceException;

    public com.borland.sctm.ws.logon.SystemService getsccsystem(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
