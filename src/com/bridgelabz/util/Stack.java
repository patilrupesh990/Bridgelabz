package com.bridgelabz.util;
/***************************************************************************************
* Created by:Rupesh Patil
* since: 20/06/2016
* Purpose: To Store data in Array in LAST IN FIRST OUT manner called stack.
*	1 Insert element PUSH operation
*	2 Deletion element POP operartion.
*	3 Peek TOP element it's PEEK operation	 
*******************************************************************************************/

public class Stack<T>
{
	//static T  stack[];
	static int top=-1;
	private static String stack[];
	
	/******************************************************************************
	 * to set the size of stack  
	 * @param int size
	 * @return void
	 * *****************************************************************************/
	 static public void setStackSize(int size)
	 {
		  stack=new String[size];
	 }
	 	/**
		 * insert values into the stack its called Push Operation
		 * @param T type element
		 * @return void
		 * **/
	 public static <T> T push(T element)
	 {
		if(isFull())
		{
			System.out.println("Stack is full");
		}
		else
		{
			try {
			stack[++top]=element.toString();
			}catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
				System.out.println("exid stack limit");
			}
		}
		
		return element;
	}
	    /*************************************************************************
		 * To check whether stack is full or not.
		 * @param no param
		 * @return boolean
		 *************************************************************************/
	static boolean isFull()
	{
		if(top==stack.length+1)
		{
			return true;
		}
		return false;
	}
    /*************************************************************************
	 * To delete element from stack it's called pop operation.
	 * @param no param
	 * @return type data
	 *************************************************************************/	
	@SuppressWarnings("unchecked")
	public static <T> T pop()
	 {
		T element=null;
		if(isEmpty())
		{
			return (T) "Stack is Empty";
			
		}
		else
		{
			element=(T) stack[top--];
		}
		return element;
		
	}
    /*************************************************************************
	 * To check whether stack is Empty or not.
	 * @param no param
	 * @return boolean
	 *************************************************************************/
	public static boolean isEmpty() 
	{
		if(top==-1)
		{
			return true;
		}
		return false;
	}
	
	public static <T> int getSize()
	{
		return top;
	}
    /*************************************************************************
	 * To get value from top of stack its called as peek operation.
	 * @param no param
	 * @return Type data
	 *************************************************************************/
	@SuppressWarnings("unchecked")
	public static <T> T peek()
	{
		if(isEmpty())
		{
			return (T) "stack is empty";
		}
		else
		{
			return (T) stack[top];
		}
	}
	
	
	}
