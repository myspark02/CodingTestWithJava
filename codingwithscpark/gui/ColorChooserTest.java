package codingwithscpark.gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;

import java.util.*;

public class ColorChooserTest extends JFrame implements ChangeListener, ActionListener {
    private JColorChooser colorChooser;
    private Color selectedColor = Color.black;
    private JButton selectBtn = new JButton("색상선택완료");
    private JPanel panel = new JPanel();
    private MyDrawingPanel drawPanel = new MyDrawingPanel();

    public ColorChooserTest() {
        this.setTitle("색상 선택기 테스트");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        colorChooser = new JColorChooser();
        colorChooser.getSelectionModel().addChangeListener(this);

        colorChooser.setBorder(BorderFactory.createTitledBorder("색상 선택"));

        selectBtn.addActionListener(this);

        // this.add(drawPanel, BorderLayout.CENTER);
        // drawPanel.setVisible(false);
        // drawPanel.addMouseMotionListener(drawPanel);

        panel.add(colorChooser);
        this.add(panel, BorderLayout.CENTER);
        this.setSize(700, 500);
        this.add(selectBtn, BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ColorChooserTest();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        selectedColor = colorChooser.getColor();
        System.out.println(e.getSource());
        System.out.println(selectedColor);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        System.out.println("버튼:" + action);
        if (action.equals("색상선택완료")) {
            // panel.setVisible(false);
            selectBtn.setText("색상선택하기");
            // drawPanel.setVisible(true);
            this.remove(panel);
            this.add(drawPanel, BorderLayout.CENTER);
            drawPanel.color = selectedColor;
            repaint();
        } else {

            // drawPanel.setVisible(false);
            this.remove(drawPanel);
            selectBtn.setText("색상선택완료");
            // panel.setVisible(true);
            this.add(panel, BorderLayout.CENTER);
            repaint();
        }
    }

    class MyDrawingPanel extends JPanel implements MouseMotionListener {

        class Point {
            int myX;
            int myY;
            Color color = null;
        }

        ArrayList<Point> points = new ArrayList<>();

        Color color = Color.black;

        public MyDrawingPanel() {
            this.addMouseMotionListener(this);
        
        }

        @Override
        public void paintComponent(Graphics g) {
            System.out.println("DrawingPanel paintComponent");
            super.paintComponent(g);
            // g.setColor(color);
            for (int i = 0; i < points.size(); i++) {
                g.setColor(points.get(i).color);
                g.drawRect(points.get(i).myX, points.get(i).myY, 1, 1);
            }

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            System.out.println("Mouse Draged...");
            Point p = new Point();
            p.myX = e.getX();
            p.myY = e.getY();
            p.color = color;
            points.add(p);
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            // TODO Auto-generated method stub
            // System.out.println("Mouse Moved...");
        }

    }

}
