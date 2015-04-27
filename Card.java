//Alex Barnes, CS110, Card Class

public class Card
{
   //Inititialize variables
   
   public static int SPADES = 1;
   public static int CLUBS = 2;
   public static int HEARTS = 3;
   public static int DIAMONDS = 4;
   public static int ACE = 1;
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



}