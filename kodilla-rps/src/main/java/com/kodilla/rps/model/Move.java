package com.kodilla.rps.model;

public enum Move {
    ROCK(": play ROCK"),
    PAPER(": play PAPER"),
    SCISSORS(": play SCISSORS"),
    SPOCK(": play SPOCK"),
    LIZARD(": play LIZARD"),
    EXIT(": EXIT"),
    NEW(": NEW"),
    INVALID(": INVALID");

    private String enumDescription;

    Move(String enumDescription) {
        this.enumDescription = enumDescription;
    }

    public static Move get(int index) {
        if (index < Move.values().length) {
            return Move.values()[index];
        } else {
            throw new IllegalStateException("Invalid index for Move");
        }
    }

    @Override
    public String toString() {
        return enumDescription;
    }
}
