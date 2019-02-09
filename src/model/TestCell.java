package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCell {
    private Cell c;

    @BeforeEach
    void runBefore() {
        c = new Cell(false);
    }

    @Test
    void testConstructor() {
        assertFalse(c.isAlive());
    }

    @Test
    void testSetAlive() {
        assertFalse(c.isAlive());
        c.setAlive(true);
        assertTrue(c.isAlive());
    }
}
