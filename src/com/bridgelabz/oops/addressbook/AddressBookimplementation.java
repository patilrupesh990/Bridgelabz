package com.bridgelabz.oops.addressbook;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.simple.parser.ParseException;

import com.bridgelabz.util.Utility;

/***********************************************************************************************************
 * @author Rupeshp007
 * date:12/12/2019
 * @version 1.0
 * Purpose:AddressBook management Service class it contains operations like create Book,Open Book,Select Book UpdateFile..etc;
 * 
 * Operations:
 * 1.create File
 * 2.Open book
 * 3.Select File
 * 4.Update File
 *
 **********************************************************************************************************/

public class AddressBookimplementation extends AddressBookReadWrite implements AddressBook 
{
	//initializations 
	static ObjectMapper objectmapper=new ObjectMapper();
	static List<PersonDetails> persondetails=new ArrayList<PersonDetails>();
	static AddressBookimplementation addressbook = new AddressBookimplementation();
	static String originbook="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/jsonfiles/";
	static String fileName="/home/user/Documents/FellowShip/Bridgelabz/src/com/bridgelabz/oops/addressbook/AddressBook.json";
	static private String bookName=null;
	static AddressBookPerson personacsess=new AddressBookPerson();

	
	/*********************************************************************************
	 * Purpose: To get name of Current OpenBook.
	 * 
	 *  @param no parameter
	 *  @return String book name
	 *******************************************************************************/	

	public static String getBookName() {
		return bookName;
	}

	/*********************************************************************************
	 * It will set the name of current open book.
	 *  @param String bookName
	 *  @return void
	 *******************************************************************************/	

	public static void setBookName(String bookName) {
		AddressBookimplementation.bookName = bookName;
	}


	
	/*********************************************************************************
	 * To create new book for store details of user it will take book name from user and
	 * create file with (.json) extension.
	 * 
	 *  @param String bookName
	 *  @return void
	 *******************************************************************************/	

	public  void createBook(String originbook) {
		//AddressDetails addressBook=null;
		System.out.println("Enter the name of the book in (.json) extention (eg:file.json)");
		String book = Utility.InputString();
		File file = new File(originbook + book);
		boolean newjason=false;
		try {
			newjason = file.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if (newjason) {
			System.out.println("Book is succesfully created and add to the file");
		} else
			try {
				throw new AddressBookException("The Name of that book is already exists pls create new book");
			} catch (AddressBookException e) {
				e.printStackTrace();
			}
	}
	
	/*********************************************************************************************
	 * it will Open Book based on the user input first it will print all list of available (.json)
	 *  Files from list user can choose the file and enter book name as input.
	 * 
	 *  @param no parameter
	 *  @return void
	 *******************************************************************************/	

	static String filenameclose;
	public  void openBook() 
	{
		System.out.println("The books are Available:");
		
		
		 File directory = new File(originbook);

	        //get all the files from a directory
	        File[] arrayOfFiles = directory.listFiles();
	        for (File file : arrayOfFiles){
	        	System.out.println(file.getName());
	        }
	    
		System.out.println("Choose the File and Eter Name of file");
		String bookName=Utility.InputString();
		AddressBookimplementation.setBookName(bookName);
		int flag=0;
		for (File file : arrayOfFiles) 
		{
			String filename = file.getName();
			filenameclose=filename;
					if (bookName.equals(filename)) 
					{
			
						System.out.println("Add new data onto the Address Book");
						try {
							try {
								AddressBookMenu(filename);
							} catch (JSONException e) {
								e.printStackTrace();
							}
						} catch (FileNotFoundException | ParseException e) {
							e.printStackTrace();
						}
					}
				flag=1;
			}//end for loop

		if(flag==0)
			try {
				throw new AddressBookException("File doesnot exist or u have not given extention(.json)");
			} catch (AddressBookException e) {
				e.printStackTrace();
			}
		
	}//
	
	/*********************************************************************************
	 * to close Current Open file 
	 * 
	 *  @param no parameter
	 *  @return void
	 *******************************************************************************/	

	 
	public  void closeFile()
	{
		System.out.println(filenameclose+"File closed");
	}
	 
	/*********************************************************************************
	 * Purpose: It show the Menu Options for AddressBook it will give options to user 
	 * 			like.. 
	 * 				1.Add New Person 
	 * 				2.Delete Person
	 * 				3.Show all entry in book
	 * 				4.Sort the list
	 * 				5.Search Person in list
	 * 				6.Save changes in File
	 * 				7. mainMenu
	 * 				8. exit
	 * 
	 * 
	 *  @param no FileName
	 *  @return void
	 *  @exception JSONException,FileNotFoundException,parseException
	 *******************************************************************************/	
	 	 
	 public static  void AddressBookMenu(String filename) throws JSONException,FileNotFoundException, ParseException
		{
			int choice=0;
			while(true)
			{
						System.out.println("Select the Option");
						System.out.println(" 1.Add New Person \n 2.Delete Person \n 3.Show All Entry \n 4.sort List \n 5.Search Person \n  6.save File \n 7.Edit Person Details \n 8.MainMenu \n 9.exit");
						try{
						 choice=Utility.InputInt();
						}
						catch (NumberFormatException ne) {
							System.out.println("invalid input");
						}
						switch(choice)
						{
							case 1:
								personacsess.addNewPeson(filename);
										break;
							case 2:
								personacsess.deletePerson();
										break;
							case 3:
								personacsess.readFromJSON();
										break;
										
							case 4:
								personacsess.sortByName();
									break;
							case 5:
								  personacsess.SearchPerson();
										break;
							case 6:
									personacsess.Save();
										break;
							case 7:	 personacsess.editPerson();
									 break;
							case 8:
										AddressBook.mainMenu();
										break;
							case 9:
										System.out.println("Thank you visit  again:");
										System.exit(0);
							default:
								try {
									throw new AddressBookException("Invalid choice");
								} catch (AddressBookException e) {
									e.printStackTrace();
								}
						}
			}
		}
		
}
