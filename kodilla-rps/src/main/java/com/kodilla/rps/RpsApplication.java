package com.kodilla.rps;

import com.kodilla.rps.engine.GameRunner;
import com.kodilla.rps.uix.SimpleUserInterface;

public final class RpsApplication {
    public static void main(String[] args) {
        new GameRunner(new SimpleUserInterface()).run();
    }
}
