package com.kodilla.rps.model;

public final class GameDefinition {
    private final String userName;
    private final int rounds;

    public GameDefinition(final String userName, final int rounds) {
        this.userName = userName;
        this.rounds = rounds;
    }

    public String getUserName() {
        return userName;
    }

    public int getRounds() {
        return rounds;
    }
}
