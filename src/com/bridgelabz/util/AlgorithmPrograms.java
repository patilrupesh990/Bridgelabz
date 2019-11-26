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
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr.length-1;j++)
			{
				int temp=0;
				if(arr[j]>arr[j+1])
				{
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			
		}
		for(int i=0;i<arr.length;i++)
		{
			System.out.println("Elements in ascending order After Bubble Sort"+arr[i]);
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
		for(int i=0;i<size;i++)
		{
			arr[i]=util.InputString();
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
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i].compareTo(arr[j])>0)
				{
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		for(int i=0;i<arr.length;i++)
		{
			System.out.println("After the Insertion sort"+arr[i]);
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
				int i=0;
				int j=0;
				for(;i<mid;i++)
				{
					left[i]=list[i];
				}
				for(;i<list.length;i++)
				{
					right[j++]=list[i];
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
		for(int i=0;i<primes.length;i++)
		{
			if(primes[i]>10)
			{
				int t=0;
				int u=primes[i];
				while(u>0)
				{
					
					int rem=u%10;
					t=t*10+rem;
					u=u/10;
				}
				if(t==primes[i])
				{
					temp[count]=primes[i];
					count++;
				}
			}
		}
		int primepalindrome[]=new int[count];
		primepalindrome=temp;
		System.out.println("Prime Anagram and Palindrome are:");
		for(int j=0;j<count;j++)
		{
			System.out.println(primepalindrome[j]);
		}
		
	}//prime palindrome and anagram
		
		public void Anagram(char[]c1,char[]c2)
		{
			if(c1.length!=c2.length)
			{
				System.out.println("Two Strings are not anagram");
			}
			else
			{
				int count=0;
				Arrays.sort(c1);
				Arrays.sort(c2);
				for(int i=0;i<c1.length;i++)
				{
					if(c1[i]==c2[i])
					{
						count++;
					}
				}
				if(count==c1.length)
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
					int no=++count;
					System.out.println("It takes "+no+" times to find your exact number");
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
