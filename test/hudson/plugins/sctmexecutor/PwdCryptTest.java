package hudson.plugins.sctmexecutor;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class PwdCryptTest {

  @Test
  public void testEncrypt() throws IOException {
    String input = "Borland1234";
    PwdCrypt pwdCrypt = new PwdCrypt("c07deb5611f085b6ca18d332e7a9f06c6ae388ac01100ec43f6f02ccb442b6dc");
    String secret = pwdCrypt.encrypt(input);
    String output = pwdCrypt.decrypt(secret);
    assertEquals(input, output);
  }
}
