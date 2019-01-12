package io.zipcoder.casino;

import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.player.Players;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayersTest {

    Player player1 = new Player("Bobbert");
    Player player2 = new Player("Nedmond");
    Player player3 = new Player("Beauseph");


    @Test
    public void addPlayer() {
        Players.getInstance().addPlayers(player1,player2);
        Players.getInstance().addPlayer(player3);
        Assert.assertTrue(Players.getInstance().getPlayers().size() == 3);
    }

    @Test
    public void removePlayer() {
        Players.getInstance().addPlayers(player1,player2,player3);
        Players.getInstance().removePlayer(player3);
        Assert.assertTrue(Players.getInstance().getPlayers().size() == 2);
    }
}