package othello_swing;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public final class Methods {

    static MouseListener mouse_listener;
    static Color color[] = new Color[3];
    private static int number;
    static boolean hard, reverse;

    public static int evaluate(Panel[][] board, Step step, String fce) {
        var rival = get_rival(step.getColor());
        number = 0;
        for (int i = 0; i < board[step.getRow()][step.getColumn()].getVertical().size(); i++) {
            number += check(board, step, new Way(board[step.getRow()][step.getColumn()].getVerticalIndex(i), board[step.getRow()][step.getColumn()].getHorizontalIndex(i)), rival, fce);
        }
        return number;
    }

    private static int check(Panel board[][], Step step, Way way, Color rival, String fce) {
        try {
            if (board[step.getRow() + way.getVertical()][step.getColumn() + way.getHorizontal()].getBackground().equals(rival)) {
                for (int i = step.getRow() + 2 * way.getVertical(), j = step.getColumn() + 2 * way.getHorizontal();; i += way.getVertical(), j += way.getHorizontal()) {
                    if (board[i][j].getBackground().equals(Color.WHITE)) {
                        return 0;
                    } else if (board[i][j].getBackground().equals(step.getColor())) {
                        if ("PLAYER".equals(fce)) {
                            color_focus(board, step, new Step(i, j, null), way, true);
                            return 1;
                        } else if ("PC".equals(fce)) {
                            color_focus(board, step, new Step(i, j, null), way, false);
                            return 1;
                        }
                        int value = 0;
                        if (number > 0) {
                            value = 1;
                        }
                        if (i == step.getRow()) {
                            return Math.abs(j - step.getColumn()) - value;
                        } else {
                            return Math.abs(i - step.getRow()) - value;
                        }
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        return 0;
    }

    public static void play_pc(Panel board[][], Color rival) {
        int count, value = 0;
        var zero = false;
        Step step = null;
        clear_focus(board);
        for (int i = 0; i < 10 && !zero; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j].getBackground().equals(Color.WHITE)) {
                    count = Methods.evaluate(board, new Step(i, j, rival), "CHECK");
                    if (count > value) {
                        step = new Step(i, j, rival);
                        if (!hard && value > 0) {
                            zero = true;
                            break;
                        }
                        value = count;
                    }
                }
            }
        }
        Methods.evaluate(board, step, "PC");
    }

    public static void clear_focus(Panel board[][]) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j].setBackground(board[i][j].getColor());
                board[i][j].setVisible(true);
            }
        }
    }

    public static void color_player(Panel board[][], Color play_player) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j].getBackground().equals(color[2])) {
                    board[i][j].setBackground(play_player);
                    board[i][j].setColor(play_player);
                    board[i][j].removeMouseListener(mouse_listener);
                }
            }
        }
    }

    private static void color_focus(Panel board[][], Step start, Step end, Way way, boolean only_focus) {
        for (int i = start.getRow(), j = start.getColumn(); i != end.getRow() || j != end.getColumn(); i += way.getVertical(), j += way.getHorizontal()) {
            if (only_focus) {
                board[i][j].setBackground(color[2]);
            } else {
                board[i][j].setBackground(start.getColor());
                board[i][j].setColor(start.getColor());
                board[i][j].removeMouseListener(mouse_listener);
            }
        }
    }

    public static boolean check_score(Panel board[][], JProgressBar score_player_1, JProgressBar score_player_2, JLabel player) {
        score_player_1.setValue(0);
        score_player_2.setValue(0);
        var can_rival_play = 0;
        var rival = get_rival(player.getForeground());
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j].getBackground().equals(color[0])) {
                    score_player_1.setValue(score_player_1.getValue() + 1);
                } else if (board[i][j].getBackground().equals(color[1])) {
                    score_player_2.setValue(score_player_2.getValue() + 1);
                } else if (can_rival_play == 0) {
                    can_rival_play = evaluate(board, new Step(i, j, rival), "CHECK");
                }
            }
        }
        check_status(score_player_1.getValue(), score_player_2.getValue(), can_rival_play, player);
        return can_rival_play > 0;
    }

    private static void check_status(int score_player_1, int score_player_2, int can_rival_play, JLabel player) {
        if (score_player_1 + score_player_2 == 100 || score_player_1 == 0 || score_player_2 == 0) {
            String winner;
            if (!reverse) {
                if (score_player_1 > score_player_2) {
                    winner = "Winner is player 1.";
                } else if (score_player_2 > score_player_1) {
                    winner = "Winner is player 2.";
                } else {
                    winner = "Indecisively.";
                }
            } else if (score_player_1 > score_player_2) {
                winner = "Winner is player 2.";
            } else if (score_player_2 > score_player_1) {
                winner = "Winner is player 1.";
            } else {
                winner = "Indecisively.";
            }
            JOptionPane.showMessageDialog(null, winner, "End of Game", 1);
            System.exit(0);
        } else if (can_rival_play > 0) {
            if (player.getForeground().equals(color[0])) {
                player.setForeground(color[1]);
            } else {
                player.setForeground(color[0]);
            }
        }
    }

    public static Color get_rival(Color player) {
        if (player.equals(color[0])) {
            return color[1];
        }
        return color[0];
    }
}
