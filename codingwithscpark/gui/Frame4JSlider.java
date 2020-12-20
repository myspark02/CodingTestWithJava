package codingwithscpark.gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;

public class Frame4JSlider extends JFrame implements ChangeListener {
    JSlider slider; 
    JPanel panel;
    JLabel label;

    Frame4JSlider() {
        super("Slider Demo");
        panel = new JPanel();

        label = new JLabel();
         
        slider = new JSlider(0, 100, 50); // minimum, maximum, starting point
        slider.setPreferredSize(new Dimension(400, 200));

        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);

        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(25);

        slider.setPaintLabels(true);
        slider.setFont(new Font("MV Boli", Font.PLAIN, 15));
        
        slider.setOrientation(SwingConstants.VERTICAL);
        // slider.setOrientation(SwingConstants.HORIZONTAL);
        slider.addChangeListener(this);

        label.setFont(new Font("MV Boli", Font.PLAIN, 25)); 
        label.setText("°C = "  + slider.getValue());

        panel.add(slider);
        panel.add(label);

        add(panel);
        setSize(420, 420);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        label.setText("°C = "  + slider.getValue());
    }

}
