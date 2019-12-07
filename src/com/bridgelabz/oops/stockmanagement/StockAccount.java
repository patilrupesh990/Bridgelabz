package com.bridgelabz.oops.stockmanagement;

import java.util.HashMap;

import org.json.simple.JSONObject;

import com.bridgelabz.util.Utility;

public class StockAccount 
{
	static StockDetails stock=new StockDetails();
	static HashMap<String, StockDetails> stockmap=new HashMap<String, StockDetails>();
	
	JSONObject stocks=new JSONObject();
	JSONObject sockName=new JSONObject();
	
		public static void mainMenu()
		{
			System.out.println("Enter Your choice");
			System.out.println("1.Add New Stock  2.All Stock List 3.Values of Stocks 4 Stock Report");
			int choice =Utility.InputInt();
			switch(choice)
			{
				case 1:
						//new stock
						break;
						
						
				case 2:
							//all stock list
						break;
				case 3:
						//value of stocks
						break;
				case 4:
						//stock report
						break;
				default:
						break;
			}
		}
		
		public static void addStock()
		{
			System.out.println("Enter the Name Of stock:");
			String stockName=Utility.InputString();
			stock.setStockName(stockName);
			System.out.println("Enter the Value of stock");
			stock.setStockValue(Utility.InputDouble());
			System.out.println("Enter the Number of stocks?");
			stock.setStockQuantity(Utility.InputInt());
			
			stockmap.put(stockName, stock);
			
		}
		
		
}
