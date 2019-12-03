package com.bridgelabz.basiccoreprograms;


import java.util.InputMismatchException;

import com.bridgelabz.util.Utility;;

/**
* Author: RupeshPatil
* Date: 16/11/2019
* Purpose: to check Leap Year or not.
*  I/P -> Year, ensure it is a 4 digit number.
*  O/P -> Print the year is a Leap Year or not
************************************************************************/
public class LeapYear 
{
	static int year;
	public static void main(String[] args) 
	{
		
		
		System.out.println("Enter the the year");
		try {
		year=Utility.InputInt();
		}
		catch (InputMismatchException e) {
			System.out.println("Enter digits only");
		}
		
		if(year<0)
		{
			System.out.println("please Enter Positive values");
			year=Utility.InputInt();
		}
		
		Utility.isLeapYear(year);
	}
}
