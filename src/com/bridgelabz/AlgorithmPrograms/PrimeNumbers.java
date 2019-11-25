package com.bridgelabz.AlgorithmPrograms;
import com.bridgelabz.util.AlgorithmPrograms;

/**
 * @author Rupeshp007
 * date:19/11/2019
 * @version 1.0
 * Purpose:Find the list of prime numbers between 0 to 1000
 * 
 *  **/
public class PrimeNumbers 
{
	static AlgorithmPrograms primeno=new AlgorithmPrograms();
	public static void main(String[] args) 
	{
		System.out.println("Prime Numbers in Range of 0-1000");
		int min=0,max=1000;
		int temp[]=new int[600];
		int c=0;
		for(int i=min;i<=max;i++)
		{
			int count=0;
			for(int j=1;j<=i;j++)
			{
				if(i%j==0)
				{
					count++;
				}
			}
			if(count==2)
			{
				temp[c++]=i;
			}
		}
		
		int primes[]=new int[c];
		primes=temp;
		
		for(int i=0;i<c;i++)
		{
			System.out.println("  "+primes[i]);
		}
		//calling prime anagrams and palindrome function
				primeno.PrimePalindrome(primes);
		
		
		
		
		
	}
	
}
