package com.bridgelabz.oops.addressbook;

import java.io.IOException;

import org.json.JSONException;

import com.bridgelabz.util.Utility;

public interface AddressBook
{
	static String originbook="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/jsonfiles/";
	public void createBook(String fileName);
	public void openBook();
	public void closeFile();
	
	public static void mainMenu() throws JSONException
	{
		AddressBookimplementation addressbook=new AddressBookimplementation();
		while(true)
		{
		int choice=0;
		System.out.println("Eneter your choice");
		System.out.println("1.New Book  2.Open Book   3.close Book 4.Quite");
		try{
		choice=Utility.InputInt();
		}catch (NumberFormatException ne) {
			System.out.println("Invalid input");
		}
		switch(choice)
		{
			case 1:
			addressbook.createBook(originbook);
					break;
			
			case 2:		
					addressbook.openBook();
						break;
						
			
			case 3:
					addressbook.closeFile();
						break;
			case 4:
						System.exit(0);
			
			default:
			try {
				throw new AddressBookException("please Enter valid input");
			} catch (AddressBookException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						break;
		}
	}
	}//end mainMenu
	
	
}
