package com.bridgelabz.designpattern.structural.proxy;

public class RealInternet implements OfficeInternate
{
	String employeeName;
	public RealInternet(String employeeName)
	{
		this.employeeName=employeeName;
	}

	@Override
	public void grantAccess() {
		System.out.println("You are eligible to access internate Wellcome "+employeeName);;
	}
}
