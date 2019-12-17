package com.bridgelabz.oops.addressbook;

import org.json.JSONException;

/***********************************************************************************************************
 * @author Rupeshp007
 * date:13/12/2019
 * @version 1.0
 * 
 *   Purpose:it's a controller for AddressBook management
 * 
 * - AddNewPerson in Current Open File
 * - delete Person From file
 * - AddressDetails
 * - save file
 * - read& write in json file
 * 
 **********************************************************************************************************/

public class AddressBookControler 
{

	public static void main(String[] args) throws JSONException 
	{
		System.out.println("Present Project Directory : "+ System.getProperty("user.dir"));
		AddressBook.mainMenu();
	}
		
}
