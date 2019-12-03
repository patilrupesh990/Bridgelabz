package com.bridgelabz.AlgorithmPrograms;
import com.bridgelabz.util.AlgorithmPrograms;
import com.bridgelabz.util.Utility;
/****************************************************************************************
* @author Rupeshp007Author: RupeshPatil
* @since: 22/11/2019
* @version 1.0
* Purpose:takes a command-line argument N, asks you to think of a number
* between 0 and N-1, where N = 2^n, and always guesses the answer with n
* questions.
* O/P -> Print the intermediary number and the final answer
***************************************************************************************/
public class Question
{
	static int range,count,upper,lower,middle;
	static String input;
	public static void main(String[] args) 
	{
			
			try
			{

				count=0;
				input=null;
				lower=0;
				
				System.out.println("Enter any Number:");
				int number=Utility.InputInt();
				
				range=(int)(Math.pow(2,number-1));                //range calculation for the number
				
				System.out.println("Take number between '0' to "+range);
				
				upper=range;
				middle=(lower+upper/2);
				
				AlgorithmPrograms.binarySearch(lower,upper,middle,count,input,number);
			}
			catch (ArrayIndexOutOfBoundsException ae)
			{
				ae.printStackTrace();
			}
	}
}