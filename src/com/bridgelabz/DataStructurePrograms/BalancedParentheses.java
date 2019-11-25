package com.bridgelabz.DataStructurePrograms;

import com.bridgelabz.util.DataStructure;
import com.bridgelabz.util.Stack;
import com.bridgelabz.util.Utility;

/*************************************************************************************
 * purpose: Take an Arithmetic Expression such as
 * (5+6)*(7+8)/(4+3)(5+6)+(7+8)/(4+3) where parentheses are used to order the
 * performance of operations.
 * @author Rupeshp007
 * date:23/11/2019
 * @version 1.0
*****************************************************************************************/
public class BalancedParentheses 
{
	static Utility util=new Utility();
	public static void main(String[] args) 
	{
		System.out.println("This is Program for BalancedParentheses");
		
		System.out.println("enter Expression like (5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3) it will check parenthes are balanced or not");
		String exprs=util.InputString();
		
		int size=exprs.length();
		Stack.setStackSize(size);
		
		String result=DataStructure.BalanaceParenthes(exprs);
		System.out.println(result);
		
	}
}
