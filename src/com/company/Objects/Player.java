package com.company.Objects;

import com.company.Enums.PlayerType;

import java.util.Random;

public class Player {
    private PlayerType playerType;
    private int accuracy;
    private boolean alive;


    //This is constructor for Player A, he can have random accuracy, but it can't be bigger than 97, since
    // player B and C have to have bigger accuracy but lower than 100

    public Player(PlayerType playerType) {
        this.playerType = playerType;
        Random randomNumber = new Random();
        this.accuracy = 1 + randomNumber.nextInt(97);
        this.alive = true;
    }

    //This is constructor for Player B and C, he will get accuracy of previous player as a parameter and use it
    // as minimal accuracy for creating player since he has to have bigger accuracy than previous player
    public Player(PlayerType playerType, int accuracyOfPrevious) {
        this.playerType = playerType;
        Random randomNumber = new Random();
        int minAccuracy = accuracyOfPrevious + 1;
        if (playerType.equals(PlayerType.B)){
            this.accuracy = minAccuracy + randomNumber.nextInt(99 - minAccuracy);
        } else if (playerType.equals(PlayerType.C)){
            this.accuracy = minAccuracy + randomNumber.nextInt(100 - minAccuracy);
        }
        this.alive = true;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
