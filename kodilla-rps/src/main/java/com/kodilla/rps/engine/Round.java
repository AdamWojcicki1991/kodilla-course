package com.kodilla.rps.engine;

import com.kodilla.rps.model.GameDefinition;
import com.kodilla.rps.model.Move;
import com.kodilla.rps.model.RoundResult;
import com.kodilla.rps.model.Statistics;
import com.kodilla.rps.strategy.EnemyStrategy;
import com.kodilla.rps.strategy.PlayerStrategy;
import com.kodilla.rps.uix.UserInterface;

import static com.kodilla.rps.model.RoundResult.EXIT;
import static com.kodilla.rps.model.RoundResult.NEW;

public class Round {

    private final int number;
    private final Statistics statistics;
    private final PlayerStrategy playerStrategy;
    private final EnemyStrategy enemyStrategy;
    private final RoundResolver roundResolver;
    private final UserInterface userInterface;
    private final GameDefinition definition;

    public Round(GameDefinition definition, Statistics statistics, UserInterface userInterface) {
        this.number = statistics.getRounds() + 1;
        this.statistics = statistics;
        this.userInterface = userInterface;
        this.definition = definition;
        this.playerStrategy = new PlayerStrategy(userInterface);
        this.enemyStrategy = new EnemyStrategy();
        this.roundResolver = new RoundResolver();
    }

    public RoundResult play() {
        Move enemyMove = enemyStrategy.getMove();
        Move playerMove = playerStrategy.getMove();
        RoundResult result = roundResolver.resolve(playerMove, enemyMove);

        if (result != NEW && result != EXIT) {
            userInterface.informRound(definition, playerMove, enemyMove, result);
            updateStatistics(result);
            userInterface.printRound(number, definition, statistics);
        }
        return result;
    }

    private void updateStatistics(RoundResult result) {
        switch (result) {
            case WIN:
                statistics.incrementWins();
                statistics.incrementRounds();
                break;
            case LOSE:
                statistics.incrementLoses();
                statistics.incrementRounds();
                break;
            case DRAW:
                statistics.incrementDraws();
                statistics.incrementRounds();
                break;
        }
    }
}
