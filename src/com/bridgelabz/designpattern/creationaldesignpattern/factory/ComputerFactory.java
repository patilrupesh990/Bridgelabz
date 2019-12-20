package com.bridgelabz.designpattern.creationaldesignpattern.factory;

public class ComputerFactory 
{
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
