package codingwithscpark.gui;
import javax.swing.*;
import java.awt.*;

public class Frame4Drawing extends JFrame   {
    Panel4Drawing panel;

    Frame4Drawing() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new Panel4Drawing();
        add(panel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        Frame4Drawing frame = new Frame4Drawing();
    }

    
}
