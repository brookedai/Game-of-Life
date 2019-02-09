package ui;

import model.Board;

import java.util.Scanner;

public class Game {
    private final int BOARD_ROWS = 100;
    private final int BOARD_COLS = 100;
    private Board b;
    private static boolean gameFinished;

    // EFFECTS: creates a new game
    public Game() {
        init();
        while (!gameFinished) {

        }
    }

    public static void main(String[] args) {
        Game g = new Game();
    }

    // MODIFIES: this
    // EFFECTSL initializes game
    public void init() {
        b = new Board(BOARD_ROWS, BOARD_COLS);
        gameFinished = false;
    }

    // EFFECTS: displays board
    private void displayBoard() {

    }

    // REQUIRES: command is not empty
    // EFFECTS: performs an action based on user input
    private void runCommand(String input) {

    }

    // EFFECTS: returns user input as a string
    private String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
