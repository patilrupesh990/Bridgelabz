package com.bridgelabz.designpattern.creationaldesignpattern.singletone;
/***********************************************************************************************************
 * @author Rupeshp007
 * date:20/12/2019
 * @version 1.0
 * Purpose:To create Singleton static design pattern it contains private object and constructor objcet will be accessed 
 * 			by public method getInstance.
 *
 **********************************************************************************************************/

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
