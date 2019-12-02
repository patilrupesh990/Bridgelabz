package com.bridgelabz.DataStructurePrograms;
import com.bridgelabz.util.Utility;

/**
 * to check whether string is Palindrom or not.
 * @author Rupeshp007
 * @since 29/11/2019
 */
public class PalindromeChecker 
{
	public static void main(String[] args) 
	{
		Utility util=new Utility();
		System.out.println("Enter a String: ");
		String string=util.InputString();
		
		//isStringPalindrom is palindrom checker method using dequeue
		String result=util.isStringPalindrom(string);
		System.out.println(result);
	}
}
