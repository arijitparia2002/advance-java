import java.awt.*;
import javax.swing.*;

public class MyCanvas extends Canvas {
    int d = 0;
    boolean right = true;

    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.setFont(new Font("Serif", 2, 30));
        g.drawString("Arijit Paria", 100, 100);

        g.setFont(new Font("Serif", 2, 20));
        g.drawString("Intersect", 205, 205);
        g.drawLine(100, 100, 200, 200);
        g.drawLine(200, 200, 100, 200);
        g.drawLine(200, 200, 100, 300);

        // bangladesh flag
        // rect
        g.setColor(Color.GREEN);
        g.fillRect(300, 300, 200, 150);

        // circle
        g.setColor(Color.red);
        g.fillOval(350, 325, 90, 90);

        // stand
        g.setColor(Color.BLACK);
        g.setFont(new Font("Serif", 1, 40));
        // g.drawLine(500,290,500,600);
        g.fillRect(500, 290, 10, 600);

        // drawing an arc
        g.setColor(Color.ORANGE);
        g.fillArc(400, 50, 200, 200, 180, 50);

        // polylines
        g.setColor(Color.black);
        int x[] = { 500, 550, 400, 300 };
        int y[] = { 150, 100, 40, 200 };
        g.drawPolyline(x, y, 4);

    }

    public static void main(String... rk) {
        JFrame frame = new JFrame("My Canvas");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        MyCanvas canvas = new MyCanvas();
        frame.add(canvas);
        frame.setVisible(true);
    }
}
