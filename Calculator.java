package com.chenzfall.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    JFrame frame;

    JTextField textField;

    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton;

    JPanel panel;

    Font font = new Font("Tahoma", Font.PLAIN, 20);

    double num1 = 0, num2 = 0, result = 0;
    String operator;
    boolean status = true;
    Calculator(){
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(new ImageIcon("calculator.png").getImage());
        frame.setSize(420,550);
        frame.setLayout(null);
        frame.setVisible(true);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(font);
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("C");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for (int i = 0; i < functionButtons.length; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font);
            functionButtons[i].setFocusable(false);
        }
        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(font);
            numberButtons[i].setFocusable(false);

        }
        delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430, 145, 50);

        JPanel panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,2,2));
        panel.setBackground(Color.gray);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(functionButtons[0]);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(functionButtons[1]);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(functionButtons[2]);
        panel.add(functionButtons[4]);
        panel.add(numberButtons[0]);
        panel.add(functionButtons[5]);
        panel.add(functionButtons[3]);

        frame.add(textField);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(panel);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]){
                textField.setText(textField.getText() + i);
            }
        }
        if (e.getSource() == decButton){
            textField.setText(textField.getText() + '.');
        }
        if (e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = addButton.getText();
            textField.setText("");
        }
        if (e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = subButton.getText();
            textField.setText("");
        }
        if (e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = mulButton.getText();
            textField.setText("");
        }
        if (e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = divButton.getText();
            textField.setText("");
        }
        if (e.getSource() == equButton){
            num2 = Double.parseDouble(textField.getText());
            result = calculator(operator, num1, num2);
            textField.setText("");
            textField.setText(Double.toString(result));
        }
        if (e.getSource() == clrButton){
            textField.setText("");
        }
        if (e.getSource() == delButton){
            textField.setText(textField.getText().substring(0,textField.getText().length()-1));
        }
//        for (int i = 0; i < 10 ; i++) {
//            if  (e.getSource() == numberButtons[i]){
//                if(status) textField.setText(textField.getText() + i);
//                else {
//                    textField.setText("");
//                    textField.setText(textField.getText() + i);
//                }
//                if (operator == null){
//                    num1 = Double.parseDouble(textField.getText());
//                } else
//                    num2 = Double.parseDouble(textField.getText());
//            }
//        }
//        for (int i = 0; i < 8; i++) {
//            if (e.getSource() == functionButtons[5]){
//                if (operator == null){
//                    textField.setText(textField.getText());
//                } else {
//                    result = calculator(operator, num1, num2);
//                    textField.setText(Double.toString(result));
//                    num1 = 0;
//                    num2 = 0;
//                    operator = null;
//                    status = false;
//                }
//            } else if (e.getSource() == functionButtons[i]){
//                operator = functionButtons[i].getText();
//                if (!status){
//                    num1 = result;
//                }
//                //for num2:
//                textField.setText("");
//            }
//        }
//        if (e.getSource() == delButton){
//            int length = textField.getText().length();
//            StringBuilder text = new StringBuilder(textField.getText());
//            String store = text.deleteCharAt(length-1).toString();
//            textField.setText(store);
//
//        }else if (e.getSource() == clrButton){
//            textField.setText("");
//            num1 = 0;
//            num2 = 0;
//            operator = null;
//            status = true;
//        }
    }
    public double calculator(String operator, double num1, double num2){
        switch (operator){
            case "+" -> num1+=num2;
            case "-" -> num1-=num2;
            case "x" -> num1*=num2;
            case "/" -> num1/=num2;
        }
        return num1;
    }
    public static void main(String[] args) {
        new Calculator();
    }
}
