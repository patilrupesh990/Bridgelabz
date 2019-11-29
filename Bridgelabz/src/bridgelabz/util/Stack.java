package com.bridgelabz.util;

public class Stack<T>
{
	//static T  stack[];
	static int top=-1;
	private static String stack[];
	
	 
	 static public void setStackSize(int size)
	 {
		  stack=new String[size];
	 }
	 
	 public static <T> T push(T element)
	 {
		if(isFull())
		{
			System.out.println("Stack is full");
		}
		else
		{
			stack[++top]=element.toString();
		}
		
		return element;
	}
	static boolean isFull()
	{
		if(top==stack.length)
		{
			return true;
		}
		return false;
	}
	
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
