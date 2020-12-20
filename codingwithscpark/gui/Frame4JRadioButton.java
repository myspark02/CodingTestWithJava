package codingwithscpark.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame4JRadioButton extends JFrame implements ActionListener{
    JRadioButton pizzaButton ;
    JRadioButton hamburgerButton ;
    JRadioButton hotdogButton ;
    JButton button;
    ButtonGroup group;

    Frame4JRadioButton() {
        pizzaButton = new JRadioButton("pizza");
        hamburgerButton = new JRadioButton("hamburger");
        hotdogButton = new JRadioButton("hotdog");
        
        // pizzaButton.addActionListener(this);
        // hamburgerButton.addActionListener(this);
        // hotdogButton.addActionListener(this);

        button = new JButton("Order");
        button.addActionListener(this);

        group = new ButtonGroup();
        group.add(pizzaButton);
        group.add(hamburgerButton);
        group.add(hotdogButton);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(pizzaButton);
        add(hamburgerButton);
        add(hotdogButton);

        add(button);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            if (pizzaButton.isSelected()) {
                System.out.println("You ordered pizza");
            } else if (hamburgerButton.isSelected()) {
                System.out.println("You ordered hamburger");
            } else if (hotdogButton.isSelected()) {
                System.out.println("You ordered hotdog");
            }
        }
        // if (e.getSource() == pizzaButton) {
        //     System.out.println("You ordered pizza");
        // } else if (e.getSource() == hamburgerButton) {
        //     System.out.println("You ordered hamburger");
        // } else if (e.getSource() == hotdogButton) {
        //     System.out.println("You ordered hotdog");
        // }
    }
}
