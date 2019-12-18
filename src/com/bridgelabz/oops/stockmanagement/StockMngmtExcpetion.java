package com.bridgelabz.oops.stockmanagement;
/***********************************************************************************************************
 * @author Rupeshp007
 * date:17/12/2019
 * @version 1.0
 * Purpose:Its a costomized Exception class for StockManagement project
 * 
 **********************************************************************************************************/

@SuppressWarnings("serial")
public class StockMngmtExcpetion extends Throwable
{
	public StockMngmtExcpetion(String message) {
		super(message);
	}
}
