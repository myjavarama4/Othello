package othello_swing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import javax.swing.SwingConstants;

public final class Clock extends javax.swing.JLabel implements java.awt.event.ActionListener {

    private final SimpleDateFormat SIMPLE_DATE_FORMAT;

    public Clock(String type, int x, int y, int width, int height) {
        setBounds(x, y, width, height);
        setForeground(java.awt.Color.DARK_GRAY);
        switch (type) {
            case "date" -> {
                SIMPLE_DATE_FORMAT = new SimpleDateFormat("  MMMM dd yyyy");
                setFont(new Font("sans-serif", Font.PLAIN, 12));
                setHorizontalAlignment(SwingConstants.LEFT);
            }
            case "time" -> {
                SIMPLE_DATE_FORMAT = new SimpleDateFormat("hh:mm:ss a");
                setFont(new Font("sans-serif", Font.PLAIN, 40));
                setHorizontalAlignment(SwingConstants.CENTER);
            }
            case "day" -> {
                SIMPLE_DATE_FORMAT = new SimpleDateFormat("EEEE  ");
                setFont(new Font("sans-serif", Font.PLAIN, 16));
                setHorizontalAlignment(SwingConstants.RIGHT);
            }
            default ->
                SIMPLE_DATE_FORMAT = new SimpleDateFormat();
        }
        var t = new javax.swing.Timer(1000, this);
        t.start();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        var d = new java.util.Date();
        setText(SIMPLE_DATE_FORMAT.format(d));
    }
}
