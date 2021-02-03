package codingwithscpark.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;

import javax.imageio.*;

public class ImageDivideTest extends JFrame implements ActionListener {
    int pieces = 4;
    int totalPieces = pieces * pieces;
    int[] pieceNumbers = new int[totalPieces];
    BufferedImage img;
    int pieceWidth;
    int pieceHeight;

    boolean[] selectedPieces = new boolean[totalPieces];
    int selectedPiece = -1;

    public ImageDivideTest() {
        this.setTitle("Image Draw Test");

        try {
            img = ImageIO.read(new File("hubble.jpg"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        for (int i = 0; i < totalPieces; i++) {
            pieceNumbers[i] = i;
        }
        this.add(new MyImageDrawPanel(), BorderLayout.CENTER);
        JButton button = new JButton("Divide");

        button.addActionListener(this);
        this.add(button, BorderLayout.SOUTH);
        this.setSize(img.getWidth(), img.getHeight());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void shuffleImagePieces() {
        Random rand = new Random(System.currentTimeMillis());

        for (int i = 0; i < totalPieces; i++) {
            int tmp = pieceNumbers[i];
            int randIdx = rand.nextInt(totalPieces);
            pieceNumbers[i] = pieceNumbers[randIdx];
            pieceNumbers[randIdx] = tmp;
        }
        System.out.println(Arrays.toString(pieceNumbers));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        shuffleImagePieces();
        repaint();
    }

    class MyImageDrawPanel extends JPanel implements MouseListener {

        public MyImageDrawPanel() {
            this.addMouseListener(this);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            pieceWidth = img.getWidth() / pieces;
            pieceHeight = img.getHeight() / pieces;
            int idx = 0;
            for (int x = 0; x < pieces; x++) {
                int destinationX = x * pieceWidth;
                for (int y = 0; y < pieces; y++) {
                    int destinationY = y * pieceHeight;

                    int pieceNum = pieceNumbers[idx++];

                    int sourceX = (pieceNum / pieces) * pieceWidth;
                    int sourceY = (pieceNum % pieces) * pieceHeight;

                    g.drawImage(img, destinationX, destinationY, destinationX + pieceWidth, destinationY + pieceHeight,
                            sourceX, sourceY, sourceX + pieceWidth, sourceY + pieceHeight, null);

                }
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();

            int pieceNum = (x / pieceWidth) * pieces;
            pieceNum = pieceNum + (y / pieceHeight);
            System.out.println("selected Piece:" + selectedPiece);
            System.out.println("pieceNum:" + pieceNum);

            if (selectedPieces[pieceNum] == false) {

                if (selectedPiece == -1) { // first selection
                    selectedPiece = pieceNum;
                    selectedPieces[pieceNum] = true;
                } else { // 2 parts of an image are selected
                    int tmp = pieceNumbers[selectedPiece];
                    pieceNumbers[selectedPiece] = pieceNumbers[pieceNum];
                    pieceNumbers[pieceNum] = tmp;
                    selectedPieces[selectedPiece] = false;
                    selectedPiece = -1;
                    System.out.println(Arrays.toString(pieceNumbers));
                    repaint();
                }

            } else {
                selectedPieces[pieceNum] = false;
            }

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub

        }
    }

    public static void main(String[] args) {
        new ImageDivideTest();
    }

}