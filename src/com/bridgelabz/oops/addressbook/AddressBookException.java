package com.bridgelabz.oops.addressbook;

/***********************************************************************************************************
 * @author Rupeshp007
 * date:13/12/2019
 * @version 1.0
 * 
 * Purpose: AddressBook costomized Exception
 * 
 * 
 * 
 **********************************************************************************************************/

@SuppressWarnings("serial")
public class AddressBookException extends Throwable
{
	 AddressBookException(String message) {
		super(message);
	}
}
