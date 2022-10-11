package edu.java.swing10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AppMain10 {
    private static final String[] COLUMN_NAMES = {"국어","영어","수학","총점","평균"};

    private JFrame frame;
    private JTextField textKorean;
    private JTextField textEnglish;
    private JTextField textMath;
    private JTable table;
    private DefaultTableModel model;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain10 window = new AppMain10();
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
    public AppMain10() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 405, 543);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        textKorean = new JTextField();
        textKorean.setFont(new Font("D2Coding", Font.PLAIN, 18));
        textKorean.setBounds(174, 10, 200, 50);
        frame.getContentPane().add(textKorean);
        textKorean.setColumns(10);
        
        textEnglish = new JTextField();
        textEnglish.setFont(new Font("D2Coding", Font.PLAIN, 18));
        textEnglish.setColumns(10);
        textEnglish.setBounds(174, 70, 200, 50);
        frame.getContentPane().add(textEnglish);
        
        textMath = new JTextField();
        textMath.setFont(new Font("D2Coding", Font.PLAIN, 18));
        textMath.setColumns(10);
        textMath.setBounds(174, 130, 200, 50);
        frame.getContentPane().add(textMath);
        
        JLabel lblKorean = new JLabel("국  어");
        lblKorean.setHorizontalAlignment(SwingConstants.CENTER);
        lblKorean.setFont(new Font("D2Coding", Font.PLAIN, 18));
        lblKorean.setBounds(12, 10, 150, 50);
        frame.getContentPane().add(lblKorean);
        
        JLabel lblEnglish = new JLabel("영  어");
        lblEnglish.setHorizontalAlignment(SwingConstants.CENTER);
        lblEnglish.setFont(new Font("D2Coding", Font.PLAIN, 18));
        lblEnglish.setBounds(12, 70, 150, 50);
        frame.getContentPane().add(lblEnglish);
        
        JLabel lblMath = new JLabel("수  학");
        lblMath.setHorizontalAlignment(SwingConstants.CENTER);
        lblMath.setFont(new Font("D2Coding", Font.PLAIN, 18));
        lblMath.setBounds(12, 130, 150, 50);
        frame.getContentPane().add(lblMath);
        
        JButton btnInput = new JButton("입  력");
        btnInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputScore();
            }
        });
        btnInput.setFont(new Font("D2Coding", Font.PLAIN, 18));
        btnInput.setBounds(12, 190, 175, 50);
        frame.getContentPane().add(btnInput);
        
        JButton btnDelete = new JButton("삭  제");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteRow();
            }
        });
        btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 18));
        btnDelete.setBounds(199, 190, 175, 50);
        frame.getContentPane().add(btnDelete);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 250, 365, 244);
        frame.getContentPane().add(scrollPane);
        
        table = new JTable(); // JTable 생성
        
        model = new DefaultTableModel(null, COLUMN_NAMES); // 컬럼 이름만 갖는 테이블 모델 생성
        
        table.setModel(model); // 테이블 모델을 테이블에 세팅.
        
        scrollPane.setViewportView(table);
    }
    
    private void inputScore() {
        // 3개의 JTextField에서 읽은 문자열을 정수(int)로 변환.
        int korean = 0;
        int english = 0;
        int math = 0;
                
        try {
            korean = Integer.parseInt(textKorean.getText());
            english = Integer.parseInt(textEnglish.getText());
            math = Integer.parseInt(textMath.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "정수를 입력해주세요.","입력오류", JOptionPane.ERROR_MESSAGE);
            return;
        } finally {
            clearAllTextFields();
        }
        
        // 입력값을들 사용해서 Score 객체 생성
        Score score = new Score(korean, english, math);
        
        // 테이블의 행(row)에 추가할 데이터를 1차원 배열로 만듦.
        Object[] rowData = {
                score.getKorean(),
                score.getEnglish(),
                score.getMath(),
                score.sum(),
                score.average()
        };
        
        // row data를 테이블 모델에 추가
        model.addRow(rowData);
        
    }
    
    private void deleteRow() {
        // 테이블에서 삭제하기 위해서 선택된 행(row) 인덱스를 찾음.
        int index = table.getSelectedRow();
        if(index == -1) {
            JOptionPane.showMessageDialog(frame, "삭제할 행을 선택해주세요.", "삭제 오류", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // 행 인덱스를 사용해서 테이블 모델에서 행을 삭제.
        int confirm = JOptionPane.showConfirmDialog(frame, "삭제하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) { // 다이얼로그에서 Yes를 클릭했을 때
            model.removeRow(index);
        }
    
    }

    private void clearAllTextFields() {
        textKorean.setText("");
        textEnglish.setText("");
        textMath.setText("");
    }
}
