package com.bridgelabz.datastructureprograms;

import com.bridgelabz.util.Utility;

public class NumberOfBinaryTree 
{
	static int numbers[];
	static int resultcount=0;
	public static void main(String[] args) 
	{
		System.out.println("Enter the Number of Task");
		int tasks=Utility.InputInt();
		numbers=new int[tasks];
		
		for(int count=0;count<tasks;count++)
		{
			numbers[count]=Utility.InputInt();
		}
		int result[]=countTree(numbers, tasks);
		for(int index=0;index<resultcount;index++)
		{
			System.out.println(result[index]);
		}
		
	}
	
	public static int[] countTree(int numbers[],int tasks)
	{
		int result[]=new int[20];
		
		int temp[]=new int[100];
		temp[0]=1;
		temp[1]=1;
		temp[2]=2;
		
		
		for(int count=0;count<numbers.length;count++)
		{
			if(numbers[count]==0)
			{
				 result[resultcount++]=0;
				 
			}
			else if(numbers[count]==1)
			{
				 result[resultcount++]=1;
			}
			else if(numbers[count]==2)
			{
				 result[resultcount++]=2;
			}
			else
			{
				int index=0,sum=0;                             
				for(int count2=3;count2<=numbers[count];count2++)
				{
					temp[count2]=temp[index++]+temp[count2-1];
					sum+=temp[count2];
				}
				result[resultcount++]=sum;          
			}
			
			
		}
		return result;
		
	}
	
	
}
