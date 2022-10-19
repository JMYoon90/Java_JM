package recipelist.view;

import static recipelist.model.IpriceCal.Entity.*;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import recipelist.controller.IpriceCalDaoImpl;
import recipelist.controller.RecipeMainDaoImpl;
import recipelist.model.RecipeMain;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class IpriceCal extends JFrame {
	private static final String[] COLUMN_NAMES = {
			COL_INGRE_NAME, COL_INGRE_WEIGHT, COL_PRICE
	};
	
	public interface OnIpriceCalListener {
		void OnIpriceCal();
	}

	private JPanel contentPane;
	private JTextField textProduct;
	private JTable table;
	private JTextField textResult;
	private JTextField textSum;
	private Integer listNo;
	
	private DefaultTableModel model;
	private IpriceCalDaoImpl dao;
	private RecipeMainDaoImpl main_Dao;
	private OnIpriceCalListener listener;
	private Component parent;
	private JButton btnCreate;

	/**
	 * Launch the application.
	 */
	public static void IpriceCalFrame(Component parent, Integer listNo, OnIpriceCalListener listener) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IpriceCal frame = new IpriceCal(parent, listNo, listener);
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
	public IpriceCal(Component parent, Integer listNo, OnIpriceCalListener listener) {
		setTitle("레시피 재료 단가 계산기");
		this.dao = IpriceCalDaoImpl.getInstance();
		this.main_Dao = RecipeMainDaoImpl.getInstance();
		this.listNo = listNo;
		this.parent = parent;
		this.listener = listener;
		
		initialize();
		
		initializeTable();
		
		searchRecipeByKeyword();
		
	}
	
	private void initializeTable() {
		model = new DefaultTableModel(null, COLUMN_NAMES);
		
		RecipeMain recipemain = main_Dao.select(listNo);
		if(recipemain != null) {
			textProduct.setText(recipemain.getProductName());
		}
	}
	
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int x = parent.getX();
		int y = parent.getY();
		setBounds(x, y, 450, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textProduct = new JTextField();
		textProduct.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		textProduct.setColumns(10);
		textProduct.setBounds(94, 10, 219, 30);
		contentPane.add(textProduct);
		
		JButton btnSelect = new JButton("선택");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchRecipeByKeyword();
			}
		});
		btnSelect.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btnSelect.setBounds(325, 10, 97, 30);
		contentPane.add(btnSelect);
		
		JLabel lblNewLabel = new JLabel("레시피");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel.setBounds(12, 10, 70, 30);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 50, 410, 450);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		
		textResult = new JTextField();
		textResult.setText("레시피 단가 합계 = ");
		textResult.setHorizontalAlignment(SwingConstants.RIGHT);
		textResult.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		textResult.setEditable(false);
		textResult.setColumns(10);
		textResult.setBounds(12, 515, 253, 30);
		contentPane.add(textResult);
		
		textSum = new JTextField();
		textSum.setHorizontalAlignment(SwingConstants.CENTER);
		textSum.setText("0원");
		textSum.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		textSum.setEditable(false);
		textSum.setColumns(10);
		textSum.setBounds(277, 515, 145, 30);
		contentPane.add(textSum);
		
		btnCreate = new JButton("확  인");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				listener.OnIpriceCal();
			}
		});
		btnCreate.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnCreate.setBounds(322, 560, 100, 35);
		contentPane.add(btnCreate);
	}

	private void searchRecipeByKeyword() {
		String keyword = textProduct.getText();
		if(keyword.equals("")) {
			return;
		}
		
		List<recipelist.model.IpriceCal> list = dao.select(keyword);
		model = new DefaultTableModel(null, COLUMN_NAMES);
		table.setModel(model);
		int sum = 0;
		for(recipelist.model.IpriceCal i : list) {
			Object[] row = {
					i.getIngrename(), i.getWeight(), i.getPrice()
			};
			sum = sum + i.getPrice();
			model.addRow(row);
		}
		textSum.setText(sum + "원");
	}

}
