package com.kodilla.rps.model;

public enum Move {

    ROCK,
    PAPER,
    SCISSORS,
    EXIT,
    NEW,
    INVALID;

    public static Move get(int index) {
        if (index < Move.values().length) {
            return Move.values()[index];
        } else {
            throw new IllegalStateException("Invalid index for Move");
        }
    }
}
