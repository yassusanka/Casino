package io.zipcoder.casino.player;

import io.zipcoder.casino.utilities.containers.CardHand;

public class GoFishPlayer extends Player{
    private CardHand hand;
    int setCount = 0;

    public int getSetCount() {
        return setCount;
    }

    public void setSetCount(int setCount) {
        this.setCount = setCount;
    }

    Player goFishPlayer;

    public GoFishPlayer(Player player) {
        this.goFishPlayer = player;
        this.hand = new CardHand();
    }

    public GoFishPlayer() {

    }

    public Player getP() {
        return goFishPlayer;
    }

    public CardHand getHand() {
        return hand;
    }

    public void setHand(CardHand hand) {
        this.hand = hand;
    }
}
