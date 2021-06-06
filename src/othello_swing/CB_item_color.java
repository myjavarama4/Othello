package othello_swing;

import java.awt.Color;

public final class CB_item_color {

    private final String COLOR_NAME;
    private final Color COLOR;

    public CB_item_color(String COLOR_NAME, Color COLOR) {
        this.COLOR_NAME = COLOR_NAME;
        this.COLOR = COLOR;
    }

    @Override
    public String toString() {
        return COLOR_NAME;
    }

    public Color getColor() {
        return COLOR;
    }
}
