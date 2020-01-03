package com.bridgelabz.designpattern.behavioral.visitor;
/***********************************************************************************************************
 * @author Rupeshp007
 * date:24/12/2019
 * @version 1.0
 * Purpose:ShppingCartClien class Controller and contains Calculate price method.
 **********************************************************************************************************/

public class ShoppingCartClient {

	public static void main(String[] args) {
		ItemElement[] items = new ItemElement[]{new Book(25, "111"),new Book(20, "222"),
				new Fruit(40, 2, "Grapes"), new Fruit(6, 64, "Stawberry")};
		
		int total = calculatePrice(items);
		System.out.println("Total Cost = "+total);
	}
	/******************************************
	 * to Calculate Price Price of product
	 *@return int
	 ******************************************/
	private static int calculatePrice(ItemElement[] items) {
		ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
		int sum=0;
		for(ItemElement item : items){
			sum = sum + item.accept(visitor);
		}
		return sum;
	}

}