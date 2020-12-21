package codingwithscpark.gui;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

public class DragPanel extends JPanel {
    ImageIcon image = new ImageIcon("smile.jpeg");
    // final int WIDTH = image.getIconWidth();
    // final int HEIGHT = image.getIconHeight();
    Point imageCorner;
    Point prevPt;


    DragPanel() {
        imageCorner = new Point(0, 0);
        ClickListener clickListener = new ClickListener();
        DragListener dragListener = new DragListener();
        addMouseListener(clickListener);
        addMouseMotionListener(dragListener);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        image.paintIcon(this, g, (int)imageCorner.getX(), (int)imageCorner.getY());
        // image.paintIcon(null, g, (int)imageCorner.getX(), (int)imageCorner.getY());
    }

    private class ClickListener extends MouseInputAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            prevPt = e.getPoint();
        }
    }
    private class DragListener extends MouseMotionAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            Point currentPt = e.getPoint();
            imageCorner.translate(
                    (int)(currentPt.getX() - prevPt.getX()) ,
                    (int)(currentPt.getY() - prevPt.getY())
                );
            // imageCorner.setLocation((int)currentPt.getX(), (int)currentPt.getY());
            prevPt = currentPt;
            repaint();    
        }
    }
}
