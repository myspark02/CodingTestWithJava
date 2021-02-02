package codingwithscpark.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Graphic Basic Program");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(new MouseEventTestPanel());

        frame.setSize(300, 200);
        frame.setVisible(true);
    }

}

class MouseEventTestPanel extends JPanel {
    private int squareX = 50;
    private int squareY = 50;
    private int squareW = 20;
    private int squareH = 20;

    public MouseEventTestPanel() {
        this.setBorder(BorderFactory.createLineBorder(Color.black));

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                moveSquare(e.getX(), e.getY());
            }
        });

        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                moveSquare(e.getX(), e.getY());
            }
        });
    }

    private void moveSquare(int x, int y) {
        int offset = 3;
        if (squareX != x || squareY != y) {
            repaint(squareX, squareY, squareW + offset, squareH + offset);
            squareX = x;
            squareY = y;
            repaint(squareX, squareY, squareW + offset, squareH + offset);
        }
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("마우스를 클릭하면 사각형이 그려집니다.!", 10, 20);
        g.setColor(Color.red);
        g.fillRect(squareX, squareY, squareW, squareH);
        g.setColor(Color.black);
        g.drawRect(squareX, squareY, squareW, squareH);
    }
}
