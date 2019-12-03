package com.bridgelabz.basiccoreprograms;
import com.bridgelabz.util.*;
/**
* Author RupeshPatil
* Date: 16/11/2019
* Purpose:Harmonic Number Prints the Nth harmonic number: 1/1 + 1/2 + ... + 1/N
*  O/P -> Print the Nth Harmonic Value.
**************************************************************************************/


public class Harmonic_Number 
{
	public static void main(String[] args) 
	{	
		
		CorePrograms harmonic=new CorePrograms();
		
		System.out.println("Enter the Number till you want Harmonic");
		int  number=Utility.InputInt();
		if(number==0)
		{
			System.out.println("please enter the number more than 0");
			number=Utility.InputInt();
		}
		harmonic.Harmonic(number);	
	}

}
