package com.bridgelabz.designpattern.behavioral.visitor;
/***********************************************************************************************************
 * @author Rupeshp007
 * date:24/12/2019
 * @version 1.0
 * Purpose:Fruit Class to set and get value of book price and isbn 
 * 			also overrides ItemElement Interface
 **********************************************************************************************************/

public class Fruit implements ItemElement {
	
	private int pricePerKg;
	private int weight;
	private String name;
	/**
	 * Constructor of Fruit class Takes Book cost and isbn as argument
	 * @param int price,String nm
	 **/
	public Fruit(int priceKg, int wt, String nm){
		this.pricePerKg=priceKg;
		this.weight=wt;
		this.name = nm;
	}
	
	/**
	 * to getPrice of Fruit
	 *@return int
	 **/
	
	public int getPricePerKg() {
		return pricePerKg;
	}

	/**
	 * to getWeight of Fruit
	 *@return int
	 **/
	public int getWeight() {
		return weight;
	}
	
	/**
	 * to getName of Fruit
	 *@return int
	 **/
	public String getName(){
		return this.name;
	}
	
	@Override
	public int accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}

}