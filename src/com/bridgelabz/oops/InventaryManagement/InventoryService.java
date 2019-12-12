package com.bridgelabz.oops.InventaryManagement;

import java.io.FileNotFoundException;
import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bridgelabz.oops.addressbook.AddressBook;
import com.bridgelabz.oops.addressbook.JsonUtility;
import com.bridgelabz.util.Utility;

/**
 * @author Rupeshp007
 * date:6/12/2019
 * @version 1.0
 * Purpose:Service for manage Inventory Program  
 * Operations:
 * 1.add inventory
 * 2.get price of value
 * 3.get total value of inventories 
 **********************************************************************************************************/

public class InventoryService extends InventoryManagerImplementation implements Inventory 
{
	
	//Initilization for InventoryService
	
	static String fileName="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/InventaryManagement/InventoryDetails.json";
	InventoryDetails details=new InventoryDetails();

	static JSONArray arrayObject=new JSONArray();	
	 JSONObject inventoryObject=new JSONObject();
	 
		
	
	@Override
	public void displayInventory() {
		String jsonobject="";
		try {
			jsonobject = JsonUtility.readFile(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(jsonobject);
	}
	

	@Override
	public void addInventory() 
	{
		String name="";
		double price=0,weight=0;
		System.out.println("Enter Name Of inventory");
		System.out.println("1.Rice 2.Pulse 3.Wheat 4.save");
		
		int input=Utility.InputInt();
		if(input>0 && input<4)
		{
		System.out.println("Enter Name");
		name=Utility.InputString();
		System.out.println("Enter the Price");
		 price=Utility.InputDouble();
		
		System.out.println("Enter the  Weight");
		 weight=Utility.InputDouble();
		details.setInventoryName(name);
		details.setInventoryprice(price);
		details.setInventoryweight(weight);
		}
		
		if(input==1)
					this.ConverJavaToJsonAll(details,"Rice" ,name,weight,price);
		else if(input==2)
					this.ConverJavaToJsonAll(details,"Pulse" ,name,weight,price);
		else if(input==3)
					this.ConverJavaToJsonAll(details,"Wheat" ,name,weight,price);
		else if(input==4)
		{
			//String jsonObject=inventoryObject.toJSONString();
			JsonUtility.writeToFile(fileName,inventoryObject);
		}
		else
		{
			System.out.println("Invalid input");
			inventary.addInventory();
		}
		
//		String string=JsonUtility.ConverJavaToJson(details);
		
		
	}

	@Override
	public void checkPrice() 
	{
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
		
	}
	
	@SuppressWarnings("unchecked")
	public  JSONArray ConverJavaToJsonAll(Object object,String input,String name,double weight,double price)
	{
		JSONObject inventoryrice=new JSONObject();
		 JSONObject inventorywheat=new JSONObject();
		 JSONObject inventorypulse=new JSONObject();
		 inventoryObject=JsonUtility.readFile2(fileName);
		
		if(input.equals("Rice"))
		{	
				
				inventoryrice.put("Name", name);
				inventoryrice.put("weight", new Double(weight));
				inventoryrice.put("Price", new Double(price));
				inventoryObject.put("Rice",inventoryrice);
				String jsonObject=inventoryObject.toJSONString();
				System.out.println(jsonObject+"SuccessFully Added.");
		}
		else if(input.equals("Wheat"))
		{

			inventorywheat.put("Name", name);
			inventorywheat.put("weight", new Double(weight));
			inventorywheat.put("Price", new Double(price));
			inventoryObject.put("Wheat",inventorywheat);
			String jsonObject=inventoryObject.toJSONString();
			System.out.println(jsonObject+"SuccessFully Added.");

			
		}
		else if(input.equals("Pulse"))
		{
			inventorypulse.put("name", name);
			inventorypulse.put("weight", new Double(weight));
			inventorypulse.put("Price", new Double(price));
			inventoryObject.put("Pulse",inventorypulse);
			String jsonObject=inventoryObject.toJSONString();
			System.out.println(jsonObject+"SuccessFully Added.");
		}
		else
		{
			System.out.println("Invalid Input please check speling");
			inventary.addInventory();
		}
		
		//System.out.println(arrayObject);
		return arrayObject;
		
		
	}
	
	
	

}
