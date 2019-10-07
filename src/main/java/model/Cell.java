package model;

public class Cell {
    private boolean isAlive;

    //==================================================================================================================
    //===========================================  C O N S T R U C T O R S  ============================================
    //==================================================================================================================

    // EFFECTS: creates a new cell with given living state
    public Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    //==================================================================================================================
    //=========================================  P U B L I C   M E T H O D S  ==========================================
    //==================================================================================================================

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
        return "X";
    }


}
