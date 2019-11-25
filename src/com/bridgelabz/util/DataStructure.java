package com.bridgelabz.util;
import com.bridgelabz.util.Utility;
public class DataStructure 
{
	static Utility util=new Utility();
	
   /****************************************************************************** 
	* Date: 15/11/2019
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
	*   Date: 15/11/2019
	*   Purpose: To Search the words taken from LinkedList and add to list if not present List
	*   		 if present then remove from LinkedList
	*   @param no String word,LinkedListiml<T>
	*   @return void
	******************************************************************************/
	public static <T>void SearchWord(T word, LinkedListiml<T> list) 
	{
		if(!list.searchNode((T) word))
		{
			list.add((T) word);
			System.out.println(word+" Not Present in list and now added to list");
		}
		else
		{
			list.removeNode((T) word);
			System.out.println(word+" it was alrady in lIST and Removed from List");
		}
		list.Display();
	}
	
	
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
}


