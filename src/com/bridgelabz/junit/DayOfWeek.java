package com.bridgelabz.junit;

import com.bridgelabz.util.DataStructure;
import com.bridgelabz.util.Utility;
/**
 * @author Rupeshp007
 * date:28/11/2019
 * Purpos:To DAY OF WEEK based on user requirements like july 2017 in that user will give year and month as input.
 * Algorithm:Insertion Sort using Generic
 **********************************************************************************/
public class DayOfWeek
{
	static int year,month,day;
	static Utility util=new Utility();
	public static void main(String[] args) 
	{
		year=Integer.parseInt(args[0]);
		month=Integer.parseInt(args[1]);
		day=Integer.parseInt(args[2]);
		
		String days[]= {"sunday","monday","tueday","wednesday","thusday","friday","saturday"};

		int d=DataStructure.day(month, day, year);
		System.out.println(days[d]);
	}
}
