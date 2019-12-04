package com.bridgelabz.oops.addressbook;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.util.Utility;

public class AddressBookPerson 
{
	static List<PersonDetails> personDetails=new ArrayList<PersonDetails>();
	static List<AddressDetails> addressDetails=new ArrayList<AddressDetails>();

	static PersonDetails person=null;
	
	public static void addNewPeson(String filename)
	{
		person=new PersonDetails();

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
			AddressDetails address=addAddress();
			person.setAddress(address);
		
		System.out.println("Eneter the PhNo");
		try{
		long phoneNo=Utility.inputLong();
		person.setPhoneNo(phoneNo);
		}catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Digits not allowed");
		}
		personDetails.add(person);
		String jsonPerson=JsonUtility.ConverJavaToJson(person);
		String fileName="/home/user/Documents/FellowShip/Bridgelabz/src/com/bridgelabz/oops/addressbook/"+filename;
		//WriteinFile(jsonPerson, fileName);
	}// End AddPers   on
	
	
	
	
	public static AddressDetails addAddress()
	{
		AddressDetails address=new AddressDetails();

		try{
			System.out.println("Eter Street");
			String street=Utility.InputString();
			address.setstreet(street);
			}catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Digits not allowed");
			}
			
			System.out.println("Enter City");
			try{
			String city=Utility.InputString();
			address.setCity(city);
			}catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Digits not allowed");
			}
			
			System.out.println("Enter State");
			try{
			String state=Utility.InputString();
			address.setState(state);
			}catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Digits not allowed");
			}
			
			System.out.println("Enter pincode");
			try{
			int pinCode=Utility.InputInt();
			address.setPinCode(pinCode);
			}
			catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Digits only allowed");
			}		
			addressDetails.add(address);
			return address;

	}
	
	public static void deletePerson(String fileName)
	{
		System.out.println("Enter the Fist Name the person who's want to Remve..");
		String fname=Utility.InputString();
		System.out.println("Last Name");
		String lname=Utility.InputString();
		for(PersonDetails p:personDetails)
		{
			if(personDetails.equals(fname)&&personDetails.equals(lname))
			{
				personDetails.remove(p);
			}
			else
			{
				System.out.println("The Book is Empty");
			}
		}
	}
	

	public static void printEntries()
	{
		System.out.println("Details of All Entries:");
		for(PersonDetails p:personDetails)
		{
			System.out.println("First Name"+p.getFirstName());
			System.out.println("Last Name"+p.getLastName());
			System.out.print("Address:");
			AddressDetails address=(AddressDetails) p.getAddress();
			System.out.println("street"+address.getstreet());
			System.out.println("city"+address.getCity());
			System.out.println("state"+address.getState());
			System.out.println("pinCode"+address.getPinCode());
		}
	}
	
	
	public static void searchPerson()
	{
		System.out.println("Enter the firstname");
		String fname=Utility.InputString();
		System.out.println("Enter the lastname");
		String lname=Utility.InputString();
		
		int flag=0;
		for(PersonDetails p:personDetails)
		{
			System.out.println();
			if(p.getFirstName().equals(fname)&&p.getLastName().equals(lname))
			{
				System.out.print("Fisrt Name:");
				System.out.println(p.getFirstName());
				
				System.out.print("Last Name:");
				System.out.println(p.getLastName());
				AddressDetails address=(AddressDetails) p.getAddress();
				System.out.print("address:");
				System.out.println("street"+address.getstreet());
				System.out.println("city"+address.getCity());
				System.out.println("state"+address.getState());
				System.out.println("pincode"+address.getPinCode());
				flag=1;
			}
		}
		if(flag==0)
		{
			System.out.println("invalid names or Data Not available");
		}
	}
}
