package codingwithscpark.yju.thread;

import java.awt.image.*;
import java.awt.event.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.*;

public class ShootingGame extends JFrame {
    public ShootingGame() {
        this.setTitle("Shooting Game");
        ShootingGamePanel panel = new ShootingGamePanel();
        this.add(panel);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Thread t = new Thread(panel);
        t.start();
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new ShootingGame();
    }
}

class ShootingGamePanel  extends JPanel implements KeyListener, Runnable {
    private Enemy enemy;
    private SpaceShip spaceShip;
    private Missile missile;

    public ShootingGamePanel() {
        this.addKeyListener(this);
        this.requestFocusInWindow();
        this.setFocusable(true);

        enemy = new Enemy("enemy.png");
        spaceShip = new SpaceShip("spaceship.png");
        missile = new Missile("missile.png");
    }

    public void run() {
        while(true) {
            enemy.update();
            spaceShip.update();
            missile.update();
            repaint();
            try {
                Thread.sleep(50);
            }catch(InterruptedException e) {}
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        enemy.draw(g);
        spaceShip.draw(g);
        missile.draw(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        spaceShip.keyPressed(e);
        missile.keyPressed(e, spaceShip.x, spaceShip.y);
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
}



class GraphicObject {
    private BufferedImage img = null;
    protected int x = 0, y = 0;

    public GraphicObject(String name) {
        try {
            img = ImageIO.read(new File(name));
        }catch(IOException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public void update() {

    }

    public void draw(Graphics g) {
        g.drawImage(img, x, y, null);
    }

    public void keyPressed(KeyEvent event) {

    }
}

class Missile extends GraphicObject {
    private boolean launched = false;

    public Missile(String name) {
        super(name);
        y = -200;
    }

    @Override
    public void update() {
        if (launched) y -= 1;
        if (y < -100) launched = false;
    }

    public void keyPressed(KeyEvent event, int x, int y) {
        if (event.getKeyCode() == KeyEvent.VK_SPACE) {
            launched = true;
            this.x = x;
            this.y = y;
        }
    }
}

class Enemy extends GraphicObject {
    private int dx = -10;

    public Enemy(String name) {
        super(name);
        x = 500;
        y = 0;
    }

    @Override
    public void update() {
        x += dx;
        if (x < 0) dx = 10;
        if (x > 500) dx = -10;
    }
}

class SpaceShip extends GraphicObject {

    public SpaceShip(String name) {
        super(name);
        x = 150;
        y = 350;
    }

    public void keyPressed(KeyEvent event) {
        switch(event.getKeyCode())  {
            case KeyEvent.VK_LEFT:
                x -= 10;  break;
            case KeyEvent.VK_RIGHT :
                x += 10; break;
            case KeyEvent.VK_UP :
                y -= 10; break;
            case KeyEvent.VK_DOWN :
                y += 10; break;
            default:
        }
    } 
}

