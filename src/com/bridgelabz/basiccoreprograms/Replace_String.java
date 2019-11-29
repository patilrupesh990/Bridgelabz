package com.bridgelabz.basiccoreprograms;

import java.util.InputMismatchException;

import com.bridgelabz.util.Utility;;



/**
* Author: RupeshPatil
* Date: 16/11/2019
* Purpose:Take User Name as Input User Input and Replace String Template “Hello <<UserName>>, How are you?”
* Print the String with User Name
***************************************************************************************************************/

public class Replace_String 
{
	static Utility u=new Utility();
	
	public static void main(String[] args) 
	{
		String user_name ="";
		String user_name2;
		String user_name3;
		
		System.out.println("Enter User Name");
		try
		{
		user_name=u.InputString();
		}
		catch (InputMismatchException e) 
		{
			// TODO: handle exception
			System.out.println("Enter name only numbers not allowedd");
		}
		
		if(user_name.length()<3)
		{
			System.out.println("Please enter minimum 3 character");
			try
			{user_name=u.InputString();}
			
			catch(InputMismatchException e)
			{System.out.println("invalid input");}
		}
		
		
		user_name2 = "“Hello "+user_name+", How are you?”";		
		// COMPUTATION
		 user_name3 = user_name.replace(user_name, user_name2);
		 
		// OUTPUT
			System.out.println(user_name3);
	}
}
