package com.bridgelabz.designpattern.structural.proxy;

public class ProxyInNetwork implements OfficeInternate
{
	String employeeNAme;
	private RealInternet access;
	int rank;
	public ProxyInNetwork(String employeeName,int rank) {
		this.employeeNAme=employeeName;
		this.rank=rank;
	}
	
	public int getRank(String name)
	{
		return rank;
	}

	@Override
	public void grantAccess() {
		if(getRank(employeeNAme)>5)
		{
			access=new RealInternet(employeeNAme);
			access.grantAccess();
		}
		else
		{
			System.out.println("Sorry You Wont be access Internate on this level");
		}
	}
}
