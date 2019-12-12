package com.bridgelabz.oops.stockmanagement;

public interface Stock
{
	 void stockAccount();//complete
	 double ValueOf();//reamaining
	 void buy(int amount,String symbol);  
	 void sell(int amount,String symbol);
	
	 void printReport();
}
