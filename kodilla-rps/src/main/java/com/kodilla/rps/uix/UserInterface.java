package com.kodilla.rps.uix;

import com.kodilla.rps.model.GameDefinition;
import com.kodilla.rps.model.Move;
import com.kodilla.rps.model.RoundResult;
import com.kodilla.rps.model.Statistics;

public interface UserInterface {

    void printMenu();

    void printShortMenu();

    String getMove();

    String getUserName();

    int getRoundCount();

    void informRound(Move playerMove, Move enemyMove, RoundResult result);

    void informGame(GameDefinition definition, Statistics statistics);

    boolean confirmExit();

    boolean confirmNewGame();

    boolean confirmOnceAgain();

    void printRound(int number);

    void thankYou(String username);
}
