package hudson.plugins.sctmexecutor.publisher.xunit;

import com.thalesgroup.hudson.plugins.xunit.types.XUnitType;

public class SCTMType extends XUnitType {
  private static final long serialVersionUID = 1L;

  protected SCTMType(String pattern, String customXSL, boolean faildedIfNotNew, boolean deleteJUnitFiles) {
    super(pattern, customXSL, faildedIfNotNew, deleteJUnitFiles);
  }
  
  @Override
  public String getXsl() {
    // TODO Auto-generated method stub
    return null;
  }

}
