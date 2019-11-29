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
		Utility util=new Utility();
		
		System.out.println("Enter the the year");
		try {
		year=util.InputInt();
		}
		catch (InputMismatchException e) {
			System.out.println("Enter digits only");
		}
		
		if(year<0)
		{
			System.out.println("please Enter Positive values");
			year=util.InputInt();
		}
		
		if(year%4==0&&year%100!=0||year%400==0)
		{
			if(year>0)
			System.out.println(year+" Is LeapYear");
		}
		else
		{
			if(year>0)
			System.out.println(year+" Is Not LeapYear");
		}
		
	}
}
