package com.bridgelabz.dataStructure_programs;

import java.io.FileNotFoundException;
import java.io.IOException;
import com.bridgelabz.util.HashingFunction;
import com.bridgelabz.util.Utility;
/**
 * @author Rupeshp007
 * date:30/11/2019
 * Purpos:To create hashing table to data based on hashcode using singly linkedlist.
 * suppose we want to store data 26.
 * 26%11=4 it will store data on 4th location
 * 44%11=4 its aslo store on 4th location
 * 22%11=2
 * 33%11=3
 * so finally
 * 				(2)->22
 * 				(3)->33
 * 				(4)->44,26
 **********************************************************************************/

public class Hashing 
{
	static int size;
	static HashingFunction hashing=new HashingFunction();
	
	static String filename="G:\\Bridgelabz\\Bridgelabz\\src\\com\\bridgelabz\\DataStructurePrograms\\OrderList.txt";
	
	public static void main(String[] args) throws FileNotFoundException, IOException 
	{
		int[] list=OrderedList.ReadFile(filename);
		
		for(int i:list)
		{
			hashing.put(i);
		}
		
		System.out.println("Enter the Number you want to search");
		int search=Utility.InputInt();
		SearchElement(search);
	}
	
	public static void SearchElement(int ele)
	{
		boolean result=hashing.search(ele);
		if(result)
		{
			System.out.println(ele+"Element is found and removed successfully");
			hashing.removeElement(ele);
		}
		else
		{
			System.out.println("Element not found and added to file");
			Utility.WriteinFile(ele, filename);
		}
	}
}
