package com.bridgelabz.testing;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import com.bridgelabz.DataStructurePrograms.BalancedParentheses;
import com.bridgelabz.DataStructurePrograms.OrderedList;
import com.bridgelabz.util.LinkedListiml;

public class DataStructure {

	@Test
	public void BalancedParenthesTest()
	{
		String expr="(a+b(a+c)";
		String result=com.bridgelabz.util.DataStructure.BalanaceParenthes(expr);
		assertTrue("not balanced", result!="balaced");
	}
	
	//values for OrderedList
	int list[]= {};	
	String fileName="G:\\Bridgelabz\\Bridgelabz\\Testings\\com\\bridgelabz\\testing\\OrderListTest.txt";
	static LinkedListiml<Integer> al=new LinkedListiml<Integer>();
	int result[]=new int[6];
}
