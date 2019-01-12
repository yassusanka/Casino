package io.zipcoder.casino.player;

public class CrapsPlayer extends Player {
    Player crapsPlayer;
    long bet;

    public CrapsPlayer(Player player) {
        this.crapsPlayer = player;
    }

    public CrapsPlayer(Player player, long bet) {
        this.crapsPlayer = player;
        this.bet = bet;
    }

    public Player getP() {
        return crapsPlayer;
    }

    public long getBet() {
        return bet;
    }
    public void setBet(long bet) { this.bet = bet;}
}
