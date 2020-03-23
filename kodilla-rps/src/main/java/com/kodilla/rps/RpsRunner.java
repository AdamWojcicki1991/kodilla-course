package com.kodilla.rps;

public class RpsRunner {
    public static void main(String[] args) {
        GameProcessor gameProcessor = new GameProcessor();
        char keyboardCharacter;
        boolean endGame = false;

        while (!endGame) {
            endGame = gameProcessor.gameInProcess();
            gameProcessor.printEndGameManyal();
            keyboardCharacter = gameProcessor.typeValidCharacter();
            switch (keyboardCharacter) {
                case 'x':
                    break;
                case 'n':
                    endGame = false;
                    break;
            }
        }
        System.out.println("Thanks for playing " + gameProcessor.getPlayerName() + " it was a great " + gameProcessor.getRound() + " GAME ROUNDS !");
    }
}
