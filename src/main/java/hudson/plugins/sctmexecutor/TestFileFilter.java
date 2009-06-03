package hudson.plugins.sctmexecutor;

import java.io.File;
import java.io.FileFilter;
import java.io.Serializable;

public class TestFileFilter implements FileFilter, Serializable {
  private static final long serialVersionUID = 1L;
  private String buildNo;

  public TestFileFilter(String buildNo) {
    this.buildNo = buildNo;
  }
  
  @Override
  public boolean accept(File pathname) {
    return pathname.getName().matches("TEST-(\\p{Print}*)-"+buildNo+".xml"); //$NON-NLS-1$ //$NON-NLS-2$
  }
}
