package com.bridgelabz.DataStructurePrograms;

import com.bridgelabz.util.DataStructure;
import com.bridgelabz.util.Day;
import com.bridgelabz.util.DayOfWeek;
import com.bridgelabz.util.LinkedListiml;
import com.bridgelabz.util.Utility;

public class CalenderUsingQueueLinkedList 
{
	public static void main(String[] args) {
	
		Utility util=new Utility();
	
	Day sunday = new Day(DayOfWeek.SUNDAY);
    Day monday = new Day(DayOfWeek.MONDAY);
    Day tuesday = new Day(DayOfWeek.TUESDAY);
    Day wednesday = new Day(DayOfWeek.WEDNESDAY);
    Day thursday = new Day(DayOfWeek.THURSDAY);
    Day friday = new Day(DayOfWeek.FRIDAY);
    Day saturday = new Day(DayOfWeek.SATURDAY);

    Day day[] = new Day[7];
    day[0] = sunday;
    day[1] = monday;
    day[2] = tuesday;
    day[3] = wednesday;
    day[4] = thursday;
    day[5] = friday;
    day[6] = saturday;
	LinkedListiml<Day> list=new LinkedListiml<Day>();
	for(int i=0;i<7;i++)
	{
		list.add(day[i]);
		list.add2Queue();;
	}
	
	System.out.println("Eneter the year");
	int year=util.InputInt();
	System.out.println("Enter the month ");
	int month=util.InputInt();
	int d=DataStructure.day(month, 1, year);
	System.out.println(d);
	}
}
