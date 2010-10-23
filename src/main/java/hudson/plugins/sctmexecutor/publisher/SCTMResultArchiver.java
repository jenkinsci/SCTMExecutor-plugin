package hudson.plugins.sctmexecutor.publisher;

import hudson.FilePath;
import hudson.Launcher;
import hudson.model.BuildListener;
import hudson.model.AbstractBuild;
import hudson.model.Hudson;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Recorder;
import hudson.tasks.test.TestResult;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import org.kohsuke.stapler.DataBoundConstructor;

public class SCTMResultArchiver extends Recorder implements Serializable {

  @DataBoundConstructor
  public SCTMResultArchiver() {
  }

  @Override
  public BuildStepMonitor getRequiredMonitorService() {
    return BuildStepMonitor.NONE;
  }

  @Override
  public boolean perform(AbstractBuild<?, ?> build, Launcher launcher, BuildListener listener)
      throws InterruptedException, IOException {
    final SCTMTestSuiteResult rootSuite = new SCTMTestSuiteResult("root", build, new ArrayList<TestResult>());
    
    FilePath workspace = build.getWorkspace();
    FilePath resultRootPath = workspace.child(String.format("SCTMResults/%d", build.getNumber()));
    SCTMResultParser sctmResultParser = new SCTMResultParser(resultRootPath, rootSuite);
    sctmResultParser.createResult(build);
    
    build.getActions().add(new SCTMResultAction(build, rootSuite));
    return true;
  }

  @Override
  public SCTMResultArchiverDescriptor getDescriptor() {
    return (SCTMResultArchiverDescriptor) Hudson.getInstance().getDescriptor(this.getClass());
  }

}
