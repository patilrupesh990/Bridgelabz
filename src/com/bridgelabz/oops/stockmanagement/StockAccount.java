package com.bridgelabz.oops.stockmanagement;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.oops.addressbook.AddressBookimplementation;
import com.bridgelabz.oops.addressbook.JsonUtility;
import com.bridgelabz.util.Utility;

/***********************************************************************************************************
 * @author Rupeshp007
 * date:11/12/2019
 * @version 1.0
 * Purpose:Controller for manage Inventory Program 
 * Operations:
 * 1.add inventory
 * 2.get price of value
 * 3.get total value of inventories 
 **********************************************************************************************************/

public class StockAccount implements Stock
{
	static StockDetails stock=new StockDetails();
	JSONObject individualStocks=new JSONObject();
	JSONObject accountHolder=new JSONObject();
	JSONObject accounttransaction=null;

	
	static JSONParser parser=new JSONParser();
	static String stockfile="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/stockmanagement/StockManagement.json";
	static String accountfile="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/stockmanagement/StockHoldersAccounts.json";
	static String stockbuyfile="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/stockmanagement/StockPurchased.json";
	static String stocksoldfile="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/stockmanagement/SoldStock.json";
	
	
		
	/*********************************************************************************
	 * it will Convert all java object into the .json file
	 * like this different Inventory from .json file.
	 *  @param Object object,String input,String name,double weight,double price
	 *  @return JSONArray
	 *******************************************************************************/	

		
		
		
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
		 JSONObject temp=new JSONObject();

