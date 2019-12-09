package com.bridgelabz.datastructureprograms;

import com.bridgelabz.util.DataStructure;

/*************************************************************************************
 * purpose: Take a range of 0 - 1000 Numbers and find the Prime numbers in that
 * range. Store the prime numbers i n a 2D Array, the first dimension represents
 * the range 0-100, 100-200, and so on. While the second dimension represents
 * the prime numbers i n that range.
 * 
 * @author Rupeshp007 date:26/11/2019
 * @version 1.0
 *****************************************************************************************/

public class PrimeNoRange 
{
	
	static int max = 1000, min = 0;

	public static void main(String[] args) {

		int primes[] = DataStructure.PrimesInRange(min, max);
		int result[][] = DataStructure.primesinlimit(primes);
		int minimum = 0, maximum = 100;
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println("Colums:prime numbers Rows:limits 0-100,100-200,200-300 so on");
		
		for (int index1 = 0; index1 < 10; index1++) {
			System.out.print(minimum + "-" + maximum + ":==>  ");
			for (int index2 = 0; index2 < 25; index2++) {
				if (result[index1][index2] > 0) {
					System.out.print(result[index1][index2] + " ");
				}
			}
			System.out.println();
			minimum = minimum + 100;
			maximum = maximum + 100;
		}
		int anagrams[] = DataStructure.primeAnagrams3(primes);
		DataStructure.AddAnagramLinkedList(anagrams);

	}

}
