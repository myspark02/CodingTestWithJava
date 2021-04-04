package codingwithscpark.yju.thread;

import javax.swing.*;
import java.awt.*;

public class CarGame extends JFrame {
    private int rank = 1;

    public static void main(String[] args) {
        new CarGame();
    }

    public CarGame() {
        this.setTitle("Car Race");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        (new CarThread("car1.jpeg", 0, 0)).start();
        (new CarThread("car2.jpeg", 0, 100)).start();
        (new CarThread("car3.jpeg", 0, 200)).start();

        this.setVisible(true);
    }

    class CarThread extends Thread {
        private JLabel label;
        private int x, y;
        private String fileName;

        public CarThread(String fileName, int x, int y) {
            this.x = x;
            this.y = y;
            this.fileName = fileName;
            label = new JLabel();
            label.setIcon(new ImageIcon(fileName));
            label.setBounds(x, y, 100, 100);
            add(label);
        }

        @Override
        public void run() {
            System.out.println("Active thread count:" + Thread.activeCount());
            for (int i = 0; i < 600; i++) {
                x += 10 * Math.random();
                // x = x + (10*Math.random());
                // System.out.println("x:" + x +", y:" + y);
                label.setBounds(x, y, 100, 100);
                repaint();
                if (x >= 500) {
                    System.out.println(fileName.substring(0, fileName.indexOf(".")) + " 도착 " + (rank++) + "등!!!");
                    break;
                }
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }

}