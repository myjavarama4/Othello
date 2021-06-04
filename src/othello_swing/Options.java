package othello_swing;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JComboBox;

public final class Options extends javax.swing.JFrame {

    public Options() {
        initComponents();
        var font = new java.awt.Font("Times New Roman", 2, 20);
        var color_player_1 = new CB_color(5, font, "Player 1 color");
        var color_player_2 = new CB_color(145, font, "Player 2 color");
        var color_focus = new CB_color(285, font, "Focus color");
        var player_vs_player = new Check_box(5, 190, "PLAYER VS PLAYER", font);
        var start_player = new Check_box(290, 170, "START PLAYER 2", font);
        var reverse = new Check_box(460, 110, "REVERSE", font);
        var difficult = new JComboBox();
        difficult.addItem("EASY");
        difficult.addItem("HARD");
        difficult.setBounds(425, 30, 85, 30);
        difficult.setFont(font);
        difficult.setBackground(Color.DARK_GRAY);
        var play = new javax.swing.JButton("PLAY");
        start_player.setEnabled(false);
        play.setBounds(510, 30, 60, 30);
        play.setEnabled(false);
        java.awt.event.ItemListener item_listener = (java.awt.event.ItemEvent e) -> {
            play.setEnabled(false);
            ((JComboBox) e.getSource()).setBackground(((CB_item_color) (((JComboBox) e.getSource()).getSelectedItem())).getColor());
            if (color_player_1.getSelectedIndex() != color_player_2.getSelectedIndex()) {
                if (color_player_1.getSelectedIndex() != color_focus.getSelectedIndex()) {
                    if (color_player_2.getSelectedIndex() != color_focus.getSelectedIndex()) {
                        play.setEnabled(true);
                    }
                }
            }
        };
        color_player_1.addItemListener(item_listener);
        color_player_2.addItemListener(item_listener);
        color_focus.addItemListener(item_listener);
        javax.swing.event.ChangeListener change_listner = (javax.swing.event.ChangeEvent e) -> {
            if (player_vs_player.isSelected()) {
                start_player.setEnabled(true);
                difficult.setEnabled(false);
            } else {
                start_player.setEnabled(false);
                start_player.setSelected(false);
                difficult.setEnabled(true);
            }
        };
        player_vs_player.addChangeListener(change_listner);
        play.addActionListener((java.awt.event.ActionEvent evt) -> {
            Color color[] = {color_player_1.getBackground(), color_player_2.getBackground(), color_focus.getBackground()};
            Methods.color = color;
            Methods.reverse = reverse.isSelected();
            Methods.hard = difficult.getSelectedIndex() == 1;
            var table_game = new Table_game(color, player_vs_player.isSelected(), start_player.isSelected());
            setVisible(false);
        });
        getContentPane().add(player_vs_player);
        getContentPane().add(start_player);
        getContentPane().add(reverse);
        getContentPane().add(color_focus);
        getContentPane().add(color_player_1);
        getContentPane().add(color_player_2);
        getContentPane().add(difficult);
        getContentPane().add(play);
        setSize(575, 65);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getWidth()) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getHeight()) / 2);
        dispose();
        setUndecorated(true);
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            new Options().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
