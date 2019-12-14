package com.bridgelabz.oops.addressbook;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.simple.parser.ParseException;

import com.bridgelabz.util.Utility;

public class AddressBookimplementation implements AddressBook
{
	static ObjectMapper objectmapper=new ObjectMapper();
	static List<PersonDetails> persondetails=new ArrayList<PersonDetails>();
	static AddressBookimplementation addressbook = new AddressBookimplementation();
	static String originbook="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/jsonfiles/";
	static String fileName="/home/user/Documents/FellowShip/Bridgelabz/src/com/bridgelabz/oops/addressbook/AddressBook.json";
	static private String bookName=null;
	static AddressBookPerson personacsess=new AddressBookPerson();

	
	public static String getBookName() {
		return bookName;
	}


	public static void setBookName(String bookName) {
		AddressBookimplementation.bookName = bookName;
	}


	

	public  void createBook(String originbook) {
		//AddressDetails addressBook=null;
		System.out.println("Enter the name of the book in (.json) extention (eg:file.json)");
		String book = Utility.InputString();
		File file = new File(originbook + book);
		boolean newjason=false;
		try {
			newjason = file.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (newjason) {
			System.out.println("Book is succesfully created and add to the file");
		} else
			try {
				throw new AddressBookException("The Name of that book is already exists pls create new book");
			} catch (AddressBookException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

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
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} catch (FileNotFoundException | ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				flag=1;
			}//end for loop

		if(flag==0)
			try {
				throw new AddressBookException("File doesnot exist or u have not given extention(.json)");
			} catch (AddressBookException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}//
	
	public static void setpersondetails(List<PersonDetails> persondetails) {
	        AddressBookimplementation.persondetails = persondetails;
	    }//
	 
	public  void closeFile()
	{
		System.out.println(filenameclose+"File closed");
	}
	 
	 	 
	 public static  void AddressBookMenu(String filename) throws JSONException,FileNotFoundException, ParseException
		{
			int choice=0;
			while(true)
			{
						System.out.println("Select the Option");
						System.out.println("1.Add New Person 2.Delete Person 3.Show All Entry 4.sort List 5.Search Person  6.save File 7.MainMenu 8.exit");
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
								personacsess.deletePerson(fileName);
										break;
							case 3:
								personacsess.readFromJSON();
										break;
										
							case 4:
								personacsess.sortByName();
									break;
							case 5:
								//personacsess.searchPerson();
										break;
							case 6:
									personacsess.Save();
										break;
							case 7:
										AddressBook.mainMenu();
										break;
							case 8:
										System.out.println("Thank you visist  again:");
										System.exit(0);
							default:
								try {
									throw new AddressBookException("Invalid choice");
								} catch (AddressBookException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						}
			}
		}
		
		
		
		
		
		public static <T>void UpdateFile(String fileName,ArrayList<String> Lines)
		{
			try { 
				  
	            // Open given file in append mode. 
	            BufferedWriter out = new BufferedWriter( 
	                   new FileWriter(fileName, true));
	            
	            Iterator<String> iter = Lines.iterator();
	            while (iter.hasNext()) {
	            	out.write(String.valueOf(iter.next())); 
	            	out.newLine();
	            }
	            out.close();          
	        }catch (FileNotFoundException e) {
	        	System.out.println("File Does Not Exist");
			}
			catch (IOException e) {
				
			} 
		}
		
		public static <T>void WriteinFile(T string,String filename)
		{
			try { 
				  
	            // Open given file in append mode. 
	            BufferedWriter out = new BufferedWriter( 
	                   new FileWriter(filename, true)); 
	            out.write(String.valueOf(string)); 
	            out.newLine();
	            out.close(); 
	        }catch (FileNotFoundException e) {
	        	System.out.println("File Does Not Exist");
			}
			catch (IOException e) {
				
			} 
		}

}
