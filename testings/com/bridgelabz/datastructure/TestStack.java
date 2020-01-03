package com.bridgelabz.datastructure;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bridgelabz.util.Stack;

/**
* Author: RupeshPatil
* Date: 28/11/2019
* Purpose:To Test Working modules Stack
***********************************************************************/

public class TestStack {

	/**To test Stack size,push pop module**/
	@Test
	public void Test_when_sizeis_three_after_insertElement_shold_full_StackSize()
	{
		assertTrue(Stack.isEmpty()==true);
		Stack.setStackSize(3);
		Stack.push(10);
		Stack.push(20);
		Stack.push(30);
		assertTrue(Stack.isFull()==true);
		assertTrue(Stack.isEmpty()==false);
	}
	

	/**To test Stack isEmpty or not module**/
	@Test
	public void Test_when_all_element_poped_stack_shold_Empty()
	{
		Stack.pop();
		Stack.pop();
		Stack.pop();
		assertTrue(Stack.isEmpty()==true);	
	}

}
