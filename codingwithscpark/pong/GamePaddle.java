package codingwithscpark.pong;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GamePaddle extends Rectangle {
    private int id;
    private int yVelocity;
    private int speed = 10;

    public GamePaddle(int x, int y, int width, int height, int id) {
        super(x, y, width, height);
        this.id = id;
    }


    public void keyPressed(KeyEvent e) {
        switch(id) {
            case 1 :
                if (e.getKeyCode() == KeyEvent.VK_W)  {
                    setYDirection(-speed);
                    move();
                } else if (e.getKeyCode() ==KeyEvent.VK_S) {
                    setYDirection(speed);
                    move();
                }
                break;
            case 2 : 
                if (e.getKeyCode() == KeyEvent.VK_UP)  {
                    setYDirection(-speed);
                    move();
                } else if (e.getKeyCode() ==KeyEvent.VK_DOWN) {
                    setYDirection(speed);
                    move();
                }
                break;
        }

    }


    public void keyReleased(KeyEvent e) {
        switch(id) {
            case 1: 
                if (e.getKeyCode() == KeyEvent.VK_W ||  e.getKeyCode() ==KeyEvent.VK_S)  {
                    setYDirection(0);
                    move();
                } 
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP ||  e.getKeyCode() ==KeyEvent.VK_DOWN)  {
                    setYDirection(0);
                    move();
                } 
                break;
            default:
        }        
    }

    public void setYDirection(int yDirection) {
        yVelocity = yDirection;
    }

    public void move() {
        y = y + yVelocity;
    }

    public void draw(Graphics g) {
        if (id == 1) {
            g.setColor(Color.blue);
        } else {
            g.setColor(Color.red);
        }
        g.fillRect(x, y, width, height);
    }
    
}
