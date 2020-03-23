package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class GameProcessor {
    Scanner scanner = new Scanner(System.in);
    Random RANDOM = new Random();
    private boolean openManual = false;
    private String playerName;
    private int round;
    private int computerChoice;
    private int computerScore;
    private int playerScore;
    private int drawsCount;
    private int numberOfWins;
    private char keyboardCharacter;

    public void printEndGameManyal() {
        System.out.println("###################################################### END GAME MANUAL ######################################################");
        System.out.println("Key x - EXIT GAME");
        System.out.println("Key n - RESET GAME");
        System.out.println("#############################################################################################################################\n");
    }

    public void printGameManual() {
        System.out.println("######################################################## GAME MANUAL ########################################################");
        System.out.println("Key 1 - play \"Stone\"");
        System.out.println("Key 2 - play \"Paper\"");
        System.out.println("Key 3 - play \"Scissors\"");
        System.out.println("Key 4 - play \"Spock\"");
        System.out.println("Key 5 - play \"Lizard\"");
        System.out.println("Key x - End of the game, preceded by the question \"Are you sure You want to EXIT GAME?\"");
        System.out.println("Key n - Starting the game again, preceded by the question \"Are you sure You want to END current GAME and START NEW GAME?\"");
        System.out.println("#############################################################################################################################\n");
    }

    public void printStartMovementDialog() {
        System.out.println("######################################################## START ROUND ########################################################");
        System.out.println("\nPlease ENTER a valid character to make your move in ROUND " + round + "\n");
    }

    public void printPlayersScore() {
        System.out.println(playerName + " WINS " + playerScore + " ROUNDS" + " | " + "Computer WINS " + computerScore + " ROUNDS");
        System.out.println("WE PLAY TO " + numberOfWins + " WINS !\n");
        System.out.println("######################################################### END ROUND #########################################################\n");
    }

    public void printGameWinner() {
        if (numberOfWins == computerScore) {
            System.out.println("######################################################### END GAME ##########################################################\n");
            System.out.println(playerName + " WINS " + playerScore + " ROUNDS" + " | " + "Computer WINS " + computerScore + " ROUNDS");
            System.out.println("PLAYERS HAVE " + drawsCount + " DRAWS");
            System.out.println("GAME TAKES " + round + " ROUNDS\n");
            System.out.println("Computer Wins Gratulations !!!");
            System.out.println("\n#############################################################################################################################\n");
        } else if (numberOfWins == playerScore) {
            System.out.println("######################################################### END GAME ##########################################################\n");
            System.out.println(playerName + " WINS " + playerScore + " ROUNDS" + " | " + "Computer WINS " + computerScore + " ROUNDS");
            System.out.println("PLAYERS HAVE " + drawsCount + " DRAWS");
            System.out.println("GAME TAKES " + round + " ROUNDS\n");
            System.out.println(playerName + " Wins Gratulations !!!");
            System.out.println("\n#############################################################################################################################\n");
        }
    }

    public void printGameMove(int playerChoice, String player) {
        switch (playerChoice) {
            case 1:
                System.out.println(player + ": play Stone");
                break;
            case 2:
                System.out.println(player + ": play Paper");
                break;
            case 3:
                System.out.println(player + ": play Scissors");
                break;
            case 4:
                System.out.println(player + ": play Spock");
                break;
            case 5:
                System.out.println(player + ": play Lizard");
                break;
        }
    }

    public void typePlayerName() {
        System.out.println("\nType Players Name and press ENTER:");
        playerName = scanner.next();
        scanner.nextLine();
        System.out.println("Hello " + playerName + ". Welcome in [Rock, Paper, Scissors, Spock, Lizard] GAME !!!" + "\n");
    }

    public void typeNumberOfWins() {
        boolean errorConfirmed = false;
        while (!errorConfirmed) {
            try {
                System.out.println("Type a Number of Wins and press ENTER: ");
                numberOfWins = scanner.nextInt();
                scanner.nextLine();
                errorConfirmed = true;
            } catch (Exception e) {
                errorConfirmed = false;
                scanner.nextLine();
                System.err.println("You Put Invalid Character - Please Type a Number and press ENTER");
            }
        }
        System.out.println("You will play up to " + numberOfWins + " Wins\n");
    }

    public char typeValidCharacter() {
        boolean errorConfirmed = false;
        char character = ' ';
        while (!errorConfirmed) {
            System.out.println("Type a Valid Character 'x' to EXIT GAME or 'n' to RESET GAME and press ENTER: ");
            keyboardCharacter = scanner.next().charAt(0);
            scanner.nextLine();
            if (keyboardCharacter == 'x') {
                errorConfirmed = true;
                character = 'x';
            } else if (keyboardCharacter == 'n') {
                errorConfirmed = true;
                character = 'n';
            } else {
                errorConfirmed = false;
                System.err.println("You Put Invalid Character - Please Type a 'x' to EXIT GAME or Typa 'n' to RESTART GAME and press ENTER");
            }
        }
        return character;
    }

    public void roundWinner(int playerChoice, int computerChoice) {
        if (playerChoice == computerChoice) {
            System.out.println("In ROUND " + round + " we have a Draw ! In this case GAME does't add points to players !");
            drawsCount++;
        } else if ((playerChoice == 1 && (computerChoice == 3 || computerChoice == 5)) || (playerChoice == 2 && (computerChoice == 1 || computerChoice == 4)) || (playerChoice == 3 && (computerChoice == 2 || computerChoice == 5)) || (playerChoice == 4 && (computerChoice == 1 || computerChoice == 3)) || (playerChoice == 5 && (computerChoice == 2 || computerChoice == 4))) {
            playerScore++;
            System.out.println("In ROUND " + round + " " + playerName + " Wins !");
        } else {
            computerScore++;
            System.out.println("In ROUND " + round + " Computer Wins !");
        }
    }

    public boolean gameOver() {
        return (numberOfWins == computerScore || numberOfWins == playerScore);
    }

    public void resetStatistics() {
        round = 0;
        computerScore = 0;
        playerScore = 0;
    }

    public void invalidCharacter() {
        while (!openManual) {
            try {
                System.err.println("You Put Invalid Character - to check Game Manual and continue type \"true\" and press ENTER");
                openManual = scanner.nextBoolean();
                scanner.nextLine();
            } catch (Exception e) {
                scanner.nextLine();
            }
        }
    }

    public boolean gameInProcess() {

        resetStatistics();
        typePlayerName();
        typeNumberOfWins();
        printGameManual();

        while (!gameOver()) {
            round++;
            if (openManual) {
                printGameManual();
                openManual = false;
            }
            printStartMovementDialog();
            keyboardCharacter = scanner.next().charAt(0);
            scanner.nextLine();
            switch (keyboardCharacter) {
                case '1':
                    printGameMove(1, playerName);
                    computerChoice = RANDOM.nextInt(5) + 1;
                    printGameMove(computerChoice, "Computer");
                    roundWinner(1, computerChoice);
                    printPlayersScore();
                    break;
                case '2':
                    printGameMove(2, playerName);
                    computerChoice = RANDOM.nextInt(5) + 1;
                    printGameMove(computerChoice, "Computer");
                    roundWinner(2, computerChoice);
                    printPlayersScore();
                    break;
                case '3':
                    printGameMove(3, playerName);
                    computerChoice = RANDOM.nextInt(5) + 1;
                    printGameMove(computerChoice, "Computer");
                    roundWinner(3, computerChoice);
                    printPlayersScore();
                    break;
                case '4':
                    printGameMove(4, playerName);
                    computerChoice = RANDOM.nextInt(5) + 1;
                    printGameMove(computerChoice, "Computer");
                    roundWinner(4, computerChoice);
                    printPlayersScore();
                    break;
                case '5':
                    printGameMove(5, playerName);
                    computerChoice = RANDOM.nextInt(5) + 1;
                    printGameMove(computerChoice, "Computer");
                    roundWinner(5, computerChoice);
                    printPlayersScore();
                    break;
                case 'x':
                    System.out.println(playerName + " Are you sure You want to EXIT GAME?\n");
                    return true;
                case 'n':
                    System.out.println(playerName + " Are you sure You want to END current GAME and start NEW GAME?\n");
                    return true;
                default:
                    round--;
                    invalidCharacter();
            }
        }
        printGameWinner();
        return true;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getRound() {
        return round;
    }
}
