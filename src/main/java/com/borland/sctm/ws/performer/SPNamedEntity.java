/**
 * SPNamedEntity.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.sctm.ws.performer;

public class SPNamedEntity  implements java.io.Serializable {
    private int miId;

    private java.lang.String msName;

    private java.lang.String msDescription;

    private long msFileSize;

    public SPNamedEntity() {
    }

    public SPNamedEntity(
           int miId,
           java.lang.String msName,
           java.lang.String msDescription,
           long msFileSize) {
           this.miId = miId;
           this.msName = msName;
           this.msDescription = msDescription;
           this.msFileSize = msFileSize;
    }


    /**
     * Gets the miId value for this SPNamedEntity.
     * 
     * @return miId
     */
    public int getMiId() {
        return miId;
    }


    /**
     * Sets the miId value for this SPNamedEntity.
     * 
     * @param miId
     */
    public void setMiId(int miId) {
        this.miId = miId;
    }


    /**
     * Gets the msName value for this SPNamedEntity.
     * 
     * @return msName
     */
    public java.lang.String getMsName() {
        return msName;
    }


    /**
     * Sets the msName value for this SPNamedEntity.
     * 
     * @param msName
     */
    public void setMsName(java.lang.String msName) {
        this.msName = msName;
    }


    /**
     * Gets the msDescription value for this SPNamedEntity.
     * 
     * @return msDescription
     */
    public java.lang.String getMsDescription() {
        return msDescription;
    }


    /**
     * Sets the msDescription value for this SPNamedEntity.
     * 
     * @param msDescription
     */
    public void setMsDescription(java.lang.String msDescription) {
        this.msDescription = msDescription;
    }


    /**
     * Gets the msFileSize value for this SPNamedEntity.
     * 
     * @return msFileSize
     */
    public long getMsFileSize() {
        return msFileSize;
    }


    /**
     * Sets the msFileSize value for this SPNamedEntity.
     * 
     * @param msFileSize
     */
    public void setMsFileSize(long msFileSize) {
        this.msFileSize = msFileSize;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SPNamedEntity)) return false;
        SPNamedEntity other = (SPNamedEntity) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.miId == other.getMiId() &&
            ((this.msName==null && other.getMsName()==null) || 
             (this.msName!=null &&
              this.msName.equals(other.getMsName()))) &&
            ((this.msDescription==null && other.getMsDescription()==null) || 
             (this.msDescription!=null &&
              this.msDescription.equals(other.getMsDescription()))) &&
            this.msFileSize == other.getMsFileSize();
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
        _hashCode += getMiId();
        if (getMsName() != null) {
            _hashCode += getMsName().hashCode();
        }
        if (getMsDescription() != null) {
            _hashCode += getMsDescription().hashCode();
        }
        _hashCode += new Long(getMsFileSize()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SPNamedEntity.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tm.segue.com", "SPNamedEntity"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("miId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "miId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msFileSize");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msFileSize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
