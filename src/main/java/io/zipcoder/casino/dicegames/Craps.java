package io.zipcoder.casino.dicegames;

import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.interfaces.Gamble;
import io.zipcoder.casino.player.CrapsPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.player.Players;
import io.zipcoder.casino.utilities.abstracts.DiceGame;

import java.util.ArrayList;

public class Craps extends DiceGame implements Gamble {
    Console console = new Console();
    private ArrayList<CrapsPlayer> crapsPlayers = new ArrayList<>();
    long bet;

    public Craps() {
        announceGameChoice();
        readyPlayers();
        //promptBets();
        runGame();
    }
    //for test purposes
    public Craps(ArrayList<CrapsPlayer> playerz){
        crapsPlayers.addAll(playerz);
        //runGame();
    }

    public void setBet(long bet){
        this.bet = bet;
    }

    public void readyPlayers() {
        for (Player player : Players.getInstance().getPlayers()) {
            crapsPlayers.add(new CrapsPlayer(player));
        }
    }

    @Override
    public void runGame(){
        for(int i = 0; i < crapsPlayers.size(); i++){
            greetPlayer(crapsPlayers.get(i).getP());
            play(crapsPlayers.get(i));
        }
    }

    public void placeBet(Player player) {
        bet = console.integerInputSameLine("Enter your bet: ");
    }

    public void evaluateBet(Player player, long payout) {
        player.setChipBalance(player.getChipBalance()+payout);
    }

    public void play(CrapsPlayer currentPlayer) {
        placeBet(currentPlayer);
        int sum;
        promptEnterKey("roll dice");
        printRollSum(sum = rollDie(2));
        simulateCraps(currentPlayer, sum);
    }

    private void simulateCraps(CrapsPlayer currentPlayer, int sum) {
        if (sum == 7 || sum == 11) {
            evalWin(currentPlayer.getP());
        } else if (sum == 2 || sum == 3 || sum == 12) {
            evalLoss(currentPlayer.getP());
        } else {
            rollForPoint(currentPlayer, sum);
        }
    }

    private void rollForPoint(CrapsPlayer currentPlayer, int sum) {
        int point = sum;
        do {
            printRollAgain(point);
            sum = rollDie(2);
            evalReRoll(currentPlayer, sum , point);
        } while (sum != point && sum != 7);
    }

    public void printRollAgain(int point){
        console.println("\n=====================" +
                "\nPoint to roll for: " + point + "\n=====================");
        promptEnterKey("roll again");
    }

    public void evalReRoll(CrapsPlayer currentPlayer, int sum, int point){
        printRollSum(sum);
        if (sum == 7) {
            evalLoss(currentPlayer.getP());
        } else if (sum == point) {
            evalWin(currentPlayer.getP());
        }
    }

    private void printRollSum(int sum) {
        console.println("------------------------\n" +
                "Your roll sum equals: " + sum + " \n------------------------");
    }

    public void evalLoss(Player player){
        console.println("\n*********\nYOU LOSE!\n*********\n");
        evaluateBet(player, -bet);
    }

    public void evalWin(Player player){
        console.println("\n*******************************\n" +
                "WINNER WINNER CHICKEN DINNER!\n" +
                "*******************************\n");
        evaluateBet(player, bet);
    }

    public void greetPlayer(Player playa){
        console.println("Ok " + playa.getName() + ", you're up...\n");
    }

    public void promptEnterKey(String str){
        String input = console.getStringInput("\n>> " +
                "Press \"ENTER\" to " + str);
    }
    public void print(){
        for(int i = 0; i < crapsPlayers.size(); i++){
            System.out.println(crapsPlayers.get(i).getP().getChipBalance());
        }
    }

    @Override
    public void promptContinue(){}
}