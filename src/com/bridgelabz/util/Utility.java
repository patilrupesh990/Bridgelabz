 package com.bridgelabz.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bridgelabz.AlgorithmPrograms.UserDetails;
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
	
	public static int InputInt()
	{
		int int_variable=scanner.nextInt();
		return int_variable;
	}
	/************************ 
	 * for take Float input
	 * @param no param
	 * @return float
	 ***************************/
	public static float InputFloat()
	{
		float float_varialble=scanner.nextFloat();
		
		return float_varialble;
	}
	
	/********************************
	 *  for take Character input
	 * @param no param
	 * @return character
	 *******************************/
	
	public static char InputChar()
	{
		char char_variable=scanner.next().charAt(0); 
		return char_variable;
	}
	
	/**************************************
	 *  for take String input from scanner
	 * @param no param
	 * @return String
	 ***************************************/
	public static String InputString()
	{
		String string_variable=scanner.next(); 
		return string_variable;
	}
	
	/***********************************
	 *  for take Double input
	 * @param no param
	 * @return double
	 ***********************************/
	public static double InputDouble()
	{
		double double_variable=scanner.nextDouble();
		
		return double_variable;
	}
	
	/********************************* 
	 * for take Boolean input
	 * @param no param
	 * @return boolean
	 ********************************/
	public static boolean InputBoolean()
	{
		boolean boolean_variable=scanner.nextBoolean();
		return boolean_variable;
	}
//end of input methods
	
	
	BufferedReader br;
	private final String REGEX_NAME = "<<name>>";
	private final String REGEX_FULLNAME = "<<full name>> ";
	private final String REGEX_MOBILE_NO = "xxxxxxxxxx";
	private final String REGEX_DATE = "12/06/2016";
	
	//constructor to initialize bufferedReader
	public Utility(){
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	/*************************************************************** 
	 * it will Give String in Pattern using java RegulerExpression.
	 * @param String message,UserDetails userDetails(class object)
	 * @return String 
	 ******************************************************************/
	public String convertString(UserDetails userDetails,String message){
		
		Pattern p = Pattern.compile(REGEX_NAME);
		Matcher m = p.matcher(message); 
		message = m.replaceAll(userDetails.getfName());

		p = Pattern.compile(REGEX_FULLNAME);
		m = p.matcher(message); 
		message = m.replaceAll(userDetails.getfName()+" "+userDetails.getlName());

		p = Pattern.compile(REGEX_MOBILE_NO);
		m = p.matcher(message); 
		message = m.replaceAll(userDetails.mobileNo());

		p = Pattern.compile(REGEX_DATE);
		m = p.matcher(message); 
		message = m.replaceAll(userDetails.date());

		return message;
	}
	
	/*************************************************** 
	 * it will format the Date as Date/Month/Year.
	 * @param Date date
	 * @return String 
	 *************************************************/
	public static String getFormatedDate(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
		return sdf.format(date);
	}
	
	/*********************************************************************************** 
	 * for Read the contents from the text file and store in ArrayList and returns list.
	 * @param String filename
	 * @return ArrayList<T> list of words/numbers 
	 *********************************************************************************/
	@SuppressWarnings("unchecked")
	public static <T>ArrayList<T> ReadFile(String FileName) 
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
	
	public static boolean isLeapYear(int year)
	{
		if(year%4==0&&year%100!=0||year%400==0)
		{
			if(year>0)
			return true;
		}
		else
		{
			if(year>0)
			return false;
			else
				return false;
		}
		return false;
		
	}
	
	/** for Read the contents from the text file and store in ArrayList and returns list.
	 * @param double c NoneNegative
	 * @return ArrayList<T> list of words/numbers 
	 * **/
	
	public static double SqurerootNewtonMethod(double c)
	{
		
		double epsilon = 1e-15;   
        double t = c;             

       
        while (Math.abs(t - c/t) > epsilon*t) {
            t = (c/t + t) / 2.0;
        }
        
        
        return t;
	}
	
	
	/** To Display Calender in 2D array formate as per day and dates.
	 * @param int day,int[] days,int month
	 * @return void 
	 * **/	
	public static void DisplayCalender(int day,int days[],int month)
	{
		for (int i = 0; i < day; i++)
	        System.out.print("\t");
	    for (int i = 1; i <= days[month-1]; i++) {
	        System.out.print(i+"\t");
	        if (((i + day) % 7 == 0) || (i == days[month-1])) 
	        	System.out.println();
	    }
    }

	/** To Check whether two numbers are anagram or not.
	 * @param int number1,int number2
	 * @return boolean
	 * **/		
	public static boolean isAnagram(int number1, int number2) {
		int len1 = countDigits(number1);
		int len2 = countDigits(number2);
		if (len1 != len2) {
			return false;
		}
		int index1 = 0;
		int index2 = 0;
		int[] num1 = new int[len1];
		int[] num2 = new int[len2];
		while (number1 != 0) {
			int rem = number1 % 10;
			num1[index1] = rem;
			number1 = number1 / 10;
			index1++;
		}
		while (number2 != 0) {
			int rem = number2 % 10;
			num2[index2] = rem;
			number2 = number2 / 10;
			index2++;
		}
		Arrays.sort(num1);
		Arrays.sort(num2);

		if (Arrays.equals(num1, num2))
			return true;
		else
			return false;
	}
	
	/** To count the digits in a numbers.
	 * @param int number
	 * @return int 
	 * **/	
	
	public static int countDigits(int num) {
		int count = 0;
		while (num != 0) {
			num = num / 10;
			++count;
		}
		return count;
	}
	/** To Write contents in file .
	 * @param T String,String fileName
	 * @return void 
	 * **/	
	public static <T>void WriteinFile(T string,String filename)
	{
		try { 
			  
            // Open given file in append mode. 
            BufferedWriter out = new BufferedWriter( 
                   new FileWriter(filename, true)); 
            out.write(","+String.valueOf(string)); 
            out.close(); 
        }catch (IOException e) {
			
		} 
	}
	
	/** To Delete line from text file.
	 * @param String filename,T word
	 * @return void 
	 ***/	
	public static <T>void DeleteFromeFile(String filename,T word)
	{
		File inputFile = new File(filename);
        File outputFile = new File(filename);
         Scanner sc = null;
        FileWriter fw = null;

        try {       
            sc = new Scanner(inputFile);
            fw = new FileWriter(outputFile);

            while(sc.hasNextLine()) {
                String str = sc.nextLine();                 
                str = str.replaceAll("\\s,"+word+"\\s", "");                 
                fw.write(str + "\r\n");
            }

            sc.close();
            fw.close();

        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
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
	/********************************************
	 *  To convert number from decim to binary.
	 * @param int decimal
	 * @return int[] 
	 *********************************************/	
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
	/** To Check whether the String is palindrom or not.
	 * e.g madam is palindrom
	 * @param int day,int[] days,int month
	 * @return void 
	 * **/	
	public static String isStringPalindrom(String string)
	{
	//adding each character to the rear of the deque
		Dequeueimpl<Character> dequeu=new Dequeueimpl<Character>();
			for(int i=0;i<string.length();i++)
			{
				char c =string.charAt(i);
				dequeu.addRear(c);
			}
			int flag=0;

			while(dequeu.size()>1)
			{
				if(dequeu.removeFront()!=dequeu.removeRear())
				{
					flag=1;
					break;
				}
			}

			if(flag==0)
			{
				return "String is palindrome";
			}
			else
			{
				return "String is not palindrome";
			}
	
	}
}
	
