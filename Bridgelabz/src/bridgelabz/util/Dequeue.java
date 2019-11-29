package com.bridgelabz.util;

public class Dequeue<E> 
{
	 char[] dequeue;
	 int front=-1,rear=-1,size;
		public void setSize(int size)
		{
			this.size=size;
			dequeue=new char[size];
		}
		public  char[] dequeu()
		{	
			return dequeue;
		}
		public void addRear(char data)
		{
			
			 if (rear==dequeue.length-1) 
		        { 
		            
		            return; 
		        } 
		   
		        if (front == -1) 
		        { 
		            front = 0; 
		            rear = 0; 
		        } 
		   
		        else if (rear == size-1) 
		            return; 
		   
		        else
		            rear = rear+1; 
		      	
		        dequeue[rear] =data; 
		    } 
		
		
		public  char deleteRear()
		{
			char x=' ';
			if (rear==-1||rear==0) 
	        { 
	           //System.out.println("Queue Underflow");
	           return 0;
	        
	        } 
	    
	        if (front == rear) 
	        { 
	            front = -1; 
	            rear = -1; 
	        } 
	        else if (front == size -1) 
	                front = 0; 
	   
	            else {
	            	
	            	x=dequeue[++front];
	            	
	            }
	        return x;
		}
		
		public char deleteFront()
		{
			if (isEmpty()) 
	        { 
	            System.out.println(" Underflow"); 
	            return 0; 
	        } 
	   
	        if (front == rear) 
	        { 
	            front = -1; 
	            rear = -1; 
	        } 
	        else if (rear == 0) 
	            rear = size-1; 
	        else
	            rear = rear-1;
			return dequeue[rear];
	        
		}
		
		public  void addFront(char data)
		{
			System.out.println();
			System.out.println();
			System.out.println(data); 
			if (isFull()) 
		        { 
		            //System.out.println("Overflow");  
		            return; 
		        } 
			if(isEmpty())
			{
				rear=0;front=0;
			}
			if(front==0)
			{
				front=size-1;
			}
			else
			{
				front=front-1;
			}
			try {
			dequeue[front]=data;
			}
			catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
				//System.out.println(dequeue[front]);
				
			}
		}
		
		public  boolean isEmpty()
		{
			if(front==-1&&rear==-1)
			{
				return true;
			}
			return false;
		}
		
		boolean isFull() 
	    { 
	        return ((front == 0 && rear == size-1)|| 
	            front == rear+1); 
	    } 
		public static void main(String[] args) 
		{
			Utility util=new Utility();
			System.out.println("Enter the String:");
			String string=util.InputString();
			/*Dequeue obj1=new Dequeue();
			obj1.setSize(string.length());
			for(int i=0;i<string.length();i++)
			{
				obj1.addRear(string.charAt(i));
			}    
			char[] str=obj1.dequeu();
			for(char j:str)
			{
				System.out.print(j);
			}*/
			
			
			Dequeue obj2=new Dequeue();
			obj2.setSize(string.length());
			for(int i=0;i<string.length();i++)
			{
				obj2.addRear(string.charAt(i));
			}    
			char[] str2=obj2.dequeu();
			for(char j:str2)
			{
			//	System.out.print(j);
			}
			char ar[]=new char[string.length()];
			for(int i=0;i<string.length();i++)
			{
					ar[i]=obj2.deleteRear();
					System.out.println(ar[i]);
					
			}
			String rev=new String(ar);
			char ar2[]=new char[string.length()];
			for(int i=0;i<string.length();i++)
			{
					ar2[i]=obj2.deleteRear();
					System.out.println(ar2[i]);
					
			}
			
			String rev2=new String(ar2);
			
			if(rev2.equals(rev))
			{
				System.out.println("palindrome");
			}
			else
			{
				System.out.println("not palindrome");
			}
			
		}
	
	
		
}



/*public class Dequeue<E> 
{
	public E data;
	public Dequeue<E>next;
	public Dequeue<E>pre;
	
	public Dequeue()
	{
		this.next=null;
		this.pre=null;
	}
	
	public Dequeue(E val)
	{
		this.data=val;
		this.next=null;
		this.pre=null;
	}
}*/