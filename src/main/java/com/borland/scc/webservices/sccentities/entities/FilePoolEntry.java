/**
 * FilePoolEntry.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.scc.webservices.sccentities.entities;

public class FilePoolEntry  extends com.borland.scc.webservices.sccentities.entities.NamedEntity  implements java.io.Serializable {
    private java.lang.String fullPathName;

    public FilePoolEntry() {
    }

    public FilePoolEntry(
           int id,
           java.lang.String name,
           java.lang.String description,
           java.lang.String fullPathName) {
        super(
            id,
            name,
            description);
        this.fullPathName = fullPathName;
    }


    /**
     * Gets the fullPathName value for this FilePoolEntry.
     * 
     * @return fullPathName
     */
    public java.lang.String getFullPathName() {
        return fullPathName;
    }


    /**
     * Sets the fullPathName value for this FilePoolEntry.
     * 
     * @param fullPathName
     */
    public void setFullPathName(java.lang.String fullPathName) {
        this.fullPathName = fullPathName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FilePoolEntry)) return false;
        FilePoolEntry other = (FilePoolEntry) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.fullPathName==null && other.getFullPathName()==null) || 
             (this.fullPathName!=null &&
              this.fullPathName.equals(other.getFullPathName())));
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
        if (getFullPathName() != null) {
            _hashCode += getFullPathName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FilePoolEntry.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://scc.segue.com", "FilePoolEntry"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fullPathName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fullPathName"));
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
