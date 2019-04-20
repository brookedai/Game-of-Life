package model;

import java.util.Scanner;

public class Game {
    private final int BOARD_ROWS = 30;
    private final int BOARD_COLS = 30;
    private Board b;
    private static boolean gameFinished;

    // EFFECTS: creates a new game
    public Game() {
        init();
    }

    // EFFECTS: runs the game
    public void run() {
        while (!gameFinished) {
            displayBoard();
            System.out.print("What will you do? ");
            runCommand(getInput());
        }
    }

    // MODIFIES: this
    // EFFECTSL initializes game
    public void init() {
        b = new Board(BOARD_ROWS, BOARD_COLS);
        gameFinished = false;
    }

    // EFFECTS: displays board
    private void displayBoard() {
        System.out.println(b.toString());
    }

    // REQUIRES: command is not empty
    // EFFECTS: performs an action based on user input
    //          commands: "r c bool" - sets cell at (r,c) alive state to bool
    //                    next - steps the board
    //                    quit - exits the program
    private void runCommand(String input) {
        if (input.contains(" ")) {
            String[] s = input.split(" ");
            b.setCell(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Boolean.parseBoolean(s[2]));
        } else if (input.equals("next")) {
            b.update();
        } else if (input.equals("quit")) {
            System.out.println("Thank you for playing!");
            System.exit(0);
        } else {
            System.out.println("That is not a valid input.");
        }
    }

    // EFFECTS: returns user input as a string
    private String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
