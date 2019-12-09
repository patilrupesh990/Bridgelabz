package com.bridgelabz.datastructureprograms;
import com.bridgelabz.util.Utility;
/*************************************************************************************
 * purpose: To count No of binary trees with given input.
 * @author Rupeshp007
 * date:24/11/2019
 * @version 1.0
*****************************************************************************************/


class NumberOfBinaryTree { 
  
	/*****************************************************************************
	 * Porpose:to find Factorial of N numbers                                                   *
	 * @param int number                                                         
	 * @return long factorial of number                                            
	 *****************************************************************************/	
	static long factorial(int number) 
	{ 
		long res = 1; 
	  
	    // Calculate value of  
	    // [1*(2)*---*(n-k+1)] /  
	    // [k*(k-1)*---*1] 
	    for (int count = 1; count <= number; ++count) 
	    { 
	        res *= count; 
	    } 
	  
	    return res; 
	} 

	/*****************************************************************************
	 * Porpose:to find binomialCofficient of given numbers                                                   *
	 * @param int number,catalan                                                         
	 * @return long binomialCoefficient of given of number                                            
	 *****************************************************************************/
	static long binomialCoeff(int number, 
	                         int catalan) 
	{ 
		long res = 1; 
	  
	    // Since C(n, k) = C(n, n-k) 
	    if (catalan > number - catalan) 
	    	catalan = number - catalan; 
	  
	    // Calculate value of  
	    // [n*(n-1)*---*(n-k+1)] /  
	    // [k*(k-1)*---*1] 
	    for (int count = 0; count < catalan; ++count) 
	    { 
	        res *= (number - count); 
	        res /= (count + 1); 
	    } 
	  
	    return res; 
	} 

	/*****************************************************************************
	 * Porpose:to find calalan of given numbers                                                   *
	 * @param int number                                                         
	 * @return catalan of number                                           
	 * A Binomial coefficient  
	 * based function to find  
	 * nth catalan number in  
	 * O(n) time  
	 *****************************************************************************/
	  
	
	static long catalan( int number) 
	{ 
	      
	    // Calculate value of 2nCn 
	    long catalan = binomialCoeff(2 * number, number); 
	  
	    // return 2nCn/(n+1) 
	    return catalan / (number + 1); 
	} 

	/*****************************************************************************
	 * Porpose:to count number of binary trees                                                   *
	 * @param int number                                                         
	 * @return long count of binary trees                                            
	 * A function to count number of 
	 * BST with n nodes using catalan  
	 *****************************************************************************/
	  
	static long countBST( int number) 
	{ 
	    // find nth catalan number 
	    long count = catalan(number); 
	  
	    // return nth catalan number 
	    return count; 
	} 
	  
	  
	// Driver Code 
	public static void main (String[] args) 
	{ 
	    int tasks=0; 
	    long result=0;
	    System.out.println( "Enter number of task");
	    tasks=Utility.InputInt();
	    System.out.println("Enter the"+tasks+"tasks");
	    // find count of BST and  
	    // binary trees with n nodes
	    int task[]=new int[tasks];
	    for(int count=0;count<tasks;count++)
	    {
	    	task[count]=Utility.InputInt();
	    }
	    
	    for(int count2=0;count2<tasks;count2++)
	    {
	    	result = countBST(task[count2]); 
	    	 System.out.println("Count of BST with "+  
                     task[count2]+" nodes is "+  
                             result); 
	    }
	} 
}
  

