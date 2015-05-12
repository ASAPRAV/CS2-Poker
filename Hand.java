import java.util.*;

public class Hand implements Comparable {
   private ArrayList<Card> hand;

   public Hand(){
      hand = new ArrayList<Card>();
   }

   public void add(Card c){
      hand.add(c);
   }

   public void sortHand(){
      Collections.sort(hand);
   }

   public String toString(){
      return hand.toString();
   }

   /*
   BEST
   Royal Flush
   Straight Flush
   Four of a Kind
   Full House
   Flush
   Straight
   Three of a Kind
   Two Pair
   One Pair
   High Card
   WORST
   */
   public String handValue() {
     if(isRoyalFlush())
      return "Royal Flush";
    else if(isStraightFlush())
      return "Straight Flush";
    else if(isFour())
      return "Four of a Kind";
    else if(isFullHouse())
      return "Full House";
    else if(isFlush())
      return "Flush";
    else if(isStraight())
      return "Straight";
    else if(isThree())
      return "Three of a Kind";
    else if(isTwo())
      return "Two Pair";
    else if(isOne())
      return "One Pair";
    else
      return String.valueOf(highCard());
   }

   private boolean isRoyalFlush()
   {
     String suit = hand.get(0).suit;
     for(int i = 0; i<hand.size(); i++)
     {
       if(suit != hand.get(i).suit || hand.get(i).value < 10)
       {
         return false;
       }
     }
     return true;
   }

   private boolean isStraightFlush()
   {
     String suit = hand.get(0).suit;
     for(int i = 0; i<hand.size(); i++)
     {
       if(suit != hand.get(i).suit || hand.get(i).value < 10)
       {
         return false;
       }
     }
     return true;
   }

   private boolean isFour()
   {
     int val1 = hand.get(0).value;
     for(int i = 0; i<hand.size(); i++)
     {

     }
   }

   private boolean isFullHouse()
   {
     int val1 = hand.get(0).value;
     int check1 = 0;
     for(int i = 0; i<hand.size(); i++)
     {
       if(hand.get(i).value == val1)
        check1++;
     }
     if(check1 != 3 || check1 != 2)
      return false;
     else
     {
       int val2;
      for(int i = 0; i<hand.size(); i++)
      {
        if(hand.get(i).value != val1)
          val2 = hand.get(i).value;
      }
      int check2 = 0;
      for(int i = 0; i<hand.size(); i++)
      {
        if(val2 == hand.get(i).value)
          check2++;
      }
      if(check2 != 3 || check2 != 2)
        return false;
    }
    return true;
   }

   private boolean isFlush()
   {return false;}

   private boolean isStraight()
   {return false;}

   private boolean isThree()
   {return false;}

   private boolean isTwo()
   {return false;}

   private boolean isOne()
   {return false;}

   private int highCard()
 {return false; /*figure out what to do about storing high value*/}

   public int compareTo(Object x){
      Hand other = (Hand)x;
      //TODO: Compare hands by ordering above; return -1, 1, or 0
      return -1;
   }
}
