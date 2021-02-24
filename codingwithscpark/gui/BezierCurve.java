package codingwithscpark.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.GeneralPath;

public class BezierCurve extends JFrame implements MouseListener, MouseMotionListener{
    private int[] xs = {50, 150, 400, 450};
    private int[] ys = {200, 50, 300, 200};

    private int dragIndex = -1;
    
    private MyBezierPanel drawPanel;

    class MyBezierPanel extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            g.setColor(Color.blue);
            g.fillRect(xs[0], ys[0], 16, 16);
            g.fillRect(xs[2], ys[2], 16, 16);
            g.setColor(Color.red);
            g.fillRect(xs[1], ys[1], 16, 16);
            g.fillRect(xs[3], ys[3], 16, 16);

            Graphics2D g2d = (Graphics2D)g;
            g2d.setColor(Color.black);
            GeneralPath path = new GeneralPath();
            path.moveTo(xs[0], ys[0]);
            path.curveTo(xs[1], ys[1], xs[2], ys[2], xs[3], ys[3]);
            g2d.draw(path);
        }
    }

    public BezierCurve() {
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("베지어 곡선 시연");
    
        this.drawPanel = new MyBezierPanel();
        this.drawPanel.addMouseListener(this);
        this.drawPanel.addMouseMotionListener(this);
        this.add(drawPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (dragIndex == -1) return;

        xs[dragIndex] = e.getX();
        ys[dragIndex] = e.getY();

        repaint();

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        dragIndex = -1;
        for (int i = 0; i < 4; i++) {
            Rectangle r = new Rectangle(xs[i]-4, ys[i]-4, 20, 20);
            if(r.contains(e.getX(), e.getY())) dragIndex = i;
        }

        // repaint();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
       dragIndex = -1;
    //    repaint();

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new BezierCurve();
    }
    
}
