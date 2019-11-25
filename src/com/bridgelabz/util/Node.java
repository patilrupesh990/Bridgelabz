package com.bridgelabz.util;

public class Node<T> 
{
	 
	public T data;
	
	@SuppressWarnings("rawtypes")
	public Node nextNode;
	
	//constructor
	@SuppressWarnings("rawtypes")
	public Node(T data,Node node)
	{
		this.data=data;
		this.nextNode=null;
	}

	

	public void setData(T data2)
	{
		this.data=data2;
		nextNode=null;
	}
	
	public T getData()
	{
		return data;
	}
}