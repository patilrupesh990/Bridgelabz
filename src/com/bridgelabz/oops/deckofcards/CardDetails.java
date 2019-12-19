package com.bridgelabz.oops.deckofcards;

/***********************************************************************************************************
* @author Rupeshp007
* date:18/12/2019
* @version 1.0
* Purpose:its Declaration of cards and user can get cards from this class To get 4 suits and 13 cards based on
* 		  their index.
* 
**********************************************************************************************************/

public class CardDetails {

	private static final String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
	private static final String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };



	public static String getSuit(int index) {
		return suits[index];
	}

	public static String getRank(int index) {
			return rank[index];

		}

	}

