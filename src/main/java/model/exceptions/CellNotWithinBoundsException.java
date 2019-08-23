package model.exceptions;

public class CellNotWithinBoundsException extends RuntimeException {

    public CellNotWithinBoundsException() {
        super();
    }

    public CellNotWithinBoundsException(String msg) {
        super(msg);
    }

}
