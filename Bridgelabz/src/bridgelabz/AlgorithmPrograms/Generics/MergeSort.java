package com.bridgelabz.AlgorithmPrograms.Generics;

import java.util.ArrayList;

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
