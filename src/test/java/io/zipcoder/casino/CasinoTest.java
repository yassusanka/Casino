package io.zipcoder.casino;


import io.zipcoder.casino.utilities.Dice;
import org.junit.Test;

public class CasinoTest {


    @Test
    public void graphicTest() {
        Dice dice = new Dice();

        for (int i = 1; i <= 6; i++) {
            System.out.println(dice.getDieGraphic(i));
        }
    }


}