/**
 * PlanningServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.tm.webservices.tmplanning;

public class PlanningServiceServiceLocator extends org.apache.axis.client.Service implements com.borland.tm.webservices.tmplanning.PlanningServiceService {

    public PlanningServiceServiceLocator() {
    }


    public PlanningServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PlanningServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for tmplanning
    private java.lang.String tmplanning_address = "http://10.5.2.218/Services1.0/services/tmplanning";

    public java.lang.String gettmplanningAddress() {
        return tmplanning_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String tmplanningWSDDServiceName = "tmplanning";

    public java.lang.String gettmplanningWSDDServiceName() {
        return tmplanningWSDDServiceName;
    }

    public void settmplanningWSDDServiceName(java.lang.String name) {
        tmplanningWSDDServiceName = name;
    }

    public com.borland.tm.webservices.tmplanning.PlanningService gettmplanning() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(tmplanning_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return gettmplanning(endpoint);
    }

    public com.borland.tm.webservices.tmplanning.PlanningService gettmplanning(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.borland.tm.webservices.tmplanning.TmplanningSoapBindingStub _stub = new com.borland.tm.webservices.tmplanning.TmplanningSoapBindingStub(portAddress, this);
            _stub.setPortName(gettmplanningWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void settmplanningEndpointAddress(java.lang.String address) {
        tmplanning_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.borland.tm.webservices.tmplanning.PlanningService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.borland.tm.webservices.tmplanning.TmplanningSoapBindingStub _stub = new com.borland.tm.webservices.tmplanning.TmplanningSoapBindingStub(new java.net.URL(tmplanning_address), this);
                _stub.setPortName(gettmplanningWSDDServiceName());
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
        if ("tmplanning".equals(inputPortName)) {
            return gettmplanning();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://10.5.2.218/Services1.0/services/tmplanning", "PlanningServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://10.5.2.218/Services1.0/services/tmplanning", "tmplanning"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("tmplanning".equals(portName)) {
            settmplanningEndpointAddress(address);
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
