package com.arghya.passworddatabase.logic;

import com.arghya.passworddatabase.bean.DataBasePojo;
import com.arghya.passworddatabase.util.DatabaseUtil;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import javax.crypto.SealedObject;

public class UpdateData
{
  public UpdateData(ArrayList<SealedObject> listOfData, Scanner scanner)
  {
    new DisplayData(listOfData);
    modifyRow(listOfData, scanner);
  }
  
  private void modifyRow(ArrayList<SealedObject> listOfData, Scanner scanner)
  {
    boolean flag = true;
    do
    {
      try
      {
        System.out.println("Enter your selection.");
        System.out.println("Press 'M' to go to (M)ain menu.");
        int selction = Integer.valueOf(scanner.nextLine()).intValue() - 1;
        DataBasePojo dataBasePojo = (DataBasePojo)DatabaseUtil.decryptObject((SealedObject)listOfData.get(selction));
        
        System.out.println("Which field you want to modify?");
        System.out.println("1. Website:");
        System.out.println("2. UserName:");
        System.out.println("3. Password:");
        System.out.println("Press 'M' to go to (M)ain menu.");
        int subSelection = Integer.valueOf(scanner.nextLine()).intValue();
        System.out.println("Please enter updated value");
        switch (subSelection)
        {
        case 1: 
          dataBasePojo.setWebsite(scanner.nextLine());
          flag = false;
          break;
        case 2: 
          dataBasePojo.setUserName(scanner.nextLine());
          flag = false;
          break;
        case 3: 
          dataBasePojo.setPassword(scanner.nextLine());
          flag = false;
          break;
        case 4: 
          flag = false;
          break;
        default: 
          System.out.println("Wrong entry!!");
        }
        listOfData.set(selction, DatabaseUtil.encryptObject(dataBasePojo));
        new AddData().writeIntoDatabase(DatabaseUtil.getFile(), listOfData);
        System.out.println("Data has been successfully updated!!!");
      }
      catch (NumberFormatException e)
      {
        flag = true;
        String message = e.getLocalizedMessage();
        if ("M".equalsIgnoreCase(message.substring(message.indexOf("\"") + 1, message.lastIndexOf("\"")))) {
          flag = false;
        } else {
          System.out.println("Wrong entry!!");
        }
      }
      catch (IndexOutOfBoundsException e)
      {
        flag = true;
        System.out.println("Wrong entry!!");
      }
    } while (flag);
  }
}
