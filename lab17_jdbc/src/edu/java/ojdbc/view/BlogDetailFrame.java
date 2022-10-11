package edu.java.ojdbc.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.ojdbc.controller.BlogDaoImpl;
import edu.java.ojdbc.model.Blog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BlogDetailFrame extends JFrame {
	
	public interface OnBlogUpdateListener {
		void onBlogUpdated();
	}
	private OnBlogUpdateListener listener;
	
	private Component parent;
	private Integer blogNo;
	private BlogDaoImpl dao;

	private JPanel contentPane;
	private JTextField textBlogNo;
	private JTextField textTitle;
	private JTextArea textContent;
	private JTextField textAuthor;
	private JTextField textCreatedDate;
	private JTextField textModifiedDate;

	/**
	 * Launch the application.
	 */
	public static void newBlogDetailFrame(Component parent, Integer blogNo, OnBlogUpdateListener listener) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlogDetailFrame frame = new BlogDetailFrame(parent, blogNo, listener);
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
	public BlogDetailFrame(Component parent, Integer blogNo, OnBlogUpdateListener listener) {
		this.listener = listener; // 블로그 글 업데이트 결과를 통지할 수 있는 메서드를 가지고 있는 객체.
		this.parent = parent; // 부모 컴포넌트 객체 저장.
		this.blogNo = blogNo; // 상세보기/수정할 블로그 글 번호.
		this.dao = BlogDaoImpl.getInstance();
		
		initialize(); // UI 컴포넌트 생성, 초기화.
		
		initializeBlogData(); // JTextFiled, JtextArea의 내용을 DB에서 검색한 내용으로 채움.
		
	}
	
	
	private void initializeBlogData() {
		Blog blog = dao.select(blogNo);
		if(blog != null) {
			textBlogNo.setText(blog.getBlogNo().toString()); // 텍스트 외에 숫자, 날자 등은 toString()으로 텍스트로 변환해줘야 함
			textTitle.setText(blog.getTitle());
			textContent.setText(blog.getContent());
			textAuthor.setText(blog.getAuthor());
			textCreatedDate.setText(blog.getCreatedDate().toString());
			textModifiedDate.setText(blog.getModifiedDate().toString());
		}
		
	}

	public void initialize() {
		setTitle("블로그 상세 보기");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int x = parent.getX();
		int y = parent.getY();
		setBounds(x, y, 400, 800);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBlogNo = new JLabel("번  호");
		lblBlogNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBlogNo.setFont(new Font("D2Coding", Font.BOLD, 18));
		lblBlogNo.setBounds(12, 10, 95, 53);
		contentPane.add(lblBlogNo);
		
		textBlogNo = new JTextField();
		textBlogNo.setEditable(false);
		textBlogNo.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textBlogNo.setBounds(119, 10, 253, 53);
		contentPane.add(textBlogNo);
		textBlogNo.setColumns(10);
		
		JLabel lblTitle = new JLabel("제  목");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("D2Coding", Font.BOLD, 18));
		lblTitle.setBounds(12, 73, 95, 53);
		contentPane.add(lblTitle);
		
		textTitle = new JTextField();
		textTitle.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textTitle.setColumns(10);
		textTitle.setBounds(119, 73, 253, 53);
		contentPane.add(textTitle);
		
		JLabel lblContent = new JLabel("내  용");
		lblContent.setHorizontalAlignment(SwingConstants.CENTER);
		lblContent.setFont(new Font("D2Coding", Font.BOLD, 18));
		lblContent.setBounds(12, 136, 95, 37);
		contentPane.add(lblContent);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 183, 360, 311);
		contentPane.add(scrollPane);
		
		textContent = new JTextArea();
		textContent.setFont(new Font("D2Coding", Font.PLAIN, 18));
		scrollPane.setViewportView(textContent);
		
		JLabel lblAuthor = new JLabel("작 성 자");
		lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthor.setFont(new Font("D2Coding", Font.BOLD, 18));
		lblAuthor.setBounds(12, 504, 95, 53);
		contentPane.add(lblAuthor);
		
		textAuthor = new JTextField();
		textAuthor.setEditable(false);
		textAuthor.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textAuthor.setColumns(10);
		textAuthor.setBounds(119, 504, 253, 53);
		contentPane.add(textAuthor);
		
		JLabel lblCreatedDate = new JLabel("작성시간");
		lblCreatedDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreatedDate.setFont(new Font("D2Coding", Font.BOLD, 18));
		lblCreatedDate.setBounds(12, 567, 95, 53);
		contentPane.add(lblCreatedDate);
		
		textCreatedDate = new JTextField();
		textCreatedDate.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textCreatedDate.setEditable(false);
		textCreatedDate.setColumns(10);
		textCreatedDate.setBounds(119, 567, 253, 53);
		contentPane.add(textCreatedDate);
		
		JLabel lblModifiedDate = new JLabel("최종수정");
		lblModifiedDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifiedDate.setFont(new Font("D2Coding", Font.BOLD, 18));
		lblModifiedDate.setBounds(12, 630, 95, 53);
		contentPane.add(lblModifiedDate);
		
		textModifiedDate = new JTextField();
		textModifiedDate.setFont(new Font("D2Coding", Font.PLAIN, 18));
		textModifiedDate.setEditable(false);
		textModifiedDate.setColumns(10);
		textModifiedDate.setBounds(119, 630, 253, 53);
		contentPane.add(textModifiedDate);
		
		JButton btnUpdate = new JButton("수정완료");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateBlog();
			}
		});
		btnUpdate.setFont(new Font("D2Coding", Font.BOLD, 18));
		btnUpdate.setBounds(12, 693, 360, 58);
		contentPane.add(btnUpdate);
	}

	protected void updateBlog() {
		// 수정할 title, content 읽음.
		String title = textTitle.getText();
		String content = textContent.getText();
		if (title.equals("") || content.equals("")) {
			JOptionPane.showMessageDialog(this,
					"제목, 내용은 반드시 작성해주세요.",
					"Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		// dao.update() 호출
		Blog blog = new Blog(blogNo, title, content, null, null, null);
		int result = dao.update(blog);
		

		
		// BlogMain 업데이트 성공을 알려줌.
		if (result == 1) {
			JOptionPane.showMessageDialog(this, blogNo + "번 블로그 업데이트 성공");
			
			// DetailFrame은 닫음.			
			dispose();
			// BlogMain에게 업데이트 성공을 알려줌.
			listener.onBlogUpdated();
		} else {
			JOptionPane.showMessageDialog(this, blogNo + "번 블로그 업데이트 실패");
			dispose();
		}
		
	}
}
