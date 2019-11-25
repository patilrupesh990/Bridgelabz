package com.bridgelabz.basiccoreprograms;
import com.bridgelabz.util.*;
/**
 Author RupeshPatil
* Date: 13/11/2019
Purpose:Harmonic Number
a. Desc -> Prints the Nth harmonic number: 1/1 + 1/2 + ... + 1/N
(http://users.encs.concordia.ca/~chvatal/notes/harmonic.html).
b. I/P -> The Harmonic Value N. Ensure N != 0
c. Logic -> compute 1/1 + 1/2 + 1/3 + ... + 1/N
d. O/P -> Print the Nth Harmonic Value.
**/


public class Harmonic_Number 
{
	public static void main(String[] args) 
	{	
		Utility util=new Utility();
		CorePrograms harmonic=new CorePrograms();
		
		System.out.println("Enter the Number till you want Harmonic");
		int  number=util.InputInt();
		if(number==0)
		{
			System.out.println("please enter the number more than 0");
			number=util.InputInt();
		}
		harmonic.Harmonic(number);	
	}

}
