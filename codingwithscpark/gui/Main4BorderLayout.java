package codingwithscpark.gui;

import java.awt.*;

import javax.swing.*;

public class Main4BorderLayout {
    public static void main(String[] args) {
        // Layout Manager : Defines the natural layout for components within a container
        // 3 common managers
        // BorderLayout : A BorderLayout places components in five areas : NORTH, SOUTH, WEST, EAST, CENTER
        //                All extra space is placed in the center area.

        // testLayout01();
        testLayout02();

    }
    private static void testLayout02() {
        JFrame frame = new JFrame();
        // frame.setLayout(new BorderLayout());
        frame.setLayout(new BorderLayout(10, 10)); // margin between components : left&right, top&bottom
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 500));

        
        JPanel nPanel = new JPanel();
        JPanel ePanel = new JPanel();
        JPanel sPanel = new JPanel();
        JPanel wPanel = new JPanel();
        JPanel cPanel = new JPanel();


        nPanel.setBackground(Color.red);
        ePanel.setBackground(Color.yellow);
        sPanel.setBackground(Color.pink);
        wPanel.setBackground(Color.magenta);
        cPanel.setBackground(Color.blue);


        cPanel.setLayout(new BorderLayout());

        nPanel.setPreferredSize(new Dimension(100, 100));
        ePanel.setPreferredSize(new Dimension(100, 100));
        sPanel.setPreferredSize(new Dimension(100, 100));
        wPanel.setPreferredSize(new Dimension(100, 100));
        cPanel.setPreferredSize(new Dimension(100, 100));

        JPanel subNPanel = new JPanel();
        JPanel subEPanel = new JPanel();
        JPanel subSPanel = new JPanel();
        JPanel subWPanel = new JPanel();
        JPanel subCPanel = new JPanel();

        subNPanel.setBackground(Color.black);
        subEPanel.setBackground(Color.darkGray);
        subSPanel.setBackground(Color.gray);
        subWPanel.setBackground(Color.lightGray);
        subCPanel.setBackground(Color.white);

        subNPanel.setPreferredSize(new Dimension(50, 50));
        subEPanel.setPreferredSize(new Dimension(50, 50));
        subSPanel.setPreferredSize(new Dimension(50, 50));
        subWPanel.setPreferredSize(new Dimension(50, 50));
        subCPanel.setPreferredSize(new Dimension(50, 50));

        cPanel.add(subNPanel, BorderLayout.NORTH);
        cPanel.add(subEPanel, BorderLayout.EAST);
        cPanel.add(subSPanel, BorderLayout.SOUTH);
        cPanel.add(subWPanel, BorderLayout.WEST);
        cPanel.add(subCPanel, BorderLayout.CENTER);

        frame.add(nPanel, BorderLayout.NORTH);
        frame.add(ePanel, BorderLayout.EAST);
        frame.add(sPanel, BorderLayout.SOUTH);
        frame.add(wPanel, BorderLayout.WEST);
        frame.add(cPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private static void testLayout01() {
        JFrame frame = new JFrame();
        // frame.setLayout(new BorderLayout());
        frame.setLayout(new BorderLayout(10, 10)); // margin between components : left&right, top&bottom
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 500));
        frame.setVisible(true);
        
        JPanel nPanel = new JPanel();
        JPanel ePanel = new JPanel();
        JPanel sPanel = new JPanel();
        JPanel wPanel = new JPanel();
        JPanel cPanel = new JPanel();

        nPanel.setBackground(Color.red);
        ePanel.setBackground(Color.yellow);
        sPanel.setBackground(Color.pink);
        wPanel.setBackground(Color.magenta);
        cPanel.setBackground(Color.blue);

        nPanel.setPreferredSize(new Dimension(100, 100));
        ePanel.setPreferredSize(new Dimension(100, 100));
        sPanel.setPreferredSize(new Dimension(100, 100));
        wPanel.setPreferredSize(new Dimension(100, 100));
        cPanel.setPreferredSize(new Dimension(100, 100));

        frame.add(nPanel, BorderLayout.NORTH);
        frame.add(ePanel, BorderLayout.EAST);
        frame.add(sPanel, BorderLayout.SOUTH);
        frame.add(wPanel, BorderLayout.WEST);
        frame.add(cPanel, BorderLayout.CENTER);
    }
    
}
