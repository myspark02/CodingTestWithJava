package codingwithscpark.gui;

import javax.swing.*;
import java.awt.*;

public class Main2 {
    public static void main(String[] args) {
        // JPanel : a GUI component that functions as a container to hold other components
        ImageIcon icon = new ImageIcon("thumbsup.png");    
        JLabel label = new JLabel();
        label.setText("Hi");
        label.setIcon(icon);
        label.setVerticalAlignment(SwingConstants.TOP);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        // label.setBounds(0, 0, 100, 100);

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setBounds(0,0,250,250);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.blue);
        bluePanel.setBounds(250,0,250,250);

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.green);
        greenPanel.setBounds(0,250,500,250);
        greenPanel.setLayout(new BorderLayout());
        // greenPanel.setLayout(null); // no layout manager then a component needs to be set bounds to be displayed
        greenPanel.add(label);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(750, 750);
        frame.setVisible(true);

        frame.add(redPanel);
        frame.add(bluePanel);
        frame.add(greenPanel);
    }
    
}
