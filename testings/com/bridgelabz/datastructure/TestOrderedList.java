package com.bridgelabz.datastructure;


import java.io.FileNotFoundException;
import java.util.Arrays;

import org.junit.Test;

import com.bridgelabz.datastructureprograms.OrderedList;
import com.bridgelabz.util.DataStructure;
import com.bridgelabz.util.LinkedListiml;
/**
* Author: RupeshPatil
* Date: 28/11/2019
* Purpose:To Test Working modules of TestOrder 
**/
public class TestOrderedList 
{
	
	@Test
	public void ReadFile()
	{
		String filename="G:\\\\Bridgelabz\\\\Bridgelabz\\\\src\\\\com\\\\bridgelabz\\\\DataStructurePrograms\\\\OrderList.txt";
		int[] result=OrderedList.ReadFile(filename);
		int[] list= {1,2,3,4,5,3,2,34,4,43,3,3,2,2,2,34,343,43,3,5,3454,32,21,32,321,321,3421,34231,3423,4,45454,54,54,54,54,5232,2321,321,3432,534,4,54,4532,5,101,101,32,10,6,7};
		assertEquals(list, result, 1);
	}
	
	@Test
	public void SearchWord()
	{
		LinkedListiml<Integer> list=new LinkedListiml<Integer>();
		
		int[] arr= {1,2,3,4,5,3,2,34,4,43,3,3,2,2,2,34,343,43,3,5,3454,32,21,32,321,321,3421,34231,3423,4,45454,54,54,54,54,5232,2321,321,3432,534,4,54,4532,5,101,101,32,10,6,7};
		Arrays.sort(arr);
		for(int i:arr)
		{
			list.add(i);
		}
		
		try {
			DataStructure.SearchWord(111, list);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("111 Not Present in list and now added to list");
	}
	
	

	private void assertEquals(String string) {
		// TODO Auto-generated method stub
		
	}

	private void assertEquals(int[] list, int[] result, int i) {
		// TODO Auto-generated method stub
		
	}
}
