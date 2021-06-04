package othello_swing;

import java.awt.Color;
import java.util.ArrayList;

public final class Panel extends javax.swing.JPanel {

    private final int ROW, COLUMN;
    private final ArrayList<Integer> HORIZONTAL = new ArrayList<>();
    private final ArrayList<Integer> VERTICAL = new ArrayList<>();
    private Color color;

    public Panel(int height, int ROW, int COLUMN) {
        this.ROW = ROW;
        this.COLUMN = COLUMN;
        this.color = Color.WHITE;
        setBackground(Color.WHITE);
        setSize((height - 10) / 10, (height - 10) / 10);
        setLocation(COLUMN * (height / 10), ROW * (height / 10));
        if (ROW > 1) {
            VERTICAL.add(-1);
            HORIZONTAL.add(0);
            if (COLUMN > 1) {
                VERTICAL.add(-1);
                HORIZONTAL.add(-1);
                VERTICAL.add(0);
                HORIZONTAL.add(-1);
            }
            if (COLUMN < 8) {
                VERTICAL.add(-1);
                HORIZONTAL.add(1);
                VERTICAL.add(0);
                HORIZONTAL.add(1);
            }
        }
        if (ROW < 8) {
            VERTICAL.add(1);
            HORIZONTAL.add(0);
            if (COLUMN > 1) {
                VERTICAL.add(1);
                HORIZONTAL.add(-1);
                VERTICAL.add(0);
                HORIZONTAL.add(-1);
            }
            if (COLUMN < 8) {
                VERTICAL.add(1);
                HORIZONTAL.add(1);
                VERTICAL.add(0);
                HORIZONTAL.add(1);
            }
        }
    }

    public ArrayList getVertical() {
        return VERTICAL;
    }

    public ArrayList getHorizontal() {
        return HORIZONTAL;
    }

    public int getVerticalIndex(int index) {
        return VERTICAL.get(index);
    }

    public int getHorizontalIndex(int index) {
        return HORIZONTAL.get(index);
    }

    public int getColumn() {
        return COLUMN;
    }

    public int getRow() {
        return ROW;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
