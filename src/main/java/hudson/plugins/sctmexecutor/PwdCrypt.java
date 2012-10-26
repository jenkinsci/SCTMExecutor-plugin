package hudson.plugins.sctmexecutor;

import hudson.plugins.sctmexecutor.exceptions.EncryptionException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.security.Key;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * Crypto-logic
 * 
 */
final class PwdCrypt {
  private static final String CRYPTO_ALGORITHM = "DESede"; //$NON-NLS-1$
  private static final Logger LOGGER = Logger.getLogger("hudson.plugins.sctmexecutor"); //$NON-NLS-1$
  
  PwdCrypt() {}

  static String encode(String toCrypt, String pass) {
    try {
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      Cipher c = Cipher.getInstance(CRYPTO_ALGORITHM);
      Key k = new SecretKeySpec(pass.substring(0, 24).getBytes(), CRYPTO_ALGORITHM);
      c.init(Cipher.ENCRYPT_MODE, k);

      OutputStream cos = new CipherOutputStream(out, c);
      cos.write(toCrypt.getBytes());
      cos.close();
      return new String(new Base64().encode(out.toByteArray()));
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, MessageFormat.format("Encode failed: {0}", e.getMessage())); //$NON-NLS-1$
      throw new EncryptionException(e);
    } 
  }

  static String decode(String secret, String pass ) { 
    try {
      ByteArrayInputStream is = new ByteArrayInputStream(new Base64().decode(secret.getBytes()));
      Cipher c = Cipher.getInstance(CRYPTO_ALGORITHM); 
      Key k = new SecretKeySpec(pass.substring(0, 24).getBytes(), CRYPTO_ALGORITHM ); 
      c.init( Cipher.DECRYPT_MODE, k ); 
 
      ByteArrayOutputStream bos = new ByteArrayOutputStream(); 
      CipherInputStream cis = new CipherInputStream( is, c ); 
 
      int b = 0;
      while ((b = cis.read()) != -1)
        bos.write(b); 
 
      cis.close(); 
      return bos.toString();
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, MessageFormat.format("Decode failed: ",e.getMessage())); //$NON-NLS-1$
      throw new EncryptionException(e);
    } 
  }
}
