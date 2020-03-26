package pl.mps.rps.uix;

import pl.mps.rps.model.GameDefinition;
import pl.mps.rps.model.Move;
import pl.mps.rps.model.RoundResult;
import pl.mps.rps.model.Statistics;

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
