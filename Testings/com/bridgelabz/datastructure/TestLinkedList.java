package com.bridgelabz.datastructure;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bridgelabz.util.LinkedListiml;


/**
* Author: RupeshPatil
* Date: 29/11/2019
* Purpose:To Test Working modules of Linkedlist 
***********************************************************************/

@SuppressWarnings("unchecked")
public class TestLinkedList 
{
	@SuppressWarnings("rawtypes")
	LinkedListiml list=new LinkedListiml();

	/**To test LinkedList isEmpty module**/
	@Test
	public void testLinkedListisEmpty() {
		assertTrue(list.isEmpty());
	}

	/**To test LinkedList Searching element module**/
	@Test
	public void testLinkedListSearch() {
		list.add(10);
		list.add(20);
		list.add(30);
		assertFalse(list.searchNode(50));
		assertTrue(list.searchNode(20));
	}
	

	/**To test LinkedList Rmove elements from Linkedlist module**/
	@Test
	public void testRemoveData()
	{
		list.add(100);
		list.add(80);
		list.add(50);
		list.removeNode(50);
		assertFalse(list.searchNode(50));
		assertTrue(list.searchNode(80));
	}
	

	/**To test LinkedList GetNext module**/
	@Test
	public void testGetIndex()
	{
		list.removeNode(10);
		list.removeNode(20);
		list.removeNode(30);
		list.removeNode(100);
		list.removeNode(80);
		assertFalse(LinkedListiml.getindex()==7);		
		list.add(100);
		list.add(80);
		list.searchNode(80);
		assertTrue(LinkedListiml.getindex()==1);
	}
	
}
