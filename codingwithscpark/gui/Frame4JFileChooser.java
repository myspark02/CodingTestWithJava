package codingwithscpark.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class Frame4JFileChooser extends JFrame implements ActionListener {
    JButton button ;

    Frame4JFileChooser() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        button = new JButton("Select File");
        button.addActionListener(this);

        add(button);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            
            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setCurrentDirectory(new File("."));

            int response = fileChooser.showOpenDialog(null); // select file to open
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                System.out.println("Select File : " + file.getName());
            }
            
        }

    }
    
}
