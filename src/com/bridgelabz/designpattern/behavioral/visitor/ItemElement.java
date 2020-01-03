package com.bridgelabz.designpattern.behavioral.visitor;

/***********************************************************************************************************
 * @author Rupeshp007
 * date:24/12/2019
 * @version 1.0
 * Purpose:Interface ItemElement of Visitor design pattern
 **********************************************************************************************************/

public interface ItemElement 
{
	
		public int accept(ShoppingCartVisitor visitor);
	
}
