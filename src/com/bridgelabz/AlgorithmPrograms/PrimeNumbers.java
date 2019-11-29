package com.bridgelabz.AlgorithmPrograms;
import com.bridgelabz.util.AlgorithmPrograms;

/**
 * @author Rupeshp007
 * date:19/11/2019
 * @version 1.0
 * Purpose:Find the list of prime numbers between 0 to 1000
 ***********************************************************************/
public class PrimeNumbers 
{
	static AlgorithmPrograms primeno=new AlgorithmPrograms();
	public static void main(String[] args) 
	{
		int min=0,max=1000,index=0;
		int temp[]=new int[600];
				
		System.out.println("Prime Numbers in Range of 0-1000");
		
		
		for(int number1=min;number1<=max;number1++)
		{
			int count=0;
			for(int number2=1;number2<=number1;number2++)
			{
				if(number1%number2==0)
				{
					count++;
				}
			}
			if(count==2)
			{
				temp[index++]=number1;
			}
		}
		
		int primes[]=new int[index];
		primes=temp;
		
		for(int index2=0;index2<index;index2++)
		{
			System.out.println("  "+primes[index2]);
		}
		//calling prime anagrams and palindrome function
				primeno.PrimePalindrome(primes);
		
	}
	
}
