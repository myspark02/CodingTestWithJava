package codingwithscpark.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Fractal extends JFrame {

    public Fractal() {
        this.setSize(800, 700);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {
        if (depth == 0)
            return;

        // int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * 10.0);
        // int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * 10.0);

        int randlen = (int) (Math.random() * 10);
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * randlen * 5.0);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * randlen * 5.0);

        g.drawLine(x1, y1, x2, y2);
        int leftAngle = (int) (Math.random() * 20);
        int rightAngle = (int) (Math.random() * 20);

        // drawTree(g, x2, y2, angle - 20, depth - 1);
        // drawTree(g, x2, y2, angle + 20, depth - 1);
        int numBranches = (int) (Math.random() * 3);
        if (numBranches == 1)
            drawTree(g, x2, y2, angle - leftAngle, depth - 1);
        else if (numBranches == 2)
            drawTree(g, x2, y2, angle + rightAngle, depth - 1);
        else {
            drawTree(g, x2, y2, angle - leftAngle, depth - 1);
            drawTree(g, x2, y2, angle + rightAngle, depth - 1);
        }
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        drawTree(g, 400, 600, -90, 20);
    }

    public static void main(String[] args) {
        JFrame frame = new Fractal();
    }

}
