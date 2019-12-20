package com.bridgelabz.designpattern.creationaldesignpattern.factory;

abstract public class Computer 
{
	public abstract String getRAM();
	public abstract String getHDD();
	public abstract String getCPU();
	public abstract String getGraphics();
	
	@Override
	public String toString() {
		return "Computer [RAM()=" + getRAM() + ", HDD()=" + getHDD() + ", CPU()=" + getCPU()
				+ ", Graphics()=" + getGraphics() + "]";
	}
}
