package com.bridgelabz.oops.stockmanagement;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.bridgelabz.oops.addressbook.JsonUtility;
import com.bridgelabz.util.Utility;

public class StockAccount implements Stock
{
	static StockDetails stock=new StockDetails();
	JSONObject individualStocks=new JSONObject();
	JSONObject accountHolder=new JSONObject();
	JSONObject accountbuy=new JSONObject();
	
	static JSONParser parser=new JSONParser();
	static String stockfile="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/stockmanagement/StockManagement.json";
	static String accountfile="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/stockmanagement/StockHoldersAccounts.json";
	static String stockbuyfile="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/stockmanagement/StockPurchased.json";
		public  void mainMenu()
		{
			System.out.println("Enter Your choice");
			System.out.println("1.Add New Stock  2.All Stock List 3.Values of Stocks 4 Stock Report");
			int choice =Utility.InputInt();
			switch(choice)
			{
				case 1:
						System.out.println("How many stocks want to Enter?");
						int tasks=Utility.InputInt();
						for(int count=0;count<tasks;count++)
						{
							addStock();
						}
						//new stock
						break;
						
						
				case 2:
							//all stock list
						break;
				case 3:
							System.out.println("Enter Stock Name");
							String stockName=Utility.InputString();
							double result=StockAccount.calculateTotalValue(stockName);
							System.out.println(stockName+" total value is::"+result);
							break;
				case 4:
						//stock report
						break;
				default:
						break;
			}
		}
		
		
		JSONObject stockRead=new JSONObject();
		@SuppressWarnings("unchecked")
		public  void addStock()
		{
			stockRead=JsonUtility.readFile2(stockfile);
			System.out.println("Enter the Name Of stock:");
			String stockName=Utility.InputString();
			stock.setStockName(stockName);
			individualStocks.put("Company Name", stockName);
			
			System.out.println("Enter the Value of stock");
			String value=Utility.InputString();
			//stock.setStockValue(value);
			individualStocks.put("stock value", value);
			
			System.out.println("Enter the Number of stocks?");
			String quantity=Utility.InputString();
			//stock.setStockQuantity(quantity);
			individualStocks.put("stock unit", quantity);			
			stockRead.put(stockName, individualStocks);
			JsonUtility.writeToFile(stockfile, stockRead);	
			System.out.println(stockName+"Added SucessFully to database..");
		}
		
		
		@SuppressWarnings("unchecked")
		public static double calculateTotalValue(String stockName)
		{
			JSONObject stockJson=null;
			String fileData=null;
			
			try {
				 fileData=JsonUtility.readFile(stockfile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				stockJson = (JSONObject) parser.parse(fileData);
			} catch (ParseException e) 
			{
					e.printStackTrace();
			}
			JSONArray arrayItems = new JSONArray();
			arrayItems.add(stockJson.get(stockName));
			Iterator<?> iterator = arrayItems.iterator();
			String value="";
			String unit="";
			while(iterator.hasNext())
			{
				JSONObject jsonObject=(JSONObject) iterator.next();
				value= (String) jsonObject.get("stock value");
				unit=(String) jsonObject.get("stock unit");
			}
			double result=Integer.parseInt(value)*Integer.parseInt(unit);
				return (result);
		}
		
		JSONObject accounts=new JSONObject();
		@SuppressWarnings("unchecked")
		@Override
		public void stockAccount()
		{
			accounts=JsonUtility.readFile2(accountfile);
			System.out.println("Enter Your Name");
			String name=Utility.InputString();
			accountHolder.put("Name",name);
			
			System.out.println("Enter your city");
			String city=Utility.InputString();
			accountHolder.put("City",city);

			
			
			System.out.println("Enter your state");
			String state=Utility.InputString();
			accountHolder.put("State",state);

			
			System.out.println("Enter your contact no");
			long  phNo=Utility.inputLong();
			accountHolder.put("Contact",phNo);

			
			System.out.println("Enter Your password");
			String password=Utility.InputString();
			accountHolder.put("Password",password);

			accounts.put(phNo, accountHolder);
			JsonUtility.writeToFile(accountfile, accounts);	
			System.out.println(name+"Registered Successfully....");			
		}
		
		JSONObject purchaseObject=new JSONObject();
		 @SuppressWarnings("unchecked")
		public void buy(int amount,String symbol) 
		 {
				//	 purchaseObject=JsonUtility.readFile2(stockbuyfile);
					 System.out.print("Enter Your Mobile No:");
					 String contact=Utility.InputString();			 
					 System.out.println("Enter your password:");
					 String password=Utility.InputString();
					 if(Authentication(contact,password))
					 {
						 accountbuy.put("Stock Name", symbol);
						 double unit=getStockunitBasedOnAmount(amount, symbol);
						 accountbuy.put("Unit",Double.toString(unit));
						 accountbuy.put("Date&Time",java.time.LocalDateTime.now());
						 purchaseObject.put(contact,accountbuy);
						 
						 
						 JsonUtility.writeToFile(stockbuyfile, purchaseObject);	
						 System.out.println("Purchessed Successfully....");
						 updateFile(stockfile, symbol, unit);
					 }
					 else {
						try {
							throw new StockMngmtExcpetion("invalid UserName or passord");
						} catch (StockMngmtExcpetion e) {
							System.out.println(e);
						}
					}
		 }
		 
		 @SuppressWarnings("unchecked")
		public double getStockunitBasedOnAmount(long amount,String stockName)
		 { 
			 JSONObject stockJson=null;
				String fileData=null;

				try {
					 fileData=JsonUtility.readFile(stockfile);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				try {
					stockJson = (JSONObject) parser.parse(fileData);
				} catch (ParseException e) 
				{
						e.printStackTrace();
				}
				JSONArray arrayItems = new JSONArray();
				arrayItems.add(stockJson.get(stockName));
				Iterator<?> iterator = arrayItems.iterator();
				double unit=0;
				String value="";
				JSONObject jsonObject=null;
				while(iterator.hasNext())
				{
					jsonObject=(JSONObject) iterator.next();
					value= (String)jsonObject.get("stock value");
				} 
				unit=amount/Double.parseDouble(value);
				 accountbuy.put("Total Value:",unit*Integer.parseInt(value));
			return unit;		
		 }
		 
		 @SuppressWarnings("unchecked")
		public static boolean Authentication(String contact,String password)
		 {
			 
			 JSONObject stockJson=null;
				String fileData=null;
				
				try {
					 fileData=JsonUtility.readFile(accountfile);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				try {
					stockJson = (JSONObject) parser.parse(fileData);
				} catch (ParseException e) 
				{
						e.printStackTrace();
				}
				JSONObject temp=(JSONObject) stockJson.get(contact);
				if(temp.get("Password").equals(password))
				{
					return true;
				}

				return false;
		 }
		 
		 @SuppressWarnings("unchecked")
		public static void updateFile(String fileName,String StockName,double unitbuy)
		 {
			 JSONObject stockJson=null;
			 JSONObject temp=null;
				String fileData=null;
				temp=JsonUtility.readFile2(fileName);

				try {
					 fileData=JsonUtility.readFile(fileName);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				try {
					stockJson = (JSONObject) parser.parse(fileData);
				} catch (ParseException e) 
				{
						e.printStackTrace();
				}
				JSONArray arrayItems = new JSONArray();
				arrayItems.add(stockJson.get(StockName));
				Iterator<?> iterator = arrayItems.iterator();
				String unit="";
				double result=0;
				JSONObject jsonObject=null;
				while(iterator.hasNext())
				{
					jsonObject=(JSONObject) iterator.next();
					unit= (String) jsonObject.get("stock unit");
					 result=Integer.parseInt(unit)-unitbuy;
					jsonObject.replace("stock unit", Double.toString(result));
					//jsonObject.remove(StockName);
				} 
				temp.put(StockName,jsonObject);
				
				JsonUtility.writeToFile(fileName, temp);	
		 }
		 
		 void save(String fileName)
		 {
			 
		 }

		
}
