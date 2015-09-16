package hudson.plugins.sctmexecutor.publisher.xunit;

import org.jenkinsci.lib.dtkit.descriptor.TestTypeDescriptor;
import org.jenkinsci.lib.dtkit.type.TestType;
import org.kohsuke.stapler.DataBoundConstructor;

import hudson.Extension;

public class SCTMTestType extends TestType {
  private static final long serialVersionUID = 1L;
 
  @DataBoundConstructor
  public SCTMTestType(String pattern, boolean faildedIfNotNew, boolean deleteOutputFiles) {
    super(pattern, faildedIfNotNew, deleteOutputFiles);
  }
  
  @Override
  public TestTypeDescriptor<? extends TestType> getDescriptor() {
    return new SCTMTestType.DescriptorImpl();
  }

  @Extension
  public static class DescriptorImpl extends TestTypeDescriptor<SCTMTestType> {

    public DescriptorImpl() {
      super(SCTMTestType.class, SCTMInputMetric.class);
    }
    
    @Override
    public String getId() {
      return SCTMTestType.class.getCanonicalName();
    }
    
  }
}
