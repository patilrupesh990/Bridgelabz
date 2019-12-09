package com.bridgelabz.datastructure;

import org.junit.Test;

import com.bridgelabz.util.DataStructure;

/**
* Author: RupeshPatil
* Date: 28/11/2019
* Purpose:To Test Working modules of Check Prime Numbers
***********************************************************************/

public class TestPrimeNo {

/**To test prime numbers in min and max range**/
	@Test
	public void Test_PrimeNo_when_input_zeroTOten_Rang_output_Sholdbe_two_three_five_seven()
	{
		
		int result[]=DataStructure.PrimesInRange(0, 10);
		int aspected[]= {2,3,5,7};
		assertArrayEquals(aspected,result,1);
	}

	private void assertArrayEquals(int[] aspected, int[] result, int i) {
		// TODO Auto-generated method stub
		
	}
	

}
