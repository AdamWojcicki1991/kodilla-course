package pl.mps.rps.strategy;

import pl.mps.rps.model.Move;

import java.util.Random;

import static pl.mps.rps.model.Move.ROCK;

public class EnemyStrategy implements Strategy {

    private static final Random random = new Random();


    @Override
    public Move getMove() {
        // implement
        return ROCK;
    }
}
