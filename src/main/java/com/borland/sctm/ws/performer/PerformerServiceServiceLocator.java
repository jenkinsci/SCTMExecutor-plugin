/**
 * PerformerServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.sctm.ws.performer;

public class PerformerServiceServiceLocator extends org.apache.axis.client.Service implements com.borland.sctm.ws.performer.PerformerServiceService {

    public PerformerServiceServiceLocator() {
    }


    public PerformerServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PerformerServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for tmperformer
    private java.lang.String tmperformer_address = "http://atlis-tm/Services1.0/services/tmperformer";

    public java.lang.String gettmperformerAddress() {
        return tmperformer_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String tmperformerWSDDServiceName = "tmperformer";

    public java.lang.String gettmperformerWSDDServiceName() {
        return tmperformerWSDDServiceName;
    }

    public void settmperformerWSDDServiceName(java.lang.String name) {
        tmperformerWSDDServiceName = name;
    }

    public com.borland.sctm.ws.performer.PerformerService gettmperformer() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(tmperformer_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return gettmperformer(endpoint);
    }

    public com.borland.sctm.ws.performer.PerformerService gettmperformer(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.borland.sctm.ws.performer.TmperformerSoapBindingStub _stub = new com.borland.sctm.ws.performer.TmperformerSoapBindingStub(portAddress, this);
            _stub.setPortName(gettmperformerWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void settmperformerEndpointAddress(java.lang.String address) {
        tmperformer_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.borland.sctm.ws.performer.PerformerService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.borland.sctm.ws.performer.TmperformerSoapBindingStub _stub = new com.borland.sctm.ws.performer.TmperformerSoapBindingStub(new java.net.URL(tmperformer_address), this);
                _stub.setPortName(gettmperformerWSDDServiceName());
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
        if ("tmperformer".equals(inputPortName)) {
            return gettmperformer();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tm.segue.com", "PerformerServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tm.segue.com", "tmperformer"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("tmperformer".equals(portName)) {
            settmperformerEndpointAddress(address);
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
