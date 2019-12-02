package com.bridgelabz.datastructure;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


/**
* Author: RupeshPatil
* Date: 28/11/2019
* Purpose:To Test Working modules of CashCouner Program Based on Queue 
***********************************************************************/
public class TestCashCounter 
{
	
	/**To Check test cash Counter Fuctionality to callnext cash deposite withdraw**/

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
