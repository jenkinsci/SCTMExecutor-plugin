package hudson.plugins.sctmexecutor;

import java.io.UnsupportedEncodingException;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * Crypto-logic
 * 
 * @author Thomas Fuerer
 */
final class PwdCrypt {
  private static final String CRYPTO_ALGORITHM = "DESede";
  private Key secretKey;

  PwdCrypt(String key) {
    secretKey = new SecretKeySpec(trimKey(key), CRYPTO_ALGORITHM);
  }

  private byte[] trimKey(String key) {
    byte[] b = key.getBytes();
    byte[] trimed = new byte[24];
    for (int i=0;i<24;i++) {
      trimed[i] = b[i];
    }
    
    return trimed;
  }

  String encrypt(String s) throws UnsupportedEncodingException {
    return String.valueOf(Base64.encodeBase64(crypt(s.getBytes("UTF8"), Cipher.ENCRYPT_MODE)));
  }
  
  String decrypt(String secret) throws UnsupportedEncodingException {
      return String.valueOf(crypt(Base64.decodeBase64(secret.getBytes("UTF8")), Cipher.DECRYPT_MODE));
  }

  private byte[] crypt(byte[] secret, int mode) {
    try {
      Cipher cipher = Cipher.getInstance(CRYPTO_ALGORITHM);
      cipher.init(mode, secretKey);
      return cipher.doFinal(secret);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
