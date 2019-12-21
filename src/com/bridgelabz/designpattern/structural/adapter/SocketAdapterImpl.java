package com.bridgelabz.designpattern.structural.adapter;

public class SocketAdapterImpl extends Socket implements Adapter
{

	public Volt get120() {
		return getVolt();
	}

	public Volt get12() {
		
		Volt v=getVolt();
		return convertVolt(v, 10);
	}

	public Volt get3() {
		Volt v=getVolt();
		return convertVolt(v, 40);
	}
	
	public Volt convertVolt(Volt volt,int volts)
	{
		return new Volt(volt.getVolts()/volts);
	}
	

}
