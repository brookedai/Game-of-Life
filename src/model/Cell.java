package model;

public class Cell {
    private boolean isAlive;

    // EFFECTS: creates a new cell with given alive state
    public Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    // MODIFIES: this
    // EFFECTS: sets cell alive state to given value
    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    // EFFECTS: returns true if the cell is alive
    public boolean isAlive() {
        return this.isAlive;
    }


}
