import java.util.*;

public class Hand implements Comparable {
   private ArrayList<Card> hand;
   private TreeMap <Integer, Integer> tm;
   private int handVal;

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
     tm = new TreeMap <Integer, Integer> ();
     for(int i = 2; i<=14; i++)
     {
       tm.put(i, 0);
     }
     for(int i = 0; i<hand.size(); i++)
     {
       tm.put(hand.get(i).value, tm.get(hand.get(i).value)+1);
     }
     if(isRoyalFlush())
     {
      handVal = 100;
      return "Royal Flush";
     }
    else if(isStraightFlush())
    {
      handVal = 99;
      return "Straight Flush";
    }
    else if(isFour())
    {
      handVal = 98;
      return "Four of a Kind";
    }
    else if(isFullHouse())
    {
      handVal = 97;
      return "Full House";
    }
    else if(isFlush())
    {
      handVal = 96;
      return "Flush";
    }
    else if(isStraight())
    {
      handVal = 95;
      return "Straight";
    }
    else if(isThree())
    {
      handVal = 94;
      return "Three of a Kind";
    }
    else if(isTwo())
    {
      handVal = 93;
      return "Two Pair";
    }
    else if(isOne())
    {
      handVal = 92;
      return "One Pair";
    }
    else
    {
        handVal = highValue();
        String s = String.valueOf(handVal);
        if(s == "14")
          s = "A";
        return "High Card: " + s;
    }
   }

   private boolean isRoyalFlush()
   {
     int check1 = 0;
     int check2 = 0;
     int check3 = 0;
     int check4 = 0;
     int check5 = 0;
     String suit = hand.get(0).suit;
     for(int i = 0; i<hand.size(); i++)
     {
       if(suit != hand.get(i).suit)
       {
         return false;
       }
       if(hand.get(i).value == 10)
       {
        check1++;
       }
       if(hand.get(i).value == 11)
       {
        check2++;
       }
       if(hand.get(i).value == 12)
       {
        check3++;
       }
       if(hand.get(i).value == 13)
       {
        check4++;
       }
       if(hand.get(i).value == 14)
       {
        check5++;
       }
     }
     if(check1 == 1 && check2 == 1 && check3 == 1 && check4 == 1 && check5 ==1)
      return true;
     return false;
   }

   private boolean isStraightFlush()
   {
     String suit = hand.get(0).suit;
     for(int i = 0; i<hand.size(); i++)
     {
       if(suit != hand.get(i).suit)
       {
         return false;
       }
       if(!isStraight())
        return false;
     }
     return true;
   }

   private boolean isFour()
   {
     for(int i = 2; i<=14; i++)
     {
       if(tm.get(i) == 4)
        return true;
     }
     return false;
   }

   private boolean isFullHouse()
   {
     int check1 = 0;
     int check2 = 0;
     for(int i = 2; i<=14; i++)
     {
       if(tm.get(i) == 3)
        check1++;
       if(tm.get(i) == 2)
        check2++;
     }
     if(check1==1 && check2==1)
      return true;
    return false;
   }

   private boolean isFlush()
   {
     String suit = hand.get(0).suit;
     for(int i = 0; i<hand.size(); i++)
     {
       if(hand.get(i).suit != suit)
        return false;
     }
     return true;
   }

   private boolean isStraight()
   {
     Collections.sort(hand);
     for(int i = 0; i<hand.size(); i++)
     {
       if(hand.get(i).value+1 != hand.get(i).value)
        return false;
     }
     return true;
   }

   private boolean isThree()
   {
     for(int i = 2; i<=14; i++)
     {
       if(tm.get(i) == 3)
        return true;
     }
     return false;
   }

   private boolean isTwo()
   {
     int check = 0;
     for(int i = 2; i<=14; i++)
     {
       if(tm.get(i) == 2)
        check++;
     }
     if(check == 2)
      return true;
     return false;
   }

   private boolean isOne()
   {
     int check = 0;
     for(int i = 2; i<=14; i++)
     {
       if(tm.get(i) == 2)
        check++;
     }
     if(check == 1)
      return true;
     return false;
   }

   private int highValue()
   {
     for(int i = 14; i>=2; i--)
     {
       if(tm.get(i) >= 1)
       {
         return i;
       }
     }
     return 2;
   }

   public int compareTo(Object x){
      Hand other = (Hand)x;
      //TODO: Compare hands by ordering above; return -1, 1, or 0
      if(handVal < other.handVal)
        return -1;
      else if(handVal > other.handVal)
        return 1;
      else
      {
        if(highValue() > other.highValue())
          return 1;
        else if(highValue() < other.highValue())
          return -1;
        else
          return 0;
      }
   }
}
