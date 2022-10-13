package recipelist.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import recipelist.controller.RecipeListDaoImpl;
import recipelist.model.RecipeList;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListCreateFrame extends JFrame {

	private RecipeListDaoImpl dao;
	
	private JPanel contentPane;
	private JTextField textProduct;
	private JTextField textModifiedDate;
	private JTextField textIngredient_1;
	private JTextField textIngredient_2;
	private JTextField textIngredient_3;
	private JTextField textIngredient_4;
	private JTextField textIngredient_5;
	private JTextField textIngredient_6;
	private JTextField textIngredient_7;
	private JTextField textIngredient_8;
	private JTextField textIngredient_9;
	private JTextField textIngredient_10;
	private JTextField textWeight_1;
	private JTextField textWeight_2;
	private JTextField textWeight_3;
	private JTextField textWeight_4;
	private JTextField textWeight_5;
	private JTextField textWeight_6;
	private JTextField textWeight_7;
	private JTextField textWeight_8;
	private JTextField textWeight_9;
	private JTextField textWeight_10;
	private JTextField textCookMethod;
	private JTextArea textETCText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListCreateFrame frame = new ListCreateFrame();
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
	public ListCreateFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProduct = new JLabel("제품명");
		lblProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblProduct.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblProduct.setBounds(12, 10, 80, 30);
		contentPane.add(lblProduct);
		
		textProduct = new JTextField();
		textProduct.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textProduct.setBounds(104, 10, 236, 30);
		contentPane.add(textProduct);
		textProduct.setColumns(10);
		
		JLabel lblGroup = new JLabel("분류");
		lblGroup.setHorizontalAlignment(SwingConstants.CENTER);
		lblGroup.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblGroup.setBounds(352, 10, 80, 30);
		contentPane.add(lblGroup);
		
		JLabel lblModifiedDate = new JLabel("작성일");
		lblModifiedDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifiedDate.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblModifiedDate.setBounds(542, 10, 80, 30);
		contentPane.add(lblModifiedDate);
		
		textModifiedDate = new JTextField();
		textModifiedDate.setEditable(false);
		textModifiedDate.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textModifiedDate.setColumns(10);
		textModifiedDate.setBounds(634, 10, 138, 30);
		contentPane.add(textModifiedDate);
		
		JLabel lblNumber = new JLabel("NO");
		lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNumber.setBounds(12, 50, 50, 30);
		contentPane.add(lblNumber);
		
		JLabel lblIngredient = new JLabel("재료명");
		lblIngredient.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngredient.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblIngredient.setBounds(74, 50, 220, 30);
		contentPane.add(lblIngredient);
		
		JLabel lblWeight = new JLabel("중량(g)");
		lblWeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeight.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblWeight.setBounds(306, 50, 80, 30);
		contentPane.add(lblWeight);
		
		JLabel lblNumber_1 = new JLabel("1");
		lblNumber_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber_1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNumber_1.setBounds(12, 90, 50, 30);
		contentPane.add(lblNumber_1);
		
		JLabel lblNumber_2 = new JLabel("2");
		lblNumber_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber_2.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNumber_2.setBounds(12, 130, 50, 30);
		contentPane.add(lblNumber_2);
		
		JLabel lblNumber_3 = new JLabel("3");
		lblNumber_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber_3.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNumber_3.setBounds(12, 170, 50, 30);
		contentPane.add(lblNumber_3);
		
		JLabel lblNumber_4 = new JLabel("4");
		lblNumber_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber_4.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNumber_4.setBounds(12, 210, 50, 30);
		contentPane.add(lblNumber_4);
		
		JLabel lblNumber_5 = new JLabel("5");
		lblNumber_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber_5.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNumber_5.setBounds(12, 250, 50, 30);
		contentPane.add(lblNumber_5);
		
		JLabel lblNumber_6 = new JLabel("6");
		lblNumber_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber_6.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNumber_6.setBounds(12, 290, 50, 30);
		contentPane.add(lblNumber_6);
		
		JLabel lblNumber_7 = new JLabel("7");
		lblNumber_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber_7.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNumber_7.setBounds(12, 330, 50, 30);
		contentPane.add(lblNumber_7);
		
		JLabel lblNumber_8 = new JLabel("8");
		lblNumber_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber_8.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNumber_8.setBounds(12, 370, 50, 30);
		contentPane.add(lblNumber_8);
		
		JLabel lblNumber_9 = new JLabel("9");
		lblNumber_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber_9.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNumber_9.setBounds(12, 410, 50, 30);
		contentPane.add(lblNumber_9);
		
		JLabel lblNumber_10 = new JLabel("10");
		lblNumber_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber_10.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNumber_10.setBounds(12, 450, 50, 30);
		contentPane.add(lblNumber_10);
		
		textIngredient_1 = new JTextField();
		textIngredient_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textIngredient_1.setColumns(10);
		textIngredient_1.setBounds(74, 90, 220, 30);
		contentPane.add(textIngredient_1);
		
		textIngredient_2 = new JTextField();
		textIngredient_2.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textIngredient_2.setColumns(10);
		textIngredient_2.setBounds(74, 130, 220, 30);
		contentPane.add(textIngredient_2);
		
		textIngredient_3 = new JTextField();
		textIngredient_3.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textIngredient_3.setColumns(10);
		textIngredient_3.setBounds(74, 170, 220, 30);
		contentPane.add(textIngredient_3);
		
		textIngredient_4 = new JTextField();
		textIngredient_4.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textIngredient_4.setColumns(10);
		textIngredient_4.setBounds(74, 210, 220, 30);
		contentPane.add(textIngredient_4);
		
		textIngredient_5 = new JTextField();
		textIngredient_5.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textIngredient_5.setColumns(10);
		textIngredient_5.setBounds(74, 250, 220, 30);
		contentPane.add(textIngredient_5);
		
		textIngredient_6 = new JTextField();
		textIngredient_6.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textIngredient_6.setColumns(10);
		textIngredient_6.setBounds(74, 290, 220, 30);
		contentPane.add(textIngredient_6);
		
		textIngredient_7 = new JTextField();
		textIngredient_7.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textIngredient_7.setColumns(10);
		textIngredient_7.setBounds(74, 330, 220, 30);
		contentPane.add(textIngredient_7);
		
		textIngredient_8 = new JTextField();
		textIngredient_8.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textIngredient_8.setColumns(10);
		textIngredient_8.setBounds(74, 370, 220, 30);
		contentPane.add(textIngredient_8);
		
		textIngredient_9 = new JTextField();
		textIngredient_9.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textIngredient_9.setColumns(10);
		textIngredient_9.setBounds(74, 410, 220, 30);
		contentPane.add(textIngredient_9);
		
		textIngredient_10 = new JTextField();
		textIngredient_10.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textIngredient_10.setColumns(10);
		textIngredient_10.setBounds(74, 450, 220, 30);
		contentPane.add(textIngredient_10);
		
		textWeight_1 = new JTextField();
		textWeight_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textWeight_1.setColumns(10);
		textWeight_1.setBounds(306, 90, 80, 30);
		contentPane.add(textWeight_1);
		
		textWeight_2 = new JTextField();
		textWeight_2.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textWeight_2.setColumns(10);
		textWeight_2.setBounds(306, 130, 80, 30);
		contentPane.add(textWeight_2);
		
		textWeight_3 = new JTextField();
		textWeight_3.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textWeight_3.setColumns(10);
		textWeight_3.setBounds(306, 170, 80, 30);
		contentPane.add(textWeight_3);
		
		textWeight_4 = new JTextField();
		textWeight_4.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textWeight_4.setColumns(10);
		textWeight_4.setBounds(306, 210, 80, 30);
		contentPane.add(textWeight_4);
		
		textWeight_5 = new JTextField();
		textWeight_5.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textWeight_5.setColumns(10);
		textWeight_5.setBounds(306, 250, 80, 30);
		contentPane.add(textWeight_5);
		
		textWeight_6 = new JTextField();
		textWeight_6.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textWeight_6.setColumns(10);
		textWeight_6.setBounds(306, 290, 80, 30);
		contentPane.add(textWeight_6);
		
		textWeight_7 = new JTextField();
		textWeight_7.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textWeight_7.setColumns(10);
		textWeight_7.setBounds(306, 330, 80, 30);
		contentPane.add(textWeight_7);
		
		textWeight_8 = new JTextField();
		textWeight_8.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textWeight_8.setColumns(10);
		textWeight_8.setBounds(306, 370, 80, 30);
		contentPane.add(textWeight_8);
		
		textWeight_9 = new JTextField();
		textWeight_9.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textWeight_9.setColumns(10);
		textWeight_9.setBounds(306, 410, 80, 30);
		contentPane.add(textWeight_9);
		
		textWeight_10 = new JTextField();
		textWeight_10.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textWeight_10.setColumns(10);
		textWeight_10.setBounds(306, 450, 80, 30);
		contentPane.add(textWeight_10);
		
		JLabel lblEtc = new JLabel("etc.");
		lblEtc.setHorizontalAlignment(SwingConstants.CENTER);
		lblEtc.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblEtc.setBounds(12, 490, 50, 30);
		contentPane.add(lblEtc);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 490, 312, 111);
		contentPane.add(scrollPane);
		
		textETCText = new JTextArea();
		textETCText.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		scrollPane.setViewportView(textETCText);
		
		JLabel lblEtc_1 = new JLabel("만드는법( 판서 )");
		lblEtc_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblEtc_1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblEtc_1.setBounds(398, 50, 374, 30);
		contentPane.add(lblEtc_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(398, 90, 374, 465);
		contentPane.add(scrollPane_1);
		
		textCookMethod = new JTextField();
		textCookMethod.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		scrollPane_1.setViewportView(textCookMethod);
		textCookMethod.setColumns(10);
		
		JButton btnCreate = new JButton("저 장");
		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createNewRecipe();
			}
		});
		btnCreate.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnCreate.setBounds(560, 565, 100, 35);
		contentPane.add(btnCreate);
		
		JButton btnCancle = new JButton("취 소");
		btnCancle.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnCancle.setBounds(672, 566, 100, 35);
		contentPane.add(btnCancle);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(444, 13, 86, 30);
		contentPane.add(comboBox);
	}

	protected void createNewRecipe() {
		
		String productName = textProduct.getText();
		String ingredientName = textIngredient_1.getText();
		Integer productWeight = Integer.parseInt(textWeight_1.getText());
		String ectText = textETCText.getText();
		String cookingMethod = textCookMethod.getText();
		
		RecipeList recipelist = new RecipeList(null, productName, null, productWeight, null, ectText, cookingMethod, ingredientName);
		int result = dao.insert(recipelist);
		
		// TODO: int result = dao
		
		
		
		
		
		
		
		
		
	}
}
