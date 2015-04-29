//Alex Barnes, CS110, Card Class

public class Card
{
   //Inititialize variables
   
   public static int SPADES = 1;
   public static int CLUBS = 2;
   public static int HEARTS = 3;
   public static int DIAMONDS = 4;
   public static int ACE = 14;
   public static int TWO = 2;
   public static int THREE = 3;
   public static int FOUR = 4;
   public static int FIVE = 5;
   public static int SIX = 6;
   public static int SEVEN = 7;
   public static int EIGHT = 8;
   public static int NINE = 9;
   public static int TEN = 10;
   public static int JACK = 11;
   public static int QUEEN = 12;
   public static int KING = 13;
   public static String SPADESIMAGE = "s";
   public static String CLUBSIMAGE = "c";
   public static String HEARTSIMAGE = "h";
   public static String DIAMONDSIMAGE = "d";
   public static String ACEIMAGE = "ace";
   public static String TWOIMAGE = "2";
   public static String THREEIMAGE = "3";
   public static String FOURIMAGE = "4";
   public static String FIVEIMAGE = "5";
   public static String SIXIMAGE = "6";
   public static String SEVENIMAGE = "7";
   public static String EIGHTIMAGE = "8";
   public static String NINEIMAGE = "9";
   public static String TENIMAGE = "10";
   public static String JACKIMAGE = "jack";
   public static String QUEENIMAGE = "queen";
   public static String KINGIMAGE = "king";
   private int rank;
   private int suit;
   
   /**
   
      Sets the card and suit of the card
      @param suit The number of the suit
      @param rank The number corresponding to rank
   */
   
   public Card(int suit, int rank)
   {
      this.suit = suit;
      this.rank = rank;
   
   }
   /**
   
      Returns the suit value
   
   */
   public int getSuit()
   {
     return suit; 
   }
   /**
   
      Returns the rank value
   
   */
   public int getRank()
   {
      return rank;
   }
   /**
   
      Returns a string version of the rank value
   
   */
   public String toString()
   {
     if (rank == ACE)
     {
        return "Ace";
     }
     else if (rank == TWO)
     {
        return "Two";
     }
     else if (rank == THREE)
     {
        return "Three";
     }
     else if (rank == FOUR)
     {
        return "Four";
     }
     else if (rank == FIVE)
     {
        return "Five";
     }
     else if (rank == SIX)
     {
        return "Six";
     }
     else if (rank == SEVEN)
     {
        return "Seven";
     }
     else if (rank == EIGHT)
     {
        return "Eight";
     }
     else if (rank == NINE)
     {
        return "Nine";
     }
     else if (rank == TEN)
     {
        return "Ten";
     }
     else if (rank == JACK)
     {
        return "Jack";
     }
     else if (rank == QUEEN)
     {
        return "Queen";
     }
     else if (rank == KING)
     {
        return "King";
     }
     else
     {
         return "Invalid";
     }
   }
   /**
   
      Compares the rank of two cards to see if they are equal. Returns true if equal. Otherwise, returns false.
      @param object2 The object put in by user
   
   */
   public Boolean equals(Card object2)
   {
      boolean status;
      
      if (this.rank == object2.rank)
      {
         status = true;
      }
      else
      {
         status = false;
      }
         
      return status;
   }
   /**
   
      Compares the rank of two cards to see if one is greater. Returns true if equal. Otherwise, returns false.
      @param object2 The object put in by user
   
   */
   public Boolean isHigher(Card object2)
   {
      boolean status;
      
      if (this.rank > object2.rank)
      {
         status = true;
      }
      else
      {
         status = false;
      }
         
      return status;
   }
   /**
   
      Compares the rank of two cards to see if one is less. Returns true if equal. Otherwise, returns false.
      @param object2 The object put in by user
   
   */
   public Boolean isLower(Card object2)
   {
      boolean status;
      
      if (this.rank < object2.rank)
      {
         status = true;
      }
      else
      {
         status = false;
      }
         
      return status;
   }
   /**
      The getImageRank method returns the ranl associated with a card for the card in
      the cardpics folder
      @return rank of card 
   */
   public static String getImageRank(Card object)
   {
      if (object.getRank() == 2)
      {
         return TWOIMAGE;
      }
      else if (object.getRank() == 3)
      {
         return THREEIMAGE;
      }
      else if (object.getRank() == 4)
      {
         return FOURIMAGE;
      }
      else if (object.getRank() == 5)
      {
         return FIVEIMAGE;
      }
      else if (object.getRank() == 6)
      {
         return SIXIMAGE;
      }
      else if (object.getRank() == 7)
      {
         return SEVENIMAGE;
      }
      else if (object.getRank() == 8)
      {
         return EIGHTIMAGE;
      }
      else if (object.getRank() == 9)
      {
         return NINEIMAGE;
      }
      else if (object.getRank() == 10)
      {
         return TENIMAGE;
      }
      else if (object.getRank() == 11)
      {
         return JACKIMAGE;
      }
      else if (object.getRank() == 12)
      {
         return QUEENIMAGE;
      }
      else if (object.getRank() == 12)
      {
         return KINGIMAGE;
      }
      else
      {
         return ACEIMAGE;
      }
   
   
   }
   /**
      The getImageSuit method returns the image variable associated with the suit of
      the card for the images in the cardpics folder
      @return the suit of the card
   */
   public static String getImageSuit(Card object)
   {
      if (object.getRank() == 1)
      {
         return SPADESIMAGE;
      }
      else if (object.getRank() == 2)
      {
         return CLUBSIMAGE;
      }
      else if (object.getRank() == 3)
      {
         return HEARTSIMAGE;
      }
      else
      {
         return DIAMONDSIMAGE;
      }
   
   
   }


}