package com.bridgelabz.datastructure;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
/**
* Author: RupeshPatil
* Date: 28/11/2019
* Purpose:To Test Working modules of BalancedParenthese Based on stack 
**/
public class TestBalancedParenthes 
{
	/**To Check whether Expressions Are Balanced with parentheses or not**/
	@Test
	public void parenthesses_should_notbalanced_expr()
	{
		String result="";String expr="";
		
		expr="(a+b(a+c)";
		 result=com.bridgelabz.util.DataStructure.BalanaceParenthes(expr);
		assertTrue("not balanced", result!="balaced");
	}
	String expr2="";String result2="";
	public void parenthesses_should_balanced_expr2()
	{
		expr2="(a+b)*(a+b)/(c*f))";
		result2=com.bridgelabz.util.DataStructure.BalanaceParenthes(expr2);
		assertTrue("not balanced", result2!="balaced");
	}
	String expr3="";String result3="";
	public void parenthesses_should_notbalanced_expr3()
	{
		expr3="(a+b)*(a+b)";
		result3=com.bridgelabz.util.DataStructure.BalanaceParenthes(expr3);
		assertTrue("balanced", result3!="not balaced");
	}
	String expr4="";String result4="";
	public void parenthesses_should_notbalanced_expr4()
	{
		expr4="(5+6)+()+(())+((())";
		result4=com.bridgelabz.util.DataStructure.BalanaceParenthes(expr4);
		assertTrue("not balanced", result4!="balaced");
	}
	}


