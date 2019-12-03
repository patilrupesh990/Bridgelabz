package com.bridgelabz.logicalprograms;
/**
 * @author Rupeshp007
 * date:18/11/2019
 * Purpos:To develop tic toc based game in that user will paly with computer on 3X3 board. 
 * first user will select the mark for play
 * two marks "X" and "0" 
 **********************************************************************************/
public class TicTacToe 
{
	public static void main(String[] args) 
	{
		
		
		System.out.println("Welcome to TicTacToe its an amazing Game");
		System.out.println("Enter Your Name:");
		String name=com.bridgelabz.util.Utility.InputString();
		Utility util=new Utility();
		util.Initilization();
		util.PrintBord(name);
	}
	
	
	
}
