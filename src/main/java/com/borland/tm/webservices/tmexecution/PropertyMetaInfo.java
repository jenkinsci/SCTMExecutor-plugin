/**
 * PropertyMetaInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.tm.webservices.tmexecution;

public class PropertyMetaInfo  implements java.io.Serializable {
    private java.lang.String[] allListValues;

    private java.lang.String defaultValue;

    private java.lang.String description;

    private java.lang.String formatString;

    private java.lang.String id;

    private boolean isEditable;

    private boolean isMultiSelect;

    private boolean isOptional;

    private java.lang.String name;

    private java.lang.String propertyTypeId;

    private int type;

    private java.lang.String typeLabel;

    public PropertyMetaInfo() {
    }

    public PropertyMetaInfo(
           java.lang.String[] allListValues,
           java.lang.String defaultValue,
           java.lang.String description,
           java.lang.String formatString,
           java.lang.String id,
           boolean isEditable,
           boolean isMultiSelect,
           boolean isOptional,
           java.lang.String name,
           java.lang.String propertyTypeId,
           int type,
           java.lang.String typeLabel) {
           this.allListValues = allListValues;
           this.defaultValue = defaultValue;
           this.description = description;
           this.formatString = formatString;
           this.id = id;
           this.isEditable = isEditable;
           this.isMultiSelect = isMultiSelect;
           this.isOptional = isOptional;
           this.name = name;
           this.propertyTypeId = propertyTypeId;
           this.type = type;
           this.typeLabel = typeLabel;
    }


    /**
     * Gets the allListValues value for this PropertyMetaInfo.
     * 
     * @return allListValues
     */
    public java.lang.String[] getAllListValues() {
        return allListValues;
    }


    /**
     * Sets the allListValues value for this PropertyMetaInfo.
     * 
     * @param allListValues
     */
    public void setAllListValues(java.lang.String[] allListValues) {
        this.allListValues = allListValues;
    }


    /**
     * Gets the defaultValue value for this PropertyMetaInfo.
     * 
     * @return defaultValue
     */
    public java.lang.String getDefaultValue() {
        return defaultValue;
    }


    /**
     * Sets the defaultValue value for this PropertyMetaInfo.
     * 
     * @param defaultValue
     */
    public void setDefaultValue(java.lang.String defaultValue) {
        this.defaultValue = defaultValue;
    }


    /**
     * Gets the description value for this PropertyMetaInfo.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this PropertyMetaInfo.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the formatString value for this PropertyMetaInfo.
     * 
     * @return formatString
     */
    public java.lang.String getFormatString() {
        return formatString;
    }


    /**
     * Sets the formatString value for this PropertyMetaInfo.
     * 
     * @param formatString
     */
    public void setFormatString(java.lang.String formatString) {
        this.formatString = formatString;
    }


    /**
     * Gets the id value for this PropertyMetaInfo.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this PropertyMetaInfo.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the isEditable value for this PropertyMetaInfo.
     * 
     * @return isEditable
     */
    public boolean isIsEditable() {
        return isEditable;
    }


    /**
     * Sets the isEditable value for this PropertyMetaInfo.
     * 
     * @param isEditable
     */
    public void setIsEditable(boolean isEditable) {
        this.isEditable = isEditable;
    }


    /**
     * Gets the isMultiSelect value for this PropertyMetaInfo.
     * 
     * @return isMultiSelect
     */
    public boolean isIsMultiSelect() {
        return isMultiSelect;
    }


    /**
     * Sets the isMultiSelect value for this PropertyMetaInfo.
     * 
     * @param isMultiSelect
     */
    public void setIsMultiSelect(boolean isMultiSelect) {
        this.isMultiSelect = isMultiSelect;
    }


    /**
     * Gets the isOptional value for this PropertyMetaInfo.
     * 
     * @return isOptional
     */
    public boolean isIsOptional() {
        return isOptional;
    }


    /**
     * Sets the isOptional value for this PropertyMetaInfo.
     * 
     * @param isOptional
     */
    public void setIsOptional(boolean isOptional) {
        this.isOptional = isOptional;
    }


    /**
     * Gets the name value for this PropertyMetaInfo.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this PropertyMetaInfo.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the propertyTypeId value for this PropertyMetaInfo.
     * 
     * @return propertyTypeId
     */
    public java.lang.String getPropertyTypeId() {
        return propertyTypeId;
    }


    /**
     * Sets the propertyTypeId value for this PropertyMetaInfo.
     * 
     * @param propertyTypeId
     */
    public void setPropertyTypeId(java.lang.String propertyTypeId) {
        this.propertyTypeId = propertyTypeId;
    }


    /**
     * Gets the type value for this PropertyMetaInfo.
     * 
     * @return type
     */
    public int getType() {
        return type;
    }


    /**
     * Sets the type value for this PropertyMetaInfo.
     * 
     * @param type
     */
    public void setType(int type) {
        this.type = type;
    }


    /**
     * Gets the typeLabel value for this PropertyMetaInfo.
     * 
     * @return typeLabel
     */
    public java.lang.String getTypeLabel() {
        return typeLabel;
    }


    /**
     * Sets the typeLabel value for this PropertyMetaInfo.
     * 
     * @param typeLabel
     */
    public void setTypeLabel(java.lang.String typeLabel) {
        this.typeLabel = typeLabel;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PropertyMetaInfo)) return false;
        PropertyMetaInfo other = (PropertyMetaInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.allListValues==null && other.getAllListValues()==null) || 
             (this.allListValues!=null &&
              java.util.Arrays.equals(this.allListValues, other.getAllListValues()))) &&
            ((this.defaultValue==null && other.getDefaultValue()==null) || 
             (this.defaultValue!=null &&
              this.defaultValue.equals(other.getDefaultValue()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.formatString==null && other.getFormatString()==null) || 
             (this.formatString!=null &&
              this.formatString.equals(other.getFormatString()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            this.isEditable == other.isIsEditable() &&
            this.isMultiSelect == other.isIsMultiSelect() &&
            this.isOptional == other.isIsOptional() &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.propertyTypeId==null && other.getPropertyTypeId()==null) || 
             (this.propertyTypeId!=null &&
              this.propertyTypeId.equals(other.getPropertyTypeId()))) &&
            this.type == other.getType() &&
            ((this.typeLabel==null && other.getTypeLabel()==null) || 
             (this.typeLabel!=null &&
              this.typeLabel.equals(other.getTypeLabel())));
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
        if (getAllListValues() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAllListValues());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAllListValues(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDefaultValue() != null) {
            _hashCode += getDefaultValue().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getFormatString() != null) {
            _hashCode += getFormatString().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        _hashCode += (isIsEditable() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsMultiSelect() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsOptional() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getPropertyTypeId() != null) {
            _hashCode += getPropertyTypeId().hashCode();
        }
        _hashCode += getType();
        if (getTypeLabel() != null) {
            _hashCode += getTypeLabel().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PropertyMetaInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tm.segue.com/webservices/tmexecution", "PropertyMetaInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("allListValues");
        elemField.setXmlName(new javax.xml.namespace.QName("", "allListValues"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("defaultValue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "defaultValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formatString");
        elemField.setXmlName(new javax.xml.namespace.QName("", "formatString"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isEditable");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isEditable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isMultiSelect");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isMultiSelect"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isOptional");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isOptional"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("propertyTypeId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "propertyTypeId"));
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
        elemField.setFieldName("typeLabel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "typeLabel"));
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
