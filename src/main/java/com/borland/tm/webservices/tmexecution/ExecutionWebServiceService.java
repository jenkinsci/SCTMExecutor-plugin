/**
 * ExecutionWebServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.tm.webservices.tmexecution;

public interface ExecutionWebServiceService extends javax.xml.rpc.Service {
    public java.lang.String gettmexecutionAddress();

    public com.borland.tm.webservices.tmexecution.ExecutionWebService gettmexecution() throws javax.xml.rpc.ServiceException;

    public com.borland.tm.webservices.tmexecution.ExecutionWebService gettmexecution(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
