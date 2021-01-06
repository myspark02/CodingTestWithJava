package codingwithscpark.yju.login;

import java.awt.Font;

import javax.swing.*;

public class WelcomePage {
    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel("Hello!");

    public WelcomePage(String userID) {
        
        welcomeLabel.setBounds(0, 0, 200, 35);
        welcomeLabel.setFont(new Font(null, Font.PLAIN|Font.BOLD, 25));
        welcomeLabel.setText("Hello " + userID);
        
        frame.add(welcomeLabel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

    }

}
