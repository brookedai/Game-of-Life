import model.Game;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ConsoleStepper {
    private static Game game;
    private static boolean inputFinished;

    public static void main(String[] args) {
        inputFinished = false;
        game = new Game();
        run();
    }

    // EFFECTS: runs the game
    public static void run() {
        while (!inputFinished) {
            System.out.println(new String(new char[50]).replace("\0", "\r\n"));
            game.displayBoard();
            System.out.print("What will you do? ");
            inputFinished = game.runCommand(getInput());
        }
        while (true) {
            System.out.println(new String(new char[50]).replace("\0", "\r\n"));
            game.displayBoard();
            game.runCommand("next");
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (Exception e) {
            }
        }
    }

    // EFFECTS: returns user input as a string
    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
