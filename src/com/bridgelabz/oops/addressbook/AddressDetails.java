package com.bridgelabz.oops.addressbook;

/***********************************************************************************
 *  Bean class for AddressDetails of StockManagement it contains private variable and 
 *  setter and getter methods for all variables.
 * 
 *  @param no parameter
 *  @return void
 *******************************************************************************/	

public class AddressDetails 
{
	private String city;
	private String state;
	private int pinCode;
	private String street;
	
	/**Get street String variable**/
	
	public String getstreet() {
		return street;
	}
	
	/**Set street String address**/

	public void setstreet(String address) {
		this.street = address;
	}
	
	/**get city **/
	public String getCity() {
		return city;
	}
	
	/**set city **/
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	
	/**set State **/
	public void setState(String state) {
		this.state = state;
	}
	
	/**get pinCode **/
	public int getPinCode() {
		return pinCode;
	}
	
	/**set pincode **/
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
}
