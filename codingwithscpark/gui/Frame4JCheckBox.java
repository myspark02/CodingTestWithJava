package codingwithscpark.gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame4JCheckBox extends JFrame implements ActionListener {
    JCheckBox checkBox;
    JButton button;
    ImageIcon xIcon;
    ImageIcon checkIcon;

    Frame4JCheckBox() {
        xIcon = new ImageIcon("X.png");
        checkIcon = new ImageIcon("checkMark.png");
        
        checkBox = new JCheckBox();
        checkBox.setText("I'm not a robot");
        checkBox.setFocusable(false);
        checkBox.setFont(new Font("Consolas", Font.PLAIN, 35));
        checkBox.setIcon(xIcon);
        checkBox.setSelectedIcon(checkIcon);

        button = new JButton();
        button.setText("submit");
        button.addActionListener(this);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(button);
        add(checkBox);
        
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            System.out.println(checkBox.isSelected());
        }
    }
    
}
