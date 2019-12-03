package com.bridgelabz.algorithmprograms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;
import com.bridgelabz.util.Utility;
/*************************************************************************************
 * purpose: To covert UserDetails in message Formate takes details from user and put into messageFormate
 * @author Rupeshp007
 * date:18/11/2019
 * @version 1.0
*****************************************************************************************/

public class Regex
{
	public static void main(String args[])
	{

		UserDetails user=new UserDetails();
		System.out.println();
	
		//asking user to enter his data
		System.out.println("Enter FirstName:");
		user.setfName(Utility.InputString());
		System.out.println();
	
		System.out.println("Enter LastName:");
		user.setlName(Utility.InputString());
		System.out.println();
	
		System.out.println("Enter Mobile Number:");
		user.setmobileNo(Utility.InputString());
		System.out.println();	
		String filename="G:\\Bridgelabz\\Bridgelabz\\src\\com\\bridgelabz\\AlgorithmPrograms\\UserDetails.txt";
		//Setting current date
		user.setdate(Utility.getFormatedDate(new Date()));
		Utility util=new Utility();

		System.out.println(util.convertString(user,Regex.ReadFile(filename)));	
	}
	 /****************************************************************************** 
		* Date: 22/11/2019
		* Purpose: To Read Contents From File and returns as String Object.
	    * @param String filename
		* @return String
		******************************************************************************/
	@SuppressWarnings("resource")
	public static String ReadFile(String fileName){
			BufferedReader br = null;
			try{
				
				br=new BufferedReader(new FileReader(fileName));
				StringBuilder sb=new StringBuilder();
				String line=br.readLine();
				while(line!=null){
					sb.append(line);
					sb.append(System.lineSeparator());
					line=br.readLine();
				}
				return sb.toString();
			 }
			catch(Exception e){
				return null;
			}
			
		}
}