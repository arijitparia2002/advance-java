import java.awt.*;
import javax.swing.*;

public class MovingBallcanvas extends Canvas {

    int h = 0;
    int v = 0;
    boolean right = true;

    void move() {
        if (right) {
            h++;
        } else {
            h--;
            
        }

        if (h == 520) {
            right = false;
        }
        if (h == 0) {
            right = true;
        }
        try {
            Thread.sleep(5);
        } catch (Exception ex) {
        }
        repaint();
    }

    public void paint(Graphics g) {

        // moving ball
        g.setColor(Color.RED);
        g.fillOval(10 - h, 200 + v, 80, 80);
       
        // moving ball
        g.setColor(Color.GREEN);
        g.fillOval(20 + h, 200 + v, 80, 80);

        // moving ball
        g.setColor(Color.BLUE);
        g.fillOval(0 + h, 200 + v, 80, 80);
        move();
    }

    public static void main(String... rk) {
        JFrame frame = new JFrame("Noving Ball");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        MovingBallcanvas canvas = new MovingBallcanvas();
        frame.add(canvas);
        frame.setVisible(true);
    }

}