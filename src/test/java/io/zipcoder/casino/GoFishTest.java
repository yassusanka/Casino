package io.zipcoder.casino;

import io.zipcoder.casino.player.GoFishPlayer;
import io.zipcoder.casino.player.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class GoFishTest {

    @Test
    public void goFish() {
        //given

        //when

        //then
    }

    @Test
    public void readyPlayersTest() {
        //given
        ArrayList<GoFishPlayer> fishers = new ArrayList<>();
        GoFishPlayer fisher1 = new GoFishPlayer(new Player("Jae", 0));
        GoFishPlayer fisher2 = new GoFishPlayer(new Player("Thuy", 2));
        GoFishPlayer fisher3 = new GoFishPlayer(new Player("Ned", 0));
        int expectedOutput = 3;
        //when
        fishers.add(fisher1);
        fishers.add(fisher2);
        fishers.add(fisher3);
        //then
        int actualOutput = fishers.size();
        Assert.assertEquals(expectedOutput, actualOutput);

    }

    @Test
    public void runGame() {
        //given

        //when

        //then
    }

    @Test
    public void dealCards() {
        //given

        //when

        //then
    }

    @Test
    public void promptContinue() {
        //given

        //when

        //then
    }

    @Test
    public void playGoFish() {
        //given

        //when

        //then
    }

    @Test
    public void askForOpponent() {
        //given

        //when

        //then
    }

    @Test
    public void searchCard() {
        //given

        //when

        //then
    }

    @Test
    public void checkCards() {
        //given

        //when

        //then
    }
}
