/**
 * ExecutionWebServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.tm.webservices.tmexecution;

public class ExecutionWebServiceServiceLocator extends org.apache.axis.client.Service implements com.borland.tm.webservices.tmexecution.ExecutionWebServiceService {

    public ExecutionWebServiceServiceLocator() {
    }


    public ExecutionWebServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ExecutionWebServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for tmexecution
    private java.lang.String tmexecution_address = "http://194.112.161.2:19120/Services1.0/services/tmexecution";

    public java.lang.String gettmexecutionAddress() {
        return tmexecution_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String tmexecutionWSDDServiceName = "tmexecution";

    public java.lang.String gettmexecutionWSDDServiceName() {
        return tmexecutionWSDDServiceName;
    }

    public void settmexecutionWSDDServiceName(java.lang.String name) {
        tmexecutionWSDDServiceName = name;
    }

    public com.borland.tm.webservices.tmexecution.ExecutionWebService gettmexecution() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(tmexecution_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return gettmexecution(endpoint);
    }

    public com.borland.tm.webservices.tmexecution.ExecutionWebService gettmexecution(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.borland.tm.webservices.tmexecution.TmexecutionSoapBindingStub _stub = new com.borland.tm.webservices.tmexecution.TmexecutionSoapBindingStub(portAddress, this);
            _stub.setPortName(gettmexecutionWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void settmexecutionEndpointAddress(java.lang.String address) {
        tmexecution_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.borland.tm.webservices.tmexecution.ExecutionWebService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.borland.tm.webservices.tmexecution.TmexecutionSoapBindingStub _stub = new com.borland.tm.webservices.tmexecution.TmexecutionSoapBindingStub(new java.net.URL(tmexecution_address), this);
                _stub.setPortName(gettmexecutionWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("tmexecution".equals(inputPortName)) {
            return gettmexecution();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tm.segue.com/webservices/tmexecution", "ExecutionWebServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tm.segue.com/webservices/tmexecution", "tmexecution"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("tmexecution".equals(portName)) {
            settmexecutionEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
