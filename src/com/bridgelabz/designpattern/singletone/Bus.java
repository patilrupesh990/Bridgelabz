package com.bridgelabz.designpattern.singletone;

public class Bus {
	private static Bus bus;
	static
	{
		try{
			bus=new Bus();
		}
		catch (Exception e) {
		}
	}
	
	private Bus()
	{
		System.out.println("Accessed Bus");
	}
	public static Bus getInstance()
	{
		return bus;
	}

}
