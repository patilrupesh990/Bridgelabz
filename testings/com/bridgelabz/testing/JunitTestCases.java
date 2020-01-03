package com.bridgelabz.testing;

import static org.junit.Assert.*;
import org.junit.Test;
import com.bridgelabz.junit.MonthlyPayment;
import com.bridgelabz.util.DataStructure;
import com.bridgelabz.util.Utility;

/*********************************************************************************
 * @author Rupeshp007
 * date:28/11/2019
 * Purpose:Test cases for different functionalities .
 * 
 **********************************************************************************/


public class JunitTestCases {

	/** To test VendingMachine to count minimum notes for given amount**/	
	@Test
	public void VendingMachine()
	{
		int[] notes = { 1000,500,100,50,10,5,2,1};
		int result=com.bridgelabz.junit.VendingMachine.calculate(2430, notes);
		assertEquals(result, 9);
	}
	
	/** To test day of week by passing value of month odd day and year **/	
	@Test
	public void Dayweek()
	{
		
		int result=DataStructure.day(11, 28, 2019);
		assertEquals(result, 4);
	}
	
	/** To test conversation of tempurature convertion of 
	 * ferenhit to celsius and celsious to ferenhit **/
	@Test
		public void TempratureConversion()
		{
			double result=Utility.temperaturConversionToCelcius(50);
			assertEquals(10.5555555555555, result,1);
			
			double result4=Utility.temperaturConversionToCelcius(-30);
			assertEquals(-33.888888888888886, result4,1);
			
			double result2=Utility.temperaturConversionToFerenhit(510);
			assertEquals(542.0, result2,1);
			
			double result3=Utility.temperaturConversionToFerenhit(-10);
			assertEquals(22.0, result3,1);
		}
	/** To test monthly EMI payment based on principal Time in year and ratio of interast **/
	@Test
	public void payment()
	{
		double result=MonthlyPayment.payment(100, 10, 1);
		assertEquals(999.9999999999997, result,1);
	}
	/** To test conversion of Decimal to binary conversion **/
	@Test
	public void binaryCoversion()
	{
		int result[]=Utility.toBinary(106);
		int aspected[]= {0,1,0,1,0,1,1};
		assertArrayEquals(aspected, result);
		int result2[]=Utility.toBinary(7);
		int aspected2[]= {1,1,1};
		assertArrayEquals(aspected2, result2);
	}
	/** To test the squre root of number using newtons methodology **/
	@Test
	public void TestSqureRoot()
	{
		Utility util=new Utility();
		
		double result=util.SqurerootNewtonMethod(4);
		assertEquals(2, result,1);
		
		 result=util.SqurerootNewtonMethod(36);
		assertEquals(6, result,1);
		
		result=util.SqurerootNewtonMethod(5);
		assertEquals(2.23606797749979, result,1);
		
	}

}
