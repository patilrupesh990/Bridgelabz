package com.bridgelabz.oops.addressbook;

public class PersonDetails 
{
	/***********************************************************************************
	 *  Bean class for Person of StockManagement it contains private variable and 
	 *  setter and getter methods for all variables.
	 * 
	 *  @param no parameter
	 *  @return void
	 *******************************************************************************/	
	private String firstName;
	private String lastName;
	private Object address;
	
	private long phoneNo;
	
	
	/**Get FirstName String variable**/
	public String getFirstName() {
		return firstName;
	}
	
	/**set FirstName String variable**/
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**Get LastName String variable**/
	public String getLastName() {
		return lastName;
	}
	
	/**Set LastName String variable**/
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**Get GetPhone Long variable**/
	public long getPhoneNo() {
		return phoneNo;
	}
	
	/**Set PhoneNumber String variable**/
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	/**Get Address Object**/
	public Object getAddress() {
		return address;
	}
	
	/**Set Address Object**/
	public void setAddress(Object address) {
		this.address = address;
	}
	
	
	
}
