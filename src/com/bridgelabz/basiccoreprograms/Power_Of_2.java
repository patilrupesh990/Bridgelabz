package com.bridgelabz.basiccoreprograms;

import com.bridgelabz.util.CorePrograms;

/*
* Author: RupeshPatil
* Date: 13/11/2019
Purpose:Power of 2
a. Desc -> This program takes a command-line argument N and prints a table of the
powers of 2 that are less than or equal to 2^N.
b. I/P -> The Power Value N. Only works if 0 <= N < 31 since 2^31 overflows an int
c. Logic -> repeat until i equals N.
d. O/P -> Print the year is a Leap Year or not.
**/


public class Power_Of_2 
{
	public static void main(String[] args) 
	{
		
		System.out.println("Enter the Number how many powers table?");
		
		int number=Integer.parseInt(args[0]);
		CorePrograms power=new CorePrograms();
		power.power(number);
	}
	
	
}
