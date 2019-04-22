package model;

public class Cell {
    private boolean isAlive;

    // EFFECTS: creates a new cell with given living state
    public Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    // MODIFIES: this
    // EFFECTS: sets cell living state to given value
    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    // EFFECTS: returns true if the cell is alive
    public boolean isAlive() {
        return this.isAlive;
    }

    // EFFECTS: returns a string representation of the cell,
    //          with O for live cell and X for dead cell
    public String toString() {
        if (isAlive) {
            return "O";
        }
        return " ";
    }


}
