package codingwithscpark.gui;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class MyFrame extends JFrame implements ActionListener  {
    JButton button = new JButton();
    JLabel label ;
    boolean showFace = false;
    MyFrame() {
        ImageIcon icon = new ImageIcon("thumbs-up.png");
        ImageIcon icon2 = new ImageIcon("face.jpeg");

        label = new JLabel();
        label.setIcon(icon2);
        label.setBounds(150, 250, 200, 200) ;
        label.setVisible(showFace);
        
        button.setBounds(100, 100, 250, 100);
        button.addActionListener(this);
        // button.addActionListener(e -> System.out.println("Poo"));
        button.setText("I'm a button");
       
        button.setFocusable(false);
        button.setIcon(icon);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setFont(new Font("Comic Sans", Font.BOLD, 25));
        button.setIconTextGap(5);
        button.setForeground(Color.cyan);
        button.setBackground(Color.lightGray);
        button.setBorder(BorderFactory.createEtchedBorder());
      

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);

        this.add(button);
        this.add(label);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.out.println("poo");
            showFace = !showFace;
            label.setVisible(showFace);
        }

    }
}
