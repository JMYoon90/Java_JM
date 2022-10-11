package edu.java.contact.ver05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.java.contact.ver04.Contact;
import edu.java.contact.ver04.ContactDaoImpl;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import edu.java.contact.ver05.ContactCreateFrame.ContactInsertListener;
import edu.java.contact.ver05.ContactUpdateFrame.ContactUpdateListener;

public class ContactMain05
    implements ContactInsertListener, ContactUpdateListener {
    private static final String[] COLUMN_NAMES = {"이름", "전화번호"};

    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    private ContactDaoImpl dao;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ContactMain05 window = new ContactMain05();
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
    public ContactMain05() {
        initialize(); // UI 컴포넌트 생성, 초기화
        dao = ContactDaoImpl.getInstance(); // 연락처 데이터 관리(추가, 삭제, 변경, 검색, ...)
        loadContactDataFromFile(); // 데이터 파일에 저장된 데이터를 로드해서 테이블에 설정.
    }
    private void loadContactDataFromFile() {
        List<Contact>list = dao.read();
        for(Contact c : list) {
            addContactToTableModel(c);
        }
    }
    
    private void addContactToTableModel(Contact c) {
        // 테이블 모델에 추가할 행(row) 데이터.
        Object[] rowData = {c.getName(), c.getPhone()};
        // 테이블 모델에 데이터 추가
        model.addRow(rowData);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Contact Ver 0.5"); // 어플 타이틀을 설정
        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
        
        JButton btnCreate = new JButton("새 연락처");
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContactCreateFrame.newContactCreateFrame(frame, ContactMain05.this);
            }
        });
        btnCreate.setFont(new Font("D2Coding", Font.PLAIN, 15));
        buttonPanel.add(btnCreate);
        
        JButton btnUpdate = new JButton("연락처 수정");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showUpdateFrame();
            }
        });
        btnUpdate.setFont(new Font("D2Coding", Font.PLAIN, 15));
        buttonPanel.add(btnUpdate);
        
        JButton btnDelete = new JButton("연락처 삭제");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteContact();
            }
        });
        btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 15));
        buttonPanel.add(btnDelete);
        
        JButton btnSearch = new JButton("검색");
        btnSearch.setFont(new Font("D2Coding", Font.PLAIN, 15));
        buttonPanel.add(btnSearch);
        
        JScrollPane scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        model = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(model);
        scrollPane.setViewportView(table);
    }

    protected void deleteContact() {
        int row = table.getSelectedRow(); // 선택된 행 번호
        if(row == -1) { // 테이블에서 선택된 행이 없으면
            JOptionPane.showMessageDialog(frame, "삭제할 행을 먼저 선택하세요.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(frame, "삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
        
        if(confirm == 0) {
         // DAO의 메서드를 사용해서 연락처를 삭제, 파일에 저장.
            dao.delete(row);
            
            // 테이블 갱신
            model.removeRow(row);
            
            JOptionPane.showMessageDialog(frame, "삭제 완료.");
        }
    }

    private void showUpdateFrame() {
        // 테이블에서 수정하기 위해서 선택한 행 번호를 찾음.
        int row = table.getSelectedRow();
            if(row == -1) {
                JOptionPane.showMessageDialog(frame, "수정할 행을 먼저 선택하세요.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
        
        // 업데이트 창에서는 수정 전의 정보를 화면에 출력하기 위해서,
        // 행 번호(=연락처 리스트의 인덱스)를 argument로 전달하면서 ContactUpdateFrame을 생성한다.
        ContactUpdateFrame.newContactUpdateFrame(frame, row, ContactMain05.this);
        
    }

    // ContactCreateFrame.ContactInsertListener 인터페이스의 메서드를 구현.
    @Override
    public void contactInsertNotify(Contact c) {
        // ContactDaoImpl의 메서드를 사용해서 새 연락처 정보를 파일에 저장.
        int result = dao.create(c);
        if (result == 1) {
            // 메인 화면의 테이블을 갱신 <- 테이블 모델에 행(row) 데이터를 추가.
            addContactToTableModel(c);
            JOptionPane.showMessageDialog(frame, c.getName() + " 추가됐습니다."); // 성공 팝업
        }
        
        // 메인 화면의 테이블을 갱신.
    }

    @Override // ContactUpdateListener 인터페이스를 구현
    public void contactdateNotify() {
        // 테이블 모델 초기화 
        model = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(model);
        // 연락처 데이터를 새로 로딩
        loadContactDataFromFile();
        JOptionPane.showMessageDialog(frame, "수정되었습니다."); // 성공 팝업
    }

}
