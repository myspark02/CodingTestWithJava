package codingwithscpark.pong;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Score {

    private static int GAME_WIDTH;
    private static int GAME_HEIGHT;
    protected int player1;
    protected int player2;

    public Score(int gameWidth, int gameHeight) {
        GAME_WIDTH = gameWidth;
        GAME_HEIGHT = gameHeight;
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 60));

        g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);

        g.drawString(String.valueOf(player1/10)+String.valueOf(player1%10), GAME_WIDTH/2 - 85, 50);
        g.drawString(String.valueOf(player2/10)+String.valueOf(player2%10), GAME_WIDTH/2 + 20, 50);
    }
    
}

