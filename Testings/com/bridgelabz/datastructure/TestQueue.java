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
	public void TestQueuesize()
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
	public void TestIsFull()
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
	
	/**To test isEmpty Queue or not module**/
	public void TestIsEmpty()
	{
		Queue.reset();
		Queue.insert(10);
		Queue.insert(20);
		Queue.insert(30);
		assertTrue(Queue.isEmpty()==false);
		Queue.detete();
		Queue.detete();
		Queue.detete();
		assertTrue(Queue.isEmpty()==true);
	}
	
	
}
