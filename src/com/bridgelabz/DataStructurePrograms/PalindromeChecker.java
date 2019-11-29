package com.bridgelabz.DataStructurePrograms;


import com.bridgelabz.util.Dequeueimpl;
import com.bridgelabz.util.Utility;

public class PalindromeChecker 
{
	public static void main(String[] args) 
	{
		Utility util=new Utility();
		Dequeueimpl<Character> dequeu=new Dequeueimpl<Character>();
		System.out.println("Enter a String: ");
		String s=util.InputString();

		//adding each character to the rear of the deque
		for(int i=0;i<s.length();i++)
		{
			char c =s.charAt(i);
			dequeu.addRear(c);
		}
		int flag=0;

		while(dequeu.size()>1)
		{
			if(dequeu.removeFront()!=dequeu.removeRear())
			{
				flag=1;
				break;
			}
		}

		if(flag==0)
		{
			System.out.println("String is palindrome");
		}
		else
		{
			System.out.println("String is not palindrome");
		}
	}
}
