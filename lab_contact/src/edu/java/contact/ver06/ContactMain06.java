package edu.java.contact.ver06;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import edu.java.contact.ver06.ContactCreateFrame.OnContactCreateListener;
import edu.java.contact.ver06.ContactDetailFrame.OnContactUpdateListener;

public class ContactMain06 implements OnContactCreateListener, OnContactUpdateListener {
	private static final String[] COLUMN_NAMES = {"No", "이름", "전화번호"};

	private JFrame frame;
	private JTable table;
	private DefaultTableModel model;
	private ContactDaoImpl dao;
	private JTextField textKeyword;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactMain06 window = new ContactMain06();
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
	public ContactMain06() {
		initialize();
		dao = ContactDaoImpl.getInstance();
		initializeTable();
	}

	private void initializeTable() {
		model = new DefaultTableModel(null, COLUMN_NAMES);
		table.setModel(model);
		
		List<Contact> list = dao.read();
		for (Contact c : list) {
			Object[] row = {
					c.getCid(), c.getName(), c.getPhone(), c.getEmail()
			};
			model.addRow(row);
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 505, 551);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setTitle("연락처 프로그램 ver.06");
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JButton btnCreate = new JButton("새 연락처");
		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ContactCreateFrame.newContactCreateFrame(frame, ContactMain06.this);
				
			}
		});
		
		JButton btnLeadAll = new JButton("전체보기");
		btnLeadAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				initializeTable();
			}
		});
		btnLeadAll.setFont(new Font("D2Coding", Font.PLAIN, 15));
		panel.add(btnLeadAll);
		btnCreate.setFont(new Font("D2Coding", Font.PLAIN, 15));
		panel.add(btnCreate);
		
		JButton btnUpdate = new JButton("연락처 상세보기");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showDetailFrame();
			}
		});
		btnUpdate.setFont(new Font("D2Coding", Font.PLAIN, 15));
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("연락처 삭제");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteContact();
			}
		});
		btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 15));
		panel.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
        model = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(model);
        scrollPane.setViewportView(table);
        
        JPanel panel_1 = new JPanel();
        frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
        
        comboBox = new JComboBox();
        comboBox.setFont(new Font("D2Coding", Font.PLAIN, 12));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"이름", "전화번호"}));
        comboBox.setSelectedIndex(0);
        panel_1.add(comboBox);
        
        textKeyword = new JTextField();
        textKeyword.setFont(new Font("D2Coding", Font.PLAIN, 16));
        textKeyword.setColumns(10);
        panel_1.add(textKeyword);
        
        JButton btnSearch = new JButton("검  색");
        btnSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		searchContact();
        	}
        });
        btnSearch.setFont(new Font("D2Coding", Font.PLAIN, 12));
        panel_1.add(btnSearch);
	}

	private void searchContact() {	
		String keyword = textKeyword.getText();
		if(keyword.equals("")) { // 검색어 JTextField가 비어 있으면
    		JOptionPane.showMessageDialog(frame, // parentComponent
    				"검색어를 입력하세요.", // message
    				"Warning", // title
    				JOptionPane.WARNING_MESSAGE); // messageType
    		return;
    	}
		
		int type = comboBox.getSelectedIndex();
		System.out.println("type = " + type + ", keyword = " + keyword);
		
		List<Contact> list = dao.select(type, keyword);
		
		model = new DefaultTableModel(null, COLUMN_NAMES);
		table.setModel(model);
		for(Contact c : list) {
			Object[] row = {
					c.getCid(), c.getName(), c.getPhone(), c.getEmail()
			};
			model.addRow(row);
			
		}
	}

	private void showDetailFrame() {
		int row = table.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(frame, // parentComponent 
    				"테이블의 행을 먼저 선택하세요.",  // message
    				"Error",  // title
    				JOptionPane.ERROR_MESSAGE); // messageType
    		return;
		}
		
		Integer ContactNo = (Integer) model.getValueAt(row, 0);
		System.out.println("ContactNo = " + ContactNo);
		
		ContactDetailFrame.newContactDetailFrame(frame, ContactNo, ContactMain06.this);
	}

	protected void deleteContact() {
		int row = table.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(frame,
					"삭제할 연락처를 선택해주세요.",
					"Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		Integer ContactNo = (Integer) model.getValueAt(row, 0);
		System.out.println("ContactNo = "+ ContactNo);
		
		int confirm = JOptionPane.showConfirmDialog(frame,
				"연락처를 삭제할까요?",
				"삭제 확인",
				JOptionPane.YES_NO_OPTION);
		if(confirm == JOptionPane.YES_OPTION) {
			int result = dao.delete(ContactNo);
			if(result == 1) {
				JOptionPane.showMessageDialog(frame, "연락처 삭제 성공");
				initializeTable();
			} else {
				JOptionPane.showMessageDialog(frame,
						"연락처 삭제 실패",
						"Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

	@Override
	public void OnContactCreated() {
		initializeTable();
		
	}

	@Override
	public void OnContactUpdated() {
		initializeTable();
		
	}

}
