package io.zipcoder.casino.cardgames;

import io.zipcoder.casino.utilities.Card;
import io.zipcoder.casino.utilities.abstracts.CardGame;
import io.zipcoder.casino.utilities.containers.CardHand;
import io.zipcoder.casino.utilities.containers.Deck;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.interfaces.Gamble;
import io.zipcoder.casino.player.BlackJackPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.player.Players;

import java.util.ArrayList;

public class BlackJack extends CardGame implements Gamble {

    CardHand dealerHand = new CardHand();
    boolean continueGame = true;
    private Deck deck = new Deck();
    private ArrayList<BlackJackPlayer> blackJackPlayers = new ArrayList<>();

    public BlackJack() {
        announceGameChoice();
        readyPlayers();
        placePlayerBets();
        dealCards(2);
        runGame();
    }

    public void readyPlayers() {
        for (Player player : Players.getInstance().getPlayers()) {
            blackJackPlayers.add(new BlackJackPlayer(player));
        }
    }

    @Override
    public void runGame() {
        for (int i = 0; i < blackJackPlayers.size(); i++) {
            play(blackJackPlayers.get(i), blackJackPlayers.get(i).getBet());
        }
    }

    public void play(BlackJackPlayer currentPlayer, long bet) {
        boolean dealerWins = false;

        evalBlackjack(); // all players evaluate hand for blackjack. Winners are paid out and removed.
        dealerWins = dealerCheck(); //TO ADD: if both player and dealer have blackjack, player keeps bet
        if (dealerWins == true) continueGame = false; // all players lose

        while (continueGame) {
            dealerDraw();

            Console.println("\nDealer is showing a " + dealerHand.get(0).getCard()); // dealer reveals upcard

            playersTurn();

            continueGame = evalBusts();
            if (!continueGame) break;

            continueGame = dealersTurn(); // IMPLEMENT: if dealer loses, all players should receive payout
            if (!continueGame) break;

            continueGame = evalWinner();
        }

        if (dealerWins == true) {
            dealerCollectAll();
        }

    }

    private boolean evalBusts() {
        int bustCounter = 0;
        for (int i = 0; i < blackJackPlayers.size(); i++) {
            if (blackJackPlayers.get(i).isPlayerBust()) bustCounter++;
        }
        if (blackJackPlayers.size() == bustCounter) {
            return false;
        } else return true;
    }

    public boolean dealerCheck() {
        if (getSum(dealerHand) == 21) {
            Console.println("Dealer has " + dealerHand.display());
            Console.println("Dealer has blackjack. Dealer wins.");
            return true;
        }
        return false;
    }

    public Deck getDeck() {
        //for testing
        return deck;
    }

    public void dealerCollectAll() {
        for (BlackJackPlayer p : this.blackJackPlayers) { // collects bet from all players
            evaluateBet(p.getP(), -p.getBet());
        }
    }

    public void payoutAll() {
        for (BlackJackPlayer p : this.blackJackPlayers) { // collects bet from all players
            long winnings = p.getBet() * 2;
            evaluateBet(p.getP(), winnings);
        }
    }

    public void dealerCollect(BlackJackPlayer p) {
        evaluateBet(p.getP(), -p.getBet());
    }

    public void placePlayerBets() {
        for (BlackJackPlayer p : this.blackJackPlayers) { //gets bet from each player
            Console.println(p.getName());
            placeBet(p);
        }
    }

    public void dealerDraw() {
        dealerHand.add(deck.removeFirst());
        dealerHand.add(deck.removeFirst());
    }

    public boolean evalWinner() {
        for (BlackJackPlayer currentPlayer : blackJackPlayers) {
            if (getSum(dealerHand) == getSum(currentPlayer.getHand())) {
                Console.println(String.format("Against %s's hand, dealer wins on a tie.", currentPlayer.getP().getName()));
                dealerCollect(currentPlayer);
            } else if (getSum(currentPlayer.getHand()) > 21) {
                dealerCollect(currentPlayer);
            } else if (getSum(dealerHand) <= 21 && getSum(dealerHand) > getSum(currentPlayer.getHand())) {
                Console.println(String.format("Against %s's hand, dealer wins.", currentPlayer.getP().getName()), currentPlayer.getP().getName());
                dealerCollect(currentPlayer);
            } else {
                Console.println(String.format("%s, you win!", currentPlayer.getP().getName()));
                evaluateBet(currentPlayer.getP(), currentPlayer.getBet());
            }
        }
        return false;
    }

