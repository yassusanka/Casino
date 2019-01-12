package io.zipcoder.casino.utilities.abstracts;

import io.zipcoder.casino.utilities.Dice;

public abstract class DiceGame extends Game {

    private Dice dice = new Dice(1);

    public int rollDie(int num) {
        Dice dice = new Dice(num);
        int sum = dice.tossAndSum();
        dice.getLastRollGraphic();
        return sum;
    }

}
