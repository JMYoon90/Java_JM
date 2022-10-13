package recipelist.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JButton;

public class IngredientCost extends JFrame {

	private JPanel contentPane;
	private JTextField textPurchaseDate;
	private JTextField textIngredient_1;
	private JTextField textIngredient_2;
	private JTextField textIngredient_3;
	private JTextField textIngredient_4;
	private JTextField textIngredient_5;
	private JTextField textWeight_1;
	private JTextField textWeight_2;
	private JTextField textWeight_3;
	private JTextField textWeight_4;
	private JTextField textWeight_5;
	private JTextField textCost_1;
	private JTextField textCost_2;
	private JTextField textCost_3;
	private JTextField textCost_4;
	private JTextField textCost_5;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngredientCost frame = new IngredientCost();
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
	public IngredientCost() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("재료 가격표");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblTitle.setBounds(12, 290, 130, 30);
		contentPane.add(lblTitle);
		
		JLabel lblPurchaseDate = new JLabel("재료 구입일");
		lblPurchaseDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblPurchaseDate.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblPurchaseDate.setBounds(12, 10, 106, 30);
		contentPane.add(lblPurchaseDate);
		
		textPurchaseDate = new JTextField();
		textPurchaseDate.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textPurchaseDate.setColumns(10);
		textPurchaseDate.setBounds(130, 10, 288, 30);
		contentPane.add(textPurchaseDate);
		
		JLabel lblNumber = new JLabel("NO");
		lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNumber.setBounds(12, 50, 50, 30);
		contentPane.add(lblNumber);
		
		JLabel lblIngredient = new JLabel("재료명");
		lblIngredient.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngredient.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblIngredient.setBounds(74, 50, 160, 30);
		contentPane.add(lblIngredient);
		
		JLabel lblWeight = new JLabel("중량(g)");
		lblWeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeight.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblWeight.setBounds(246, 50, 80, 30);
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
		
		textIngredient_1 = new JTextField();
		textIngredient_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textIngredient_1.setColumns(10);
		textIngredient_1.setBounds(74, 90, 160, 30);
		contentPane.add(textIngredient_1);
		
		textIngredient_2 = new JTextField();
		textIngredient_2.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textIngredient_2.setColumns(10);
		textIngredient_2.setBounds(74, 130, 160, 30);
		contentPane.add(textIngredient_2);
		
		textIngredient_3 = new JTextField();
		textIngredient_3.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textIngredient_3.setColumns(10);
		textIngredient_3.setBounds(74, 170, 160, 30);
		contentPane.add(textIngredient_3);
		
		textIngredient_4 = new JTextField();
		textIngredient_4.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textIngredient_4.setColumns(10);
		textIngredient_4.setBounds(74, 210, 160, 30);
		contentPane.add(textIngredient_4);
		
		textIngredient_5 = new JTextField();
		textIngredient_5.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textIngredient_5.setColumns(10);
		textIngredient_5.setBounds(74, 250, 160, 30);
		contentPane.add(textIngredient_5);
		
		textWeight_1 = new JTextField();
		textWeight_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textWeight_1.setColumns(10);
		textWeight_1.setBounds(246, 90, 80, 30);
		contentPane.add(textWeight_1);
		
		textWeight_2 = new JTextField();
		textWeight_2.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textWeight_2.setColumns(10);
		textWeight_2.setBounds(246, 130, 80, 30);
		contentPane.add(textWeight_2);
		
		textWeight_3 = new JTextField();
		textWeight_3.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textWeight_3.setColumns(10);
		textWeight_3.setBounds(246, 170, 80, 30);
		contentPane.add(textWeight_3);
		
		textWeight_4 = new JTextField();
		textWeight_4.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textWeight_4.setColumns(10);
		textWeight_4.setBounds(246, 210, 80, 30);
		contentPane.add(textWeight_4);
		
		textWeight_5 = new JTextField();
		textWeight_5.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textWeight_5.setColumns(10);
		textWeight_5.setBounds(246, 250, 80, 30);
		contentPane.add(textWeight_5);
		
		JLabel lblCost = new JLabel("가격");
		lblCost.setHorizontalAlignment(SwingConstants.CENTER);
		lblCost.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblCost.setBounds(338, 50, 80, 30);
		contentPane.add(lblCost);
		
		textCost_1 = new JTextField();
		textCost_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textCost_1.setColumns(10);
		textCost_1.setBounds(338, 90, 80, 30);
		contentPane.add(textCost_1);
		
		textCost_2 = new JTextField();
		textCost_2.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textCost_2.setColumns(10);
		textCost_2.setBounds(338, 130, 80, 30);
		contentPane.add(textCost_2);
		
		textCost_3 = new JTextField();
		textCost_3.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textCost_3.setColumns(10);
		textCost_3.setBounds(338, 170, 80, 30);
		contentPane.add(textCost_3);
		
		textCost_4 = new JTextField();
		textCost_4.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textCost_4.setColumns(10);
		textCost_4.setBounds(338, 210, 80, 30);
		contentPane.add(textCost_4);
		
		textCost_5 = new JTextField();
		textCost_5.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textCost_5.setColumns(10);
		textCost_5.setBounds(338, 250, 80, 30);
		contentPane.add(textCost_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 330, 396, 224);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnCreate = new JButton("저 장");
		btnCreate.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnCreate.setBounds(206, 564, 100, 35);
		contentPane.add(btnCreate);
		
		JButton btnCancle = new JButton("취 소");
		btnCancle.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnCancle.setBounds(318, 565, 100, 35);
		contentPane.add(btnCancle);
	}

}
