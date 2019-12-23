package com.bridgelabz.util;
/***************************************************************************************
* Created by:Rupesh Patil
* Date: 25/11/2019
* Purpose: Insert Element in hashTable using linklist it will generate the hashcode for element based on
* element%sizeofArray and store generated location. Here SizefLInklist we have taken 11.
*******************************************************************************************/
public class HashingFunction 
{
	@SuppressWarnings("rawtypes")
	static LinkedListiml linklist[]=new LinkedListiml[11];

	/** it will generates the linlList Object as per size of stack here we have taken 10.
	 * @param no param
	 * @constructor  
	 * **/	
	@SuppressWarnings("rawtypes")
	public HashingFunction()
	{
		for(int index=0;index<11;index++)
		{
			linklist[index]=new LinkedListiml();
		}
	}
	
	/** it will put the element in LinkedList on given location.
	 * @param int value
	 * @return void  
	 * **/	
	@SuppressWarnings("unchecked")
	public void put(int value)
	{
		linklist[value%11].add(value);	
	}
	
	/** it will Search the element in LinkedList on given location.
	 * @param int value
	 * @return boolean  
	 * **/	
	static int index; 
	@SuppressWarnings("unchecked")
	public boolean search(int value)
	{
		boolean result=false;
		try {
		 result=linklist[value%11].searchNode(value);
		index=LinkedListiml.getindex();
		}catch (NullPointerException e) {
			// TODO: handle exception
		}
		return result;
	}
	
	/** it will Remove the element from LinkedList on given location.
	 * @param int value
	 * @return void  
	 * **/	
	@SuppressWarnings("unchecked")
	public void removeElement(int data)
	{
		linklist[index].removeNode(data);
	}
}
