package hudson.plugins.sctmexecutor;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.borland.tm.webservices.tmexecution.ExecutionHandle;
import com.borland.tm.webservices.tmexecution.ExecutionResult;
import com.borland.tm.webservices.tmexecution.ExecutionWebService;

public class ResultCollectorThread extends Thread {
  private List<ExecutionHandle> handles;
  private ExecutionWebService service;
  private long sessionId;
  private long sleep = 10000; // in ms

  public ResultCollectorThread(String name, ExecutionWebService service, long sessionId, List<ExecutionHandle> handles) {
    super(name);
    this.handles = handles;
    this.service = service;
    this.sessionId = sessionId;
  }
  
  public void setSleep(long sleep) {
    this.sleep = sleep;
  }
  
  @Override
  public void run() {
    List<ExecutionHandle> toRemove = new ArrayList<ExecutionHandle>();
    List<ExecutionResult> results = new ArrayList<ExecutionResult>();
    try {
      while (!handles.isEmpty()) {
        toRemove.clear();
        for (ExecutionHandle handle : handles) {
          int stateOfExecution = service.getStateOfExecution(sessionId, handles.get(0));
          if (stateOfExecution == -1) {
            results.add(service.getExecutionResult(sessionId, handle));
            toRemove.add(handle);
          }
        }
        for (ExecutionHandle handle : toRemove) {
          handles.remove(handle);
        }
        Thread.sleep(sleep);
      }
    } catch (RemoteException e) {
      throw new RuntimeException("Collecting results failed: ", e);
    } catch (InterruptedException e) {
      interrupt();
      throw new RuntimeException("Collecting result aborted: ", e);
    }
  }

  public boolean isFinished() {
    return this.handles.isEmpty();
  }
}
