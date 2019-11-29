package com.bridgelabz.functionalprograms;

import com.bridgelabz.util.Utility;
/**********************************************************************************************************
* Created by:	Rupesh Patil
* Date:  		16/11/2019
* Purpose: 		Developed Two Dimentional array based on user input e.g Row Size Column Size
* 				and datatypes.
***********************************************************************************************************/

public class TwoDimentional_Array
{
	static int row,colom;
	static Utility util=new Utility();
	static int intArray[][];
	static double doubleArray[][];
	static boolean booleanArray[][];
	
	static 
	{
		System.out.println("2 Dimentional Array Input");
		System.out.println("Enter the Size of Row");
		 row=util.InputInt();
		System.out.println("Enter the Size of Row");
		 colom=util.InputInt();
	}
	
	public static void main(String args[])
	{
		 intArray=new int[row][colom];
		 doubleArray=new double[row][colom];
		 booleanArray=new boolean[row][colom];
		System.out.println("Which Type Data Want to insert press 1 for Integer press 2 for double 3 for boolean");
		int choice=util.InputInt();
		switch(choice)
		{
			case 1:
					System.out.println("Enter elemnts in integer Array");
				for(int index1=0;index1<row;index1++)
				{
					for(int index2=0;index2<colom;index2++)
					{
						intArray[index1][index2]=util.InputInt();
					}
				}
				break;
			case 2:
				System.out.println("Enter elemnts in double Array");
				for(int index1=0;index1<row;index1++)
				{
					for(int index2=0;index2<colom;index2++)
					{
						doubleArray[index1][index2]=util.InputDouble();
					}
				}
				break;
			case 3:
				System.out.println("Enter elemnts in boolean Array");
				for(int index1=0;index1<row;index1++)
				{
					for(int index2=0;index2<colom;index2++)
					{
						booleanArray[index1][index2]=util.InputBoolean();
					}
				}
				break;
			default:
						System.out.println("Invalide Input:");
		}
		System.out.println("Which Type Array want to print press 1 for Integer press 2 for double 3 for boolean");
		int choice2=util.InputInt();
		switch(choice2)
		{
			case 1:
					System.out.println("elemnts in integer Array");
					TwoDimentional_Array.print_IntArray(intArray);
							break;
			case 2:
				System.out.println("elemnts in double Array");
				TwoDimentional_Array.print_DoubleArray(doubleArray);
				break;
			case 3:
				System.out.println("elemnts in boolean Array");
				TwoDimentional_Array.print_BooleanArray(booleanArray);
				break;
			default:
						System.out.println("Invalide Input:");
		}
	}
	
	public static void print_IntArray(int array[][])
	{
		for(int index1=0;index1<row;index1++)
		{
			for(int index2=0;index2<colom;index2++)
			{
				System.out.print(" "+intArray[index1][index2]+" ");;
			}
			System.out.println();
		}
	}
	public static void print_DoubleArray(double array[][])
	{
		for(int index1=0;index1<row;index1++)
		{
			for(int index2=0;index2<colom;index2++)
			{
				System.out.print(" "+doubleArray[index1][index2]+" ");;
			}
			System.out.println();
		}
	}
	public static void print_BooleanArray(boolean array[][])
	{
		for(int index1=0;index1<row;index1++)
		{
			for(int index2=0;index2<colom;index2++)
			{
				System.out.print(" "+booleanArray[index1][index2]+" ");;
			}
			System.out.println();
		}
	}

 
}
