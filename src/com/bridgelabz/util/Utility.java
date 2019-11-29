 package com.bridgelabz.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/***************************************************************************************
* Created by:Rupesh Patil
* Date: 16/11/2019
* Purpose: Putting Commonly used function in single file.
*	1 function to take word,integer and double as input
*	2: function to read and write file.
*	3 function to match regex from string and replace with user details	 
*******************************************************************************************/

public class Utility 
{
	//util class initilization
	public static Scanner scanner=new Scanner(System.in);
	static Utility util=new Utility();
	
	
	/**Redymade input methods using Scanner class**/
	
	/*************************** 
	 * for take Integer input  *
	 * @param no param         *
	 * @return integer         *
	 **************************/
	
	public int InputInt()
	{
		int int_variable=scanner.nextInt();
		return int_variable;
	}
	/** for take Float input
	 * @param no param
	 * @return float
	 ***/
	
	
	
	public float InputFloat()
	{
		float float_varialble=scanner.nextFloat();
		
		return float_varialble;
	}
	
	/** for take Character input
	 * @param no param
	 * @return character
	 * **/
	
	public char InputChar()
	{
		char char_variable=scanner.next().charAt(0); 
		return char_variable;
	}
	
	/** for take String input from scanner
	 * @param no param
	 * @return String
	 * **/
	public String InputString()
	{
		String string_variable=scanner.next(); 
		return string_variable;
	}
	
	/** for take Double input
	 * @param no param
	 * @return double
	 * **/
	public double InputDouble()
	{
		double double_variable=scanner.nextDouble();
		
		return double_variable;
	}
	
	/** for take Boolean input
	 * @param no param
	 * @return boolean
	 * **/
	public boolean InputBoolean()
	{
		boolean boolean_variable=scanner.nextBoolean();
		return boolean_variable;
	}
//end of input methods
	
	
	public <T>ArrayList<T> ReadFile(String FileName) 
	{
		File file;
		file=new File(FileName);
		FileReader filereader=null;
		BufferedReader b_reader;
		String line="";
		ArrayList<T> al=new ArrayList<T>();
		
			try 
			{
				filereader = new FileReader(file);
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			b_reader=new BufferedReader(filereader);
			String temp="";
		
			
		try
		{
			while((temp=b_reader.readLine())!=null)
			{
				line+=temp;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String s[]=line.split(",");
		for(int i=0;i<s.length;i++)
		{
			al.add((T) s[i]);
		}
		try {
			b_reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (ArrayList<T>) al;
	}
	
	
	public static <T>void WriteinFile(T string,String filename)
	{
		try { 
			  
            // Open given file in append mode. 
            BufferedWriter out = new BufferedWriter( 
                   new FileWriter(filename, true)); 
            out.write(","+String.valueOf(string)); 
            out.close(); 
        }catch (IOException e) {
			// TODO: handle exception
		} 
	}
	
	/**To convert Temperature from Celsius to Feranhit
	 * @param double temperature in celsius
	 * @return double
	 ************************************************************/
	public static double temperaturConversionToFerenhit(double input)
	{
		double ferenhit=(input*(9/5))+32;
		
		return ferenhit;
	}
	/**To convert Temperature from Feranhit to celsius
	 * @param double temperature in Feranhit
	 * @return double
	 ************************************************************/
	public static double temperaturConversionToCelcius(double input)
	{
		double celcius=(input-31)*5/9;
		
		return celcius;
	}
	
	public static int[] toBinary(int decimal){    
	     int binary[] = new int[40];    
	     int index = 0;    
	     while(decimal > 0){    
	       binary[index++] = decimal%2;    
	       decimal = decimal/2;    
	     }    
	     for(int count = index-1;count >= 0;count--){    
	      // System.out.print(binary[i]);    
	     }    
	System.out.println();//new line  
	int binarynew []=new int[index];
	
	for(int count=0;count<binarynew.length;count++)
		binarynew[count]=binary[count];
	
	
	return binarynew;
	}    
	
}
