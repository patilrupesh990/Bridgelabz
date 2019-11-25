package com.bridgelabz.util;

import java.util.Random;
public class CorePrograms 
{
	/**
	 * logic for flip coin and gives the o/p in term os head and tail.
	 *  @param no param
	 *  @return void
	 */
	private enum Coin{Heads, Tails};
	static int result;
	static int loss;
	static int win;
	static int Totalgames;
	Coin coinFlip;
	public void flipcoin()
	{
		
		Random randomNum = new Random();
		 
		result = randomNum.nextInt(2);

		if(result == 0)
		{
		   ++win;
		   ++Totalgames;
			coinFlip = Coin.Heads;
		   System.out.println("You flipped Heads!");
		   System.out.println("You won "+win+" times");
		   System.out.println("Winning percentage: "+(win/Totalgames)*100);
		   
		}
		else
		{
			++loss;
			++Totalgames;
		   coinFlip = Coin.Tails;
		   System.out.println("You flipped Tails!");
		   System.out.println("You loss "+loss+" times");
		   System.out.println("loss percentage: "+(loss/Totalgames)*100);
		}
	}
	/**
	 * logic for flip coin and gives the o/p in term os head and tail.
	 *  @param no param
	 *  @return void
	 */
	
	public void Harmonic(int number)
	{
		double result=0;
		for(int i=1;i<=number;i++)
		{
			 result=(double)1/number;
			System.out.println(result);
		}
		System.out.println();
        System.out.println("Output of Harmonic Series is "+result);	
	}
	
	public void power(int number)
	{
		for(int i=0;i<=number;i++)
		{
			double result=Math.pow(2, i);
			
			System.out.println("2"+"^"+i+"="+result);			
		}
	}
	

}
