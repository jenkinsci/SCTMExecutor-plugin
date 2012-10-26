/**
 * SPExecution.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.sctm.ws.performer;

public class SPExecution  implements java.io.Serializable {
    private int miId;

    private java.lang.String msName;

    private java.lang.String msExecutionDefinition;

    private int miTimestamp;

    private int miTestDefinitionId;

    private java.lang.String msExecutionServer;

    private int miStatus;

    private int miVersion;

    private int miBuild;

    private java.lang.String mVersionName;

    private java.lang.String mBuildName;

    public SPExecution() {
    }

    public SPExecution(
           int miId,
           java.lang.String msName,
           java.lang.String msExecutionDefinition,
           int miTimestamp,
           int miTestDefinitionId,
           java.lang.String msExecutionServer,
           int miStatus,
           int miVersion,
           int miBuild,
           java.lang.String mVersionName,
           java.lang.String mBuildName) {
           this.miId = miId;
           this.msName = msName;
           this.msExecutionDefinition = msExecutionDefinition;
           this.miTimestamp = miTimestamp;
           this.miTestDefinitionId = miTestDefinitionId;
           this.msExecutionServer = msExecutionServer;
           this.miStatus = miStatus;
           this.miVersion = miVersion;
           this.miBuild = miBuild;
           this.mVersionName = mVersionName;
           this.mBuildName = mBuildName;
    }


    /**
     * Gets the miId value for this SPExecution.
     * 
     * @return miId
     */
    public int getMiId() {
        return miId;
    }


    /**
     * Sets the miId value for this SPExecution.
     * 
     * @param miId
     */
    public void setMiId(int miId) {
        this.miId = miId;
    }


    /**
     * Gets the msName value for this SPExecution.
     * 
     * @return msName
     */
    public java.lang.String getMsName() {
        return msName;
    }


    /**
     * Sets the msName value for this SPExecution.
     * 
     * @param msName
     */
    public void setMsName(java.lang.String msName) {
        this.msName = msName;
    }


    /**
     * Gets the msExecutionDefinition value for this SPExecution.
     * 
     * @return msExecutionDefinition
     */
    public java.lang.String getMsExecutionDefinition() {
        return msExecutionDefinition;
    }


    /**
     * Sets the msExecutionDefinition value for this SPExecution.
     * 
     * @param msExecutionDefinition
     */
    public void setMsExecutionDefinition(java.lang.String msExecutionDefinition) {
        this.msExecutionDefinition = msExecutionDefinition;
    }


    /**
     * Gets the miTimestamp value for this SPExecution.
     * 
     * @return miTimestamp
     */
    public int getMiTimestamp() {
        return miTimestamp;
    }


    /**
     * Sets the miTimestamp value for this SPExecution.
     * 
     * @param miTimestamp
     */
    public void setMiTimestamp(int miTimestamp) {
        this.miTimestamp = miTimestamp;
    }


    /**
     * Gets the miTestDefinitionId value for this SPExecution.
     * 
     * @return miTestDefinitionId
     */
    public int getMiTestDefinitionId() {
        return miTestDefinitionId;
    }


    /**
     * Sets the miTestDefinitionId value for this SPExecution.
     * 
     * @param miTestDefinitionId
     */
    public void setMiTestDefinitionId(int miTestDefinitionId) {
        this.miTestDefinitionId = miTestDefinitionId;
    }


    /**
     * Gets the msExecutionServer value for this SPExecution.
     * 
     * @return msExecutionServer
     */
    public java.lang.String getMsExecutionServer() {
        return msExecutionServer;
    }


    /**
     * Sets the msExecutionServer value for this SPExecution.
     * 
     * @param msExecutionServer
     */
    public void setMsExecutionServer(java.lang.String msExecutionServer) {
        this.msExecutionServer = msExecutionServer;
    }


    /**
     * Gets the miStatus value for this SPExecution.
     * 
     * @return miStatus
     */
    public int getMiStatus() {
        return miStatus;
    }


    /**
     * Sets the miStatus value for this SPExecution.
     * 
     * @param miStatus
     */
    public void setMiStatus(int miStatus) {
        this.miStatus = miStatus;
    }


    /**
     * Gets the miVersion value for this SPExecution.
     * 
     * @return miVersion
     */
    public int getMiVersion() {
        return miVersion;
    }


    /**
     * Sets the miVersion value for this SPExecution.
     * 
     * @param miVersion
     */
    public void setMiVersion(int miVersion) {
        this.miVersion = miVersion;
    }


    /**
     * Gets the miBuild value for this SPExecution.
     * 
     * @return miBuild
     */
    public int getMiBuild() {
        return miBuild;
    }


    /**
     * Sets the miBuild value for this SPExecution.
     * 
     * @param miBuild
     */
    public void setMiBuild(int miBuild) {
        this.miBuild = miBuild;
    }


    /**
     * Gets the mVersionName value for this SPExecution.
     * 
     * @return mVersionName
     */
    public java.lang.String getMVersionName() {
        return mVersionName;
    }


    /**
     * Sets the mVersionName value for this SPExecution.
     * 
     * @param mVersionName
     */
    public void setMVersionName(java.lang.String mVersionName) {
        this.mVersionName = mVersionName;
    }


    /**
     * Gets the mBuildName value for this SPExecution.
     * 
     * @return mBuildName
     */
    public java.lang.String getMBuildName() {
        return mBuildName;
    }


    /**
     * Sets the mBuildName value for this SPExecution.
     * 
     * @param mBuildName
     */
    public void setMBuildName(java.lang.String mBuildName) {
        this.mBuildName = mBuildName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SPExecution)) return false;
        SPExecution other = (SPExecution) obj;
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
            ((this.msExecutionDefinition==null && other.getMsExecutionDefinition()==null) || 
             (this.msExecutionDefinition!=null &&
              this.msExecutionDefinition.equals(other.getMsExecutionDefinition()))) &&
            this.miTimestamp == other.getMiTimestamp() &&
            this.miTestDefinitionId == other.getMiTestDefinitionId() &&
            ((this.msExecutionServer==null && other.getMsExecutionServer()==null) || 
             (this.msExecutionServer!=null &&
              this.msExecutionServer.equals(other.getMsExecutionServer()))) &&
            this.miStatus == other.getMiStatus() &&
            this.miVersion == other.getMiVersion() &&
            this.miBuild == other.getMiBuild() &&
            ((this.mVersionName==null && other.getMVersionName()==null) || 
             (this.mVersionName!=null &&
              this.mVersionName.equals(other.getMVersionName()))) &&
            ((this.mBuildName==null && other.getMBuildName()==null) || 
             (this.mBuildName!=null &&
              this.mBuildName.equals(other.getMBuildName())));
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
        if (getMsExecutionDefinition() != null) {
            _hashCode += getMsExecutionDefinition().hashCode();
        }
        _hashCode += getMiTimestamp();
        _hashCode += getMiTestDefinitionId();
        if (getMsExecutionServer() != null) {
            _hashCode += getMsExecutionServer().hashCode();
        }
        _hashCode += getMiStatus();
        _hashCode += getMiVersion();
        _hashCode += getMiBuild();
        if (getMVersionName() != null) {
            _hashCode += getMVersionName().hashCode();
        }
        if (getMBuildName() != null) {
            _hashCode += getMBuildName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SPExecution.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tm.segue.com", "SPExecution"));
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
        elemField.setFieldName("msExecutionDefinition");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msExecutionDefinition"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("miTimestamp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "miTimestamp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("miTestDefinitionId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "miTestDefinitionId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msExecutionServer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msExecutionServer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("miStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "miStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("miVersion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "miVersion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("miBuild");
        elemField.setXmlName(new javax.xml.namespace.QName("", "miBuild"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MVersionName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mVersionName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MBuildName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mBuildName"));
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
