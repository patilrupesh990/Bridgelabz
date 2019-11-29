package com.bridgelabz.AlgorithmPrograms;

import com.bridgelabz.util.AlgorithmPrograms;
import com.bridgelabz.util.Utility;

/**
 * @author Rupeshp007
 * date:18/11/2019
 * Purpos:Sorting the Elements in Array
 * Algorithm:Bubble Sort
 **/
public class BubbleSort 
{
	static int size=0;
	static int array[];
	
	public static void main(String[] args) 
	{
		Utility util=new Utility();
		AlgorithmPrograms bubble=new AlgorithmPrograms();
		System.out.println("Enter the Size Of Array");
		size=util.InputInt();
		System.out.println("Enter the Elements in Array");
		array=new int[size];
		for(int i=0;i<size;i++)
		{
			array[i]=util.InputInt();
		}
		bubble.BubbleSort(array);
	}
}
