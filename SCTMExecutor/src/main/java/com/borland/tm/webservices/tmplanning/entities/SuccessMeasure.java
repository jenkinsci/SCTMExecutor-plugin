/**
 * SuccessMeasure.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.tm.webservices.tmplanning.entities;

public class SuccessMeasure  extends com.borland.tm.webservices.tmplanning.entities.NamedEntity  implements java.io.Serializable {
    private boolean mCondWasActive;

    private float mCondMaxValue;

    private float mValue;

    public SuccessMeasure() {
    }

    public SuccessMeasure(
           int id,
           java.lang.String name,
           java.lang.String description,
           boolean mCondWasActive,
           float mCondMaxValue,
           float mValue) {
        super(
            id,
            name,
            description);
        this.mCondWasActive = mCondWasActive;
        this.mCondMaxValue = mCondMaxValue;
        this.mValue = mValue;
    }


    /**
     * Gets the mCondWasActive value for this SuccessMeasure.
     * 
     * @return mCondWasActive
     */
    public boolean isMCondWasActive() {
        return mCondWasActive;
    }


    /**
     * Sets the mCondWasActive value for this SuccessMeasure.
     * 
     * @param mCondWasActive
     */
    public void setMCondWasActive(boolean mCondWasActive) {
        this.mCondWasActive = mCondWasActive;
    }


    /**
     * Gets the mCondMaxValue value for this SuccessMeasure.
     * 
     * @return mCondMaxValue
     */
    public float getMCondMaxValue() {
        return mCondMaxValue;
    }


    /**
     * Sets the mCondMaxValue value for this SuccessMeasure.
     * 
     * @param mCondMaxValue
     */
    public void setMCondMaxValue(float mCondMaxValue) {
        this.mCondMaxValue = mCondMaxValue;
    }


    /**
     * Gets the mValue value for this SuccessMeasure.
     * 
     * @return mValue
     */
    public float getMValue() {
        return mValue;
    }


    /**
     * Sets the mValue value for this SuccessMeasure.
     * 
     * @param mValue
     */
    public void setMValue(float mValue) {
        this.mValue = mValue;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SuccessMeasure)) return false;
        SuccessMeasure other = (SuccessMeasure) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.mCondWasActive == other.isMCondWasActive() &&
            this.mCondMaxValue == other.getMCondMaxValue() &&
            this.mValue == other.getMValue();
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
        _hashCode += (isMCondWasActive() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += new Float(getMCondMaxValue()).hashCode();
        _hashCode += new Float(getMValue()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SuccessMeasure.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tm.segue.com", "SuccessMeasure"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MCondWasActive");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mCondWasActive"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MCondMaxValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mCondMaxValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
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
