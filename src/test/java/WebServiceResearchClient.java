import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.borland.sctm.ws.execution.ExecutionWebService;
import com.borland.sctm.ws.execution.ExecutionWebServiceServiceLocator;
import com.borland.sctm.ws.execution.entities.ExecutionNode;
import com.borland.sctm.ws.execution.entities.PropertyMetaInfo;
import com.borland.sctm.ws.execution.entities.PropertyValue;
import com.borland.sctm.ws.logon.SystemService;
import com.borland.sctm.ws.logon.SystemServiceServiceLocator;
import com.borland.sctm.ws.planning.PlanningService;
import com.borland.sctm.ws.planning.PlanningServiceServiceLocator;



public class WebServiceResearchClient {
  private static String SCTM_URL = "http://atlis-tm/services";
  public static void main(String[] args) throws MalformedURLException, ServiceException, RemoteException {
    SystemService systemService = new SystemServiceServiceLocator().getsccsystem(new URL(SCTM_URL + "/sccsystem?wsdl"));
    ExecutionWebService execService = new ExecutionWebServiceServiceLocator().gettmexecution(new URL(SCTM_URL + "/tmexecution?wsdl"));
    PlanningService planningService = new PlanningServiceServiceLocator().gettmplanning(new URL(SCTM_URL+"/tmplanning?wsdl"));
    long sessionId = systemService.logonUser("LQM.Buildmaster.AT", "Borland1234");
    execService.setCurrentProject(sessionId, 34);
    planningService.setCurrentProject(sessionId, "34");
    
    String[] propertyIds = execService.getPropertyIds(sessionId, 3);
    for (String prop : propertyIds) {
      PropertyMetaInfo propertyInfo = execService.getPropertyInfo(sessionId, 3, prop);
      System.out.println(propertyInfo.getName());
    }
    
    System.out.println();
    ExecutionNode node = execService.getNode(sessionId, 30208);
    String testcontid="";
    for (PropertyValue propVal : node.getPropertyValues()) {
      System.out.println(propVal.getName() + "/"+propVal.getPropertyID()+"/"+propVal.getValue());
      if ("PROP_TESTCONTAINER".equals(propVal.getName()))
        testcontid = propVal.getValue();
    }
    System.out.println();
    System.out.println("ProductId: "+planningService.getProperty(sessionId, testcontid, "_node_properties_ProductID_pk_fk").getValue());
  }
}
