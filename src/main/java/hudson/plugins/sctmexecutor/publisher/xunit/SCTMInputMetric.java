package hudson.plugins.sctmexecutor.publisher.xunit;

import org.jenkinsci.lib.dtkit.model.InputMetricXSL;
import org.jenkinsci.lib.dtkit.model.InputType;
import org.jenkinsci.lib.dtkit.model.OutputMetric;
import org.jenkinsci.plugins.xunit.types.model.JUnitModel;

public final class SCTMInputMetric extends InputMetricXSL {
  private static final long serialVersionUID = -38720636581583520L;

  @Override
  public String getXslName() {
    return "sctm-to-junit.xsl"; //$NON-NLS-1$
  }

  @Override
  public String getToolName() {
    return "Silk Central";
  }

  @Override
  public String getToolVersion() {
    return " >2008R2";
  }

  @Override
  public InputType getToolType() {
    return InputType.TEST;
  }

  @Override
  public OutputMetric getOutputFormatType() {
    return JUnitModel.LATEST;
  }
}
