package com.bridgelabz.util;

/***************************************************************************************
* Created by:Rupesh Patil
* Date: 22/11/2019
* Purpose: To create new Node for create LinkedList.
*******************************************************************************************/

public class Node<T> 
{
	 
	public T data;
	
	@SuppressWarnings("rawtypes")
	public Node nextNode;
	/**
	 * constructor of Node class
	 * @param data and reference value
	 * **/
	@SuppressWarnings("rawtypes")
	public Node(T data,Node node)
	{
		this.data=data;
		this.nextNode=null;
	}
	
	/**
	 * Set the values of variables 
	 * @param reference value of type data type
	 * @return void
	 * **/
	

	public void setData(T data2)
	{
		this.data=data2;
		nextNode=null;
	}
	
	/**
	 * get the values of class variables 
	 * @param no param
	 * @return T type data
	 * **/
	public T getData()
	{
		return data;
	}
}