package codingwithscpark.gui.graphics2d;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class GradientTest extends JFrame {
    public GradientTest() {
        this.setSize(1200, 130);
        this.setTitle("Java 2D Shapes");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new ShapesGradientPanel();
        this.add(panel);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GradientTest();
    }
}

class ShapesGradientPanel extends ShapesPanel {
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
      
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(3));
        GradientPaint gp = new GradientPaint(0, 10, Color.WHITE, 0, 70, Color.RED);

        System.out.println(shapeArray.size());
        for (int i = 0; i < shapeArray.size(); i++) {
            if (i % 2 == 0) {
                g2.setPaint(Color.red);
                g2.fill(shapeArray.get(i));
            } else {
                g2.setPaint(gp);
                g2.fill(shapeArray.get(i));
            }
        }

    }
}