    public boolean dealersTurn() {
        Console.println("Dealer's card are: " + dealerHand.display());
        Console.println("The sum of dealer's cards is " + getSum(dealerHand));

        while (getSum(dealerHand) < 17) {
            revealCard();
            Console.println("Dealer's sum is " + getSum(dealerHand));
        }

        if (getSum(dealerHand) > 21) {
            Console.println("\nDealer busted. You all win!");
            payoutAll();
            return false;
        }

        return true;
    }

    public void playersTurn() {
        BlackJackPlayer currentPlayer;

        for (int i = 0; i < blackJackPlayers.size(); i++) {
            currentPlayer = blackJackPlayers.get(i);

            Console.println(String.format("\n%s, you're up!", currentPlayer.getP().getName()));
            displaySumPlayerHand(currentPlayer);

            hitOrStand(currentPlayer);
        }
    }

    private boolean playerBust(BlackJackPlayer currentPlayer) {
        if (getSum(currentPlayer.getHand()) > 21) {
            Console.println("\n"+currentPlayer.getP().getName() + " busted. House wins.");
//            blackJackPlayers.remove(currentPlayer);
            return false;
        }
        return true;
    }

    private void displaySumPlayerHand(BlackJackPlayer currentPlayer) {
        Console.println(currentPlayer.getP().getName() + ", you have: " + currentPlayer.getHand().display() + "\nThis hand is worth " + getSum(currentPlayer.getHand()));
    }

    public void hitOrStand(BlackJackPlayer currentPlayer) {

        while (getSum(currentPlayer.getHand()) < 21) {
            String hitOrStand = Console.getStringInput(String.format("\n%s, do you want to Hit or Stand?\nEnter H for Hit or S for Stand", currentPlayer.getP().getName()));

            if (hitOrStand.equalsIgnoreCase("H")) {
                dealCards(currentPlayer, 1);
                Console.println( "\n%s, you have been dealt %s.", currentPlayer.getP().getName(), currentPlayer.getHand().get(currentPlayer.getHand().size() - 1).getCard());
                displaySumPlayerHand(currentPlayer);
                playerBust(currentPlayer);
            } else if (hitOrStand.equalsIgnoreCase("S")) {
                break;
            } else {
                hitOrStand = Console.getStringInput("Invalid input. Please enter H for Hit or S for Stand");
            }
        }
    }

    public void evalBlackjack() {
        BlackJackPlayer p;
        for (int i = 0; i < blackJackPlayers.size(); i++) {
            p = blackJackPlayers.get(i);
            if (getSum(p.getHand()) == 21) {
                Console.println(p.getP().getName() + ", you have " + p.getHand().display());
                Console.println(p.getP().getName() + ", you have blackjack. You win!");
//                evaluateBet(p.getP(), p.getBet());
//                blackJackPlayers.remove(i);
            }
        }
    }

    @Override
    public void dealCards(int numberOfCards) {
        Console.println("The dealer is dealing cards to the players.");
        for (BlackJackPlayer p : blackJackPlayers) { //deal 2 cards to each player
            for (int i = 0; i < numberOfCards; i++) {
                Card card = deck.removeFirst();
                p.getHand().add(card);
            }
        }
    }

    @Override
    public void dealCards(Player p, int numberOfCards) {
        BlackJackPlayer bjp = (BlackJackPlayer) p;
        for (int i = 0; i < numberOfCards; i++) {
            Card card = deck.removeFirst();
            bjp.getHand().add(card);
        }
    }

    @Override
    public void placeBet(Player player) {
        BlackJackPlayer blackJackPlayer = (BlackJackPlayer) player;
        long bet = Console.getLongInput(String.format("%s, please enter your bet.", ((BlackJackPlayer) player).getP().getName()));
        blackJackPlayer.setBet(bet);
    }

    public void evaluateBet(Player player, long payout) {
        player.setChipBalance(player.getChipBalance() + payout);
    }


    public Card drawCard() {
        Card card = deck.removeFirst();
        return card;
    }

    public int getSum(CardHand cardHand) {
        int cardSum = 0;
        boolean ace = false;

        for (int i = 0; i < cardHand.size(); i++) {
            int cardValue = cardHand.get(i).getCardValue().getCardValue();

            if (cardValue > 10) {
                cardValue = 10;   // For a Jack, Queen, or King.
            }
            if (cardValue == 1) {
                ace = true;
            }
            cardSum = cardSum + cardValue;
        }
        if (cardHand.size() == 2 && ace && cardSum + 10 <= 21) {
            cardSum = cardSum + 10;
        }
        return cardSum;
    }

    public void revealCard() {
        Card newCard = drawCard();
        Console.println("Dealer drew a " + newCard.getCardValue() + " of " + newCard.getSuit().getCardGraphic());
        dealerHand.add(newCard);
    }

    @Override
    public void promptContinue() {
    }

    ;

}
