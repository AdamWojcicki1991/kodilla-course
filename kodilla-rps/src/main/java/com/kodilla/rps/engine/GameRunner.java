package com.kodilla.rps.engine;

import com.kodilla.rps.model.GameResult;
import com.kodilla.rps.uix.UserInterface;

import static com.kodilla.rps.model.GameResult.NEXT;

public final class GameRunner {
    private final UserInterface userInterface;

    public GameRunner(final UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void run() {
        Game game = new Game(userInterface);
        GameResult gameResult = game.start();

        while (gameResult == NEXT) {
            gameResult = new Game(userInterface).start();
        }
        userInterface.thankYou(game.getUsername());
    }
}
