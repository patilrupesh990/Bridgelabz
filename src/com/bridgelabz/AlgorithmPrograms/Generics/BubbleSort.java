package com.bridgelabz.AlgorithmPrograms.Generics;

import java.util.ArrayList;
/**
 * @author Rupeshp007
 * date:19/11/2019
 * Purpos:Sorting the Elements in ArrayList
 * Algorithm:Bubble Sort using  Generic
 ***********************************************/

public class BubbleSort 
{
	static Utility util=new Utility();
	public static void main(String[] args) 
	{
		ArrayList<Integer> al=new ArrayList<Integer>();
		
		System.out.println("Enter the how many elements want to insert?");
		int size=util.InputInt();
		
		System.out.println("Enter the Elements");
		for(int i=0;i<size;i++)
		{
			al.add(util.InputInt());
		}
		
		//calling BubbleSort Method
		util.BubbleSort(al);
		
		
		
	}
}
