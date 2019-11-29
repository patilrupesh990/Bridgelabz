package com.bridgelabz.DataStructurePrograms;
/*****************************************************************************************
* @Author: RupeshPatil
* @since: 25/11/2019
* @version :1.0
* @Purpose:Create a Program which creates Banking Cash Counter where people
* come in to deposit Cash and withdraw Cash. Have an input panel to add people
* to Queue to either deposit or withdraw money and dequeue the people. Maintain
* the Cash Balance.
******************************************************************************************/


import com.bridgelabz.util.DataStructure;
import com.bridgelabz.util.Utility;

public class CashCounter 
{
	
	public static void main(String[] args) 
	{
		
		Utility util=new Utility();	
		System.out.println("press S for start Counter");
		String start=util.InputString();
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
