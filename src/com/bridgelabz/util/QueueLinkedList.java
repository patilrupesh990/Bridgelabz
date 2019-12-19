package com.bridgelabz.util;

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

public class QueueLinkedList<T> 
{
	QNode front,rear;
	
	QueueLinkedList()
	{
		front=rear=null;
	}
	
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
	
	public <T> void deQueue()
	{
		if(front==null)
		{
			System.out.println("Queue is Empty");
			return;
		}
		
		
			QNode temp=front;
			front=front.next;
			if(front==null)
			{
				rear=null;
			}
	}
	
	public void display()
	{
		while(front!=null)
		{
			System.out.println(front.element);
			front=front.next;
		}
	}
	
}
