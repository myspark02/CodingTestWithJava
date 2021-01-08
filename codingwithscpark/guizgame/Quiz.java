package codingwithscpark.guizgame;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class Quiz implements ActionListener {
    private String[] questions = {
                    "Which company created Java?", 
                    "Which year was Java created?",
                    "What was Java originally called?", 
                    "Who is credited with creating Java?"
    };
    
    private String[][] options = {
                    {"Sun Microsystems", "Starbucks", "Microsoft", "Alphabet"}, 
                    {"1989", "1996", "1972", "1492"},
                    {"Apple", "Latte", "Oak", "Koffing"},
                    {"Steve Jobs", "Bill Gates", "James Gosling", "Mark Zuckerburg"}
    };
    private char[] answers = {'A', 'B', 'C', 'C'};

    private char guess;
    private char answer;
    private int index;
    private int correctGuesses = 0;
    private int totalQuestions = questions.length;
    private int seconds = 10;

    private JFrame frame = new JFrame();
    private JTextField textField = new JTextField();
    private JTextArea textArea = new JTextArea();
    private JButton buttonA = new JButton();
    private JButton buttonB = new JButton();
    private JButton buttonC = new JButton();
    private JButton buttonD = new JButton();
    private JLabel answerLabelA = new JLabel();
    private JLabel answerLabelB = new JLabel();
    private JLabel answerLabelC = new JLabel();
    private JLabel answerLabelD = new JLabel();
    private JLabel timeLabel = new JLabel();
    private JLabel secondsLeft = new JLabel();
    private JTextField numberRight = new JTextField();
    private JTextField percentage = new JTextField();


    public Quiz() {

    }

     public void nextQuestion() {

     }

     @Override
     public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub

     }

     public void displayAnswer() {

     }

     public void results() {

     }
}
