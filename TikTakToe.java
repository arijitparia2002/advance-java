import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TikTakToe {

    static boolean isOdd = true;
    static JButton[] buttons = new JButton[9];

    public static void main(String[] args) {
        class MyListener implements ActionListener {
            public void actionPerformed(ActionEvent ae) {
                JButton b = (JButton) ae.getSource();
                if (!b.getText().equals("")) {
                    return; // If the button already has a symbol, do nothing
                }
                if (isOdd) {
                    b.setText("X");
                } else {
                    b.setText("O");
                }
                isOdd = !isOdd;
                b.setEnabled(false);
                if (checkWin("X")) {
                    JOptionPane.showMessageDialog(null, "Player X wins!");
                    resetBoard();
                } else if (checkWin("O")) {
                    JOptionPane.showMessageDialog(null, "Player O wins!");
                    resetBoard();
                } else if (isBoardFull()) {
                    JOptionPane.showMessageDialog(null, "It's a draw!");
                    resetBoard();
                }
            }
        }

        JFrame f = new JFrame("Tic Tac Toe");
        f.setSize(500, 500);
        f.getContentPane().setBackground(new Color(30, 20, 200, 20));
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        GridLayout gl = new GridLayout(3, 3, 4, 4);
        JPanel jp = new JPanel(gl);

        for (int i = 0; i < 9; i++) {
            JButton bt = new JButton("");
            bt.setFont(new Font("Serif", i, 30));
            bt.addActionListener(new MyListener());
            jp.add(bt);
            buttons[i] = bt; // store buttons in an array for easier access
        }

        f.add(jp);

        f.setVisible(true);

    }

    static boolean checkWin(String symbol) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (buttons[i * 3].getText().equals(symbol) && buttons[i * 3 + 1].getText().equals(symbol) && buttons[i * 3 + 2].getText().equals(symbol)) {
                return true;
            }
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (buttons[i].getText().equals(symbol) && buttons[i + 3].getText().equals(symbol) && buttons[i + 6].getText().equals(symbol)) {
                return true;
            }
        }
        // Check diagonals
        if (buttons[0].getText().equals(symbol) && buttons[4].getText().equals(symbol) && buttons[8].getText().equals(symbol)) {
            return true;
        }
        if (buttons[2].getText().equals(symbol) && buttons[4].getText().equals(symbol) && buttons[6].getText().equals(symbol)) {
            return true;
        }
        return false;
    }

    static boolean isBoardFull() {
        for (JButton button : buttons) {
            if (button.getText().equals("")) {
                return false;
            }
        }
        return true;
    }

    static void resetBoard() {
        for (JButton button : buttons) {
            button.setText("");
            button.setEnabled(true);
        }
        isOdd = true; // Reset the turn to X
    }
}
