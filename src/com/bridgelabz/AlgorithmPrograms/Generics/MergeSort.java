package com.bridgelabz.AlgorithmPrograms.Generics;

import java.util.ArrayList;
/**
 * @author Rupeshp007
 * date:19/11/2019
 * Purpos:Sorting the Elements in ArrayList
 * Algorithm:Merge Sort using Generic
 **********************************************************************************/
public class MergeSort 
{
	static Utility util = new Utility();
	static ArrayList<String> al = new ArrayList<String>();

	public static void main(String[] args) {
		System.out.println("How many elements wants t insert??");
		int size = util.InputInt();
		
		System.out.println("Enter the elements");
		for (int i = 0; i < size; i++)
		{
			al.add(util.InputString());
		}
		
		al=util.MergeSort(al);
		
		System.out.println("Elements after MergeSort");
		for(String s:al)
		{
			System.out.println(s);
		}
			
	}
}
