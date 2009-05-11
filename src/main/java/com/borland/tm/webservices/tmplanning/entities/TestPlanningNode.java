/**
 * TestPlanningNode.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.tm.webservices.tmplanning.entities;

public class TestPlanningNode  extends com.borland.tm.webservices.tmplanning.entities.NamedEntity  implements java.io.Serializable {
    private com.borland.tm.webservices.tmplanning.entities.PropertyValue[] propertyValues;

    private int kind;

    public TestPlanningNode() {
    }

    public TestPlanningNode(
           int id,
           java.lang.String name,
           java.lang.String description,
           com.borland.tm.webservices.tmplanning.entities.PropertyValue[] propertyValues,
           int kind) {
        super(
            id,
            name,
            description);
        this.propertyValues = propertyValues;
        this.kind = kind;
    }


    /**
     * Gets the propertyValues value for this TestPlanningNode.
     * 
     * @return propertyValues
     */
    public com.borland.tm.webservices.tmplanning.entities.PropertyValue[] getPropertyValues() {
        return propertyValues;
    }


    /**
     * Sets the propertyValues value for this TestPlanningNode.
     * 
     * @param propertyValues
     */
    public void setPropertyValues(com.borland.tm.webservices.tmplanning.entities.PropertyValue[] propertyValues) {
        this.propertyValues = propertyValues;
    }


    /**
     * Gets the kind value for this TestPlanningNode.
     * 
     * @return kind
     */
    public int getKind() {
        return kind;
    }


    /**
     * Sets the kind value for this TestPlanningNode.
     * 
     * @param kind
     */
    public void setKind(int kind) {
        this.kind = kind;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TestPlanningNode)) return false;
        TestPlanningNode other = (TestPlanningNode) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.propertyValues==null && other.getPropertyValues()==null) || 
             (this.propertyValues!=null &&
              java.util.Arrays.equals(this.propertyValues, other.getPropertyValues()))) &&
            this.kind == other.getKind();
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
        if (getPropertyValues() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPropertyValues());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPropertyValues(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getKind();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TestPlanningNode.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tm.segue.com", "TestPlanningNode"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("propertyValues");
        elemField.setXmlName(new javax.xml.namespace.QName("", "propertyValues"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tm.segue.com", "PropertyValue"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("kind");
        elemField.setXmlName(new javax.xml.namespace.QName("", "kind"));
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
