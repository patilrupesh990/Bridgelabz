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

import com.bridgelabz.util.Utility;

public class AddressBook
{
	static ObjectMapper objectmapper=new ObjectMapper();
	static List<PersonDetails> persondetails=new ArrayList<PersonDetails>();
	static AddressBook addressbook = new AddressBook();
	static String originbook="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/jsonfiles/";
	static private String bookName=null;

	
	public static String getBookName() {
		return bookName;
	}


	public static void setBookName(String bookName) {
		AddressBook.bookName = bookName;
	}


	public static void mainMenu() throws JSONException
	{
		while(true)
		{
		int choice=0;
		System.out.println("Eneter your choice");
		System.out.println("1.New Book  2.Open Book   3.close Book 4.Quite");
		try{
		choice=Utility.InputInt();
		}catch (NumberFormatException ne) {
			System.out.println("Invalid input");
			// TODO: handle exception
		}
		switch(choice)
		{
			case 1:
						try {
							createBook(originbook);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					break;
			
			case 2:		
						openBook();
						break;
						
			
			case 3:
						closeFile();
						break;
			case 4:
						System.exit(0);
			
			default:
						System.out.println("Invalid Option");
						break;
		}//end mainMenu
	}
	}
	

	public static void createBook(String originbook) throws IOException {
		//AddressDetails addressBook=null;
		System.out.println("Enter the name of the book in (.json) extention (eg:file.json)");
		String book = Utility.InputString();
		File file = new File(originbook + book);
		boolean newjason = file.createNewFile();
		if (newjason) {
			System.out.println("Book is succesfully created and add to the file");
		}
			else
			System.out.println("The Name of that book is already exists pls create new book");
	}

	static String filenameclose;
	public static void openBook() throws JSONException
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
		AddressBook.setBookName(bookName);
		int flag=0;
		for (File file : arrayOfFiles) 
		{
			String filename = file.getName();
			filenameclose=filename;
					if (bookName.equals(filename)) 
					{
			
						System.out.println("Add new data onto the Address Book");
						AddressBookMenu(filename);
					}
				flag=1;
			}//end for loop

		if(flag==0)
			System.out.println("File doesnot exist or u have not given extention(.json)");
		
	}//
	
	public static void setpersondetails(List<PersonDetails> persondetails) {
	        AddressBook.persondetails = persondetails;
	    }//
	 
	public static void closeFile()
	{
		System.out.println(filenameclose+"File closed");
	}
	 
	 
	 //////////////////////////////////////////////////////////////////////////
	 
		static String fileName="/home/user/Documents/FellowShip/Bridgelabz/src/com/bridgelabz/oops/addressbook/AddressBook.json";
	 public static void AddressBookMenu(String filename) throws JSONException  //use whene book open
		{
			int choice=0;
			while(true)
			{
						System.out.println("Select the Option");
						System.out.println("1.Add New Person 2.Delete Person 3.Show All Entry 4.Search Person 5.save File 6.MainMenu 7.exit");
						try{
						 choice=Utility.InputInt();
						}
						catch (NumberFormatException ne) {
							// TODO: handle exception
							System.out.println("invalid input");
						}
						switch(choice)
						{
							case 1:
										AddressBookPerson.addNewPeson(filename);
										break;
							case 2:
										AddressBookPerson.deletePerson(fileName);
										break;
							case 3:
										//AddressBookPerson.Print();;
										break;
							case 4:
										AddressBookPerson.searchPerson();
										break;
							case 5:
										AddressBookPerson.Save();
										break;
							case 6:
										mainMenu();
										break;
							case 7:
										System.exit(0);
							default:
									System.out.println("Invalid choice");
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
				// TODO: handle exception
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
				// TODO: handle exception
	        	System.out.println("File Does Not Exist");
			}
			catch (IOException e) {
				
			} 
			
		}

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
