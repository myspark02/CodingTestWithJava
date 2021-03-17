package codingwithscpark.yju.thread;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.swing.*;


public class ShootingGameV3 extends JFrame {
    private ShootingGamePanelV3 gamePanel;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 700;
    public static final int ENEMY_NUMBER = 10;
    public static boolean started = false;
    public static int sleepTime = 10;
    public static int score = 0;

    public ShootingGameV3() {
        this.setTitle("Shooting Game");
        gamePanel = new ShootingGamePanelV3();
        this.add(gamePanel);
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        this.setVisible(true);
    }

    public static void main(String[] args) {
        ShootingGameV3 sg =  new ShootingGameV3();
    }
}

class ShootingGamePanelV3  extends JPanel implements KeyListener{
    protected static Queue<EnemyV3> enemies = new ConcurrentLinkedQueue<>();
    protected SpaceShipV3 spaceShip;
    protected Queue<MissileV3> missiles =  new ConcurrentLinkedQueue<>();
    private Image image;
    private Graphics graphics;

    public ShootingGamePanelV3() {
        this.addKeyListener(this);
        this.requestFocusInWindow();
        this.setFocusable(true);

        for (int i = 0; i < ShootingGameV3.ENEMY_NUMBER; i++) {
            EnemyV3 enemy = new EnemyV3("enemy.png");
            new Thread(enemy).start();
            enemies.add(enemy);
        }    
        spaceShip = new SpaceShipV3("spaceship.png");
        new Thread(spaceShip).start();

        startPainting();
    }

    public void startPainting() {
        new Thread() {
            public void run() {
                while(true) {
                    repaint();
                    try {
                        Thread.sleep(ShootingGameV3.sleepTime);
                    }catch(InterruptedException e) {}
                }    
            }    

        }.start();
    }

    public void paint(Graphics g) {
        image = createImage(ShootingGameV3.WIDTH, ShootingGameV3.HEIGHT);
        graphics = image.getGraphics();

        for (EnemyV3 e : enemies) {
            if (e.exploded == false) e.draw(graphics);
            else enemies.remove(e);
        }

        spaceShip.draw(graphics);

        // System.out.println("Number of missiles:" + missiles.size());
        for (MissileV3 m : missiles) {
            if (m.exploded == false) m.draw(graphics);
            else missiles.remove(m);
        }

        g.drawImage(image, 0, 0, this);
    }

    @Override
    public void keyTyped(KeyEvent e) {   }

    @Override
    public void keyPressed(KeyEvent e) {
        spaceShip.keyPressed(e); 
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
           // System.out.println("missile launched");
            MissileV3 missile = new MissileV3("missile.png");
            missile.x = spaceShip.x;
            missile.y = spaceShip.y;
            missiles.add(missile);
            // System.out.println("# of missiles: " + missiles.size());
            new Thread(missile).start();
        } else if (e.getKeyCode() == KeyEvent.VK_R && ShootingGameV3.started == false) {
            for (int i = 0; i < ShootingGameV3.ENEMY_NUMBER; i++) {
                EnemyV3 enemy = new EnemyV3("enemy.png");
                new Thread(enemy).start();
                enemies.add(enemy);
            }   
            ShootingGameV3.started = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {  }
}



class GraphicObjectV3 {
    protected BufferedImage img = null;
    protected int x = 0, y = 0;

    public GraphicObjectV3(String name) {
        try {
            img = ImageIO.read(new File(name));
        }catch(IOException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public void update() { }

    public void draw(Graphics g) {
        if (img != null)
            g.drawImage(img, x, y, null);
    }

    public void keyPressed(KeyEvent event) { }
}

class MissileV3 extends GraphicObjectV3 implements Runnable {
    public static Object lock = new Object();
    protected boolean exploded = false;
    
    public MissileV3(String name) {
        super(name);
        y = -200;
    }

    @Override
    public void update() {
        y -= 10;
        if (y < -100) {
            exploded = true;
        }
    }

    public boolean checkCollision()  {
        synchronized(lock)  {
            boolean collision = false;
            Rectangle meR = new Rectangle(x, y, img.getWidth(), img.getHeight());
            for (int i = 0; i < ShootingGamePanelV3.enemies.size(); i++) {
                EnemyV3 enemy = ShootingGamePanelV3.enemies.peek();
                Rectangle enemyR = new Rectangle(enemy.x, enemy.y, enemy.getWidth(), enemy.getHeight());
                if (enemyR.intersects(meR)) {
                    // System.out.println("Missile shot down an enemy...");

                    ShootingGameV3.score++;
                    collision = true;
                    enemy.explode();
                    ShootingGamePanelV3.enemies.remove(enemy);
                    System.out.println("Remaining enemies:" + ShootingGamePanelV3.enemies.size());
                    exploded = true;
                }
            }
        
            
            if (ShootingGamePanelV3.enemies.size() == 0) {
                ShootingGameV3.started = false;
                System.out.println("\nAll enemies are destroyed...");
                System.out.println("Shot down " + ShootingGameV3.score + " enemies");
                System.out.println("To start again press 'R' \n");
            } 
            return collision;
        }
    }

    public void run() {
        while (true) {
            update();
            checkCollision();
            if (exploded == true) {
                img = null;                
                break;
            }
            try {
                Thread.sleep(ShootingGameV3.sleepTime);
            }catch(InterruptedException e) {}
        } 
    }
}

class EnemyV3 extends GraphicObjectV3 implements Runnable {
    private int dx = -10;
    private int dy = 10;
    protected boolean exploded = false;
    public EnemyV3(String name) {
        super(name);
        x = ShootingGameV3.WIDTH/2;
        y = 0;
    }

    public void explode() {
        exploded = true;
       // System.out.println("I got a Missile...");
    }

    public int getWidth() {
        if (img == null) return 0;
        return img.getWidth();
    }  

    public int getHeight() {
        if (img == null) return 0;
        return img.getHeight();
    }

    @Override
    public void update() {
        if (x+dx < 0) dx = 10;
        if (x+dx > ShootingGameV3.WIDTH - img.getWidth()) dx = -10;
        x += dx;

        if (y+dy < 0) {
            dy = (int)(Math.random()*10);
        } else if (y+dy > ShootingGameV3.HEIGHT/2) {
            dy = -1 * (int)(Math.random()*10);
        }     
        y += dy;

    }

    public void run() {
        while (true) {
            update();
            if (exploded == true) {
                img = null;
                
                break;
            } 
            try {
                Thread.sleep(ShootingGameV3.sleepTime);
            }catch(InterruptedException e) {}
        }
    }
}

class SpaceShipV3 extends GraphicObjectV3 implements Runnable {
    public SpaceShipV3(String name) {
        super(name);
        x = ShootingGameV3.WIDTH/2;
        y = ShootingGameV3.HEIGHT - img.getHeight() - 50;
    }

    public void keyPressed(KeyEvent event) {
        switch(event.getKeyCode())  {
            case KeyEvent.VK_LEFT:
                x -= 20;  break;
            case KeyEvent.VK_RIGHT :
                x += 20; break;
            case KeyEvent.VK_UP :
                y -= 20; break;
            case KeyEvent.VK_DOWN :
                y += 20; break;
            default:
        }
    } 

    public void run() {
        while (true) {
            update();
            try {
                Thread.sleep(ShootingGameV3.sleepTime);
            }catch(InterruptedException e) {}
        }
    }
}

