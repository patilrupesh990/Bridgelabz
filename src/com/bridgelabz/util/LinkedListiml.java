package com.bridgelabz.util;


public class LinkedListiml<T>
{
		private int size = 0;
		private Node<T> node,root,p;
	 
		/**
		 * Add element at last.
		 * 
		 * @param data
		 */
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
		
		public boolean isEmpty()
		{
			if(root==null)
			{
				return true;
			}
				
			return false;
		}
	
	 
		/**
		 * Add element at first. set the newly created node as root node
		 * 
		 * @param data
		 */
		public void addAtFirst(T data) 
		{
			node=new Node<T>(data,null);
			node.data=data;
			node.nextNode=root;
			root=node;
			size++;
		}
		
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
	   
	        if (temp == null) return; 
	        prev.nextNode = temp.nextNode; 
		}
		
		
		@SuppressWarnings("unchecked")
		public boolean searchNode(T data)
		{
			p=root;
			while(p!=null)
			{
				if((boolean) node.getData().equals(data))
				{
					System.out.println(node.getData());
					return true;
				}
				p=p.nextNode;
			}
			return false;
		}
		
		
		@SuppressWarnings("unchecked")
		public void Display()
		{
			p=root;
			while(p != null)
			{
				System.out.println(p.data);
				p=p.nextNode;
			}
		}
		 
	
	 
			public int size() 
			{
				return this.size;
			}
	 
	 
		 
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((node == null) ? 0 : node.hashCode());
			result = prime * result + size;
			return result;
		}
	 
		/**
		 * Two linked list is equal when their size is equals and both have similar node structure
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (!(obj instanceof LinkedListiml))
				return false;
			@SuppressWarnings("rawtypes")
			LinkedListiml other = (LinkedListiml) obj;
			if (node == null) {
				if (other.node != null)
					return false;
			} else if (!node.equals(other.node))
				return false;
			if (size != other.size)
				return false;
			return true;
		}
		
	}

