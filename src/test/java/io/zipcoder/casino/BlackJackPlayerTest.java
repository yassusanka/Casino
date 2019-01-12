package io.zipcoder.casino;

import io.zipcoder.casino.player.BlackJackPlayer;
import io.zipcoder.casino.player.Player;
import org.junit.Before;
import org.junit.Test;

public class BlackJackPlayerTest {
    Player player = new Player("Mr. Guy");

    @Before
    public void setUp() throws Exception {
        BlackJackPlayer b = new BlackJackPlayer(player);
    }

    @Test
    public void hit() {
    }

    @Test
    public void stay() {
    }

    @Test
    public void getHand() {
    }

    @Test
    public void setHand() {
    }
}