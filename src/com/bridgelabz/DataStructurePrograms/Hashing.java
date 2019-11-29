package com.bridgelabz.DataStructurePrograms;

import java.io.FileNotFoundException;
import java.io.IOException;
import com.bridgelabz.util.HashingFunction;
import com.bridgelabz.util.Utility;

public class Hashing 
{
	static int size;
	static HashingFunction hashing=new HashingFunction();
	static Utility util=new Utility();
	static String filename="G:\\Bridgelabz\\Bridgelabz\\src\\com\\bridgelabz\\DataStructurePrograms\\OrderList.txt";
	
	public static void main(String[] args) throws FileNotFoundException, IOException 
	{
		int[] list=OrderedList.ReadFile(filename);
		
		for(int i:list)
		{
			hashing.put(i);
		}
		
		System.out.println("Enter the Number you want to search");
		int search=util.InputInt();
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
