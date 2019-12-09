package com.bridgelabz.logicalprograms;

import com.bridgelabz.util.LogicalProgram;
import com.bridgelabz.util.Utility;
/**
* Author: RupeshPatil
* Date: 16/11/2019
* Purpose:Generate A Random code coupen as per user user size limit 
* e.g user i/p:7
* o/p:aVS5fG4
**/

public class CoupenCode 
{
	public static void main(String[] args) 
	{

		System.out.println("How many numbers you want?");
		int max=Utility.InputInt();
		String code=LogicalProgram.GenerateCode(max);
		System.out.println("Coupen Code:"+code);
	}
}
