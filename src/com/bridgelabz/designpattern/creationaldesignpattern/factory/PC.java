package com.bridgelabz.designpattern.creationaldesignpattern.factory;

public class PC extends Computer
{
	private String ram;
	private String cpu;
	private String hdd;
	private String graphics;
	
	public PC(String ram, String cpu, String hdd, String graphics) {
		super();
		this.ram = ram;
		this.cpu = cpu;
		this.hdd = hdd;
		this.graphics = graphics;
	}
	
	
	@Override
	public String getRAM() {
		return this.ram;
	}
	@Override
	public String getHDD() {
		return this.hdd;
	}
	@Override
	public String getCPU() {
		return this.cpu;
	}
	@Override
	public String getGraphics() {
		return this.graphics;
	}
	
	
}
