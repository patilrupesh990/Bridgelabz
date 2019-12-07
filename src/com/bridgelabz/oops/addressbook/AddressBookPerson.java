package com.bridgelabz.oops.addressbook;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.util.Utility;

public class AddressBookPerson 
{
	static List<PersonDetails> personDetails=new ArrayList<PersonDetails>();
	static List<AddressDetails> addressDetails=new ArrayList<AddressDetails>();
	static HashMap<String, PersonDetails> personMap=new HashMap<>();
	static HashMap<String,AddressDetails> addressMap=new HashMap<>();
	static JSONObject personjson=new JSONObject();
	static JSONObject personaddressjson=new JSONObject();
	static JSONObject personList=new JSONObject();
	
	static PersonDetails person=null;
	static String originbook="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/jsonfiles/";

	
	public static void addNewPeson(String filename)
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
			// TODO: handle exception
			System.out.println("Digits not allowed");
		}
		personDetails.add(person);
		AddressBookPerson.addNewPesonToJsonFile();
		
				
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
	
	@SuppressWarnings("unchecked")
	public static void addNewPesonToJsonFile()
	{
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
		personList.put("Person",personjson);
	
	}
	public static void Save()
	{
		System.out.println(AddressBook.getBookName());
		System.out.println("hello");
		String temporary=personList.toJSONString();
		System.out.println(temporary);
		JsonUtility.WriteinFile(temporary, originbook+AddressBook.getBookName());
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
				AddressBookPerson.addNewPesonToJsonFile();
			}
			else
			{
				System.out.println("The Book is Empty");
			}
		}
	}
	
	public static void addToMap()
	{
		Object obj = null;
		try {
			obj = new JSONParser().parse(new FileReader(originbook+AddressBook.getBookName()));
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} 
          
        // typecasting obj to JSONObject 
        JSONObject jo = (JSONObject) obj; 
        // getting address 
        Map person = ((Map)jo.get("Person")); 
        PersonDetails persondetail=null;
        AddressDetails addressdetail=null;
        Iterator<Map.Entry> itr1 = person.entrySet().iterator(); 
        while (itr1.hasNext()) { 
            Map.Entry pair = itr1.next(); 
            if(pair.getKey().equals("firstName"))
            	persondetail.setFirstName((String)pair.getValue());
            if(pair.getKey().equals("lastName"))
            	System.out.println("LastName:"+(String)pair.getValue());	
            if(pair.getKey().equals("phNo:"))
            	System.out.println("phNo:"+(String)pair.getValue());	
        }
        
       
        
      
	        // getting address 
	        Map address = (Map) ((Map)jo.get("Person")).get("address"); 
	        
	        Iterator<Map.Entry> itr2 = address.entrySet().iterator(); 
	        while (itr2.hasNext()) { 
            Map.Entry pair2 = itr2.next(); 
        if(pair2.getKey().equals("street"))
        	System.out.println("street:"+(String)pair2.getValue());
        if(pair2.getKey().equals("city"))
        	System.out.println("city:"+(String)pair2.getValue());
        if(pair2.getKey().equals("state"))
        	System.out.println("state:"+(String)pair2.getValue());
        if(pair2.getKey().equals("pinCode"))
        	System.out.println("pinCode:"+(Long)pair2.getValue());
    } 
	}

	
	public static void printEntries() 
	{
		
		  Object obj = null;
			try {
				obj = new JSONParser().parse(new FileReader(originbook+AddressBook.getBookName()));
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			} 
	          
	        // typecasting obj to JSONObject 
	        JSONObject jo = (JSONObject) obj; 
	        // getting address 
	        Map person = ((Map)jo.get("Person")); 
	        
	        Iterator<Map.Entry> itr1 = person.entrySet().iterator(); 
	        while (itr1.hasNext()) { 
	            Map.Entry pair = itr1.next(); 
	            if(pair.getKey().equals("firstName"))
	            	System.out.println("FirstName:"+(String)pair.getValue());
	            if(pair.getKey().equals("lastName"))
	            	System.out.println("LastName:"+(String)pair.getValue());	
	            if(pair.getKey().equals("phNo:"))
	            	System.out.println("phNo:"+(String)pair.getValue());	
	        }
	        
	       
	        
	      
  	        // getting address 
  	        Map address = (Map) ((Map)jo.get("Person")).get("address"); 
  	        
  	        Iterator<Map.Entry> itr2 = address.entrySet().iterator(); 
  	        while (itr2.hasNext()) { 
	            Map.Entry pair2 = itr2.next(); 
            if(pair2.getKey().equals("street"))
            	System.out.println("street:"+(String)pair2.getValue());
            if(pair2.getKey().equals("city"))
            	System.out.println("city:"+(String)pair2.getValue());
            if(pair2.getKey().equals("state"))
            	System.out.println("state:"+(String)pair2.getValue());
            if(pair2.getKey().equals("pinCode"))
            	System.out.println("pinCode:"+(Long)pair2.getValue());
        } 
  	        System.out.println("================================================================================================================");
	        
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
