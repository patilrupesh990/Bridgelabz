package com.bridgelabz.AlgorithmPrograms.Generics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
/*
* Author: RupeshPatil
* Date: 19/11/2019
* Purpose:Read the words from comma separated file  and store in array and sort
* After sorting take the word input from user and search the word from ArrayList
* Algorithm:Binary search using Generic 
**/

public class BinarySearch {
	static Utility util = new Utility();
	static ArrayList<String> al=new ArrayList<String>();
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws IOException {
		String FileName = "E:\\project p\\BinarySearch.txt";
		al=util.ReadFile(FileName);
		@SuppressWarnings("unchecked")
		SortedSet sorted = new TreeSet(al);
		Iterator it = sorted.iterator();

	      while (it.hasNext()) {
	         // Get element
	         Object element = it.next();
	         System.out.println(element.toString());
	      }
	      System.out.println("Enter the word you Want to Search");
			String word=util.InputString();
			util.SearchWord(sorted,word);

	      

		
		

	}
}
