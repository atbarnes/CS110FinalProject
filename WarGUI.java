//Alex Barnes, CS110, The Game of War GUI
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
   GUI representation of the War game
*/
public class WarGUI extends JFrame
{                    
   private War game;
   private JPanel topPanel, gamePanel, playerPanel, deckPanel1, deckPanel2, deckPanel3, deckPanel4, deckPanel5, deckPanel6;
   private JPanel playerSide, computerSide;
   private JButton playCardButton;
   
   private JLabel title;
   private JLabel playerDeck;
   private JLabel computerDeck;
   private JLabel playerCard, playerCard2, playerCard3;
   private JLabel computerCard, computerCard2, computerCard3;
   private JLabel playerPile;
   private JLabel computerPile;
   private JLabel player;
   private JLabel computer;
   
   private ImageIcon backCard;
   private ImageIcon playerCard1;
   private ImageIcon computerCard1;
   private ImageIcon blank;
   
   private static final int WINDOW_WIDTH = 1200;
   private static final int WINDOW_HEIGHT = 700;
   
   public WarGUI()
   {
      game = new War();
      setTitle("Game of War");
      
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      setVisible(true);
      
      backCard = new ImageIcon("C:\\Users\\Barnes\\Documents\\GitHub\\CS110FinalProject\\cardpics\\back.jpg");
      blank = new ImageIcon("C:\\Users\\Barnes\\Documents\\GitHub\\CS110FinalProject\\cardpics\\blank.png");
      topPanel = new JPanel();
      topPanel.setBackground(Color.red);
      
      gamePanel = new JPanel(new BorderLayout());
      gamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 210, 0));
      gamePanel.setBackground(Color.green);
      
      playerPanel = new JPanel(new BorderLayout());
      playerPanel.setBackground(Color.red);
      
      playerSide = new JPanel(new BorderLayout());
      playerSide.setBackground(Color.green);
      
      computerSide = new JPanel(new BorderLayout());
      computerSide.setBackground(Color.green);
      
      deckPanel1= new JPanel();
      deckPanel1.setLayout(new BorderLayout());
      deckPanel1.setBackground(Color.red);
      
      deckPanel2 = new JPanel();
      deckPanel2.setLayout(new BorderLayout());
      deckPanel2.setBackground(Color.red);
      
      deckPanel3 = new JPanel();
      deckPanel3.setBackground(Color.red);
      
      deckPanel4 = new JPanel();
      deckPanel4.setBackground(Color.red);
      
      deckPanel5 = new JPanel();
      deckPanel5.setBackground(Color.red);
      
      deckPanel6 = new JPanel();
      deckPanel6.setBackground(Color.red);
      
      title = new JLabel("Alex's War Game");
      title.setFont(new Font("HELVETICA",Font.ITALIC,36));
      topPanel.add(title);
      
      playerDeck = new JLabel ("Player Deck Amount: " + game.getPlayerPileCards());
      playerDeck.setFont(new Font ("HELVETICA",Font.BOLD,15));
      deckPanel5.add(playerDeck);
      
      computerDeck = new JLabel ("Computer Deck Amount: " + game.getComputerPileCards());
      computerDeck.setFont(new Font ("HELVETICA",Font.BOLD,15));
      deckPanel6.add(computerDeck);
      
      playerPile = new JLabel ("Player Pile Amount: " + game.myPile());
      playerPile.setFont(new Font ("HELVETICA",Font.BOLD,15));
      deckPanel3.add(playerPile);
      
      computerPile = new JLabel ("Computer Pile Amount: " + game.comPile());
      computerPile.setFont(new Font ("HELVETICA",Font.BOLD,15));
      deckPanel4.add(computerPile);

      player = new JLabel ("Player");
      player.setFont(new Font ("HELVETICA",Font.BOLD,15));
      playerPanel.add(player);
      
      playerCard = new JLabel(backCard);
      playerCard2 = new JLabel(blank);
      playerCard3 = new JLabel(blank);
      
      playCardButton = new JButton("PLAY");
      playerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 0));
      playerPanel.add(playCardButton);
      
      playCardButton.addActionListener(new ButtonListener());
      
      computer = new JLabel ("Computer");
      computer.setFont(new Font ("HELVETICA",Font.BOLD,15));
      playerPanel.add(computer);
      
      computerCard = new JLabel(backCard);
      computerCard2 = new JLabel(blank);
      computerCard3 = new JLabel(blank);
      
      add(topPanel, BorderLayout.NORTH);
      add(gamePanel, BorderLayout.CENTER);
      add(playerPanel, BorderLayout.SOUTH);
      add(deckPanel1, BorderLayout.WEST);
      add(deckPanel2, BorderLayout.EAST);
      deckPanel1.add(deckPanel3, BorderLayout.SOUTH);
      deckPanel2.add(deckPanel4, BorderLayout.SOUTH);
      deckPanel1.add(deckPanel5, BorderLayout.NORTH);
      deckPanel2.add(deckPanel6, BorderLayout.NORTH);
      gamePanel.add(playerSide);
      gamePanel.add(computerSide);
      playerSide.add(playerCard, BorderLayout.SOUTH);
      playerSide.add(playerCard2, BorderLayout.CENTER);
      playerSide.add(playerCard3, BorderLayout.NORTH);
      computerSide.add(computerCard, BorderLayout.SOUTH);
      computerSide.add(computerCard2, BorderLayout.CENTER);
      computerSide.add(computerCard3, BorderLayout.NORTH);
      
    }
  /**
      The ButtonListener handles the event for the game of war 
  */
  private class ButtonListener implements ActionListener 
  { 
   
      public void actionPerformed(ActionEvent e)
      {
         //Initialize variables. Set war cards to blank
         Card p;
         Card c;
         Card p3;
         Card c3;
         playerCard2.setIcon(blank);
         playerCard3.setIcon(blank);
         computerCard2.setIcon(blank);
         computerCard3.setIcon(blank);
         
         if (game.getPlayerPileCards() <= 4)
         {
            game.getPlayerPile();
         }
         //If computer cards go to 4 or below, refill cards from pile  
         if (game.getComputerPileCards() <= 4)
         {
            game.getComputerPile(); 
         }
         //If computer or player are completely out of cards, check for winner
         if (game.getPlayerPileCards() <= 4 || game.getComputerPileCards() <= 4)
         {
            if (game.myPile() == 0  || game.comPile() == 0)
            {
               if(game.winner())
               {
                  title.setText("You won the game!");
               }
               else
               {
                  title.setText("You lost the game!");
               }
            }
         }
         
         if (game.getPlayerPileCards() != 0 && game.getComputerPileCards() != 0)   
         {  
            
               game.getCard(); //Each player draws card
               game.compare(game.getPlayerCard(), game.getComputerCard()); //Compares them
               if (game.getWar()) //If War, find winner
               {
                  p = game.getPlayerCard();
                  c = game.getComputerCard(); 
                  p3 = game.getPlayerWarCard();
                  c3 = game.getComputerWarCard();
                  playerCard.setIcon(new ImageIcon("C:\\Users\\Barnes\\Documents\\GitHub\\CS110FinalProject\\cardpics\\" + Card.getImageRank(p) + Card.getImageSuit(p) + ".jpg"));
                  computerCard.setIcon(new ImageIcon("C:\\Users\\Barnes\\Documents\\GitHub\\CS110FinalProject\\cardpics\\" + Card.getImageRank(c) + Card.getImageSuit(c) + ".jpg"));
                  playerCard2.setIcon(new ImageIcon("C:\\Users\\Barnes\\Documents\\GitHub\\CS110FinalProject\\cardpics\\back.jpg"));
                  computerCard2.setIcon(new ImageIcon("C:\\Users\\Barnes\\Documents\\GitHub\\CS110FinalProject\\cardpics\\back.jpg"));
                  playerCard3.setIcon(new ImageIcon("C:\\Users\\Barnes\\Documents\\GitHub\\CS110FinalProject\\cardpics\\" + Card.getImageRank(p3) + Card.getImageSuit(p3) + ".jpg"));
                  computerCard3.setIcon(new ImageIcon("C:\\Users\\Barnes\\Documents\\GitHub\\CS110FinalProject\\cardpics\\" + Card.getImageRank(c3) + Card.getImageSuit(c3) + ".jpg"));


                  if (game.getWarWin())
                  {
                     title.setText("You won the war!");
                     playerDeck.setText("Player Deck Amount: " + game.getPlayerPileCards());
                     computerDeck.setText("Computer Deck Amount: " + game.getComputerPileCards());
                     playerPile.setText("Player Pile Amount: " + game.myPile());
                     computerPile.setText("Computer Pile Amount: " + game.comPile());
                     
                  }
                  else
                  {
                     title.setText("Computer won the war!");
                     playerDeck.setText("Player Deck Amount: " + game.getPlayerPileCards());
                     computerDeck.setText("Computer Deck Amount: " + game.getComputerPileCards());
                     playerPile.setText("Player Pile Amount: " + game.myPile());
                     computerPile.setText("Computer Pile Amount: " + game.comPile());
                  }
               }                  //If not war, compare as usual and display winner
               else
               {
                  p = game.getPlayerCard();
                  c = game.getComputerCard();
                  playerCard.setIcon(new ImageIcon("C:\\Users\\Barnes\\Documents\\GitHub\\CS110FinalProject\\cardpics\\" + Card.getImageRank(p) + Card.getImageSuit(p) + ".jpg"));
                  computerCard.setIcon(new ImageIcon("C:\\Users\\Barnes\\Documents\\GitHub\\CS110FinalProject\\cardpics\\" + Card.getImageRank(c) + Card.getImageSuit(c) + ".jpg"));
                  
                  if (game.getRoundWin())
                  {
                     title.setText("You won the round");
                     playerDeck.setText("Player Deck Amount: " + game.getPlayerPileCards());
                     computerDeck.setText("Computer Deck Amount: " + game.getComputerPileCards());
                     playerPile.setText("Player Pile Amount: " + game.myPile());
                     computerPile.setText("Computer Pile Amount: " + game.comPile());
                  }
                  else
                  {
                     title.setText("Computer won the round");
                     playerDeck.setText("Player Deck Amount: " + game.getPlayerPileCards());
                     computerDeck.setText("Computer Deck Amount: " + game.getComputerPileCards());
                     playerPile.setText("Player Pile Amount: " + game.myPile());
                     computerPile.setText("Computer Pile Amount: " + game.comPile());
                  }
                  
               }

      
           }
       }
      
      
      }




   

   // main driver
   public static void main(String [] args)
   {
      WarGUI war = new WarGUI();
      
   }





}