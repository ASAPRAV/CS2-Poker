import java.util.*;
public class Controller
{
   private static Deck deck;
   private static Hand hand1;
   private static Hand hand2;

   public static void main(String[] args){
      deck = new Deck();
      //System.out.println(deck);
      hand1 = new Hand();
      hand2 = new Hand();

      dealHands(5);
      //System.out.println(hand1);
      //System.out.println(hand2);

      hand1.sortHand();
      hand2.sortHand();
      System.out.println(hand1);
      System.out.println(hand2);

      System.out.println("Best Hand: " + hand1.handValue());
      System.out.println("Best Hand: " + hand2.handValue());
      System.out.println(findWinner());
   }

   public static void dealHands(int x){
      //TODO: Deal x cards to each player
      for(int i = 0; i<x; i++)
      {
        hand1.add(deck.remove());
        hand2.add(deck.remove());
      }
   }

   public static String findWinner(){
      int result = hand1.compareTo(hand2);
      if(result > 0)
        return "Player 1";
      else if(result < 0)
        return "Player 2";
      else
        return "Tie";
   }
}
/*
406-imac24:CS2-Poker 1ravi$ java Controller
[5s, 7d, Jd, Jc, Qs]
[4c, 5h, 6h, 7s, Kh]
Best Hand: One Pair
Best Hand: High Card
Player 1
406-imac24:CS2-Poker 1ravi$ java Controller
[2c, 3c, 6s, 9h, Jd]
[3h, 4c, Js, Qc, Ah]
Best Hand: High Card
Best Hand: High Card
Player 2
406-imac24:CS2-Poker 1ravi$
*/
