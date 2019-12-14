package com.bridgelabz.oops.InventaryManagement;
/**
 *this class defined as Customized Exception it will take Message From Methods of other classes and pass this
 *message to super class throwable and throwable class Constructor will print Exception message. 
 * @author Rupesh Patil
 * @version 1.0
 */
@SuppressWarnings("serial")
public class InventoryExcpetion extends Throwable
{
	public InventoryExcpetion(String message) {
		
		super(message);
	}
}
