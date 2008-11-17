package hudson.plugins.sctmexecutor;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
  PwdCryptTest.class,
  TestResultCollector.class
})
public class TestAll {
}
