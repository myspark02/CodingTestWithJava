package codingwithscpark.gui;

import javax.swing.*;
import javax.swing.event.InternalFrameListener;

import java.awt.*;
import java.awt.event.*;

public class CheckBoxDemo extends JPanel implements ItemListener {
    private JCheckBox[] checkboxes = new JCheckBox[3];
    String[] friutes = {"apple", "grape", "orange"};
    JLabel[] pictureLabels = new JLabel[3];
    ImageIcon[] icons = new ImageIcon[3];

    public CheckBoxDemo() {
        this.setLayout(new GridLayout(0, 4));

        for (int i = 0; i < 3; i++) {
            checkboxes[i] = new JCheckBox(friutes[i]);
            checkboxes[i].addItemListener(this);
            pictureLabels[i] = new JLabel(friutes[i] + ".gif");
            icons[i] = new ImageIcon(friutes[i] +".gif");
        }

        JPanel checkPanel = new JPanel(new GridLayout(0, 1));
        for (int i = 0; i < 3; i++) checkPanel.add(checkboxes[i]);

        this.add(checkPanel);
        for (int i = 0; i < 3; i++) this.add(pictureLabels[i]);
    }
	@Override
	public void itemStateChanged(ItemEvent e) {
		
        Object source = e.getSource();
        for (int i = 0; i < 3; i++) {
            if (source == checkboxes[i]) {
                if (e.getStateChange() == ItemEvent.DESELECTED)
                    pictureLabels[i].setIcon(null);
                else 
                    pictureLabels[i].setIcon(icons[i]);
            }
        }
		
	}

    public static void main(String[] args) {
        JFrame frame = new JFrame("CheckBoxDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CheckBoxDemo checkboxDemoPanel = new CheckBoxDemo();
        checkboxDemoPanel.setOpaque(true);
        frame.add(checkboxDemoPanel);
        frame.setSize(500, 200);
        frame.setVisible(true);
    }
    
}
