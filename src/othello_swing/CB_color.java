package othello_swing;

import java.awt.Color;

public final class CB_color extends javax.swing.JComboBox {

    public CB_color(int left, java.awt.Font font, String tool_tip) {
        setBounds(left, 30, 141, 30);
        setFont(font);
        setToolTipText(tool_tip);
        setBackground(Color.MAGENTA);
        addItem(new CB_item_color("PURPLE", Color.MAGENTA));
        addItem(new CB_item_color("RED", Color.RED));
        addItem(new CB_item_color("GREEN", Color.GREEN));
        addItem(new CB_item_color("YELLOW", Color.YELLOW));
        addItem(new CB_item_color("TURQUOISE", Color.CYAN));
        addItem(new CB_item_color("BLUE", Color.BLUE));
        setSelectedIndex(0);
    }
}
