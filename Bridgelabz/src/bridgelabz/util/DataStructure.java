package com.bridgelabz.util;
import java.io.FileNotFoundException;

import com.bridgelabz.util.Utility;
public class DataStructure 
{
	static Utility util=new Utility();
	
   /****************************************************************************** 
	* Date: 22/11/2019
	* Purpose: To add the words taken from file into LinkedList and Generate List
    * @param <B>
	* @param no String words[],LinkedListiml<T>
	* @return LinkedListiml<T> list
	******************************************************************************/
	
	public static <T> LinkedListiml<T> add2List(T words[],LinkedListiml<T> list)
	{
		for(T s:words)
		{
			list.add((T) s);
		}
		return list;
	}
	public static <T> LinkedListiml<Integer> add2List2(int numbers[],LinkedListiml<Integer> list)
	{
		for(int i:numbers)
		{
			list.add((Integer) i);
		}
		return list;
	}
	/****************************************************************************** 
	*   Date: 22/11/2019
	*   Purpose: To Search the words taken from LinkedList and add to list if not present List
	*   		 if present then remove from LinkedList
	*   @param no String word,LinkedListiml<T>
	*   @return void
	 * @throws FileNotFoundException 
	******************************************************************************/
	
	
	
	public static <T>void SearchWord(T word, LinkedListiml<T> list) throws FileNotFoundException 
	{
		if(!list.searchNode((T) word))
		{
			list.add((T) word);
			System.out.println(word+" Not Present in list and now added to list");
			list.WriteinFile();
		}
		else
		{
			list.removeNode((T) word);
			System.out.println(word+" it was alrady in lIST and Removed from List");
		}
		list.Display();
	}
	
	/****************************************************************************** 
	*   Date: 24/11/2019
	*   Purpose:To push '(', '{' and '[' in the Stack and if related closing braces found
	*   		then it will pop lastly if stack will goes empty then return msg "Balanced".
	*   @param no String expression
	*   @return String message
	******************************************************************************/
	public static String BalanaceParenthes(String expr)
	{
		char[] c=expr.toCharArray();
		for(char i:c)
		{
			if(i=='('||i=='{'||i=='[') 
			{
			  Stack.push(i);	
			}
			else if(i==')'||i=='}'||i==']')
			{
				char last=i;
				String x=Stack.peek();
				char first=x.charAt(0);
				if(first=='{'&&last=='}'||first=='['&&last==']'||first=='('&&last==')')
				{
					Stack.pop();
				}
				else
				{
					return "not balanced";
				}
			}
		}
		if(Stack.isEmpty())
		return "balanced";
		else
			return"not balanced";	
	}//BalancedParanthes End
	
	
	/*************************************************************************************** 
	*   Date: 25/11/2019
	*   Purpose:To add the peoples in cashcounter queue its gives options to cashier  
	*   		want to withdraw transaction or deposite and also can add people in queue and close counter
	*   @param no param
	*   @return void
	*************************************************************************************/
	public static void StartCounter()
	{
		int size=2;
		double cash=2000000.00;
		
		
		Queue.setSize(size);
		System.out.println("initially "+size+" people standing in queue");
		for(int i=1;i<=size;i++)
		{
			Queue.insert(i);
		}
		while(true)
		{
				
				System.out.println("1.CallNext Customer 2.Add people in queue 3.close counter");
				int action=util.InputInt();
				switch(action)
				{
					case 1:
							if(Queue.isEmpty())
							{
								System.out.println("Queue is Empty");
								break;
							}
							else
							{
								cash=callNext(cash);
								break;
							}
							
					case 2:	
							Queue.reset();
							System.out.println("Enter the number of people");
							int x=util.InputInt();
							Queue.setSize(x);
							for(int i=0;i<x;i++)
							{
								Queue.insert(i);
							}
							break;
					case 3:	
							System.out.println("Cash counter closed final Amount:"+cash);
							System.exit(0);
					default:
							System.out.println("invalid option:");
				}	
				
				
				
				
			
		}//end while loop
	}//end startcounter
	
	
	/**************************************************************************************************** 
	*   Date: 25/11/2019
	*   Purpose:To add the peoples in cashcounter queue  and give unique tokenNo to each one and allow to cash withdraw and cash deposite
	*   		money and after that remove from queue.
	*   @param double cash
	*   @return double 
	******************************************************************************************************/

