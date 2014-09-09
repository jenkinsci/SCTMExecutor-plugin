/**
 * Attribute2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.sctm.ws.performer;

public class Attribute2  extends com.borland.sctm.ws.performer.Attribute  implements java.io.Serializable {
    private java.lang.Double maxVal;

    private java.lang.Double minVal;

    private int precision;

    public Attribute2() {
    }

    public Attribute2(
           boolean active,
           java.lang.String description,
           int id,
           java.lang.String name,
           com.borland.sctm.ws.performer.AttributeOption[] options,
           java.lang.String type,
           java.lang.Double maxVal,
           java.lang.Double minVal,
           int precision) {
        super(
            active,
            description,
            id,
            name,
            options,
            type);
        this.maxVal = maxVal;
        this.minVal = minVal;
        this.precision = precision;
    }


    /**
     * Gets the maxVal value for this Attribute2.
     * 
     * @return maxVal
     */
    public java.lang.Double getMaxVal() {
        return maxVal;
    }


    /**
     * Sets the maxVal value for this Attribute2.
     * 
     * @param maxVal
     */
    public void setMaxVal(java.lang.Double maxVal) {
        this.maxVal = maxVal;
    }


    /**
     * Gets the minVal value for this Attribute2.
     * 
     * @return minVal
     */
    public java.lang.Double getMinVal() {
        return minVal;
    }


    /**
     * Sets the minVal value for this Attribute2.
     * 
     * @param minVal
     */
    public void setMinVal(java.lang.Double minVal) {
        this.minVal = minVal;
    }


    /**
     * Gets the precision value for this Attribute2.
     * 
     * @return precision
     */
    public int getPrecision() {
        return precision;
    }


    /**
     * Sets the precision value for this Attribute2.
     * 
     * @param precision
     */
    public void setPrecision(int precision) {
        this.precision = precision;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Attribute2)) return false;
        Attribute2 other = (Attribute2) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.maxVal==null && other.getMaxVal()==null) || 
             (this.maxVal!=null &&
              this.maxVal.equals(other.getMaxVal()))) &&
            ((this.minVal==null && other.getMinVal()==null) || 
             (this.minVal!=null &&
              this.minVal.equals(other.getMinVal()))) &&
            this.precision == other.getPrecision();
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
        if (getMaxVal() != null) {
            _hashCode += getMaxVal().hashCode();
        }
        if (getMinVal() != null) {
            _hashCode += getMinVal().hashCode();
        }
        _hashCode += getPrecision();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Attribute2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tm.segue.com", "Attribute2"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxVal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maxVal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("minVal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "minVal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("precision");
        elemField.setXmlName(new javax.xml.namespace.QName("", "precision"));
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
