package com.bridgelabz.functionalprograms;
import com.bridgelabz.util.FunctionalPrograms;
/**
* Author: RupeshPatil
* Date: 16/11/2019
* Purpose:prints the Euclidean distance from the point (x, y) to the origin (0, 0).Takes two integer command-line arguments x and y and . 
* The formule to calculate distance = sqrt(x*x + y*y). Used Math.power function
* @version 1.0
*******************************************************************************************************************************************/


public class Distance 
{
	public static void main(String[] args) 
	{
		FunctionalPrograms distance=new FunctionalPrograms();
		int point_x=Integer.parseInt(args[0]);
		int point_y=Integer.parseInt(args[1]);
		distance.Euclidean_distance(point_x,point_y);
	}
}
