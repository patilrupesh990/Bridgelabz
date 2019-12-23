package com.bridgelabz.util;

import org.json.simple.JSONObject;

/***************************************************************************************
* Created by:Rupesh Patil
* since: 20/06/2016
* Purpose: To Store data in Linkedlist in LAST IN FIRST OUT manner called stack.
*	1 Insert element PUSH operation
*	2 Deletion element POP operartion.
*	3 Peek TOP element it's PEEK operation	 
*******************************************************************************************/

public class LinkedListStack<T> 
{
		  int count=0;
	    private class Node { 
	  
	        T data; 
	        Node next;     
	    } 
	    Node top; 
	    public  LinkedListStack ()  
	    { 
	        this.top = null; 
	    } 
	  
		/*************************************************************
		 * insert values into the stack its called Push Operation
		 * @param T type element
		 * @return void
		 ************************************************************/
	    @SuppressWarnings("unused")
		public void push(T x) 
	    { 
	        Node temp = new Node(); 
	  
	        if (temp == null) { 
	            System.out.print("\nHeap Overflow"); 
	            return; 
	        } 
	  
	        temp.data = x; 
	  	    temp.next = top; 
	  
	        top = temp; 
	        count++;
	    } 
	    /*************************************************************************
		 * To check whether stack is Empty or not.
		 * @param no param
		 * @return boolean
		 *************************************************************************/
	    public boolean isEmpty() 
	    { 
	        return top == null; 
	    } 
	  
	    /*************************************************************************
		 * To get value from top of stack its called as peek operation.
		 * @param no param
		 * @return Type data
		 *************************************************************************/

	    public T peek() 
	    { 
	        if (!isEmpty()) { 
	            return top.data; 
	        } 
	        else { 
	            System.out.println("Stack is empty"); 
	        }
			return null; 
	    } 
	  
	    /*************************************************************************
		 * To delete element from stack it's called pop operation.
		 * @param no param
		 * @return type data
		 *************************************************************************/	

	    public void pop() 
	    { 
	        if (top == null) { 
	            System.out.print("\nStack Underflow"); 
	            return; 
	        } 
	  
	        top = (top).next; 
	    } 
	  
	    /*************************************************************************
		 * To Display all value store inside stacks
		 * @param no param
		 * @return Type data
		 *************************************************************************/

	    public void display() 
	    { 
	        if (top == null) { 
	            System.out.printf("\nStack Underflow"); 
	        } 
	        else { 
	            Node temp = top; 
	            while (temp != null) { 
	  
	                System.out.printf("%d->", temp.data); 
	  
	                temp = temp.next; 
	            } 
	        } 
	    } 
	    
	    public JSONObject[] getjson() 
	    { 
	    	JSONObject objcet []=new JSONObject[count];
	    	int index=0;
	        if (top == null) { 
	            System.out.printf("\nStack Underflow"); 
	        } 
	        else { 
	            Node temp = top; 
	            while (temp != null) { 
	  
	               objcet[index++]= (JSONObject) temp.data; 
	  
	                temp = temp.next; 	            
	                } 
	        }
			return objcet;
	    } 
	} 

