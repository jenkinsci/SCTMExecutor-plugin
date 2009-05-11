/**
 * MainEntitiesServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.scc.webservices.sccentities;

public class MainEntitiesServiceLocator extends org.apache.axis.client.Service implements com.borland.scc.webservices.sccentities.MainEntitiesService {

    public MainEntitiesServiceLocator() {
    }


    public MainEntitiesServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MainEntitiesServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for sccentities
    private java.lang.String sccentities_address = "http://10.5.2.218//axislegacy/sccentities";

    public java.lang.String getsccentitiesAddress() {
        return sccentities_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String sccentitiesWSDDServiceName = "sccentities";

    public java.lang.String getsccentitiesWSDDServiceName() {
        return sccentitiesWSDDServiceName;
    }

    public void setsccentitiesWSDDServiceName(java.lang.String name) {
        sccentitiesWSDDServiceName = name;
    }

    public com.borland.scc.webservices.sccentities.MainEntities getsccentities() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(sccentities_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getsccentities(endpoint);
    }

    public com.borland.scc.webservices.sccentities.MainEntities getsccentities(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.borland.scc.webservices.sccentities.SccentitiesSoapBindingStub _stub = new com.borland.scc.webservices.sccentities.SccentitiesSoapBindingStub(portAddress, this);
            _stub.setPortName(getsccentitiesWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setsccentitiesEndpointAddress(java.lang.String address) {
        sccentities_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.borland.scc.webservices.sccentities.MainEntities.class.isAssignableFrom(serviceEndpointInterface)) {
                com.borland.scc.webservices.sccentities.SccentitiesSoapBindingStub _stub = new com.borland.scc.webservices.sccentities.SccentitiesSoapBindingStub(new java.net.URL(sccentities_address), this);
                _stub.setPortName(getsccentitiesWSDDServiceName());
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
        if ("sccentities".equals(inputPortName)) {
            return getsccentities();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "MainEntitiesService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "sccentities"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("sccentities".equals(portName)) {
            setsccentitiesEndpointAddress(address);
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
