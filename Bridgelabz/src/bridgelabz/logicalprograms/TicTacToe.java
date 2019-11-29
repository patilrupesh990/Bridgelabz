package com.bridgelabz.logicalprograms;

public class TicTacToe 
{
	public static void main(String[] args) 
	{
		Utility util=new Utility();
		com.bridgelabz.util.Utility scan=new com.bridgelabz.util.Utility();
		System.out.println("Welcome to TicTacToe its an amazing Game");
		System.out.println("Enter Your Name:");
		String name=scan.InputString();
		util.Initilization();
		util.PrintBord(name);
		
	}
	
	
	
}
