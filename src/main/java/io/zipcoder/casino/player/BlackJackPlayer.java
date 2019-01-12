package io.zipcoder.casino.player;

import io.zipcoder.casino.utilities.containers.CardHand;

public class BlackJackPlayer extends Player{
    private CardHand hand;
    Player blackJackPlayer;
    private long bet;
    boolean playerBust = false;

    public boolean isPlayerBust() {
        return playerBust;
    }

    public long getBet() {
        return bet;
    }

    public void setBet(long bet) {
        this.bet = bet;
    }

    public BlackJackPlayer() {
    }

    public BlackJackPlayer(Player player) {
        this.blackJackPlayer = player;
        this.hand = new CardHand();
    }

    public void hit(Player player) {
    }

    public Player getP() {
        return blackJackPlayer;
    }

    public CardHand getHand() {
        return hand;
    }

}
