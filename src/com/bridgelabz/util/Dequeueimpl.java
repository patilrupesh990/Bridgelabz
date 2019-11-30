package com.bridgelabz.util;

public class Dequeueimpl<E> {

	
	Deque<E> front;
	Deque<E> rear;
	int size=0;
	
	/**
	 * To Add data in front
	 * @param Type value
	 * @return void
	 * **/
	@SuppressWarnings("null")
	public void addFront(E c)
	{
		if(front==null) //if no element in list
		{
			front.data=c;
			rear=front;
		}
		else  //if element in list
		{
			Deque<E>tNode=null;
			tNode.data=c;
			tNode.next=front;
			front.pre=tNode;
			front=tNode;
		}
		size++;
	}
	/*************************
	 * To Add data in Rear
	 * @param Type value
	 * @return void
	 *************************/	
	public void addRear(E c)
	{
		if(front==null) //if no element in list
		{
			Deque<E>tNode=new Deque<E>(c);
			front=tNode;
			rear=front;
		}
		else  //if element in list
		{
			Deque<E>tNode=new Deque<>(c);
			rear.next=tNode;
			tNode.pre=rear;
			rear=tNode;
		}
		size++;
	}
	/**
	 * To remove data from front
	 * @param no param
	 * @return type data
	 * **/
	public E removeFront()
	{
		E val=null;
		if(front==null)
		{
			System.out.println("No elements to delete");
		}
		else
		{
			val=front.data;
			front=front.next;
		}
		size--;
		return val;
	}
	/**
	 * To Add data from Rear
	 * @param no param
	 * @return Type data
	 * **/
	public E removeRear()
	{
		E val=null;
		if(front==null)
		{
			System.out.println("No element to delete");
		}
		else
		{
			val=rear.data;
			rear=rear.pre;
			rear.next=null;
		}
		size--;
		return val;
	}
	/**
	 * it will check whether queue is empty or not
	 * @param no param
	 * @return boolean
	 * **/
	public boolean isEmpty()
	{
		if(front==null)
			return true;
		else
			return false;
	}
	/**
	 * it will return size of queue
	 * @param no param
	 * @return int
	 * **/	
	public int size()
	{
		return size;
	}
}
