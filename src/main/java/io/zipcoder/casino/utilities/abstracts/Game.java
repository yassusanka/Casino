package io.zipcoder.casino.utilities.abstracts;

import io.zipcoder.casino.utilities.Console;

import java.sql.DriverManager;

public abstract class Game {
    String className = this.getClass().getSimpleName();

    public abstract void promptContinue();

    public abstract void runGame();

    private String getClassName() {
        return className;
    }

    protected void announceGameChoice() {
        Console console = new Console();
        console.println("\nWelcome to %s\n", this.getClassName());
    }
}
