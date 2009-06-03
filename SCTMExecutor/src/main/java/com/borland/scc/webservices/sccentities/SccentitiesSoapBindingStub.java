/**
 * SccentitiesSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.borland.scc.webservices.sccentities;

public class SccentitiesSoapBindingStub extends org.apache.axis.client.Stub implements com.borland.scc.webservices.sccentities.MainEntities {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[62];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
        _initOperationDesc4();
        _initOperationDesc5();
        _initOperationDesc6();
        _initOperationDesc7();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getAllRoles");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://scc.segue.com", "ArrayOfRole"));
        oper.setReturnClass(com.borland.scc.webservices.sccentities.entities.Role[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getAllRolesReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("setPassword");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "password"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.MissingValueException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "MissingValueException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.LoginException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "LoginException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createLocation");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locationDetails"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://scc.segue.com", "LocationDetails"), com.borland.scc.webservices.sccentities.entities.LocationDetails.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "createLocationReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.MissingValueException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "MissingValueException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.LoginException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "LoginException"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getLocations");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://scc.segue.com", "ArrayOfLocation"));
        oper.setReturnClass(com.borland.scc.webservices.sccentities.entities.Location[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getLocationsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUsers");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "login"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://scc.segue.com", "ArrayOfUser"));
        oper.setReturnClass(com.borland.scc.webservices.sccentities.entities.User[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getUsersReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getProducts");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "ArrayOf_xsd_string"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getProductsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getComponents");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "product"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "ArrayOf_xsd_string"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getComponentsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("encryptAndSetPassword");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "password"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.NotExistingValueException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "NotExistingValueException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.MissingValueException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "MissingValueException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.LoginException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "LoginException"), 
                      true
                     ));
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteExecServer");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "execServerId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.LoginException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "LoginException"), 
                      true
                     ));
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateExecServer");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "execServer"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://scc.segue.com", "ExecServer"), com.borland.scc.webservices.sccentities.entities.ExecServer.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.NotExistingValueException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "NotExistingValueException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deactivateExecServer");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "execServerId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.LoginException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "LoginException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userDetails"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://scc.segue.com", "UserDetails"), com.borland.scc.webservices.sccentities.entities.UserDetails.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.NotExistingValueException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "NotExistingValueException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.MissingValueException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "MissingValueException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.ExistingKeyException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "ExistingKeyException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.LoginException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "LoginException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateProject");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "project"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://scc.segue.com", "Project"), com.borland.scc.webservices.sccentities.entities.Project.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.NotExistingValueException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "NotExistingValueException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidStateException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidStateException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.LoginException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "LoginException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getProjects");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://scc.segue.com", "ArrayOfProject"));
        oper.setReturnClass(com.borland.scc.webservices.sccentities.entities.Project[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getProjectsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getProjectById");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "projectId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://scc.segue.com", "Project"));
        oper.setReturnClass(com.borland.scc.webservices.sccentities.entities.Project.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getProjectByIdReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.NotExistingValueException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "NotExistingValueException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.LoginException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "LoginException"), 
                      true
                     ));
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateLocation");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locationDetails"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://scc.segue.com", "LocationDetails"), com.borland.scc.webservices.sccentities.entities.LocationDetails.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.MissingValueException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "MissingValueException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.LoginException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "LoginException"), 
                      true
                     ));
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getBuilds");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "product"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "version"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "ArrayOf_xsd_string"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getBuildsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getProjectNames");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "ArrayOf_xsd_string"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getProjectNamesReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getVersions");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "product"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "ArrayOf_xsd_string"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getVersionsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createExecServer");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "execServer"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://scc.segue.com", "ExecServer"), com.borland.scc.webservices.sccentities.entities.ExecServer.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "createExecServerReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.LoginException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "LoginException"), 
                      true
                     ));
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateUserGroup");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userGroup"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://scc.segue.com", "UserGroup"), com.borland.scc.webservices.sccentities.entities.UserGroup.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPlatforms");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "ArrayOf_xsd_string"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getPlatformsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getProjectsForUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "appModuleId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://scc.segue.com", "ArrayOfProject"));
        oper.setReturnClass(com.borland.scc.webservices.sccentities.entities.Project[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getProjectsForUserReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getLocationsForProject");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "projectId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://scc.segue.com", "ArrayOfLocation"));
        oper.setReturnClass(com.borland.scc.webservices.sccentities.entities.Location[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getLocationsForProjectReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getLocationDetails");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locationId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://scc.segue.com", "LocationDetails"));
        oper.setReturnClass(com.borland.scc.webservices.sccentities.entities.LocationDetails.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getLocationDetailsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.NotExistingValueException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "NotExistingValueException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.LoginException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "LoginException"), 
                      true
                     ));
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteLocations");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locationIds"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "ArrayOf_xsd_int"), int[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.NotExistingValueException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "NotExistingValueException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.LoginException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "LoginException"), 
                      true
                     ));
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("setProxyUsernameAndPasswordForLocation");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locationId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "proxyUsername"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "proxyPassword"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidStateException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidStateException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.LoginException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "LoginException"), 
                      true
                     ));
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteUsers");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userIdsToDelete"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "ArrayOf_xsd_int"), int[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.NotExistingValueException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "NotExistingValueException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.LoginException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "LoginException"), 
                      true
                     ));
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUserDetails");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://scc.segue.com", "UserDetails"));
        oper.setReturnClass(com.borland.scc.webservices.sccentities.entities.UserDetails.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getUserDetailsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.NotExistingValueException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "NotExistingValueException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.LoginException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "LoginException"), 
                      true
                     ));
        _operations[28] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userDetails"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://scc.segue.com", "UserDetails"), com.borland.scc.webservices.sccentities.entities.UserDetails.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "createUserReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.ExistingKeyException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "ExistingKeyException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.MissingValueException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "MissingValueException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.LoginException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "LoginException"), 
                      true
                     ));
        _operations[29] = oper;

    }

    private static void _initOperationDesc4(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getAllProjects");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "projectName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://scc.segue.com", "ArrayOfProject"));
        oper.setReturnClass(com.borland.scc.webservices.sccentities.entities.Project[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getAllProjectsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[30] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createProject");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "project"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://scc.segue.com", "Project"), com.borland.scc.webservices.sccentities.entities.Project.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "createProjectReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.LoginException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "LoginException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[31] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteProjects");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "projectIds"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "ArrayOf_xsd_int"), int[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.NotExistingValueException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "NotExistingValueException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.LoginException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "LoginException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[32] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("activateProjects");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "projectIds"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "ArrayOf_xsd_int"), int[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.LoginException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "LoginException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[33] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deactivateProjects");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "projectIds"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "ArrayOf_xsd_int"), int[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.LoginException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "LoginException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[34] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getExecServerById");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "execServerId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://scc.segue.com", "ExecServer"));
        oper.setReturnClass(com.borland.scc.webservices.sccentities.entities.ExecServer.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getExecServerByIdReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.NotExistingValueException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "NotExistingValueException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[35] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getExecServersOfLocation");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locationId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://scc.segue.com", "ArrayOfExecServer"));
        oper.setReturnClass(com.borland.scc.webservices.sccentities.entities.ExecServer[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getExecServersOfLocationReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[36] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("activateExecServer");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "execServerId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locationId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.NotExistingValueException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "NotExistingValueException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.LoginException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "LoginException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[37] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("removeResourceTag");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locationId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "execServerId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "resourceTag"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.NotExistingValueException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "NotExistingValueException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.LoginException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "LoginException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[38] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addResourceTag");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locationId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "execServerId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "resourceTag"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.NotExistingValueException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "NotExistingValueException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.LoginException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "LoginException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[39] = oper;

    }

    private static void _initOperationDesc5(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getAllResourceTags");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locationId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "execServerId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "ArrayOf_xsd_string"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getAllResourceTagsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.NotExistingValueException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "NotExistingValueException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.LoginException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "LoginException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[40] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addLocationToProject");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "projectId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locationId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addLocationToProjectReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.NotExistingValueException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "NotExistingValueException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidStateException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidStateException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.LoginException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "LoginException"), 
                      true
                     ));
        _operations[41] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("removeLocationFromProject");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "projectId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "locationId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "removeLocationFromProjectReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.NotExistingValueException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "NotExistingValueException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidStateException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidStateException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.LoginException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "LoginException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[42] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getAllEssentials");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://scc.segue.com", "ArrayOfEssentialDescriptions"));
        oper.setReturnClass(com.borland.scc.webservices.sccentities.entities.EssentialDescription[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getAllEssentialsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[43] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getEssentialGroups");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://scc.segue.com", "ArrayOfEssentialGroups"));
        oper.setReturnClass(com.borland.scc.webservices.sccentities.entities.EssentialGroup[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getEssentialGroupsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[44] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getEssentialSubGroups");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "essentialGroupId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://scc.segue.com", "ArrayOfEssentialSubGroups"));
        oper.setReturnClass(com.borland.scc.webservices.sccentities.entities.EssentialSubGroup[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getEssentialSubGroupsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[45] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getEssentials");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "parentId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://scc.segue.com", "ArrayOfEssentialDescriptions"));
        oper.setReturnClass(com.borland.scc.webservices.sccentities.entities.EssentialDescription[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getEssentialsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[46] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getFilePoolEntries");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "projectId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://vision.segue.com", "ArrayOfFilePoolEntries"));
        oper.setReturnClass(com.borland.scc.webservices.sccentities.entities.FilePoolEntry[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getFilePoolEntriesReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[47] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createUsergroup");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userGroup"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://scc.segue.com", "UserGroup"), com.borland.scc.webservices.sccentities.entities.UserGroup.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "createUsergroupReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[48] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getGroupByName");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "groupName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://scc.segue.com", "UserGroup"));
        oper.setReturnClass(com.borland.scc.webservices.sccentities.entities.UserGroup.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getGroupByNameReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[49] = oper;

    }

    private static void _initOperationDesc6(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getGroupById");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "groupId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://scc.segue.com", "UserGroup"));
        oper.setReturnClass(com.borland.scc.webservices.sccentities.entities.UserGroup.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getGroupByIdReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[50] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getAllUserGroups");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://scc.segue.com", "ArrayOfUserGroup"));
        oper.setReturnClass(com.borland.scc.webservices.sccentities.entities.UserGroup[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getAllUserGroupsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[51] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteUserGroup");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "groupId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[52] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getMembershipsOfGroup");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "groupId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://scc.segue.com", "ArrayOfUserGroupMembership"));
        oper.setReturnClass(com.borland.scc.webservices.sccentities.entities.UserGroupMembership[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getMembershipsOfGroupReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[53] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getMembershipsOfUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://scc.segue.com", "ArrayOfUserGroupMembership"));
        oper.setReturnClass(com.borland.scc.webservices.sccentities.entities.UserGroupMembership[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getMembershipsOfUserReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[54] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getAllMemberships");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://scc.segue.com", "ArrayOfUserGroupMembership"));
        oper.setReturnClass(com.borland.scc.webservices.sccentities.entities.UserGroupMembership[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getAllMembershipsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[55] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateMembershipsOfGroup");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "groupId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "memberships"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://scc.segue.com", "ArrayOfUserGroupMembership"), com.borland.scc.webservices.sccentities.entities.UserGroupMembership[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[56] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateMembershipsOfUser");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "memberships"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://scc.segue.com", "ArrayOfUserGroupMembership"), com.borland.scc.webservices.sccentities.entities.UserGroupMembership[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[57] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRoleById");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "roleId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://scc.segue.com", "Role"));
        oper.setReturnClass(com.borland.scc.webservices.sccentities.entities.Role.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getRoleByIdReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[58] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addBuild");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "product"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "version"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "build"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "descr"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "isActive"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addBuildReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[59] = oper;

    }

    private static void _initOperationDesc7(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("isMixedModeAuthentication");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "isMixedModeAuthenticationReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.NotExistingValueException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "NotExistingValueException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[60] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("setMixedModeAuthentication");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sessionId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "useMixedMode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InvalidIdException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "fault"),
                      "com.segue.scc.webservice.exceptions.InternalException",
                      new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException"), 
                      true
                     ));
        _operations[61] = oper;

    }

    public SccentitiesSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public SccentitiesSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public SccentitiesSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "ArrayOf_xsd_int");
            cachedSerQNames.add(qName);
            cls = int[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://atlis-tm//axislegacy/sccentities", "ArrayOf_xsd_string");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "ExistingKeyException");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.exceptions.ExistingKeyException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InternalException");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.exceptions.InternalException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidIdException");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.exceptions.InvalidIdException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "InvalidStateException");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.exceptions.InvalidStateException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "LoginException");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.exceptions.LoginException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "MissingValueException");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.exceptions.MissingValueException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://exceptions.webservice.scc.segue.com", "NotExistingValueException");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://scc.segue.com", "ArrayOfEssentialDescriptions");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.entities.EssentialDescription[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://scc.segue.com", "EssentialDescription");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://scc.segue.com", "ArrayOfEssentialGroups");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.entities.EssentialGroup[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://scc.segue.com", "EssentialGroup");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://scc.segue.com", "ArrayOfEssentialSubGroups");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.entities.EssentialSubGroup[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://scc.segue.com", "EssentialSubGroup");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://scc.segue.com", "ArrayOfExecServer");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.entities.ExecServer[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://scc.segue.com", "ExecServer");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://scc.segue.com", "ArrayOfLocation");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.entities.Location[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://scc.segue.com", "Location");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://scc.segue.com", "ArrayOfProject");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.entities.Project[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://scc.segue.com", "Project");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://scc.segue.com", "ArrayOfRole");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.entities.Role[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://scc.segue.com", "Role");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://scc.segue.com", "ArrayOfUser");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.entities.User[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://scc.segue.com", "User");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://scc.segue.com", "ArrayOfUserGroup");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.entities.UserGroup[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://scc.segue.com", "UserGroup");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://scc.segue.com", "ArrayOfUserGroupMembership");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.entities.UserGroupMembership[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://scc.segue.com", "UserGroupMembership");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://scc.segue.com", "Entity");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.entities.Entity.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://scc.segue.com", "EssentialDescription");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.entities.EssentialDescription.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://scc.segue.com", "EssentialGroup");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.entities.EssentialGroup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://scc.segue.com", "EssentialSubGroup");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.entities.EssentialSubGroup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://scc.segue.com", "ExecServer");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.entities.ExecServer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://scc.segue.com", "FilePoolEntry");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.entities.FilePoolEntry.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://scc.segue.com", "Location");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.entities.Location.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://scc.segue.com", "LocationDetails");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.entities.LocationDetails.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://scc.segue.com", "NamedEntity");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.entities.NamedEntity.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://scc.segue.com", "Project");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.entities.Project.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://scc.segue.com", "Role");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.entities.Role.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://scc.segue.com", "User");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.entities.User.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://scc.segue.com", "UserDetails");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.entities.UserDetails.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://scc.segue.com", "UserGroup");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.entities.UserGroup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://scc.segue.com", "UserGroupMembership");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.entities.UserGroupMembership.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://vision.segue.com", "ArrayOfFilePoolEntries");
            cachedSerQNames.add(qName);
            cls = com.borland.scc.webservices.sccentities.entities.FilePoolEntry[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://scc.segue.com", "FilePoolEntry");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
                    _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.borland.scc.webservices.sccentities.entities.Role[] getAllRoles(long sessionId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getAllRoles"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.borland.scc.webservices.sccentities.entities.Role[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.borland.scc.webservices.sccentities.entities.Role[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.borland.scc.webservices.sccentities.entities.Role[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void setPassword(long sessionId, int userId, java.lang.String password) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.MissingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.LoginException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "setPassword"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), new java.lang.Integer(userId), password});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.MissingValueException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.MissingValueException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.LoginException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.LoginException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int createLocation(long sessionId, com.borland.scc.webservices.sccentities.entities.LocationDetails locationDetails) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.MissingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException, com.borland.scc.webservices.sccentities.exceptions.LoginException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "createLocation"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), locationDetails});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.MissingValueException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.MissingValueException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.LoginException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.LoginException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.borland.scc.webservices.sccentities.entities.Location[] getLocations(long sessionId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getLocations"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.borland.scc.webservices.sccentities.entities.Location[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.borland.scc.webservices.sccentities.entities.Location[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.borland.scc.webservices.sccentities.entities.Location[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.borland.scc.webservices.sccentities.entities.User[] getUsers(long sessionId, java.lang.String login) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getUsers"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), login});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.borland.scc.webservices.sccentities.entities.User[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.borland.scc.webservices.sccentities.entities.User[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.borland.scc.webservices.sccentities.entities.User[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.String[] getProducts(long sessionId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getProducts"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.String[] getComponents(long sessionId, java.lang.String product) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getComponents"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), product});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void encryptAndSetPassword(long sessionId, int userId, java.lang.String password) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.MissingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException, com.borland.scc.webservices.sccentities.exceptions.LoginException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "encryptAndSetPassword"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), new java.lang.Integer(userId), password});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.MissingValueException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.MissingValueException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.LoginException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.LoginException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void deleteExecServer(long sessionId, int execServerId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException, com.borland.scc.webservices.sccentities.exceptions.LoginException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "deleteExecServer"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), new java.lang.Integer(execServerId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.LoginException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.LoginException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void updateExecServer(long sessionId, com.borland.scc.webservices.sccentities.entities.ExecServer execServer) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "updateExecServer"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), execServer});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void deactivateExecServer(long sessionId, int execServerId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.LoginException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "deactivateExecServer"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), new java.lang.Integer(execServerId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.LoginException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.LoginException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void updateUser(long sessionId, com.borland.scc.webservices.sccentities.entities.UserDetails userDetails) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.MissingValueException, com.borland.scc.webservices.sccentities.exceptions.ExistingKeyException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.LoginException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "updateUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), userDetails});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.MissingValueException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.MissingValueException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.ExistingKeyException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.ExistingKeyException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.LoginException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.LoginException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void updateProject(long sessionId, com.borland.scc.webservices.sccentities.entities.Project project) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidStateException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.LoginException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "updateProject"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), project});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidStateException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidStateException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.LoginException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.LoginException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.borland.scc.webservices.sccentities.entities.Project[] getProjects(long sessionId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getProjects"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.borland.scc.webservices.sccentities.entities.Project[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.borland.scc.webservices.sccentities.entities.Project[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.borland.scc.webservices.sccentities.entities.Project[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.borland.scc.webservices.sccentities.entities.Project getProjectById(long sessionId, int projectId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException, com.borland.scc.webservices.sccentities.exceptions.LoginException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getProjectById"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), new java.lang.Integer(projectId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.borland.scc.webservices.sccentities.entities.Project) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.borland.scc.webservices.sccentities.entities.Project) org.apache.axis.utils.JavaUtils.convert(_resp, com.borland.scc.webservices.sccentities.entities.Project.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.LoginException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.LoginException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void updateLocation(long sessionId, com.borland.scc.webservices.sccentities.entities.LocationDetails locationDetails) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.MissingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException, com.borland.scc.webservices.sccentities.exceptions.LoginException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "updateLocation"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), locationDetails});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.MissingValueException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.MissingValueException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.LoginException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.LoginException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.String[] getBuilds(long sessionId, java.lang.String product, java.lang.String version) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getBuilds"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), product, version});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.String[] getProjectNames(long sessionId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getProjectNames"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.String[] getVersions(long sessionId, java.lang.String product) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getVersions"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), product});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int createExecServer(long sessionId, com.borland.scc.webservices.sccentities.entities.ExecServer execServer) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException, com.borland.scc.webservices.sccentities.exceptions.LoginException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "createExecServer"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), execServer});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.LoginException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.LoginException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void updateUserGroup(long sessionId, com.borland.scc.webservices.sccentities.entities.UserGroup userGroup) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "updateUserGroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), userGroup});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.String[] getPlatforms(long sessionId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getPlatforms"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.borland.scc.webservices.sccentities.entities.Project[] getProjectsForUser(long sessionId, int userId, int appModuleId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getProjectsForUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), new java.lang.Integer(userId), new java.lang.Integer(appModuleId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.borland.scc.webservices.sccentities.entities.Project[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.borland.scc.webservices.sccentities.entities.Project[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.borland.scc.webservices.sccentities.entities.Project[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.borland.scc.webservices.sccentities.entities.Location[] getLocationsForProject(long sessionId, int projectId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getLocationsForProject"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), new java.lang.Integer(projectId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.borland.scc.webservices.sccentities.entities.Location[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.borland.scc.webservices.sccentities.entities.Location[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.borland.scc.webservices.sccentities.entities.Location[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.borland.scc.webservices.sccentities.entities.LocationDetails getLocationDetails(long sessionId, int locationId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException, com.borland.scc.webservices.sccentities.exceptions.LoginException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getLocationDetails"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), new java.lang.Integer(locationId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.borland.scc.webservices.sccentities.entities.LocationDetails) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.borland.scc.webservices.sccentities.entities.LocationDetails) org.apache.axis.utils.JavaUtils.convert(_resp, com.borland.scc.webservices.sccentities.entities.LocationDetails.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.LoginException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.LoginException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void deleteLocations(long sessionId, int[] locationIds) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException, com.borland.scc.webservices.sccentities.exceptions.LoginException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "deleteLocations"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), locationIds});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.LoginException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.LoginException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void setProxyUsernameAndPasswordForLocation(long sessionId, int locationId, java.lang.String proxyUsername, java.lang.String proxyPassword) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidStateException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException, com.borland.scc.webservices.sccentities.exceptions.LoginException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "setProxyUsernameAndPasswordForLocation"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), new java.lang.Integer(locationId), proxyUsername, proxyPassword});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidStateException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidStateException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.LoginException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.LoginException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void deleteUsers(long sessionId, int[] userIdsToDelete) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException, com.borland.scc.webservices.sccentities.exceptions.LoginException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "deleteUsers"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), userIdsToDelete});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.LoginException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.LoginException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.borland.scc.webservices.sccentities.entities.UserDetails getUserDetails(long sessionId, int userId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException, com.borland.scc.webservices.sccentities.exceptions.LoginException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getUserDetails"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), new java.lang.Integer(userId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.borland.scc.webservices.sccentities.entities.UserDetails) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.borland.scc.webservices.sccentities.entities.UserDetails) org.apache.axis.utils.JavaUtils.convert(_resp, com.borland.scc.webservices.sccentities.entities.UserDetails.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.LoginException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.LoginException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int createUser(long sessionId, com.borland.scc.webservices.sccentities.entities.UserDetails userDetails) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.ExistingKeyException, com.borland.scc.webservices.sccentities.exceptions.MissingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException, com.borland.scc.webservices.sccentities.exceptions.LoginException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[29]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "createUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), userDetails});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.ExistingKeyException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.ExistingKeyException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.MissingValueException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.MissingValueException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.LoginException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.LoginException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.borland.scc.webservices.sccentities.entities.Project[] getAllProjects(long sessionId, java.lang.String projectName) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[30]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getAllProjects"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), projectName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.borland.scc.webservices.sccentities.entities.Project[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.borland.scc.webservices.sccentities.entities.Project[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.borland.scc.webservices.sccentities.entities.Project[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int createProject(long sessionId, com.borland.scc.webservices.sccentities.entities.Project project) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.LoginException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[31]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "createProject"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), project});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.LoginException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.LoginException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void deleteProjects(long sessionId, int[] projectIds) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.LoginException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[32]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "deleteProjects"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), projectIds});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.LoginException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.LoginException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void activateProjects(long sessionId, int[] projectIds) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.LoginException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[33]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "activateProjects"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), projectIds});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.LoginException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.LoginException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void deactivateProjects(long sessionId, int[] projectIds) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.LoginException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[34]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "deactivateProjects"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), projectIds});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.LoginException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.LoginException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.borland.scc.webservices.sccentities.entities.ExecServer getExecServerById(long sessionId, int execServerId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[35]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getExecServerById"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), new java.lang.Integer(execServerId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.borland.scc.webservices.sccentities.entities.ExecServer) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.borland.scc.webservices.sccentities.entities.ExecServer) org.apache.axis.utils.JavaUtils.convert(_resp, com.borland.scc.webservices.sccentities.entities.ExecServer.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.borland.scc.webservices.sccentities.entities.ExecServer[] getExecServersOfLocation(long sessionId, int locationId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[36]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getExecServersOfLocation"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), new java.lang.Integer(locationId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.borland.scc.webservices.sccentities.entities.ExecServer[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.borland.scc.webservices.sccentities.entities.ExecServer[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.borland.scc.webservices.sccentities.entities.ExecServer[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void activateExecServer(long sessionId, int execServerId, int locationId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.LoginException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[37]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "activateExecServer"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), new java.lang.Integer(execServerId), new java.lang.Integer(locationId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.LoginException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.LoginException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void removeResourceTag(long sessionId, int locationId, int execServerId, java.lang.String resourceTag) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.LoginException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[38]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "removeResourceTag"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), new java.lang.Integer(locationId), new java.lang.Integer(execServerId), resourceTag});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.LoginException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.LoginException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void addResourceTag(long sessionId, int locationId, int execServerId, java.lang.String resourceTag) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.LoginException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[39]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "addResourceTag"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), new java.lang.Integer(locationId), new java.lang.Integer(execServerId), resourceTag});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.LoginException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.LoginException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.String[] getAllResourceTags(long sessionId, int locationId, int execServerId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.LoginException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[40]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getAllResourceTags"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), new java.lang.Integer(locationId), new java.lang.Integer(execServerId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.LoginException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.LoginException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public boolean addLocationToProject(long sessionId, int projectId, int locationId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidStateException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException, com.borland.scc.webservices.sccentities.exceptions.LoginException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[41]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "addLocationToProject"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), new java.lang.Integer(projectId), new java.lang.Integer(locationId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidStateException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidStateException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.LoginException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.LoginException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public boolean removeLocationFromProject(long sessionId, int projectId, int locationId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidStateException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.LoginException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[42]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "removeLocationFromProject"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), new java.lang.Integer(projectId), new java.lang.Integer(locationId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidStateException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidStateException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.LoginException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.LoginException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.borland.scc.webservices.sccentities.entities.EssentialDescription[] getAllEssentials(long sessionId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[43]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getAllEssentials"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.borland.scc.webservices.sccentities.entities.EssentialDescription[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.borland.scc.webservices.sccentities.entities.EssentialDescription[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.borland.scc.webservices.sccentities.entities.EssentialDescription[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.borland.scc.webservices.sccentities.entities.EssentialGroup[] getEssentialGroups(long sessionId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[44]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getEssentialGroups"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.borland.scc.webservices.sccentities.entities.EssentialGroup[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.borland.scc.webservices.sccentities.entities.EssentialGroup[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.borland.scc.webservices.sccentities.entities.EssentialGroup[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.borland.scc.webservices.sccentities.entities.EssentialSubGroup[] getEssentialSubGroups(long sessionId, int essentialGroupId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[45]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getEssentialSubGroups"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), new java.lang.Integer(essentialGroupId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.borland.scc.webservices.sccentities.entities.EssentialSubGroup[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.borland.scc.webservices.sccentities.entities.EssentialSubGroup[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.borland.scc.webservices.sccentities.entities.EssentialSubGroup[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.borland.scc.webservices.sccentities.entities.EssentialDescription[] getEssentials(long sessionId, int parentId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[46]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getEssentials"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), new java.lang.Integer(parentId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.borland.scc.webservices.sccentities.entities.EssentialDescription[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.borland.scc.webservices.sccentities.entities.EssentialDescription[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.borland.scc.webservices.sccentities.entities.EssentialDescription[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.borland.scc.webservices.sccentities.entities.FilePoolEntry[] getFilePoolEntries(long sessionId, int projectId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[47]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getFilePoolEntries"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), new java.lang.Integer(projectId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.borland.scc.webservices.sccentities.entities.FilePoolEntry[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.borland.scc.webservices.sccentities.entities.FilePoolEntry[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.borland.scc.webservices.sccentities.entities.FilePoolEntry[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int createUsergroup(long sessionId, com.borland.scc.webservices.sccentities.entities.UserGroup userGroup) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[48]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "createUsergroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), userGroup});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.borland.scc.webservices.sccentities.entities.UserGroup getGroupByName(long sessionId, java.lang.String groupName) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[49]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getGroupByName"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), groupName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.borland.scc.webservices.sccentities.entities.UserGroup) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.borland.scc.webservices.sccentities.entities.UserGroup) org.apache.axis.utils.JavaUtils.convert(_resp, com.borland.scc.webservices.sccentities.entities.UserGroup.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.borland.scc.webservices.sccentities.entities.UserGroup getGroupById(long sessionId, int groupId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[50]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getGroupById"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), new java.lang.Integer(groupId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.borland.scc.webservices.sccentities.entities.UserGroup) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.borland.scc.webservices.sccentities.entities.UserGroup) org.apache.axis.utils.JavaUtils.convert(_resp, com.borland.scc.webservices.sccentities.entities.UserGroup.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.borland.scc.webservices.sccentities.entities.UserGroup[] getAllUserGroups(long sessionId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[51]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getAllUserGroups"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.borland.scc.webservices.sccentities.entities.UserGroup[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.borland.scc.webservices.sccentities.entities.UserGroup[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.borland.scc.webservices.sccentities.entities.UserGroup[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void deleteUserGroup(long sessionId, int groupId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[52]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "deleteUserGroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), new java.lang.Integer(groupId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.borland.scc.webservices.sccentities.entities.UserGroupMembership[] getMembershipsOfGroup(long sessionId, int groupId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[53]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getMembershipsOfGroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), new java.lang.Integer(groupId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.borland.scc.webservices.sccentities.entities.UserGroupMembership[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.borland.scc.webservices.sccentities.entities.UserGroupMembership[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.borland.scc.webservices.sccentities.entities.UserGroupMembership[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.borland.scc.webservices.sccentities.entities.UserGroupMembership[] getMembershipsOfUser(long sessionId, int userId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[54]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getMembershipsOfUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), new java.lang.Integer(userId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.borland.scc.webservices.sccentities.entities.UserGroupMembership[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.borland.scc.webservices.sccentities.entities.UserGroupMembership[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.borland.scc.webservices.sccentities.entities.UserGroupMembership[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.borland.scc.webservices.sccentities.entities.UserGroupMembership[] getAllMemberships(long sessionId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[55]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getAllMemberships"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.borland.scc.webservices.sccentities.entities.UserGroupMembership[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.borland.scc.webservices.sccentities.entities.UserGroupMembership[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.borland.scc.webservices.sccentities.entities.UserGroupMembership[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void updateMembershipsOfGroup(long sessionId, int groupId, com.borland.scc.webservices.sccentities.entities.UserGroupMembership[] memberships) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[56]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "updateMembershipsOfGroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), new java.lang.Integer(groupId), memberships});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void updateMembershipsOfUser(long sessionId, int userId, com.borland.scc.webservices.sccentities.entities.UserGroupMembership[] memberships) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[57]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "updateMembershipsOfUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), new java.lang.Integer(userId), memberships});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.borland.scc.webservices.sccentities.entities.Role getRoleById(long sessionId, int roleId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[58]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "getRoleById"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), new java.lang.Integer(roleId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.borland.scc.webservices.sccentities.entities.Role) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.borland.scc.webservices.sccentities.entities.Role) org.apache.axis.utils.JavaUtils.convert(_resp, com.borland.scc.webservices.sccentities.entities.Role.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public boolean addBuild(long sessionId, java.lang.String product, java.lang.String version, java.lang.String build, java.lang.String descr, boolean isActive) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[59]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "addBuild"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), product, version, build, descr, new java.lang.Boolean(isActive)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public boolean isMixedModeAuthentication(long sessionId, int userId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[60]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "isMixedModeAuthentication"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), new java.lang.Integer(userId)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void setMixedModeAuthentication(long sessionId, int userId, boolean useMixedMode) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[61]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://impl.webservice.scc.segue.com", "setMixedModeAuthentication"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Long(sessionId), new java.lang.Integer(userId), new java.lang.Boolean(useMixedMode)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InvalidIdException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.borland.scc.webservices.sccentities.exceptions.InternalException) {
              throw (com.borland.scc.webservices.sccentities.exceptions.InternalException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
