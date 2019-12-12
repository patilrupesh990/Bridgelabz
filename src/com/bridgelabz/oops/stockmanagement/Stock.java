package com.bridgelabz.oops.stockmanagement;

public interface Stock
{
	 void StockAccount();
	 double ValueOf();
	 void buy(int amount,String symbol);
	 void sell(int amount,String symbol);
	 void save(String fileName);
	 void printReport();
}
