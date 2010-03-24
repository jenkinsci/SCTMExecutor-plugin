package hudson.plugins.sctmexecutor;

import hudson.FilePath;
import hudson.plugins.sctmexecutor.exceptions.SCTMException;
import hudson.plugins.sctmexecutor.service.ISCTMService;

import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.borland.sctm.ws.execution.entities.ExecutionResult;
import com.borland.sctm.ws.execution.entities.TestDefinitionResult;
import com.borland.sctm.ws.performer.SPNamedEntity;

public class SCTMResultWriter implements ITestResultWriter {
  private static final Logger LOGGER = Logger.getLogger("hudson.plugins.sctmexecutor");
  
  private ISCTMService service;
  private FilePath rootDir;
  private boolean ignoreSetupCleanup;

  public SCTMResultWriter(FilePath rootDir, ISCTMService service, boolean ignoreSetupCleanup) {
    this.rootDir = rootDir;
    this.service = service;
    this.ignoreSetupCleanup = ignoreSetupCleanup;
  }

  @Override
  public void write(ExecutionResult result) throws SCTMException {
    try {
      FilePath execDefFolder = new FilePath(this.rootDir, result.getExecDefName());
        execDefFolder.mkdirs();
      
      if (!ignoreSetupCleanup) {
        writeTestDefResult(result.getSetupTestDef(), execDefFolder);
        writeTestDefResult(result.getCleanupTestDef(), execDefFolder);
      }
      
      for (TestDefinitionResult testResult : result.getTestDefResult()) {
        writeTestDefResult(testResult, execDefFolder);
      }
    } catch (Exception e) {
      String msg = MessageFormat.format("Cannot create result folder for Execution definition ''{0}'' ({1}). ", result.getExecDefName(), result.getExecDefId());
      LOGGER.log(Level.FINE, msg, e);
      throw new SCTMException(msg);
    }
  }

  private void writeTestDefResult(TestDefinitionResult testDefResult, FilePath execDefResultFolder) throws SCTMException {
    String name = testDefResult.getName();
    int testRunId = testDefResult.getTestRunId();
    
    try {
      FilePath testDefResFolder = new FilePath(execDefResultFolder, name);
      testDefResFolder.mkdirs();
      SPNamedEntity[] resultFiles = this.service.getResultFiles(testRunId);
      for (SPNamedEntity resultFile : resultFiles) {
        String resultFileName = resultFile.getMsName();
        FilePath file = new FilePath(testDefResFolder, resultFileName);
        this.service.loadResultFile(resultFile.getMiId(), file);      
      }
    } catch (Exception e) {
      String msg = MessageFormat.format("Cannot create result folder for Test definition ''{0}'' ({1}). ", testDefResult.getName(), testDefResult.getTestDefId());
      LOGGER.log(Level.FINE, msg, e);
      throw new SCTMException(msg);
    }
    
  }

}
