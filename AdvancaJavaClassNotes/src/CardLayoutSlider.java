import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class CardLayoutSlider {
    static int value = 0;

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

        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.yellow);
        card_panel.add(panel4, "Yellow");

        // add buttons
        JPanel footer = new JPanel();
        JLabel text = new JLabel("Change speed");
        JSlider slider = new JSlider(100, 3000);
        footer.add(text);
        footer.add(slider);
        f.add(footer, BorderLayout.SOUTH);
        f.setVisible(true);

        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                value = slider.getValue();
            }
        });

        while (true) {
            try {
                System.out.println(value);
                Thread.sleep(3000 - value);
            } catch (Exception e) {
            }
            cl.next(card_panel);
        }
    }

}
