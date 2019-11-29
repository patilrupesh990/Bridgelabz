package com.bridgelabz.basiccoreprograms;


import com.bridgelabz.util.Utility;;

/*
* Author: RupeshPatil
* Date: 13/11/2019
Purpose:Leap Year
a. I/P -> Year, ensure it is a 4 digit number.
b. Logic -> Determine if it is a Leap Year.
c. O/P -> Print the year is a Leap Year or not
**/
public class LeapYear 
{
	public static void main(String[] args) 
	{
		Utility util=new Utility();
		//Pattern pattern = Pattern.compile("(\\d{4})");
		int year;
		
		System.out.println("Enter the the year");
		year=util.InputInt();
		//if(pattern.matcher(year).matches())
		
		if(year%4==0&&year%100!=0||year%400==0)
		{
			System.out.println(year+" Is LeapYear");
		}
		else
		{
			System.out.println(year+" Is Not LeapYear");
		}
		
	}
}
