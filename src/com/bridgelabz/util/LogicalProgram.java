package com.bridgelabz.util;

import java.util.Random;
/**********************************************************************************************************
* Created by:	Rupesh Patil
* Date:  		16/11/2019
* Purpose: 		Logical programs utility methods.
***********************************************************************************************************/

public class LogicalProgram 
{
	
	
	/**
	 * Code Generation for given number of size
	 * @param integer max for get size of code
	 * @return void
	**/
	
	public static String GenerateCode(int max)
	{
		
		String s="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
		
		StringBuffer sb=new StringBuffer(max);
		for(int i=0;i<max;i++)
		{
		int index = (int)(s.length()* Math.random()); 
			sb.append(s.charAt(index));
			
		}

		String couponCode=sb.toString();
		//System.out.println("Coupon Code: "+couponCode);	
		return couponCode;
	
	}//end GenerateCode
	
	
	//variables for Gambler
		static int goal,time;
		static double stack;
		static int won;
		static int loss;
		static int totalgame;
		
		
		
		
		/**
		 * Initialization for Gambler Program
		 * @param no parameters
		 * @return void
		**/
		public static void Initilazation()
		{
			System.out.println("Enter the Stack amount");
			stack=Utility.InputDouble();
			System.out.println("Enter Your Goal:");
			goal=Utility.InputInt();
			System.out.println("How many taimes want to play Gambler");
			time=Utility.InputInt();
		}//end Initilazion
		
		/**
		 * Rotation of strike for Gambler Program
		 * @param no parameters
		 * @return void
		**/
		public static void Rotate()
		{
			int choice=0;
			while(time>0)
			{
				if(stack>=goal)
				{
					System.out.println("Congratulations!! You Reached to Your Goal:");
				}
				System.out.println("press 1 for Rotate  press 2 for Exit");
				System.out.println("=======================================>>>>>>><<<<<<=====================================");
				choice=Utility.InputInt();
				if(choice==1)
				{
					LogicalProgram.gamble();
					time--;
				}
				else if(choice==2)
				{
					System.exit(0);
				}
				else
				{
					System.out.println("Invalid Input!! Please Enter Valid Input");
					System.out.println("press 1 for Rotate  press 2 for Exit");
				}
				
			}
		}
		
		/**
		 * winning and looser logic for Gambler program
		 * @param no parameters
		 * @return void
		**/
		
		public static void gamble()
		{
			Random random=new Random();
			
			int result=random.nextInt(2);
		
				totalgame++;
					if(result==0)
					{
						won++;
						stack=stack*2;
						System.out.println();
						System.out.println("wow!! you won the strick,You have "+stack+" your goal is "+goal+" keep play");
						System.out.println("You have Now left "+time+" Roation");
					}
					else
					{
						loss++;
						stack=(0.5)*stack;
						System.out.println();
						System.out.println("Bad Luck!! you loss the strick,Now You have " +stack+" your goal is "+goal+" keep play");
						System.out.println("You have Now left "+time+" Roation");
					}
					
					System.out.println();
					System.out.println();
			System.out.println("You win "+ won + " taimes");
			System.out.println("You loss "+ loss + " taimes");
			double win_percentage=((double)won/totalgame)*100;
			double loss_percentage=((double)loss/totalgame)*100;
			System.out.println("winning percentage:"+win_percentage);
			System.out.println("loss percentage:"+loss_percentage);
			System.out.println("=======================================>>>>>>><<<<<<=====================================");
		}//End Gamble
		
		/**
		 * Repetition of gambler after first given number of game
		 * @param no parameters
		 * @return void
		**/
		public static void RepeatationAfterFirst()
		{
				if(stack<=goal)
				{
					System.out.println();
					System.out.println("Sorry You cant reached To Your Goal!! You Want to play Again?");
					System.out.println("press Y for play again: Y/N");
					char ch=Utility.InputChar();
					
					if(ch=='y'||ch=='Y')
					{
						System.out.println();
						System.out.println("You have "+stack+"Now");
						System.out.println("You want to add Money In Stack??");
						System.out.println("press Y for add Money or press N for skip: Y/N");
						int ch2=Utility.InputChar();
						if(ch2=='y'||ch2=='Y')
						{
							System.out.println();
							System.out.println("enter the amount of stack");
							stack+=Utility.InputDouble();
							System.out.println("You have Now "+stack+" stacks");
							
							System.out.println("How Many Times Want To Rotate??");
							time=Utility.InputInt();
							while(time>0)
							{
								time--;
								LogicalProgram.Rotate();
							}
							if(time==0)
							{
								LogicalProgram.RepeatationAfterFirst();
							}
						}
						else if(ch=='n'||ch=='N')
						{
							LogicalProgram.Rotate();
						}
						else
						{
							System.out.println("Invalid input");
							LogicalProgram.RepeatationAfterFirst();
						}
							
						
						LogicalProgram.Rotate();
					}
					else
					{
						System.exit(0);
					}
				}
		}//end RepeatationAfterFirst()
		
}
