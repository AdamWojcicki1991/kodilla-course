package com.kodilla.rps.strategy;

import com.kodilla.rps.model.Move;

import java.util.Random;

import static com.kodilla.rps.model.Move.ROCK;

public class EnemyStrategy implements Strategy {

    private static final Random random = new Random();


    @Override
    public Move getMove() {
        // implement
        return ROCK;
    }
}
