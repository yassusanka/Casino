package io.zipcoder.casino;

import io.zipcoder.casino.cardgames.BlackJack;
import io.zipcoder.casino.player.BlackJackPlayer;
import io.zipcoder.casino.utilities.Card;
import io.zipcoder.casino.utilities.containers.CardHand;
import io.zipcoder.casino.utilities.containers.Deck;
import io.zipcoder.casino.utilities.enums.CardValue;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static io.zipcoder.casino.utilities.enums.CardSuit.HEARTS;

public class BlackJackTest {
  Deck deck = new Deck();
  BlackJack blackJack = new BlackJack();
  ArrayList<BlackJackPlayer> blackJackPlayers = new ArrayList<>();
  CardHand dealerHand = new CardHand();
  CardHand playerHand = new CardHand();
  BlackJackPlayer player = new BlackJackPlayer();
  Card card10 = new Card(CardValue.TEN,HEARTS);
  Card card7 = new Card(CardValue.SEVEN,HEARTS);
  Card cardAce = new Card(CardValue.ACE,HEARTS);


    @Test
    public void testPayoutAll(){
        player.setBet(100);
        blackJack.payoutAll();
        long expected = 100;
        long actual = player.getBet();
        Assert.assertEquals(expected, actual);
    }

//    @Test
//    public void testDealerDraw(){
//    blackJack.dealerDraw();
//    int expected = 2;
//    int actual = dealerHand.size();
//    Assert.assertEquals(expected,actual);
//    }

//    @Test
//    public void testDealCards(){
//        blackJack.dealCards(2);
//        int expected = 50;
//        int actual = blackJack.getDeck().size();
//        Assert.assertNotNull();
//    }


    @Test
    public void testDrawCard(){
        blackJack.drawCard();

      int expected = 51;
      int actual = blackJack.getDeck().size();
      Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRevealCard(){
        dealerHand.add(card10);
        blackJack.revealCard();
        int expected = 1;
        int actual = dealerHand.size();

    Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetSum(){

        playerHand.add(card7);
        playerHand.add(card10);

        int expected = 17;
        int actual = blackJack.getSum(playerHand);

        Assert.assertEquals(expected, actual);

    }
}
