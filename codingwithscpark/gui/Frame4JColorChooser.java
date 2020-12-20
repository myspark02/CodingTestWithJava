package codingwithscpark.gui;

import javax.swing.*;
import javax.swing.text.AttributeSet.FontAttribute;

import java.awt.*;
import java.awt.event.*;

public class Frame4JColorChooser extends JFrame implements ActionListener  {
    JButton button;
    JLabel label;

    Frame4JColorChooser() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        button = new JButton("Pick a color");
        button.addActionListener(this);

        label = new JLabel();
        label.setOpaque(true);
        label.setBackground(Color.white);
        label.setText("This is some text :D");
        label.setFont(new Font("MV Boli", Font.PLAIN, 100));

        add(button);
        add(label);
        pack();
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == button) {
           
           Color color = JColorChooser.showDialog(null, "Pick a color ... I guess", Color.black);
           label.setForeground(color);
        //    label.setBackground(color);
       }

    }
    
}
