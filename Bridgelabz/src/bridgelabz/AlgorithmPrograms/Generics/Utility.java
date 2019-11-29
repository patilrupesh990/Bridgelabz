package com.bridgelabz.AlgorithmPrograms.Generics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedSet;


public class Utility {
	public static Scanner scanner=new Scanner(System.in);
	static Utility util=new Utility();
	
	
	/**Redylymade input methods using Scanner class**/
	
	/** for take Integer input
	 * @param no param
	 * @return integer
	 * **/
	public int InputInt()
	{
		int int_variable=scanner.nextInt();
		return int_variable;
	}
	/** for take Float input
	 * @param no param
	 * @return float
	 * **/
	public float InputFloat()
	{
		float float_varialble=scanner.nextFloat();
		
		return float_varialble;
	}
	
	/** for take Character input
	 * @param no param
	 * @return character
	 * **/
	public char InputChar()
	{
		char char_variable=scanner.next().charAt(0); 
		return char_variable;
	}
	
	/** for take String input from scanner
	 * @param no param
	 * @return String
	 * **/
	public String InputString()
	{
		String string_variable=scanner.next(); 
		return string_variable;
	}
	
	/** for take Double input
	 * @param no param
	 * @return double
	 * **/
	public double InputDouble()
	{
		double double_variable=scanner.nextDouble();
		
		return double_variable;
	}
	
	/** for take Boolean input
	 * @param no param
	 * @return boolean
	 * **/
	public boolean InputBoolean()
	{
		boolean boolean_variable=scanner.nextBoolean();
		return boolean_variable;
	}
	//end of input methods
	
	/**
	 * Porpose:For Sorting string elements in ArrayList and print the ArrayList in ascending order.
	 * @param names al
	 * @param key ArrayList<String>
	 * @return void
	 **/
	public void InsertionSort(ArrayList<String> al)
	{
		for(int i=0;i<al.size()-1;i++)
		{
			for(int j=i+1;j<al.size();j++)
			{
				String temp;
				if(al.get(i).compareTo(al.get(j))>0)
				{
					temp=al.get(i);
					al.set(i, al.get(j));
					al.set(j,temp);
				}
			}
		}
		System.out.println("Array After Sort");
		for(String s:al)
		{
			System.out.println(s);
		}
	}
	/**
	 * Porpose:to find read word from (,) separated lines from TextFile
	 * @param names FileName
	 * @param key String
	 * @return ArrayList<String> of words
	 **/	
	public ArrayList<String> ReadFile(String FileName) throws IOException,FileNotFoundException
	{
		File file;
		file=new File(FileName);
		FileReader filereader=null;
		BufferedReader b_reader;
		String line="";
		ArrayList<String> al=new ArrayList<String>();
		
			filereader = new FileReader(file);
			b_reader=new BufferedReader(filereader);
			String temp="";
		while((temp=b_reader.readLine())!=null)
		{
			line+=temp;
		}
		String s[]=line.split(",");
		for(int i=0;i<s.length;i++)
		{
			al.add(s[i]);
		}
		b_reader.close();
		return al;
	}
	
	/**
	 * Porpose:to find perticuler word from sortedList in ascending order,
	 * and prints the given word is found or not if found prints its location   
	 * @param names names,key(word)
	 * @param key SortedSet,String
	 * @return void
	 **/
	@SuppressWarnings("rawtypes")
	public void SearchWord(SortedSet s,String word)
	{
		@SuppressWarnings("unchecked")
		ArrayList<String> al=new ArrayList<String>(s);
		int first=0;
		int last=s.size();
		while(first<last)
		{
			int mid=(first+last)/2;
			if(word.compareTo(al.get(mid))<0)
			{
				last=mid;
			}
			else if(word.compareTo(al.get(mid))>0)
			{
				first=mid+1;
			}
			else
			{
				System.out.println(al.get(mid)+"word found at index "+mid);
				break;
			}
		}
		System.out.println("word not found");
		
	}
	/**
	 * Porpose:For Sorting string elements in ArrayList and print the ArrayList in ascending order.
	 * @param  names String words 
	 * @param key ArrayList<String>
	 * @return void
	 * @algorithm BubbleSort
	 **/
	
	
	public void BubbleSort(ArrayList<Integer> al)
	{
		for(int i=0;i<al.size();i++)
		{
			for(int j=0;j<al.size()-1;j++)
			{
				int temp=0;
				if(al.get(j).compareTo(al.get(j+1))>0)
				{
					temp=al.get(j);
					al.set(j, al.get(j+1));
					al.set(j+1,temp);
				}
			}
		}
		for(int k:al)
		{
			System.out.println("Elements After BubbleSort:"+k);
		}
	}
	
	@SuppressWarnings("null")
	public ArrayList<String> MergeSort(ArrayList<String> al)
	{
		ArrayList<String> sorted=al;
		if(al.size()==1)
		{
			return al;
		}
		else
		{
			ArrayList<String> left;
			ArrayList<String> right;
			int mid=0;
			if(al.size()%2==0)
			{
				mid=al.size()/2;
				left=new ArrayList<String>(mid);
				right = new ArrayList<String>(mid);
			}
			else
			{
				mid=al.size()/2;
				left=new ArrayList<String>(mid);
				right = new ArrayList<String>(mid+1);
			}
			int x=0;
			int y=0;
			for(;x<mid;x++)
			{
				left.add(x,al.get(x));
			}
			for(;x<al.size();x++)
			{
				right.add(y++,al.get(x));
				
			}
			left=MergeSort(left);
			right=MergeSort(right);
			sorted=MergeList(left,right);
			//return sorted;
		}
		return sorted;
		
	}//end
	
	public ArrayList<String> MergeList(ArrayList<String> left,ArrayList<String> right)
	{
		ArrayList<String> merge=new ArrayList<String>();
		int l=0,r=0,c=0,m=0;
		
		while(l<left.size()||r<right.size())
		{
			if(r==right.size())
			{
				merge.add(m++, left.get(l++));
			}
			else if(l==left.size())
			{
				merge.add(m++,right.get(r++));
			}
			else
			{
				c=left.get(l).compareTo(right.get(r));
				if(c>0)
				{
					merge.add(m++,right.get(r++));
				}
				if(c<0)
				{
					merge.add(m++, left.get(l++));
				}
				else
				{
					merge.add(m++,left.get(l++));
				}
			}
		}
		return merge;
	}
	
	
}



