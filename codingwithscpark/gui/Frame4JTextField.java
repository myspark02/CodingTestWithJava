package codingwithscpark.gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Frame4JTextField extends JFrame implements ActionListener {
    JButton button;
    JTextField textField;
    Frame4JTextField() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        button = new JButton("Submit");
        button.addActionListener(this);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250, 40));
        textField.setFont(new Font("c", Font.PLAIN, 35));
        textField.setForeground(Color.green);
        textField.setBackground(Color.black);
        textField.setCaretColor(Color.white);
        textField.setText("user name");

        add(button);
        add(textField);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() ==  button) {
            String txt = textField.getText();
            System.out.println(txt);
       }

    }
    
}
