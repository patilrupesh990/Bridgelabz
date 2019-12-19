package com.bridgelabz.oops.deckofcards;

import com.bridgelabz.util.Utility;

/***********************************************************************************************************
* @author Rupeshp007
* date:19/12/2019
* @version 1.0
* Purpose:InterFace of DeckOfCard program it contains start method to start the game and also contains programs
* 		  Concrete methods. 
* 
**********************************************************************************************************/

public interface DeckOfCard 
{
	
	DeckOfCard card = new DeckOfCardService();
	
	/**************************************************
	 * To start the game gives choice to User 
	 * -Shuffle cards
	 * -show cards
	 * -exit game
	 **************************************************/
	public static void Start()
	{
		while(true)
		{
			System.out.println("1.Shuffle Cards  2.Show Cards  3.Exit ");
			int choice=Utility.InputInt();
			switch(choice)
			{
				
				case 1:
					for (int count = 1; count <= 4; count++) 
						card.assignCards(count);
					System.out.println("Cards Distributed between 4 palyes press 2 to Show Cards");
					break;
				case 2:
						for(int count=1;count<=4;count++)
						{
							System.out.println("Player " + count + "\n---------");
							card.printCards(count);
							//card.assignCards(count);
						}
						break;
				case 3:
						System.exit(0);
			}
		}
	}
	
	void shuffle();
	void display();
	void assignCards(int index);
	void shuffleCards(int player);
	void printCards(int player); 
}
