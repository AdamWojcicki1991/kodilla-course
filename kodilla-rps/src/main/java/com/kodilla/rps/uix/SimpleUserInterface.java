package com.kodilla.rps.uix;

import com.kodilla.rps.model.GameDefinition;
import com.kodilla.rps.model.Move;
import com.kodilla.rps.model.RoundResult;
import com.kodilla.rps.model.Statistics;

public class SimpleUserInterface implements UserInterface {
    @Override
    public void printMenu() {

    }

    @Override
    public void printShortMenu() {

    }

    @Override
    public String getMove() {
        return null;
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public int getRoundCount() {
        return 0;
    }

    @Override
    public void informRound(Move playerMove, Move enemyMove, RoundResult result) {

    }

    @Override
    public void informGame(GameDefinition definition, Statistics statistics) {

    }

    @Override
    public boolean confirmExit() {
        return false;
    }

    @Override
    public boolean confirmNewGame() {
        return false;
    }

    @Override
    public boolean confirmOnceAgain() {
        return false;
    }

    @Override
    public void printRound(int number) {

    }

    @Override
    public void thankYou(String username) {

    }

    // implement
}
