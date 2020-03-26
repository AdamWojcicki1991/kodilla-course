package pl.mps.rps;

import pl.mps.rps.engine.GameRunner;
import pl.mps.rps.uix.SimpleUserInterface;
import pl.mps.rps.uix.UserInterface;

public class RpsApplication {

    public static void main(String[] args) {
        UserInterface userInterface = new SimpleUserInterface();
        new GameRunner(userInterface).run();
    }
}
