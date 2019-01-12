package io.zipcoder.casino.cardgames;

import io.zipcoder.casino.player.GoFishPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.player.Players;
import io.zipcoder.casino.utilities.Card;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.abstracts.CardGame;
import io.zipcoder.casino.utilities.containers.Deck;

import java.util.ArrayList;

public class GoFish extends CardGame {
    private static Deck drawPile = new Deck();
    private ArrayList<GoFishPlayer> goFishPlayers = new ArrayList<>();
//    private int numberOfCards;

    public void readyPlayers() {
        for (Player player : Players.getInstance().getPlayers()) {
            goFishPlayers.add(new GoFishPlayer(player));
        }
    }

    @Override
    public void runGame() {                                 // run the game as long as the drawPile is more than 0 cards
        while (drawPile.size() >= 0) {
            for (int j = 0; j < goFishPlayers.size(); j++) {
                playGoFish();
            }
        }
    }

    public int getStartingCards() {                 //generate numberOfCards param for below based on number of players
        int numberOfCards;
        if (goFishPlayers.size() <= 3) {            //RULES: For 3 players or less, deal each player 7 cards;
            numberOfCards = 7;
        } else {                                    //RULES contd: if more than three players, deal 5 cards each.
            numberOfCards = 5;
        }
        return numberOfCards;
    }

    @Override
    public void dealCards(Player player, int numberOfCards) {
//        numberOfCards = getStartingCards();
//        GoFishPlayer fishie = (GoFishPlayer) player;                    // depending on how many players
//        for (int i = 0; i < numberOfCards; i++) {
//            Card card = drawPile.removeFirst();
//            fishie.getHand().add(card);
//        }
    }

    @Override
    public void dealCards(int numberOfCards) {
        numberOfCards = getStartingCards();
        for (GoFishPlayer p : goFishPlayers) {
            for (int i = 0; i < numberOfCards; i++) {
                Card card = drawPile.removeFirst();
                p.getHand().add(card);
            }
        }
    }

    public GoFish() {
        readyPlayers();
        dealCards(getStartingCards());
        runGame();
    }

    @Override
    public void promptContinue() {
    }                                     //WHAT??


    public void playGoFish() {
            askForOpponent();
            searchCard();
            checkCards();
            checkSets();
    }

    public String askForOpponent() {
        String opponent = Console.getStringInput("Which player would you like to question?");
        return opponent;
    }

    public Integer searchCard() {
        Integer wantedCard = Console.getIntegerInput("Which card would you like to request?");
        return wantedCard;
    }

    public void checkCards() {
        String opponent = askForOpponent();
        GoFishPlayer fishie = new GoFishPlayer();
        for (int i = 0; i < goFishPlayers.size(); i++) {
            if (opponent.equals(goFishPlayers.get(i).getName())) {
                Console.println(fishie.getName() + " has " + fishie.getHand().display());  //hopefully this prints out
                for (int j = 0; j < goFishPlayers.get(i).getHand().size(); j++) {
                    while (searchCard().equals(goFishPlayers.get(i).getHand().get(j).getCardValue())) {
                        Console.println("Nice job!");
                        fishie.getHand().add(goFishPlayers.get(i).getHand().get(j));
                        goFishPlayers.get(i).getHand().remove(j);
                        askForOpponent();                                   //need this?
                        searchCard();                                       //need this?
                    }
                    fish();
                }
            }
        }
    }


    public void fish() {
        GoFishPlayer player = new GoFishPlayer();
        player.getHand().add(drawPile.removeFirst());
        Console.println("Lame. Go Fish loser \"\\uD83D\\uDC1F\"");
    }


    public void checkSets() {                                               // help. lost. trying to set aside the sets
//        GoFishPlayer player = new GoFishPlayer();
        for (int i = 0; i < goFishPlayers.size(); i++) {
            GoFishPlayer currentPlayer = goFishPlayers.get(i);
            for (int j = 0; j < currentPlayer.getHand().size(); j++) {
                int set = 0;
                for (int k = 1; k < currentPlayer.getHand().size(); k++) {
                    if (currentPlayer.getHand().get(j).getCardValue() == currentPlayer.getHand().get(k).getCardValue()) {
                        set++;
                    }
                }
                if (set>=4) {
                    int setCount = currentPlayer.getSetCount();
                    int newSetCount = setCount += 1;
                    currentPlayer.setSetCount(newSetCount);
                }
//                    setCount.put();
//                }
//                goFishPlayers.get(i).getHand();
//                if (setCount.containsKey(goFishPlayers.get(i).getHand().get().getCardValue())))
            }
            {

            }
        }


    }
}