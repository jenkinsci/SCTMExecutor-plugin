package hudson.plugins.sctmexecutor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PwdCryptTest {

  @Test
  public void testEncrypt() throws Exception {
    String input = "AVeryGoodPassWd";
    String pass = "c07deb5611f085b6ca18d332e7a9f06c6ae388ac01100ec43f6f02ccb442b6dc";
    String secret = PwdCrypt.encode(input, pass);
    String output = PwdCrypt.decode(secret, pass);
    assertEquals(input, output);
  }
}
