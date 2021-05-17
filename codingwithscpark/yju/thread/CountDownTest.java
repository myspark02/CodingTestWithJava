package codingwithscpark.yju.thread;

import javax.swing.*;
import java.awt.*;

public class CountDownTest extends JFrame {

    private JLabel label;

    public CountDownTest() {
        this.setTitle("카운트다운");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Start");
        label.setFont(new Font("Serif", Font.BOLD, 100));
        this.add(label, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        CountDownTest cdt = new CountDownTest();
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }

        for (int i = 10; i >= 0; i--) {
            try {
                Thread.sleep(1000);
            }catch(InterruptedException e) {
                System.out.println(e.getMessage());
            }
            cdt.label.setText(String.valueOf(i));
        }
    }
}
