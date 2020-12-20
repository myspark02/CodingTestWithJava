package codingwithscpark.gui;

import javax.swing.*;

public class Frame4DragListener extends JFrame  {

    DragPanel dragPanel = new DragPanel();

    Frame4DragListener() {
        add(dragPanel);
        setTitle("Drage & Drop Demo");
        setSize(600, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
