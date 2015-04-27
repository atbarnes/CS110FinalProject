import java.util.Random;
import java.util.ArrayList;

public class CardPile
{
   
  
  //private int ct;
  private final int MAX_CARDS = 52;
  private ArrayList<Card> cardPile;
  
   public CardPile()
   {
      cardPile = new ArrayList<Card>();
       
   }
   
   //Adds card to card pile
   
   public void add(int i, Card object)
   {
      cardPile.add(i, object);
   }
   
   //Removes the top card from the cardPile. Returns the card removed
   

   
   public Card dealCard()
   {
      Card c = cardPile.remove(0);  //  remove it (returns removed object)
      return c;
   }
   
   /** 
     * Return current number of Cards in Deck
     * @return number of Cards in Deck
     */

   public int cardsRemaining()
   {  
      return cardPile.size();
   }
   /** 
     * Randomize the order of Cards in Deck
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
     * Determine if Deck is empty
     * @return true if there are no more cards, false otherwise
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
