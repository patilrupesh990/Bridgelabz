package com.bridgelabz.basiccoreprograms;

import java.util.InputMismatchException;

import com.bridgelabz.util.CorePrograms;
import com.bridgelabz.util.Utility;
/****************************************************************************************
 * @author Rupeshp007
 * since:16/11/2019
 * Purpos:Get prime factors of user given number it will take input frome user
 * virsion:1.0
 **************************************************************************************/
public class PrimeFactors 
{
       
	public static void main (String[] args) 
    {
		int number=0;
		
		System.out.println("Enter the number");
		try 
		{
			number=Utility.InputInt();
		}
		catch (InputMismatchException e) 
		{
			System.out.println("invalid input");
		}
		CorePrograms.primeFactors(number); 
    } 	  
	    
} 
	
	

