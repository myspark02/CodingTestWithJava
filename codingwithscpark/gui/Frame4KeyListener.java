package codingwithscpark.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame4KeyListener extends JFrame implements KeyListener  {
    JLabel label ;

    Frame4KeyListener() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(null);
        addKeyListener(this);

        label = new JLabel();
        label.setBounds(0, 0, 100, 100);
        // label.setBackground(Color.red);
        // label.setOpaque(true);
        
        ImageIcon icon = new ImageIcon("rocket2.png");
        label.setIcon(icon);

        getContentPane().setBackground(Color.black);
        add(label);

        setVisible(true); 

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // keyTyped : Invoked when a key is typed. Uses KeyChar, char output
        switch(e.getKeyChar()) {
            case 'a': label.setLocation(label.getX()-10, label.getY());
                break;
            case 'w': label.setLocation(label.getX(), label.getY()-10); 
                break;
            case 's': label.setLocation(label.getX(), label.getY()+10); 
                 break;
            case 'd': label.setLocation(label.getX()+10, label.getY()); 
                 break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // keyPressed : Invoked when a physical key is pressed down. Uses KeyCode, int output
        switch(e.getKeyCode()) {
            case 37: label.setLocation(label.getX()-10, label.getY());
                break;
            case 38: label.setLocation(label.getX(), label.getY()-10); 
                break;
            case 39: label.setLocation(label.getX()+10, label.getY()); 
                 break;
            case 40: label.setLocation(label.getX(), label.getY()+10); 
                 break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // keyReleased : called whenever a button is released
        System.out.println("You released key char : " + e.getKeyChar());
        System.out.println("You released key char : " + e.getKeyCode());
    }
    
}
