/**
 * ExecServer.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.scc.webservices.sccentities.entities;

public class ExecServer  extends com.borland.scc.webservices.sccentities.entities.NamedEntity  implements java.io.Serializable {
    private int locationId;

    private java.lang.String execServerHostName;

    private int rmiProxyPort;

    private int rmiProxyPortSSL;

    private boolean useSSL;

    private int appModuleID;

    private int state;

    private int problemAlertTimeout;

    private int maxConcurrentExecutions;

    private int maxBandwidth;

    private boolean active;

    public ExecServer() {
    }

    public ExecServer(
           int id,
           java.lang.String name,
           java.lang.String description,
           int locationId,
           java.lang.String execServerHostName,
           int rmiProxyPort,
           int rmiProxyPortSSL,
           boolean useSSL,
           int appModuleID,
           int state,
           int problemAlertTimeout,
           int maxConcurrentExecutions,
           int maxBandwidth,
           boolean active) {
        super(
            id,
            name,
            description);
        this.locationId = locationId;
        this.execServerHostName = execServerHostName;
        this.rmiProxyPort = rmiProxyPort;
        this.rmiProxyPortSSL = rmiProxyPortSSL;
        this.useSSL = useSSL;
        this.appModuleID = appModuleID;
        this.state = state;
        this.problemAlertTimeout = problemAlertTimeout;
        this.maxConcurrentExecutions = maxConcurrentExecutions;
        this.maxBandwidth = maxBandwidth;
        this.active = active;
    }


    /**
     * Gets the locationId value for this ExecServer.
     * 
     * @return locationId
     */
    public int getLocationId() {
        return locationId;
    }


    /**
     * Sets the locationId value for this ExecServer.
     * 
     * @param locationId
     */
    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }


    /**
     * Gets the execServerHostName value for this ExecServer.
     * 
     * @return execServerHostName
     */
    public java.lang.String getExecServerHostName() {
        return execServerHostName;
    }


    /**
     * Sets the execServerHostName value for this ExecServer.
     * 
     * @param execServerHostName
     */
    public void setExecServerHostName(java.lang.String execServerHostName) {
        this.execServerHostName = execServerHostName;
    }


    /**
     * Gets the rmiProxyPort value for this ExecServer.
     * 
     * @return rmiProxyPort
     */
    public int getRmiProxyPort() {
        return rmiProxyPort;
    }


    /**
     * Sets the rmiProxyPort value for this ExecServer.
     * 
     * @param rmiProxyPort
     */
    public void setRmiProxyPort(int rmiProxyPort) {
        this.rmiProxyPort = rmiProxyPort;
    }


    /**
     * Gets the rmiProxyPortSSL value for this ExecServer.
     * 
     * @return rmiProxyPortSSL
     */
    public int getRmiProxyPortSSL() {
        return rmiProxyPortSSL;
    }


    /**
     * Sets the rmiProxyPortSSL value for this ExecServer.
     * 
     * @param rmiProxyPortSSL
     */
    public void setRmiProxyPortSSL(int rmiProxyPortSSL) {
        this.rmiProxyPortSSL = rmiProxyPortSSL;
    }


    /**
     * Gets the useSSL value for this ExecServer.
     * 
     * @return useSSL
     */
    public boolean isUseSSL() {
        return useSSL;
    }


    /**
     * Sets the useSSL value for this ExecServer.
     * 
     * @param useSSL
     */
    public void setUseSSL(boolean useSSL) {
        this.useSSL = useSSL;
    }


    /**
     * Gets the appModuleID value for this ExecServer.
     * 
     * @return appModuleID
     */
    public int getAppModuleID() {
        return appModuleID;
    }


    /**
     * Sets the appModuleID value for this ExecServer.
     * 
     * @param appModuleID
     */
    public void setAppModuleID(int appModuleID) {
        this.appModuleID = appModuleID;
    }


    /**
     * Gets the state value for this ExecServer.
     * 
     * @return state
     */
    public int getState() {
        return state;
    }


    /**
     * Sets the state value for this ExecServer.
     * 
     * @param state
     */
    public void setState(int state) {
        this.state = state;
    }


    /**
     * Gets the problemAlertTimeout value for this ExecServer.
     * 
     * @return problemAlertTimeout
     */
    public int getProblemAlertTimeout() {
        return problemAlertTimeout;
    }


    /**
     * Sets the problemAlertTimeout value for this ExecServer.
     * 
     * @param problemAlertTimeout
     */
    public void setProblemAlertTimeout(int problemAlertTimeout) {
        this.problemAlertTimeout = problemAlertTimeout;
    }


    /**
     * Gets the maxConcurrentExecutions value for this ExecServer.
     * 
     * @return maxConcurrentExecutions
     */
    public int getMaxConcurrentExecutions() {
        return maxConcurrentExecutions;
    }


    /**
     * Sets the maxConcurrentExecutions value for this ExecServer.
     * 
     * @param maxConcurrentExecutions
     */
    public void setMaxConcurrentExecutions(int maxConcurrentExecutions) {
        this.maxConcurrentExecutions = maxConcurrentExecutions;
    }


    /**
     * Gets the maxBandwidth value for this ExecServer.
     * 
     * @return maxBandwidth
     */
    public int getMaxBandwidth() {
        return maxBandwidth;
    }


    /**
     * Sets the maxBandwidth value for this ExecServer.
     * 
     * @param maxBandwidth
     */
    public void setMaxBandwidth(int maxBandwidth) {
        this.maxBandwidth = maxBandwidth;
    }


    /**
     * Gets the active value for this ExecServer.
     * 
     * @return active
     */
    public boolean isActive() {
        return active;
    }


    /**
     * Sets the active value for this ExecServer.
     * 
     * @param active
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExecServer)) return false;
        ExecServer other = (ExecServer) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.locationId == other.getLocationId() &&
            ((this.execServerHostName==null && other.getExecServerHostName()==null) || 
             (this.execServerHostName!=null &&
              this.execServerHostName.equals(other.getExecServerHostName()))) &&
            this.rmiProxyPort == other.getRmiProxyPort() &&
            this.rmiProxyPortSSL == other.getRmiProxyPortSSL() &&
            this.useSSL == other.isUseSSL() &&
            this.appModuleID == other.getAppModuleID() &&
            this.state == other.getState() &&
            this.problemAlertTimeout == other.getProblemAlertTimeout() &&
            this.maxConcurrentExecutions == other.getMaxConcurrentExecutions() &&
            this.maxBandwidth == other.getMaxBandwidth() &&
            this.active == other.isActive();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        _hashCode += getLocationId();
        if (getExecServerHostName() != null) {
            _hashCode += getExecServerHostName().hashCode();
        }
        _hashCode += getRmiProxyPort();
        _hashCode += getRmiProxyPortSSL();
        _hashCode += (isUseSSL() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getAppModuleID();
        _hashCode += getState();
        _hashCode += getProblemAlertTimeout();
        _hashCode += getMaxConcurrentExecutions();
        _hashCode += getMaxBandwidth();
        _hashCode += (isActive() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExecServer.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://scc.segue.com", "ExecServer"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("locationId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "locationId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("execServerHostName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "execServerHostName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rmiProxyPort");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rmiProxyPort"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rmiProxyPortSSL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rmiProxyPortSSL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("useSSL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "useSSL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("appModuleID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "appModuleID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("state");
        elemField.setXmlName(new javax.xml.namespace.QName("", "state"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("problemAlertTimeout");
        elemField.setXmlName(new javax.xml.namespace.QName("", "problemAlertTimeout"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxConcurrentExecutions");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maxConcurrentExecutions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxBandwidth");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maxBandwidth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("active");
        elemField.setXmlName(new javax.xml.namespace.QName("", "active"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
