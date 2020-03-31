package com.kodilla.rps.model;

public class GameDefinition {

    private String username;
    private int rounds;

    public GameDefinition(String username, int rounds) {
        this.username = username;
        this.rounds = rounds;
    }

    public String getUsername() {
        return username;
    }

    public int getRounds() {
        return rounds;
    }
}
