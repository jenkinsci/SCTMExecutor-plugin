/**
 * NodeFilter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.tm.webservices.tmplanning.entities;

public class NodeFilter  implements java.io.Serializable {
    private int testPlanningFilterId;

    private java.lang.String createdBy;

    private java.lang.String testDefinitionType;

    public NodeFilter() {
    }

    public NodeFilter(
           int testPlanningFilterId,
           java.lang.String createdBy,
           java.lang.String testDefinitionType) {
           this.testPlanningFilterId = testPlanningFilterId;
           this.createdBy = createdBy;
           this.testDefinitionType = testDefinitionType;
    }


    /**
     * Gets the testPlanningFilterId value for this NodeFilter.
     * 
     * @return testPlanningFilterId
     */
    public int getTestPlanningFilterId() {
        return testPlanningFilterId;
    }


    /**
     * Sets the testPlanningFilterId value for this NodeFilter.
     * 
     * @param testPlanningFilterId
     */
    public void setTestPlanningFilterId(int testPlanningFilterId) {
        this.testPlanningFilterId = testPlanningFilterId;
    }


    /**
     * Gets the createdBy value for this NodeFilter.
     * 
     * @return createdBy
     */
    public java.lang.String getCreatedBy() {
        return createdBy;
    }


    /**
     * Sets the createdBy value for this NodeFilter.
     * 
     * @param createdBy
     */
    public void setCreatedBy(java.lang.String createdBy) {
        this.createdBy = createdBy;
    }


    /**
     * Gets the testDefinitionType value for this NodeFilter.
     * 
     * @return testDefinitionType
     */
    public java.lang.String getTestDefinitionType() {
        return testDefinitionType;
    }


    /**
     * Sets the testDefinitionType value for this NodeFilter.
     * 
     * @param testDefinitionType
     */
    public void setTestDefinitionType(java.lang.String testDefinitionType) {
        this.testDefinitionType = testDefinitionType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NodeFilter)) return false;
        NodeFilter other = (NodeFilter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.testPlanningFilterId == other.getTestPlanningFilterId() &&
            ((this.createdBy==null && other.getCreatedBy()==null) || 
             (this.createdBy!=null &&
              this.createdBy.equals(other.getCreatedBy()))) &&
            ((this.testDefinitionType==null && other.getTestDefinitionType()==null) || 
             (this.testDefinitionType!=null &&
              this.testDefinitionType.equals(other.getTestDefinitionType())));
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
        _hashCode += getTestPlanningFilterId();
        if (getCreatedBy() != null) {
            _hashCode += getCreatedBy().hashCode();
        }
        if (getTestDefinitionType() != null) {
            _hashCode += getTestDefinitionType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NodeFilter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tm.segue.com", "NodeFilter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("testPlanningFilterId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "testPlanningFilterId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("createdBy");
        elemField.setXmlName(new javax.xml.namespace.QName("", "createdBy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("testDefinitionType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "testDefinitionType"));
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
