package hudson.plugins.sctmexecutor;

import org.junit.Assert;
import org.junit.Test;

public class UtilsTest {
  @Test
  public void testCsvToIntList() {
    Assert.assertArrayEquals(new Integer[]{123}, Utils.csvToIntList("123").toArray(new Integer[1]));
    Assert.assertArrayEquals(new Integer[]{123,124,125}, Utils.csvToIntList("123,124,125").toArray(new Integer[3]));
  }
  
  @Test(expected=NumberFormatException.class)
  public void testCsvToIntListWithWrongSeparator() throws Exception {
    Assert.assertArrayEquals(new Integer[]{123,124,125}, Utils.csvToIntList("123;124;125").toArray(new Integer[3]));    
  }
  
  @Test(expected=NumberFormatException.class)
  public void testCsvToIntListWithSpaces() throws Exception {
    Assert.assertArrayEquals(new Integer[]{123,124,125}, Utils.csvToIntList("123, 124, 125").toArray(new Integer[3]));    
  }
}
