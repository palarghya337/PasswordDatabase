package com.arghya.passworddatabase.logic;

import java.util.ArrayList;
import java.util.Scanner;

import javax.crypto.SealedObject;

public class DataBase
{
  private Scanner scanner;
  private ArrayList<SealedObject> listOfData;
  
  public DataBase(Scanner scanner)
  {
    this.scanner = scanner;
    this.listOfData = getData();
  }
  
  public void getMenu()
  {
    boolean flag = true;
    do
    {
      System.out.println("\n1. Add");
      System.out.println("2. Update");
      System.out.println("3. Delete");
      System.out.println("4. Display");
      System.out.println("5. Exit");
      try
      {
        System.out.println("Enter your selection.");
        flag = isValidated(Integer.valueOf(this.scanner.nextLine()));
      }
      catch (NumberFormatException e)
      {
        System.out.println("Wrong entry!!");
      }
    } while (flag);
  }
  
  private boolean isValidated(Integer value)
  {
    switch (value.intValue())
    {
    case 1: 
      new AddData(this.listOfData, this.scanner);
      getData();
      return true;
    case 2: 
      if ((this.listOfData != null) && (this.listOfData.size() != 0))
      {
        new UpdateData(this.listOfData, this.scanner);
        getData();
      }
      else
      {
        System.out.println("No data found!!!");
      }
      return true;
    case 3: 
      if ((this.listOfData != null) && (this.listOfData.size() != 0)) {
        new DeleteData(this.listOfData, this.scanner);
      } else {
        System.out.println("No data found!!!");
      }
      return true;
    case 4: 
      if ((this.listOfData != null) && (this.listOfData.size() != 0)) {
        new DisplayData(this.listOfData);
      } else {
        System.out.println("No data found!!!");
      }
      return true;
    case 5: 
      return false;
    }
    System.out.println("Wrong entry!!");
    
    return true;
  }
  
