package com.bridgelabz.basiccoreprograms;
import java.util.InputMismatchException;

import com.bridgelabz.util.*;


/**
*********************************************************************************
* Author: RupeshPatil
* Date: 16/11/2019
* Purpose:User Input and Replace String Template “Hello <<UserName>>, How are you?”
*  O/P​ -> Print the String with User Name
*******************************************************************************************/

public class Flip_coin
{
	public static void main(String[] args) 
	{
		
		CorePrograms toss=new CorePrograms();
				
		int choice=0;	   
		
		
		System.out.println("Welcome to the coin flip game!");

		do
		{
			System.out.println("Enter '1' to Flip Coin OR Enter '0' to Quit: ");
			try {
			choice = Utility.InputInt();
			}
			catch (InputMismatchException e) {
				System.out.println("invalid input");
			}
			
			
			if (choice == 1){
				toss.flipcoin();
			}
			else if (choice > 1){
				System.out.println("Invalid entry - please enter 1 or 0: ");
				try {
				choice = Utility.InputInt();}
				catch (Exception e) {
					System.out.println("Invalid input");
				}
				}
			else
			{
				System.exit(0);
			}

		}
	while (choice != 0);
	}
}