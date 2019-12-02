package com.bridgelabz.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class AlgorithmPrograms
{
	static Utility util=new Utility();
	/**
	 * Porpose:to find read word from (,) separated lines from TextFile
	 * @param <T>
	 * @param names FileName
	 * @param key String
	 * @return String[] array of words
	 **/	
	
	@SuppressWarnings("unchecked")
	public <T> T ReadFile(String FileName) throws IOException,FileNotFoundException
	{
		File file;
		file=new File(FileName);
		FileReader filereader=null;
		BufferedReader b_reader;
		String line="";
		T temp=null;
		
			filereader = new FileReader(file);
			b_reader=new BufferedReader(filereader);
	
		while((temp=(T) b_reader.readLine())!=null)
		{
			line+=temp;
		}
		
		T words=(T) line.split(",");
		//List word=new List();
		b_reader.close();
		return (T) words;
		
	}
	
	
	/**
	 * Porpose:to find perticuler word from sorted ArrayList in ascending order
	 * @param names names,key(word)
	 * @param key String,String
	 * @return integer value
	 **/
	public  int searchString(String[] names, String key) 
	{
			    int first = 0;
			    int last  = names.length;
			 
			    while (first < last) {
			        int mid = (first + last) / 2;
			        if (key.compareTo(names[mid]) < 0) {
			            last = mid;
			        } else if (key.compareTo(names[mid]) > 0) {
			            first = mid + 1;
			        } else {
			            return mid;
			        }
			    }
			    
			    return -(first + 1);
	}//end Search String
	
	/**
	 * Porpose:For Sorting Integer elements in array and print the Array in ascending order.
	 * @param names array
	 * @param key int arr[]
	 * @return void
	 **/
	public void BubbleSort(int arr[])
	{
		for(int index1=0;index1<arr.length;index1++)
		{
			for(int index2=0;index2<arr.length-1;index2++)
			{
				int temp=0;
				if(arr[index2]>arr[index2+1])
				{
					temp=arr[index2];
					arr[index2]=arr[index2+1];
					arr[index2+1]=temp;
				}
			}
			
		}
		for(int index=0;index<arr.length;index++)
		{
			System.out.println("Elements in ascending order After Bubble Sort"+arr[index]);
		}
	}//end bubbleSort
	
	/**
	 * Porpose:For insert string Elements in array and call sort method. 
	 * @param names array,size
	 * @param key String[],int
	 * @return void
	 **/
		
	public String[] InsertElementInArray(String arr[],int size)
	{
		for(int index=0;index<size;index++)
		{
			arr[index]=util.InputString();
		}
		return arr;
		//
		
	}//end InsertArray
	
	
	/**
	 * Porpose:For Sorting string elements in array and print the Array in ascending order.
	 * @param names array
	 * @param key String[]
	 * @return void
	 **/
	public static void Insertionsort(String arr[])
	{
		String temp;
		for(int index=0;index<arr.length-1;index++)
		{
			for(int index2=index+1;index2<arr.length;index2++)
			{
				if(arr[index].compareTo(arr[index2])>0)
				{
					temp=arr[index];
					arr[index]=arr[index2];
					arr[index2]=temp;
				}
			}
		}
		for(int index=0;index<arr.length;index++)
		{
			System.out.println("After the Insertion sort"+arr[index]);
		}
	}// end of InsertionSort
	/**
	 * Porpose:For Sorting String elements its divides 
	 * the array in equal parts and pass left and right arrays for Merge and sort to Merge().
	 * @param String[] list array
	 * @param key String list[]
	 * @return String[]
	 **/
	
	public String[] MergeSort(String[] list)
	{
		String sorted[]=list;
		
		
		
		if(list.length==1)
		{
			sorted=list;
		}
		else
		{
			int mid=list.length/2;
			String left[]=null;
			String right[]=null;
			if(list.length%2==0)
			{
				left=new String[list.length/2];
				right=new String[list.length/2];
			}
			else
			{
				left=new String[list.length/2];
				right=new String[(list.length/2)+1];
			}
				int index1=0;
				int index2=0;
				for(;index1<mid;index1++)
				{
					left[index1]=list[index1];
				}
				for(;index1<list.length;index1++)
				{
					right[index2++]=list[index1];
				}
				left=MergeSort(left);
				right=MergeSort(right);
				sorted=Merge(left,right);
		}
		return sorted;
	}
	
	/**
	 * Porpose:It Takes the left and right parts of array and and Merging them in Sorted Order 
	 * @param String[] left array,String right[]
	 * @return String[]
	 **/
	public String[] Merge(String[] left,String[] right)
	{
		String merge[]=new String[left.length+right.length];
		int r=0;
		int l=0;
		int c=0;
		int m=0;
		
		while(l<left.length||r<right.length)
		{
			if(r==right.length)
			{
				merge[m++]=left[l++];
			}
			else if(l==left.length)
			{
				merge[m++]=right[r++];
			}
			else
			{
				c=left[l].compareTo(right[r]);
				if(c>0)
				{
					merge[m++]=right[r++];
				}
				else if(c<0)
				{
					merge[m++]=left[l++];
				}
				else
				{
					merge[m++]=left[l++];
				}
			}
		}
		return merge;
	}//End MergeSort
	/**
	 * Porpose:It takes primes arrays as input and find the Prime Anagrams and Palindrome from the Primes array
	 * @param int primes[] array of primes between 0 - 1000  
	 * @return Void
	 * it will print Primes Anagrams
	 **/
		public void PrimePalindrome(int primes[])
	   {
		int temp[]=new int[100];
		int count=0;
		for(int index=0;index<primes.length;index++)
		{
			if(primes[index]>10)
			{
				int temp2=0;
				int temp3=primes[index];
				while(temp3>0)
				{
					
					int rem=temp3%10;
					temp2=temp2*10+rem;
					temp3=temp3/10;
				}
				if(temp3==primes[index])
				{
					temp[count]=primes[index];
					count++;
				}
			}
		}
			
		
		int temp2[]=new int[1000];
		int count2=0;
		System.out.println("Prime Anagram");
		for (int k = 0; k < primes.length; k++) {
				for (int j = k + 1; j < primes.length; j++) {
					if (Utility.isAnagram(primes[k], primes[j]) && (primes[k] != 0 && primes[j] != 0)) {
						System.out.println(primes[k] + " " + primes[j]);
						temp2[count2++]=primes[k];
						temp2[count2++]=primes[j];
					}
				}
			}
		int primepalindrome[]=new int[count];
		primepalindrome=temp;
		

		System.out.println("Prime Palindrome");
		for(int index=0;index<count;index++)
		{
			System.out.print(primepalindrome[index]);
		}
		
	}//prime palindrome and anagram
		
		public void Anagram(char[]chararray1,char[]chararray2)
		{
			if(chararray1.length!=chararray2.length)
			{
				System.out.println("Two Strings are not anagram");
			}
			else
			{
				int count=0;
				Arrays.sort(chararray1);
				Arrays.sort(chararray2);
				for(int index=0;index<chararray1.length;index++)
				{
					if(chararray1[index]==chararray2[index])
					{
						count++;
					}
				}
				if(count==chararray1.length)
				{
					System.out.println("Two Strings Are Anagram");
				}
				else
				{
					System.out.println("Two Strings Are not Anagram");
				}
			}
		}//
		/**********************************************************************
		 * Porpose:To Search the Number Guess by the user using Binary Search
		 * @param int lower,int upper,int middle,int count,String input  
		 * @return Void
		 * it will print the Number Guess By the User
		 ***********************************************************************/
		public  static void binarySearch(int lower,int upper,int middle,int count,String input,int n)
	   	{
			
	       	System.out.println("Is your number:"+middle);
			System.out.println();
			System.out.println("Enter your answer in 'yes' or 'high' or 'low'");
			input=util.InputString();
	       	do
	        {
	            if (input.equals("high"))
	            {
					lower= middle;
					count++;
	            }
		    else if (input.equals("yes"))
	            {
					System.out.println("The number you thought was: "+middle);
					int number=++count;
					System.out.println("It takes "+number+" times to find your exact number");
					break;
	            }
				else if(input.equals("low"))
	            {
					upper=middle;
					count++;
				}
	            if(count<n)
	            {
					middle=(lower+ upper+1)/2;
					System.out.println("Is your number "+middle+":");
					input=util.InputString();
				}
			}
			while(lower<=upper);
				if (count>n)
				{
					System.out.println("Number not found");
				}
				else
				{
					System.exit(0);
				}
			}
		
}
