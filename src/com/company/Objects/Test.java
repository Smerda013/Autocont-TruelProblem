package com.company.Objects;

import com.company.Enums.Strategy;

public class Test {

    private Strategy strategy;
    private int numberOfWins;

    public Test(Strategy strategy) {
        this.strategy = strategy;
        this.numberOfWins = 0;
        makeTheTest();
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }


    //Every test makes 10000 samples of games and it will count how many times player A will win the game
    private void makeTheTest() {
        for (int i = 0; i < 10000; i++) {
            Game game = new Game(this.strategy);
            if (game.isPlayerAWinner()){
                numberOfWins++;
            }
        }
    }
}
