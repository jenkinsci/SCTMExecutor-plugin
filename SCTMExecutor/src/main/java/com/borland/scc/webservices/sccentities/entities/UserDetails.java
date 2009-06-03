/**
 * UserDetails.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.scc.webservices.sccentities.entities;

public class UserDetails  extends com.borland.scc.webservices.sccentities.entities.User  implements java.io.Serializable {
    private int[] assignedProjects;

    private int roleId;

    private java.lang.String eMail;

    private java.lang.String timeZoneId;

    private java.lang.String dateFormat;

    private java.lang.String shortDateFormat;

    private int firstDayOfWeek;

    private int pageRefreshTime;

    private java.lang.String separatorString;

    public UserDetails() {
    }

    public UserDetails(
           int id,
           java.lang.String name,
           java.lang.String description,
           boolean isLocked,
           java.lang.String firstName,
           java.lang.String login,
           int[] assignedProjects,
           int roleId,
           java.lang.String eMail,
           java.lang.String timeZoneId,
           java.lang.String dateFormat,
           java.lang.String shortDateFormat,
           int firstDayOfWeek,
           int pageRefreshTime,
           java.lang.String separatorString) {
        super(
            id,
            name,
            description,
            isLocked,
            firstName,
            login);
        this.assignedProjects = assignedProjects;
        this.roleId = roleId;
        this.eMail = eMail;
        this.timeZoneId = timeZoneId;
        this.dateFormat = dateFormat;
        this.shortDateFormat = shortDateFormat;
        this.firstDayOfWeek = firstDayOfWeek;
        this.pageRefreshTime = pageRefreshTime;
        this.separatorString = separatorString;
    }


    /**
     * Gets the assignedProjects value for this UserDetails.
     * 
     * @return assignedProjects
     */
    public int[] getAssignedProjects() {
        return assignedProjects;
    }


    /**
     * Sets the assignedProjects value for this UserDetails.
     * 
     * @param assignedProjects
     */
    public void setAssignedProjects(int[] assignedProjects) {
        this.assignedProjects = assignedProjects;
    }


    /**
     * Gets the roleId value for this UserDetails.
     * 
     * @return roleId
     */
    public int getRoleId() {
        return roleId;
    }


    /**
     * Sets the roleId value for this UserDetails.
     * 
     * @param roleId
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }


    /**
     * Gets the eMail value for this UserDetails.
     * 
     * @return eMail
     */
    public java.lang.String getEMail() {
        return eMail;
    }


    /**
     * Sets the eMail value for this UserDetails.
     * 
     * @param eMail
     */
    public void setEMail(java.lang.String eMail) {
        this.eMail = eMail;
    }


    /**
     * Gets the timeZoneId value for this UserDetails.
     * 
     * @return timeZoneId
     */
    public java.lang.String getTimeZoneId() {
        return timeZoneId;
    }


    /**
     * Sets the timeZoneId value for this UserDetails.
     * 
     * @param timeZoneId
     */
    public void setTimeZoneId(java.lang.String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }


    /**
     * Gets the dateFormat value for this UserDetails.
     * 
     * @return dateFormat
     */
    public java.lang.String getDateFormat() {
        return dateFormat;
    }


    /**
     * Sets the dateFormat value for this UserDetails.
     * 
     * @param dateFormat
     */
    public void setDateFormat(java.lang.String dateFormat) {
        this.dateFormat = dateFormat;
    }


    /**
     * Gets the shortDateFormat value for this UserDetails.
     * 
     * @return shortDateFormat
     */
    public java.lang.String getShortDateFormat() {
        return shortDateFormat;
    }


    /**
     * Sets the shortDateFormat value for this UserDetails.
     * 
     * @param shortDateFormat
     */
    public void setShortDateFormat(java.lang.String shortDateFormat) {
        this.shortDateFormat = shortDateFormat;
    }


    /**
     * Gets the firstDayOfWeek value for this UserDetails.
     * 
     * @return firstDayOfWeek
     */
    public int getFirstDayOfWeek() {
        return firstDayOfWeek;
    }


    /**
     * Sets the firstDayOfWeek value for this UserDetails.
     * 
     * @param firstDayOfWeek
     */
    public void setFirstDayOfWeek(int firstDayOfWeek) {
        this.firstDayOfWeek = firstDayOfWeek;
    }


    /**
     * Gets the pageRefreshTime value for this UserDetails.
     * 
     * @return pageRefreshTime
     */
    public int getPageRefreshTime() {
        return pageRefreshTime;
    }


    /**
     * Sets the pageRefreshTime value for this UserDetails.
     * 
     * @param pageRefreshTime
     */
    public void setPageRefreshTime(int pageRefreshTime) {
        this.pageRefreshTime = pageRefreshTime;
    }


    /**
     * Gets the separatorString value for this UserDetails.
     * 
     * @return separatorString
     */
    public java.lang.String getSeparatorString() {
        return separatorString;
    }


    /**
     * Sets the separatorString value for this UserDetails.
     * 
     * @param separatorString
     */
    public void setSeparatorString(java.lang.String separatorString) {
        this.separatorString = separatorString;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UserDetails)) return false;
        UserDetails other = (UserDetails) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.assignedProjects==null && other.getAssignedProjects()==null) || 
             (this.assignedProjects!=null &&
              java.util.Arrays.equals(this.assignedProjects, other.getAssignedProjects()))) &&
            this.roleId == other.getRoleId() &&
            ((this.eMail==null && other.getEMail()==null) || 
             (this.eMail!=null &&
              this.eMail.equals(other.getEMail()))) &&
            ((this.timeZoneId==null && other.getTimeZoneId()==null) || 
             (this.timeZoneId!=null &&
              this.timeZoneId.equals(other.getTimeZoneId()))) &&
            ((this.dateFormat==null && other.getDateFormat()==null) || 
             (this.dateFormat!=null &&
              this.dateFormat.equals(other.getDateFormat()))) &&
            ((this.shortDateFormat==null && other.getShortDateFormat()==null) || 
             (this.shortDateFormat!=null &&
              this.shortDateFormat.equals(other.getShortDateFormat()))) &&
            this.firstDayOfWeek == other.getFirstDayOfWeek() &&
            this.pageRefreshTime == other.getPageRefreshTime() &&
            ((this.separatorString==null && other.getSeparatorString()==null) || 
             (this.separatorString!=null &&
              this.separatorString.equals(other.getSeparatorString())));
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
        if (getAssignedProjects() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAssignedProjects());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAssignedProjects(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getRoleId();
        if (getEMail() != null) {
            _hashCode += getEMail().hashCode();
        }
        if (getTimeZoneId() != null) {
            _hashCode += getTimeZoneId().hashCode();
        }
        if (getDateFormat() != null) {
            _hashCode += getDateFormat().hashCode();
        }
        if (getShortDateFormat() != null) {
            _hashCode += getShortDateFormat().hashCode();
        }
        _hashCode += getFirstDayOfWeek();
        _hashCode += getPageRefreshTime();
        if (getSeparatorString() != null) {
            _hashCode += getSeparatorString().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UserDetails.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://scc.segue.com", "UserDetails"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("assignedProjects");
        elemField.setXmlName(new javax.xml.namespace.QName("", "assignedProjects"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("roleId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "roleId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EMail");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eMail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeZoneId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "timeZoneId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateFormat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dateFormat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shortDateFormat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "shortDateFormat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("firstDayOfWeek");
        elemField.setXmlName(new javax.xml.namespace.QName("", "firstDayOfWeek"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pageRefreshTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pageRefreshTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("separatorString");
        elemField.setXmlName(new javax.xml.namespace.QName("", "separatorString"));
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
