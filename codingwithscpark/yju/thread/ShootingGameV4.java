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


public class ShootingGameV4 extends JFrame {
    private ShootingGamePanelV4 gamePanel;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 700;
    public static final int ENEMY_NUMBER = 10;
    public static boolean started = false;
    public static int sleepTime = 10;
    public static int score = 0;

    public ShootingGameV4() {
        this.setTitle("Shooting Game");
        gamePanel = new ShootingGamePanelV4();
        this.add(gamePanel);
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        this.setVisible(true);
    }

    public static void main(String[] args) {
        ShootingGameV4 sg =  new ShootingGameV4();
    }
}

class ShootingGamePanelV4  extends JPanel implements KeyListener{
    protected static Queue<EnemyV4> enemies = new ConcurrentLinkedQueue<>();
    protected SpaceShipV4 spaceShip;
    protected static Queue<MissileV4> missiles =  new ConcurrentLinkedQueue<>();
    private Image image;
    private Graphics graphics;
    private long previousLaunchTime = System.currentTimeMillis(); // missile lauch speed control
    private static final long MINIMUM_KEYPRESS_GAP = 300L;

    public ShootingGamePanelV4() {
        this.addKeyListener(this);
        this.requestFocusInWindow();
        this.setFocusable(true);

        for (int i = 0; i < ShootingGameV4.ENEMY_NUMBER; i++) {
            EnemyV4 enemy = new EnemyV4("enemy.png");
            new Thread(enemy).start();
            enemies.add(enemy);
        }    

        spaceShip = new SpaceShipV4("spaceship.png");
        new Thread(spaceShip).start();

        startPainting();
    }

    public void startPainting() {
        new Thread() {
            public void run() {
                while(true) {
                    repaint();
                    try {
                        Thread.sleep(ShootingGameV4.sleepTime);
                    }catch(InterruptedException e) {}
                }    
            }    

        }.start();
    }

    public void paint(Graphics g) {
        image = createImage(ShootingGameV4.WIDTH, ShootingGameV4.HEIGHT);
        graphics = image.getGraphics();

        for (EnemyV4 e : enemies) {
            e.draw(graphics);
        }

        spaceShip.draw(graphics);

        // System.out.println("Number of missiles:" + missiles.size());
        for (MissileV4 m : missiles) {
            m.draw(graphics);
        }

        g.drawImage(image, 0, 0, this);
    }

    @Override
    public void keyTyped(KeyEvent e) {   }

    @Override  
    public void keyPressed(KeyEvent e) {
        spaceShip.keyPressed(e); 
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
          
            if (System.currentTimeMillis() - previousLaunchTime < MINIMUM_KEYPRESS_GAP) {
                return;
            }
            
            previousLaunchTime = System.currentTimeMillis();
        
            MissileV4 missile = new MissileV4("missile.png");
            missile.x = spaceShip.x;
            missile.y = spaceShip.y;
            missiles.add(missile);
            // System.out.println("# of missiles: " + missiles.size());
            new Thread(missile).start();
        } else if (e.getKeyCode() == KeyEvent.VK_R && ShootingGameV4.started == false) {
            for (int i = 0; i < ShootingGameV4.ENEMY_NUMBER; i++) {
                EnemyV4 enemy = new EnemyV4("enemy.png");
                new Thread(enemy).start();
                enemies.add(enemy);
            }   
            ShootingGameV4.started = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {  }
}



class GraphicObjectV4 {
    protected BufferedImage img = null;
    protected int x = 0, y = 0;

    public GraphicObjectV4(String name) {
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

class MissileV4 extends GraphicObjectV4 implements Runnable {
    protected boolean exploded = false;
    
    public MissileV4(String name) {
        super(name);
        y = -200;
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
        y -= 10;
        if (y < -100) {
            explode();
        }
    }

    public void explode() {
        exploded = true;
        ShootingGamePanelV4.missiles.remove(this);
    }

    public void run() {
        while (true) {
            update();
            if (exploded == true) {
                img = null;                
                break;
            }
            try {
                Thread.sleep(ShootingGameV4.sleepTime);
            }catch(InterruptedException e) {}
        } 
    }
}

class EnemyV4 extends GraphicObjectV4 implements Runnable {
    private Random random = new Random(System.currentTimeMillis());
    private int direction = (int) (Math.random() * 2);

    private int dx ;
    private int dy ;
    protected boolean exploded = false;
    public static final Object lock = new Object();
    
    public EnemyV4(String name) {
        super(name);
        x = ShootingGameV4.WIDTH/2;
        y = 0;
        if (direction > 0) {
            dx = random.nextInt(20) + 1;  // 오른쪽으로 이동 
        } else {
            dx = (-1)*(random.nextInt(20) + 1) ; // 왼쪽으로 이동
        }
        dy = random.nextInt(20);
    }

    public void explode() {
        exploded = true;
        ShootingGamePanelV4.enemies.remove(this);
    }

    @Override
    public void update() {
        if (x+dx <= 0) {
            dx = 10;
        }    

        if (x+dx >= ShootingGameV4.WIDTH - img.getWidth()) {
            dx = -10;
        }    

        x += dx;

        if (y+dy <= 0) {
            dy = random.nextInt(20)+1;
        } else if (y+dy >= ShootingGameV4.HEIGHT/2) {
            dy = -1 * (random.nextInt(20) + 1);
        }     
        y += dy;

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
                Thread.sleep(ShootingGameV4.sleepTime);
            }catch(InterruptedException e) {}
        }
    }

    public boolean checkCollision()  {
        // System.out.println(Thread.currentThread().getName() + " : " + exploded);
        // System.out.println("Missiles: " + ShootingGamePanelV4.missiles.size());
        synchronized(lock)  {
            boolean collision = false;
            Rectangle meR = new Rectangle(x, y, img.getWidth(), img.getHeight());
            for (int i = 0; i < ShootingGamePanelV4.missiles.size(); i++) {
                MissileV4 missile = ShootingGamePanelV4.missiles.peek();
                Rectangle missileR = new Rectangle(missile.x, missile.y, missile.getWidth(), missile.getHeight());
                if (missileR.intersects(meR)) {

                    ShootingGameV4.score++;
                    collision = true;

                    missile.explode();
                    this.explode();

                    System.out.println("Remaining enemies:" + ShootingGamePanelV4.enemies.size());
                    break;
                }
            }
        
            if (ShootingGamePanelV4.enemies.size() == 0) {
                ShootingGameV4.started = false;
                System.out.println("\nAll enemies are destroyed...");
                System.out.println("Shot down " + ShootingGameV4.score + " enemies");
                System.out.println("To start again press 'R' \n");
            } 
            return collision;
        }
    }
}

class SpaceShipV4 extends GraphicObjectV4 implements Runnable {
    public SpaceShipV4(String name) {
        super(name);
        x = ShootingGameV4.WIDTH/2;
        y = ShootingGameV4.HEIGHT - img.getHeight() - 50;
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
                Thread.sleep(ShootingGameV4.sleepTime);
            }catch(InterruptedException e) {}
        }
    }
}

