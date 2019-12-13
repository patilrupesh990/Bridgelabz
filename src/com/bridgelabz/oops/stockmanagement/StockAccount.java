package com.bridgelabz.oops.stockmanagement;

import java.io.FileNotFoundException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
		
	
		
		
		public  void mainMenu()
		{
			String symbol;
			int amount;
			System.out.println("Enter Your choice");
			System.out.println("1.Add New Stock \n 2.All Stock List \n 3.Values of Stocks \n 4.Purchase Stock \n 5.Sell Stock \n 6. Stock Report");
			int choice =Utility.InputInt();
			System.out.println();
			
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
						
						System.out.println("Enter StockNAme");
						symbol=Utility.InputString();
						System.out.println("Enter Amount");
						amount=Utility.InputInt();
						this.buy(amount, symbol);
						break;
				case 5:
						System.out.println("Enter StockNAme");
						symbol=Utility.InputString();
						System.out.println("Enter Amount");
						amount=Utility.InputInt();
						this.sell(amount, symbol);
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
			 		accounttransaction=new JSONObject();
					 purchaseObject=JsonUtility.readFile2(stockbuyfile);
					 System.out.print("Enter Your Mobile No:");
					 String contact=Utility.InputString();			 
					 System.out.println("Enter your password:");
					 String password=Utility.InputString();
					 if(Authentication(contact,password))
					 {
						 JSONObject temp=new JSONObject();
						 accounttransaction.put("Stock Name", symbol);
						 accounttransaction.put("Account Holder Name", StockAccount.getStockHolderName());
						 double unit=getStockunitBasedOnAmount(amount, symbol);
						 accounttransaction.put("Unit",Double.toString(unit));
						 accounttransaction.put("Date&Time",java.time.LocalDateTime.now().toString());
						 accounttransaction.put("Status", "Stock Purchased");
						 purchaseObject.put(contact,accounttransaction);

						 temp.put("Purchase"+contact, purchaseObject);
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
				while(iterator.hasNext())
				{
					jsonObject=(JSONObject) iterator.next();
					value= (String)jsonObject.get("stock value");
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
		 
		 
		 @SuppressWarnings("unchecked")
		public void sell(int amount,String symbol)
		 {
			 accounttransaction=new JSONObject();
			 System.out.print("Enter Your Mobile No:");
			 String contact=Utility.InputString();			 
			 System.out.println("Enter your password:");
			 String password=Utility.InputString();
			 if(Authentication(contact,password))
			 {
				 accounttransaction.put("Stock Name", symbol);
				
				 accounttransaction.put("Date&Time",java.time.LocalDateTime.now());
				 purchaseObject.put(contact,accounttransaction);
				 
				 System.out.println("you transaction succesfull....");
				 UpdateFilesAfterSell(amount, symbol,contact); 
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
		 
		 
		 @SuppressWarnings("unchecked")
		public static void UpdateFilesAfterSell(int amount,String StockName,String key) 
		 {
			 JSONObject stockJson=null;
			 JSONObject temp=JsonUtility.readFile2(stockbuyfile);
			 String fileData=temp.toString();			
			 try {
				stockJson=(JSONObject) parser.parse(fileData);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 if(stockJson.get("Sold"+key)!=null)
			 {
			 JSONObject temp2=(JSONObject) stockJson.get("Sold"+key);
			 String value=  (String) temp2.get("Stock Value");
			 String unit=(String) temp2.get("Unit");
			 int sellUnit=amount/Integer.parseInt(value);
			 double result=Double.parseDouble(unit)-sellUnit;
			 double totalValue=Integer.parseInt(value)*result;
			 temp2.replace("Unit", Double.toString(result));
			 temp2.replace("Total Value:", totalValue);
			 
			 temp2.put("Status", "Stock Sold");
			 temp.put("Sold"+key,temp2);
			 JsonUtility.writeToFile(stockbuyfile, temp);
			 System.out.println("You have now "+result+"Stocks Available");
			 }
			 else
			 {
				 JSONObject temp2=(JSONObject) stockJson.get("Purchase"+key);
				 String value=  (String) temp2.get("Stock Value");
				 String unit=(String) temp2.get("Unit");
				 int sellUnit=amount/Integer.parseInt(value);
				 double result=Double.parseDouble(unit)-sellUnit;
				 double totalValue=Integer.parseInt(value)*result;
				 temp2.replace("Unit", Double.toString(result));
				 temp2.replace("Total Value:", totalValue);
				 
				 temp2.put("Status", "Stock Sold");
				 temp.put("Sold"+key,temp2);
				 JsonUtility.writeToFile(stockbuyfile, temp);
				 System.out.println("You have now "+result+"Stocks Available");
				 
			 }
		 }

		 

		@Override
		public double ValueOf() {
			// TODO Auto-generated method stub
			return 0;
		}


		@Override
		public void printReport() 
		{
			JSONObject stockJson=null;
			 JSONObject temp=JsonUtility.readFile2(stockbuyfile);
			 String fileData=temp.toString();			
			 System.out.println("Enter phNo of Person");
			 String phNo=Utility.InputString();
			 
			 try {
				stockJson=(JSONObject) parser.parse(fileData);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						 
		}

		
}
