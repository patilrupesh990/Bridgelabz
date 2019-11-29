package com.bridgelabz.AlgorithmPrograms;
import com.bridgelabz.util.AlgorithmPrograms;
import com.bridgelabz.util.Utility;
/**
 * @author Rupeshp007
 * date:19/11/2019
 * @version 1.0
 * Purpose:For check given two Strings are anarams or not eg. "earth" and "heart" this strings are anagrams 
 *  takes two input from user String1 and String2
 **********************************************************************************************************/

public class StringAnagram 
{
	static AlgorithmPrograms anagram=new AlgorithmPrograms();
	static Utility util=new Utility();
	public static void main(String[] args) 
	{
		System.out.println("Enter the First String");
		String string1=util.InputString();
		
		System.out.println("Enter the First String");
		String string2=util.InputString();
		
		char[] chararray1=string1.toCharArray();
		char[] chararray2=string2.toCharArray();
		
		anagram.Anagram(chararray1,chararray2);
		
	}
	
}
