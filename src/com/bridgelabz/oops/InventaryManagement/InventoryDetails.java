package com.bridgelabz.oops.InventaryManagement;
/**
 * @author Rupeshp007
 * date:6/12/2019
 * @version 1.0
 * Purpose:To set value of Inventory price,weight and name and we can also get values. 
 * Variables price,weight,name
 **********************************************************************************************************/

public class InventoryDetails 
{
	private double inventoryprice;
	private double inventoryweight;
	private String inventoryName;
	
	/**To Get value of price **/
	
	public double getInventoryprice() {
		return inventoryprice;
	}
	
	/**To set value of price **/

	
	public void setInventoryprice(double inventoryprice) {
		this.inventoryprice = inventoryprice;
	}
	
	/**To Get value of price **/

	public double getInventoryweight() {
		return inventoryweight;
	}
	public void setInventoryweight(double inventoryweight) {
		this.inventoryweight = inventoryweight;
	}
	
	/**To set value of price **/

	public String getInventoryName() {
		return inventoryName;
	}
	
	/**To set value of price **/

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}
	
	
}
