package com.bridgelabz.datastructureprograms;
/*****************************************************************************************
* @Author: RupeshPatil
* @since: 25/11/2019
* @version :1.0
* @Purpose:To Manage Cashcounter queue using Queue.
******************************************************************************************/


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
			DataStructure.StartCounter();
		}
		else
		{
			System.out.println("Invalid Option");
		}
	}
}
