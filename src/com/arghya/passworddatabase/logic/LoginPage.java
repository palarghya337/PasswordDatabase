package com.arghya.passworddatabase.logic;

import java.io.IOException;
import java.util.Scanner;

public class LoginPage {

	private Scanner scanner = new Scanner(System.in);

	public void open() {
		System.out.println("\t\t*************** Password Database ***************\n");
		System.out.println("\t\t\t\t      Login");
		System.out.println("\t\t\t\t ---------------\n\n\n\n");
		System.out.print("UserName:");
		String userName = this.scanner.nextLine();
		System.out.print("Password:");
		char[] password = null;
		if (System.console() != null) {
			password = System.console().readPassword();
		} else {
			String value = this.scanner.nextLine();
			password = value.toCharArray();
		}
		if (("argpal".equals(userName)) && 
				("argpal".equals(new String(password)))) {
			DataBase database = new DataBase(this.scanner);
			database.getMenu();
		} else {
			System.out.println("You have entered wrong username or password.");
			int input = 0;
			do {
				System.out.println("Press enter to exit...");
				try {
					input = System.in.read();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (input != 13);
		}
	}
}
