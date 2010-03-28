package hudson.plugins.sctmexecutor.publisher.xunit;

import org.kohsuke.stapler.DataBoundConstructor;

import hudson.Extension;

import com.thalesgroup.hudson.plugins.xunit.types.XUnitType;
import com.thalesgroup.hudson.plugins.xunit.types.XUnitTypeDescriptor;

public class SCTMUnitType extends XUnitType {
  private static final long serialVersionUID = 1L;

  
  @DataBoundConstructor
  public SCTMUnitType(String pattern, String customXSL, boolean faildedIfNotNew, boolean deleteJUnitFiles) {
    super(pattern, customXSL, faildedIfNotNew, deleteJUnitFiles);
  }
  
  @Override
  public String getXsl() {
    return "sctm-to-junit.xsl";
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
      return "Silk Central TestManager";
    }
    
    @Override
    public String getId() {
      return "sctmunit";
    }
    
  }
}
