package com.bridgelabz.util;

/***************************************************************************************
* Created by:Rupesh Patil
* Date: 22/11/2019
* Purpose: To create New Node for elements store
*******************************************************************************************/

class QNode<T>
{
	T element;
	QNode next;
	QNode(T data)
	{
		
		this.element=data;
		next=null;
	}
	
}

/***************************************************************************************
* Created by:Rupesh Patil
* Date: 22/11/2019
* Purpose: Insert element Array in FIRST IN FIRST OUT manner using linkedlist.
* 	Operations on queue	
*	1 Insert
*	2 Delete.
*	3 IsEmpty.
*	4 IsFull	 
*******************************************************************************************/

public class QueueLinkedList<T> 
{
	QNode front,rear;
	
	public QueueLinkedList()
	{
		front=rear=null;
	}
	
	/**
	 * insert the values into queue 
	 * @param type data 
	 * @return void
	 * **/
	public <T> void enQueue(T data)
	{
		QNode<T> temp=new QNode<T>(data);
		if(rear==null)
		{
			this.rear=this.front=temp;
			return;
		}
		
		rear.next=temp;
		rear=temp;
		
	}
	/***************************************************************************
	 * delete values from  queue
	 * @param no params
	 * @return type data
	 * ***********************************************************************/

	public <T> T deQueue()
	{
		if(front==null)
		{
			System.out.println("Queue is Empty");
			return null;
		}
		
		
			QNode temp=front;
			front=front.next;
			if(front==null)
			{
				rear=null;
			}
			return (T) temp.element;
	}
	
	/*****************************************************************************
	 * To display the values from queue 
	 * @param no param
	 * @return void
	 * ****************************************************************************/
	
	public void display()
	{
		while(front!=null)
		{
			System.out.println(front.element);
			front=front.next;
		}
	}
	
}
