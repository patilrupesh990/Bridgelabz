package com.bridgelabz.datastructureprograms;

import java.util.function.Predicate;

import com.bridgelabz.util.DataStructure;
import com.bridgelabz.util.Utility;
/**
 * @author Rupeshp007
 * date:27/11/2019
 * Purpos:To show monthly calenders based on user requirements like july 2017 in that user will give year and month as input.
 * Algorithm:Insertion Sort using Generic
 **********************************************************************************/
public class Calender 
{
	static int year,month;
	static Utility util=new Utility();
	public static void main(String[] args) 
	{
		year=Integer.parseInt(args[0]);
		month=Integer.parseInt(args[1]);
		
		String months[]= {"january","february","march","April","May","Jun","July","Aug","sept","Octomber","November","December"};
		int days[]= {31,28,31,30,31,30,31,31,30,31,30,31};
		
		//java * predicate Fuction for check year is leap year or not
		 Predicate<Integer>p=year->((year%4==0&&year%100!=0)||year%400==0);
		 
		if(month==2 &&p.test(year))
			days[1]=29;
		else
			days[1]=28;
		
		System.out.println("\t\t"+months[month-1]+","+year);
		System.out.println("=======================================================");
		System.out.println("S\tM\tT\tW\tT\tF\tS");
		System.out.println();
		
		int day=DataStructure.day(month, 1, year);
		
		for (int index = 0; index < day; index++)
	            System.out.print("\t");
	        for (int index = 1; index <= days[month-1]; index++) {
	            System.out.print(index+"\t");
	            if (((index + day) % 7 == 0) || (index == days[month-1])) 
	            	System.out.println();   	
	            
	        }
	}
}
