package com.bridgelabz.oops.addressbook;

public class AddressDetails 
{
	private String city;
	private String state;
	private int pinCode;
	private String street;
	
	public String getstreet() {
		return street;
	}
	public void setstreet(String address) {
		this.street = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
}
