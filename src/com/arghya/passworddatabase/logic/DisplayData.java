package com.arghya.passworddatabase.logic;

import com.arghya.passworddatabase.bean.DataBasePojo;
import com.arghya.passworddatabase.util.DatabaseUtil;
import java.io.PrintStream;
import java.util.ArrayList;
import javax.crypto.SealedObject;

public class DisplayData
{
  public DisplayData(ArrayList<SealedObject> listOfData)
  {
    display(listOfData);
  }
  
  private void display(ArrayList<SealedObject> listOfData)
  {
    System.out.println("\n***************************************************************************");
    
    System.out.print("SL No.");
    DatabaseUtil.alignText("SL No.".length(), 9);
    System.out.print("UserName");
    DatabaseUtil.alignText("UserName".length(), 33);
    System.out.print("Website");
    DatabaseUtil.alignText("Website".length(), 22);
    System.out.println("Password\n");
    
    int index = 1;
    if (listOfData != null) {
      for (SealedObject sealedObject : listOfData)
      {
        String indexS = index++ + ".";
        System.out.print(indexS);
        DatabaseUtil.alignText(indexS.length(), 9);
        DataBasePojo dataBasePojo = (DataBasePojo)DatabaseUtil.decryptObject(sealedObject);
        String uName = dataBasePojo.getUserName();
        System.out.print(uName);
        DatabaseUtil.alignText(dataBasePojo.getUserName().length(), 33);
        System.out.print(dataBasePojo.getWebsite());
        DatabaseUtil.alignText(dataBasePojo.getWebsite().length(), 22);
        System.out.println(dataBasePojo.getPassword());
      }
    } else {
      System.out.println("No data found!!!");
    }
    System.out.println("\n***************************************************************************");
  }
}
