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
	public void TestStackSize()
	{
		assertTrue(Stack.isEmpty()==true);
		Stack.setStackSize(3);
		Stack.push(10);
		Stack.push(20);
		Stack.push(30);
		assertTrue(Stack.isFull()==true);
		assertTrue(Stack.isEmpty()==false);
		Stack.pop();
		Stack.pop();
		Stack.pop();
	}
	

	/**To test Stack isEmpty or not module**/
	@Test
	public void TestStackIsEmpty()
	{
		assertTrue(Stack.isEmpty()==true);	
		Stack.push(30);
		assertTrue(Stack.isEmpty()==false);	
		Stack.pop();
	}

}
