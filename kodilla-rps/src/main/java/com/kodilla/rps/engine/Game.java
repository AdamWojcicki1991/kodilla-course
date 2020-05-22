package com.kodilla.rps.engine;

import com.kodilla.rps.model.GameDefinition;
import com.kodilla.rps.model.GameResult;
import com.kodilla.rps.model.RoundResult;
import com.kodilla.rps.model.Statistics;
import com.kodilla.rps.uix.UserInterface;

import static com.kodilla.rps.model.RoundResult.EXIT;
import static com.kodilla.rps.model.RoundResult.NEW;

public final class Game {
    private final UserInterface userInterface;
    private final Statistics statistics;
    private GameDefinition definition;

    public Game(final UserInterface userInterface) {
        this.userInterface = userInterface;
        this.statistics = new Statistics();
    }

    public GameResult start() {
        userInterface.printMenu();
        definition = getGameDefinition();
        RoundResult result = RoundResult.DRAW;
        while (shouldPlay(definition, result)) {
            result = new Round(definition, statistics, userInterface).play();
        }
        userInterface.informGame(definition, statistics);
        return (result == NEW) ? GameResult.NEXT : GameResult.END;
    }

    public String getUsername() {
        return definition.getUserName();
    }

    private boolean shouldPlay(GameDefinition definition, RoundResult result) {
        if (result == EXIT) return gameConfirm(definition, userInterface.confirmExit());
        if (result == NEW) return gameConfirm(definition, userInterface.confirmNewGame());
        return statistics.hasNextRound(definition.getRounds());
    }

    private boolean gameConfirm(GameDefinition definition, boolean confirm) {
        return (!confirm) && statistics.hasNextRound(definition.getRounds());
    }

    private GameDefinition getGameDefinition() {
        String userName = userInterface.getUserName();
        int roundCount = userInterface.getRoundCount();
        return new GameDefinition(userName, roundCount);
    }
}
