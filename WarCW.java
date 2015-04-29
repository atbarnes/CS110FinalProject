//Alex Barnes, CS110, War game, A Game of War in the command window
import  java.util.Scanner;

public class WarCW
{
  
   public WarCW()
   {
      
      War war = new War(); //Sets up new game
      System.out.println(war.getPlayerPileCards());
      System.out.println(war.getComputerPileCards());
    
      //Plays game. Compares cards and gives them to each player
      while (war.getPlayerPileCards() != 0 || war.getComputerPileCards() != 0)
      {  
         //If player cards go to 4 or below, refill cards from pile
         if (war.getPlayerPileCards() <= 4)
         {
            war.getPlayerPile();
            System.out.println("Refilling player deck");
         }
         //If computer cards go to 4 or below, refill cards from pile  
         if (war.getComputerPileCards() <= 4)
         {
            war.getComputerPile(); 
            System.out.println("Refilling computer deck");
         }
         //If computer or player are completely out of cards, check for winner
         if (war.getPlayerPileCards() <= 4 || war.getComputerPileCards() <= 4)
         {
            if (war.myPile() == 0  || war.comPile() == 0)
            {
               System.out.println("Out of cards!");
               if(war.winner())
               {
                  System.out.println("You won the game!");
               }
               else
               {
                  System.out.println("You lost the game!");
               }
            }
         }
         
         //Ask user to draw card. If no, ends program
         Scanner keyboard = new Scanner(System.in);
         System.out.println("Would you like to draw cards (y/n)? ");
         String answer = keyboard.nextLine();
         
         //If player has cards in deck and computer has cards in deck, draw cards and compare them
         if (war.getPlayerPileCards() != 0 && war.getComputerPileCards() != 0)   
         {  
            if (answer.equals("y"))
            { 
               
               war.getCard(); //Each player draws card
               war.compare(war.getPlayerCard(), war.getComputerCard()); //Compares them
               if (war.getWar()) //If War, find winner
               {
                  System.out.println("WAR!");
                  System.out.println("You have a " + war.playerWarCardToString() + ". Your opponent has a " + war.computerWarCardToString());
                  if (war.getWarWin())
                  {
                     System.out.println("You won the war!");
                  }
                  else
                  {
                     System.out.println("You lost the war!");
                  }
                  System.out.println(war.getPlayerPileCards() + " " + war.getComputerPileCards()); //Display remaining cards 
               }
               //If not war, compare as usual and display winner
               else
               {
                  System.out.println("You have a " + war.playerCardToString() + ". Your opponent has a " + war.computerCardToString());
                  if (war.getRoundWin())
                  {
                     System.out.println("You won the round");
                  }
                  else
                  {
                     System.out.println("You lost the round");
                  }
                  System.out.println(war.getPlayerPileCards() + " " + war.getComputerPileCards()); //Display remaining cards
               }
              
            }
            //Ends program if no
            if (answer.equals("n"))
            {
               System.out.println("Game over");
               System.exit(0);
            }
          }
          
          
      }
      
      
    }  
   
   //Main driver
   public static void main(String [] args)
   {
      WarCW war = new WarCW();
      
   }
   
   

   
 }






