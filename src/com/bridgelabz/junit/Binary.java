package com.bridgelabz.junit;

import com.bridgelabz.util.Utility;
public class Binary 
{
	public static void main(String[] args) 
	{
		//int nibble[]=Utility.toBinary(result);
			int result=swapNibbles(100);
}
	static int swapNibbles(int x) 
	{ 
	    return ((x & 0x0F) << 4 | (x & 0xF0) >> 4); 
	} 
}
