package model;

import model.exceptions.CellNotWithinBoundsException;

public class Board {
    public static final int DEFAULT_NUM = 10;

    private int rows;
    private int cols;
    private Cell[][] board;

    //==================================================================================================================
    //===========================================  C O N S T R U C T O R S  ============================================
    //==================================================================================================================

    // REQUIRES: rows, cols > 0
    // EFFECTS: constructs a new board with given rows and cols
    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        board = new Cell[rows][cols];
        init();
    }

    // EFFECTS: constructs a new board with 10 rows and 10 columns
    public Board() {
        this(DEFAULT_NUM, DEFAULT_NUM);
    }


    //==================================================================================================================
    //=========================================  P U B L I C   M E T H O D S  ==========================================
    //==================================================================================================================

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
        if (withinBounds(r, rows) && withinBounds(c, cols)) {
            this.board[r][c].setAlive(isAlive);
        } else {
            throw new CellNotWithinBoundsException("You cannot set the cell at " + r + " " + c);
        }
    }

    // MODIFIES: this
    // EFFECTS: updates cells in board
    public void update() {
        Cell[][] nextBoard = boardCopy();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                nextBoard[r][c] = nextCell(r, c);
            }
        }
        board = nextBoard;
    }

    // EFFECTS: returns string representation of board
    //          with Os representing live cells and
    //          Xs representing dead cells
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Cell[] row : board) {
            for (Cell c : row) {
                s.append(c.toString());
                s.append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    //==================================================================================================================
    //=======================================  P R I V A T E   M E T H O D S  ==========================================
    //==================================================================================================================

    // MODIFIES: this
    // EFFECTS: initializes board by filling with dead cells
    private void init() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                board[i][j] = new Cell(false);
            }
        }
    }

    // EFFECTS: returns the next cell at (r, c)
    private Cell nextCell(int r, int c) {
        int neighbours = numNeighbours(r, c);
        if ((board[r][c].isAlive() && neighbours == 2)
            || neighbours == 3) {
            return new Cell(true);
        }
        return new Cell(false);
    }

    // EFFECTS: returns the number of live neighbours surrounding cell at (r, c)
    private int numNeighbours(int r, int c) {
        int count = 0;
        for (int row = r - 1; row <= r + 1; row ++) {
            if (withinBounds(row, rows)) {

                for (int col = c - 1; col <= c + 1; col++) {
                    if (withinBounds(col, cols) && (row != r || col != c)) {
                        count += board[row][col].isAlive() ? 1 : 0;
                    }
                }

            }
        }
        return count;
    }

    // EFFECTS: returns true if 0 <= num < bound
    private boolean withinBounds(int num, int bound) {
        return 0 <= num && num < bound;
    }

    // EFFECTS: returns a copy of the board
    private Cell[][] boardCopy() {
        Cell[][] newBoard = new Cell[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                newBoard[r][c] = new Cell(board[r][c].isAlive());
            }
        }
        return newBoard;
    }



}
