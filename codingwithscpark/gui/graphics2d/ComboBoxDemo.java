package codingwithscpark.gui.graphics2d;

import java.awt.BorderLayout;

import javax.swing.*;
import java.awt.event.*;

public class ComboBoxDemo extends JFrame implements ActionListener, ItemListener{
    String[] animals = {"dog", "lion", "tiger"};
    JComboBox comboBox = new JComboBox(animals);
    public ComboBoxDemo() {
        
        comboBox.setEditable(true);
        comboBox.addActionListener(this);
        add(comboBox, BorderLayout.NORTH);
    
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }    
    public static void main(String[] args) {
        new ComboBoxDemo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("actionPerformed");
        JComboBox cb = (JComboBox) e.getSource();
        String name = (String) cb.getSelectedItem();
        System.out.println(name);
        String[] temp = new String[animals.length+1];
        int idx = 0;
        for (String animal : animals) {
            temp[idx++] = animal;
        }
        temp[idx++] = name;
        animals = temp;
   
        comboBox.addItem(name);
        repaint();

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        System.out.println("ItemStateChanged");

    }
}
