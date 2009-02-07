package hudson.plugins.sctmexecutor;

import hudson.Plugin;
import hudson.tasks.BuildStep;

/**
 * Entry point of a plugin.
 * 
 * @author Thomas Fuerer
 * @plugin
 */
public class SCTMExecutorPlugin extends Plugin {
  @Override
  public void start() throws Exception {
    BuildStep.BUILDERS.add(SCTMExecutor.DESCRIPTOR);
  }
  
  @Override
  public void stop() throws Exception {
    SCTMExecutor.DESCRIPTOR.shutdown();
  }
}
