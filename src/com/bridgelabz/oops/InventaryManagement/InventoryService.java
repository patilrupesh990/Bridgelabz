package com.bridgelabz.oops.InventaryManagement;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
	static String fileName="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/InventaryManagement/InventoryDetails.json";
	static HashMap<String, InventoryDetails> invetorymap=new HashMap<String, InventoryDetails>();
	InventoryDetails details=new InventoryDetails();
	static JSONArray arrayObject=new JSONArray();
	
	static JSONObject inventoryObject=new JSONObject();
	static JSONObject inventoryrice=new JSONObject();
	static JSONObject inventorywheat=new JSONObject();
	static JSONObject inventorypulse=new JSONObject();



	
	public static Inventory inventary=new InventoryService();
	

	public static void mainMenu()
	{
		int choice=0;
		while(true){
		System.out.println("1.Display File  2.Add Inventory 3.check price 4.Total values of Inventory 5 exit");
		try{
		choice=Utility.InputInt();
		}catch (NumberFormatException e) 
		{
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
			case 4:	
						System.out.println("1.Rice  2.Wheat 3.Pulses");
						int input=Utility.InputInt();
						InventoryManagerImplementation inventoryManager=new InventoryManagerImplementation();

						switch(input)
						{
							case 1:
								
									inventoryManager.totalValue("rice");
									break;
							case 2:
								
								inventoryManager.totalValue("wheat");
								break;
							case 3:
								
									inventoryManager.totalValue("pulses");
									break;
							default:
								
									System.out.println("Invalid Choice");
									mainMenu();		
						}
						break;
			case 5:
						System.exit(0);
			default :
						System.out.println("invalid choice");
		}
		}

	}

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
		InventoryService.ConverJavaToJsonArray(details,"Rice" ,name,weight,price);
		else if(input==2)
			InventoryService.ConverJavaToJsonArray(details,"Pulse" ,name,weight,price);
		else if(input==3)
			InventoryService.ConverJavaToJsonArray(details,"Wheat" ,name,weight,price);
		else if(input==4)
		{
			String jsonObject=inventoryObject.toJSONString();
			JsonUtility.WriteinFile(jsonObject, fileName);
		}
		else
		{
			System.out.println("Invalid input");
			inventary.addInventory();
		}
		
//		String string=JsonUtility.ConverJavaToJson(details);
		invetorymap.put(name, details);
		
		
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
		
		
		System.out.println("in java object:");
	
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		invetorymap.forEach((p,q)->
		{
			InventoryDetails inventory=(InventoryDetails)q;
			
			System.out.println("Name:"+inventory.getInventoryName());
			System.out.println("Price:"+inventory.getInventoryprice());
		});
	}
	
	@SuppressWarnings("unchecked")
	public static JSONArray ConverJavaToJsonArray(Object object,String input,String name,double weight,double price)
	{
		
		
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
