package codingwithscpark.gui;

import javax.swing.*;
import java.awt.*;

public class Main4JLayeredPane {
    public static void main(String[] args) {    
        /*
            JLayeredPane : Swing container that provides a
                           third dimension for positioning components
                           ex. depth, z-index
        */
        JLabel label1 = new JLabel();
        label1.setOpaque(true);
        label1.setBackground(Color.red);
        label1.setBounds(50, 50, 200, 200);

        JLabel label2 = new JLabel();
        label2.setOpaque(true);
        label2.setBackground(Color.green);
        label2.setBounds(100, 100, 200, 200);

        JLabel label3 = new JLabel();
        label3.setOpaque(true);
        label3.setBackground(Color.blue);
        label3.setBounds(150, 150, 200, 200);

        // 0 Default, 100 Pallette, 200 Modal, 300 PopUp, 400 Drag
        JLayeredPane layeredPane = new JLayeredPane(); 
        layeredPane.setBounds(0, 0, 500, 500);

        layeredPane.add(label1, JLayeredPane.DEFAULT_LAYER);
        // layeredPane.add(label2, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(label3, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(label2, Integer.valueOf(200)); // 200은 효과가 없는데, Integer.valueOf(200)은 효과가 있네... 왜?
        
        

        JFrame frame = new JFrame("JLayeredPane");
        frame.add(layeredPane);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 500));
        frame.setLayout(null);


        frame.setVisible(true);

    }
}
