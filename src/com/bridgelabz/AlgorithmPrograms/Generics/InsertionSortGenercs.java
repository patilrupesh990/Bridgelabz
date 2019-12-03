package com.bridgelabz.AlgorithmPrograms.Generics;

import java.util.ArrayList;
/**
 * @author Rupeshp007
 * date:19/11/2019
 * Purpos:Sorting the Elements in ArrayList
 * Algorithm:Insertion Sort using Generic
 **********************************************************************************/

public class InsertionSortGenercs 
{

	public static void main(String[] args) 
	{
		ArrayList<String> al=new ArrayList<String>();
	
		System.out.println("How many words wants to insert??");
		int size=Utility.InputInt();
		
		System.out.println("Enter the words into list");
		for(int i=0;i<size;i++)
		{
			String s=Utility.InputString();
			al.add(s);
		}
		
		Utility.InsertionSort(al);
	}
	
}
