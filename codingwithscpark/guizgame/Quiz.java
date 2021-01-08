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

    private Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            secondsLeft.setText(String.valueOf(seconds));
            if (seconds <= 0) {
                displayAnswer();
            }
        }
    });


    public Quiz() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(null);
        frame.setResizable(false);

        textField.setBounds(0, 0, 650, 50);
        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setEditable(false);

        textArea.setBounds(0, 50, 650, 50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(25, 25, 25));
        textArea.setForeground(new Color(25, 255, 0));
        textArea.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);

        buttonA.setBounds(0, 100, 100, 100);
        buttonA.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(0, 200, 100, 100);
        buttonB.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0, 300, 100, 100);
        buttonC.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0, 400, 100, 100);
        buttonD.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);   
        buttonD.setText("D");     

        answerLabelA.setBounds(125, 100, 500, 100);
        answerLabelA.setBackground(new Color(50, 50, 50));
        answerLabelA.setForeground(new Color(25, 250, 25));
        answerLabelA.setFont(new Font(Font.SERIF, Font.PLAIN, 35));

        answerLabelB.setBounds(125, 200, 500, 100);
        answerLabelB.setBackground(new Color(50, 50, 50));
        answerLabelB.setForeground(new Color(25, 250, 25));
        answerLabelB.setFont(new Font(Font.SERIF, Font.PLAIN, 35));

        answerLabelC.setBounds(125, 300, 500, 100);
        answerLabelC.setBackground(new Color(50, 50, 50));
        answerLabelC.setForeground(new Color(25, 250, 25));
        answerLabelC.setFont(new Font(Font.SERIF, Font.PLAIN, 35));

        answerLabelD.setBounds(125, 400, 500, 100);
        answerLabelD.setBackground(new Color(50, 50, 50));
        answerLabelD.setForeground(new Color(25, 250, 25));
        answerLabelD.setFont(new Font(Font.SERIF, Font.PLAIN, 35));

        secondsLeft.setBounds(535, 510, 100, 100);
        secondsLeft.setBackground(new Color(25, 25, 25));
        secondsLeft.setForeground(new Color(255, 0, 0));
        secondsLeft.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 60));
        secondsLeft.setBorder(BorderFactory.createBevelBorder(1));
        secondsLeft.setOpaque(true);
        secondsLeft.setHorizontalAlignment(SwingConstants.CENTER);
        secondsLeft.setText(String.valueOf(seconds));

        timeLabel.setBounds(535, 475, 100, 25);
        timeLabel.setBackground(new Color(50, 50, 50));
        timeLabel.setForeground(new Color(255, 0, 0));
        timeLabel.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setText("timer >:D");
        
        numberRight.setBounds(225, 225, 200, 100);
        numberRight.setBackground(new Color(25, 25, 25));
        numberRight.setForeground(new Color(25, 255, 0));
        numberRight.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
        numberRight.setBorder(BorderFactory.createBevelBorder(1));
        numberRight.setHorizontalAlignment(SwingConstants.CENTER);
        numberRight.setEditable(false);

        percentage.setBounds(225, 325, 200, 100);
        percentage.setBackground(new Color(25, 25, 25));
        percentage.setForeground(new Color(25, 255, 0));
        percentage.setFont(new Font(Font.SERIF, Font.BOLD, 50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(SwingConstants.CENTER);
        percentage.setEditable(false);

        // frame.add(percentage);
        // frame.add(numberRight);
        frame.add(timeLabel);
        frame.add(secondsLeft);
        frame.add(answerLabelA);
        frame.add(answerLabelB);
        frame.add(answerLabelC);
        frame.add(answerLabelD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);

        frame.add(textArea);
        frame.add(textField);

        frame.setVisible(true);

        nextQuestion();

    }

     public void nextQuestion() {
        if (index >= totalQuestions) {
            results();
        }else {
            textField.setText("Question " + (index+1));
            textArea.setText(questions[index]);
            answerLabelA.setText(options[index][0]);
            answerLabelB.setText(options[index][1]);
            answerLabelC.setText(options[index][2]);
            answerLabelD.setText(options[index][3]);

            timer.start();
        }
     }

     @Override
     public void actionPerformed(ActionEvent e) {       
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (e.getSource() == buttonA) {
            answer = 'A';
        } else if (e.getSource() == buttonB) {
            answer = 'B';
        } else if (e.getSource() == buttonC) {
            answer = 'C';
        } else if (e.getSource() == buttonD) {
            answer = 'D';
        }

        if (answers[index] == answer) {
            correctGuesses++;
        }
        displayAnswer();

     }

     public void displayAnswer() {
        timer.stop();

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (answers[index] != 'A')
            answerLabelA.setForeground(new Color(255, 0, 0));
        if (answers[index] != 'B')
            answerLabelB.setForeground(new Color(255, 0, 0));
        if (answers[index] != 'C')
            answerLabelC.setForeground(new Color(255, 0, 0));
        if (answers[index] != 'D')
            answerLabelD.setForeground(new Color(255, 0, 0));

        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerLabelA.setForeground(new Color(25, 255, 0));
                answerLabelB.setForeground(new Color(25, 255, 0));
                answerLabelC.setForeground(new Color(25, 255, 0));
                answerLabelD.setForeground(new Color(25, 255, 0));

                answer = ' ';
                seconds = 10;
                secondsLeft.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();
            }
        });
        pause.setRepeats(false); // make timer execute only once
        pause.start();
     }

     public void results() {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        int result = (int)((correctGuesses/(double)totalQuestions)*100);
        textField.setText("RESULTS!");
        textArea.setText("");
        answerLabelA.setText("");
        answerLabelB.setText("");
        answerLabelC.setText("");
        answerLabelD.setText("");

        numberRight.setText(String.valueOf("("+correctGuesses)+"/"+totalQuestions+")");
        percentage.setText(String.valueOf(result)+"%");

        frame.add(numberRight);
        frame.add(percentage);

     }
}
