package pl.mps.rps.engine;

import pl.mps.rps.model.GameDefinition;
import pl.mps.rps.model.GameResult;
import pl.mps.rps.model.RoundResult;
import pl.mps.rps.model.Statistics;
import pl.mps.rps.uix.UserInterface;

import static pl.mps.rps.model.RoundResult.EXIT;
import static pl.mps.rps.model.RoundResult.NEW;

public class Game {

    private final UserInterface userInterface;
    private final Statistics statistics;
    private GameDefinition definition;

    public Game(UserInterface userInterface) {
        this.userInterface = userInterface;
        this.statistics = new Statistics();
    }

    public GameResult start() {
        userInterface.printMenu();
        definition = getGameDefinition();
        RoundResult result = RoundResult.DRAW;
        while (shouldPlay(definition, result)) {
            result = new Round(statistics, userInterface).play();
        }
        userInterface.informGame(definition, statistics);
        if (result == NEW) {
            return GameResult.NEXT;
        }
        return GameResult.END;
    }

    private boolean shouldPlay(GameDefinition definition, RoundResult result) {
        if (result == EXIT) {
            boolean exit = userInterface.confirmExit();
            if (exit) return false; else return statistics.hasNextRound(definition.getRounds());
        }
        if (result == NEW) {
            boolean exit = userInterface.confirmNewGame();
            if (exit) return false; else return statistics.hasNextRound(definition.getRounds());
        }
        return statistics.hasNextRound(definition.getRounds());
    }

    private GameDefinition getGameDefinition() {
        String userName = userInterface.getUserName();
        int roundCount = userInterface.getRoundCount();
        return new GameDefinition(userName, roundCount);
    }

    public String getUsername() {
        return definition.getUsername();
    }
}
