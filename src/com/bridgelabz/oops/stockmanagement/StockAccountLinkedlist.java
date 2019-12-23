package com.bridgelabz.oops.stockmanagement;

import org.json.simple.JSONObject;

import com.bridgelabz.util.LinkedListStack;
import com.bridgelabz.util.LinkedListiml;
import com.bridgelabz.util.Utility;


public class StockAccountLinkedlist extends StockFilesReadWrite
{
	JSONObject stockJson=new JSONObject();
	LinkedListiml<StockDetails> Stocklist=new LinkedListiml<>();
	LinkedListiml<BuyerDetails> BuyerDetails=new LinkedListiml<>();
	LinkedListiml<BuyerDetails> SellDetails=new LinkedListiml<>();
	
    StockDetails stock;

	public  void addStock()
	{
		stock=new StockDetails();
		System.out.println("Enter the Name Of stock:");
		String stockName=Utility.InputString();
		stock.setStockName(stockName);
		
		System.out.println("Enter the Value of stock");
		int value=Utility.InputInt();
		stock.setStockValue(value);
		
		System.out.println("Enter the Number of stocks?");
		int quantity=Utility.InputInt();
		stock.setStockQuantity(quantity);
		System.out.println(stockName+"Added SucessFully to database..");
		Stocklist.add(stock);
		System.out.println(stockName+"Added Successfully");
	}
	public void removeLinkedList()
	{
		System.out.println("Enter the Name Of stock:");
		String stockName=Utility.InputString();
		StockDetails stocks[]=Stocklist.GetListObject();
		for(StockDetails object:stocks)
		{
			if(object.getStockName().equals(stockName))
			{
				Stocklist.removeNode(object);
			}
		}
		
	}
	
	public void buyStock()
	{
		BuyerDetails buyer=new BuyerDetails();
		
		System.out.println("Enter Your Name:");
		String name=Utility.InputString();
		buyer.setBuyerName(name);
		
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
				Stocklist.removeNode(object);
				Stocklist.add(object);
				BuyerDetails.add(buyer);
				System.out.println("SuccessFully You have Purchased"+buyer.getCompanyName()+"  Stocks");
			}
		}
	}
	
	public void SellStock()
	{
		BuyerDetails buyer=new BuyerDetails();
		System.out.println("Enter Your Name");
		String name=Utility.InputString();
		buyer.setBuyerName(name);
		
		System.out.println("Enter Company name :");
		String companyName=Utility.InputString();
		buyer.setCompanyName(companyName);
		
		System.out.println("Enter How many Stocks want to Sell");
		int unit=Utility.InputInt();
		buyer.setUnit(unit);
		
		StockDetails stocks[]=Stocklist.GetListObject();
		for(StockDetails object:stocks)
		{
			if(object.getStockName().equals(buyer.getCompanyName()))
			{
				int value=object.getStockValue();
				int amount=value*unit;
				int availableunit=object.getStockQuantity();
				int result=availableunit+unit;
				buyer.setStockValue(value);
				object.setStockQuantity(result);
				buyer.setTotalValue(amount);
				buyer.setStatus("Stocks Sold");
				Stocklist.removeNode(object);
				Stocklist.add(object);
				
				SellDetails.add(buyer);
				System.out.println(amount+" You have recieved after sell"+buyer.getUnit()+" stocks");
			}
			else
			{
				System.out.println("invalid company name");
			}
		}
	}
	
	
	public void printReport()
	{
		System.out.println("Enter the Name Person");
		String name=Utility.InputString();
		BuyerDetails buyers[]=BuyerDetails.GetBuyerListObject();
		BuyerDetails sale[]=SellDetails.GetBuyerListObject();
		
		for(BuyerDetails buyer:buyers)
		{
			try{
			if(buyers!=null)
			{
				System.out.println("==============>>>>>Stock Report Of "+name+"<<<<==============");

				if(buyer.getBuyerName().equals(name))
				{
					System.out.println("Buyer Name:"+buyer.getBuyerName());
					System.out.println("Compny name:"+buyer.getCompanyName());
					System.out.println("Stock value:"+buyer.getStockValue());
					System.out.println("Unit:"+buyer.getUnit());
					System.out.println("Total stocks value:"+buyer.getTotalValue());
					System.out.println("Status:"+buyer.getStatus());
				}
				else
				{
					try {
							throw new StockMngmtExcpetion(name+"not Available");
					} catch (StockMngmtExcpetion e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("----------------------------------------");
				System.out.println();
			}
			else
			{
				try {
					throw new StockMngmtExcpetion("No Data Available");
				} catch (StockMngmtExcpetion e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			}catch (NullPointerException e) {
				
			}
		}
		
		
		
		for(BuyerDetails person:sale)
		{
			try{
			if(person!=null)
			{
				
				if(person.getBuyerName().equals(name))
				{
					System.out.println("Buyer Name:"+person.getBuyerName());
					System.out.println("Compny name:"+person.getCompanyName());
					System.out.println("Stock value:"+person.getStockValue());
					System.out.println("Unit:"+person.getUnit());
					System.out.println("Total stocks:"+person.getTotalValue());
					System.out.println("Status:"+person.getStatus());
				}
				else
				{
					try {
							throw new StockMngmtExcpetion(name+"not Available");
					} catch (StockMngmtExcpetion e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("----------------------------------------");
				System.out.println();
			}
			else
			{
				try {
					throw new StockMngmtExcpetion("No Data Available");
				} catch (StockMngmtExcpetion e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			}catch (NullPointerException e) {
				
			}
		}
		
	}
	
	public void compnyList()
	{
		System.out.println("==============>>>>>compnies available<<<<==============");
		StockDetails stocks[]=Stocklist.GetListObject();
		for(StockDetails stock:stocks)
		{
			try{
			if(stocks!=null)
			{
				System.out.println("Compny name:"+stock.getStockName());
				System.out.println("Stock value:"+stock.getStockValue());
				System.out.println("Total stocks:"+stock.getStockQuantity());
				System.out.println("----------------------------------------");
				System.out.println();
			}
			else
			{
				System.out.println("No companies available");
			}
			}catch (NullPointerException e) {
				
			}
		}
	}
	
	public static void mainMenu()
	{
		StockAccountLinkedlist stocks=new StockAccountLinkedlist();
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
					stocks.compnyList();
					break;
			case 6:
					stocks.printReport();
					
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
