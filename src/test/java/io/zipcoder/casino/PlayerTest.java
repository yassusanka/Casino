package io.zipcoder.casino;

import io.zipcoder.casino.player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

    Player player;

    @Before
    public void setup() {
        player = new Player("Test");
    }

    @Test
    public void getName() {
        Assert.assertTrue(player.getName().equals("Test"));
    }

    @Test
    public void setName() {
        player.setName("Bob");
        Assert.assertTrue(player.getName().equals("Bob"));
    }

    @Test
    public void getChipBalance() {
        Assert.assertTrue(player.getChipBalance() == 500);
    }

    @Test
    public void setChipBalance() {
        player.setChipBalance(666);
        Assert.assertTrue(player.getChipBalance() == 666);
    }
}