	static int token=1;
	public static double callNext(double cash)
	{
		System.out.println("Available Cash:"+cash+" Rs.");
		System.out.println("Enter the Input:");
		System.out.println("Token No:"+token);token++;
		System.out.println (" 1.Deposite  2.Withdraw ");
		int ch=util.InputInt();
		switch(ch)
		{
		case 1:
				cash=deposite(cash);
				break;
		case 2:
				cash=withdraw(cash);
				break;
		default:
				System.out.println("invalid Option");
		}
		return cash;
		
	}

	/**************************************************************************************************** 
	*   Date: 25/11/2019
	*   Purpose:Takes input from user and Deposite money in bank available balance.
	*   @param double (current cash available in bank)
	*   @return double (total after add money)
	******************************************************************************************************/

	
	public static double deposite(double current)
	{
		double total=0.0;
		
		Queue.detete();
		System.out.println("Enter the Deposite Amount");
		double deposite=util.InputDouble();
		total=current+deposite;
		System.out.println("Successfully Deposited"+deposite+"Rs.");
		System.out.println("Available Cash"+total);
		System.out.println("=======================================================================================");
		return total;
	}
	
	/**************************************************************************************************** 
	*   Date: 26/11/2019
	*   Purpose:Takes input from user and Withdraw money from bank available balance.
	*   @param double (current cash available in bank)
	*   @return double (total after add money)
	******************************************************************************************************/
	public static double withdraw(double current)
	{
		double total=0.0;
		
		Queue.detete();
		System.out.println("Enter the withdrow Amount");
		double withdrow=util.InputDouble();
		total=current-withdrow;
		System.out.println("Successfully withdraw"+withdrow+"Rs.");
		System.out.println("Available Cash"+total);
		System.out.println("=======================================================================================");
		return total;
	}
	
	
	
	/**************************************************************************************************** 
	*   Date: 26/11/2019
	*   Purpose:Takes maximum and minimum range from user and finds the Prime numbers within range.
	*   @param int min,int max (current cash available in bank)
	*   @return int[] (prime numbers array)
	******************************************************************************************************/
	public static int[] PrimesInRange(int min,int max)
	{
		int index=0;
		int primes[]=new int[700]; 
		for(int i=min;i<=max;i++)
		{
			int count=0;
			for(int j=1;j<=i;j++)
			{
				if(i%j==0)
				{
					count++;
				}
			}
			if(count==2)
			{
				primes[index++]=i;
				System.out.print(i+" ");
			}
		}
		return primes;
	}//
	/**************************************************************************************************** 
	*   Date: 26/11/2019
	*   Purpose:Takes array of prime numbers and divide them in the limits 0-100,100-200,200-300 so on,
	*   		and stored in 2D Array and re  
	*   @param int min,int max (current cash available in bank)
	*   @return int[][] (prime no as per limits)
	******************************************************************************************************/
		public static int[][] primesinlimit(int primes[])
		{
			int a=0,b=0,c=0,d=0,e=0,f=0,g=0,h=0,j=0,k=0;
			int result[][]=new int[10][25];
			for(int i=0;i<primes.length;i++)
			{
				if(primes[i]>0&&primes[i]<100)
				{
					result[0][a++]=primes[i];
				}
				else if(primes[i]>101&&primes[i]<200)
				{
					result[1][b++]=primes[i];
				}
				else if(primes[i]>201&&primes[i]<300)
				{
					result[2][c++]=primes[i];
				}
				else if(primes[i]>301&&primes[i]<400)
				{
					result[3][d++]=primes[i];
				}
				else if(primes[i]>401&&primes[i]<500)
				{
					result[4][e++]=primes[i];
				}else if(primes[i]>501&&primes[i]<600)
				{
					result[5][f++]=primes[i];
				}
				else if(primes[i]>601&&primes[i]<700)
				{
					result[6][g++]=primes[i];
				}
				else if(primes[i]>701&&primes[i]<800)
				{
					result[7][h++]=primes[i];
				}
				else if(primes[i]>801&&primes[i]<900)
				{
					result[8][j++]=primes[i];
				}
				else if(primes[i]>901&&primes[i]<1000)
				{
					result[9][k++]=primes[i];
				}
			}//for
			return result;
		}//end primenumbers
		/**************************************************************************************************** 
		*   Date: 26/11/2019
		*   Purpose:Takes array of prime numbers and divide them in Anagrams numbers and Non Anagrams Numbers
		*   		and stored in 2D Array and print  
		*   @param int primes (array of prime numbers(0-100))
		*   @return int[] (anagrams list)
		******************************************************************************************************/		
		