		 @SuppressWarnings("unchecked")
		public void buy(int amount,String symbol) 
		 {
			 		accounttransaction=new JSONObject();
					 temp=JsonUtility.readFile2(stockbuyfile);
					 System.out.print("Enter Your Mobile No:");
					 String contact=Utility.InputString();			 
					 System.out.println("Enter your password:");
					 String password=Utility.InputString();
					 if(Authentication(contact,password))
					 {
						 accounttransaction.put("Stock Name", symbol);
						 accounttransaction.put("Account Holder Name", StockAccount.getStockHolderName());
						 double unit=getStockunitBasedOnAmount(amount, symbol);
						 accounttransaction.put("Unit",Double.toString(unit));
						 accounttransaction.put("Date&Time",java.time.LocalDateTime.now().toString());
						 accounttransaction.put("Status", "Stock Purchased");
						purchaseObject.put(contact,accounttransaction);
						 temp.put("Purchase", purchaseObject);
						 JsonUtility.writeToFile(stockbuyfile, temp);	
						 System.out.println("Purchessed Successfully....");
						 updateFileAfterPurchased(stockfile, symbol, unit);
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
				String Unit="";
				while(iterator.hasNext())
				{
					jsonObject=(JSONObject) iterator.next();
					value= (String)jsonObject.get("stock value");
					Unit=(String) jsonObject.get("stock unit");
				} 
				if(Integer.parseInt(Unit)<0)
				{
					System.out.println("There is no Available Stocks of this compnies:");
					Stock.mainMenu();
				}
				unit=amount/Double.parseDouble(value);
				accounttransaction.put("Stock Value", value);
				accounttransaction.put("Total Value:",Double.toString(unit*Integer.parseInt(value)));
			return unit;		
		 }
		 
		 static String StockHolderName;
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
				StockHolderName=(String) temp.get("Name");
				if(temp.get("Password").equals(password))
				{
					return true;
				}
				else
				{
					try {
						throw new StockMngmtExcpetion("Invalid Username or password");
					} catch (StockMngmtExcpetion e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				return false;
		 }
		public static String getStockHolderName()
		{
			return StockHolderName;
		}
		
		
		 
		 @SuppressWarnings("unchecked")
		public static void updateFileAfterPurchased(String fileName,String StockName,double unitbuy)
		 {
			 
			 	JSONObject stockJson=null;
			 	JSONObject temp=null;
				String fileData=null;
				temp=JsonUtility.readFile2(fileName);
				fileData=temp.toString();
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
					 result=Double.parseDouble(unit)-unitbuy;
					jsonObject.replace("stock unit", Double.toString(result));
					//jsonObject.remove(StockName);
				} 
				temp.put(StockName,jsonObject);
				
				JsonUtility.writeToFile(fileName, temp);	
		 }
		 
		 void save(String fileName)
		 {
			 
		 }
		 
		  JSONObject selljson=new JSONObject();
		 
		 @SuppressWarnings("unchecked")
		public void sell(int amount,String symbol)
		 {
			 
			 temp=JsonUtility.readFile2(stocksoldfile);
			 System.out.print("Enter Your Mobile No:");
			 String contact=Utility.InputString();			 
			 System.out.println("Enter your password:");
			 String password=Utility.InputString();
			 if(Authentication(contact,password))
			 {
				 String unit=UpdateFilesAfterSell(amount, symbol,contact); 
				 selljson.put("Stock Holder Name", StockAccount.getStockHolderName());
				 selljson.put("stock Name", symbol);
				 selljson.put("Date&Time",java.time.LocalDateTime.now().toString());
				 selljson.put("Status", "Stock Sold");
				 selljson.put("Unit", StockAccount.Unit);
				 purchaseObject.put(contact,selljson);
				 temp.put("Sold", purchaseObject);
				 JsonUtility.writeToFile(stocksoldfile, temp);	
			//	 System.out.println("Purchessed Successfully....");

				 
				 System.out.println("you transaction succesfull....");
			 }
			 else
			 {
				 try {
						throw new StockMngmtExcpetion("invalid UserName or passord");
					} catch (StockMngmtExcpetion e) {
						System.out.println(e);
					}
			 }
		 }
		 static String Unit;
		 public static String getUnit()
		 {
			return Unit; 
		 }
		@SuppressWarnings("unchecked")
		public  String UpdateFilesAfterSell(int amount,String StockName,String key) 
		 {
			JSONObject stockJson=null;
		 	JSONObject temp=null;
			String fileData=null;
			temp=JsonUtility.readFile2(stockfile);
			fileData=temp.toString();
			try {
				stockJson = (JSONObject) parser.parse(fileData);
			} catch (ParseException e) 
			{
					e.printStackTrace();
			}
			JSONObject temporary=(JSONObject) stockJson.get("Purchase");

			JSONArray arrayItems = new JSONArray();
			arrayItems.add(temporary.get(key));
			Iterator<?> iterator = arrayItems.iterator();
			String unit="";
			String value="";
			double result=0;
			double sell=0;
			JSONObject jsonObject=null;
			while(iterator.hasNext())
			{
				jsonObject=(JSONObject) iterator.next();
				unit=  (String) jsonObject.get("Unit");
				value=(String) jsonObject.get("Stock Value"); 
				 sell=amount/Double.parseDouble(value);
				selljson.put("Unit",Double.toString(sell));
				selljson.put("Total amount:", Integer.toString(amount));
				result=Double.parseDouble(unit)-sell;
				jsonObject.replace("Unit", Double.toString(result));
				jsonObject.replace("Status", "Sold");
				//jsonObject.remove(StockName);
			} 
			StockAccount.Unit=Double.toString(sell);
			temp.put(key,jsonObject);
			
			JsonUtility.writeToFile(stockbuyfile, temp);	
			return Double.toString(sell);
		 }
		 
		 
		
		
		
		
//		public  void UpdateSoldFilesAfterSell(int amount,String StockName,String key) 
//		 {
//			JSONObject stockJson=null;
//		 	JSONObject temp=null;
//			String fileData=null;
//			temp=JsonUtility.readFile2(stocksoldfile);
//			fileData=temp.toString();
//			try {
//				stockJson = (JSONObject) parser.parse(fileData);
//			} catch (ParseException e) 
//			{
//					e.printStackTrace();
//			}
//			JSONObject temporary=(JSONObject) stockJson.get("Sold");
//
//			JSONArray arrayItems = new JSONArray();
//			arrayItems.add(temporary.get(key));
//			Iterator<?> iterator = arrayItems.iterator();
//			String unit="";
//			String value="";
//			double result=0;
//			double sell=0;
//			JSONObject jsonObject=null;
//			while(iterator.hasNext())
//			{
//				jsonObject=(JSONObject) iterator.next();
//				unit=  (String) jsonObject.get("Unit");
//				value=(String) jsonObject.get("Stock Value"); 
//				 sell=amount/Double.parseDouble(value);
//				selljson.put("Unit",Double.toString(sell));
//				selljson.put("Total amount:", Integer.toString(amount));
//				result=Double.parseDouble(unit)-sell;
//				jsonObject.replace("Unit", Double.toString(result));
//				jsonObject.replace("Status", "Sold");
//				//jsonObject.remove(StockName);
//				
//				
//				selljson.put("Stock Holder Name", StockAccount.getStockHolderName());
//				 selljson.put("stock Name", StockName);
//				 selljson.put("Date&Time",java.time.LocalDateTime.now().toString());
//				 selljson.put("Status", "Stock Sold");
//				 selljson.put("Unit", Double.toString(sell));
//				 purchaseObject.put(key,selljson);
//				 temp.put("Sold", purchaseObject);
//				 JsonUtility.writeToFile(stocksoldfile, temp);	
//
//			} 
//			
//		 }
		  
		 
		
		@Override
		public double ValueOf() {
			// TODO Auto-generated method stub
			return 0;
		}


		@Override
		public void printReport() 
		{
			
			 		 
		}

		
}
