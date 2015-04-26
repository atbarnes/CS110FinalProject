/**
 * Representation of a Deck of cards.  
 * Initialized to a standard 52 card deck. 
 *
 * @author Jackie Horton
 */

import java.util.Random;
import java.util.ArrayList;

public class Deck extends CardPile
{
   /** 
   *  Number of cards in standard deck {@value #CARDS_IN_DECK}
   **/
   final int CARDS_IN_DECK = 52;

   /** The collection of Cards */
   
   
   /**
    * Constructs a regular 52-card deck.  Initially, the cards
    * are in a sorted order.  The shuffle() method can be called to
    * randomize the order.  
    */
   public Deck()
   {
            super();
            freshDeck();
   }
   /**
    * Create a new collection of 52 cards, in sorted order
    */
   public void freshDeck()
   {
      
      for (int r = Card.ACE; r<=Card.KING;r++)
      {
         for (int s= Card.SPADES; s<=Card.DIAMONDS;s++)
         {
           super.add(0, new Card(s,r));
         }
      }
      
      
     
   
   }
     

   public static void main(String [] args) 
   {
      Deck deck = new Deck();
      deck.shuffle();
      int i = 0;
      Card card;
      while (!(deck.isEmpty()))
      {  
          card = deck.dealCard();
          System.out.println(i++ + " : " + card + " " + card.getSuit());
          System.out.println(deck.cardsRemaining());
               
      }
      

   }

}