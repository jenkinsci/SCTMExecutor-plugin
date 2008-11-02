package hudson.plugins.sctmexecutor;

import hudson.Plugin;
import hudson.tasks.BuildStep;
import hudson.tasks.Publisher;

/**
 * Entry point of a plugin.
 * 
 * @author Thomas Fuerer
 * @plugin
 */
public class SCTMExecutorPlugin extends Plugin {
    public void start() throws Exception {
      BuildStep.BUILDERS.add(SCTMExecutor.DESCRIPTOR);
      //Publisher.PUBLISHERS.add(SCTMExecutionPublisher.DESCRIPTOR);
    }
}
