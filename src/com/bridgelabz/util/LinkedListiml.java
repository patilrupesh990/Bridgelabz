package com.bridgelabz.util;

import com.bridgelabz.oops.stockmanagement.BuyerDetails;
import com.bridgelabz.oops.stockmanagement.StockDetails;

public class LinkedListiml<T>
{
		private int size = 0;
		private Node<T> node,root,p;
	 
		/***********************************************************************
		 * purpose:Add data in LinkedList
		 * @param T data 
		 * @return void
		 * 
		************************************************************************/
	
		@SuppressWarnings("unchecked")
		public void add(T data) 
		{
			node=new Node<T>(data, null);
			if(root==null)
			{
				root=node;
			}
			else
			{
				p=root;
				while(p.nextNode!=null)
				{
					p=p.nextNode;
				}
				p.nextNode=node;
			}
				
			size++;
		}
		/**
		 * purpose:To chek LinkedList Empty or not  
		 * @param  no param 
		 * @return boolean
		 * 
		**/

		public boolean isEmpty()
		{
			if(root==null)
			{
				return true;
			}
				
			return false;
		}
	
		/**
		 * purpose:Add data at first node in LinkedList
		 * @param T data 
		 * @return void
		 * 
		**/

		
		public void addAtFirst(T data) 
		{
			node=new Node<T>(data,null);
			node.data=data;
			node.nextNode=root;
			root=node;
			size++;
		}
		/**
		 * purpose:Remove Node from LinkedList
		 * @param T data 
		 * @return void
		 * 
		**/

		@SuppressWarnings("unchecked")
		public void removeNode(T data)
		{
			
	        @SuppressWarnings("rawtypes")
			Node temp = root, prev = null; 
	  
	        if (temp != null && temp.data.equals(data)) 
	        { 
	            root = temp.nextNode; // Changed head 
	            return; 
	        } 
	   
	        while (temp != null && !temp.data.equals(data)) 
	        { 
	            prev = temp; 
	            temp = temp.nextNode; 
	            
	        }   
	        if(temp==null)
	        	return;
	        	prev.nextNode = temp.nextNode; 
		}
		
		/**
		 * purpose:search data in LinkedList
		 * @param T data 
		 * @return boolean
		 * 
		**/

		static int index=0;
		@SuppressWarnings("unchecked")
		public boolean searchNode(T data)
		{
			index=0;
			p=root;
			while(p!=null)
			{
				
				if((boolean) p.getData().equals(data))
				{
					//System.out.println(node.getData());
					return true;
				}
				index++;
				p=p.nextNode;
			}
			return false;
			
		}
		public static int getindex()
		{
			return index;
		}
		/**
		 * purpose:Display data from LinkedList
		 * @param no param
		 * @return void
		 * 
		**/

		
		@SuppressWarnings("unchecked")
		public void Display()
		{
			p=root;
			while(p != null)
			{
				System.out.print(" "+p.data);
				p=p.nextNode;
			}
		}
		 
		@SuppressWarnings("unchecked")
		public void add2Stack()
		{
			p=root;
			while(p != null)
			{
				Stack.push(p.data);
				p=p.nextNode;
			}
		}
		
		@SuppressWarnings("unchecked")
		public void add2Queue()
		{
			p=root;
			while(p != null)
			{
				Queue.insert(p.data);
				p=p.nextNode;
			}
		}	
		
		
		public int[] GetListElements()
		{
			int[] elements=new int[size];
			int count=0;
			p=root;
			while(p != null)
			{
				elements[count++]=(int) p.data;
				p=p.nextNode;
			}
			return elements;
		}
		
		
		public StockDetails[] GetListObject()
		{
			StockDetails[] elements=new StockDetails[size];
			int count=0;
			p=root;
			while(p != null)
			{
				elements[count++]= (StockDetails) p.data;
				p=p.nextNode;
			}
			return elements;
		}
		
		
		public BuyerDetails[] GetBuyerListObject()
		{
			BuyerDetails[] elements=new BuyerDetails[size];
			int count=0;
			p=root;
			while(p != null)
			{
				elements[count++]= (BuyerDetails) p.data;
				p=p.nextNode;
			}
			return elements;
		}
			
			
				
	}

