package com.company.Application;

import com.company.Enums.Strategy;
import com.company.Objects.Test;

public class Main {

    public static void main(String[] args) {
        int strongestStrategyTestResult = new Test(Strategy.STRONGEST).getNumberOfWins();
        int skipStrategyTestResult = new Test(Strategy.SKIP).getNumberOfWins();
        int randomStrategyTest = new Test(Strategy.RANDOM).getNumberOfWins();


        //This big if statement just searching for the right output

        if (skipStrategyTestResult > strongestStrategyTestResult && skipStrategyTestResult > randomStrategyTest) {
            System.out.println("Strategy with skipping turn is the best!");
        } else if (strongestStrategyTestResult > skipStrategyTestResult &&
                strongestStrategyTestResult > randomStrategyTest) {
            System.out.println("Strategy with attacking on the strongest enemy is the best!");
        } else if (randomStrategyTest > skipStrategyTestResult && randomStrategyTest > strongestStrategyTestResult){
            System.out.println("Strategy with random attacking is the best!");
        } else if (randomStrategyTest > skipStrategyTestResult) {
            System.out.println("Strategies with random attacking and attacking on the strongest enemy have same " +
                    "result!");
        } else if (randomStrategyTest > strongestStrategyTestResult){
            System.out.println("Strategies with random attacking and skipping the turn have same result!");
        } else if (strongestStrategyTestResult > randomStrategyTest) {
            System.out.println("Strategies with attacking on the strongest enemy and skipping the turn have same " +
                    "result!");
        } else {
            System.out.println("Every strategy has same result!");
        }

    }
}
