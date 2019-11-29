package com.bridgelabz.basiccoreprograms;

import java.util.InputMismatchException;

import com.bridgelabz.util.CorePrograms;

/**
* Author: RupeshPatil
* Date: 16/11/2019
* Purpose:Power of 2 This program takes a command-line argument N and prints a table of the
* powers of 2 that are less than or equal to 2^N.
* O/P -> Print the year is a Leap Year or not.
*********************************************************************************************/

public class Power_Of_2 
{
	public static void main(String[] args) 
	{
		int number=0;
		System.out.println("Enter the Number how many powers table?");
		try
		{
			 number=Integer.parseInt(args[0]);
			if(number<0)
			{
				System.out.println("Negative number not allowed please enter positive");
				 number=Integer.parseInt(args[0]);
			}
		}
		catch (InputMismatchException e) 
		{
			System.out.println("inavlid input");
		}
		CorePrograms power=new CorePrograms();
		power.power(number);
	}
	
	
}
