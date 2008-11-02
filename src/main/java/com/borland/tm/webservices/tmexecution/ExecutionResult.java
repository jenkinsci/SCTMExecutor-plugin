/**
 * ExecutionResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.tm.webservices.tmexecution;

public class ExecutionResult  implements java.io.Serializable {
    private java.lang.String build;

    private com.borland.tm.webservices.tmexecution.TestDefinitionResult cleanupTestDef;

    private int execDefId;

    private java.lang.String execDefName;

    private java.lang.String execServerName;

    private java.lang.String[] keywords;

    private java.lang.String manualTester;

    private com.borland.tm.webservices.tmexecution.TestDefinitionResult setupTestDef;

    private com.borland.tm.webservices.tmexecution.TestDefinitionResult[] testDefResult;

    public ExecutionResult() {
    }

    public ExecutionResult(
           java.lang.String build,
           com.borland.tm.webservices.tmexecution.TestDefinitionResult cleanupTestDef,
           int execDefId,
           java.lang.String execDefName,
           java.lang.String execServerName,
           java.lang.String[] keywords,
           java.lang.String manualTester,
           com.borland.tm.webservices.tmexecution.TestDefinitionResult setupTestDef,
           com.borland.tm.webservices.tmexecution.TestDefinitionResult[] testDefResult) {
           this.build = build;
           this.cleanupTestDef = cleanupTestDef;
           this.execDefId = execDefId;
           this.execDefName = execDefName;
           this.execServerName = execServerName;
           this.keywords = keywords;
           this.manualTester = manualTester;
           this.setupTestDef = setupTestDef;
           this.testDefResult = testDefResult;
    }


    /**
     * Gets the build value for this ExecutionResult.
     * 
     * @return build
     */
    public java.lang.String getBuild() {
        return build;
    }


    /**
     * Sets the build value for this ExecutionResult.
     * 
     * @param build
     */
    public void setBuild(java.lang.String build) {
        this.build = build;
    }


    /**
     * Gets the cleanupTestDef value for this ExecutionResult.
     * 
     * @return cleanupTestDef
     */
    public com.borland.tm.webservices.tmexecution.TestDefinitionResult getCleanupTestDef() {
        return cleanupTestDef;
    }


    /**
     * Sets the cleanupTestDef value for this ExecutionResult.
     * 
     * @param cleanupTestDef
     */
    public void setCleanupTestDef(com.borland.tm.webservices.tmexecution.TestDefinitionResult cleanupTestDef) {
        this.cleanupTestDef = cleanupTestDef;
    }


    /**
     * Gets the execDefId value for this ExecutionResult.
     * 
     * @return execDefId
     */
    public int getExecDefId() {
        return execDefId;
    }


    /**
     * Sets the execDefId value for this ExecutionResult.
     * 
     * @param execDefId
     */
    public void setExecDefId(int execDefId) {
        this.execDefId = execDefId;
    }


    /**
     * Gets the execDefName value for this ExecutionResult.
     * 
     * @return execDefName
     */
    public java.lang.String getExecDefName() {
        return execDefName;
    }


    /**
     * Sets the execDefName value for this ExecutionResult.
     * 
     * @param execDefName
     */
    public void setExecDefName(java.lang.String execDefName) {
        this.execDefName = execDefName;
    }


    /**
     * Gets the execServerName value for this ExecutionResult.
     * 
     * @return execServerName
     */
    public java.lang.String getExecServerName() {
        return execServerName;
    }


    /**
     * Sets the execServerName value for this ExecutionResult.
     * 
     * @param execServerName
     */
    public void setExecServerName(java.lang.String execServerName) {
        this.execServerName = execServerName;
    }


    /**
     * Gets the keywords value for this ExecutionResult.
     * 
     * @return keywords
     */
    public java.lang.String[] getKeywords() {
        return keywords;
    }


    /**
     * Sets the keywords value for this ExecutionResult.
     * 
     * @param keywords
     */
    public void setKeywords(java.lang.String[] keywords) {
        this.keywords = keywords;
    }


    /**
     * Gets the manualTester value for this ExecutionResult.
     * 
     * @return manualTester
     */
    public java.lang.String getManualTester() {
        return manualTester;
    }


    /**
     * Sets the manualTester value for this ExecutionResult.
     * 
     * @param manualTester
     */
    public void setManualTester(java.lang.String manualTester) {
        this.manualTester = manualTester;
    }


    /**
     * Gets the setupTestDef value for this ExecutionResult.
     * 
     * @return setupTestDef
     */
    public com.borland.tm.webservices.tmexecution.TestDefinitionResult getSetupTestDef() {
        return setupTestDef;
    }


    /**
     * Sets the setupTestDef value for this ExecutionResult.
     * 
     * @param setupTestDef
     */
    public void setSetupTestDef(com.borland.tm.webservices.tmexecution.TestDefinitionResult setupTestDef) {
        this.setupTestDef = setupTestDef;
    }


    /**
     * Gets the testDefResult value for this ExecutionResult.
     * 
     * @return testDefResult
     */
    public com.borland.tm.webservices.tmexecution.TestDefinitionResult[] getTestDefResult() {
        return testDefResult;
    }


    /**
     * Sets the testDefResult value for this ExecutionResult.
     * 
     * @param testDefResult
     */
    public void setTestDefResult(com.borland.tm.webservices.tmexecution.TestDefinitionResult[] testDefResult) {
        this.testDefResult = testDefResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExecutionResult)) return false;
        ExecutionResult other = (ExecutionResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.build==null && other.getBuild()==null) || 
             (this.build!=null &&
              this.build.equals(other.getBuild()))) &&
            ((this.cleanupTestDef==null && other.getCleanupTestDef()==null) || 
             (this.cleanupTestDef!=null &&
              this.cleanupTestDef.equals(other.getCleanupTestDef()))) &&
            this.execDefId == other.getExecDefId() &&
            ((this.execDefName==null && other.getExecDefName()==null) || 
             (this.execDefName!=null &&
              this.execDefName.equals(other.getExecDefName()))) &&
            ((this.execServerName==null && other.getExecServerName()==null) || 
             (this.execServerName!=null &&
              this.execServerName.equals(other.getExecServerName()))) &&
            ((this.keywords==null && other.getKeywords()==null) || 
             (this.keywords!=null &&
              java.util.Arrays.equals(this.keywords, other.getKeywords()))) &&
            ((this.manualTester==null && other.getManualTester()==null) || 
             (this.manualTester!=null &&
              this.manualTester.equals(other.getManualTester()))) &&
            ((this.setupTestDef==null && other.getSetupTestDef()==null) || 
             (this.setupTestDef!=null &&
              this.setupTestDef.equals(other.getSetupTestDef()))) &&
            ((this.testDefResult==null && other.getTestDefResult()==null) || 
             (this.testDefResult!=null &&
              java.util.Arrays.equals(this.testDefResult, other.getTestDefResult())));
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
        if (getBuild() != null) {
            _hashCode += getBuild().hashCode();
        }
        if (getCleanupTestDef() != null) {
            _hashCode += getCleanupTestDef().hashCode();
        }
        _hashCode += getExecDefId();
        if (getExecDefName() != null) {
            _hashCode += getExecDefName().hashCode();
        }
        if (getExecServerName() != null) {
            _hashCode += getExecServerName().hashCode();
        }
        if (getKeywords() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getKeywords());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getKeywords(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getManualTester() != null) {
            _hashCode += getManualTester().hashCode();
        }
        if (getSetupTestDef() != null) {
            _hashCode += getSetupTestDef().hashCode();
        }
        if (getTestDefResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTestDefResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTestDefResult(), i);
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
        new org.apache.axis.description.TypeDesc(ExecutionResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tm.segue.com/webservices/tmexecution", "ExecutionResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("build");
        elemField.setXmlName(new javax.xml.namespace.QName("", "build"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cleanupTestDef");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cleanupTestDef"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tm.segue.com/webservices/tmexecution", "TestDefinitionResult"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("execDefId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "execDefId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("execDefName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "execDefName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("execServerName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "execServerName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("keywords");
        elemField.setXmlName(new javax.xml.namespace.QName("", "keywords"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("manualTester");
        elemField.setXmlName(new javax.xml.namespace.QName("", "manualTester"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("setupTestDef");
        elemField.setXmlName(new javax.xml.namespace.QName("", "setupTestDef"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tm.segue.com/webservices/tmexecution", "TestDefinitionResult"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("testDefResult");
        elemField.setXmlName(new javax.xml.namespace.QName("", "testDefResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tm.segue.com/webservices/tmexecution", "TestDefinitionResult"));
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
