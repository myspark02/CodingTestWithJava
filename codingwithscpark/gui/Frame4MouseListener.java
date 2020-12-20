package codingwithscpark.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame4MouseListener extends JFrame implements MouseListener {
    JLabel label;
    ImageIcon smile;
    ImageIcon nervous;
    ImageIcon pain;
    ImageIcon dizzy;


    Frame4MouseListener() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(new FlowLayout());

        label = new JLabel();
        // label.setBounds(0, 0, 100, 100);
        // label.setBackground(Color.red);
        // label.setOpaque(true);
        label.addMouseListener(this);

        smile = new ImageIcon("smile.jpeg");
        nervous = new ImageIcon("nervous.png");
        pain = new ImageIcon("pain.png");
        dizzy = new ImageIcon("dizzy.png");

        label.setIcon(smile);

        add(label);

        setLocationRelativeTo(null);
        setVisible(true);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // Invoked when the mouse button has been clicked (pressed and released) on a component
        // System.out.println("You clicked the mouse");

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Invoked when a mouse button has been pressed on a component
        // System.out.println("You pressed the mouse");
        // label.setBackground(Color.yellow);
        label.setIcon(pain);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Invoked when a mouse button has been released on a component
        // System.out.println("You released the mouse");
        // label.setBackground(Color.green);
        label.setIcon(dizzy);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Invoked when the mouse enters a component
        // System.out.println("You entered the mouse");
        // label.setBackground(Color.blue);
        label.setIcon(nervous);

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Invoked when the mouse exits a component
        // System.out.println("You exited the mouse");
        // label.setBackground(Color.red);
        label.setIcon(smile);
    }
    
}
