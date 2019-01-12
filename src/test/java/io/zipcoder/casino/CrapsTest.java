package io.zipcoder.casino;

import io.zipcoder.casino.dicegames.Craps;
import io.zipcoder.casino.player.CrapsPlayer;
import io.zipcoder.casino.player.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class CrapsTest {

    @Test
    public void testPrintBalance(){
        //Given
        ArrayList<CrapsPlayer> playerz = new ArrayList<>();
        CrapsPlayer cplayer1 = new CrapsPlayer(new Player("Bob",100),5);
        CrapsPlayer cplayer2 = new CrapsPlayer(new Player("Joe",100),20);
        CrapsPlayer cplayer3 = new CrapsPlayer(new Player("Will",100),12);

        //When
        playerz.add(cplayer1);
        playerz.add(cplayer2);
        playerz.add(cplayer3);

        Craps newCraps = new Craps(playerz);
        newCraps.print();
        //When
        //Then
    }

    @Test
    public void testWin(){
        //Given
        ArrayList<CrapsPlayer> playerz = new ArrayList<>();
        Player player = new Player("Bob", 100);
        CrapsPlayer playa = new CrapsPlayer(player,5);

        //When
        playa.setChipBalance(100);
        playerz.add(playa);
        Craps craps = new Craps(playerz);

        craps.setBet(5);
        craps.evalWin(playa);
        long exp = 105;
        long act = playerz.get(0).getChipBalance();
        //Then
        Assert.assertEquals(exp,act);

    }


    @Test
    public void testLoss(){
        //Given
        ArrayList<CrapsPlayer> playerz = new ArrayList<>();
        Player player = new Player("Bob", 100);
        CrapsPlayer playa = new CrapsPlayer(player,5);

        //When
        playa.setChipBalance(100);
        playerz.add(playa);
        Craps craps = new Craps(playerz);

        craps.setBet(5);
        craps.evalLoss(playa);
        long exp = 95;
        long act = playerz.get(0).getChipBalance();
        //Then
        Assert.assertEquals(exp,act);

    }

}
