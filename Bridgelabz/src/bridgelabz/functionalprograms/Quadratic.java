package com.bridgelabz.functionalprograms;

import com.bridgelabz.util.FunctionalPrograms;
import com.bridgelabz.util.Utility;

/**
* Author: RupeshPatil
* Date: 15/11/2019
Purpose:to find the roots of the Quadratic equation a*x*x + b*x + c.
Since the equation is x*x, hence there are 2 roots. The 2 roots of the equation
can be found using a formula  
 a, b and c as input values and find x roots
**/

public class Quadratic
{
	public static void main(String[] args) 
	{
		Utility util=new Utility();
		FunctionalPrograms quadratic=new FunctionalPrograms();
		System.out.println("Enter the value of a:");
		double a=util.InputDouble();
		System.out.println("Enter the value of b:");
		double b=util.InputDouble();
		System.out.println("Enter the value of c:");
		double c=util.InputDouble();
		quadratic.Find_Quadratic(a, b, c);
	}
}
