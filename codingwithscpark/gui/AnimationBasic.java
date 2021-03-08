package codingwithscpark.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

public class AnimationBasic extends JPanel implements ActionListener{
    private final int WIDTH = 500;
    private final int HEIGHT = 300;
    private final int START_X = WIDTH/2;
    private final int START_Y = HEIGHT/2;
    private BufferedImage image;
    private Timer timer;
    private int x, y;
    private int xVeolocity = 1, yVelocity = -1;

    public AnimationBasic() {
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setDoubleBuffered(true);

        File file = new File("spaceship.jpg");
        try {
            image = ImageIO.read(file);
        }catch(IOException e) {
            e.printStackTrace();
        }
        x = START_X;
        y = START_Y;

        timer = new Timer(20, this);
        timer.start();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, x, y, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if ( x >= (WIDTH-image.getWidth()) || x <= 0) {
            xVeolocity *= -1;
        }

        if (y >= (HEIGHT-image.getHeight()) || y <= 0) {
            yVelocity *= -1;
        }

        x += xVeolocity;
        y += yVelocity;

        System.out.printf("x:%d, y:%d, xVelocity:%d, yVelocity:%d\n", x, y, xVeolocity, yVelocity);

        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new AnimationBasic());
        frame.setTitle("애니메이션 테스트");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setVisible(true);
    }
}
