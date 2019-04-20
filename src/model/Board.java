package model;

import model.exceptions.CellNotWithinBoundsException;

public class Board {
    public static final int DEFAULT_NUM = 30;

    private int rows;
    private int cols;
    private Cell[][] board;

    // REQUIRES: rows, cols > 0
    // EFFECTS: constructs a new board with given rows and cols
    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        board = new Cell[rows][cols];
        init();
    }

    // EFFECTS: constructs a new board with 50 rows and 50 columns
    public Board() {
        this(DEFAULT_NUM, DEFAULT_NUM);
    }

    // MODIFIES: this
    // EFFECTS: initializes board by filling with dead cells
    private void init() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                board[i][j] = new Cell(false);
            }
        }
    }

    // EFFECTS: returns number of rows in board
    public int getRows() {
        return this.rows;
    }

    // EFFECTS: returns number of columns in board
    public int getCols() {
        return this.cols;
    }

    // REQUIRES: 0 <= r < rows, 0 <= c < cols
    // EFFECTS: returns cell at position (r, c)
    public Cell getCell(int r, int c) {
        return this.board[r][c];
    }

    // MODIFIES: this
    // EFFECTS: sets cell at (r, c) to given living state
    public void setCell(int r, int c, boolean isAlive) {
        if (withinBounds(r, c)) {
            this.board[r][c].setAlive(isAlive);
        } else {
            throw new CellNotWithinBoundsException("You cannot set the cell at " + r + " " + c);
        }
    }

    // MODIFIES: this
    // EFFECTS: updates cells in board
    public void update() {

    }

    // EFFECTS: returns true if 0 <= r < rows and 0 <= c < cols
    private boolean withinBounds(int r, int c) {
        return (0 <= r && r < rows && 0 <= c && c < cols);
    }

    // EFFECTS: returns string representation of board
    //          with Os representing live cells and
    //          Xs representing dead cells
    @Override
    public String toString() {
        String s = "";
        for (Cell[] row : board) {
            for (Cell c : row) {
                s += c.toString() + " ";
            }
            s += "\n";
        }
        return s;
    }

}
