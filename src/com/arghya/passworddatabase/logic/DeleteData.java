package com.arghya.passworddatabase.logic;

import com.arghya.passworddatabase.util.DatabaseUtil;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import javax.crypto.SealedObject;

public class DeleteData
{
  public DeleteData(ArrayList<SealedObject> listOfData, Scanner scanner)
  {
    new DisplayData(listOfData);
    delete(listOfData, scanner);
  }
  
  private void delete(ArrayList<SealedObject> listOfData, Scanner scanner)
  {
    boolean flag = true;
    do
    {
      try
      {
        System.out.println("Enter your selection.");
        System.out.println("Press 'M' to go to (M)ain menu.");
        int selction = Integer.valueOf(scanner.nextLine()).intValue() - 1;
        if (listOfData.size() >= selction)
        {
          System.out.println("Are you sure you want to delete this record?");
          System.out.println("Press 'Y' to delete or 'N' revert");
          String selection = scanner.nextLine();
          if ("Y".equalsIgnoreCase(selection))
          {
            listOfData.remove(selction);
            new AddData().writeIntoDatabase(DatabaseUtil.getFile(), listOfData);
            System.out.println("Data has been removed successfully");
          }
          flag = false;
        }
        else
        {
          flag = true;
          System.out.println("Wrong entry!!");
        }
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
