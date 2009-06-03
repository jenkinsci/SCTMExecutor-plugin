package com.borland.scc.webservices.sccentities;

public class MainEntitiesProxy implements com.borland.scc.webservices.sccentities.MainEntities {
  private String _endpoint = null;
  private com.borland.scc.webservices.sccentities.MainEntities mainEntities = null;
  
  public MainEntitiesProxy() {
    _initMainEntitiesProxy();
  }
  
  public MainEntitiesProxy(String endpoint) {
    _endpoint = endpoint;
    _initMainEntitiesProxy();
  }
  
  private void _initMainEntitiesProxy() {
    try {
      mainEntities = (new com.borland.scc.webservices.sccentities.MainEntitiesServiceLocator()).getsccentities();
      if (mainEntities != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)mainEntities)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)mainEntities)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (mainEntities != null)
      ((javax.xml.rpc.Stub)mainEntities)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.borland.scc.webservices.sccentities.MainEntities getMainEntities() {
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities;
  }
  
  public com.borland.scc.webservices.sccentities.entities.Role[] getAllRoles(long sessionId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getAllRoles(sessionId);
  }
  
  public void setPassword(long sessionId, int userId, java.lang.String password) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.MissingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.LoginException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    mainEntities.setPassword(sessionId, userId, password);
  }
  
  public int createLocation(long sessionId, com.borland.scc.webservices.sccentities.entities.LocationDetails locationDetails) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.MissingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException, com.borland.scc.webservices.sccentities.exceptions.LoginException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.createLocation(sessionId, locationDetails);
  }
  
  public com.borland.scc.webservices.sccentities.entities.Location[] getLocations(long sessionId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getLocations(sessionId);
  }
  
  public com.borland.scc.webservices.sccentities.entities.User[] getUsers(long sessionId, java.lang.String login) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getUsers(sessionId, login);
  }
  
  public java.lang.String[] getProducts(long sessionId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getProducts(sessionId);
  }
  
  public java.lang.String[] getComponents(long sessionId, java.lang.String product) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getComponents(sessionId, product);
  }
  
  public void encryptAndSetPassword(long sessionId, int userId, java.lang.String password) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.MissingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException, com.borland.scc.webservices.sccentities.exceptions.LoginException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    mainEntities.encryptAndSetPassword(sessionId, userId, password);
  }
  
  public void deleteExecServer(long sessionId, int execServerId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException, com.borland.scc.webservices.sccentities.exceptions.LoginException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    mainEntities.deleteExecServer(sessionId, execServerId);
  }
  
  public void updateExecServer(long sessionId, com.borland.scc.webservices.sccentities.entities.ExecServer execServer) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    mainEntities.updateExecServer(sessionId, execServer);
  }
  
  public void deactivateExecServer(long sessionId, int execServerId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.LoginException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    mainEntities.deactivateExecServer(sessionId, execServerId);
  }
  
  public void updateUser(long sessionId, com.borland.scc.webservices.sccentities.entities.UserDetails userDetails) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.MissingValueException, com.borland.scc.webservices.sccentities.exceptions.ExistingKeyException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.LoginException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    mainEntities.updateUser(sessionId, userDetails);
  }
  
  public void updateProject(long sessionId, com.borland.scc.webservices.sccentities.entities.Project project) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidStateException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.LoginException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    mainEntities.updateProject(sessionId, project);
  }
  
  public com.borland.scc.webservices.sccentities.entities.Project[] getProjects(long sessionId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getProjects(sessionId);
  }
  
  public com.borland.scc.webservices.sccentities.entities.Project getProjectById(long sessionId, int projectId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException, com.borland.scc.webservices.sccentities.exceptions.LoginException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getProjectById(sessionId, projectId);
  }
  
  public void updateLocation(long sessionId, com.borland.scc.webservices.sccentities.entities.LocationDetails locationDetails) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.MissingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException, com.borland.scc.webservices.sccentities.exceptions.LoginException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    mainEntities.updateLocation(sessionId, locationDetails);
  }
  
  public java.lang.String[] getBuilds(long sessionId, java.lang.String product, java.lang.String version) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getBuilds(sessionId, product, version);
  }
  
  public java.lang.String[] getProjectNames(long sessionId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getProjectNames(sessionId);
  }
  
  public java.lang.String[] getVersions(long sessionId, java.lang.String product) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getVersions(sessionId, product);
  }
  
  public int createExecServer(long sessionId, com.borland.scc.webservices.sccentities.entities.ExecServer execServer) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException, com.borland.scc.webservices.sccentities.exceptions.LoginException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.createExecServer(sessionId, execServer);
  }
  
  public void updateUserGroup(long sessionId, com.borland.scc.webservices.sccentities.entities.UserGroup userGroup) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    mainEntities.updateUserGroup(sessionId, userGroup);
  }
  
  public java.lang.String[] getPlatforms(long sessionId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getPlatforms(sessionId);
  }
  
  public com.borland.scc.webservices.sccentities.entities.Project[] getProjectsForUser(long sessionId, int userId, int appModuleId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getProjectsForUser(sessionId, userId, appModuleId);
  }
  
  public com.borland.scc.webservices.sccentities.entities.Location[] getLocationsForProject(long sessionId, int projectId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getLocationsForProject(sessionId, projectId);
  }
  
  public com.borland.scc.webservices.sccentities.entities.LocationDetails getLocationDetails(long sessionId, int locationId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException, com.borland.scc.webservices.sccentities.exceptions.LoginException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getLocationDetails(sessionId, locationId);
  }
  
  public void deleteLocations(long sessionId, int[] locationIds) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException, com.borland.scc.webservices.sccentities.exceptions.LoginException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    mainEntities.deleteLocations(sessionId, locationIds);
  }
  
  public void setProxyUsernameAndPasswordForLocation(long sessionId, int locationId, java.lang.String proxyUsername, java.lang.String proxyPassword) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidStateException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException, com.borland.scc.webservices.sccentities.exceptions.LoginException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    mainEntities.setProxyUsernameAndPasswordForLocation(sessionId, locationId, proxyUsername, proxyPassword);
  }
  
  public void deleteUsers(long sessionId, int[] userIdsToDelete) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException, com.borland.scc.webservices.sccentities.exceptions.LoginException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    mainEntities.deleteUsers(sessionId, userIdsToDelete);
  }
  
  public com.borland.scc.webservices.sccentities.entities.UserDetails getUserDetails(long sessionId, int userId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException, com.borland.scc.webservices.sccentities.exceptions.LoginException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getUserDetails(sessionId, userId);
  }
  
  public int createUser(long sessionId, com.borland.scc.webservices.sccentities.entities.UserDetails userDetails) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.ExistingKeyException, com.borland.scc.webservices.sccentities.exceptions.MissingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException, com.borland.scc.webservices.sccentities.exceptions.LoginException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.createUser(sessionId, userDetails);
  }
  
  public com.borland.scc.webservices.sccentities.entities.Project[] getAllProjects(long sessionId, java.lang.String projectName) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getAllProjects(sessionId, projectName);
  }
  
  public int createProject(long sessionId, com.borland.scc.webservices.sccentities.entities.Project project) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.LoginException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.createProject(sessionId, project);
  }
  
  public void deleteProjects(long sessionId, int[] projectIds) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.LoginException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    mainEntities.deleteProjects(sessionId, projectIds);
  }
  
  public void activateProjects(long sessionId, int[] projectIds) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.LoginException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    mainEntities.activateProjects(sessionId, projectIds);
  }
  
  public void deactivateProjects(long sessionId, int[] projectIds) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.LoginException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    mainEntities.deactivateProjects(sessionId, projectIds);
  }
  
  public com.borland.scc.webservices.sccentities.entities.ExecServer getExecServerById(long sessionId, int execServerId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getExecServerById(sessionId, execServerId);
  }
  
  public com.borland.scc.webservices.sccentities.entities.ExecServer[] getExecServersOfLocation(long sessionId, int locationId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getExecServersOfLocation(sessionId, locationId);
  }
  
  public void activateExecServer(long sessionId, int execServerId, int locationId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.LoginException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    mainEntities.activateExecServer(sessionId, execServerId, locationId);
  }
  
  public void removeResourceTag(long sessionId, int locationId, int execServerId, java.lang.String resourceTag) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.LoginException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    mainEntities.removeResourceTag(sessionId, locationId, execServerId, resourceTag);
  }
  
  public void addResourceTag(long sessionId, int locationId, int execServerId, java.lang.String resourceTag) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.LoginException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    mainEntities.addResourceTag(sessionId, locationId, execServerId, resourceTag);
  }
  
  public java.lang.String[] getAllResourceTags(long sessionId, int locationId, int execServerId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.LoginException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getAllResourceTags(sessionId, locationId, execServerId);
  }
  
  public boolean addLocationToProject(long sessionId, int projectId, int locationId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidStateException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException, com.borland.scc.webservices.sccentities.exceptions.LoginException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.addLocationToProject(sessionId, projectId, locationId);
  }
  
  public boolean removeLocationFromProject(long sessionId, int projectId, int locationId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidStateException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.LoginException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.removeLocationFromProject(sessionId, projectId, locationId);
  }
  
  public com.borland.scc.webservices.sccentities.entities.EssentialDescription[] getAllEssentials(long sessionId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getAllEssentials(sessionId);
  }
  
  public com.borland.scc.webservices.sccentities.entities.EssentialGroup[] getEssentialGroups(long sessionId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getEssentialGroups(sessionId);
  }
  
  public com.borland.scc.webservices.sccentities.entities.EssentialSubGroup[] getEssentialSubGroups(long sessionId, int essentialGroupId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getEssentialSubGroups(sessionId, essentialGroupId);
  }
  
  public com.borland.scc.webservices.sccentities.entities.EssentialDescription[] getEssentials(long sessionId, int parentId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getEssentials(sessionId, parentId);
  }
  
  public com.borland.scc.webservices.sccentities.entities.FilePoolEntry[] getFilePoolEntries(long sessionId, int projectId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getFilePoolEntries(sessionId, projectId);
  }
  
  public int createUsergroup(long sessionId, com.borland.scc.webservices.sccentities.entities.UserGroup userGroup) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.createUsergroup(sessionId, userGroup);
  }
  
  public com.borland.scc.webservices.sccentities.entities.UserGroup getGroupByName(long sessionId, java.lang.String groupName) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getGroupByName(sessionId, groupName);
  }
  
  public com.borland.scc.webservices.sccentities.entities.UserGroup getGroupById(long sessionId, int groupId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getGroupById(sessionId, groupId);
  }
  
  public com.borland.scc.webservices.sccentities.entities.UserGroup[] getAllUserGroups(long sessionId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getAllUserGroups(sessionId);
  }
  
  public void deleteUserGroup(long sessionId, int groupId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    mainEntities.deleteUserGroup(sessionId, groupId);
  }
  
  public com.borland.scc.webservices.sccentities.entities.UserGroupMembership[] getMembershipsOfGroup(long sessionId, int groupId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getMembershipsOfGroup(sessionId, groupId);
  }
  
  public com.borland.scc.webservices.sccentities.entities.UserGroupMembership[] getMembershipsOfUser(long sessionId, int userId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getMembershipsOfUser(sessionId, userId);
  }
  
  public com.borland.scc.webservices.sccentities.entities.UserGroupMembership[] getAllMemberships(long sessionId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getAllMemberships(sessionId);
  }
  
  public void updateMembershipsOfGroup(long sessionId, int groupId, com.borland.scc.webservices.sccentities.entities.UserGroupMembership[] memberships) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    mainEntities.updateMembershipsOfGroup(sessionId, groupId, memberships);
  }
  
  public void updateMembershipsOfUser(long sessionId, int userId, com.borland.scc.webservices.sccentities.entities.UserGroupMembership[] memberships) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    mainEntities.updateMembershipsOfUser(sessionId, userId, memberships);
  }
  
  public com.borland.scc.webservices.sccentities.entities.Role getRoleById(long sessionId, int roleId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.getRoleById(sessionId, roleId);
  }
  
  public boolean addBuild(long sessionId, java.lang.String product, java.lang.String version, java.lang.String build, java.lang.String descr, boolean isActive) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.addBuild(sessionId, product, version, build, descr, isActive);
  }
  
  public boolean isMixedModeAuthentication(long sessionId, int userId) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.NotExistingValueException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    return mainEntities.isMixedModeAuthentication(sessionId, userId);
  }
  
  public void setMixedModeAuthentication(long sessionId, int userId, boolean useMixedMode) throws java.rmi.RemoteException, com.borland.scc.webservices.sccentities.exceptions.InvalidIdException, com.borland.scc.webservices.sccentities.exceptions.InternalException{
    if (mainEntities == null)
      _initMainEntitiesProxy();
    mainEntities.setMixedModeAuthentication(sessionId, userId, useMixedMode);
  }
  
  
}