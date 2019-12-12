package com.bridgelabz.util;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.function.Predicate;

import com.bridgelabz.util.Utility;
/*************************************************************************************
 * purpose:ontains the Methods Related to DataStructure
 * @author Rupeshp007
 * date:23/11/2019
 * @version 1.0
*****************************************************************************************/

public class DataStructure 
{
	
	
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
			
			Utility.WriteinFile(word,"/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/datastructureprograms/UnorderFile.txt");
			
		}
		else
		{
			list.removeNode((T) word);
			System.out.println(word+" it was alrady in lIST and Removed from List");
			Utility.DeleteFromeFile("/home/user/Documents/FellowShip/FellowShipProject/src/com/bridgelabz/datastructureprograms/UnorderFile.txt", word);;
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
		char[] character=expr.toCharArray();
		for(char index:character)
		{
			if(index=='('||index=='{'||index=='[') 
			{
				try {
			  Stack.push(index);	
				}
				catch (Exception e) {
					// TODO: handle exception
					System.out.println();
				}
			}
			else if(index==')'||index=='}'||index==']')
			{
				char last=index;
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
	public static void StartCounter(int number)
	{
		int size=number;
		double cash=2000000.00;
		Queue.setSize(size);
		for(int index=1;index<=size;index++)
		{
			Queue.insert(index);
		}
		while(true)
		{
				System.out.println(size+"people standing in queue");
				System.out.println("1.CallNext Customer 2.Add people in queue 3.close counter");
				int action=Utility.InputInt();
				switch(action)
				{
					case 1:
							
								if(!(Queue.isEmpty()))
								{
									cash=callNext(cash);
									size--;
									Queue.detete();
								}
								else
								{
									System.out.println("===========================================================================================");
									System.out.println(" Queue is Empty please add people in queue");
									size=DataStructure.addPeople(size);
								}
								break;
								
					case 2:	
							Queue.reset();
							System.out.println("Enter the number of people");
							size=DataStructure.addPeople(size);
							break;
					case 3:	
							System.out.println("Cash counter closed final Amount:"+cash);
							System.exit(0);
					default:
							System.out.println("invalid option:");
				}	
				
				
				
				
			
		}//end while loop
	}//end startcounter
	
	
	
	
	public static int addPeople(int size)
	{
		System.out.println("Enter the number of people");
		int number=Utility.InputInt()+size;
		Queue.setSize(number);
		for(int index=0;index<number;index++)
		{
			Queue.insert(index);
		}
		return number;
	}
	
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
		int input=Utility.InputInt();
		switch(input)
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
		System.out.println("Enter the Deposite Amount");
		double deposite=Utility.InputDouble();
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
		
		
		System.out.println("Enter the withdrow Amount");
		double withdrow=Utility.InputDouble();
		if(withdrow>current)
		{
			System.out.println("Sorry cash not available more then"+current+"Rs.");
			DataStructure.callNext(current);
			return current;
		}
		else {
		total=current-withdrow;
		System.out.println("Successfully withdraw"+withdrow+"Rs.");
		System.out.println("Available Cash"+total);
		System.out.println("=======================================================================================");
		return total;
		}
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
		for(int count2=min;count2<=max;count2++)
		{
			int count=0;
			for(int count3=1;count3<=count2;count3++)
			{
				if(count2%count3==0)
				{
					count++;
				}
			}
			if(count==2)
			{
				primes[index++]=count2;
				System.out.print(count2+" ");
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
					result[0][a++]=primes[i];
				else if(primes[i]>101&&primes[i]<200)
					result[1][b++]=primes[i];
				else if(primes[i]>201&&primes[i]<300)
					result[2][c++]=primes[i];
				else if(primes[i]>301&&primes[i]<400)
					result[3][d++]=primes[i];
				else if(primes[i]>401&&primes[i]<500)
					result[4][e++]=primes[i];
				else if(primes[i]>501&&primes[i]<600)
					result[5][f++]=primes[i];
				else if(primes[i]>601&&primes[i]<700)
					result[6][g++]=primes[i];
				else if(primes[i]>701&&primes[i]<800)
					result[7][h++]=primes[i];
				else if(primes[i]>801&&primes[i]<900)
					result[8][j++]=primes[i];
				else if(primes[i]>901&&primes[i]<1000)
					result[9][k++]=primes[i];
			}//for
			
			return result;
		}//end primenumbers
		
		
		/**************************************************************************************************** 
		*   Date: 26/11/2019
		*   Purpose:Takes array of prime numbers and divide them in Anagrams numbers and Non Anagrams Numbers
		*   		and stored in 2D Array and print  
		*   @param int primes (array of prime numbers(0-100))
		 * @return 
		*   @return int[] (anagrams list)
		******************************************************************************************************/		
		
		public static int[] primeAnagrams3(int primes[])
		{
				// logic to check prime numbers are anagram or not
			int temp[]=new int[1000];
			int count=0;
			for (int index = 0; index < primes.length; index++) {
					for (int index2 = index + 1; index2 < primes.length; index2++) {
						if (Utility.isAnagram(primes[index], primes[index2]) && (primes[index] != 0 && primes[index2] != 0)) {
							System.out.println(primes[index] + " " + primes[index2]);
							temp[count++]=primes[index];
							temp[count++]=primes[index2];
						}
					}
				}
			int anagram[]=new int[count];
			anagram=temp;
			return anagram;
			}

		
		
		/**************************************************************************************************** 
		*   Date: 26/11/2019
		*   Purpose:To Divedigit for given Number
		*   @param int Number
		*   @return int
		******************************************************************************************************/		
				
		public static int dividedigit(int number)
			{
				int tempNumber=number;
				int sum[]=new int[3];
				int tempvariable=0;
				while(tempNumber>0)
				{
					int rem=tempNumber%10;
					sum[tempvariable++]=rem;
					tempNumber=tempNumber/10;
				}
				Arrays.sort(sum);
				int sorted=0;
				for(int count=0;count<tempvariable;count++)
				{
					sorted+=(10*sorted)+sum[count];
				}
				
				return sorted;
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
			
			for(int index=0;index<anagram.length;index++)
			{
				LinkedListiml<Integer> linklist=new LinkedListiml<Integer>();
				linklist.add(anagram[index]);
				linklist.add2Stack();
				stackanag[index]=Stack.peek().toString();
			}
			System.out.println();
			System.out.println("stack anagrams entry");
			
			for(int index2=stackanag.length-1;index2>=0;index2--)
			{
				if(!stackanag[index2].equals("0"))
				System.out.print(stackanag[index2]+" ");
			}
			
			//add in queue using linkedlist
			String queueanag[]=new String[anagram.length];
			Queue.setSize(anagram.length);
			
			for(int index3=0;index3<anagram.length;index3++)
			{
				LinkedListiml<Integer> linklist2=new LinkedListiml<Integer>();
				linklist2.add(anagram[index3]);
				linklist2.add2Queue();
				queueanag[index3]=Queue.detete().toString();
			}
			System.out.println();
			System.out.println("Queue anagrams entry");
			
			for(int index4=0;index4<queueanag.length;index4++)
			{
				if(!queueanag[index4].equals("0"))
				System.out.print(queueanag[index4]+" ");
			}
			
		}//end whole primes operations
		/**************************************************************************************************** 
		*   Date: 26/11/2019
		*   Purpose:Takes months,day,and year as input and returns odd days to the class 
		*   @param int month,day,year
		*   @return int
		******************************************************************************************************/			
		 public static int day(int month, int day, int year) {
		        int y = year - (14 - month) / 12;
		        int x = y + y/4 - y/100 + y/400;
		        int m = month + 12 * ((14 - month) / 12) - 2;
		        int d = (day + x + (31*m)/12) % 7;
		        return d;
		    }
		 
		 
		 /**************************************************************************************************** 
			*   Purpose:Takes year as input and returns true if year is Leap Year
			*   @param int year
			*   @return boolean
			******************************************************************************************************/			
		 Predicate<Integer>p=year->((year%4==0&&year%100!=0)||year%400==0);

		 
	
	
	
}


