package com.bridgelabz.oops.InventaryManagement;

import java.awt.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import com.bridgelabz.oops.addressbook.JsonUtility;
import com.bridgelabz.util.Utility;

public class InventoryJSON extends InventoryFuctionality implements Inventory 
{
	String fileName="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/InventaryManagement/InventoryDetails.json";
	static HashMap<String, InventoryDetails> invetorymap=new HashMap<String, InventoryDetails>();
	InventoryDetails details=new InventoryDetails();
	
	public static Inventory inventary=new InventoryJSON();

	
	public static void mainMenu()
	{
		int choice=0;
		System.out.println("1.Display File  2.Add Inventory 3.check price 4.Change StockDetails");
		try{
		choice=Utility.InputInt();
		}catch (NumberFormatException e) 
		{
			// TODO: handle exception
			System.out.println("invalid input");
		}
		
		switch(choice)
		{
			case 1:
						inventary.displayInventory();
						break;
			case 2:
						inventary.addInventory();
						break;
			case 3:
						inventary.checkPrice();
						break;
			default :
						System.out.println("invalid choice");
		}

	}

	@Override
	public void displayInventory() {
		// TODO Auto-generated method stub
		String jsonobject="";
		try {
			jsonobject = JsonUtility.readFile(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(jsonobject);
		
		
	}

	@Override
	public void addInventory() 
	{
		
		System.out.println("Enter Name Of Rice inventory Name");
		System.out.println("1.Rice 2.Pulse 3.Wheat");
		String name=Utility.InputString();
		System.out.println("Enter the Price");
		double price=Utility.InputDouble();
		System.out.println("Enter the  Weight");
		double weight=Utility.InputDouble();
		details.setInventoryName(name);
		details.setInventoryprice(price);
		details.setInventoryweight(weight);
		
		String string=JsonUtility.ConverJavaToJson(details);
		JsonUtility.WriteinFile(string, fileName);
		invetorymap.put(name, details);
		
		
	}

	@Override
	public void checkPrice() 
	{
		// TODO Auto-generated method stub
		System.out.println("Price of All inventory");
		System.out.println();
		System.out.println("In json Object");
		String jsonobject="";
		try {
			jsonobject = JsonUtility.readFile(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(jsonobject);
		System.out.println("in java object:");
		ArrayList<InventoryDetails> javaobject=InventoryJSON.converJsonToJava(jsonobject, InventoryDetails.class);
		
			for(InventoryDetails temp:javaobject)
			{
				System.out.println("Name"+temp.getInventoryName());
				System.out.println("Price"+temp.getInventoryprice());
			}
			System.out.println("------------------------------------------------------------------------------------------------------------------------");
		invetorymap.forEach((p,q)->
		{
			InventoryDetails inventory=(InventoryDetails)q;
			
			System.out.println("Name:"+inventory.getInventoryName());
			System.out.println("Price:"+inventory.getInventoryprice());
		});
	}
	
	
	
	
	public static <T, cls>ArrayList<InventoryDetails> converJsonToJava(String jsonstring,Class<T> cls)
	{
		
		//-String result=null;
		ArrayList<cls> list = new ArrayList<cls>();
		try {
			//-result=mapper.readValue(jsonstring, cls);
			

			//			String jsonArray = "[{\"brand\":\"ford\"}, {\"brand\":\"Fiat\"}]";
//
			ObjectMapper objectMapper = new ObjectMapper();
			 list= objectMapper.readValue(jsonstring, new TypeReference<List>(){});
			

		} 
		catch (JsonParseException e) {
			System.out.println("Exceptionoccured while converting JSON object to java object");
		}
		catch (JsonMappingException e) {
			System.out.println("Exceptionoccured while converting JSON object to java object");
		}
		catch (IOException e) {
			System.out.println("Exceptionoccured while converting JSON object to java object");
		}
		return (ArrayList<InventoryDetails>) list;
		
	}
	
	
	
	
	
	
	
	
}
