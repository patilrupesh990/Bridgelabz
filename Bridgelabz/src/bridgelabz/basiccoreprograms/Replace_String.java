package com.bridgelabz.basiccoreprograms;

import com.bridgelabz.util.Utility;;



/**
* Author: RupeshPatil
* Date: 13/11/2019
Purpose:User Input and Replace String Template “Hello <<UserName>>, How are you?”
a. I/P​ -> Take User Name as Input. ​ Ensure UserName has min 3 char
b. Logic​ -> Replace <<UserName>> with the proper name
c. O/P​ -> Print the String with User Name
**/

public class Replace_String 
{
	static Utility u=new Utility();
	
	public static void main(String[] args) 
	{
		String user_name;
		String user_name2;
		String user_name3;
		
		System.out.println("Enter User Name");
		user_name=u.InputString();
		
		if(user_name.length()<3)
		{
			System.out.println("Please enter minimum 3 character");
			user_name=u.InputString();
		}
		
		
		user_name2 = "“Hello "+user_name+", How are you?”";		
		// COMPUTATION
		 user_name3 = user_name.replace(user_name, user_name2);
		 
		// OUTPUT
			System.out.println(user_name3);
	}
}
