package com.bridgelabz.basiccoreprograms;
import com.bridgelabz.util.*;


/*
* Author: RupeshPatil
* Date: 13/11/2019
Purpose:User Input and Replace String Template “Hello <<UserName>>, How are you?”
a. I/P​ -> Take User Name as Input. ​ Ensure UserName has min 3 char
b. Logic​ -> Replace <<UserName>> with the proper name
c. O/P​ -> Print the String with User Name
**/

public class Flip_coin
{
	public static void main(String[] args) 
	{
		
		CorePrograms toss=new CorePrograms();
		Utility u=new Utility();		
		int choice;	   
		
		
		System.out.println("Welcome to the coin flip game!");

		do
		{
			System.out.println("Enter '1' to Flip Coin OR Enter '0' to Quit: ");
			choice = u.InputInt();

			if (choice == 1)
			{
				toss.flipcoin();
			}
			else if (choice > 1)
			{
				System.out.println("Invalid entry - please enter 1 or 0: ");
				choice = u.InputInt();
			}
			else
			{
				System.exit(0);
			}

		}
	while (choice != 0);
	}
}