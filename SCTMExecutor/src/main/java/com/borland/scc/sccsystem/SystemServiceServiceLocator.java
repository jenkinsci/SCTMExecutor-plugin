/**
 * SystemServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.scc.sccsystem;

public class SystemServiceServiceLocator extends org.apache.axis.client.Service implements com.borland.scc.sccsystem.SystemServiceService {

    public SystemServiceServiceLocator() {
    }


    public SystemServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SystemServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for sccsystem
    private java.lang.String sccsystem_address = "http://10.5.3.19:19120/Services1.0/services/sccsystem";

    public java.lang.String getsccsystemAddress() {
        return sccsystem_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String sccsystemWSDDServiceName = "sccsystem";

    public java.lang.String getsccsystemWSDDServiceName() {
        return sccsystemWSDDServiceName;
    }

    public void setsccsystemWSDDServiceName(java.lang.String name) {
        sccsystemWSDDServiceName = name;
    }

    public com.borland.scc.sccsystem.SystemService getsccsystem() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(sccsystem_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getsccsystem(endpoint);
    }

    public com.borland.scc.sccsystem.SystemService getsccsystem(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.borland.scc.sccsystem.SccsystemSoapBindingStub _stub = new com.borland.scc.sccsystem.SccsystemSoapBindingStub(portAddress, this);
            _stub.setPortName(getsccsystemWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setsccsystemEndpointAddress(java.lang.String address) {
        sccsystem_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.borland.scc.sccsystem.SystemService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.borland.scc.sccsystem.SccsystemSoapBindingStub _stub = new com.borland.scc.sccsystem.SccsystemSoapBindingStub(new java.net.URL(sccsystem_address), this);
                _stub.setPortName(getsccsystemWSDDServiceName());
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
        if ("sccsystem".equals(inputPortName)) {
            return getsccsystem();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://10.5.3.19:19120/Services1.0/services/sccsystem", "SystemServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://10.5.3.19:19120/Services1.0/services/sccsystem", "sccsystem"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("sccsystem".equals(portName)) {
            setsccsystemEndpointAddress(address);
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
