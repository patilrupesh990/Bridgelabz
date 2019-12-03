package com.bridgelabz.AlgorithmPrograms;

import com.bridgelabz.util.AlgorithmPrograms;
import com.bridgelabz.util.Utility;
/**
 * @author Rupeshp007
 * date:18/11/2019
 * Purpos:Sorting the Elements in Array
 * Algorithm:Insertion Sort
 **************************************************/
public class InsertionSort 
{
	static String array[];
	
	static AlgorithmPrograms sort=new AlgorithmPrograms();
	
	public static void main(String[] args) 
	{
		System.out.println("Enter the Size of Array");
		int size=Utility.InputInt();
		
		System.out.println("Enter the elements in array");
		array=new String[size];
		
		array=sort.InsertElementInArray(array,size);
		AlgorithmPrograms.Insertionsort(array);
				
	}

}
