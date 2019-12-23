package com.bridgelabz.designpattern.structural.proxy;

import com.bridgelabz.util.Utility;

public class Controller 
{
	static OfficeInternate access;
	public static void main(String[] args) 
	{
		System.out.println("Enter EmployeeName");
		String name=Utility.InputString();
		System.out.println("Enter Rank of Employee");
		int rank=Utility.InputInt();
		access=new ProxyInNetwork(name,rank);
		access.grantAccess();
	}
}
