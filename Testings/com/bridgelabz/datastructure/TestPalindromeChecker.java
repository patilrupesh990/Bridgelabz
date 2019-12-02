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
	@Test
	public void testStrigPalindromUsingDequeue() 
	{
		Utility util=new Utility();
		String message="madam";
		String result=util.isStringPalindrom(message);
		assertEquals("String is palindrome",result);
		
		 message="raman";
		result=util.isStringPalindrom(message);
		assertEquals("String is not palindrome",result);
		
		 message="121";
			result=util.isStringPalindrom(message);
			assertEquals("String is palindrome",result);
			
		message="123";
			result=util.isStringPalindrom(message);
			assertEquals("String is not palindrome",result);


	}

}
