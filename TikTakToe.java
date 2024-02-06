import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TikTakToe {

    static boolean isOdd = true;

    public static void main(String[] args) {
        // my listner class
        class MyListner implements ActionListener {
            public void actionPerformed(ActionEvent ae) {
                System.out.println("ButtonClicked");
                JButton b = (JButton) ae.getSource();
                if (isOdd) {
                    isOdd = false;
                    b.setText("X");

                } else {
                    isOdd = true;
                    b.setText("O");
                }
                b.setEnabled(false);

            }
        }

        JFrame f = new JFrame("Tic Tac Toe");
        f.setSize(500, 500);
        f.getContentPane().setBackground(new Color(30, 20, 200, 20));
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // grid layout
        GridLayout gl = new GridLayout(3, 3, 4, 4);
        JPanel jp = new JPanel(gl);

        for (int i = 0; i < 9; i++) {
            JButton bt = new JButton("");
            bt.setFont(new Font("Serif", i, 30));
            bt.addActionListener(new MyListner());
            jp.add(bt);
        }

        f.add(jp);

        f.setVisible(true);

    }
}
