import java.util.Random;
import java.util.ArrayList;

public class CardPile
{
   
  
  //Inititalize variables
  private final int MAX_CARDS = 52;
  private ArrayList<Card> cardPile;
  
   public CardPile()
   {
      cardPile = new ArrayList<Card>();
       
   }
   
   /**
      The add method adds card to the card pile
      @param i The index to add the object
      @param object The card object to be added
   */
   
   public void add(int i, Card object)
   {
      cardPile.add(i, object);
   }
   
   /**
      Deals the top card from the pile. Returns it
      @return The top card from the card pile
   */
   
   public Card dealCard()
   {
      Card c = cardPile.remove(0);  //  remove it (returns removed object)
      return c;
   }
   
   /** 
     The cardsRemaining method teturns the current number of Cards in Deck
     @return Number of cards in the card pile
   */

   public int cardsRemaining()
   {  
      return cardPile.size();
   }
   
   /** 
      The shuffle method randomizes the order of the card pile
   */
   
   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < cardPile.size(); i++)
      {
         randNum = r.nextInt(cardPile.size());
         temp = cardPile.get(i);
         cardPile.set(i,cardPile.get(randNum));
         cardPile.set(randNum,temp);
      }      
   }
   
   /** 
     Determine if Deck is empty
     @return true if there are no more cards, false otherwise
   */
   
   public boolean isEmpty()
   {
      return (cardPile.size() == 0);
   }
   public static void main(String [] args)
   {
   
      CardPile pile = new CardPile();
      pile.add(0,new Card(1,1));
      pile.add(0,new Card(2,2));
      
   }

}
