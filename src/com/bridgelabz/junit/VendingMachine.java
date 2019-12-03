package com.bridgelabz.junit;

import com.bridgelabz.util.Utility;

/**
 * @author Rupeshp007
 * date:28/11/2019
 * Purpos:The program for money wending it wil count how many minimum notes need for transaction
 * it will count in terms of 1000,500,100,50,10,5,2,1 notes.
 **********************************************************************************/

public class VendingMachine 
{
	static int i=0;
  	

  	//Initialization of New Array
  	static int[] notes = { 1000,500,100,50,10,5,2,1};
  	static int money;
  	static int total=0;
  	// Function for Calculating the notes
  	public static  int calculate(int money,int[]notes )
  	{
  		//calling calculate Function
  		
        int rem;
		if(money==0)
		{
			return total ;
		}
		else
		{
			if(money>=notes[i])
			{
				// logic for Calculating The notes
				int calNotes =money/notes[i];
				rem = money%notes[i];
				money =rem;
				total += calNotes;
				System.out.println(notes[i]+   " Notes ---> " +calNotes );
			}
			i++;
			return calculate(money, notes);
		}
	}//end of method

  	// Starting Main Function
	public static void main(String[] args)
	{

		//ask the user enter the money
		System.out.print("Enter the Amount:");
		money =Utility.InputInt();

		// Creating The Object of Vending MAchine class
		int total=VendingMachine.calculate(money,notes);
		System.out.println("Total Number of Notes are :"+total);
	}
	
}
