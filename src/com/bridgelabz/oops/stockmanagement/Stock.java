package com.bridgelabz.oops.stockmanagement;

import java.io.FileNotFoundException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.bridgelabz.util.JsonUtility;
import com.bridgelabz.util.Utility;


/***********************************************************************************************************
 * @author Rupeshp007
 * date:15/12/2019
 * @version 1.0
 * Purpose:It's an Interface to declare abstract methods of Stock Management Program
 * 
 * Operations:
 * Main Menu of Stock program
 * -> Abstract Methods
 * 		void stockAccount();
 *	    double ValueOf();//reamaining
 * 	    void buy(int amount,String symbol);  
 *	    void sell(int amount,String symbol);
 *	    void printReport();
 * 	
 **********************************************************************************************************/
public interface Stock
{
	Stock stock=new StockAccount();
	StockAccount stockmanagement=new StockAccount();
	static String stockfile="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/stockmanagement/StockManagement.json";
	static String accountfile="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/stockmanagement/StockHoldersAccounts.json";
	static String stockbuyfile="/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/oops/stockmanagement/StockPurchased.json";
	static JSONParser parser=new JSONParser();

	
	 void stockAccount();//complete
	 double ValueOf();//reamaining
	 void buy(int amount,String symbol);  
	 void sell(int amount,String symbol);
	 void printReport();
	 
	    /*********************************************************************************
		 * MainMenu of StockManagement Program
		 * 	
		 *   1.AddNew Stock
		 *   2.Create User Account
		 *   3.All Stock List
		 *   4.Values of Stocks
		 *   5.Purchase Stock
		 *   6.Sell Stock 
		 *   7. Stock Report
		 *   8. exit
		 *  @param no parameter
		 *  @return void
		 *******************************************************************************/	

	 @SuppressWarnings("unchecked")
	public static  void mainMenu()
		{
			String symbol;
			int amount;
			 JSONObject stocks = null;
				String fileRead = null;
				try {
						if(JsonUtility.readFile(stockfile)!=null)
						{
								fileRead = JsonUtility.readFile(stockfile);
						}
						stocks = (JSONObject) parser.parse(fileRead);	
						
					}
				 catch (ParseException e) {
					e.printStackTrace();
				}
				catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			
			while(true)
			{
				System.out.println("====================================================================================");
			System.out.println(" 1.Add New Stock \n 2.New User Account \n 3.All Stock List \n 4.Values of Stocks \n 5.Purchase Stock \n 6.Sell Stock \n 7. Stock Report \n 8. exit");
			System.out.println("Enter Your choice");

			int choice =Utility.InputInt();

			System.out.println();
			
					switch(choice)
					{
						case 1:
								System.out.println("How many stocks want to Enter?");
								int tasks=Utility.InputInt();
								for(int count=0;count<tasks;count++)
								{
									stockmanagement.addStock();
								}
								//new stock
								break;
						case 2:
							stock.stockAccount();
									break;
								
						case 3:
									System.out.println("==================>>Available Stocks<<==================");
									stocks.keySet().forEach(key -> System.out.println("             "+key));
									System.out.println("-------------------------------");
									break;
						case 4:
									System.out.println("==================>>Available Stocks<<==================");
									stocks.keySet().forEach(key -> System.out.println("             "+key));
									System.out.println("-------------------------------");
									System.out.println("Enter Stock Name For get Total value of compny");
									String stockName=Utility.InputString();
									double result=Stock.calculateTotalValue(stockName);
									System.out.println(stockName+" total value is::"+result);
									System.out.println("---------------------------------------------");
									break;
						case 5:
								
								System.out.println("==================>>Available Stocks<<==================");
								JSONObject temp=stocks;
								System.out.println("Stock \tValue\tUnits");
								stocks.keySet().forEach(key ->{ 
									//System.out.println(key);			
										JSONArray arrayItems = new JSONArray();
										arrayItems.add(temp.get(key));
										Iterator<?> iterator = arrayItems.iterator();
										JSONObject jsonObject=null;
										while(iterator.hasNext())
										{
											jsonObject=(JSONObject) iterator.next();
											System.out.print(jsonObject.get("Company Name"));
											System.out.print("\t"+jsonObject.get("stock value"));
											System.out.print("\t"+jsonObject.get("stock unit"));
											System.out.println();
										} 
									
								});
								
								
								
								System.out.println("-------------------------------");
								System.out.println("Enter Stock Name:");
								symbol=Utility.InputString();
								System.out.println("Enter Amount");
								amount=Utility.InputInt();
								stock.buy(amount, symbol);
								break;
						case 6:
								System.out.println("Enter StockNAme");
								symbol=Utility.InputString();
								System.out.println("Enter Amount");
								amount=Utility.InputInt();
								
								stock.sell(amount, symbol);
								break;
						case 7:
								stock.printReport();
									break;
						case 8:
								System.exit(0);
						default:
								break;
					}
			}
		}
	 

		/*********************************************************************************
		 * To calculate TotalValue of Stocks
		 *  
		 *  @param No Parameter
		 *  @return void
		 *******************************************************************************/	
	
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
			double result=Double.parseDouble(value)*Double.parseDouble(unit);
				return (result);
		}

}
