package com.company.Objects;

import com.company.Enums.PlayerType;
import com.company.Enums.Strategy;

import java.util.Random;

public class Game {
   private Player playerA;
   private Player playerB;
   private Player playerC;
   private boolean isPlayerAWinner;
   private Strategy strategy;
   private int alivePlayers;

    public Game(Strategy strategy) {
        this.strategy = strategy;
        this.playerA = new Player(PlayerType.A);
        this.playerB = new Player(PlayerType.B, this.playerA.getAccuracy());
        this.playerC = new Player(PlayerType.C, this.playerB.getAccuracy());
        this. alivePlayers = 3;

        this.isPlayerAWinner = playTheGame();
    }

    public boolean isPlayerAWinner() {
        return isPlayerAWinner;
    }

    public void setPlayerAWinner(boolean playerAWinner) {
        isPlayerAWinner = playerAWinner;
    }

    public int getAlivePlayers() {
        return alivePlayers;
    }

    public void setAlivePlayers(int alivePlayers) {
        this.alivePlayers = alivePlayers;
    }

    public Player getPlayerA() {
        return playerA;
    }

    public void setPlayerA(Player playerA) {
        this.playerA = playerA;
    }

    public Player getPlayerB() {
        return playerB;
    }

    public void setPlayerB(Player playerB) {
        this.playerB = playerB;
    }

    public Player getPlayerC() {
        return playerC;
    }

    public void setPlayerC(Player playerC) {
        this.playerC = playerC;
    }


    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    private boolean playTheGame() {
        Random randomNumber = new Random();

        //This game is on until the last player standing, so this is the reason why I'm using while loop
        //At the beginning I'am asking which strategy my game using.

        while (this.alivePlayers != 1) {
            if (this.strategy.equals(Strategy.STRONGEST)) {
                strongestStrategy();
            } else if (this.strategy.equals(Strategy.RANDOM)) {
                randomStrategy();
            }

            //In case of skip strategy, there is no need to make player A attack since he doesn't using it,
            //so I just skipped it


            //In case that player B is still alive, he is randomly choosing his target, in case that there are only
            //one enemy left I don't need to find alive enemy because it must be player A who left.

            if (this.playerB.isAlive()){
                Player target;

                if (this.alivePlayers ==3) {
                    int randomPickPlayer = randomNumber.nextInt(2);
                    if (randomPickPlayer == 0){
                        target = this.playerA;
                    } else {
                        target = this.playerC;
                    }
                } else {
                    target = this.playerA;
                }

                if (shoot(this.playerB,target)){
                    this.alivePlayers--;
                }
            }

            //Same logic like with attack of player B

            if (this.playerC.isAlive()){
                Player target;

                if (alivePlayers ==3) {
                    int randomPickPlayer = randomNumber.nextInt(2);
                    if (randomPickPlayer == 0){
                        target = this.playerA;
                    } else {
                        target = this.playerB;
                    }
                } else {
                    target = this.playerA;
                }
                if (shoot(this.playerC,target)){
                    this.alivePlayers--;
                }
            }

            //At the end of every while loop I'm asking if playerA is still alive, if not, there is no
            // purpose to continue with game, since I'm only looking for cases when playerA wins,
            // so I just return false without finding real winner
            if (!(this.playerA.isAlive())){
                return false;
            }
        }
        //If the loop is finished is certainty, that player A is a winner, so I can return true
        return true;
    }

    //This function is for player A attack with the strongest strategy, so if there is still 3 players left,
    //player A attacking on the strongest which is everytime player C. If there is only 2 players left,
    // I'm using function for finding alive enemy in case that player C killed player B

    private void strongestStrategy() {

            Player playerATarget;
            if (this.alivePlayers == 3) {
                playerATarget = this.playerC;
            } else {
                playerATarget = findAliveEnemy();
            }

            if (shoot(this.playerA, playerATarget)) {
                this.alivePlayers--;
            }
    }

    //This function represents player A attack with randomly choose enemy. In case of just one enemy left
    //I'm using function for finding alive enemy

    private void randomStrategy() {
        Random randomNumber = new Random();

        Player playerATarget;
        if (this.alivePlayers == 3) {
            int randomPickPlayer = randomNumber.nextInt(2);
            if (randomPickPlayer == 0) {
                playerATarget = this.playerB;
            } else {
                playerATarget = this.playerC;
            }
        } else {
            playerATarget = findAliveEnemy();
        }

        if (shoot(this.playerA, playerATarget)) {
            this.alivePlayers--;
        }
    }

    // Function for counting of success of attack
    private boolean shoot(Player attacker, Player target) {
        Random randomNumber = new Random();
        int hitProbability = randomNumber.nextInt(100);
        if (hitProbability < attacker.getAccuracy()){
            target.setAlive(false);
            return true;
        }
        return false;
    }


    private Player findAliveEnemy() {
        if (this.playerB.isAlive()){
            return playerB;
        }
        return playerC;
    }
}
