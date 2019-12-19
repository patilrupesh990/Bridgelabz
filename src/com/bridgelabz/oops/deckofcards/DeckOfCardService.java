package com.bridgelabz.oops.deckofcards;

import java.util.Random;

/***********************************************************************************************************
* @author Rupeshp007
* date:15/12/2019
* @version 1.0
* Purpose:Its Service class for the DeckofCard program this class implements DeckOfCrads interface and overrides
* 		  methods..
* 
*	void shuffle();
*	void display();
*	void assignCards(int index);
*	void shuffleCards(int player);
*	void printCards(int player); 
**********************************************************************************************************/

public class DeckOfCardService implements DeckOfCard{
	private int[][] cards=new int[4][13];;

	private static final String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
	private static final String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
	private int deckLength = suits.length * rank.length;
	private String[] bunchOfCard = new String[deckLength];


	/***************
	 * Constructor of DeckOfService class
	 **************************************************/
	public DeckOfCardService() {
		for (int count = 0; count < rank.length; count++) {
			for (int count2 = 0; count2 < suits.length; count2++) {
				bunchOfCard[suits.length * count + count2] = rank[count] + " " + suits[count2];
			}
		}
	}

	/***************
	 * To Shuffle cards randomly between players 
	 **************************************************/
	@Override
	public void shuffle() {
		for (int count = 0; count < bunchOfCard.length; count++) {
			int Card = count + (int) (Math.random() * (bunchOfCard.length - count));
			String temp = bunchOfCard[Card];
			bunchOfCard[Card] = bunchOfCard[count];
			bunchOfCard[count] = temp;
		}
	}

	/***************
	 * prints all the cards received by The players.
	 **************************************************/
	@Override
	public void display() {
		System.out.println("Total number of cards in deck : " + bunchOfCard.length);
		int index = 1;
		for (int count = 0; count < bunchOfCard.length; count++) {
			if (count % 13 == 0) {
				System.out.println("\nplayer : " + index++ + "\n----------");
			}
			System.out.println(bunchOfCard[count]);
		}
	}

	

	/**
	 * Shuffling the card and assigning to each player 9 cards.
	 * 
	 * @param playerNumber
	 */
	@Override
	public void assignCards(int index) {
		for (int count = 0; count < 9; count++) {
			shuffleCards(index);
		}
	}

	/**
	 * Randomly generate suits and rank recursively calls the function unless 0 is
	 * found in the 2D array if not found then assign card to that player.
	 * 
	 * @param playerNumber as integer Input parameter
	 */
	@Override
	 public void shuffleCards(int player) {
		Random random = new Random();
		int suit = random.nextInt(4);
		int rank = random.nextInt(13);
		if (cards[suit][rank] != 0)
			shuffleCards(player);
		else
			cards[suit][rank] = player;
	}

	/**
	 * prints all the cards received by player 1, player 2, player 3, player 4
	 */
	@Override
	public void printCards(int player) {
		for (int suit = 0; suit < 4; suit++) {
			for (int rank = 0; rank < 13; rank++) {
				if (cards[suit][rank] == player) {
					System.out.print(CardDetails.getSuit(suit) + "::" + CardDetails.getRank(rank) + "\n");
				}
			}
		}
		System.out.println();
	}


	
}
