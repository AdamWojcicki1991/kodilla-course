package com.kodilla.rps;

import com.kodilla.rps.engine.GameRunner;
import com.kodilla.rps.uix.SimpleUserInterface;
import com.kodilla.rps.uix.UserInterface;

public class RpsApplication {

    public static void main(String[] args) {
        UserInterface userInterface = new SimpleUserInterface();
        new GameRunner(userInterface).run();
    }
}
