package hudson.plugins.sctmexecutor.publisher;

import java.util.Collection;

public interface ISCTMMultipleConfigurationTest {

  String getConfigurationForResult(SCTMTestConfigurationResult configurationResult);

  SCTMTestConfigurationResult getTestResultForConfiguration(String configuration);

  Collection<String> getConfigurations();

}