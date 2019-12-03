package com.bridgelabz.AlgorithmPrograms;
import java.io.IOException;
import java.util.Arrays;

import com.bridgelabz.util.AlgorithmPrograms;
import com.bridgelabz.util.Utility;



/*****************************************************************************************
* @Author: RupeshPatil
* @since: 17/11/2019
* @version :1.0
* @Purpose:Read the words from comma separated file  and store in array and sort
* After sorting take the word input from user and search the word from array
* Algorithm:Binary search
******************************************************************************************/


public class BinarySearchWords 
{
	static String wordsarray[];
		public static void main(String[] args) throws IOException 
		{
			
			AlgorithmPrograms binary=new AlgorithmPrograms();
			
			String FileName="/home/user/Documents/Bridgelabz/src/com/bridgelabz/AlgorithmPrograms/BinarySearch.txt";
			binary.ReadFile(FileName);
			
			wordsarray=binary.ReadFile(FileName);
			Arrays.sort(wordsarray);
			
			for(String word:wordsarray)
			{
				System.out.println(word);
			}
			
			System.out.println("Enter the word you Want to Search");
			String word=Utility.InputString();
			
			
			int index=binary.searchString(wordsarray,word);
			
			if(index>=0)
			{
				System.out.println("word found at "+index+" th location" );
			}
			else
			{
				System.out.println("Word not found");
			}			
		}
}
