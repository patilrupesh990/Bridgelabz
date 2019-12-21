package com.bridgelabz.designpattern.structural.adapter;

public class SocketObjectAdapter implements Adapter
{
	Socket socket=new Socket();
	@Override
	public Volt get120() {
		return socket.getVolt();
	}
	
	@Override
	public Volt get12() {
		return socket.getVolt();
	}
	
	@Override
	public Volt get3() {
		return socket.getVolt();
	}
	
	public Volt convertVolts(Volt volt,int volts)
	{
		return new Volt(volt.getVolts()/volts);
	}
	
}
