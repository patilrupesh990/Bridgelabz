package com.bridgelabz.designpattern.creational.factory;

/***********************************************************************************************************
 * @author Rupeshp007
 * date:20/12/2019
 * @version 1.0
 * Purpose:Factory class For Factory Design Pattern Program
 **********************************************************************************************************/

public class ComputerFactory 
{
	/**
	 * static method to return instance of PC and Server classes 
	 * @param String type,ram,cpu,hdd,graphics
	 * @return Computer Interface reference object
	 * */
	public static Computer getInstance(String type,String ram,String cpu,String hdd,String graphics)
	{
		if("PC".equalsIgnoreCase(type))
			return new PC(ram, cpu, hdd, graphics);
		else if("Server".equalsIgnoreCase(type))
			return new Server(ram, cpu, hdd, graphics);
		else
			return null;
	}
}
