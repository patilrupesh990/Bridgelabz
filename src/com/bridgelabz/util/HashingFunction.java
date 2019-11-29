package com.bridgelabz.util;

public class HashingFunction 
{
	@SuppressWarnings("rawtypes")
	static LinkedListiml linklist[]=new LinkedListiml[10];

	public HashingFunction()
	{
		for(int index=0;index<10;index++)
		{
			linklist[index]=new LinkedListiml();
		}
	}
	@SuppressWarnings("unchecked")
	public void put(int value)
	{
		linklist[value%10].add(value);	
	}
	static int index; 
	@SuppressWarnings("unchecked")
	public boolean search(int value)
	{
		boolean result=false;
		try {
		 result=linklist[value%10].searchNode(value);
		index=LinkedListiml.getindex();
		}catch (NullPointerException e) {
			// TODO: handle exception
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public void removeElement(int data)
	{
		linklist[index].removeNode(data);
	}
}
