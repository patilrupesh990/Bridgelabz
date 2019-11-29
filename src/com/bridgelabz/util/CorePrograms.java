package com.bridgelabz.util;
import java.util.Random;
/**
 * @author Rupeshp007
 * date:18/11/2019
 * Purpos:utility class for core program classes methods
 * @version 1.0
 **/
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
	
	/******************************************************************************
	 * logic for flip coin and gives the o/p in term of head and tail.
	 *  @param no param
	 *  @return void
	 *********************************************************************************/
	
	public void Harmonic(int number)
	{
		double result=0;
		for(int count=1;count<=number;count++)
		{
			 result=(double)1/number;
			System.out.println(result);
		}
		System.out.println();
        System.out.println("Output of Harmonic Series is "+result);	
	}
	
	/*****************************************************************************
	 * logic for get power of 2 using Math.pow().
	 *  @param int number
	 *  @return void
	 *************************************************************************/
	public void power(int number)
	{
		for(int count=0;count<=number;count++)
		{
			double result=Math.pow(2, count);
			
			System.out.println("2"+"^"+count+"="+result);			
		}
	}
	
	/*********************************************************************************
	 * logic for get prime factors of user given input numbers
	 *  @param int number
	 *  @return void
	 *******************************************************************************/
	public static void primeFactors(int number) 
    { 
       
        while (number%2==0) 
        { 
            System.out.print(2 + " "); 
            try{number /= 2;}
            catch (ArithmeticException eaithmeticexc) 
            {
            	System.out.println("divide by zero");
			} 
        } 
  
         
        for (int count = 3; count <= Math.sqrt(number); count+= 2) 
        { 
          
            while (number%count == 0) 
            { 
                System.out.print(count + " "); 
               try {number /= count;}catch (Exception e) {
				System.out.println("divide by zero");
			} 
            } 
        } 
  
        
        if (number > 2) 
            System.out.print(number); 
    } 

	

}