  /* Error */
  private ArrayList<SealedObject> getData()
  {
	  return null;
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: aconst_null
    //   5: astore_3
    //   6: new 109	java/io/FileInputStream
    //   9: dup
    //   10: invokestatic 111	com/arghya/passwordDatabase/util/DatabaseUtil:getFile	()Ljava/io/File;
    //   13: invokespecial 117	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   16: astore_1
    //   17: aload_1
    //   18: invokevirtual 120	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   21: invokevirtual 124	java/nio/channels/FileChannel:size	()J
    //   24: lconst_0
    //   25: lcmp
    //   26: ifeq +162 -> 188
    //   29: new 129	java/io/ObjectInputStream
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 131	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   37: astore_2
    //   38: aload_2
    //   39: invokevirtual 134	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   42: checkcast 89	java/util/ArrayList
    //   45: astore_3
    //   46: goto +142 -> 188
    //   49: astore 4
    //   51: aload 4
    //   53: invokevirtual 138	java/io/FileNotFoundException:printStackTrace	()V
    //   56: aload_1
    //   57: ifnull +7 -> 64
    //   60: aload_1
    //   61: invokevirtual 143	java/io/FileInputStream:close	()V
    //   64: aload_2
    //   65: ifnull +149 -> 214
    //   68: aload_2
    //   69: invokevirtual 146	java/io/ObjectInputStream:close	()V
    //   72: goto +142 -> 214
    //   75: astore 6
    //   77: aload 6
    //   79: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   82: goto +132 -> 214
    //   85: astore 4
    //   87: aload 4
    //   89: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   92: aload_1
    //   93: ifnull +7 -> 100
    //   96: aload_1
    //   97: invokevirtual 143	java/io/FileInputStream:close	()V
    //   100: aload_2
    //   101: ifnull +113 -> 214
    //   104: aload_2
    //   105: invokevirtual 146	java/io/ObjectInputStream:close	()V
    //   108: goto +106 -> 214
    //   111: astore 6
    //   113: aload 6
    //   115: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   118: goto +96 -> 214
    //   121: astore 4
    //   123: aload 4
    //   125: invokevirtual 150	java/lang/ClassNotFoundException:printStackTrace	()V
    //   128: aload_1
    //   129: ifnull +7 -> 136
    //   132: aload_1
    //   133: invokevirtual 143	java/io/FileInputStream:close	()V
    //   136: aload_2
    //   137: ifnull +77 -> 214
    //   140: aload_2
    //   141: invokevirtual 146	java/io/ObjectInputStream:close	()V
    //   144: goto +70 -> 214
    //   147: astore 6
    //   149: aload 6
    //   151: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   154: goto +60 -> 214
    //   157: astore 5
    //   159: aload_1
    //   160: ifnull +7 -> 167
    //   163: aload_1
    //   164: invokevirtual 143	java/io/FileInputStream:close	()V
    //   167: aload_2
    //   168: ifnull +17 -> 185
    //   171: aload_2
    //   172: invokevirtual 146	java/io/ObjectInputStream:close	()V
    //   175: goto +10 -> 185
    //   178: astore 6
    //   180: aload 6
    //   182: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   185: aload 5
    //   187: athrow
    //   188: aload_1
    //   189: ifnull +7 -> 196
    //   192: aload_1
    //   193: invokevirtual 143	java/io/FileInputStream:close	()V
    //   196: aload_2
    //   197: ifnull +17 -> 214
    //   200: aload_2
    //   201: invokevirtual 146	java/io/ObjectInputStream:close	()V
    //   204: goto +10 -> 214
    //   207: astore 6
    //   209: aload 6
    //   211: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   214: aload_3
    //   215: areturn
    // Line number table:
    //   Java source line #82	-> byte code offset #0
    //   Java source line #83	-> byte code offset #2
    //   Java source line #84	-> byte code offset #4
    //   Java source line #86	-> byte code offset #6
    //   Java source line #87	-> byte code offset #17
    //   Java source line #88	-> byte code offset #29
    //   Java source line #89	-> byte code offset #38
    //   Java source line #91	-> byte code offset #46
    //   Java source line #92	-> byte code offset #51
    //   Java source line #99	-> byte code offset #56
    //   Java source line #100	-> byte code offset #60
    //   Java source line #101	-> byte code offset #64
    //   Java source line #102	-> byte code offset #68
    //   Java source line #103	-> byte code offset #72
    //   Java source line #104	-> byte code offset #77
    //   Java source line #93	-> byte code offset #85
    //   Java source line #94	-> byte code offset #87
    //   Java source line #99	-> byte code offset #92
    //   Java source line #100	-> byte code offset #96
    //   Java source line #101	-> byte code offset #100
    //   Java source line #102	-> byte code offset #104
    //   Java source line #103	-> byte code offset #108
    //   Java source line #104	-> byte code offset #113
    //   Java source line #95	-> byte code offset #121
    //   Java source line #96	-> byte code offset #123
    //   Java source line #99	-> byte code offset #128
    //   Java source line #100	-> byte code offset #132
    //   Java source line #101	-> byte code offset #136
    //   Java source line #102	-> byte code offset #140
    //   Java source line #103	-> byte code offset #144
    //   Java source line #104	-> byte code offset #149
    //   Java source line #97	-> byte code offset #157
    //   Java source line #99	-> byte code offset #159
    //   Java source line #100	-> byte code offset #163
    //   Java source line #101	-> byte code offset #167
    //   Java source line #102	-> byte code offset #171
    //   Java source line #103	-> byte code offset #175
    //   Java source line #104	-> byte code offset #180
    //   Java source line #106	-> byte code offset #185
    //   Java source line #99	-> byte code offset #188
    //   Java source line #100	-> byte code offset #192
    //   Java source line #101	-> byte code offset #196
    //   Java source line #102	-> byte code offset #200
    //   Java source line #103	-> byte code offset #204
    //   Java source line #104	-> byte code offset #209
    //   Java source line #107	-> byte code offset #214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	DataBase
    //   1	192	1	fileInputStream	java.io.FileInputStream
    //   3	198	2	objectInputStream	java.io.ObjectInputStream
    //   5	210	3	listOfObject	ArrayList<SealedObject>
    //   49	3	4	e	java.io.FileNotFoundException
    //   85	3	4	e	java.io.IOException
    //   121	3	4	e	ClassNotFoundException
    //   157	29	5	localObject	Object
    //   75	3	6	e	java.io.IOException
    //   111	3	6	e	java.io.IOException
    //   147	3	6	e	java.io.IOException
    //   178	3	6	e	java.io.IOException
    //   207	3	6	e	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   6	46	49	java/io/FileNotFoundException
    //   56	72	75	java/io/IOException
    //   6	46	85	java/io/IOException
    //   92	108	111	java/io/IOException
    //   6	46	121	java/lang/ClassNotFoundException
    //   128	144	147	java/io/IOException
    //   6	56	157	finally
    //   85	92	157	finally
    //   121	128	157	finally
    //   159	175	178	java/io/IOException
    //   188	204	207	java/io/IOException
  }
}
