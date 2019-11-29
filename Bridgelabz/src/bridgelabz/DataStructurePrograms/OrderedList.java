package com.bridgelabz.DataStructurePrograms;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import com.bridgelabz.util.DataStructure;
import com.bridgelabz.util.LinkedListiml;
import com.bridgelabz.util.Utility;
 /*************************************************************************************
  * purpose: Read a List of Numbers from a file and arrange it ascending Order in a
  * Linked List. Take user input for a number, if found then pop the number out of the
  * list else insert the number in appropriate position.
  * @author Rupeshp007
  * date:23/11/2019
  * @version 1.0
*****************************************************************************************/
public class OrderedList 
{
	static LinkedListiml<Integer> list=new LinkedListiml<Integer>();
	static Utility util=new Utility();
	public static <T> void main(String[] args) throws FileNotFoundException, IOException 
	{
		String filename="D:\\c drive\\new Desktop\\Brigezlebz\\Bridgelabz\\src\\com\\bridgelabz\\DataStructurePrograms\\OrderList.txt";
				
		 int numbers[]=OrderedList.ReadFile(filename);
		 Arrays.sort(numbers);
		 list=DataStructure.add2List2(numbers, list);
		 
		 list.Display();
		 
		 System.out.println("Enter The Number you want to search");
		 int number=util.InputInt();
		 DataStructure.SearchWord(number, list);
	}
	
	/*****************************************************************************
	 * Porpose:to find read Numbers from (,) separated lines from TextFile       *
	 * @param names FileName                                                     *
	 * @param key String                                                         *
	 * @return int[] array of Numbers                                            *
	 *****************************************************************************/	
	
	public static int[] ReadFile(String FileName) throws IOException,FileNotFoundException
	{
		File file;
		file=new File(FileName);
		FileReader filereader=null;
		BufferedReader b_reader;
		String temp= "";
		String line="";
		
			filereader = new FileReader(file);
			b_reader=new BufferedReader(filereader);
	
		while((temp=b_reader.readLine())!=null)
		{
			line+=temp;
		}
		
		String[] temp2= line.split(",");
		int words[]=new int[temp2.length];
		 int i=0;
		 for(String s:temp2)
		 {
			 words[i++]=Integer.parseInt(s);
		 }
		//List word=new List();
		b_reader.close();
		return words;
	}
}
