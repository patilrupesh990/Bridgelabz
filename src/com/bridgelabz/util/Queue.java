package com.bridgelabz.util;
/***************************************************************************************
* Created by:Rupesh Patil
* Date: 22/11/2019
* Purpose: Insert element Array in FIRST IN FIRST OUT manner.
* 	Operations on queueu	
*	1 Insert
*	2 Delete.
*	3 IsEmpty.
*	4 IsFull	 
*******************************************************************************************/

public class Queue<T>
{
	
	static int front=0,rear=-1,count=0;
	static String queue[];
	static int size=0;
	/**
	 * Set size of queue array 
	 * @param int 
	 * @return void
	 * **/
	public static void setSize(int size1)
	{
		size=size1;
		queue=new String[size1];
	}
	
	public static int getSize()
	{
		return count;
	}
	
	/**
	 * insert the values into queue 
	 * @param type data 
	 * @return void
	 * **/
	public static <T>void insert(T data)	
	{
		
		if(isFull())
		{
			System.out.println("Sorry For inconvenience Queue is Full");
			
		}
		else
		{
			
			try {
			queue[++rear]=data.toString();
			count++;
			}catch (ArrayIndexOutOfBoundsException e) {
				
			}
		}
	}
	
	/**
	 * Reset the values of rear and front so queue will be empty 
	 * @param reference value of type data type
	 * @return void
	 * **/
	public static void reset()
	{
		rear=-1;front=-1;
	}
	/***************************************************************************
	 * delete values from  queue
	 * @param no params
	 * @return type data
	 * ***********************************************************************/
	public static <T>String detete()
	{
		if(isEmpty())
		{
			return  "Queue is empty";
		}
		else
		{
			//queue.remove(rear);
			String deleted=queue[front];
			for(int i=0;i<queue.length-1;i++)
			{
				queue[i]=queue[i+1];
			}
			rear--;
			count--;
			return deleted;
		}
		
		
		
	}
	/****************************************************************************
	 * To check whether queue is full or not
	 * @param no param
	 * @return boolean
	 *****************************************************************************/
	public static boolean isFull()
	{
		if(count==size-1)
		return true;
		else
		return false;				
	}
	/******************************************************************************
	 * To check whether queue is empty or not 
	 * @param no param
	 * @return boolean
	 **********************************************************************************/
	public static boolean isEmpty()
	{
		if(count==-1)
			return true;
		return false;
	}
	/*****************************************************************************
	 * To display the values from queue 
	 * @param no param
	 * @return void
	 * ****************************************************************************/
	public static void Display()
	{
		for(int i=0;i<rear;i++)
		{
			try
			{
				System.out.println(queue[i]);
			}catch (Exception e) 
			{
				System.out.println("Display queue problem");
			}
		}
	}

}
