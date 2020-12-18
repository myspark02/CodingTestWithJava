package codingwithscpark.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.Border;

public class Main {
        public static void main(String[] args) {
            // JFrame frame = new JFrame(); // create a GUI window to add components to
            // frame.setTitle("title");
            // frame.setResizable(false);
            // frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            // frame.setSize(420, 420);
            // frame.setVisible(true);

            ImageIcon image = new ImageIcon("googleLogo.jpg");
            System.out.println("width:" +image.getIconWidth());
            // if (image.getImage()==null) 
            //     System.out.println("image is null");
        
            // frame.setIconImage(image.getImage());  // not changed...
            // frame.getContentPane().setBackground(Color.green);
            // frame.getContentPane().setBackground(new Color(0,0,0));
            
            // MyFrame myFrame = new MyFrame();

            Border border = BorderFactory.createLineBorder(Color.green, 3);

            JLabel label = new JLabel();

            label.setText("Bro, do you even code?");
            label.setIcon(image);
            label.setHorizontalTextPosition(SwingConstants.CENTER);
            label.setVerticalTextPosition(SwingConstants.TOP); // set text TOP, CENTER, BOTTOM of imageicon
            label.setForeground(new Color(0x00FF00));
            label.setFont(new Font("MV Boli", Font.PLAIN, 50));
            label.setIconTextGap(-25); // set gap of text to image
            label.setBackground(Color.BLACK);
            label.setOpaque(true); // display background
            label.setBorder(border);
            label.setVerticalAlignment(SwingConstants.CENTER); // set vertical position of icon+text within label
            label.setHorizontalAlignment(SwingConstants.CENTER);
            // label.setBounds(0, 0, 400, 400); // set x, y position within frame as well as dimensions


            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            // frame.setSize(500, 500);
            // frame.setLayout(null);
            frame.setVisible(true);
            frame.add(label);
            frame.pack(); // before calling pack method be sure to add components

        }
}
