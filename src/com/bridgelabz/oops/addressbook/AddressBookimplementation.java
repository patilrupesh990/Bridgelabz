package com.bridgelabz.oops.addressbook;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import com.bridgelabz.util.Utility;

public class AddressBookimplementation
{
	public static void main(String[] args) 
	{
		addNewPeson();	
	}
	
	public static void createNewAddressBook()
	{
		
	}
	public static void AddressBookMenu()
	{
		int choice=0;
		System.out.println("Select the Option");
		System.out.println("1.Add New Person 2.Delete Person 3.Sort List");
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
						addNewPeson();
						break;
			case 2:
						deletePerson();
						break;
			case 3:
						printEntries();
						break;
			default:
					System.out.println("Invalid choice");
		}
	}
	
	public static void addNewPeson()
	{
		Person person=new Person();
		
		System.out.println("Enter the first Name of Person");
		try{
		String fName=Utility.InputString();
		person.setFirstName(fName);
		}catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Digits not allowed");
		}
		
		System.out.println("Enter the Last Name of person");
		try{
		String lName=Utility.InputString();
		person.setLastName(lName);
		}catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Digits not allowed");
		}
		
		System.out.println("Enter the Address");
		try{
		String address=Utility.InputString();
		person.setAddress(address);
		}catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Digits not allowed");
		}
		
		System.out.println("Enter City");
		try{
		String city=Utility.InputString();
		person.setCity(city);
		}catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Digits not allowed");
		}
		
		System.out.println("Enter State");
		try{
		String state=Utility.InputString();
		person.setState(state);
		}catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Digits not allowed");
		}
		
		System.out.println("Enter pincode");
		try{
		int pinCode=Utility.InputInt();
		person.setPinCode(pinCode);
		}
		catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Digits only allowed");
		}
		
		System.out.println("Eneter the PhNo");
		try{
		long phoneNo=Utility.inputLong();
		person.setPhoneNo(phoneNo);
		}catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Digits not allowed");
		}
		
		String jsonPerson=JsonUtility.ConverJavaToJson(person);
		String fileName="/home/user/Documents/FellowShip/Bridgelabz/src/com/bridgelabz/oops/addressbook/AddressBook.json";
		WriteinFile(jsonPerson, fileName);
	}
	public static void deletePerson()
	{}
	public static void printEntries()
	{}
	
	public static <T>void WriteinFile(T string,String filename)
	{
		try { 
			  
            // Open given file in append mode. 
            BufferedWriter out = new BufferedWriter( 
                   new FileWriter(filename, true)); 
            out.write(String.valueOf(string)); 
            out.close(); 
        }catch (FileNotFoundException e) {
			// TODO: handle exception
        	System.out.println("File Does Not Exist");
		}
		catch (IOException e) {
			
		} 
		
	}
	
}
