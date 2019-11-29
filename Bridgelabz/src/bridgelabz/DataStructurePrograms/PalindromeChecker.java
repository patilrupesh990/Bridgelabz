package com.bridgelabz.DataStructurePrograms;


import com.bridgelabz.util.Dequeue;
import com.bridgelabz.util.Utility;

public class PalindromeChecker 
{
	static Utility util=new Utility();
	public static void main(String[] args) 
	{
		System.out.println("Enter the String:");
		String string=util.InputString();
		char[] characters=string.toCharArray();
		for(int i=characters.length-1;i>=0;i--)
		{
			Dequeue.addRear(characters[i]);
		}
		
	}
}
