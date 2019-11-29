package com.bridgelabz.junit;

public class MonthlyPayment 
{
	public static void main(String[] args) 
	{
		double p=0,r=0;
		int y=0;
		p=Double.parseDouble(args[0]);
		y=Integer.parseInt(args[1]);
		r=Double.parseDouble(args[2]);
		payment(p, r, y);
		
	}
	
	public static double payment(double p,double r,int y)
	{
		double emi=(p*r)/1-(Math.pow(1+r, -12));
		System.out.println(emi);
		return emi;
		
	}
	
	
}
