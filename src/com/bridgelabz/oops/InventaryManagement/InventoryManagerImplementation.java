package com.bridgelabz.oops.InventaryManagement;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Rupeshp007
 * date:8/12/2019
 * @version 1.0
 * Purpose:InventoryManager to manage the inventory. The Inventory Manager will use InventoryFactory 
 * to create Inventory Object from JSON.The InventoryManager will call each Inventory Object in its 
 * list to calculate the Inventory Price and then call  Inventory Object to return the JSON String.
 **********************************************************************************************************/

public class InventoryManagerImplementation extends InventoryManager{
	
	static String fileName="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/InventaryManagement/InventoryDetails.json";
	
	/*********************************************************************************
	 * Override Method From Inventory to Count Total Value For Rice,Wheat and Pulse
	 * like this different Inventory.
	 *  @param String Name of Inventroy
	 *  @return void
	 *  
	 *  	logic:weight of Inventory * Price Of Inventory per Kg.
	 *******************************************************************************/	
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void totalValue(String name) {
		if(name.equals("rice"))
			{
				 // parsing file "JSONExample.json" 
		        Object obj = null;
				try {
					obj = new JSONParser().parse(new FileReader(fileName));
				} catch (IOException | ParseException e) {
					e.printStackTrace();
				} 
		          
		        // typecasting obj to JSONObject 
		        JSONObject jo = (JSONObject) obj; 
		         
		        // getting address 
		        Map rice = ((Map)jo.get("Rice")); 
		          
		        // iterating address Map
		        double price=0;
		        double weight=0;
		        String inventoryname="";
		        Iterator<Map.Entry> itr1 = rice.entrySet().iterator(); 
		        while (itr1.hasNext()) { 
		            Map.Entry pair = itr1.next(); 
		            if(pair.getKey().equals("Name"))
		            {
		            	inventoryname=(String) pair.getValue();
		            }
		            if(pair.getKey().equals("Price"))
		            {
		            	price=(double) pair.getValue();
		            }
		            if(pair.getKey().equals("weight"))
		            {
		            	weight=(double) pair.getValue();
		
		            }
			      
		        } 
	            double total=price*weight;
		        System.out.println("Name of Rice /kg-->"+inventoryname);
		        System.out.println("Price of Rice /kg-->"+price);
		        System.out.println("weight of Rice is-->"+weight+"kg");
		        System.out.println("Total Value of Rice is-->"+total); 
		        System.out.println("--------------------");
			}
			else if(name.equals("wheat"))
			{
				 Object obj = null;
					try {
						obj = new JSONParser().parse(new FileReader(fileName));
					} catch (IOException | ParseException e) {
						e.printStackTrace();
					} 
			          
			        // typecasting obj to JSONObject 
			        JSONObject jo = (JSONObject) obj; 
			         
			        // getting address 
			        Map wheat = ((Map)jo.get("Wheat")); 
			          
			        // iterating address Map
			        double price=0;
			        double weight=0;
			        String inventoryname="";
					Iterator<Map.Entry> itr1 = wheat.entrySet().iterator(); 
			        while (itr1.hasNext()) { 
			            Map.Entry pair = itr1.next(); 
			            if(pair.getKey().equals("Name"))
			            {
			            	inventoryname=(String) pair.getValue();
			            }
			            if(pair.getKey().equals("Price"))
			            {
			            	price=(double) pair.getValue();
			            }
			            if(pair.getKey().equals("weight"))
			            {
			            	weight=(double) pair.getValue();
			            }
			        } 		
		            double total=price*weight;
			        System.out.println("Name of Rice /kg-->"+inventoryname);
		            System.out.println("Price of Wheat /kg-->"+price);
		            System.out.println("weight of Wheat is-->"+weight+"kg");
		            System.out.println("Total Value of Wheat is-->"+total); 
		
			}
			
			else if(name.equals("Pulse"))
			{
				 Object obj = null;
					try {
						obj = new JSONParser().parse(new FileReader(fileName));
					} catch (IOException | ParseException e) {
						e.printStackTrace();
					} 
			          
			        // typecasting obj to JSONObject 
			        JSONObject jo = (JSONObject) obj; 
			         
			        // getting address 
			        Map pulse = ((Map)jo.get("Pulse")); 
			          
			        // iterating address Map
			        double price=0;
			        double weight=0;
			        String inventoryname="";
					Iterator<Map.Entry> itr1 = pulse.entrySet().iterator(); 
			        while (itr1.hasNext()) { 
			            Map.Entry pair = itr1.next(); 
			            if(pair.getKey().equals("Name"))
			            {
			            	inventoryname=(String) pair.getValue();
			            }
			            if(pair.getKey().equals("price"))
			            {
			            	price=(double) pair.getValue();
			            }
			            if(pair.getKey().equals("weight"))
			            {
			            	weight=(double) pair.getValue();
			            }
			           
			        } 		
			        double total=price*weight;
			        System.out.println("Name of Rice /kg-->"+inventoryname);
		            System.out.println("Price of Pulse /kg-->"+price);
		            System.out.println("weight of Pulse is-->"+weight+"kg");
		            System.out.println("Total Value of Pulse is-->"+total);
			}
			else
			{
				System.out.println("Invalid choice");
			}

	}
	
	

}
