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
import com.bridgelabz.util.Utility;

public class StockAccountLinkedList2 
{
	JSONObject stockJson=new JSONObject();
	JSONObject stockListJson=new JSONObject();
	
	LinkedListiml<JSONObject> Stocklist=new LinkedListiml<>();
	LinkedListStack<JSONObject> buylist=new LinkedListStack<>();
	String stockList="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/stockmanagement/LinkedListStockList.json";

	
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
				Stocklist.add(object);
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
		stockJson.put("Stock Value", value);
		
		System.out.println("Enter the Number of stocks?");
		int quantity=Utility.InputInt();
		stockJson.put("Units", quantity);
		temp.put(stockName, stockJson);
		Stocklist.add(temp);
		
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
					Stocklist.add(object);
					mainobject.put(name, object);
				}
				else
					Stocklist.removeNode(object);
					System.out.println("Removed Sucssefully");
			}
			}
			} catch (ParseException  | FileNotFoundException e) {
			}
		JsonUtility.writeToFile(stockList, mainobject);	
	}
	
	public void buyStock()
	{
		JSONObject temp=new JSONObject();
		JSONObject mainobject=new JSONObject();
		if(JsonUtility.readFile2(stockList)!=null)
		{
		   temp = JsonUtility.readFile2(stockList);
		
		}
		BuyerDetails buyer=new BuyerDetails();
		System.out.println("Enter Your Name:");
		String name=Utility.InputString();
		buyer.setBuyerName(name);
	//	mainobject.put("Name",);
		
		System.out.println("Enter Company name :");
		String companyName=Utility.InputString();
		buyer.setCompanyName(companyName);
		
		System.out.println("Enter How many Stocks want to buy");
		int unit=Utility.InputInt();
		buyer.setUnit(unit);
				
		buyer.setStatus("Purchased");
		
		StockDetails stocks[]=Stocklist.GetListObject();
		for(StockDetails object:stocks)
		{
			System.out.println("dfd");
			if(object.getStockName().equals(companyName))
			{
				System.out.println("abc");
				int value=object.getStockValue();
				buyer.setStockValue(value);
				int amount=value*unit;
				buyer.setTotalValue(amount);
				int buyUnit=buyer.getUnit();
				int availableunit=object.getStockQuantity();
				System.out.println("jsj");
				if(availableunit<=0)
				{
					try {
						throw new StockMngmtExcpetion("There is No available stocks for Company"+buyer.getCompanyName());
					} catch (StockMngmtExcpetion e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					mainMenu();
				}
				int result=availableunit-buyUnit;
				object.setStockQuantity(result);
//				Stocklist.removeNode(object);
//				Stocklist.add(object);
//				BuyerDetails.add(buyer);
				System.out.println("SuccessFully You have Purchased"+buyer.getCompanyName()+"  Stocks");
			}
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
					//stocks.buyStock();
					break;
			case 4:
					//stocks.SellStock();
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
