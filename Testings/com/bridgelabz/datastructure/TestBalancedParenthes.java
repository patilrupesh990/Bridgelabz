package com.bridgelabz.datastructure;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestBalancedParenthes 
{
	@Test
	public void BalancedParenthesTest()
	{
		String result="";String expr="";
		
		expr="(a+b(a+c)";
		 result=com.bridgelabz.util.DataStructure.BalanaceParenthes(expr);
		assertTrue("not balanced", result!="balaced");
		
		expr="(a+b)*(a+b)/(c*f))";
		result=com.bridgelabz.util.DataStructure.BalanaceParenthes(expr);
		assertTrue("not balanced", result!="balaced");
		
		expr="(a+b)*(a+b)";
		result=com.bridgelabz.util.DataStructure.BalanaceParenthes(expr);
		assertTrue("balanced", result!="not balaced");
		
		expr="(5+6)+()+(())+((())";
		result=com.bridgelabz.util.DataStructure.BalanaceParenthes(expr);
		assertTrue("not balanced", result!="balaced");
	}

}
