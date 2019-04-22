package model;

public class Game {
    private final int BOARD_ROWS = 30;
    private final int BOARD_COLS = 30;
    private Board b;

    // EFFECTS: creates a new game
    public Game() {
        init();
    }

    // MODIFIES: this
    // EFFECTSL initializes game
    public void init() {
        b = new Board(BOARD_ROWS, BOARD_COLS);
    }

    // EFFECTS: displays board
    public void displayBoard() {
        System.out.println(b.toString());
    }

    // EFFECTS: performs an action based on user input, returns true if user starts auto stepping
    //          commands: "r c bool" - sets cell at (r,c) alive state to bool
    //                    next - steps the board
    //                    run - board starts auto stepping
    //                    quit - exits the program
    public boolean runCommand(String input) {
        if (input.contains(" ")) {
            String[] s = input.split(" ");
            b.setCell(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Boolean.parseBoolean(s[2]));
        } else if (input.equals("next")) {
            b.update();
        } else if (input.equals("run")) {
            return true;
        } else if (input.equals("quit")) {
            System.out.println("Thank you for playing!");
            System.exit(0);
        } else {
            System.out.println("That is not a valid input.");
        }
        return false;
    }


}
