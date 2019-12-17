package com.bridgelabz.oops.addressbook;

import org.json.JSONException;

import com.bridgelabz.util.Utility;

/***********************************************************************************************************
 * @author Rupeshp007
 * date:12/12/2019
 * @version 1.0
 * Purpose:Interface to define contract methods  
 * Methods:
 * 
 * 1.Create Book
 * 2.Open book
 * 3.Close Book
 * 4.mainMenu static Method(Java 1.8)
 *
 **********************************************************************************************************/

public interface AddressBook
{
	static String originbook="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/jsonfiles/";
	
	
	public void createBook(String fileName);
	
	public void openBook();
	
	public void closeFile();
	
	/*********************************************************************************
	 * Purpose: MainMenu Of AddressBook project it gives Options To User Like.
	 * 	1.New Book
	 *  2.Open Book
	 *  3.Close Book
	 *  4.Quite
	 *  
	 *  @param no parameter
	 *  @return void
	 *  @exception JSONException
	 *******************************************************************************/	

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
