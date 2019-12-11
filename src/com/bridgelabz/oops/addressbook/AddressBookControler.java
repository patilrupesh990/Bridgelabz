package com.bridgelabz.oops.addressbook;

import org.json.JSONException;

public class AddressBookControler 
{

	public static void main(String[] args) throws JSONException 
	{
		AddressBook addressbook=new AddressBook();
		System.out.println("Present Project Directory : "+ System.getProperty("user.dir"));
		addressbook.mainMenu();
	}
		
}
