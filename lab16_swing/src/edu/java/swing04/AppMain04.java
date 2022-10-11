package edu.java.swing04;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AppMain04 {

    private JFrame frame;
    private JTextField textNum1;
    private JTextField textNum2;
    private JTextArea textArea;
    private JButton btnadd;
    private JButton btnsub;
    private JButton htnmulti;
    private JButton btndivi;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain04 window = new AppMain04();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public AppMain04() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 327, 417);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNum1 = new JLabel("number1");
        lblNum1.setOpaque(true);
        lblNum1.setBackground(new Color(192, 192, 192));
        lblNum1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNum1.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblNum1.setBounds(31, 41, 120, 50);
        frame.getContentPane().add(lblNum1);
        
        JLabel lblNum2 = new JLabel("number2");
        lblNum2.setOpaque(true);
        lblNum2.setBackground(new Color(192, 192, 192));
        lblNum2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNum2.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblNum2.setBounds(31, 101, 120, 50);
        frame.getContentPane().add(lblNum2);
        
        textNum1 = new JTextField();
        textNum1.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textNum1.setBounds(163, 41, 120, 50);
        frame.getContentPane().add(textNum1);
        textNum1.setColumns(10);
        
        textNum2 = new JTextField();
        textNum2.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textNum2.setColumns(10);
        textNum2.setBounds(163, 101, 120, 50);
        frame.getContentPane().add(textNum2);
        
        btnadd = new JButton("+");
        // 파라미터 ActionEvent e: 이벤트가 발생한 컴포넌트, 이벤트의 종류 등에 대한 정보를 가지고 있는 객체.
        btnadd.addActionListener(e -> performCalculation(e));

        btnadd.setFont(new Font("D2Coding", Font.PLAIN, 30));
        btnadd.setBounds(41, 161, 50, 50);
        frame.getContentPane().add(btnadd);

        
        btnsub = new JButton("-");
        btnsub.addActionListener(e -> performCalculation(e));
        
        btnsub.setFont(new Font("D2Coding", Font.PLAIN, 30));
        btnsub.setBounds(103, 161, 50, 50);
        frame.getContentPane().add(btnsub);

        
        htnmulti = new JButton("x");
        htnmulti.addActionListener(e -> performCalculation(e));
        
        htnmulti.setFont(new Font("D2Coding", Font.PLAIN, 30));
        htnmulti.setBounds(165, 161, 50, 50);
        frame.getContentPane().add(htnmulti);
        
        btndivi = new JButton("/");
        btndivi.addActionListener(e -> performCalculation(e));
        
        btndivi.setFont(new Font("D2Coding", Font.PLAIN, 30));
        btndivi.setBounds(227, 161, 50, 50);
        frame.getContentPane().add(btndivi);

        textArea = new JTextArea();
        textArea.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textArea.setBounds(12, 236, 287, 132);
        frame.getContentPane().add(textArea);
    }
        private void performCalculation(ActionEvent e) {
            // JTextField에 입력된 문자열을 읽고, double 타입으로 변환
            String s1 = textNum1.getText();
            String s2 = textNum2.getText();
            double number1 = 0;
            double number2 = 0;
            
            try {
                number1 = Double.parseDouble(s1);
                number2 = Double.parseDouble(s2);
            } catch (NumberFormatException ex) {
                textArea.setText("number1 또는 number2는 \n숫자 타입으로 입력하세요...");
                return; // 메서드 종료
            }
            double result = 0; // 산술 연산 결과를 저장하기 위한 변수.
            String op = " ";
            
            Object source = e.getSource(); // 이벤트가 발생한 컴포넌트.
            if (source == btnadd) {
                result = number1 + number2;
                op = " + ";
            } else if (source == btnsub) {
                result = number1 - number2;
                op = " - ";
            } else if (source == htnmulti) {
                result = number1 * number2;
                op = " * ";
            } else if (source == btndivi) {
                result = number1 / number2;
                op = " / ";
            }
            String output = String.format("%f %s %f \n= %f",
                    number1, op, number2, result);
            textArea.setText(output);
        }

}
