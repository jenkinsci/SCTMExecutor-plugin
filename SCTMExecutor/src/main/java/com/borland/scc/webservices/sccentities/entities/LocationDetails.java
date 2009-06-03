/**
 * LocationDetails.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.scc.webservices.sccentities.entities;

public class LocationDetails  extends com.borland.scc.webservices.sccentities.entities.Location  implements java.io.Serializable {
    private boolean useCentralProxy;

    private int proxyType;

    private java.lang.String proxyHostName;

    private int proxyPort;

    public LocationDetails() {
    }

    public LocationDetails(
           int id,
           java.lang.String name,
           java.lang.String description,
           boolean isActive,
           boolean useCentralProxy,
           int proxyType,
           java.lang.String proxyHostName,
           int proxyPort) {
        super(
            id,
            name,
            description,
            isActive);
        this.useCentralProxy = useCentralProxy;
        this.proxyType = proxyType;
        this.proxyHostName = proxyHostName;
        this.proxyPort = proxyPort;
    }


    /**
     * Gets the useCentralProxy value for this LocationDetails.
     * 
     * @return useCentralProxy
     */
    public boolean isUseCentralProxy() {
        return useCentralProxy;
    }


    /**
     * Sets the useCentralProxy value for this LocationDetails.
     * 
     * @param useCentralProxy
     */
    public void setUseCentralProxy(boolean useCentralProxy) {
        this.useCentralProxy = useCentralProxy;
    }


    /**
     * Gets the proxyType value for this LocationDetails.
     * 
     * @return proxyType
     */
    public int getProxyType() {
        return proxyType;
    }


    /**
     * Sets the proxyType value for this LocationDetails.
     * 
     * @param proxyType
     */
    public void setProxyType(int proxyType) {
        this.proxyType = proxyType;
    }


    /**
     * Gets the proxyHostName value for this LocationDetails.
     * 
     * @return proxyHostName
     */
    public java.lang.String getProxyHostName() {
        return proxyHostName;
    }


    /**
     * Sets the proxyHostName value for this LocationDetails.
     * 
     * @param proxyHostName
     */
    public void setProxyHostName(java.lang.String proxyHostName) {
        this.proxyHostName = proxyHostName;
    }


    /**
     * Gets the proxyPort value for this LocationDetails.
     * 
     * @return proxyPort
     */
    public int getProxyPort() {
        return proxyPort;
    }


    /**
     * Sets the proxyPort value for this LocationDetails.
     * 
     * @param proxyPort
     */
    public void setProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LocationDetails)) return false;
        LocationDetails other = (LocationDetails) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.useCentralProxy == other.isUseCentralProxy() &&
            this.proxyType == other.getProxyType() &&
            ((this.proxyHostName==null && other.getProxyHostName()==null) || 
             (this.proxyHostName!=null &&
              this.proxyHostName.equals(other.getProxyHostName()))) &&
            this.proxyPort == other.getProxyPort();
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
        _hashCode += (isUseCentralProxy() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getProxyType();
        if (getProxyHostName() != null) {
            _hashCode += getProxyHostName().hashCode();
        }
        _hashCode += getProxyPort();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LocationDetails.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://scc.segue.com", "LocationDetails"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("useCentralProxy");
        elemField.setXmlName(new javax.xml.namespace.QName("", "useCentralProxy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("proxyType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "proxyType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("proxyHostName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "proxyHostName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("proxyPort");
        elemField.setXmlName(new javax.xml.namespace.QName("", "proxyPort"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
