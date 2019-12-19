package com.bridgelabz.util;

public class LinkedListStack<T> 
{
		  
	    private class Node { 
	  
	        T data; 
	        Node next;     
	    } 
	    Node top; 
	    public  LinkedListStack ()  
	    { 
	        this.top = null; 
	    } 
	  
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
	    } 
	  
	    public boolean isEmpty() 
	    { 
	        return top == null; 
	    } 
	  
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
	  
	    public void pop() 
	    { 
	        if (top == null) { 
	            System.out.print("\nStack Underflow"); 
	            return; 
	        } 
	  
	        top = (top).next; 
	    } 
	  
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
	} 

