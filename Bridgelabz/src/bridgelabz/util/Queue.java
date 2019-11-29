package com.bridgelabz.util;

public class Queue<T>
{
	
	static int front=-1,rear=-1;
	static String queue[];
	static int size;
	
	public static void setSize(int size1)
	{
		size=size1;
		queue=new String[size1];
	}
	
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
	
	public static void reset()
	{
		rear=-1;front=-1;
	}
	
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
	
	public static boolean isFull()
	{
		if(front==queue.length)
		{
			return true;
		}
		
		return false;				
	}
	
	public static boolean isEmpty()
	{
		if(rear==-1)
		{
			return true;
		}
		return false;
	}
	
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
