package edu.java.swing08;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

public class AppMain08 {

    private JFrame frame;
    private JTextField textField;
    private JList<String> list;
    private DefaultListModel<String> listModel;

    /**
     * Launch the application.
     */
    // JList의 원소들을 관리하는 객체
    // JList에 새로운 원소 추가, 원소 삭제, 선택된 원소에 대한 정보, ...
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain08 window = new AppMain08();
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
    public AppMain08() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        textField = new JTextField();
        textField.setFont(new Font("D2Coding", Font.PLAIN, 16));
        textField.setBounds(12, 10, 250, 50);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        JButton btnInput = new JButton("입력");
        btnInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemTolist();
            }
        });
        btnInput.setFont(new Font("D2Coding", Font.PLAIN, 18));
        btnInput.setBounds(274, 10, 98, 50);
        frame.getContentPane().add(btnInput);
        
        
        JButton btnDelete = new JButton("삭제");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteItemToList();
            }
        });
        btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 18));
        btnDelete.setBounds(274, 70, 98, 50);
        frame.getContentPane().add(btnDelete);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 70, 250, 281);
        frame.getContentPane().add(scrollPane);
        
        list = new JList<>(); // JList 객체 생성
        listModel = new DefaultListModel<>(); // JList의 원소들을 관리하는 ListModel 객체를 생성.
        list.setModel(listModel); // JList에 ListModel을 설정.
        list.setFont(new Font("D2Coding", Font.PLAIN, 18));
        scrollPane.setViewportView(list);
    }

    protected void deleteItemToList() {
        try {
            int result = JOptionPane.showConfirmDialog(frame, "선택한 파일을 삭제할까요?", "리스트 삭제", JOptionPane.YES_NO_OPTION);
            
            if(result == 0) {
                int index = list.getSelectedIndex();
                listModel.remove(index);
                JOptionPane.showMessageDialog(frame, "삭제했습니다.");
            } else {
                JOptionPane.showMessageDialog(frame, "삭제를 취소했습니다.");
            }
            
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(frame, "삭제할 리스트를 선택하세요.");
        }
    }

    private void addItemTolist() {
        String input = textField.getText();
        
        if(input.length() == 0) {
            JOptionPane.showMessageDialog(frame, "내용을 입력하세요", "입력오류", JOptionPane.WARNING_MESSAGE);
        } else {
            listModel.addElement(input);
            JOptionPane.showMessageDialog(frame, "저장되었습니다.");
            textField.setText("");
        }
        
        
    }
}
