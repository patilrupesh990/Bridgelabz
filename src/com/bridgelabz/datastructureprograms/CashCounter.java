package com.bridgelabz.datastructureprograms;
/*************************************************************************************
 * purpose: Create a Program which creates Banking Cash Counter where people
 * come in to deposit Cash and withdraw Cash. Have an input panel to add people
 * to Queue to either deposit or withdraw money and dequeue the people. Maintain
 * the Cash Balance.
 * @author Rupeshp007
 * date:24/11/2019
 * @version 1.0
 * Operationas:
 * 1>Add People in Queue
 * 2>Deposite
 * 3>Withdraw
*****************************************************************************************/


import com.bridgelabz.util.DataStructure;
import com.bridgelabz.util.Utility;

public class CashCounter 
{
	
	public static void main(String[] args) 
	{
		
		
		System.out.println("press S for start Counter");
		String start=Utility.InputString();
		if(start.equals("s")||start.equals("S"))
		{
			System.out.println("How many people want to Add in Row??");
			int number=Utility.InputInt();
			DataStructure.StartCounter(number);
		}
		else
		{
			System.out.println("Invalid Option");
		}
	}
}
