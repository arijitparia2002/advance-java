import javax.swing.*;
import java.awt.*;

class Frame {
    static public void main(String... rk) {
        JFrame f = new JFrame("KE019");
        f.setSize(500, 800);
        f.getContentPane().setBackground(new Color(0, 0, 255, 20));
        f.setLocationRelativeTo(null);
        // f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel msg = new JLabel("Copyright Reserver @ Arijit Paria");
        f.add(msg, BorderLayout.SOUTH);

        JTextField value = new JTextField(20);
        f.add(value, BorderLayout.NORTH);

        // Creating a JPanel for holding the Buttons

        GridLayout gl = new GridLayout(4, 4, 10, 10);
        JPanel p = new JPanel(gl);

        //string array of button
        String s = "789/456*123-0.=+";

        for (char i : s.toCharArray())
            p.add(new JButton("" + i));
        

        f.add(p);
        f.setVisible(true);
    }
}
