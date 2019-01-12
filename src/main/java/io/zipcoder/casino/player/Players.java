package io.zipcoder.casino.player;

import java.util.ArrayList;

public class Players {

    private static Players INSTANCE = null;

    ArrayList<Player> playerList = new ArrayList<>();

    public Players() {
    }

    public static Players getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Players();
        }
        return INSTANCE;
    }


    public void addPlayer(Player player) {
        playerList.add(player);
    }

    public void addPlayers(Player ... players) {
        for (Player player : players) {
            playerList.add(player);
        }
    }

    public ArrayList<Player> getPlayers() {
        return playerList;
    }

    public void removePlayer(final Player player) {
        playerList.removeIf(Player -> Player.equals(player));
    }

}
