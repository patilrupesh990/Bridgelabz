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
	static JSONParser parser=new JSONParser();
	static String fileName="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/stockmanagement/StockManagement.json";
	
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
			stockRead=JsonUtility.readFile2(fileName);
			System.out.println("Enter the Name Of stock:");
			String stockName=Utility.InputString();
			stock.setStockName(stockName);
			individualStocks.put("Company Name", stockName);
			
			System.out.println("Enter the Value of stock");
			double value=Utility.InputDouble();
			stock.setStockValue(value);
			individualStocks.put("stock value", value);

			
			System.out.println("Enter the Number of stocks?");
			int quantity=Utility.InputInt();
			stock.setStockQuantity(quantity);
			individualStocks.put("stock unit", quantity);			
			stockread.put(stockName, individualStocks);
			JsonUtility.writeToFile(fileName, stockRead);	
			System.out.println(stockName+"Added SucessFully to database..");
		}
		
		
		@SuppressWarnings("unchecked")
		public static double calculateTotalValue(String stockName)
		{
			JSONObject stockJson=null;
			String fileData=null;
			
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
			arrayItems.add(stockJson.get(stockName));
			Iterator<?> iterator = arrayItems.iterator();
			double value=0;
			long unit=0;
			while(iterator.hasNext())
			{
				JSONObject jsonObject=(JSONObject) iterator.next();
				value= (double) jsonObject.get("stock value");
				unit=(long) jsonObject.get("stock unit");
			}
				return (value*unit);
		}
		
		JSONObject accounts=new JSONObject();
		@Override
		public void StockAccount()
		{
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

			
			
		}
		
		
}
