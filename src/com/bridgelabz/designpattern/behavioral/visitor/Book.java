package com.bridgelabz.designpattern.behavioral.visitor;
/***********************************************************************************************************
 * @author Rupeshp007
 * date:24/12/2019
 * @version 1.0
 * Purpose:Book Class to set and get value of book price and isbn 
 * 			also overrides ItemElement Interface
 **********************************************************************************************************/

	public class Book implements ItemElement {

		private int price;
		private String isbnNumber;
		/**
		 * Constructor of Book class Takes Book cost and isbn as argument
		 * @param int cost,String isbn
		 **/
		public Book(int cost, String isbn){
			this.price=cost;
			this.isbnNumber=isbn;
		}
		
		/**
		 * to getPrice of book
		 *@return int
		 **/
		public int getPrice() {
			return price;
		}
		/**
		 * to getIsbn Number of book
		 *@return String
		 **/
		public String getIsbnNumber() {
			return isbnNumber;
		}
		
		/************************************
		 * Overridden method of ItemElement
		 * @param ShoppingCartVisitor visitor
		 * @return int
		 *************************************/
		@Override
		public int accept(ShoppingCartVisitor visitor) {
			return visitor.visit(this);
		}

	}

