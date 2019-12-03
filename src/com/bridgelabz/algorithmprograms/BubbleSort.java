package com.bridgelabz.algorithmprograms;

import com.bridgelabz.util.AlgorithmPrograms;
import com.bridgelabz.util.Utility;

/**
 * @author Rupeshp007
 * date:18/11/2019
 * Purpos:Sorting the Elements in Array
 * Algorithm:Bubble Sort
 ***************************************************/
public class BubbleSort 
{
	static int size=0;
	static int array[];
	
	public static void main(String[] args) 
	{

		AlgorithmPrograms bubble=new AlgorithmPrograms();
		
		
		System.out.println("Enter the Size Of Array");
		size=Utility.InputInt();
		
		System.out.println("Enter the Elements in Array");
		array=new int[size];
		
		for(int index=0;index<size;index++)
		{
			array[index]=Utility.InputInt();
		}
		
		bubble.BubbleSort(array);
	}
}
