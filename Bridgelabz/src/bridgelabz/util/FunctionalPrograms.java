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
		size=util.InputInt();
		array=new int[size];
		
		/**Purpose: input elements in Array**/
		for(int j=0;j<size;j++)
		{
			array[j]=util.InputInt();
		}
		
		/**Purpose: to print triplets of sum 0 and total count of distincts triplets**/
		for(int i=0;i<size;i++)
		{
			for(int j=i+1;j<size;j++)
			{
				for(int k=j+1;k<size;k++)
				{
					if(array[i]+array[j]+array[k]==0)
					{
						System.out.println(array[i]+","+array[j]+","+array[k]);
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
	public void Euclidean_distance(int x1,int y1)
	{
		double result=Math.sqrt((Math.pow(x1,2))+Math.pow(y1, 2));
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
	public void Find_Quadratic(double a,double b,double c)
	{
		double delta=b*b-4*a*c;
		double x1=(-b+Math.sqrt(delta))/(2*a);
		double x2=(-b-Math.sqrt(delta))/(2*a);
		
		System.out.println(x1);
		System.out.println(x2);
	}// end Quadratic 

	
	/**
	 * purpose:For Calculate WindChill Based On temperature and wind speed
	 * @param two double command-line arguments t and v 
	 * @return void
	 * 
	**/
	public void Compute_Wind_Chill(double t,double v)
	{
		double w=35.74+0.6215+(0.4275*t-35.75)*Math.pow(v, 0.16);
		System.out.println("Temprature is: "+t+" °F");
		System.out.println("Wind Speed is: "+v+"Mile/hour");
		System.out.println("Wind-Chill: "+w+" Mile/hour");
	} //end wind child
	
}
