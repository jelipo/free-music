package Music.service;

import java.security.MessageDigest;
import sun.misc.BASE64Encoder;

public class Encryption
{
  public static String encrypted_id(String id)
  {
    byte[] byte1 = "3go8&$8*3*3h0k(2)2".getBytes();
    byte[] byte2 = id.getBytes();
    int byte1Length = byte1.length;
    for (int i = 0; i < byte2.length; i++)
    {
      byte tmp = byte1[(i % byte1Length)];
      byte2[i] = ((byte)(byte2[i] ^ tmp));
    }
    MessageDigest md5 = null;
    try
    {
      md5 = MessageDigest.getInstance("MD5");
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return "";
    }
    byte[] md5Bytes = md5.digest(byte2);
    String retval = new BASE64Encoder().encode(md5Bytes);
    retval = retval.replace('/', '_');
    retval = retval.replace('+', '-');
    return retval;
  }
}
