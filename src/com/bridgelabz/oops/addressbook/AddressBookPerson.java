package com.bridgelabz.oops.addressbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.json.JSONException;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bridgelabz.util.Utility;

public class AddressBookPerson 
{
	static List<PersonDetails> personDetails=new ArrayList<PersonDetails>();
	static List<AddressDetails> addressDetails=new ArrayList<AddressDetails>();
	static HashMap<String, PersonDetails> personMap=new HashMap<>();
	static JSONObject personaddressjson=new JSONObject();
	static JSONObject personList=new JSONObject();
	JSONObject mainobject=new JSONObject();
	static PersonDetails person=null;
	static String originbook="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/jsonfiles/";
	public JSONParser parser = new JSONParser();


	
	public  void addNewPeson(String filename) throws JSONException
	{
		person=new PersonDetails();

		System.out.println("Enter the first Name of Person");
		try
		{
			person.setFirstName(Utility.InputString());
		}catch (NumberFormatException e) 
		{
			System.out.println("Digits not allowed");
		}
		
		System.out.println("Enter the Last Name of person");
		try{
		person.setLastName(Utility.InputString());
		}catch (NumberFormatException e) {
			System.out.println("Digits not allowed");
		}
		
			System.out.println("Enter the Address");
			AddressDetails address=AddressBookPerson.addAddress();
			person.setAddress(address);
		
		System.out.println("Eneter the PhNo");
		try{
		person.setPhoneNo(Utility.inputLong());
		}catch (NumberFormatException e) {
			System.out.println("Digits not allowed");
		}
		personDetails.add(person);
		
		this.addNewPesonToJsonFile();
		
				
	}// End AddPers   on
	
	
	public static AddressDetails addAddress()
	{
		AddressDetails address=new AddressDetails();

		try{
			System.out.println("Eter Street");
			String street=Utility.InputString();
			address.setstreet(street);
			}catch (NumberFormatException e) {
				System.out.println("Digits not allowed");
			}
			
			System.out.println("Enter City");
			try{
			String city=Utility.InputString();
			address.setCity(city);
			}catch (NumberFormatException e) {
				System.out.println("Digits not allowed");
			}
			
			System.out.println("Enter State");
			try{
			String state=Utility.InputString();
			address.setState(state);
			}catch (NumberFormatException e) {
				System.out.println("Digits not allowed");
			}
			
			System.out.println("Enter pincode");
			try{
			int pinCode=Utility.InputInt();
			address.setPinCode(pinCode);
			}
			catch (NumberFormatException e) {
				System.out.println("Digits only allowed");
			}		
			addressDetails.add(address);
			return address;
	}
	
	
	@SuppressWarnings("unchecked")
	public  void addNewPesonToJsonFile() throws JSONException
	{
		JSONObject personjson=new JSONObject();
		mainobject=JsonUtility.readFile2(originbook+AddressBook.getBookName());
		System.out.println(mainobject.toJSONString());
		String firstName=person.getFirstName();
		System.out.println(firstName);
		String lastName=person.getLastName();
		long phNo=person.getPhoneNo();
		AddressDetails address=(AddressDetails) person.getAddress();
		String street=address.getstreet();
		String city=address.getCity();
		String state=address.getState();
		int pinCode=address.getPinCode();
		
		
		personjson.put("firstName", firstName);
		personjson.put("lastName", lastName);
		personjson.put("phNo", phNo);
		
		personaddressjson.put("street", street);
		personaddressjson.put("city", city);
		personaddressjson.put("state", state);
		personaddressjson.put("pinCode", pinCode);
		
		personjson.put("address", personaddressjson);
		mainobject.put(firstName, personjson);
	}
	
	
	public  void Save() 
	{
		//System.out.println(AddressBook.getBookName());
		//System.out.println("hello");
		
        File file = new File(AddressBook.getBookName());
        System.out.println(AddressBook.getBookName());
        System.out.println(file.length());
		
			String temporary=mainobject.toString();
			System.out.println(temporary);
		JsonUtility.writeToFile(originbook+AddressBook.getBookName(), mainobject);	
	}
	
	
	@SuppressWarnings("unchecked")
	public void readFromJSON()
	{
		System.out.println("\n************************Details of Persons:************************\n");

		JSONObject PersonObject = null;
		//Iterating through ArrayObjects
		try 
		{
			String fileRead = JsonUtility.readFile(originbook+AddressBook.getBookName());
			PersonObject = (JSONObject) parser.parse(fileRead);

			System.out.println("     Available Uers:");
			System.out.println("=====================================================================");
			Set<?> s =  PersonObject.keySet(); 	//Using the HASHMAP property to list each object's KEY

			Iterator<?> i = s.iterator();
			do{
				String k = i.next().toString();
				System.out.println("\t"+k);

			}while(i.hasNext());

			System.out.println();
			System.out.print("You want To know More ?");
			System.out.println("Enter Person Name");
			String firstName = Utility.InputString();

			JSONArray arrayItems = new JSONArray();
			arrayItems.add(PersonObject.get(firstName));
			Iterator<?> iterator = arrayItems.iterator();

			System.out.println("\n["+firstName+"'s Address]\n");
			while (iterator.hasNext()) //Iterating thorugh JSONObjectso
			{
				JSONObject jsonObject = (JSONObject) iterator.next();
				String fname = (String) jsonObject.get("firstName");
				String lname = (String) jsonObject.get("lastName");
				long phNo = (long) jsonObject.get("phNo");
				JSONObject addr=(JSONObject) jsonObject.get("address");
				String city=(String) addr.get("city");
				
				String street = (String) addr.get("street");
				String state = (String) addr.get("state");
				long zip = (long)addr.get("pinCode");
				

				System.out.println("Name: " + (fname+" "+lname));
				System.out.println("Address: " + street + "\nCity: " + city + "\nState : " + state);
				System.out.println("Contact No: " + phNo);
				System.out.println("Pin Code: " + zip);
				System.out.println();
			}
			System.out.println("===============================================================================");
		}
		catch (Exception e) 
		{
			System.out.println("File Reading Error");
			e.printStackTrace();
		}
	}
	
	
	public  void deletePerson(String fileName) throws JSONException
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
				this.addNewPesonToJsonFile();
			}
			else
			{
				try {
					throw new AddressBookException("The Book is Empty");
				} catch (AddressBookException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
		@SuppressWarnings("unchecked")
		public void sortByName() 
		{		
			JSONObject personSort=null;
			
			String fileRead;
			try {
				fileRead = JsonUtility.readFile(originbook+AddressBook.getBookName());		
				personSort = (JSONObject) parser.parse(fileRead);
			}
			 catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Set<?> s =  personSort.keySet(); 	//Using the HASHMAP property to list each object's KEY
			List<String> temp=new ArrayList<String>();
			Iterator<?> i = s.iterator();
			do{
				String k = i.next().toString();
				temp.add(k);
			}while(i.hasNext());
			System.out.println("----------------------------persons in book-----------------------");
			List<String>sortedList=temp.stream().sorted().collect(Collectors.toList()); 
			sortedList.forEach(System.out::println);  
			System.out.println("--------------------full Sorted Details Of All Users-----------------");
			for(String list:sortedList)
			{
				JSONArray arrayItems = new JSONArray();
				arrayItems.add(personSort.get(list));
				Iterator<?> iterator = arrayItems.iterator();

				System.out.println("\n["+list+"'s Address]\n");
				while (iterator.hasNext()) //Iterating thorugh JSONObjectso
				{
					JSONObject jsonObject = (JSONObject) iterator.next();
					String fname = (String) jsonObject.get("firstName");
					String lname = (String) jsonObject.get("lastName");
					long phNo = (long) jsonObject.get("phNo");
					JSONObject addr=(JSONObject) jsonObject.get("address");
					String city=(String) addr.get("city");
					
					String street = (String) addr.get("street");
					String state = (String) addr.get("state");
					long zip = (long)addr.get("pinCode");
					

					System.out.println("Name: " + (fname+" "+lname));
					System.out.println("Address: " + street + "\nCity: " + city + "\nState : " + state);
					System.out.println("Contact No: " + phNo);
					System.out.println("Pin Code: " + zip);
					System.out.println();
				}
			}
			
		}
		
		
			
}
