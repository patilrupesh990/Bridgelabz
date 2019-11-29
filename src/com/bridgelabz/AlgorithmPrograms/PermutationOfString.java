package com.bridgelabz.AlgorithmPrograms;

/*****************************************************************************************
* @Author: RupeshPatil
* @since: 18/11/2019
* @version :1.0
* @Purpose:permutations of a String using iterative method and Recursion method
******************************************************************************************/

public class PermutationOfString 
{

			public static void main(String[] args) 
			{ 
			    String string = "ABC"; 
			    
			    int length = string.length(); 
			    
			    PermutationOfString permutation = new PermutationOfString(); 
			    permutation.permute(string, 0, length - 1); 
			} 
			
			/** 
			 * permutation function 
			 * @param str string to calculate permutation for 
			 * @param start starting index 
			 * @param last end index
			 * @return void 
			 */
			private void permute(String string, int start, int last) 
			{ 
			    if (start == last) 
			        System.out.println(string); 
			    else { 
			        for (int index = start; index <= last; index++) { 
			            
			        	string = swap(string, start, index); 
			            
			        	permute(string, start + 1, last); 
			            
			        	string = swap(string, start, index); 
			        } 
			    } 
			} 
			
			/** 
			 * Swap Characters at position 
			 * @param a string value 
			 * @param i position 1 
			 * @param j position 2 
			 * @return swapped string 
			 */
			public String swap(String string, int pos1, int pos2) 
			{ 
			    char temp; 
			    char[] charArray = string.toCharArray(); 
			    temp = charArray[pos1]; 
			    charArray[pos1] = charArray[pos2]; 
			    charArray[pos2] = temp; 
			    return String.valueOf(charArray); 
			} 
} 
