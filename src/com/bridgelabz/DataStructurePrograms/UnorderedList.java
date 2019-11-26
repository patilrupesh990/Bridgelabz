package com.bridgelabz.DataStructurePrograms;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.bridgelabz.AlgorithmPrograms.Generics.Utility;
import com.bridgelabz.util.AlgorithmPrograms;
import com.bridgelabz.util.DataStructure;
import com.bridgelabz.util.LinkedListiml;

/*****************************************************************************************
 * Purpose Read the Text from a file, split it into words and arrange it as UnOrderes Linked List.
 * Take a user input to search a Word in the List. If the Word is not found then add it
 * to the list, and if it found then remove the word from the List. In the end save the
 * list into a file
 * @author Rupeshp007
 * date:22/11/2019
 * @version 1.0
 **********************************************************************************/
public class UnorderedList 
{
	static LinkedListiml<String> list=new LinkedListiml<String>();
	static DataStructure unlist=new DataStructure();
	
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws FileNotFoundException, IOException 
	{
		Utility util=new Utility();
		String FileName="E:\\project p\\BinarySearch.txt";
		
		AlgorithmPrograms unorlist=new AlgorithmPrograms();
		
		String words[]=unorlist.ReadFile(FileName);
		list=unlist.add2List(words, list);
		
		while(true)
		{
			System.out.println();
			System.out.println("Enter your choice:");
			System.out.println("1.search press any key for exit");
			int i=util.InputInt();
			if(i==1)
			{
			list.Display();
			System.out.println();
			System.out.println("Enter the word you want to search");
			String word=util.InputString();
			
			unlist.SearchWord(word, list);
			list.Display();
			}
			else
			{
				System.exit(0);
			}
		}
	}
}