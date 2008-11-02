/**
 * SystemServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.scc.sccsystem;

public interface SystemServiceService extends javax.xml.rpc.Service {
    public java.lang.String getsccsystemAddress();

    public com.borland.scc.sccsystem.SystemService getsccsystem() throws javax.xml.rpc.ServiceException;

    public com.borland.scc.sccsystem.SystemService getsccsystem(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
