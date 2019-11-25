package com.bridgelabz.logicalprograms;


import com.bridgelabz.util.LogicalProgram;
import com.bridgelabz.util.Utility;;
/*
* Author: RupeshPatil
* Date: 13/11/2019
* Purpose:Gambler Simulates a gambler who start with $stake and place fair $1 bets 
* until he/she goes broke (i.e. has no money) or reach $goal. 
**/

public class Gambler extends Utility
{
	
	static Utility util=new Utility();
	
	public static void main(String[] args) 
	{
	
		System.out.println("Welcome to Gambler Play and check your luck");
		System.out.println("Each winning you will double your stack");
		System.out.println("if you lost you will lose your half stack amount");
		System.out.println("Lets start the Game");
		
			LogicalProgram.Initilazation();
			LogicalProgram.Rotate();
			LogicalProgram.RepeatationAfterFirst();
		
		
	}//end main
	
	
	
	
	
	
	
}
