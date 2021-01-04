package codingwithscpark.yju;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButtion;
    JButton decButton, equButton, delButton, clrButton, negButton;

    JPanel panel;

    Font myFont = new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 30);
    double num1 = 0, num2=0, result = 0;
    char operator;

    public Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        functionButtons[0] = addButton = new JButton("+");
        functionButtons[1] = subButton = new JButton("-");
        functionButtons[2] = mulButton = new JButton("*");
        functionButtons[3] = divButtion = new JButton("/");
        functionButtons[4] = decButton = new JButton(".");
        functionButtons[5] = equButton = new JButton("=");
        functionButtons[6] = delButton = new JButton("Delete");
        functionButtons[7] = clrButton = new JButton("Clear");
        functionButtons[8] = negButton = new JButton("(-)");

        for (int i = 0; i < functionButtons.length; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);
  

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        // panel.setBackground(Color.gray);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);

        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButtion);

        frame.add(panel);

        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);

        frame.setLocationRelativeTo(null);

        frame.add(textField);


        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       for (int i = 0; i < numberButtons.length; i++) {
           if (e.getSource() == numberButtons[i]) {
               textField.setText(textField.getText().concat(String.valueOf(i)));
           }
       }

       if (e.getSource() == decButton) {
           textField.setText(textField.getText().concat("."));
       } else if (e.getSource() == addButton || e.getSource() == subButton ||
                                e.getSource() == mulButton || e.getSource() == divButtion) {
            num1 = Double.parseDouble(textField.getText());
            operator = ((JButton)(e.getSource())).getText().charAt(0);                                    
            textField.setText("");
       } else if (e.getSource() == equButton) {
           num2 = Double.parseDouble(textField.getText());
           switch(operator) {
               case '+' :
                    result = num1 + num2;
                    break;
                case '-' :
                    result = num1 - num2;
                    break;
                case '*' :
                    result = num1 * num2;
                    break;
                case '/' :
                    result = num1 / num2;
                    break;      
                default:      
            }  
            textField.setText(String.valueOf(result));   
            num1 = result;           
        } else if (e.getSource() == clrButton) {
            textField.setText("");
        } else if (e.getSource() == delButton) {
            String str = textField.getText();
            if (str.length() > 0)
                textField.setText(str.substring(0, str.length()-1));
        } else if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp = (-1)*temp;
            textField.setText(String.valueOf(temp));
        }
    }
}
