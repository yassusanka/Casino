package io.zipcoder.casino.player;

public class Player {

    protected String name = "";
    protected long chipBalance;

    public Player() {
    }

    public Player(String name, long startingBalance) {
        this.name = name;
        this.chipBalance = startingBalance;
    }

    public Player(String name) {
        this.name = name;
        this.chipBalance = 500;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getChipBalance() {
        return chipBalance;
    }

    public void setChipBalance(long chipBalance) {
        this.chipBalance = chipBalance;
    }
}
