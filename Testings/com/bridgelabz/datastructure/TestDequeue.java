package com.bridgelabz.datastructure;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Assert;

import com.bridgelabz.util.Dequeueimpl;

/**
* Author: RupeshPatil
* Date: 28/11/2019
* Purpose:To Test Working modules of Dequeue 
***********************************************************************/

@SuppressWarnings("unchecked")
public class TestDequeue {
	@SuppressWarnings("rawtypes")
	Dequeueimpl deque=new Dequeueimpl();

	/**To test is dequeue is Empty or not**/

	@Test
	public void if_returns_true_dequeue_should_empty() {
		Assert.assertEquals(true, deque.isEmpty());
	}

	/**To test dequeue size**/
	@Test
	public void TestDequeimpl_data() {
		deque.addRear(21);
		assertEquals(1, deque.size());
		deque.addRear(2);
		deque.addRear(22);
		assertEquals(3, deque.size());
	}
	/**To test dequeue Remove element from rear**/
	@Test
	public void TestRmoveRear() {
		deque.addRear(22);
		deque.addRear(21);
		deque.addRear(23);
		assertEquals(23, deque.removeRear());
	}
	
	/**To test Remove element from frontside**/
	@Test
	public void TestRmovefront() {
		deque.addRear(22);
		deque.addRear(23);
		assertEquals(22, deque.removeFront());
	}

}
