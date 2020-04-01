package com.kodilla.rps.uix;

import com.kodilla.rps.model.GameDefinition;
import com.kodilla.rps.model.Move;
import com.kodilla.rps.model.RoundResult;
import com.kodilla.rps.model.Statistics;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.kodilla.rps.model.Winner.ENEMY;
import static com.kodilla.rps.model.Winner.PLAYER;

public class SimpleUserInterface implements UserInterface {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void printMenu() {
        System.out.println("############################################################### GAME MENU ###############################################################");
        System.out.println("Key 1 - play \"Stone\"");
        System.out.println("Key 2 - play \"Paper\"");
        System.out.println("Key 3 - play \"Scissors\"");
        System.out.println("Key 4 - play \"Spock\"");
        System.out.println("Key 5 - play \"Lizard\"");
        System.out.println("Key x - End of the game, preceded by the question \"Are you sure You want to EXIT GAME?\"");
        System.out.println("Key n - Starting the game again, preceded by the question \"Are you sure You want to END current GAME and START NEW GAME?\"");
        System.out.println("#########################################################################################################################################\n");
    }

    @Override
    public void printShortMenu() {
        System.out.println("\n############################################################ SHORT GAME MENU ############################################################");
        System.out.println("Key y - EXIT GAME OR START NEW GAME");
        System.out.println("Key n - RETURN TO PREVIUS GAME");
        System.out.println("#########################################################################################################################################\n");
    }

    @Override
    public void informRound(GameDefinition definition, Move playerMove, Move enemyMove, RoundResult result) {
        System.out.println("\n############################################################## START ROUND ##############################################################\n");
        System.out.println(definition.getUsername() + playerMove.toString());
        System.out.println("Computer" + enemyMove.toString());
        System.out.println("ROUND RESULT: " + definition.getUsername() + " " + result);
    }

    @Override
    public void informGame(GameDefinition definition, Statistics statistics) {
        System.out.println("############################################################### END GAME ################################################################\n");
        System.out.println(definition.getUsername() + " WINS " + statistics.getWins() + " ROUNDS" + " | " + "Computer WINS " + statistics.getLoses() + " ROUNDS");
        System.out.println("PLAYERS HAVE " + statistics.getDraws() + " DRAWS");
        System.out.println("GAME TAKES " + statistics.getRounds() + " ROUNDS\n");
        if (statistics.whoWins() == PLAYER) {
            System.out.println(definition.getUsername() + " wins gratulations !!!");
        } else if (statistics.whoWins() == ENEMY) {
            System.out.println("Computer wins gratulations !!!");
        } else {
            System.out.println(definition.getUsername() + " and Computer have a draw !!!");
        }
        System.out.println("\n#########################################################################################################################################\n");
    }

    @Override
    public void printRound(int number, GameDefinition definition, Statistics statistics) {
        System.out.println("ROUND: " + number);
        System.out.println(definition.getUsername() + " WINS " + statistics.getWins() + " ROUNDS" + " | " + "Computer WINS " + statistics.getLoses() + " ROUNDS");
        System.out.println("PLAYERS HAVE: " + statistics.getDraws() + " DRAWS");
        System.out.println("WE PLAY TO " + definition.getRounds() + " WINS !\n");
        System.out.println("############################################################### END ROUND ###############################################################\n");
    }

    @Override
    public void printValidCharacters() {
        System.out.println("Type a valid character '1' - ROCK, '2' - PAPER, '3' - SCISSORS, '4' - SPOCK, '5' - LIZARD or 'x' - EXIT, 'n' - NEW GAME and press ENTER: ");
    }

    @Override
    public void printErrorMessage() {
        System.err.println("You put invalid symbol. Please try again !");
    }

    @Override
    public void printConfirmation(String confirmationType) {
        if (confirmationType.equals("EXIT")) {
            System.out.println("Are you sure You want to EXIT GAME? - type 'y' to confirm or 'n' to return to GAME\n");
        } else if (confirmationType.equals("NEW GAME")) {
            System.out.println("Are you sure You want to END current GAME and start NEW GAME ? - type 'y' to confirm or 'n' to return to GAME\n");
        }
    }

    @Override
    public void thankYou(String playerName) {
        System.out.println("Thanks for playing " + playerName + " it was a great experiance !");
    }

    @Override
    public String getUserName() {
        System.out.println("Type player name and press ENTER: ");
        return scanner.next();
    }

    @Override
    public char getValidCharacter() {
        boolean errorConfirmed = false;
        char keyboardCharacter = ' ';
        while (!errorConfirmed) {
            printValidCharacters();
            keyboardCharacter = scanner.next().charAt(0);
            if (isValidCharacter(keyboardCharacter)) {
                errorConfirmed = true;
            } else {
                printErrorMessage();
            }
        }
        return keyboardCharacter;
    }

    private boolean isValidCharacter(char keyboardCharacter) {
        return keyboardCharacter == '1' || keyboardCharacter == '2' || keyboardCharacter == '3' || keyboardCharacter == '4' || keyboardCharacter == '5' || keyboardCharacter == 'x' || keyboardCharacter == 'n';
    }

    @Override
    public int getRoundCount() {
        int result = 0;
        boolean errorConfirmed = false;
        while (!errorConfirmed) {
            try {
                System.out.println("Type a number of wins and press ENTER: ");
                result = scanner.nextInt();
                scanner.nextLine();
                errorConfirmed = true;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                printErrorMessage();
            }
        }
        return result;
    }

    @Override
    public boolean confirmExit() {
        boolean errorConfirmed = false;
        char keyboardCharacter = ' ';
        while (!errorConfirmed) {
            printShortMenu();
            printConfirmation("EXIT");
            keyboardCharacter = scanner.next().charAt(0);
            if (keyboardCharacter == 'y' || keyboardCharacter == 'n') {
                errorConfirmed = true;
            } else {
                printErrorMessage();
            }
        }
        return keyboardCharacter == 'y';
    }

    @Override
    public boolean confirmNewGame() {
        boolean errorConfirmed = false;
        char keyboardCharacter = ' ';
        while (!errorConfirmed) {
            printShortMenu();
            printConfirmation("NEW GAME");
            keyboardCharacter = scanner.next().charAt(0);
            if (keyboardCharacter == 'y' || keyboardCharacter == 'n') {
                errorConfirmed = true;
            } else {
                printErrorMessage();
            }
        }
        return keyboardCharacter == 'y';
    }
}
