/**
 * SPNodeProperty.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.sctm.ws.performer;

public class SPNodeProperty  implements java.io.Serializable {
    private java.lang.String msName;

    private java.lang.String msValue;

    public SPNodeProperty() {
    }

    public SPNodeProperty(
           java.lang.String msName,
           java.lang.String msValue) {
           this.msName = msName;
           this.msValue = msValue;
    }


    /**
     * Gets the msName value for this SPNodeProperty.
     * 
     * @return msName
     */
    public java.lang.String getMsName() {
        return msName;
    }


    /**
     * Sets the msName value for this SPNodeProperty.
     * 
     * @param msName
     */
    public void setMsName(java.lang.String msName) {
        this.msName = msName;
    }


    /**
     * Gets the msValue value for this SPNodeProperty.
     * 
     * @return msValue
     */
    public java.lang.String getMsValue() {
        return msValue;
    }


    /**
     * Sets the msValue value for this SPNodeProperty.
     * 
     * @param msValue
     */
    public void setMsValue(java.lang.String msValue) {
        this.msValue = msValue;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SPNodeProperty)) return false;
        SPNodeProperty other = (SPNodeProperty) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.msName==null && other.getMsName()==null) || 
             (this.msName!=null &&
              this.msName.equals(other.getMsName()))) &&
            ((this.msValue==null && other.getMsValue()==null) || 
             (this.msValue!=null &&
              this.msValue.equals(other.getMsValue())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getMsName() != null) {
            _hashCode += getMsName().hashCode();
        }
        if (getMsValue() != null) {
            _hashCode += getMsValue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SPNodeProperty.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tm.segue.com", "SPNodeProperty"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msValue"));
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
