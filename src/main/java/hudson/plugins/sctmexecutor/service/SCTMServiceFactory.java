package hudson.plugins.sctmexecutor.service;

import hudson.plugins.sctmexecutor.exceptions.SCTMException;

public class SCTMServiceFactory {
  private static SCTMServiceFactory instance;
  private ISCTMService service;
  
  public static SCTMServiceFactory getInstance() {
    if (instance == null)
      instance = new SCTMServiceFactory();
    return instance;
  }
  
  public ISCTMService getService(String serviceURL, String user, String pwd, boolean forceCreation) throws SCTMException {
    if (service == null || forceCreation)
      service = new SCTMService(serviceURL, user, pwd);
    return service;
  }
}
