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

/***********************************************************************************************************
 * @author Rupesh Patil
 * date:13/12/2019
 * @version 1.0
 * 
 * Purpose:it contains Person Details related operations in AddressBook management project it contains
 * 
 * - AddNewPerson in Current Open File
 * - delete Person From file
 * - AddressDetails
 * - save file
 * - read& write in json file
 * 
 **********************************************************************************************************/

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

	/*********************************************************************************
	 * To add New Person In current File it will take details and put data in .json file 
	 *  
	 *  @param String FileName
	 *  @return void
	 *  @exception JSONException
	 *******************************************************************************/	

	
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
	
	/*********************************************************************************
	 * It will take Address details from user and add in addressDetails Object
	 * 
	 *  @param no parameter
	 *  @return void
	 *******************************************************************************/	

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
	
	/*********************************************************************************
	 * To Store the details of Person and address in current .json File .
	 * 
	 *  @param no parameter
	 *  @return void
	 *  @exception JSONException
	 *******************************************************************************/	

	
	@SuppressWarnings("unchecked")
	public  void addNewPesonToJsonFile() throws JSONException
	{
		JSONObject personjson=new JSONObject();
		mainobject=JsonUtility.readFile2(originbook+AddressBookimplementation.getBookName());
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
	
	
	/*********************************************************************************
	 * To Save the changes  made in current .json file Opened.
	 * 
	 *  @param no parameter
	 *  @return void
	 *******************************************************************************/	

	public  void Save() 
	{
		//System.out.println(AddressBook.getBookName());
		//System.out.println("hello");
		
        File file = new File(AddressBookimplementation.getBookName());
        System.out.println(AddressBookimplementation.getBookName());
        System.out.println(file.length());
		
			String temporary=mainobject.toString();
			System.out.println(temporary);
		JsonUtility.writeToFile(originbook+AddressBookimplementation.getBookName(), mainobject);	
	}
	
	
	/*****************************************************************************************
	 *  purpose:It will Read the details from .json file and give the list of all user.After 
	 *          that from given list user can input the person name from list and it will print
	 *          all full details of person like......
	 * 			
	 * 			-Name
	 *  		-Contact
	 *  		-Address
	 *  
	 *  @param no parameter
	 *  @return void
	 *******************************************************************************/	

	@SuppressWarnings("unchecked")
	public void readFromJSON()
	{
		System.out.println("\n************************Details of Persons:************************\n");

		JSONObject PersonObject = null;
		//Iterating through ArrayObjects
		try 
		{
			String fileRead = JsonUtility.readFile(originbook+AddressBookimplementation.getBookName());
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
	
	/*********************************************************************************
	 * 	Purpose: It will Take Persons FisrtName and LastName as input from user and FileName as arguments and
	 *  based on details it will remove person details from json file.
	 *  
	 *  @param String FileName
	 *  @return void
	 *  @exception JSONException
	 *******************************************************************************/	

	
	@SuppressWarnings("unchecked")
	public  void deletePerson() throws JSONException
	{
		
		 JSONObject personSort = null;
			
			String fileRead = null;
			try {
					if(JsonUtility.readFile(originbook+AddressBookimplementation.getBookName())!=null)
					{
							fileRead = JsonUtility.readFile(originbook+AddressBookimplementation.getBookName());
					}
					personSort = (JSONObject) parser.parse(fileRead);			
				}
			 catch (ParseException e) {
				e.printStackTrace();
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			personSort.keySet().forEach(key -> System.out.println(key));
			System.out.println("Enter the Persons Name whom want to delete:");
			String name=Utility.InputString();
			if(personSort.containsKey(name))
			{
				personSort.remove(name);
				System.out.println("Removed Successfully");
			}
			else
			{
				try {
					throw new AddressBookException("No Person Found");
				} catch (AddressBookException e) {
				}
			}
			JsonUtility.writeToFile(originbook+AddressBookimplementation.getBookName(), personSort);	

		}
	
	/*********************************************************************************
	 * 	Purpose: It will Take Persons FisrtName and LastName as input from user and FileName as arguments and
	 *  based on details it will Change person details from json file.
	 *  
	 *  @param String FileName
	 *  @return void
	 *  @exception JSONException
	 *******************************************************************************/	
	@SuppressWarnings("unchecked")
	public  void editPerson() throws JSONException
	{
		
		 JSONObject personSort = new JSONObject();
			
			String fileRead = null;
			try {
					if(JsonUtility.readFile(originbook+AddressBookimplementation.getBookName())!=null)
					{
							fileRead = JsonUtility.readFile(originbook+AddressBookimplementation.getBookName());
					}
					personSort = (JSONObject) parser.parse(fileRead);			
				}
			 catch (ParseException e) {
				e.printStackTrace();
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			personSort.keySet().forEach(key -> System.out.println(key));
			System.out.println("Enter the Persons Name who's Details you want change");
			String name=Utility.InputString();
			System.out.println("1. Name 2.lastname 3.Address 4.PhoneNumber");
			System.out.println("Enter Your Choice:");
			int choice=Utility.InputInt();
			if(personSort.containsKey(name))
			{
					switch(choice)
					{
					case 1:
							JSONObject person=(JSONObject) personSort.get(name);
							System.out.println("Enter New First");
							String newName=Utility.InputString();
							System.out.println(personSort.toJSONString());
							person.replace("firstName",newName);
							personSort.replace(name, person);
							System.out.println("Succesusfully changed your First Name");
							break;
					case 2:
							JSONObject person2=(JSONObject) personSort.get(name);
							System.out.println("Enter New LastName");
							String lastName=Utility.InputString();
							person2.replace("lastName",lastName);
							personSort.replace(name, person2);
							System.out.println("Succesusfully changed your Last Name");
							break;
					case 3:
							System.out.println("Enter New Address");
							JSONObject temp=(JSONObject) personSort.get(name);
							JSONObject address=(JSONObject) temp.get("address");
							System.out.println(address.toJSONString());
							System.out.println("Enter street");
							String street=Utility.InputString();
							address.replace("street", street);
							
							System.out.println("Enter city");
							String city=Utility.InputString();
							address.replace("city", city);
							
							System.out.println("Enter state");
							String state=Utility.InputString();
							address.replace("state", state);
							System.out.println("Enter pincode");
							String pincode=Utility.InputString();
							address.put("pinCode", pincode);
							personSort.replace("address", address);
							System.out.println("Succesusfully changed your Adddress");
							break;
					case 4:
							JSONObject person3=(JSONObject) personSort.get(name);
							System.out.println("Enter New LastName");
							String ph=Utility.InputString();
							person3.replace("address",ph);
							personSort.replace(name, person3);
							System.out.println("Succesusfully changed your Last Name");
							
						default :
						
					}
			
			}
			else
			{
				try {
					throw new AddressBookException("No Person Found");
				} catch (AddressBookException e) {
				}
			}
			JsonUtility.writeToFile(originbook+AddressBookimplementation.getBookName(), personSort);	

		}
	
	
	
	
			
	/*********************************************************************************
	 * 	Purpose: It will Take Persons FisrtName and LastName as input from user and FileName as arguments and
	 *  based on details it will Search person details from json file.
	 *  
	 *******************************************************************************/		
	
	
	@SuppressWarnings("unchecked")
	public void SearchPerson()
	{
		JSONObject PersonObject = null;
		//Iterating through ArrayObjects
		try 
		{
			String fileRead = JsonUtility.readFile(originbook+AddressBookimplementation.getBookName());
			PersonObject = (JSONObject) parser.parse(fileRead);

			System.out.println();
			System.out.println("Enter Person Name to Search");
			String firstName = Utility.InputString();
			System.out.println("=============================="+firstName+"'s Details============================");
			JSONArray arrayItems = new JSONArray();
			arrayItems.add(PersonObject.get(firstName));
			Iterator<?> iterator = arrayItems.iterator();

			try{
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
			}catch (NullPointerException e) {
				try {
					throw new AddressBookException("data is Not available for"+firstName);
				} catch (AddressBookException e1) {
					System.out.println("Data is Not  Available for "+firstName);
				}
			}
			System.out.println("===============================================================================");
		}
		catch (Exception e) 
		{
			System.out.println("File Reading Error");
			e.printStackTrace();
		}
	}
	
	/*********************************************************************************
	 * To Sort the Details of Person and print the Details..
	 * 
	 *  @param no parameter
	 *  @return void
	 *******************************************************************************/	

	
		@SuppressWarnings("unchecked")
		public void sortByName() 
		{		
			JSONObject personSort=null;
			
			String fileRead;
			try {
				fileRead = JsonUtility.readFile(originbook+AddressBookimplementation.getBookName());		
				personSort = (JSONObject) parser.parse(fileRead);
			}
			 catch (ParseException e) {
				e.printStackTrace();
			}
			catch (FileNotFoundException e) {
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
		
		@SuppressWarnings("unchecked")
		public void sortByPinCode()
		{
				JSONObject personSort=null;
			
			String fileRead;
			try {
				fileRead = JsonUtility.readFile(originbook+AddressBookimplementation.getBookName());		
				personSort = (JSONObject) parser.parse(fileRead);
			}
			 catch (ParseException e) {
				e.printStackTrace();
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			Set<?> s =  personSort.keySet(); 	//Using the HASHMAP property to list each object's KEY
			List<String> temp=new ArrayList<String>();
			Iterator<?> i = s.iterator();
			do{
				String k = i.next().toString();
				temp.add(k);
			}while(i.hasNext());
			List<String>sortedList=temp.stream().sorted().collect(Collectors.toList()); 
			List<Long> temp2=new ArrayList<>();

			for(String list:sortedList)
			{
				JSONArray arrayItems = new JSONArray();
				arrayItems.add(personSort.get(list));
				Iterator<?> iterator = arrayItems.iterator();

				while (iterator.hasNext()) //Iterating thorugh JSONObjectso
				{
					JSONObject jsonObject = (JSONObject) iterator.next();
					
					JSONObject addr=(JSONObject) jsonObject.get("address");
					
					temp2.add((long)addr.get("pinCode"));
				}
			}
			List<Long>sortedZipList=temp2.stream().sorted().collect(Collectors.toList()); 
			for(Long list:sortedZipList)
			{
				
				JSONArray arrayItems = new JSONArray();
				arrayItems.add(personSort.get(list));
				Iterator<?> iterator = arrayItems.iterator();

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
