/**
 * TestDefinitionResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.tm.webservices.tmexecution;

public class TestDefinitionResult  implements java.io.Serializable {
    private int duration;

    private int errorCount;

    private int execDefRunId;

    private java.lang.String name;

    private java.lang.String resultURL;

    private int status;

    private int testDefId;

    private int testRunId;

    private int typeId;

    private int warningCount;

    public TestDefinitionResult() {
    }

    public TestDefinitionResult(
           int duration,
           int errorCount,
           int execDefRunId,
           java.lang.String name,
           java.lang.String resultURL,
           int status,
           int testDefId,
           int testRunId,
           int typeId,
           int warningCount) {
           this.duration = duration;
           this.errorCount = errorCount;
           this.execDefRunId = execDefRunId;
           this.name = name;
           this.resultURL = resultURL;
           this.status = status;
           this.testDefId = testDefId;
           this.testRunId = testRunId;
           this.typeId = typeId;
           this.warningCount = warningCount;
    }


    /**
     * Gets the duration value for this TestDefinitionResult.
     * 
     * @return duration
     */
    public int getDuration() {
        return duration;
    }


    /**
     * Sets the duration value for this TestDefinitionResult.
     * 
     * @param duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }


    /**
     * Gets the errorCount value for this TestDefinitionResult.
     * 
     * @return errorCount
     */
    public int getErrorCount() {
        return errorCount;
    }


    /**
     * Sets the errorCount value for this TestDefinitionResult.
     * 
     * @param errorCount
     */
    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
    }


    /**
     * Gets the execDefRunId value for this TestDefinitionResult.
     * 
     * @return execDefRunId
     */
    public int getExecDefRunId() {
        return execDefRunId;
    }


    /**
     * Sets the execDefRunId value for this TestDefinitionResult.
     * 
     * @param execDefRunId
     */
    public void setExecDefRunId(int execDefRunId) {
        this.execDefRunId = execDefRunId;
    }


    /**
     * Gets the name value for this TestDefinitionResult.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this TestDefinitionResult.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the resultURL value for this TestDefinitionResult.
     * 
     * @return resultURL
     */
    public java.lang.String getResultURL() {
        return resultURL;
    }


    /**
     * Sets the resultURL value for this TestDefinitionResult.
     * 
     * @param resultURL
     */
    public void setResultURL(java.lang.String resultURL) {
        this.resultURL = resultURL;
    }


    /**
     * Gets the status value for this TestDefinitionResult.
     * 
     * @return status
     */
    public int getStatus() {
        return status;
    }


    /**
     * Sets the status value for this TestDefinitionResult.
     * 
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }


    /**
     * Gets the testDefId value for this TestDefinitionResult.
     * 
     * @return testDefId
     */
    public int getTestDefId() {
        return testDefId;
    }


    /**
     * Sets the testDefId value for this TestDefinitionResult.
     * 
     * @param testDefId
     */
    public void setTestDefId(int testDefId) {
        this.testDefId = testDefId;
    }


    /**
     * Gets the testRunId value for this TestDefinitionResult.
     * 
     * @return testRunId
     */
    public int getTestRunId() {
        return testRunId;
    }


    /**
     * Sets the testRunId value for this TestDefinitionResult.
     * 
     * @param testRunId
     */
    public void setTestRunId(int testRunId) {
        this.testRunId = testRunId;
    }


    /**
     * Gets the typeId value for this TestDefinitionResult.
     * 
     * @return typeId
     */
    public int getTypeId() {
        return typeId;
    }


    /**
     * Sets the typeId value for this TestDefinitionResult.
     * 
     * @param typeId
     */
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }


    /**
     * Gets the warningCount value for this TestDefinitionResult.
     * 
     * @return warningCount
     */
    public int getWarningCount() {
        return warningCount;
    }


    /**
     * Sets the warningCount value for this TestDefinitionResult.
     * 
     * @param warningCount
     */
    public void setWarningCount(int warningCount) {
        this.warningCount = warningCount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TestDefinitionResult)) return false;
        TestDefinitionResult other = (TestDefinitionResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.duration == other.getDuration() &&
            this.errorCount == other.getErrorCount() &&
            this.execDefRunId == other.getExecDefRunId() &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.resultURL==null && other.getResultURL()==null) || 
             (this.resultURL!=null &&
              this.resultURL.equals(other.getResultURL()))) &&
            this.status == other.getStatus() &&
            this.testDefId == other.getTestDefId() &&
            this.testRunId == other.getTestRunId() &&
            this.typeId == other.getTypeId() &&
            this.warningCount == other.getWarningCount();
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
        _hashCode += getDuration();
        _hashCode += getErrorCount();
        _hashCode += getExecDefRunId();
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getResultURL() != null) {
            _hashCode += getResultURL().hashCode();
        }
        _hashCode += getStatus();
        _hashCode += getTestDefId();
        _hashCode += getTestRunId();
        _hashCode += getTypeId();
        _hashCode += getWarningCount();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TestDefinitionResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tm.segue.com/webservices/tmexecution", "TestDefinitionResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("duration");
        elemField.setXmlName(new javax.xml.namespace.QName("", "duration"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "errorCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("execDefRunId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "execDefRunId"));
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
        elemField.setFieldName("resultURL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultURL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("testDefId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "testDefId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("testRunId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "testRunId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("typeId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "typeId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("warningCount");
        elemField.setXmlName(new javax.xml.namespace.QName("", "warningCount"));
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
