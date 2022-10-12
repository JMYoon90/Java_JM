package edu.java.contact.ver06;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class ContactCreateFrame extends JFrame {
	
	public interface OnContactCreateListener {
		void OnContactCreated();
	}

	private JPanel contentPane;
	private JTextField textname;
	private JTextField textphone;
	private JTextField textemail;
	
	private ContactDaoImpl dao;
	private OnContactCreateListener listener;
	private Component parent;

	/**
	 * Launch the application.
	 */
	public static void newContactCreateFrame(Component parent, OnContactCreateListener listener) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactCreateFrame frame = new ContactCreateFrame(parent, listener);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ContactCreateFrame(Component parent, OnContactCreateListener listener) {
		this.parent = parent;
		this.listener = listener;
		this.dao = ContactDaoImpl.getInstance();
	
		initialize();
	}
	
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int x = parent.getX();
		int y = parent.getY();
		setBounds(x, y, 382, 295);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("이    름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblName.setBounds(12, 10, 120, 50);
		contentPane.add(lblName);
		
		textname = new JTextField();
		textname.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textname.setColumns(10);
		textname.setBounds(144, 10, 210, 50);
		contentPane.add(textname);
		
		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblPhone.setBounds(12, 70, 120, 50);
		contentPane.add(lblPhone);
		
		textphone = new JTextField();
		textphone.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textphone.setColumns(10);
		textphone.setBounds(144, 70, 210, 50);
		contentPane.add(textphone);
		
		JLabel lblEmail = new JLabel("이 메 일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblEmail.setBounds(12, 130, 120, 50);
		contentPane.add(lblEmail);
		
		textemail = new JTextField();
		textemail.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textemail.setColumns(10);
		textemail.setBounds(144, 130, 210, 50);
		contentPane.add(textemail);
		
		JButton btnSave = new JButton("저장");
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createContact();
			}
		});
		btnSave.setFont(new Font("D2Coding", Font.PLAIN, 18));
		btnSave.setBounds(48, 190, 110, 40);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 18));
		btnCancel.setBounds(197, 190, 110, 40);
		contentPane.add(btnCancel);
	}

	protected void createContact() {
		String name = textname.getText();
		String phone = textphone.getText();
		String email = textemail.getText();
		if(name.equals("") || phone.equals("") || email.equals("")) {
			JOptionPane.showMessageDialog(
                    this, // parentComponent -> BlogCreateFrame의 인스턴스 주소.
                    "제목, 내용, 작성자는 반드시 입력되어야 합니다!", // message
                    "Error", // title
                    JOptionPane.ERROR_MESSAGE);
			return;
		}
		Contact contact = new Contact(null, name, phone, email);
		int result = dao.create(contact);
		if (result == 1) {
			JOptionPane.showMessageDialog(this, "새 연락처 작성 성공");
			dispose();
			
			listener.OnContactCreated();
		} else {
			JOptionPane.showMessageDialog(this,
					"새 연락처 작성 실패",
					"Error",
					JOptionPane.ERROR_MESSAGE);
		}
				
			
				
		
		
		
		
		
		
	}
}
