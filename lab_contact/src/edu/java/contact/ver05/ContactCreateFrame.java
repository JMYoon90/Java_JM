package edu.java.contact.ver05;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.contact.ver04.Contact;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactCreateFrame extends JFrame {

    @FunctionalInterface
    public interface ContactInsertListener {
        void contactInsertNotify(Contact c);
    }

    private Component parent;
    private ContactInsertListener listener;
    
    private JPanel contentPane;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;
    

    /**
     * Launch the application.
     */
    public static void newContactCreateFrame(Component parent, ContactInsertListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                ContactCreateFrame frame = new ContactCreateFrame(parent, listener);
                frame.setVisible(true);
            }
        });
    }

    /**
     * Create the frame.
     */
    public ContactCreateFrame(Component parent, ContactInsertListener listener) {
        this.parent = parent; // 부모 컴포넌트를 초기화.
        this.listener = listener; // contactInsertNotify() 메서드를 가지고 있는 객체를 초기화.
        initialize(); // UI 컴포넌트들을 생성, 초기화.
    }
    
    /**
     * Initialize UI components 
     */
    
    private void initialize() {
        setTitle("새 연락처 추가"); // JFrame의 타이틀 설정.
        // 닫기 버튼을 클릭했을 떄의 기본 동작을 설정 - 현재 창만 닫기.
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
        // JFrame이 화면에 보이게 될 자표와 크기(가로/세로)를 설정.
        int x = parent.getX(); // 부모 컴포넌트의 x 좌표
        int y = parent.getY(); // 부모 컴포넌트의 y 좌표
        setBounds(x, y, 379, 283);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblName = new JLabel("이    름");
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        lblName.setFont(new Font("D2Coding", Font.PLAIN, 18));
        lblName.setBounds(12, 10, 120, 50);
        contentPane.add(lblName);
        
        JLabel lblPhone = new JLabel("전화번호");
        lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
        lblPhone.setFont(new Font("D2Coding", Font.PLAIN, 18));
        lblPhone.setBounds(12, 70, 120, 50);
        contentPane.add(lblPhone);
        
        JLabel lblEmail = new JLabel("이 메 일");
        lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmail.setFont(new Font("D2Coding", Font.PLAIN, 18));
        lblEmail.setBounds(12, 130, 120, 50);
        contentPane.add(lblEmail);
        
        textName = new JTextField();
        textName.setFont(new Font("D2Coding", Font.PLAIN, 18));
        textName.setBounds(144, 10, 207, 50);
        contentPane.add(textName);
        textName.setColumns(10);
        
        textPhone = new JTextField();
        textPhone.setFont(new Font("D2Coding", Font.PLAIN, 18));
        textPhone.setColumns(10);
        textPhone.setBounds(144, 70, 207, 50);
        contentPane.add(textPhone);
        
        textEmail = new JTextField();
        textEmail.setFont(new Font("D2Coding", Font.PLAIN, 18));
        textEmail.setColumns(10);
        textEmail.setBounds(144, 130, 207, 50);
        contentPane.add(textEmail);
        
        JButton btnSave = new JButton("저장");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewContact();
            }
        });
        btnSave.setFont(new Font("D2Coding", Font.PLAIN, 18));
        btnSave.setBounds(48, 190, 110, 40);
        contentPane.add(btnSave);
        
        JButton btnCancel = new JButton("취소");
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // 현재 창만 닫고, 부모 컴포넌트는 계속 실행.
            }
        });
        btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 18));
        btnCancel.setBounds(197, 190, 110, 40);
        contentPane.add(btnCancel);
    }

    private void createNewContact() {
        // 3개의 텍스트 필드에 입력된 문자열을 읽음.
        String name = textName.getText();
        String phone = textPhone.getText();
        String email = textEmail.getText();
        
        // Contact 객체 생성
        Contact contact = new Contact(name, phone, email);
        
        // 현재 창 닫기
        dispose();
        
        // 새 연락처가 생성됐음을 (ContactMain에게) 알려줌.
        listener.contactInsertNotify(contact);
        
        
    }

}
