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
	
	static int front=-1,rear=-1;
	static String queue[];
	static int size;
	
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
	/**
	 * insert the values into queue 
	 * @param type data 
	 * @return void
	 * **/
	public static <T>void insert(T data)	
	{
		if(isEmpty())
		{
			front=0;rear=0;
		}
		if(isFull())
		{
			System.out.println("Sorry For inconvenience Queue is Full");
			
		}
		else
		{
			//queue.add(queue.indexOf(front), data.toString());
			try {
			queue[rear++]=data.toString();
			}catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
				//System.out.println("queue size is limited:"+size);
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
	@SuppressWarnings("unchecked")
	public static <T> T detete()
	{
		if(isEmpty())
		{
			return (T) "Queue is Empty";
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
			return (T) deleted;
		}
		
		
	}
	/****************************************************************************
	 * To check whether queue is full or not
	 * @param no param
	 * @return boolean
	 *****************************************************************************/
	public static boolean isFull()
	{
		if(front==queue.length)
		{
			return true;
		}
		
		return false;				
	}
	/******************************************************************************
	 * To check whether queue is empty or not 
	 * @param no param
	 * @return boolean
	 **********************************************************************************/
	public static boolean isEmpty()
	{
		if(rear==-1)
		{
			return true;
		}
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
				// TODO: handle exception
			}
		}
	}
	
	
	public static void main(String args[])
	{
		
	}
}
