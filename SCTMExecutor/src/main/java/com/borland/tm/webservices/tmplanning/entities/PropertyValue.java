/**
 * PropertyValue.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.tm.webservices.tmplanning.entities;

public class PropertyValue  implements java.io.Serializable {
    private com.borland.tm.webservices.tmplanning.entities.PropertyValue[] children;

    private int modifyCount;

    private java.lang.String name;

    private java.lang.String nodeID;

    private java.lang.String propertyID;

    private java.lang.String propertyTypeID;

    private int type;

    private java.lang.String value;

    public PropertyValue() {
    }

    public PropertyValue(
           com.borland.tm.webservices.tmplanning.entities.PropertyValue[] children,
           int modifyCount,
           java.lang.String name,
           java.lang.String nodeID,
           java.lang.String propertyID,
           java.lang.String propertyTypeID,
           int type,
           java.lang.String value) {
           this.children = children;
           this.modifyCount = modifyCount;
           this.name = name;
           this.nodeID = nodeID;
           this.propertyID = propertyID;
           this.propertyTypeID = propertyTypeID;
           this.type = type;
           this.value = value;
    }


    /**
     * Gets the children value for this PropertyValue.
     * 
     * @return children
     */
    public com.borland.tm.webservices.tmplanning.entities.PropertyValue[] getChildren() {
        return children;
    }


    /**
     * Sets the children value for this PropertyValue.
     * 
     * @param children
     */
    public void setChildren(com.borland.tm.webservices.tmplanning.entities.PropertyValue[] children) {
        this.children = children;
    }


    /**
     * Gets the modifyCount value for this PropertyValue.
     * 
     * @return modifyCount
     */
    public int getModifyCount() {
        return modifyCount;
    }


    /**
     * Sets the modifyCount value for this PropertyValue.
     * 
     * @param modifyCount
     */
    public void setModifyCount(int modifyCount) {
        this.modifyCount = modifyCount;
    }


    /**
     * Gets the name value for this PropertyValue.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this PropertyValue.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the nodeID value for this PropertyValue.
     * 
     * @return nodeID
     */
    public java.lang.String getNodeID() {
        return nodeID;
    }


    /**
     * Sets the nodeID value for this PropertyValue.
     * 
     * @param nodeID
     */
    public void setNodeID(java.lang.String nodeID) {
        this.nodeID = nodeID;
    }


    /**
     * Gets the propertyID value for this PropertyValue.
     * 
     * @return propertyID
     */
    public java.lang.String getPropertyID() {
        return propertyID;
    }


    /**
     * Sets the propertyID value for this PropertyValue.
     * 
     * @param propertyID
     */
    public void setPropertyID(java.lang.String propertyID) {
        this.propertyID = propertyID;
    }


    /**
     * Gets the propertyTypeID value for this PropertyValue.
     * 
     * @return propertyTypeID
     */
    public java.lang.String getPropertyTypeID() {
        return propertyTypeID;
    }


    /**
     * Sets the propertyTypeID value for this PropertyValue.
     * 
     * @param propertyTypeID
     */
    public void setPropertyTypeID(java.lang.String propertyTypeID) {
        this.propertyTypeID = propertyTypeID;
    }


    /**
     * Gets the type value for this PropertyValue.
     * 
     * @return type
     */
    public int getType() {
        return type;
    }


    /**
     * Sets the type value for this PropertyValue.
     * 
     * @param type
     */
    public void setType(int type) {
        this.type = type;
    }


    /**
     * Gets the value value for this PropertyValue.
     * 
     * @return value
     */
    public java.lang.String getValue() {
        return value;
    }


    /**
     * Sets the value value for this PropertyValue.
     * 
     * @param value
     */
    public void setValue(java.lang.String value) {
        this.value = value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PropertyValue)) return false;
        PropertyValue other = (PropertyValue) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.children==null && other.getChildren()==null) || 
             (this.children!=null &&
              java.util.Arrays.equals(this.children, other.getChildren()))) &&
            this.modifyCount == other.getModifyCount() &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.nodeID==null && other.getNodeID()==null) || 
             (this.nodeID!=null &&
              this.nodeID.equals(other.getNodeID()))) &&
            ((this.propertyID==null && other.getPropertyID()==null) || 
             (this.propertyID!=null &&
              this.propertyID.equals(other.getPropertyID()))) &&
            ((this.propertyTypeID==null && other.getPropertyTypeID()==null) || 
             (this.propertyTypeID!=null &&
              this.propertyTypeID.equals(other.getPropertyTypeID()))) &&
            this.type == other.getType() &&
            ((this.value==null && other.getValue()==null) || 
             (this.value!=null &&
              this.value.equals(other.getValue())));
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
        if (getChildren() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getChildren());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getChildren(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getModifyCount();
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getNodeID() != null) {
            _hashCode += getNodeID().hashCode();
        }
        if (getPropertyID() != null) {
            _hashCode += getPropertyID().hashCode();
        }
        if (getPropertyTypeID() != null) {
            _hashCode += getPropertyTypeID().hashCode();
        }
        _hashCode += getType();
        if (getValue() != null) {
            _hashCode += getValue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PropertyValue.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tm.segue.com", "PropertyValue"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("children");
        elemField.setXmlName(new javax.xml.namespace.QName("", "children"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tm.segue.com", "PropertyValue"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modifyCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "modifyCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nodeID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nodeID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("propertyID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "propertyID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("propertyTypeID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "propertyTypeID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("value");
        elemField.setXmlName(new javax.xml.namespace.QName("", "value"));
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
