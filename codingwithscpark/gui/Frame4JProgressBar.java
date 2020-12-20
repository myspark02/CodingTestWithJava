package codingwithscpark.gui;

import javax.swing.*;

import java.awt.*;


public class Frame4JProgressBar {

    JFrame frame = new JFrame();
    JProgressBar bar = new JProgressBar(0, 500); // minimum, maximum;

    Frame4JProgressBar() {
        bar.setBounds(0, 0, 420, 50); // height is not applied, don't know why
        bar.setStringPainted(true);
        bar.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        bar.setForeground(Color.red); // forground setting is not working.
        bar.setBackground(Color.BLACK); // background setting is not working.

        frame.add(bar);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

        fill();
    }

    private void fill() {
        int counter = 500;
        while(counter > 0) {
            bar.setValue(counter);
            try {
                Thread.sleep(50);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }    
            counter -= 1;
        }
        bar.setString("Done! :)");
    }

}
