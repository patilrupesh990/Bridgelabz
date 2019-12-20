package com.bridgelabz.designpattern.creationaldesignpattern.singletone;
/***********************************************************************************************************
 * @author Rupeshp007
 * date:20/12/2019
 * @version 1.0
 * Purpose:To create Lazy design pattern it contains private object and constructor object will be accessed 
 * 			by public method getInstance and its only create object when we accessed get instance method .
 *
 **********************************************************************************************************/

public class Library 
{
	private static Library library;
	
	/**Private Constructor of Library Class to restrict object creation */
	private Library() {
		System.out.println("Library accessed");
	}
	
	/**Public static method to access object of library class **/
	public static Library getInstance()
	{
		if(library==null)
		{
			library=new Library();
		}
		return library;
	}
}
