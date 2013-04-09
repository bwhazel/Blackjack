//************************************************************
//  Blackjack.java		
//
//  The BlackJack class provides an implementation of a single
//  deck blackjack game.  It makes use of the Hand class to 
//  represent a player's hand and the Deck class to represent
//  the deck of cards for the game.
//*************************************************************
import jss2.exceptions.*;
import java.util.*;

public class Blackjack
{
  Hand dealer;    //to hold the dealer's cards
  Hand player;    //to hold the player's cards
  Deck newDeck;   //a set of cards

  /*************************************************************
    Creates dealer, player and deck.
  *************************************************************/
  public Blackjack(Hand dlr, Hand plr)
  {
  	//add code
	//construct a new Balckjack game with dealer and player as specified
	//				and a new deck created 
   dealer = dlr;
   player = plr;
   newDeck = new Deck(); 

  }

  /*************************************************************
    Deals the intitial cards to each player.
  *************************************************************/
  public void dealInitialCards()            
  { 
  	//add code to deal two cards to the dealer and two cards to the player
	//from the new deck 
   player.newCard(newDeck);
   player.newCard(newDeck); 
   dealer.newCard(newDeck);
   dealer.newCard(newDeck); 

  }

  /*************************************************************
    Adds the next random card from the deck to the given 
    player's hand.
  *************************************************************/
  public Card hit(Hand whoHit)
  {
  	//add code
	//randomly deal one more card from the new deck and add it to the hand requested the hit
	//Hint: check the newCard() method of the Hand class  
   Card result = whoHit.newCard(newDeck);
   
   return result;

  }

  /*************************************************************
    Returns the value of the given player's hand.
  *************************************************************/
  public int handValue(Hand whoHand)
  {
 	//Add code
	//return the hand value of the specified hand 
   int result = whoHand.getHandValue();
   
   return result;

  }

  /*************************************************************
    Discards a given card from the given player's hand. 
    Throws an ElementNotFoundException if the card is not 
    in the hand.
  *************************************************************/
  public void discard(Hand whoDis, Card discrd) 
                      throws ElementNotFoundException
  {
    Card card=null;
    boolean found = false;
    Iterator<Card> scan = whoDis.iterator();
    while (scan.hasNext() && !found)
    {
        card = scan.next();
        if(discrd.equals(card))
        {
          whoDis.remove(card);
          found = true;
        }
    }
    if(!found)
        throw new ElementNotFoundException("BlackJack");
  }

  /***********************************************************
    Tests to see if the player's hand has a value of 21.
  ***********************************************************/
  public boolean blackj()
  {
     //add code
     //check if the player has a black jack by checking on player's hand value
     //      return the result as boolean  
  
     boolean result;
     
     if(player.getHandValue()==21)
     {
         result = true;
     }
     else
     {
      result = false;
     }
     
     return result;

  }

  /***********************************************************
    Tests a given player's hand to see if they have 
    gone over 21.
  ***********************************************************/
  public boolean bust(Hand whoBust)
  {
    //add code
  //check if the current hand busts by checking if current hand value is over 21
  //      return the result as boolean  
  
     boolean result;
     
     if(whoBust.getHandValue()>21)
     {
         result = true;
     }
     else
     {
      result = false;
     }
     
     return result;

  }

  /***********************************************************
     Adds cards to the dealer's hand until the value 
     is greater than or equal to 16.
  ***********************************************************/
  public Hand dealerPlays()
  {
  	//add code
	//implement dealer's rule: keep adding new cards till the dealer's handvalue is over 16
	//return the new dealer hand after implementing the dealer's rule
	
   Hand result = dealer;
   
   while(dealer.getHandValue()<=16)
   {
      dealer.newCard(newDeck);
   }
   return result;

  }
  
  /***********************************************************
    Determines the winner of the game.
  ***********************************************************/
  public String winner()
  {
    String result = "";
    //add code to implementing the following winning rules:
	 
	 //if dealer's hand value is larger than the player's and dealer does not bust
	 //declare "Lose" for the player
	 //if dealers hand value is the same as the player's and no one busts,
	 //declare "Push" as the result
	 //declare "win" for the player otherwise
	 
    if((player.getHandValue()<dealer.getHandValue()) && dealer.getHandValue()<=21)
    {
      result = "You Lost!";
    }
    else if((player.getHandValue() == dealer.getHandValue()) && dealer.getHandValue() <=21)
    {
      result = "Push!";
    }
    else
    {
      result = "You Won!";
    }

    return result;
  }
}
