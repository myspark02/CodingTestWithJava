package codingwithscpark.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame4JComboBox extends JFrame implements ActionListener {
    JComboBox comboBox ;
    String[] animals = {"dog", "cat", "bird"};
    Frame4JComboBox () {

        comboBox = new JComboBox(animals);
        comboBox.addActionListener(this);
        // comboBox.setEditable(true);
        comboBox.addItem("horse");
        comboBox.insertItemAt("pig", 0);
        System.out.println(comboBox.getItemCount());
        comboBox.setSelectedIndex(0);
        
        add(comboBox);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
 

        pack();
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboBox) {
            int idx = comboBox.getSelectedIndex();
            System.out.println("You selected : " + comboBox.getItemAt(idx));
        }

    }
}
