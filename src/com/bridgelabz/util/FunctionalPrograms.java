package com.bridgelabz.util;
import com.bridgelabz.util.Utility;;
public class FunctionalPrograms 
{
	Utility util=new Utility();
	/** 
	* Date: 15/11/2019
	*Purpose: Read Array elements from user and
	*find the triplets of sum zero and print triplets and total count 
	*@param no param
	*@return void
	**/
	public void Cube_Sum()
	{
		
		int array[];
		int size=0;
		int count=0;
		
		System.out.println("How many Elements want to insert");
		size=Utility.InputInt();
		array=new int[size];
		
		/**Purpose: input elements in Array**/
		for(int index=0;index<size;index++)
		{
			array[index]=Utility.InputInt();
		}
		
		/**Purpose: to print triplets of sum 0 and total count of distincts triplets**/
		for(int index=0;index<size;index++)
		{
			for(int index2=index+1;index2<size;index2++)
			{
				for(int index3=index2+1;index3<size;index3++)
				{
					if(array[index]+array[index2]+array[index3]==0)
					{
						System.out.println(array[index]+","+array[index2]+","+array[index3]);
						count++;
					}
				}
			}
		}
		System.out.println("number of triplets of sum 0 is:"+count);
	}// end of Cube_Sum
	
	/** To find the Euclidean Distance of point X and Y
	 * @param int x1, int y1
	 * @return void
	 *  **/
	public void Euclidean_distance(int point_x,int point_y)
	{
		double result=Math.sqrt((Math.pow(point_x,2))+Math.pow(point_y, 2));
		System.out.println("Euclidean Distance="+result);
	}
	//end of Euclidean_distance
	
	/** To find the Quadratic equation and find the values of x
	 * @param double a  b c 
	 *  delta = b*b - 4*a*c
		Root 1 of x = (-b + sqrt(delta))/(2*a)
		Root 2 of x = (-b - sqrt(delta))/(2*a)
	 *@return void
	**/
	public void Find_Quadratic(double a_value,double b_value,double c_value)
	{
		double delta=b_value * b_value-4 * a_value * c_value;
		double result1=(-b_value + Math.sqrt(delta))/(2 * a_value);
		double result2=(-b_value - Math.sqrt(delta))/(2 * a_value);
		
		System.out.println(result1);
		System.out.println(result2);
	}// end Quadratic 

	
	/**
	 * purpose:For Calculate WindChill Based On temperature and wind speed
	 * @param two double command-line arguments t and v 
	 * @return void
	 * 
	**/
	public void Compute_Wind_Chill(double temperature,double speed)
	{
		double wind_chill=35.74+0.6215+(0.4275 * temperature-35.75)*Math.pow(speed, 0.16);
		System.out.println("Temprature is: "+temperature+" �F");
		System.out.println("Wind Speed is: "+speed+"Mile/hour");
		System.out.println("Wind-Chill: "+wind_chill+" Mile/hour");
	} //end wind child
	
}
