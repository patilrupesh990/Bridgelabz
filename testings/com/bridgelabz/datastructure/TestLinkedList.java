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
	public void Test_initially_linkedlist_shold_Empty() {
		assertTrue(list.isEmpty());
	}

	/**To test LinkedList Searching element module**/
	@Test
	public void Test_when_input_Integers_search_ouput_should_Be_true() {
		list.add(10);
		list.add(20);
		list.add(30);
		assertFalse(list.searchNode(50));
		assertTrue(list.searchNode(20));
	}
	

	/**To test LinkedList Rmove elements from Linkedlist module**/
	@Test
	public void test_when_input_searchNode_50_should_false_and_search_80_sould_true()
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
	public void test_when_integers_inputs_after_removeNode_ouput_index_should_7_and_1()
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
