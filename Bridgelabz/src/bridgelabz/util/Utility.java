 package com.bridgelabz.util;

import java.util.Scanner;
/**
* Created by:Rupesh Patil
* Date: 11/06/2016
* Purpose: Putting Commonly used function in single file.
	1 function to take word,integer and double as input
	2: function to read and write file.
	3 function to match regex from string and replace with user details	 
**/

public class Utility 
{
	//util class initilization
	public static Scanner scanner=new Scanner(System.in);
	static Utility util=new Utility();
	
	
	/**Redymade input methods using Scanner class**/
	
	/*************************** 
	 * for take Integer input  *
	 * @param no param         *
	 * @return integer         *
	 **************************/
	
	public int InputInt()
	{
		int int_variable=scanner.nextInt();
		return int_variable;
	}
	/** for take Float input
	 * @param no param
	 * @return float
	 ***/
	
	
	
	public float InputFloat()
	{
		float float_varialble=scanner.nextFloat();
		
		return float_varialble;
	}
	
	/** for take Character input
	 * @param no param
	 * @return character
	 * **/
	
	public char InputChar()
	{
		char char_variable=scanner.next().charAt(0); 
		return char_variable;
	}
	
	/** for take String input from scanner
	 * @param no param
	 * @return String
	 * **/
	public String InputString()
	{
		String string_variable=scanner.next(); 
		return string_variable;
	}
	
	/** for take Double input
	 * @param no param
	 * @return double
	 * **/
	public double InputDouble()
	{
		double double_variable=scanner.nextDouble();
		
		return double_variable;
	}
	
	/** for take Boolean input
	 * @param no param
	 * @return boolean
	 * **/
	public boolean InputBoolean()
	{
		boolean boolean_variable=scanner.nextBoolean();
		return boolean_variable;
	}
//end of input methods
}
