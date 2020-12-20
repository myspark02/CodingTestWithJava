package codingwithscpark.gui;

import java.awt.*;

import javax.swing.*;

public class Main4FlowLayout {
    public static void main(String[] args) {
        // Layout Manager : Defines the natural layout for components within a container

        /*
        FlowLayout : places components in a row, sized at their preferred size.
                    If the horizontal space in the container is too small, 
                    the FlowLayout class uses the next available row.
        */

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 500));
        // frame.setLayout(new FlowLayout());
        // frame.setLayout(new FlowLayout(FlowLayout.LEADING));
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(250, 250));
        panel.setBackground(Color.lightGray);
        panel.setLayout(new FlowLayout());
        
        panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        panel.add(new JButton("4"));
        panel.add(new JButton("5"));
        panel.add(new JButton("6"));
        panel.add(new JButton("7"));
        panel.add(new JButton("8"));
        panel.add(new JButton("9"));

        frame.add(panel);
        frame.setVisible(true);
    }
}
