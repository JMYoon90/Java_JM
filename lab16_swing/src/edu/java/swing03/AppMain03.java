package edu.java.swing03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain03 {

    private JFrame frame;
    private JTextField text_name;
    private JTextField text_phone;
    private JTextField text_email;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain03 window = new AppMain03();
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
    public AppMain03() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 570, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblname = new JLabel("이    름");
        lblname.setHorizontalAlignment(SwingConstants.CENTER);
        lblname.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblname.setBounds(34, 56, 110, 60);
        frame.getContentPane().add(lblname);
        
        JLabel lblphone = new JLabel("전화번호");
        lblphone.setHorizontalAlignment(SwingConstants.CENTER);
        lblphone.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblphone.setBounds(34, 126, 110, 60);
        frame.getContentPane().add(lblphone);
        
        JLabel lblemail = new JLabel("이 메 일");
        lblemail.setHorizontalAlignment(SwingConstants.CENTER);
        lblemail.setForeground(new Color(0, 0, 0));
        lblemail.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblemail.setBounds(34, 196, 110, 60);
        frame.getContentPane().add(lblemail);
        
        text_name = new JTextField();
        text_name.setFont(new Font("D2Coding", Font.PLAIN, 20));
        text_name.setBounds(196, 56, 324, 60);
        frame.getContentPane().add(text_name);
        text_name.setColumns(10);
        
        text_phone = new JTextField();
        text_phone.setFont(new Font("D2Coding", Font.PLAIN, 20));
        text_phone.setColumns(10);
        text_phone.setBounds(196, 126, 324, 60);
        frame.getContentPane().add(text_phone);
        
        text_email = new JTextField();
        text_email.setFont(new Font("D2Coding", Font.PLAIN, 20));
        text_email.setColumns(10);
        text_email.setBounds(196, 196, 324, 60);
        frame.getContentPane().add(text_email);
        
        JButton btnInput = new JButton("입력");
        // 버튼에 이벤트 핸들러를 등록
        // 이벤트 핸들러: 이벤트가 발생됐을 때 자동으로 호출되는 메서드.
        btnInput.addActionListener((e) -> printInfo());
        
        btnInput.setFont(new Font("D2Coding", Font.PLAIN, 20));
        btnInput.setBounds(34, 298, 83, 135);
        frame.getContentPane().add(btnInput);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textArea.setBounds(129, 298, 391, 135);
        frame.getContentPane().add(textArea);
    }
    // "입력" 버튼을 클릭했을 때 실행할 내용.
    private void printInfo() {
        // JTextField에 입력된 내용을 읽음.
        String name = text_name.getText();
        String phone = text_phone.getText();
        String email = text_email.getText();
        
        // JTextArea에 출력할 문자열 만들기
        StringBuilder buffer = new StringBuilder();
        buffer.append("이름: ").append(name).append("\n")
            .append("전화번호: ").append(phone).append("\n")
            .append("이메일: ").append(email);
        // 만들어진 문자열을 JTextArea에 출력
        textArea.setText(buffer.toString());
    }
}
