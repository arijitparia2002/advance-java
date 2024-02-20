import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.SliderUI;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CardLAyoutDemo {
    static public void main(String... rk) {
        JFrame f = new JFrame();
        f.setSize(600, 800);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setLocationRelativeTo(null);
        f.getContentPane().setBackground(Color.YELLOW);

        CardLayout cl = new CardLayout();
        JPanel card_panel = new JPanel();
        f.add(card_panel);
        card_panel.setLayout(cl);

        // add a card

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.red);
        card_panel.add(panel1, "Red");

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.green);
        card_panel.add(panel2, "Green");

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.blue);
        card_panel.add(panel3, "Blue");

        // add buttons
        JPanel footer = new JPanel();

        // JButton prev = new JButton("Previous");
        // footer.add(prev);

        // JButton next = new JButton("Next");
        // footer.add(next);
        
        // class Listener implements ActionListener {
        //     public void actionPerformed(ActionEvent e) {
        //         if (e.getSource() == next) {
        //             cl.next(card_panel);
        //         } else if (e.getSource() == prev) {
        //             cl.previous(card_panel);
        //         }
        //     }
        // }
        // Listener listner = new Listener();
        // next.addActionListener(listner);
        // prev.addActionListener(listner);

        JSlider slider = new JSlider();
        footer.add(slider);

        f.add(footer, BorderLayout.SOUTH);
        f.setVisible(true);


       


        // change in delay
        // while (true) {
        // cl.next(card_panel);
        // try {
        // Thread.sleep(500);
        // } catch (Exception ex) {
        // }
        // }

    }

}
