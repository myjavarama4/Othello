package othello_swing;

public final class CB_item_color {

    private final String COLOR_NAME;
    private final java.awt.Color COLOR;

    public CB_item_color(String COLOR_NAME, java.awt.Color COLOR) {
        this.COLOR_NAME = COLOR_NAME;
        this.COLOR = COLOR;
    }

    @Override
    public String toString() {
        return COLOR_NAME;
    }

    public java.awt.Color getColor() {
        return COLOR;
    }
}
