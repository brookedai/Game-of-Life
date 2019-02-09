package model;

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
    void testSetCell() {
        b.setCell(25, 30, true);
        assertTrue(b.getCell(25, 30).isAlive());

        b.setCell(25, 30, false);
        assertFalse(b.getCell(25, 30).isAlive());
    }

}
