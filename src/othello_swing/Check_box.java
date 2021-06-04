package othello_swing;

public class Check_box extends javax.swing.JCheckBox {

    public Check_box(int left, int width, String text, java.awt.Font font) {
        setBounds(left, 5, width, 25);
        setText(text);
        setFont(font);
    }
}
