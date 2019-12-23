	package com.bridgelabz.oops.stockmanagement;

	import java.io.FileNotFoundException;
	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.Set;

	import org.json.JSONException;
	import org.json.simple.JSONObject;
	import org.json.simple.parser.JSONParser;
	import org.json.simple.parser.ParseException;

import com.bridgelabz.util.JsonUtility;
import com.bridgelabz.util.LinkedListStack;
	import com.bridgelabz.util.LinkedListiml;
	import com.bridgelabz.util.QueueLinkedList;
	import com.bridgelabz.util.Utility;
	/***********************************************************************************************************
	 * @author Rupeshp007
	 * date:17/12/2019
	 * @version 1.0
	 * Purpose:Stock management Service Class it will do the Operations like To create new Stock user and register 
	 * 		   companies and Buy and sell functions for user ,view all stock companies information..etc. 
	 * 
	 * Operations:
	 * 1.Add Stock
	 * 2.buy Stock(User Operation)
	 * 3.Sell Stock by User
	 * 4.print all companies list and information
	 * 5.print the  Report of buy and sell stock
	 **********************************************************************************************************/

	public class StockAccountLinkedList2 extends StockFilesReadWrite
	{
		//Initialization
		JSONObject stockJson=new JSONObject();
		JSONObject stockListJson=new JSONObject();
		
		 LinkedListiml<JSONObject> linkedlistStocklist=new LinkedListiml<>();
		 LinkedListStack<JSONObject> stackBuyList=new LinkedListStack<>();
		 LinkedListStack<JSONObject> stacksellList=new LinkedListStack<>();
		 QueueLinkedList<String> queuetime=new QueueLinkedList<String>();
		 LinkedListiml<JSONObject> loadStocklist=new LinkedListiml<>();
		 LinkedListStack<JSONObject> loadBuyList=new LinkedListStack<>();
		 LinkedListStack<JSONObject> loadsellList=new LinkedListStack<>();
		 QueueLinkedList<String> loadtime=new QueueLinkedList<String>();
		 StockFilesReadWrite readwrte=new StockAccountLinkedList2();

		 	String stockList="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/stockmanagement/LinkedListStockList.json";
			String buyList="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/stockmanagement/stackBuy.json";
			String sellList="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/stockmanagement/StacksellList.json";


		/*********************************************************************************
		 * To add Companies in list it will take information like Name of stock,value,unit..etc
		 * and it will store the data in Json String format in Stockmanagement.json file
		 * 
		 * --> LinkedList to add stocks
		 * 
		 *  @param no parameter
		 *  @return void
		 *******************************************************************************/	
		
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
		
		/*********************************************************************************
		 * To Add all stocks in linkedlist from .json file
		 * 
		 * --> LinkedList to add stocks
		 * 
		 *  @param no parameter
		 *  @return void
		 *******************************************************************************/	
		
		public void LoadStockFileINLinkedList()
		{
			 
				JSONParser parser=new JSONParser();
			
				
				//Iterating through ArrayObjects
				try {
					
					if(JsonUtility.readFile2(stockList)!=null)
					{
					   String fileRead = JsonUtility.readFile(stockList);
					
						temp = (JSONObject) parser.parse(fileRead);
					
					@SuppressWarnings("unchecked")
					Set<JSONObject> s =  temp.keySet();	//Using the HASHMAP property to list each object's KEY
					
					
					Iterator<?> i = s.iterator();
					ArrayList<String> names=new ArrayList<>();
					do{
						names.add(i.next().toString());
					}while(i.hasNext());
						
					for(String name:names)
					{
						JSONObject object=(JSONObject) temp.get(name);
						loadStocklist.add(object);
					}
					}
					} catch (ParseException  | FileNotFoundException e) {
						e.printStackTrace();
					}

		}
		
		    /***********************************************************************************
		    * purpose: To load all purchase object from .json file to stack 
		    *	->Used StackLinkedlist
			************************************************************************************/	

		
		public void LoadPurchaseInStack()
		{
				JSONParser parser=new JSONParser();
			
				
				//Iterating through ArrayObjects
				try {
					
					if(JsonUtility.readFile2(buyList)!=null)
					{
					   String fileRead = JsonUtility.readFile(buyList);
					
						temp = (JSONObject) parser.parse(fileRead);
					
					@SuppressWarnings("unchecked")
					Set<JSONObject> s =  temp.keySet();	//Using the HASHMAP property to list each object's KEY
					
					
					Iterator<?> i = s.iterator();
					ArrayList<String> names=new ArrayList<>();
					do{
						names.add(i.next().toString());
					}while(i.hasNext());
						
					for(String name:names)
					{
						JSONObject object=(JSONObject) temp.get(name);
						loadBuyList.push(object);
						String time=object.get("Transaction Time").toString();
						loadtime.enQueue(time);
					}
					}
					} catch (ParseException  | FileNotFoundException e) {
						e.printStackTrace();
					}
		}

	    /***********************************************************************************
	    * purpose: To load all selling object from .json file to stack 
	    *	->Used StackLinkedlist
		************************************************************************************/	

		public void LoadSellInStack()
		{
				JSONParser parser=new JSONParser();
			
				
				//Iterating through ArrayObjects
				try {
					
					if(JsonUtility.readFile2(sellList)!=null)
					{
					   String fileRead = JsonUtility.readFile(sellList);
					
						temp = (JSONObject) parser.parse(fileRead);
					
					@SuppressWarnings("unchecked")
					Set<JSONObject> s =  temp.keySet();	//Using the HASHMAP property to list each object's KEY
					
					
					Iterator<?> i = s.iterator();
					ArrayList<String> names=new ArrayList<>();
					do{
						names.add(i.next().toString());
					}while(i.hasNext());
						
					for(String name:names)
					{
						JSONObject object=(JSONObject) temp.get(name);
						loadsellList.push(object);
						String time=object.get("Transaction Time").toString();
						loadtime.enQueue(time);
					}
					}
					} catch (ParseException  | FileNotFoundException e) {
						e.printStackTrace();
					}
		}


	    /***********************************************************************************
	    * purpose: To Remove stock object from linkedList 
	    *	->Used StackLinkedlist
		************************************************************************************/	

		
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
			readwrte.writeToFile(stockList, mainobject);	
		}
		

		/*********************************************************************************
		 *purpose: buy the Stocks from companies it will take amount and symbol of companies 
		 *         from user and Authentic the user if user is registered then it will store 
		 *         the purchase data into the StockPurchase.json file.
		 * --> used stackLinkedList
		 *  @return void
		 *******************************************************************************/	

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
			   temp2.keySet().forEach(key -> System.out.println(key));

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
			readwrte.writeToFile(buyList, temp);	
			readwrte.writeToFile(stockList, temp2);	
			System.out.println("You purchased "+companyName+" Stocks Successfully");
		}
		
		
		/*********************************************************************************
		 *purpose: Sell the Stocks to companies it will take amount and symbol of companies 
		 *         from user and Authentic the user if user is registered then it will store 
		 *         the purchase data into the StockPurchase.json file.
		 * --> used stackLinkedList
		 *  @return void
		 *******************************************************************************/	

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
			   temp2.keySet().forEach(key -> System.out.println(key));
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
			mainobject.put("Unit", Integer.toString(unit));
			
			Set<JSONObject> set=temp2.keySet();
			Iterator<?> i=set.iterator();
			ArrayList<String> names=new ArrayList<>();
			do{
				
				names.add(i.next().toString());
			}while(i.hasNext());
			
			//temp2 buylist temp3 stocklist temp selllist
				JSONObject read=(JSONObject) temp2.get(name);
				JSONObject read2=(JSONObject) temp3.get(companyName);
				int value=Integer.parseInt((String) read.get("Value"));
				mainobject.put("Value", Integer.toString(value));//
				int unit2=Integer.parseInt((String) read2.get("Units"));
				int result=unit2+unit;
				value=unit*value;
				read2.replace("Unit", Integer.toString(result));
				temp3.put(companyName, read);
				mainobject.put("Total Value", Integer.toString(value));
				mainobject.put("Status","Stock Sold:");
				String time=java.time.LocalDateTime.now().toString();
				mainobject.put("Transaction Time", time);
				temp.put(name,mainobject);
				queuetime.enQueue(time);
				stacksellList.push(temp); //Pushed JsonObject into Stack
				readwrte.writeToFile(sellList, temp);	
				readwrte.writeToFile(stockList, temp3);	
				System.out.println("You sold "+companyName+"Stocks:");
		}
		static StockAccountLinkedList2 obj=new StockAccountLinkedList2();

		 /***********************************************************************************
		 *purpose: it will print the report of users stock details and selling and buying
		 *			details and time when purchased
		 *
		 *  @param no param
		 *  @return void
		 * @throws JSONException 
		 *******************************************************************************/	

		public void PrintReport() throws JSONException
		{
			System.out.println("");
			obj.LoadStockFileINLinkedList();
			obj.LoadPurchaseInStack();
			obj.LoadSellInStack();
			JSONObject[] buylist=loadBuyList.getjson();
			JSONObject[]	selllist=loadsellList.getjson();
			System.out.println("=======================>>StockPurchased Report<<============================");
			for(JSONObject objetc:buylist)
			{
				System.out.println("Account Holder NAme: "+objetc.get("Name"));
				System.out.println("Stock name: "+objetc.get("Stock Name"));
				System.out.println("Units: "+objetc.get("Unit"));
				System.out.println("VAlue: "+objetc.get("Value"));
				String time=loadtime.deQueue();
				System.out.println("Transaction time: "+time);
			}
			System.out.println("=======================>>StockSell Report<<============================");
			for(JSONObject objetc:selllist)
			{
				System.out.println("Account Holder NAme: "+objetc.get("Name"));
				System.out.println("Stock name: "+objetc.get("Stock Name"));
				System.out.println("Units: "+objetc.get("Unit"));
				System.out.println("VAlue: "+objetc.get("Value"));
				String time=loadtime.deQueue();
				System.out.println("Transaction time: "+time);
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
						break;
				case 6:
					try {
						obj.PrintReport();
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
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