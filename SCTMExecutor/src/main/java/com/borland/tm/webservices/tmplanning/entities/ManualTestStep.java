/**
 * ManualTestStep.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.tm.webservices.tmplanning.entities;

public class ManualTestStep  implements java.io.Serializable {
    private int stepPos;

    private java.lang.String name;

    private java.lang.String description;

    private java.lang.String expectedResult;

    private com.borland.tm.webservices.tmplanning.entities.CustomStepProperty[] properties;

    public ManualTestStep() {
    }

    public ManualTestStep(
           int stepPos,
           java.lang.String name,
           java.lang.String description,
           java.lang.String expectedResult,
           com.borland.tm.webservices.tmplanning.entities.CustomStepProperty[] properties) {
           this.stepPos = stepPos;
           this.name = name;
           this.description = description;
           this.expectedResult = expectedResult;
           this.properties = properties;
    }


    /**
     * Gets the stepPos value for this ManualTestStep.
     * 
     * @return stepPos
     */
    public int getStepPos() {
        return stepPos;
    }


    /**
     * Sets the stepPos value for this ManualTestStep.
     * 
     * @param stepPos
     */
    public void setStepPos(int stepPos) {
        this.stepPos = stepPos;
    }


    /**
     * Gets the name value for this ManualTestStep.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this ManualTestStep.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the description value for this ManualTestStep.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this ManualTestStep.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the expectedResult value for this ManualTestStep.
     * 
     * @return expectedResult
     */
    public java.lang.String getExpectedResult() {
        return expectedResult;
    }


    /**
     * Sets the expectedResult value for this ManualTestStep.
     * 
     * @param expectedResult
     */
    public void setExpectedResult(java.lang.String expectedResult) {
        this.expectedResult = expectedResult;
    }


    /**
     * Gets the properties value for this ManualTestStep.
     * 
     * @return properties
     */
    public com.borland.tm.webservices.tmplanning.entities.CustomStepProperty[] getProperties() {
        return properties;
    }


    /**
     * Sets the properties value for this ManualTestStep.
     * 
     * @param properties
     */
    public void setProperties(com.borland.tm.webservices.tmplanning.entities.CustomStepProperty[] properties) {
        this.properties = properties;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ManualTestStep)) return false;
        ManualTestStep other = (ManualTestStep) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.stepPos == other.getStepPos() &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.expectedResult==null && other.getExpectedResult()==null) || 
             (this.expectedResult!=null &&
              this.expectedResult.equals(other.getExpectedResult()))) &&
            ((this.properties==null && other.getProperties()==null) || 
             (this.properties!=null &&
              java.util.Arrays.equals(this.properties, other.getProperties())));
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
        _hashCode += getStepPos();
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getExpectedResult() != null) {
            _hashCode += getExpectedResult().hashCode();
        }
        if (getProperties() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProperties());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getProperties(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ManualTestStep.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tm.segue.com", "ManualTestStep"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stepPos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stepPos"));
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
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expectedResult");
        elemField.setXmlName(new javax.xml.namespace.QName("", "expectedResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("properties");
        elemField.setXmlName(new javax.xml.namespace.QName("", "properties"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tm.segue.com", "CustomStepProperty"));
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
