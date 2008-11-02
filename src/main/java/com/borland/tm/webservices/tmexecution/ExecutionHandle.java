/**
 * ExecutionHandle.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.tm.webservices.tmexecution;

public class ExecutionHandle  implements java.io.Serializable {
    private int execDefId;

    private long timeStamp;

    public ExecutionHandle() {
    }

    public ExecutionHandle(
           int execDefId,
           long timeStamp) {
           this.execDefId = execDefId;
           this.timeStamp = timeStamp;
    }


    /**
     * Gets the execDefId value for this ExecutionHandle.
     * 
     * @return execDefId
     */
    public int getExecDefId() {
        return execDefId;
    }


    /**
     * Sets the execDefId value for this ExecutionHandle.
     * 
     * @param execDefId
     */
    public void setExecDefId(int execDefId) {
        this.execDefId = execDefId;
    }


    /**
     * Gets the timeStamp value for this ExecutionHandle.
     * 
     * @return timeStamp
     */
    public long getTimeStamp() {
        return timeStamp;
    }


    /**
     * Sets the timeStamp value for this ExecutionHandle.
     * 
     * @param timeStamp
     */
    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExecutionHandle)) return false;
        ExecutionHandle other = (ExecutionHandle) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.execDefId == other.getExecDefId() &&
            this.timeStamp == other.getTimeStamp();
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
        _hashCode += getExecDefId();
        _hashCode += new Long(getTimeStamp()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExecutionHandle.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tm.segue.com/webservices/tmexecution", "ExecutionHandle"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("execDefId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "execDefId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeStamp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "timeStamp"));
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
