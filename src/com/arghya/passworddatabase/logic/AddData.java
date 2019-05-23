package com.arghya.passworddatabase.logic;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.crypto.SealedObject;

import com.arghya.passworddatabase.bean.DataBasePojo;
import com.arghya.passworddatabase.util.DatabaseUtil;

public class AddData
{
  private Scanner scanner;
  
  public AddData() {}
  
  public AddData(ArrayList<SealedObject> listOfData, Scanner scanner)
  {
    this.scanner = scanner;
    createFile(listOfData);
  }
  
  private void createFile(ArrayList<SealedObject> listOfData)
  {
    File file = DatabaseUtil.getFile();
    writeIntoDatabase(file, getUserData(listOfData));
  }
  
  private ArrayList<SealedObject> getUserData(ArrayList<SealedObject> listOfData)
  {
    DataBasePojo dataBasePojo = new DataBasePojo();
    System.out.print("Website:");
    dataBasePojo.setWebsite(this.scanner.nextLine());
    System.out.print("UserName:");
    dataBasePojo.setUserName(this.scanner.nextLine());
    System.out.print("Password:");
    dataBasePojo.setPassword(this.scanner.nextLine());
    if (listOfData == null)
    {
      ArrayList<SealedObject> arrayList = new ArrayList<>();
      arrayList.add(DatabaseUtil.encryptObject(dataBasePojo));
      return arrayList;
    }
    listOfData.add(DatabaseUtil.encryptObject(dataBasePojo));
    return listOfData;
  }
  
  /* Error */
  public void writeIntoDatabase(File file, ArrayList<SealedObject> listOfData)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: new 99	java/io/FileOutputStream
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 101	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   13: astore_3
    //   14: new 104	java/io/ObjectOutputStream
    //   17: dup
    //   18: aload_3
    //   19: invokespecial 106	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore 4
    //   24: aload 4
    //   26: aload_2
    //   27: invokevirtual 109	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   30: goto +85 -> 115
    //   33: astore 5
    //   35: aload 5
    //   37: invokevirtual 113	java/io/FileNotFoundException:printStackTrace	()V
    //   40: aload 4
    //   42: invokevirtual 118	java/io/ObjectOutputStream:close	()V
    //   45: aload_3
    //   46: invokevirtual 121	java/io/FileOutputStream:close	()V
    //   49: goto +85 -> 134
    //   52: astore 7
    //   54: aload 7
    //   56: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   59: goto +75 -> 134
    //   62: astore 5
    //   64: aload 5
    //   66: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   69: aload 4
    //   71: invokevirtual 118	java/io/ObjectOutputStream:close	()V
    //   74: aload_3
    //   75: invokevirtual 121	java/io/FileOutputStream:close	()V
    //   78: goto +56 -> 134
    //   81: astore 7
    //   83: aload 7
    //   85: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   88: goto +46 -> 134
    //   91: astore 6
    //   93: aload 4
    //   95: invokevirtual 118	java/io/ObjectOutputStream:close	()V
    //   98: aload_3
    //   99: invokevirtual 121	java/io/FileOutputStream:close	()V
    //   102: goto +10 -> 112
    //   105: astore 7
    //   107: aload 7
    //   109: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   112: aload 6
    //   114: athrow
    //   115: aload 4
    //   117: invokevirtual 118	java/io/ObjectOutputStream:close	()V
    //   120: aload_3
    //   121: invokevirtual 121	java/io/FileOutputStream:close	()V
    //   124: goto +10 -> 134
    //   127: astore 7
    //   129: aload 7
    //   131: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   134: return
    // Line number table:
    //   Java source line #65	-> byte code offset #0
    //   Java source line #66	-> byte code offset #2
    //   Java source line #68	-> byte code offset #5
    //   Java source line #69	-> byte code offset #14
    //   Java source line #70	-> byte code offset #24
    //   Java source line #71	-> byte code offset #30
    //   Java source line #72	-> byte code offset #35
    //   Java source line #77	-> byte code offset #40
    //   Java source line #78	-> byte code offset #45
    //   Java source line #79	-> byte code offset #49
    //   Java source line #80	-> byte code offset #54
    //   Java source line #73	-> byte code offset #62
    //   Java source line #74	-> byte code offset #64
    //   Java source line #77	-> byte code offset #69
    //   Java source line #78	-> byte code offset #74
    //   Java source line #79	-> byte code offset #78
    //   Java source line #80	-> byte code offset #83
    //   Java source line #75	-> byte code offset #91
    //   Java source line #77	-> byte code offset #93
    //   Java source line #78	-> byte code offset #98
    //   Java source line #79	-> byte code offset #102
    //   Java source line #80	-> byte code offset #107
    //   Java source line #82	-> byte code offset #112
    //   Java source line #77	-> byte code offset #115
    //   Java source line #78	-> byte code offset #120
    //   Java source line #79	-> byte code offset #124
    //   Java source line #80	-> byte code offset #129
    //   Java source line #83	-> byte code offset #134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	AddData
    //   0	135	1	file	File
    //   0	135	2	listOfData	ArrayList<SealedObject>
    //   1	120	3	fileOutputStream	java.io.FileOutputStream
    //   3	113	4	objectOutputStream	java.io.ObjectOutputStream
    //   33	3	5	e	java.io.FileNotFoundException
    //   62	3	5	e	java.io.IOException
    //   91	22	6	localObject	Object
    //   52	3	7	e	java.io.IOException
    //   81	3	7	e	java.io.IOException
    //   105	3	7	e	java.io.IOException
    //   127	3	7	e	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   5	30	33	java/io/FileNotFoundException
    //   40	49	52	java/io/IOException
    //   5	30	62	java/io/IOException
    //   69	78	81	java/io/IOException
    //   5	40	91	finally
    //   62	69	91	finally
    //   93	102	105	java/io/IOException
    //   115	124	127	java/io/IOException
  }
}
