package com.arghya.passworddatabase.util;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.spec.SecretKeySpec;

public class DatabaseUtil
{
  public static final SealedObject encryptObject(Serializable value)
  {
    byte[] keyValue = { 84, 104, 101, 66, 101, 115, 116, 83, 101, 99, 114, 101, 116, 75, 101, 121 };
    Key key = new SecretKeySpec(keyValue, "AES");
    SealedObject sealedObject = null;
    try
    {
      Cipher cipher = Cipher.getInstance("AES");
      cipher.init(1, key);
      sealedObject = new SealedObject(value, cipher);
    }
    catch (NoSuchAlgorithmException e)
    {
      e.printStackTrace();
    }
    catch (NoSuchPaddingException e)
    {
      e.printStackTrace();
    }
    catch (InvalidKeyException e)
    {
      e.printStackTrace();
    }
    catch (IllegalBlockSizeException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return sealedObject;
  }
  
  public static final Object decryptObject(SealedObject value)
  {
    byte[] keyValue = { 84, 104, 101, 66, 101, 115, 116, 83, 101, 99, 114, 101, 116, 75, 101, 121 };
    Key key = new SecretKeySpec(keyValue, "AES");
    Object object = null;
    try
    {
      Cipher cipher = Cipher.getInstance("AES");
      cipher.init(2, key);
      object = value.getObject(cipher);
    }
    catch (NoSuchAlgorithmException e)
    {
      e.printStackTrace();
    }
    catch (NoSuchPaddingException e)
    {
      e.printStackTrace();
    }
    catch (InvalidKeyException e)
    {
      e.printStackTrace();
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    catch (IllegalBlockSizeException e)
    {
      e.printStackTrace();
    }
    catch (BadPaddingException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return object;
  }
  
  public static final void alignText(int length, int pixel)
  {
    if (length < pixel) {
      for (int index = 0; index < pixel - length; index++) {
        System.out.print(" ");
      }
    }
  }
  
  public static final File getFolder()
  {
    File folder = new File("C:\\PasswordDatabase");
    if (!folder.exists()) {
      folder.mkdir();
    }
    return folder;
  }
  
  public static final File getFile()
  {
    File file = new File(getFolder().getAbsolutePath() + "\\" + 
      "PasswordDatabase");
    if (!file.exists()) {
      try
      {
        file.createNewFile();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    return file;
  }
}
