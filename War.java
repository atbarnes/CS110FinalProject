//Alex Barnes, CS110, War game, A Game of War 
import  java.util.Scanner;

public class War
{
   private Deck deck;
   private Card playerCard, computerCard;
   private Card playerCard2, computerCard2;
   private Card playerCard3, computerCard3;
   private Card warCard;
   private CardPile playerPile, computerPile, playerPile2, computerPile2;
   private CardPile WarPile;
 
   
//Sets up new game
  
   public War()
   {
      
      deck = new Deck();
      playerPile = new CardPile();
      computerPile = new CardPile();
      playerPile2 = new CardPile();
      computerPile2 = new CardPile();
      WarPile = new CardPile();
      
      //Deals cards to player
      for (int index = 0; index < 26; index ++) 
      {
         warCard = deck.dealCard();
         System.out.println(); 
         playerPile.add(index, warCard);
            
      }
      //Deals cards to computer
      for (int index = 0; index < 26; index ++) 
      {  
         warCard = deck.dealCard();
         System.out.println();
         computerPile.add(index, warCard); 
      }
      
      System.out.println(computerPile.cardsRemaining());
      System.out.println(playerPile.cardsRemaining());
    
      //Plays game. Compares cards and gives them to each player
      while (!playerPile.isEmpty() || !computerPile.isEmpty())
      {
         System.out.println("draw card");
         getCard();
         compare(playerCard, computerCard);
         
         if (playerPile.isEmpty())
         {
            while (playerPile.cardsRemaining() != 0)
            {
               warCard = playerPile2.dealCard();
               playerPile.add(0, warCard);
            }
         }
         
         if (computerPile.isEmpty())
         {
            while (computerPile.cardsRemaining() != 0)
            {
               warCard = computerPile2.dealCard();
               computerPile.add(0, warCard);
            }
         
         
         }
      }
      
      String winner = winner();
      System.out.println(winner);
    }  
    
//Method to draw card from top of each pile

   public void getCard()
   {
      if (!playerPile.isEmpty() || !computerPile.isEmpty())
      {  
         playerCard = playerPile.dealCard();
         computerCard = computerPile.dealCard();
         WarPile.add(0, playerCard);
         WarPile.add(0, computerCard);
      }
   }

//Compares cards, if one is bigger, put into that players pile.
   public void compare(Card object1, Card object2)
   {
      
      if (object1.getRank() > object2.getRank())
      {
         while(WarPile.cardsRemaining() != 0)
         {
            warCard = WarPile.dealCard();
            playerPile2.add(0, warCard);
         }

      }
      
      else if (object2.getRank() > object1.getRank())
      {
         while(WarPile.cardsRemaining() != 0)
         {
            warCard = WarPile.dealCard();
            computerPile2.add(0, warCard);
         }
      }
      
      else
      {
         cardWar();
      }
    
   
   
   }
      //In the case of a war, this method is called
   public void cardWar()
   {
         if (!playerPile.isEmpty() || !computerPile.isEmpty())
         {
            playerCard2 = playerPile.dealCard();
            computerCard2 = computerPile.dealCard(); //Sets down two player cards
            
            playerCard3 = playerPile.dealCard();
            computerCard3 = computerPile.dealCard(); //Sets down computer cards
            
            WarPile.add(0, playerCard2); //All cards in war put in a pile
            WarPile.add(0, computerCard2);
            WarPile.add(0, playerCard3);
            WarPile.add(0, computerCard2);
            
            compare(playerCard3, computerCard3);
         }
         
      
   }  
   
   public String winner()
   {
      if (playerPile.isEmpty() && playerPile2.isEmpty())
      {
         return "Computer Wins!";
      }
      else if (computerPile.isEmpty() && computerPile2.isEmpty())
      {
         return "You win!";
      }
      else
      {
         return "Your program doesn't work";
      }
   }
   
   
   public static void main(String [] args)
   {
      War war = new War();
      
   }


   
 }






