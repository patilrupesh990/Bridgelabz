package com.bridgelabz.datastructure;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bridgelabz.util.Utility;

/**
* Author: RupeshPatil
* Date: 28/11/2019
* Purpose:To Test Working modules of String Palindrome checker program
***********************************************************************/

public class TestPalindromeChecker {

	/**To test String is palindrome or not module**/
	String message;
	String result;
	@Test
	public void When_Strig_is_madam_then_String_should_palindrome() 
	{
		
		String message="madam";
		String result=Utility.isStringPalindrom(message);
		assertEquals("String is palindrome",result);
	}
	
	public void When_Strig_is_raman_then_String_should_palindrome() 
	{
		 message="raman";
		result=Utility.isStringPalindrom(message);
		assertEquals("String is not palindrome",result);
	}	
	public void When_Strig_is_121_then_String_should_palindrome() 
	{
		 message="121";
			result=Utility.isStringPalindrom(message);
			assertEquals("String is palindrome",result);
	}
	public void When_Strig_is_123_then_String_should_palindrome() 
	{
		message="123";
			result=Utility.isStringPalindrom(message);
			assertEquals("String is not palindrome",result);
	}


}
