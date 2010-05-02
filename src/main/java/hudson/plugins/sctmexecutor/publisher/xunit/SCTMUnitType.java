package hudson.plugins.sctmexecutor.publisher.xunit;

import hudson.Extension;

import org.kohsuke.stapler.DataBoundConstructor;

import com.thalesgroup.hudson.plugins.xunit.types.XUnitType;
import com.thalesgroup.hudson.plugins.xunit.types.XUnitTypeDescriptor;

public class SCTMUnitType extends XUnitType {
  private static final long serialVersionUID = 1L;
  
  @DataBoundConstructor
  public SCTMUnitType(String pattern, boolean faildedIfNotNew, boolean deleteJUnitFiles) {
    super(pattern, faildedIfNotNew, deleteJUnitFiles);
  }
  
  @Override
  public String getXsl() {
    return "sctm-to-junit.xsl"; //$NON-NLS-1$
  }
  
  @Override
  public XUnitTypeDescriptor<SCTMUnitType> getDescriptor() {
    return new SCTMUnitType.DescriptorImpl();
  }

  @Extension
  public static class DescriptorImpl extends XUnitTypeDescriptor<SCTMUnitType> {

    public DescriptorImpl() {
      super(SCTMUnitType.class);
    }

    @Override
    public String getDisplayName() {
      return Messages.getString("SCTMUnitType.xunit.pluginname"); //$NON-NLS-1$
    }
    
    @Override
    public String getId() {
      return "sctmunit"; //$NON-NLS-1$
    }
    
  }
}
