package model;

import model.exceptions.CellNotWithinBoundsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBoard {
    private Board b;

    @BeforeEach
    public void runBefore() {
        b = new Board();
    }

    @Test
    void testConstructor() {
        Board b1 = new Board();
        assertEquals(Board.DEFAULT_NUM, b1.getRows());
        assertEquals(Board.DEFAULT_NUM, b1.getCols());

        Board b2 = new Board(100, 70);
        assertEquals(100, b2.getRows());
        assertEquals(70, b2.getCols());
    }

    @Test
    void testSetCellNoException() {
        int rows = b.getRows()/2;
        int cols = b.getCols()/2;
        b.setCell(rows, cols, true);
        assertTrue(b.getCell(rows, cols).isAlive());

        b.setCell(rows, cols, false);
        assertFalse(b.getCell(rows, cols).isAlive());
    }

    @Test
    void testSetCellExceptionExpected() {
        int rows = b.getRows();
        int cols = b.getCols();
        try {
            b.setCell(rows, cols/2, true);
            fail("CellNotWithinBoundsException expected");
        } catch (CellNotWithinBoundsException e) {
            // expected
        }

        try {
            b.setCell(rows/2, cols, true);
            fail("CellNotWithinBoundsException expected");
        } catch (CellNotWithinBoundsException e) {
            // expected
        }
    }

    @Test
    void testToString() {
        String toString = "";
        for (int i = 0; i < Board.DEFAULT_NUM; i++) {
            for (int j = 0; j < Board.DEFAULT_NUM; j++) {
                toString += "X ";
            }
            toString += "\n";
        }
        assertEquals(toString, b.toString());
    }

    @Test
    void testUpdateBoard() {
        Board board = new Board(10, 10);

        // upper left corner
        board.setCell(0, 0, true);

        // lower box
        board.setCell(7, 5, true);
        board.setCell(7, 6, true);
        board.setCell(8, 5, true);
        board.setCell(8, 6, true);

        // upper right glider
        board.setCell(1, 8, true);
        board.setCell(2, 8, true);
        board.setCell(3, 8, true);
        board.setCell(3, 7, true);
        board.setCell(2, 6, true);

        // left blinker
        board.setCell(5, 1, true);
        board.setCell(6, 1, true);
        board.setCell(7, 1, true);

        // lower left corner
        board.setCell(9, 0, true);

        // lower right corner
        board.setCell(9, 9, true);


        String current =
                        "O X X X X X X X X X \n" +
                        "X X X X X X X X O X \n" +
                        "X X X X X X O X O X \n" +
                        "X X X X X X X O O X \n" +
                        "X X X X X X X X X X \n" +
                        "X O X X X X X X X X \n" +
                        "X O X X X X X X X X \n" +
                        "X O X X X O O X X X \n" +
                        "X X X X X O O X X X \n" +
                        "O X X X X X X X X O \n";
        String next =
                        "X X X X X X X X X X \n" +
                        "X X X X X X X O X X \n" +
                        "X X X X X X X X O O \n" +
                        "X X X X X X X O O X \n" +
                        "X X X X X X X X X X \n" +
                        "X X X X X X X X X X \n" +
                        "O O O X X X X X X X \n" +
                        "X X X X X O O X X X \n" +
                        "X X X X X O O X X X \n" +
                        "X X X X X X X X X X \n";

        assertEquals(current, board.toString());
        board.update();
        assertEquals(next, board.toString());
    }

}
