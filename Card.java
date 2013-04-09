//************************************************************
//  Card.java                      
//
//  Provides an implementation of a class to represent a
//  playing card.
//************************************************************
import java.util.Random;
import javax.swing.*;

public class Card
{
  protected String face;  //ace, jack, queen, king, seven,...
  protected ImageIcon cardPic; //picture 
  protected int value;   //10 for face cards, and facevalue for numeric cards, 1/11 for ace card
  protected String suit;  //spade, club, heart, diamond
  
  /***********************************************************
    Constructs a card.
  ***********************************************************/
  public Card()
  {
		//add your java codes to set up an inital card
      cardPic = null;
      value = 0;
      suit = null;
      face = null;

  }
  
  /***********************************************************
    Draws the shape of this card.
  ***********************************************************/
  public Card(ImageIcon x, int val, String s, String f)
  {
    //add your java codes to set up an initial card with specified attributes.
    cardPic = x;
    value = val;
    face = f;
    suit = s;
  }
  
  /***********************************************************
    Returns the image of this card.
  ***********************************************************/
  public ImageIcon getImage()
  {
    //add your java codes to return an image
    return cardPic;
  }
  
  /***********************************************************
    Returns the value of this card.
  ***********************************************************/
  public int getValue()
  {
    //add your java codes to return the face value of the card
    return value;
  }
  
  /***********************************************************
    Allows the user to set the value of this card.
  ***********************************************************/
  public void setValue(int v)
  {
    //sets the face value of the card to the specified value
    value = v;
  }

  /***********************************************************
     Returns the suit of this card.
  ***********************************************************/
  public String getSuit()
  {
    //returns the suit of the card
    return suit;
  }

  /***********************************************************
     Returns the face of this card.
  ***********************************************************/
  public String getFace()
  {
    return face;
  }
  
  /***********************************************************
     Returns a string representation this card.
  ***********************************************************/
  public String toString()
  {
    // return a string reprentation of the card, which includes "Face: ", " Suit" and " face Value"
    return "Face: "+ face + " Suit"+ suit +" Face Value "+ value;
  }
}
