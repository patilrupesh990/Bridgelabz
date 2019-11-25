package com.bridgelabz.functionalprograms;

import com.bridgelabz.util.Utility;

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
				for(int i=0;i<row;i++)
				{
					for(int j=0;j<colom;j++)
					{
						intArray[i][j]=util.InputInt();
					}
				}
				break;
			case 2:
				System.out.println("Enter elemnts in double Array");
				for(int i=0;i<row;i++)
				{
					for(int j=0;j<colom;j++)
					{
						doubleArray[i][j]=util.InputDouble();
					}
				}
				break;
			case 3:
				System.out.println("Enter elemnts in boolean Array");
				for(int i=0;i<row;i++)
				{
					for(int j=0;j<colom;j++)
					{
						booleanArray[i][j]=util.InputBoolean();
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
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<colom;j++)
			{
				System.out.print(" "+intArray[i][j]+" ");;
			}
			System.out.println();
		}
	}
	public static void print_DoubleArray(double array[][])
	{
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<colom;j++)
			{
				System.out.print(" "+doubleArray[i][j]+" ");;
			}
			System.out.println();
		}
	}
	public static void print_BooleanArray(boolean array[][])
	{
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<colom;j++)
			{
				System.out.print(" "+booleanArray[i][j]+" ");;
			}
			System.out.println();
		}
	}

 
}
