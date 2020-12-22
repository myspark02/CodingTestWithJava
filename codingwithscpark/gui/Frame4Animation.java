package codingwithscpark.gui;

import java.awt.*;
import javax.swing.*;

public class Frame4Animation extends JFrame {

    Panel4Animation panel ;

    Frame4Animation() {
        panel = new Panel4Animation();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
}
