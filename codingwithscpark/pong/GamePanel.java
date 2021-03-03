package codingwithscpark.pong;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GamePanel extends JPanel implements Runnable {
    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int) (GAME_WIDTH * (5 / 9.0));
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    static final int BALL_DIAMETER = 20;
    static final int PADDLE_WIDTH = 25;
    static final int PADDLE_HEIGHT = 100;

    private Thread gameThread;
    private Image image;
    private Graphics graphics;
    private Random random;
    private GamePaddle paddle1;
    private GamePaddle paddle2;
    private Ball ball;
    private Score score;

    public GamePanel() {
        newPaddles();
        newBall();
        score = new Score(GAME_WIDTH, GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new MyActionListener());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void newBall() {
        random = new Random();
        // ball = new Ball(((GAME_WIDTH/2)-(BALL_DIAMETER/2)),
        // ((GAME_HEIGHT/2)-(BALL_DIAMETER/2)), BALL_DIAMETER, BALL_DIAMETER);
        ball = new Ball(((GAME_WIDTH / 2) - (BALL_DIAMETER / 2)), random.nextInt(GAME_HEIGHT - BALL_DIAMETER),
                BALL_DIAMETER, BALL_DIAMETER);
    }

    public void newPaddles() {
        paddle1 = new GamePaddle(0, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
        paddle2 = new GamePaddle(GAME_WIDTH - PADDLE_WIDTH, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2), PADDLE_WIDTH,
                PADDLE_HEIGHT, 2);
    }

    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        // draw(g);
        g.drawImage(image, 0, 0, this);
        ;
    }

    public void draw(Graphics g) {
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        score.draw(g);
    }

    public void move() {
        paddle1.move();
        paddle2.move();
        ball.move();
    }

    public void checkCollision() {
        // bounce ball off top & bottom window edges
        if (ball.y <= 0 || ball.y >= (GAME_HEIGHT - BALL_DIAMETER)) {
            ball.setYDirection(-ball.yVelocity);
        }

        // bounce ball off paddles
        if (ball.intersects(paddle1) || ball.intersects(paddle2)) {
            int org = ball.xVelocity;

            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++; // optional for more difficulty

            if (org > 0) {
                ball.xVelocity *= -1;
            }

            if (ball.yVelocity > 0)
                ball.yVelocity++; // optional for more difficulty
            else
                ball.yVelocity--;

            System.out.println("ball : xVelocity[" + ball.xVelocity + "], yVelocity[" + ball.yVelocity + "]");
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }
        // stops paddles at window edges
        if (paddle1.y <= 0)
            paddle1.y = 0;
        else if (paddle1.y >= (GAME_HEIGHT - PADDLE_HEIGHT))
            paddle1.y = GAME_HEIGHT - PADDLE_HEIGHT;

        if (paddle2.y <= 0)
            paddle2.y = 0;
        else if (paddle2.y >= (GAME_HEIGHT - PADDLE_HEIGHT))
            paddle2.y = GAME_HEIGHT - PADDLE_HEIGHT;

        // give a player 1 point and creates new paddles & ball
        if (ball.x <= 0 || ball.x >= GAME_WIDTH - BALL_DIAMETER) {
            if (ball.x <= 0) {
                score.player2++;
                System.out.println("player2:" + score.player2);
            } else {
                score.player1++;
                System.out.println("player1:" + score.player1);
            }
            newPaddles();
            newBall();

        }

    }

    public void run() {
        // game loop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;

        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                // System.out.println(delta);
                // System.out.println("now:" + now);
                move();
                checkCollision();
                repaint();
                // try {
                // Thread.currentThread().sleep(10);
                // } catch (Exception e) {
                // }
                delta--;
                // System.out.println("TEST");
            }
        }
        // while(true) {
        // try {
        // Thread.sleep(10);
        // } catch(Exception e){}
        // move();ssssww
        // checkCollision();
        // repaint();
        // }
    }

    public class MyActionListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            paddle1.keyReleased(e);
            paddle2.keyReleased(e);
        }

    }
}
