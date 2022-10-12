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

public class ContactDetailFrame extends JFrame {
	
	public interface OnContactUpdateListener {
		void OnContactUpdated();
	}
	private OnContactUpdateListener listener;
	
	private Component parent;
	private Integer contactNo;
	private ContactDaoImpl dao;

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textEmail;
	private JTextField textCid;

	/**
	 * Launch the application.
	 */
	public static void newContactDetailFrame(Component parent, Integer contactNo, OnContactUpdateListener listener) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactDetailFrame frame = new ContactDetailFrame(parent, contactNo, listener);
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
	public ContactDetailFrame(Component parent, Integer contactNo, OnContactUpdateListener listener) {
	this.listener = listener;
	this.parent = parent;
	this.contactNo = contactNo;
	this.dao = ContactDaoImpl.getInstance();
	
	initialize();
	
	initializeContactData();
	}
	
	
	
	private void initializeContactData() {
		Contact contact = dao.read(contactNo);
		if(contact != null) {
			textCid.setText(contact.getCid().toString());
			textName.setText(contact.getName());
			textPhone.setText(contact.getPhone());
			textEmail.setText(contact.getEmail());
		}
		
	}

	private void initialize() {
		setTitle("연락처 상세 보기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int x = parent.getX();
		int y = parent.getY();
		setBounds(x, y, 392, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("이    름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblName.setBounds(12, 70, 120, 50);
		contentPane.add(lblName);
		
		textName = new JTextField();
		textName.setText((String) null);
		textName.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textName.setColumns(10);
		textName.setBounds(144, 70, 220, 50);
		contentPane.add(textName);
		
		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblPhone.setBounds(12, 130, 120, 50);
		contentPane.add(lblPhone);
		
		textPhone = new JTextField();
		textPhone.setText((String) null);
		textPhone.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textPhone.setColumns(10);
		textPhone.setBounds(144, 130, 220, 50);
		contentPane.add(textPhone);
		
		JLabel lblEmail = new JLabel("이 메 일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblEmail.setBounds(12, 190, 120, 50);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setText((String) null);
		textEmail.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textEmail.setColumns(10);
		textEmail.setBounds(144, 190, 220, 50);
		contentPane.add(textEmail);
		
		JButton btnSave = new JButton("수  정");
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateContact();
			}
		});
		btnSave.setFont(new Font("D2Coding", Font.PLAIN, 18));
		btnSave.setBounds(48, 250, 110, 40);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("취  소");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 18));
		btnCancel.setBounds(206, 250, 110, 40);
		contentPane.add(btnCancel);
		
		JLabel lblCid = new JLabel("번    호");
		lblCid.setHorizontalAlignment(SwingConstants.CENTER);
		lblCid.setFont(new Font("D2Coding", Font.PLAIN, 18));
		lblCid.setBounds(12, 10, 120, 50);
		contentPane.add(lblCid);
		
		textCid = new JTextField();
		textCid.setEditable(false);
		textCid.setText((String) null);
		textCid.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textCid.setColumns(10);
		textCid.setBounds(144, 10, 220, 50);
		contentPane.add(textCid);
	}

	protected void updateContact() {
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();
		if(name.equals("") || phone.equals("")) {
			JOptionPane.showMessageDialog(this,
					"이름과 전화번호는 꼭 적어주세요.",
					"Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		Contact contact = new Contact(contactNo, name, phone, email);
		int result = dao.update(contact);
		
		if (result == 1) {
			JOptionPane.showMessageDialog(this, "업데이트 성공");
			
			dispose();
			
			listener.OnContactUpdated();
		} else {
			JOptionPane.showMessageDialog(this, "업데이트 실패");
			
			dispose();
		}
		
		
		
	}

}
