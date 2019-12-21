package com.bridgelabz.designpattern.creational.singletone;
/**
 * Eager intilization it contains private static object and private Constructor .
 * and returns Object throgh static method.
 * 
 * 
 * -Example of Singleton Eager initialization Design pattern
 **********************************************************************************/
public class Charger 
{
	private static final Charger charger=new Charger();
	
	private Charger()
	{
		System.out.println("Charger Access");
	}
	
	public static Charger getInstance()
	{
		return charger;
	}
}
