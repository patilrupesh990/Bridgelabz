package com.bridgelabz.datastructure;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.bridgelabz.util.Queue;

/**
* Author: RupeshPatil
* Date: 28/11/2019
* Purpose:To Test Working modules of Queue
***********************************************************************/

public class TestQueue 
{
	/**To test Queue size module**/
	@Test
	public void Test_when_size_Five_after_insert_element_Queue_shouldnot_Empty ()
	{
		Queue.setSize(5);
		Queue.insert(10);
		Queue.insert(20);
		Queue.insert(30);
		assertTrue(Queue.isEmpty()==false);
		Queue.insert(40);
		Queue.insert(50);
		assertTrue(Queue.isFull()==true);
	}

	/**To test Queue isFull or not module**/
	@Test
	public void Test_when_size_Five_after_insert_element_Queue_should_Full()
	{
		Queue.reset();
		Queue.setSize(5);
		Queue.insert(10);
		Queue.insert(20);
		Queue.insert(30);
		assertTrue(Queue.isEmpty()==false);
		Queue.insert(40);
		Queue.insert(50);
		assertTrue(Queue.isFull()==true);
		
	}
	

	
	
}
