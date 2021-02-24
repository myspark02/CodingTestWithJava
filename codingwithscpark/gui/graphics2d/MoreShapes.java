package codingwithscpark.gui.graphics2d;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.geom.*;

public class MoreShapes extends JFrame {
    public MoreShapes() {
        this.setSize(600, 130);
        this.setTitle("Java 2D Shapes");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new ShapesPanel();
        this.add(panel);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MoreShapes();
    }
}

class ShapesPanel extends JPanel {
    protected ArrayList<Shape> shapeArray = new ArrayList<>();

    public ShapesPanel() {
        Shape shape;

        shape = new Rectangle2D.Float(10, 10, 70, 80);
        shapeArray.add(shape);

        shapeArray.add(new RoundRectangle2D.Float(110, 10, 70, 80, 20, 20));

        shapeArray.add(new Ellipse2D.Float(210, 10, 80, 80));

        shapeArray.add(new Arc2D.Float(301, 10, 80, 80, 90, 90, Arc2D.OPEN));

        shapeArray.add(new Arc2D.Float(410, 10, 80, 80, 0, 180, Arc2D.CHORD));

        shapeArray.add(new Arc2D.Float(510, 10, 80, 80, 45, 90, Arc2D.PIE));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(3));

        for (Shape s : shapeArray)
            g2.draw(s);

    }
}
