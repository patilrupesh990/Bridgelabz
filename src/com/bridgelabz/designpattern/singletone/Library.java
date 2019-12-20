package com.bridgelabz.designpattern.singletone;

public class Library 
{
	private static Library library;
	
	private Library() {
		System.out.println("Library accessed");
	}
	
	public static Library getInstance()
	{
		if(library==null)
		{
			library=new Library();
		}
		return library;
	}
}
