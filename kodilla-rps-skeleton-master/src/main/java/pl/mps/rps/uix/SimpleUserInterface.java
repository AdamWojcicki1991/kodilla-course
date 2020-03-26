package pl.mps.rps.uix;

import pl.mps.rps.model.GameDefinition;
import pl.mps.rps.model.Move;
import pl.mps.rps.model.RoundResult;
import pl.mps.rps.model.Statistics;

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
