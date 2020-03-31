package com.kodilla.rps.strategy;

import com.kodilla.rps.model.Move;
import com.kodilla.rps.uix.UserInterface;

import static com.kodilla.rps.model.Move.ROCK;

public class PlayerStrategy implements Strategy {

    private final UserInterface userInterface;

    public PlayerStrategy(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @Override
    public Move getMove() {
        // implement
        return ROCK;
    }
}
