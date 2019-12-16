package com.bridgelabz.oops.stockmanagement;

import com.bridgelabz.util.LinkedListiml;
import com.bridgelabz.util.Utility;

public class StockAccountLinkedlist extends Object
{
	LinkedListiml<StockDetails> Stocklist=new LinkedListiml<>();
	LinkedListiml<StockDetails> Buyerlist=new LinkedListiml<>();
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
		System.out.println("Enter Company name :");
		String name=Utility.InputString();
		System.out.println("Enter How many Stocks want to buy");
		int unit=Utility.InputInt();
		System.out.println("Enter Amount :");
		int amount=Utility.InputInt();
		
		StockDetails stocks[]=Stocklist.GetListObject();
		for(StockDetails object:stocks)
		{
			if(object.getStockName().equals(name))
			{
				int value=object.getStockValue();
				int buyUnit=amount/value;
				int availableunit=object.getStockQuantity();
				int result=availableunit-buyUnit;
				object.setStockQuantity(result);
				Stocklist.removeNode(object);
				Stocklist.add(object);
			}
		}
	}
	
	public void SellStock()
	{
		System.out.println("Enter Company name :");
		String name=Utility.InputString();
		System.out.println("Enter How many Stocks want to Sell");
		int unit=Utility.InputInt();
		
		StockDetails stocks[]=Stocklist.GetListObject();
		for(StockDetails object:stocks)
		{
			if(object.getStockName().equals(name))
			{
				int value=object.getStockValue();
				int amount=value*unit;
				int availableunit=object.getStockQuantity();
				int result=availableunit+unit;
				object.setStockQuantity(result);
				Stocklist.removeNode(object);
				Stocklist.add(object);
				System.out.println(amount+" You have recieved after sell"+unit+" stocks");
			}
			else
			{
				System.out.println("invalid company name");
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
	public static void main(String[] args) 
	{
		StockAccountLinkedlist stocks=new StockAccountLinkedlist();
		while(true)
		{
			System.out.println("1. add 2 remove 3.buy 4.sell 5.display 6.exit");
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
			case 5:
					stocks.compnyList();
					break;
					
			case 6:
					System.exit(0);;
			}
		}
	}
}
