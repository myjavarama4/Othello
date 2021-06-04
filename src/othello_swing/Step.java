package othello_swing;

import java.awt.Color;

public final class Step {

    private final int ROW, COLUMN;
    private final Color COLOR;

    public Step(int ROW, int COLUMN, Color COLOR) {
        this.ROW = ROW;
        this.COLUMN = COLUMN;
        this.COLOR = COLOR;
    }

    public int getRow() {
        return ROW;
    }

    public int getColumn() {
        return COLUMN;
    }

    public Color getColor() {
        return COLOR;
    }
}
