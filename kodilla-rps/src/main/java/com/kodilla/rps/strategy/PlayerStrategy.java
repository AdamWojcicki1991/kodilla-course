package com.kodilla.rps.strategy;

import com.kodilla.rps.model.Move;
import com.kodilla.rps.uix.UserInterface;

import static com.kodilla.rps.model.Move.*;

public class PlayerStrategy implements Strategy {
    private final UserInterface userInterface;

    public PlayerStrategy(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @Override
    public Move getMove() {

        switch (userInterface.getValidCharacter()) {
            case '1':
                return ROCK;
            case '2':
                return PAPER;
            case '3':
                return SCISSORS;
            case '4':
                return SPOCK;
            case '5':
                return LIZARD;
            case 'x':
                return EXIT;
            case 'n':
                return NEW;
            default:
                return INVALID;
        }
    }
}
