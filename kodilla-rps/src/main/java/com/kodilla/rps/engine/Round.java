package com.kodilla.rps.engine;

import com.kodilla.rps.model.RoundResult;
import com.kodilla.rps.model.Statistics;
import com.kodilla.rps.strategy.EnemyStrategy;
import com.kodilla.rps.strategy.PlayerStrategy;
import com.kodilla.rps.uix.UserInterface;

import static com.kodilla.rps.model.RoundResult.WIN;

public class Round {

    private final int number;
    private final Statistics statistics;
    private final PlayerStrategy playerStrategy;
    private final EnemyStrategy enemyStrategy;
    private final RoundResolver roundResolver;
    private final UserInterface userInterface;

    public Round(Statistics statistics, UserInterface userInterface) {
        this.number = statistics.getRounds() + 1;
        this.statistics = statistics;
        this.userInterface = userInterface;
        this.playerStrategy = new PlayerStrategy(userInterface);
        this.enemyStrategy = new EnemyStrategy();
        this.roundResolver = new RoundResolver();
    }

    public RoundResult play() {
        // implement
        return WIN;
    }

    private void updateStatistics(RoundResult result) {
        // implement
    }

}
