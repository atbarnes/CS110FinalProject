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
   private Boolean roundWin = false;
   private Boolean warWin = false;
   private Boolean war = false;
   private Boolean playerWin = false;
   private Boolean computerWin = false;
/**
   Sets up game of War. Creates new deck and deals half to each player
*/
  
   public War()
   {
      //Creates deck, shuffles it, and creates piles for each player
      deck = new Deck();
      deck.shuffle();
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
      
   }
   

          
          
 
    
/**
   The getCard method draws the top card from each players hand
*/
   public void getCard()
   {
      
         playerCard = playerPile.dealCard();
         computerCard = computerPile.dealCard();
         
         WarPile.add(0, playerCard);
         WarPile.add(0, computerCard);
      
   }

/**
   The compare method compares each players card to see which is bigger. All the cards
   in that rounds pile go to the player whose card is bigger
   @param object1 A card object to be compared
   @param object2 Another card object to be compared
*/
   public void compare(Card object1, Card object2)
   {
      
      if (object1.getRank() > object2.getRank())
      {
         while(WarPile.cardsRemaining() != 0)
         {
            warCard = WarPile.dealCard();
            playerPile2.add(0, warCard);
            
         }
         
         roundWin = true;
         
      }
      
      if (object2.getRank() > object1.getRank())
      {
         while(WarPile.cardsRemaining() != 0)
         {
            warCard = WarPile.dealCard();
            computerPile2.add(0, warCard);
           
         }
         
         roundWin = false;
         
      }
      //If both cards are equal, a war is started
      if (object2.getRank() == object1.getRank())
      {
         cardWar();
      }
      
   }
   
   /**
      The cardWar method deals one card, then another one. The last card dealt by each
      player is compared. If it is bigger, all the cards go to that respective players
      pile 
   */
   
   public void cardWar()
   {
         
        if (playerPile.cardsRemaining() >= 2 && computerPile.cardsRemaining() >= 2) 
        {   
            war = true;
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
         //If the cards remaining by either player are less than 0, ends game
         if (playerPile.cardsRemaining() < 2)
         {
            
            System.exit(0);
            
         }
         
         if (computerPile.cardsRemaining() < 2)
         {
            
            System.exit(0);
         
         }
      
   }
   /**
      The getPlayer Pile refills your deck with 
      the cards from your card pile
   */
   public void getPlayerPile()
   {
      if (!playerPile2.isEmpty())
      {
         while (playerPile2.cardsRemaining() != 0)
         {
             warCard = playerPile2.dealCard();
             playerPile.add(0, warCard);
         }
                  
             playerPile.shuffle();
            
      }
   }
   
   /**
      The getComputerPile method refiils your opponents
      deck with the cards from your card pile
   */
   
   public void getComputerPile()
   {
      if (!computerPile2.isEmpty())
      {
         while (computerPile2.cardsRemaining() != 0)
         {
             warCard = computerPile2.dealCard();
             computerPile.add(0, warCard);
         }
                  
         computerPile.shuffle();
            
      }
    
   }  
   
   /**
      The winner method returns the winner of the game
      @return The winner of the game
   */
   
   public Boolean winner()
   {
      if (playerPile.isEmpty())
      {
         computerWin = true;
         return computerWin;
      }
      else 
      {
         playerWin = true;
         return playerWin;
      }
      
   }
   
   /**
      The getRoundWin method returns the winner of a round
      @return The winner of a round
   */
   
   public Boolean getRoundWin()
   {
      if (roundWin == true)
      {
         return true;
         
      }    
   
      else
      {
      
         return false;
      }
   
   }
   
   /**
      The getWarWin method returns the winner of a war
      @return The winner of a war
   */
   
   public Boolean getWarWin()
   {
      if (warWin == true)
      {
         warWin = false;
         war = false;
         return true;
         
      }
      
      else
      {
         warWin = false;
         war = false;
         return false;
      }
   
   
   }
   
   /**
      The getPlayerPileCards method returns the amount
      of cards remaining in the players deck
      @return The cards remaining in the players hand
   */
   
   public int getPlayerPileCards()
   {
      return playerPile.cardsRemaining();
   
   }
   
   /**
      The getComputerPileCards method returns the amount of
      cards remaining in the computers deck
      @return The cards remaining in the players hand
   */
   
   public int getComputerPileCards()
   {
      return computerPile.cardsRemaining();
   
   }
   
   /**
      The getWar method returns the status of the war variable
      @return If true, there is a war. If false, not a war
   */
   
   public Boolean getWar()
   {
      return war;
   }
   
   /**
      The getPlayer Card method return the players card
      @return The players card
   */
   
   public Card getPlayerCard()
   {
      return playerCard;
  
   }
   
   /**
      The getComputerCard method returns the computers card
      @return The computers card
   */
   
   public Card getComputerCard()
   {
      return computerCard;
   
   }
   
   /**
      The getPlayerWarCard method returns the players card
      that is used to compare in a war
      @return The player card to be compared in a war   
   */
   
   public Card getPlayerWarCard()
   {
      return playerCard3;
   
   }
   
   /**
      The getComputerWarCard method returns the computers card
      that is used to compare in a war
      @return The computer card to be compared in a war
   */
   
   public Card getComputerWarCard()
   {
      return computerCard3;
   }
   
   /**
      The getPlayerRank method returns the rank of the
      players card
      @return The rank of the player card
   */
   
   public int getPlayerRank()
   {
      return playerCard.getRank();
   }
   
   /**
      The getComputerRank method returns the rank of the 
      computers card
      @return The rank of the computer card
   */
   
   public int getComputerRank()
   {
      return computerCard.getRank();
   }
   
   /**
      The playerCardToString method returns a string representation
      of the player card
      @return A string representation of the players card
   */
   
   public String playerCardToString()
   {
      return playerCard.toString();
   }
   
   /**
      The computerCardToString method returns a string representation
      of the computer card
      @return A string representaiton of the computers card
   */
   
   public String computerCardToString()
   {
      return computerCard.toString();
   }
   
   /**
      The playerWarCardToString method returns a string represenation
      of the players war card to be compared
      @return A string representation of the players war card to be compared
   */
   
   public String playerWarCardToString()
   {
      return playerCard3.toString();
   }
   
   /**
      The computerWarCardToString method returns a string representation 
      oft the computers war card to be comared
      @return A string representation of the computers war card to be compared
   */
   
   public String computerWarCardToString()
   {
      return computerCard3.toString();
   }
   
   
   
}






