package com.bridgelabz.datastructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bridgelabz.util.DataStructure;
public class TestCashCounter 
{
	@Test
	public void testCallNext()
	{
		//when 2000 deposited
		double cash,result;
		cash=2000.0d;
		result=com.bridgelabz.util.DataStructure.callNext(cash);
		assertEquals(4000.00, result, 1);
		
		//when 7000 withdraw
		cash=14000.0d;
		result=com.bridgelabz.util.DataStructure.callNext(cash);
		assertEquals(7000.00, result, 1);
	}
	
}
