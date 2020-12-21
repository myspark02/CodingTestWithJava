package codingwithscpark.gui;

import javax.swing.*;
import java.awt.*;

public class Panel4Drawing extends JPanel {
    Image img ;
    Panel4Drawing() {
        img = new ImageIcon("face.jpeg").getImage();
        setPreferredSize(new Dimension(800, 500));
    }

    public void paint(Graphics g) {
        System.out.println("paint called...");
        Graphics2D g2D = (Graphics2D)g;

        g2D.drawImage(img, 0, 0, null);
        
        g2D.setPaint(Color.blue);
        g2D.setStroke(new BasicStroke(5));
        g2D.drawLine(0, 0, 800, 500);
        g2D.drawRect(0, 0, 100, 200);
        g2D.fillRect(0, 0, 100, 200);

        g2D.setPaint(Color.orange);
        g2D.drawOval(0, 0, 100, 100);
        g2D.fillOval(0, 0, 100, 100);

        g2D.setPaint(Color.red);
        g2D.drawArc(0, 0, 100, 100, 0, 180);
        g2D.fillArc(0, 0, 100, 100, 0, 180);
        
        g2D.setPaint(Color.white);
        g2D.fillArc(0, 0, 100, 100, 180, 180);

        g2D.setPaint(Color.yellow);
        int[] xPoints = {150, 250, 350};
        int[] yPoints = {300, 150, 300};
        g2D.drawPolygon(xPoints, yPoints, 3);

        g2D.setPaint(Color.MAGENTA);
        g2D.setFont(new Font("Ink Free", Font.BOLD, 50));
        g2D.drawString("U R A WINNER", 300, 200);  // coordinates of bottom left corner of a string

      

    
    
        // g.drawLine(0, 0, 500, 500);
    }
    
}
