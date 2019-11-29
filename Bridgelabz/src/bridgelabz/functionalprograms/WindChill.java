package com.bridgelabz.functionalprograms;

import com.bridgelabz.util.FunctionalPrograms;

/**
* Author: RupeshPatil
* Date: 15/11/2019
Purpose: Program for Calculate WindChild
@param String args
 two double command-line arguments t
and v 
and prints the wind chill. Use Math.pow(a, b) to compute ab. Given the
temperature t (in Fahrenheit) and the wind speed v (in miles per hour), the
National Weather Service defines the effective temperature (the wind chill) to be:
**/

public class WindChill 
{
	public static void main(String[] args) 
	{
		double temprature=Double.parseDouble(args[0]);
		double speed=Double.parseDouble(args[1]);
		FunctionalPrograms windchil=new FunctionalPrograms();
		windchil.Compute_Wind_Chill(temprature,speed);
	}
}
