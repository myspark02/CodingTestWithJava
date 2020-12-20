package codingwithscpark.gui;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Main4JOptionPane {
    public static void main(String[] args) {
        /*
            JOptionPane : pop up a standard dialog box that prompts users for a value
                          or informs them of something.
        */

        // JOptionPane.showMessageDialog(null, "This is some info", "title", JOptionPane.PLAIN_MESSAGE);
        // JOptionPane.showMessageDialog(null, "This is some info", "title", JOptionPane.INFORMATION_MESSAGE);
        // JOptionPane.showMessageDialog(null, "This is some info", "title", JOptionPane.QUESTION_MESSAGE);
        // JOptionPane.showMessageDialog(null, "This is some info", "title", JOptionPane.WARNING_MESSAGE);
        // JOptionPane.showMessageDialog(null, "This is some info", "title", JOptionPane.ERROR_MESSAGE);

        // int choice = JOptionPane.showConfirmDialog(null, "do you even code?", "My Title", JOptionPane.YES_NO_CANCEL_OPTION);
        // System.out.println(choice);

        // String name = JOptionPane.showInputDialog(null,  "What is your name?:");
        // System.out.println(name);
        String[] responses = {"No", "you're awesome", "thank you", "*blush*"};
        ImageIcon icon = new ImageIcon("thumbs-up.png");
        JOptionPane.showOptionDialog(null, 
                                        "You are awesome", 
                                        "secret", 
                                        JOptionPane.YES_NO_CANCEL_OPTION, 
                                        JOptionPane.INFORMATION_MESSAGE, 
                                        icon, 
                                        responses, 0);


    }
}
