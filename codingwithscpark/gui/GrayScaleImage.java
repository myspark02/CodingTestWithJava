package codingwithscpark.gui;

import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.imageio.*;
import javax.swing.*;

import java.io.*;

public class GrayScaleImage extends JFrame implements java.awt.event.ActionListener {
    private BufferedImage image;
    private int imageWidth;
    private int imageHeight;
    private BufferedImage grayImage;
    private JButton grayBtn;
    private boolean gray = false;

    public GrayScaleImage() {
        try {
            File file = new File("Lenna.png");
            image = ImageIO.read(file);
            grayImage = ImageIO.read(file);

            imageWidth = image.getWidth();
            imageHeight = image.getHeight();

            for (int r = 0; r < imageHeight; r++) {
                for (int c = 0; c < imageWidth; c++) {
                    Color color = new Color(image.getRGB(r, c));

                    int red = color.getRed();
                    int green = color.getGreen();
                    int blue = color.getBlue();

                    int avg = (red + green + blue) / 3;
                    Color newColor = new Color(avg, avg, avg);

                    grayImage.setRGB(r, c, newColor.getRGB());
                }
            }
            JPanel panel = new ImageViewPanel();
            this.add(panel);

            grayBtn = new JButton("Convert to gray image");
            this.add(grayBtn, BorderLayout.SOUTH);
            grayBtn.setFont(new Font(Font.SERIF, Font.BOLD, 20));
            grayBtn.addActionListener(this);
            // this.setSize(image.getWidth(), image.getHeight());
            this.pack();
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("이미지 읽기 실패.");
        }
    }

    class ImageViewPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            if (gray)
                g.drawImage(grayImage, 0, 0, null);
            else
                g.drawImage(image, 0, 0, null);

        }

        @Override
        public Dimension getPreferredSize() {
            if (image == null) {
                return new Dimension(100, 100);
            } else {
                return new Dimension(image.getWidth(), image.getHeight());
            }
        }
    }

    public static void main(String[] args) {
        new GrayScaleImage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gray == false) {
            gray = true;
            grayBtn.setText("원본보기");
        } else {
            gray = false;
            grayBtn.setText("Convert to gray image");
        }
        repaint();

    }

}
