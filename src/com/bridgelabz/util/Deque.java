package com.bridgelabz.util;
/***************************************************************************************
* Created by:Rupesh Patil
* Date: 23/11/2019
* Purpose: Insert element Array in FIRST IN FIRST OUT manner A deque, also known as a double-ended queue, is an ordered collection of items similar to the queue.
* 	Operations on queueu	
*	1 Insert
*	2 Delete.
*	3 IsEmpty.
*	4 IsFull	 
*******************************************************************************************/
public class Deque<E> 
{
	public E data;
	public Deque<E>next;
	public Deque<E>pre;
	
	public Deque()
	{
		this.next=null;
		this.pre=null;
	}
	
	public Deque(E val)
	{
		this.data=val;
		this.next=null;
		this.pre=null;
	}
}
