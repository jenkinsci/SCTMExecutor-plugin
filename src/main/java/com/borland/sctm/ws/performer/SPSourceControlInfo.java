/**
 * SPSourceControlInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.sctm.ws.performer;

public class SPSourceControlInfo  implements java.io.Serializable {
    private java.lang.String mProjectPath;

    private java.lang.String mProvider;

    private java.lang.String mRepInfo;

    private java.lang.String mUser;

    private java.lang.String mUNCUser;

    private java.lang.String mUNCPassword;

    public SPSourceControlInfo() {
    }

    public SPSourceControlInfo(
           java.lang.String mProjectPath,
           java.lang.String mProvider,
           java.lang.String mRepInfo,
           java.lang.String mUser,
           java.lang.String mUNCUser,
           java.lang.String mUNCPassword) {
           this.mProjectPath = mProjectPath;
           this.mProvider = mProvider;
           this.mRepInfo = mRepInfo;
           this.mUser = mUser;
           this.mUNCUser = mUNCUser;
           this.mUNCPassword = mUNCPassword;
    }


    /**
     * Gets the mProjectPath value for this SPSourceControlInfo.
     * 
     * @return mProjectPath
     */
    public java.lang.String getMProjectPath() {
        return mProjectPath;
    }


    /**
     * Sets the mProjectPath value for this SPSourceControlInfo.
     * 
     * @param mProjectPath
     */
    public void setMProjectPath(java.lang.String mProjectPath) {
        this.mProjectPath = mProjectPath;
    }


    /**
     * Gets the mProvider value for this SPSourceControlInfo.
     * 
     * @return mProvider
     */
    public java.lang.String getMProvider() {
        return mProvider;
    }


    /**
     * Sets the mProvider value for this SPSourceControlInfo.
     * 
     * @param mProvider
     */
    public void setMProvider(java.lang.String mProvider) {
        this.mProvider = mProvider;
    }


    /**
     * Gets the mRepInfo value for this SPSourceControlInfo.
     * 
     * @return mRepInfo
     */
    public java.lang.String getMRepInfo() {
        return mRepInfo;
    }


    /**
     * Sets the mRepInfo value for this SPSourceControlInfo.
     * 
     * @param mRepInfo
     */
    public void setMRepInfo(java.lang.String mRepInfo) {
        this.mRepInfo = mRepInfo;
    }


    /**
     * Gets the mUser value for this SPSourceControlInfo.
     * 
     * @return mUser
     */
    public java.lang.String getMUser() {
        return mUser;
    }


    /**
     * Sets the mUser value for this SPSourceControlInfo.
     * 
     * @param mUser
     */
    public void setMUser(java.lang.String mUser) {
        this.mUser = mUser;
    }


    /**
     * Gets the mUNCUser value for this SPSourceControlInfo.
     * 
     * @return mUNCUser
     */
    public java.lang.String getMUNCUser() {
        return mUNCUser;
    }


    /**
     * Sets the mUNCUser value for this SPSourceControlInfo.
     * 
     * @param mUNCUser
     */
    public void setMUNCUser(java.lang.String mUNCUser) {
        this.mUNCUser = mUNCUser;
    }


    /**
     * Gets the mUNCPassword value for this SPSourceControlInfo.
     * 
     * @return mUNCPassword
     */
    public java.lang.String getMUNCPassword() {
        return mUNCPassword;
    }


    /**
     * Sets the mUNCPassword value for this SPSourceControlInfo.
     * 
     * @param mUNCPassword
     */
    public void setMUNCPassword(java.lang.String mUNCPassword) {
        this.mUNCPassword = mUNCPassword;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SPSourceControlInfo)) return false;
        SPSourceControlInfo other = (SPSourceControlInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mProjectPath==null && other.getMProjectPath()==null) || 
             (this.mProjectPath!=null &&
              this.mProjectPath.equals(other.getMProjectPath()))) &&
            ((this.mProvider==null && other.getMProvider()==null) || 
             (this.mProvider!=null &&
              this.mProvider.equals(other.getMProvider()))) &&
            ((this.mRepInfo==null && other.getMRepInfo()==null) || 
             (this.mRepInfo!=null &&
              this.mRepInfo.equals(other.getMRepInfo()))) &&
            ((this.mUser==null && other.getMUser()==null) || 
             (this.mUser!=null &&
              this.mUser.equals(other.getMUser()))) &&
            ((this.mUNCUser==null && other.getMUNCUser()==null) || 
             (this.mUNCUser!=null &&
              this.mUNCUser.equals(other.getMUNCUser()))) &&
            ((this.mUNCPassword==null && other.getMUNCPassword()==null) || 
             (this.mUNCPassword!=null &&
              this.mUNCPassword.equals(other.getMUNCPassword())));
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
        if (getMProjectPath() != null) {
            _hashCode += getMProjectPath().hashCode();
        }
        if (getMProvider() != null) {
            _hashCode += getMProvider().hashCode();
        }
        if (getMRepInfo() != null) {
            _hashCode += getMRepInfo().hashCode();
        }
        if (getMUser() != null) {
            _hashCode += getMUser().hashCode();
        }
        if (getMUNCUser() != null) {
            _hashCode += getMUNCUser().hashCode();
        }
        if (getMUNCPassword() != null) {
            _hashCode += getMUNCPassword().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SPSourceControlInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tm.segue.com", "SPSourceControlInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MProjectPath");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mProjectPath"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MProvider");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mProvider"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MRepInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mRepInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MUser");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mUser"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MUNCUser");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mUNCUser"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MUNCPassword");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mUNCPassword"));
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
