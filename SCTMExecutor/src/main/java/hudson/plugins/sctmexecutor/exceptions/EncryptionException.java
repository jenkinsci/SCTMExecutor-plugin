package hudson.plugins.sctmexecutor.exceptions;

public class EncryptionException extends RuntimeException {
  private static final long serialVersionUID = 1L;
  
  public EncryptionException(Throwable cause) {
    super(cause);
  }

}
