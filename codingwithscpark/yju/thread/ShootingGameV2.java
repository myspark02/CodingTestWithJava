package codingwithscpark.yju.thread;

import java.awt.image.*;
import java.awt.event.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.*;

public class ShootingGameV2 extends JFrame {
    private ShootingGamePanelV2 gamePanel;
    public ShootingGameV2() {
        this.setTitle("Shooting Game");
        gamePanel = new ShootingGamePanelV2();
        this.add(gamePanel);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        this.setVisible(true);
    }

    public void startGame() {
        while(true) {
            gamePanel.enemy.update();
            gamePanel.spaceShip.update();
            gamePanel.missile.update();
            gamePanel.repaint();
            try {
                Thread.sleep(50);
            }catch(InterruptedException e) {}
        }
    }

    public static void main(String[] args) {
        ShootingGameV2 sg =  new ShootingGameV2();
        sg.startGame();
    }
}

class ShootingGamePanelV2  extends JPanel implements KeyListener{
    protected EnemyV2 enemy;
    protected SpaceShipV2 spaceShip;
    protected MissileV2 missile;

    public ShootingGamePanelV2() {
        this.addKeyListener(this);
        this.requestFocusInWindow();
        this.setFocusable(true);

        enemy = new EnemyV2("enemy.png");
        spaceShip = new SpaceShipV2("spaceship.png");
        missile = new MissileV2("missile.png");
    }

    public void paint(Graphics g) {
        super.paint(g);
        enemy.draw(g);
        spaceShip.draw(g);
        missile.draw(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {   }

    @Override
    public void keyPressed(KeyEvent e) {
        spaceShip.keyPressed(e);
        missile.keyPressed(e, spaceShip.x, spaceShip.y);
        
    }

    @Override
    public void keyReleased(KeyEvent e) {  }
}



class GraphicObjectV2 {
    private BufferedImage img = null;
    protected int x = 0, y = 0;

    public GraphicObjectV2(String name) {
        try {
            img = ImageIO.read(new File(name));
        }catch(IOException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public void update() { }

    public void draw(Graphics g) {
        g.drawImage(img, x, y, null);
    }

    public void keyPressed(KeyEvent event) { }
}

class MissileV2 extends GraphicObjectV2 {
    private boolean launched = false;

    public MissileV2(String name) {
        super(name);
        y = -200;
    }

    @Override
    public void update() {
        if (launched) y -= 10;
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

class EnemyV2 extends GraphicObjectV2 {
    private int dx = -10;

    public EnemyV2(String name) {
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

class SpaceShipV2 extends GraphicObjectV2 {

    public SpaceShipV2(String name) {
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

