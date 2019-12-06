package com.bridgelabz.datastructureprograms;

import com.bridgelabz.util.Utility;

public class NumberOfBinaryTree 
{
	 //factorial() will calculate the factorial of given number  
    public static int factorial(int num) {  
        int fact = 1;  
        if(num == 0)  
            return 1;  
        else {  
            while(num > 1) {  
                fact = fact * num;  
                num--;  
            }  
            return fact;  
        }  
    }  
      
    //numOfBST() will calculate the total number of possible BST by calculating Catalan Number for given key  
    public static int numOfBST(int key) {  
    	int catalanNumber=0;
    	try{
        catalanNumber = factorial(2 * key)/(factorial(key + 1) * factorial(key));  
    	}catch (Exception e) {
		}
        return catalanNumber; 

    	
    }  
	  public static void display(int results[])
	  {
		  System.out.println("Number of tree respectively");
		  for(int index:results)
		  {
			  System.out.println(index);
		  }
	  }

	  public static void main(String[] args) {  
          
		  System.out.println("Enter How many Task");
		  int noOfTask=Utility.InputInt();
		  System.out.println("Enter "+noOfTask+" Tasks");
		  int tasks[]=new int[noOfTask];

		  for(int index=0;index<noOfTask;index++)
          {
        	tasks[index]=Utility.InputInt();  
          }
		 
		  int results[]=new int[noOfTask];
          for(int index2=0;index2<noOfTask;index2++)
        	  results[index2]=numOfBST(tasks[index2]);
          
          display(results);
      }  
	  
}  

