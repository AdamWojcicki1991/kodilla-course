package com.kodilla.rps.uix;

import com.kodilla.rps.model.GameDefinition;
import com.kodilla.rps.model.Move;
import com.kodilla.rps.model.RoundResult;
import com.kodilla.rps.model.Statistics;

public interface UserInterface {

    void printMenu();

    void printShortMenu();

    String getUserName();

    char getValidCharacter();

    int getRoundCount();

    void informRound(GameDefinition definition, Move playerMove, Move enemyMove, RoundResult result);

    void informGame(GameDefinition definition, Statistics statistics);

    boolean confirmExit();

    boolean confirmNewGame();

    void printRound(int number, GameDefinition definition, Statistics statistics);

    void thankYou(String username);
}
