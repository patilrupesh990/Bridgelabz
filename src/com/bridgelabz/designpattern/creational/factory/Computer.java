package com.bridgelabz.designpattern.creational.factory;

/***********************************************************************************************************
 * @author Rupeshp007
 * date:20/12/2019
 * @version 1.0
 * Purpose:Compuer Abstract class it contains common specification methods for PC and Server classes
 **********************************************************************************************************/

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
