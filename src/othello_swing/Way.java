package othello_swing;

public final class Way {

    private final int VERTICAL, HORIZONTAL;

    public Way(int VERTICAL, int HORIZONTAL) {
        this.VERTICAL = VERTICAL;
        this.HORIZONTAL = HORIZONTAL;
    }

    public int getVertical() {
        return VERTICAL;
    }

    public int getHorizontal() {
        return HORIZONTAL;
    }
}