		public static int[] primeAnagrams(int primes[])
		{
			int temp[]=new int[500],temp2[]=new int[800],
					index=0,index2=0;
			for(int i=0;i<primes.length;i++)
			{
				if(primes[i]>0)
				{
					int t=primes[i];
					int rem=0;
					int sum=0;
					while(t>0)
					{
						rem=t%10;
						sum=(sum*10)+rem;
						t=t/10;
					}
					if(sum==primes[i]&&sum>10)
					{
						temp[index++]=primes[i];						
					}
					else
					{
						temp2[index2++]=primes[i];
						
					}
				}
			}//end for
			int anagram[]=new int[index2];
			anagram=temp;
			int not_anagram[]=new int[index2];
			not_anagram=temp2;
			index=0;index2=0;
			int result[][]=new int[2][1000];
//			System.out.println("Prime anagrams");

				for(int j=0;j<not_anagram.length;j++)
				{
						result[0][j]=not_anagram[j];
				}
				for(int j=0;j<anagram.length;j++)
				{
						result[1][j]=anagram[j];
				}
				System.out.println("Prime anagrams/not anagrams");
			for(int i=0;i<2;i++)
			{
				for(int j=0;j<not_anagram.length;j++)
				{
					if(result[i][j]>0)
					System.out.print(result[i][j]+" ");
				}
				System.out.println();
			}
			return anagram;
		}
		/**************************************************************************************************** 
		*   Date: 26/11/2019
		*   Purpose:Takes anagram numbers array and pass them to add linkedlist and after that that will access from stack and queue,
		*   and prints the anagrams in reverse oreder.  
		*   @param int anagrams[] (list of anagrams)
		*   @return void
		******************************************************************************************************/
		public static void AddAnagramLinkedList(int anagram[])
		{
			
			
			//add in stack using linkedlist
			String stackanag[]=new String[anagram.length];
			Stack.setStackSize(anagram.length);
			for(int i=0;i<anagram.length;i++)
			{
				LinkedListiml<Integer> linklist=new LinkedListiml<Integer>();
				linklist.add(anagram[i]);
				linklist.add2Stack();
				stackanag[i]=Stack.peek().toString();
			}
			System.out.println("stack anagrams entry");
			for(int j=stackanag.length-1;j>=0;j--)
			{
				if(!stackanag[j].equals("0"))
				System.out.print(stackanag[j]+" ");
			}
			
			//add in queue using linkedlist
			String queueanag[]=new String[anagram.length];
			Queue.setSize(anagram.length);
			for(int i=0;i<anagram.length;i++)
			{
				LinkedListiml<Integer> linklist2=new LinkedListiml<Integer>();
				linklist2.add(anagram[i]);
				linklist2.add2Queue();
				queueanag[i]=Queue.detete().toString();
			}
			System.out.println();
			System.out.println("Queue anagrams entry");
			for(int j=queueanag.length-1;j>=0;j--)
			{
				if(!queueanag[j].equals("0"))
				System.out.print(queueanag[j]+" ");
			}
			
		}//end whole primes operations
	
	
	
}


