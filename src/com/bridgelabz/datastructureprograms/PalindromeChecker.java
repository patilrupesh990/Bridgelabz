package com.bridgelabz.datastructureprograms;
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
		
		System.out.println("Enter a String: ");
		String string=Utility.InputString();
		
		//isStringPalindrom is palindrom checker method using dequeue
		String result=Utility.isStringPalindrom(string);
		System.out.println(result);
	}
}
