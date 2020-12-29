package codingwithscpark.yju.wdb.snake;

import javax.swing.*;

public class GameFrame extends JFrame {
    GameFrame() {
        GamePanel panel = new GamePanel();

        add(panel);
        setTitle("Snake");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
