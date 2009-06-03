/**
 * ExtendedAppModule.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.scc;

public class ExtendedAppModule  extends com.borland.scc.AppModule  implements java.io.Serializable {
    private java.lang.String buildNumber;

    public ExtendedAppModule() {
    }

    public ExtendedAppModule(
           int id,
           java.lang.String name,
           java.lang.String description,
           java.lang.String buildNumber) {
        super(
            id,
            name,
            description);
        this.buildNumber = buildNumber;
    }


    /**
     * Gets the buildNumber value for this ExtendedAppModule.
     * 
     * @return buildNumber
     */
    public java.lang.String getBuildNumber() {
        return buildNumber;
    }


    /**
     * Sets the buildNumber value for this ExtendedAppModule.
     * 
     * @param buildNumber
     */
    public void setBuildNumber(java.lang.String buildNumber) {
        this.buildNumber = buildNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExtendedAppModule)) return false;
        ExtendedAppModule other = (ExtendedAppModule) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.buildNumber==null && other.getBuildNumber()==null) || 
             (this.buildNumber!=null &&
              this.buildNumber.equals(other.getBuildNumber())));
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
        if (getBuildNumber() != null) {
            _hashCode += getBuildNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExtendedAppModule.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://scc.segue.com", "ExtendedAppModule"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("buildNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "buildNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
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
