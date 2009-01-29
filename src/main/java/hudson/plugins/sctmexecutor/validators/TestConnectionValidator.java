package hudson.plugins.sctmexecutor.validators;

import hudson.util.FormFieldValidator;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.servlet.ServletException;
import javax.xml.rpc.ServiceException;

import com.borland.scc.sccsystem.SystemService;
import com.borland.scc.sccsystem.SystemServiceServiceLocator;

public class TestConnectionValidator extends FormFieldValidator {
  private String serviceURL;
  private String user;
  private String password;
  
  
  public TestConnectionValidator(String serviceURL, String user, String password) {
    super(null);
    this.serviceURL = serviceURL;
    this.user = user;
    this.password = password;
  }


  @Override
  protected void check() throws IOException, ServletException {
    if (!serviceURL.matches("http://((\\d{1,3}.){3}\\d{1,3})??|(\\p{Alnum}*)(:\\d{0,5})??(/\\p{Alnum}*)??/services"))
      error("Enter a valid URL.");
    try {
      SystemService systemService = new SystemServiceServiceLocator().getsccsystem(new URL(serviceURL + "/sccsystem?wsdl")); //$NON-NLS-1$
      try {
        systemService.logonUser(user, password);
        ok("Connection successfully established");
      } catch (RemoteException e) {
        error("Wrong user or password.");
      }
    } catch (RemoteException e) {
      error("Cannot connect to SilkCentral TestManager. Please check the connection data.");
    } catch (ServiceException e) {
      error("Cannot connect to SilkCentral TestManager. Please check the connection data.");
    }
  }

}
