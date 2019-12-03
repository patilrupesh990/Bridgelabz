package com.bridgelabz.dataStructure_programs;

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
		int k = 0, l = 100;
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println("Colums:prime numbers Rows:limits 0-100,100-200,200-300 so on");
		for (int i = 0; i < 10; i++) {
			System.out.print(k + "-" + l + ":==>  ");
			for (int j = 0; j < 25; j++) {
				if (result[i][j] > 0) {
					System.out.print(result[i][j] + " ");
				}
			}
			System.out.println();
			k = k + 100;
			l = l + 100;
		}
		int anagrams[] = DataStructure.primeAnagrams3(primes);
		DataStructure.AddAnagramLinkedList(anagrams);

	}

}
