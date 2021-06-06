package othello_swing;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JLabel;

public final class Table_game extends javax.swing.JFrame {

    public Table_game(java.awt.Color color[], boolean is_second_player, boolean start_player_2) {
        initComponents();
        var board = new Panel[10][10];
        var width = Toolkit.getDefaultToolkit().getScreenSize().width;
        var height = Toolkit.getDefaultToolkit().getScreenSize().height;
        var date = new Clock("date");
        var time = new Clock("time");
        var day = new Clock("day");
        date.setBounds(width - 290, 10, 150, 40);
        time.setBounds(width - 300, 50, 300, 40);
        day.setBounds(width - 105, 90, 100, 40);
        getContentPane().add(date);
        getContentPane().add(time);
        getContentPane().add(day);
        var player_1 = new JPanel();
        var player_2 = new JPanel();
        player_1.setBounds(height + 12, height - 10, 46, 10);
        player_2.setBounds(height + 72, height - 10, 46, 10);
        player_1.setBackground(color[0]);
        player_2.setBackground(color[1]);
        getContentPane().add(player_1);
        getContentPane().add(player_2);
        var score_player_1 = new JProgressBar(1, 0, 75);
        var score_player_2 = new JProgressBar(1, 0, 75);
        score_player_1.setBounds(height + 10, 0, 50, height - 10);
        score_player_2.setBounds(height + 70, 0, 50, height - 10);
        score_player_1.setValue(2);
        score_player_2.setValue(2);
        getContentPane().add(score_player_1);
        getContentPane().add(score_player_2);
        var play_player = new JLabel("PLAYER_PLAY");
        play_player.setFont(new java.awt.Font("Times New Roman", 1, 30));
        if (!start_player_2) {
            play_player.setForeground(color[0]);
        } else {
            play_player.setForeground(color[1]);
        }
        play_player.setBounds(height + 200, height / 2 - 30, 300, 100);
        getContentPane().add(play_player);
        var mouse_listener = new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Methods.color_player(board, play_player.getForeground());
                if (Methods.check_score(board, score_player_1, score_player_2, play_player)) {
                    if (!is_second_player) {
                        do {
                            Methods.play_pc(board, play_player.getForeground());
                        } while (!Methods.check_score(board, score_player_1, score_player_2, play_player));
                    }
                }
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Methods.clear_focus(board);
                var panel = (Panel) evt.getSource();
                if (Methods.evaluate(board, new Step(panel.getRow(), panel.getColumn(), play_player.getForeground()), "PLAYER") == 0) {
                    board[panel.getRow()][panel.getColumn()].setVisible(false);
                }
            }
        };
        Methods.mouse_listener = mouse_listener;
        for (var i = 0; i < 10; i++) {
            for (var j = 0; j < 10; j++) {
                board[i][j] = new Panel(height, i, j);
                board[i][j].addMouseListener(mouse_listener);
                getContentPane().add(board[i][j]);
            }
        }
        board[4][4].setBackground(color[0]);
        board[5][5].setBackground(color[0]);
        board[4][5].setBackground(color[1]);
        board[5][4].setBackground(color[1]);
        board[4][4].setColor(color[0]);
        board[5][5].setColor(color[0]);
        board[4][5].setColor(color[1]);
        board[5][4].setColor(color[1]);
        board[4][4].removeMouseListener(mouse_listener);
        board[5][5].removeMouseListener(mouse_listener);
        board[4][5].removeMouseListener(mouse_listener);
        board[5][4].removeMouseListener(mouse_listener);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        dispose();
        setUndecorated(true);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == 27 && javax.swing.JOptionPane.showConfirmDialog(null,
                "Really want to exit?", "QUIT",
                javax.swing.JOptionPane.YES_NO_OPTION) == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_formKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
