package com.bridgelabz.junit;

/************************************************************************************
 * @author Rupeshp007
 * date:28/11/2019
 
 **********************************************************************************/

public class Binary 
{
	public static void main(String[] args) 
	{
		//int nibble[]=Utility.toBinary(result);
			swapNibbles(100);
}
	static int swapNibbles(int x) 
	{ 
	    return ((x & 0x0F) << 4 | (x & 0xF0) >> 4); 
	} 
}
