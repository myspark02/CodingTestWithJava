package codingwithscpark.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class ScreenCaptureDemo implements ActionListener {

    private JButton btnCapture = new JButton("Capture");
    private JFrame captureFrame = new JFrame();
    Dimension d = new Dimension(700, 700);

    CapturePanel panel;
    Robot robot;
    Rectangle rectangle = new Rectangle(700, 700);

    public ScreenCaptureDemo() {
        btnCapture.addActionListener(this);

        captureFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        captureFrame.setSize(d);

        captureFrame.add(btnCapture, BorderLayout.SOUTH);
        panel = new CapturePanel();
        captureFrame.getContentPane().add(panel, BorderLayout.CENTER);
        captureFrame.setVisible(true);
    }

    private void captureScreen() {

        try {
            robot = new Robot();
            panel.image = robot.createScreenCapture(rectangle);
            panel.image.flush();
            panel.setOpaque(false);
            panel.prepareImage(panel.image, panel);
            panel.repaint();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ScreenCaptureDemo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("capture button clicked...");
        captureScreen();
    }

    class CapturePanel extends JPanel {

        BufferedImage image;

        public void paintComponent(Graphics g) {
            g.drawImage(image, 0, 0, d.width, d.height, this);
        }
    }
}
