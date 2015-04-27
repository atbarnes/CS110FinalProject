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
      
      System.out.println(computerPile.cardsRemaining());
      System.out.println(playerPile.cardsRemaining());
    
      //Plays game. Compares cards and gives them to each player
      while (!playerPile.isEmpty() || !computerPile.isEmpty())
      {  
         if (playerPile.cardsRemaining() <= 4)
         {
            getPlayerPile();
         
         }
            
         if (computerPile.cardsRemaining() <= 4)
         {
            getComputerPile(); 
         }
         
         if (playerPile.isEmpty() || computerPile.isEmpty())
         {
            String winner = winner();
            System.out.println(winner());
         }
         
         Scanner keyboard = new Scanner(System.in);
         System.out.println("Would you like to draw cards (y/n)? ");
         String answer = keyboard.nextLine();
         
         
         if (!playerPile.isEmpty() && !computerPile.isEmpty())   
         {  
            if (answer.equals("y"))
            { 
               System.out.println("draw card");
               getCard();
               compare(playerCard, computerCard);
            }
            
            if (answer.equals("n"))
            {
               System.out.println("Game over");
               System.exit(0);
            }
          }
          
          
      }
      
      
    }  
    
//Method to draw card from top of each pile

   public void getCard()
   {
      
         playerCard = playerPile.dealCard();
         computerCard = computerPile.dealCard();
         
         WarPile.add(0, playerCard);
         WarPile.add(0, computerCard);
      
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
         
         System.out.println("Player Card: " + object1 + ". Computer Card: " + object2 + ". You win!");
         System.out.println("Player:" + playerPile.cardsRemaining());
         System.out.println("Computer: " + computerPile.cardsRemaining());

      }
      
      else if (object2.getRank() > object1.getRank())
      {
         while(WarPile.cardsRemaining() != 0)
         {
            warCard = WarPile.dealCard();
            computerPile2.add(0, warCard);
            
         }
         
         System.out.println("Player Card: " + object1 + ". Computer Card: " + object2 + ". You lose!");
         System.out.println("Player: " + playerPile.cardsRemaining());
         System.out.println("Computer: " + computerPile.cardsRemaining());
      }
      
      else if (object2.getRank() == object2.getRank())
      {
         System.out.println("Tie! Its war time");
         cardWar();
      }
      
      else
      {
        System.out.println("poop");
      }
    
   
   
   }
      //In the case of a war, this method is called
   public void cardWar()
   {
         
        if (playerPile.cardsRemaining() >= 2 && computerPile.cardsRemaining() >= 2) 
        {   
            playerCard2 = playerPile.dealCard();
            computerCard2 = computerPile.dealCard(); //Sets down two player cards
            
            playerCard3 = playerPile.dealCard();
            computerCard3 = computerPile.dealCard(); //Sets down computer cards
            
            WarPile.add(0, playerCard2); //All cards in war put in a pile
            WarPile.add(0, computerCard2);
            WarPile.add(0, playerCard3);
            WarPile.add(0, computerCard2);
            Scanner k = new Scanner(System.in);
            System.out.println("Ready? (enter y): ");
            String ans  = k.nextLine();
            
            if (ans.equals("y"))
            {
               compare(playerCard3, computerCard3);
            }
         }
         
         if (playerPile.cardsRemaining() < 2)
         {
            System.out.println("Computer Wins");
            System.exit(0);
            
         }
         
         if (computerPile.cardsRemaining() < 2)
         {
            System.out.println("Player Wins");
            System.exit(0);
         
         }
      
   }
   
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
      
      if (playerPile.cardsRemaining() == 0)
      {
         winner();
      }
   }
   
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
      
      if (computerPile.cardsRemaining() == 0)
      {
         winner();
      }
   }  
   
   public String winner()
   {
      if (playerPile.isEmpty() && playerPile2.isEmpty())
      {
         return "You lost the game!";
      }
      else if (computerPile.isEmpty() && computerPile2.isEmpty())
      {
         return "You win the game!";
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






