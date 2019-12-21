package com.bridgelabz.oops.stockmanagement;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.bridgelabz.oops.addressbook.JsonUtility;
import com.bridgelabz.util.LinkedListStack;
import com.bridgelabz.util.LinkedListiml;
import com.bridgelabz.util.QueueLinkedList;
import com.bridgelabz.util.Utility;

public class StockAccountLinkedList2 
{
	JSONObject stockJson=new JSONObject();
	JSONObject stockListJson=new JSONObject();
	
	LinkedListiml<JSONObject> linkedlistStocklist=new LinkedListiml<>();
	LinkedListStack<JSONObject> stackBuyList=new LinkedListStack<>();
	LinkedListStack<JSONObject> stacksellList=new LinkedListStack<>();
	QueueLinkedList<String> queuetime=new QueueLinkedList<String>();


	String stockList="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/stockmanagement/LinkedListStockList.json";
	String buyList="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/stockmanagement/stackBuy.json";
	String sellList="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/stockmanagement/StacksellList.json";


	
    StockDetails stock;
	JSONObject temp=new JSONObject();
	@SuppressWarnings("unchecked")
	public  void addStock()
	{
		JSONParser parser=new JSONParser();
	
		
		//Iterating through ArrayObjects
		try {
			
			if(JsonUtility.readFile2(stockList)!=null)
			{
			   String fileRead = JsonUtility.readFile(stockList);
			
				temp = (JSONObject) parser.parse(fileRead);
			
			Set<JSONObject> s =  temp.keySet();	//Using the HASHMAP property to list each object's KEY
			
			
			Iterator<?> i = s.iterator();
			ArrayList<String> names=new ArrayList<>();
			do{
				names.add(i.next().toString());
			}while(i.hasNext());
				
			for(String name:names)
			{
				JSONObject object=(JSONObject) temp.get(name);
				System.out.println(object.toJSONString());
				linkedlistStocklist.add(object);
			}
			}
			} catch (ParseException  | FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		stock=new StockDetails();
		
		System.out.println("Enter the Name Of stock:");
		String stockName=Utility.InputString();
		stockJson.put("Stock Name", stockName);
		
		System.out.println("Enter the Value of stock");
		int value=Utility.InputInt();
		stockJson.put("Stock Value", Integer.toString(value));
		
		System.out.println("Enter the Number of stocks?");
		int quantity=Utility.InputInt();
		stockJson.put("Units", Integer.toString(quantity));
		temp.put(stockName, stockJson);
		linkedlistStocklist.add(temp);
		
		JsonUtility.writeToFile(stockList, temp);	
		System.out.println(stockName+"Added Successfully");
	}
	@SuppressWarnings("unchecked")
	public void removeLinkedList()
	{
		JSONParser parser=new JSONParser();
		System.out.println("Enter StockName:");
		String stockname=Utility.InputString();
		JSONObject mainobject=new  JSONObject();
		
		try{
			if(JsonUtility.readFile2(stockList)!=null)
			{
			   String fileRead = JsonUtility.readFile(stockList);
			
				temp = (JSONObject) parser.parse(fileRead);
			
			Set<JSONObject> s =  temp.keySet();	//Using the HASHMAP property to list each object's KEY
			
			
			Iterator<?> i = s.iterator();
			ArrayList<String> names=new ArrayList<>();
			do{
				names.add(i.next().toString());
			}while(i.hasNext());
				
			for(String name:names)
			{
				JSONObject object=new JSONObject();
				object=(JSONObject) temp.get(name);
				System.out.println(object.toJSONString());
				
				if(!object.get("Stock Name").equals(stockname))
				{
					linkedlistStocklist.add(object);
					mainobject.put(name, object);
				}
				else
					linkedlistStocklist.removeNode(object);
					System.out.println("Removed Sucssefully");
			}
			}
			} catch (ParseException  | FileNotFoundException e) {
			}
		JsonUtility.writeToFile(stockList, mainobject);	
	}
	
	@SuppressWarnings("unchecked")
	public void buyStock()
	{
		JSONObject temp=new JSONObject();
		JSONObject temp2=new JSONObject();
		JSONObject mainobject=new JSONObject();
		
		if(JsonUtility.readFile2(buyList)!=null)
		{
		   temp = JsonUtility.readFile2(buyList);
		}
		if(JsonUtility.readFile2(stockList)!=null)
		{
		   temp2 = JsonUtility.readFile2(stockList);
		}
		BuyerDetails buyer=new BuyerDetails();
		System.out.println("Enter Your Name:");
		String name=Utility.InputString();
		mainobject.put("Name",name);
		
		System.out.println("Enter Stock name :");
		String companyName=Utility.InputString();
		buyer.setCompanyName(companyName);
		mainobject.put("Stock Name", companyName);
		System.out.println("Enter How many Stocks want to buy");
		int unit=Utility.InputInt();
		buyer.setUnit(unit);
		mainobject.put("Unit", unit);
		
		
		JSONObject read=(JSONObject) temp2.get(companyName);
		int value=Integer.parseInt((String) read.get("Stock Value"));
		mainobject.put("Value", value);//
		int unit2=Integer.parseInt((String) read.get("Units"));
		unit2=unit2-unit;
		value=unit*value;
		read.replace("Units", Integer.toString(unit2));
		temp2.put(companyName, read);
		
		mainobject.put("Total Value", value);
		mainobject.put("Status","Stock Purchased");
		mainobject.put("Transaction Time", java.time.LocalDateTime.now().toString());
		String time=java.time.LocalDateTime.now().toString();
		temp.put(name,mainobject);
		
		stackBuyList.push(temp); //Pushed JsonObject into Stack
		queuetime.enQueue(time);
		JsonUtility.writeToFile(buyList, temp);	
		JsonUtility.writeToFile(stockList, temp2);	

	}
	
	@SuppressWarnings("unchecked")
	public void SellStock()
	{
		JSONObject temp=new JSONObject();
		JSONObject temp2=new JSONObject();
		JSONObject temp3=new JSONObject();
		JSONObject mainobject=new JSONObject();
		
		if(JsonUtility.readFile2(sellList)!=null)
		{
		   temp = JsonUtility.readFile2(sellList);
		}
		if(JsonUtility.readFile2(buyList)!=null)
		{
		   temp2 = JsonUtility.readFile2(buyList);
		}
		if(JsonUtility.readFile2(stockList)!=null)
		{
		   temp3 = JsonUtility.readFile2(stockList);
		}
		System.out.println("Enter Your Name:");
		String name=Utility.InputString();
		mainobject.put("Name",name);
		
		System.out.println("Enter Stock name :");
		String companyName=Utility.InputString();
		mainobject.put("Stock Name", companyName);
		System.out.println("Enter How many Stocks want to Sell");
		int unit=Utility.InputInt();
		mainobject.put("Unit", companyName);
		
		Set<JSONObject> set=temp2.keySet();
		Iterator<?> i=set.iterator();
		ArrayList<String> names=new ArrayList<>();
		do{
			
			names.add(i.next().toString());
		}while(i.hasNext());
		
		
		for(String string:names)
		{
			
		
			JSONObject read=(JSONObject) temp2.get(name);
			JSONObject read2=(JSONObject) temp3.get(name);
			if(read.get("Stock Name").equals(name))
			{
			int value=Integer.parseInt((String) read.get("Value"));
			mainobject.put("Value", value);//
			int unit2=Integer.parseInt((String) read.get("Units"));
			unit2=unit2-unit;
			value=unit*value;
			read2.replace("Units", unit);
			temp3.put(companyName, read);
			mainobject.put("Total Value", value);
			mainobject.put("Status","Stock Sold:");
			String time=java.time.LocalDateTime.now().toString();
			mainobject.put("Transaction Time", time);
			temp.put(name,mainobject);
			
			queuetime.enQueue(time);
			stacksellList.push(temp); //Pushed JsonObject into Stack
			}
			
			JsonUtility.writeToFile(sellList, temp);	
			JsonUtility.writeToFile(stockList, temp3);	
		}
	}
	
	public static void mainMenu()
	{
		StockAccountLinkedList2 stocks=new StockAccountLinkedList2();
		while(true)
		{
			System.out.println("1. add  2. remove  3.buy  4.sell   5.display 6.Print Report 7.exit");
			int choice=Utility.InputInt();
			switch(choice)
			{
			
			case 1:
					stocks.addStock();
					break;
			case 2:
					stocks.removeLinkedList();
					break;
			case 3:
					stocks.buyStock();
					break;
			case 4:
					stocks.SellStock();
					break;
			case 5:
					//stocks.compnyList();
					break;
			case 6:
					//stocks.printReport();
					
			case 7:
					System.exit(0);;
			}
		}
	}
	
	public static void main(String[] args) 
	{
		mainMenu();
	}
		
}
