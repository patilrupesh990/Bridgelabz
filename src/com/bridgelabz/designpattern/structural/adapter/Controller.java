package com.bridgelabz.designpattern.structural.adapter;

public class Controller 
{
	

		public static void main(String[] args) {
			
			testClassAdapter();
			testObjectAdapter();
		}

		private static void testObjectAdapter() {
			Adapter sockAdapter = new SocketObjectAdapter();
			Volt v3 = getVolt(sockAdapter,3);
			Volt v12 = getVolt(sockAdapter,12);
			Volt v120 = getVolt(sockAdapter,120);
			System.out.println("v3 volts using Object Adapter="+v3.getVolts());
			System.out.println("v12 volts using Object Adapter="+v12.getVolts());
			System.out.println("v120 volts using Object Adapter="+v120.getVolts());
		}

		private static void testClassAdapter() {
		Adapter sockAdapter = new SocketAdapterImpl();
			Volt v3 = getVolt(sockAdapter,3);
			Volt v12 = getVolt(sockAdapter,12);
			Volt v120 = getVolt(sockAdapter,120);
			System.out.println("v3 volts using Class Adapter="+v3.getVolts());
			System.out.println("v12 volts using Class Adapter="+v12.getVolts());
			System.out.println("v120 volts using Class Adapter="+v120.getVolts());
		}
		
		private static Volt getVolt(Adapter sockAdapter, int i) {
			switch (i){
			case 3: return sockAdapter.get3();
			case 12: return sockAdapter.get12();
			case 120: return sockAdapter.get120();
			default: return sockAdapter.get120();
			}
		}
	}

