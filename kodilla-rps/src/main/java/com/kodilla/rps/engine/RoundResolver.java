package com.kodilla.rps.engine;

import com.kodilla.rps.model.Move;
import com.kodilla.rps.model.RoundResult;

import static com.kodilla.rps.model.Move.*;

public class RoundResolver {
    public RoundResult resolve(Move playerMove, Move enemyMove) {
        if (playerMove == NEW) return RoundResult.NEW;
        if (playerMove == EXIT) return RoundResult.EXIT;
        if (playerMove == enemyMove) return RoundResult.DRAW;
        return ((playerMove == ROCK && (enemyMove == SCISSORS || enemyMove == LIZARD)) ||
                (playerMove == PAPER && (enemyMove == ROCK || enemyMove == SPOCK)) ||
                (playerMove == SCISSORS && (enemyMove == PAPER || enemyMove == LIZARD)) ||
                (playerMove == SPOCK && (enemyMove == ROCK || enemyMove == SCISSORS)) ||
                (playerMove == LIZARD && (enemyMove == PAPER || enemyMove == SPOCK))) ? RoundResult.WIN : RoundResult.LOSE;
    }
}
