package com.kodilla.rps.engine;

import com.kodilla.rps.model.GameResult;
import com.kodilla.rps.uix.UserInterface;

import static com.kodilla.rps.model.GameResult.NEXT;

public class GameRunner {

    private final UserInterface userInterface;

    public GameRunner(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void run() {
        Game game = new Game(userInterface);
        GameResult gameResult = game.start();

        while (gameResult == NEXT) {
            game = new Game(userInterface);
            gameResult = game.start();
        }
        userInterface.thankYou(game.getUsername());
    }
}
