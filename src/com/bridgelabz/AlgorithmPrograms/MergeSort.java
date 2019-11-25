package com.bridgelabz.AlgorithmPrograms;
import com.bridgelabz.util.AlgorithmPrograms;
import com.bridgelabz.util.Utility;
/**
 * @author Rupeshp007
 * date:19/11/2019
 * Purpos:Sorting the Sring Elements in Array
 * Algorithm:Merge Sort
 **/
public class MergeSort 
{
	static int size;
	static String array[];
	public String[] getArray()
	{
		return array;
	}
	public static void main(String[] args) 
	{
		AlgorithmPrograms sort=new AlgorithmPrograms();
		Utility util=new Utility();
		System.out.println("Enter the Size of array");
		size=util.InputInt();
		array=new String[size];
		System.out.println("Enter The Elemetns");
		array=sort.InsertElementInArray(array, size);
		
		array=sort.MergeSort(array);
		for(int i=0;i<array.length;i++)
		{
			System.out.println("O/P after MergeSort Apply  :"+array[i]);
		}
	}
}
