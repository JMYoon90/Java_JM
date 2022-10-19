package recipelist.view;

import java.awt.Component;
import java.awt.EventQueue;

import static recipelist.model.FoodCost.Entity.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import recipelist.controller.FoodCostDaoImpl;
import recipelist.model.FoodCost;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class FoodCostFrame extends JFrame {
	
	private static final String[] COLUMN_NAMES = {
			COL_FOOD_NO, COL_FOOD_NAME, COL_FOOD_WEIGHT, COL_FOODCOST
	};
	
	public interface OnCostlistInsertListener {
		void OnCostlistInserted();
	}

	private OnCostlistInsertListener listener;
	private Component parent;
	private JPanel contentPane;
	private JTextField textIngreName;
	private JTextField textCost;
	private JTable table;
	
	private FoodCostDaoImpl dao;
	private DefaultTableModel model;
	private JTextField textweight;

	/**
	 * Launch the application.
	 */
	public static void newCostlistCreateFrame(Component parent, OnCostlistInsertListener listener) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoodCostFrame frame = new FoodCostFrame(parent, listener);
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
	public FoodCostFrame(Component parent, OnCostlistInsertListener listener) {
		this.listener = listener;
		this.parent = parent;
		this.dao = FoodCostDaoImpl.getInstance();
		
		initialize();
		
		initializeTable();
	}
		
		
	private void initializeTable() {
		model = new DefaultTableModel(null, COLUMN_NAMES);
		table.setModel(model);
		
		List<FoodCost> list = dao.select();
		for(FoodCost f : list) {
			Object[] row = {
					f.getFoodNo(), f.getFoodName(), f.getfWeight(), f.getFoodCost()
			};
			model.addRow(row);
		}
	}

	private void initialize() {
		setTitle("재료 가격표");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int x = parent.getX();
		int y = parent.getY();
		setBounds(x, y, 800, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textIngreName = new JTextField();
		textIngreName.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		textIngreName.setBounds(22, 90, 300, 35);
		contentPane.add(textIngreName);
		textIngreName.setColumns(10);
		
		JLabel lblIngreName = new JLabel("재료명");
		lblIngreName.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreName.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblIngreName.setBounds(12, 40, 100, 40);
		contentPane.add(lblIngreName);
		
		JLabel lblCost = new JLabel("가  격");
		lblCost.setHorizontalAlignment(SwingConstants.CENTER);
		lblCost.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblCost.setBounds(12, 230, 100, 40);
		contentPane.add(lblCost);
		
		textCost = new JTextField();
		textCost.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		textCost.setColumns(10);
		textCost.setBounds(22, 280, 300, 35);
		contentPane.add(textCost);
		
		JLabel lblCostTable = new JLabel("재료 가격표");
		lblCostTable.setHorizontalAlignment(SwingConstants.CENTER);
		lblCostTable.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblCostTable.setBounds(340, 10, 123, 30);
		contentPane.add(lblCostTable);
		
		JButton btnInsert = new JButton("입  력");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addFood();
			}
		});
		btnInsert.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnInsert.setBounds(32, 333, 80, 30);
		contentPane.add(btnInsert);
		
		JButton btnDelete = new JButton("삭  제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteIndex();
			}
		});
		btnDelete.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnDelete.setBounds(120, 333, 80, 30);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(340, 44, 432, 517);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		
		JButton btnCancel = new JButton("취  소");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btnCancel.setBounds(672, 571, 100, 30);
		contentPane.add(btnCancel);
		
		JButton btnCreate = new JButton("확  인");
		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCreate.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btnCreate.setBounds(559, 571, 100, 30);
		contentPane.add(btnCreate);
		
		JButton btnInsert_1 = new JButton("검색/초기화");
		btnInsert_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchIngreByKeyword();
			}
		});
		btnInsert_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnInsert_1.setBounds(212, 333, 110, 30);
		contentPane.add(btnInsert_1);
		
		JLabel lblweight = new JLabel("중  량");
		lblweight.setHorizontalAlignment(SwingConstants.CENTER);
		lblweight.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblweight.setBounds(12, 135, 100, 40);
		contentPane.add(lblweight);
		
		textweight = new JTextField();
		textweight.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		textweight.setColumns(10);
		textweight.setBounds(22, 185, 300, 35);
		contentPane.add(textweight);
		
		JLabel lblNewLabel = new JLabel("이용방법!");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel.setBounds(22, 373, 300, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("1. 구매한 재료의 총 중량과 가격을 적어");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_1.setBounds(22, 402, 300, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("주세요.");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_2.setBounds(42, 427, 278, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("2. 이미 있는 재료일 경우엔, 기존가격표");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(22, 459, 300, 30);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("가 수정되요.");
		lblNewLabel_2_1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(42, 484, 278, 30);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("3. 중량과 가격을 적어 주셔야 계산기가");
		lblNewLabel_1_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(22, 515, 300, 30);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("잘 작동해요.");
		lblNewLabel_2_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_2_1_1.setBounds(42, 540, 278, 30);
		contentPane.add(lblNewLabel_2_1_1);
	}

	private void addFood() {
		if(countrow() == 0) {
			String fname = textIngreName.getText();
			Integer fweight = Integer.parseInt(textweight.getText());
			double fcost = Double.parseDouble(textCost.getText());
			double priceforg = (fcost / fweight);
			FoodCost foodcost = new FoodCost(null, fname, fcost, priceforg, null, fweight);
			
			dao.insert(foodcost);
			
			textweight.setText(null);
			textCost.setText(null);
			textIngreName.setText(null);
			
			initializeTable();
		} else {
			String fname = textIngreName.getText();
			Integer fweight = Integer.parseInt(textweight.getText());
			double fcost = Double.parseDouble(textCost.getText());
			double priceforg = (double)(fcost / fweight);
			FoodCost foodcost = new FoodCost(null, fname, fcost, priceforg, null, fweight);
			
			dao.update(foodcost);
			
			textweight.setText(null);
			textCost.setText(null);
			textIngreName.setText(null);
			
			initializeTable();
		}
	}

	private void searchIngreByKeyword() {
		String keyword = textIngreName.getText();
		if(keyword.equals("")) {
			initializeTable();
			return;
		}
		List<FoodCost> list = dao.select(keyword);
		
		model = new DefaultTableModel(null, COLUMN_NAMES);
		table.setModel(model);
		for(FoodCost c : list) {
			Object[] row = {
					c.getFoodNo(), c.getFoodName(), c.getfWeight(), c.getFoodCost()
			};
			model.addRow(row);
			textIngreName.setText(null);
		}
	}
	private int countrow() {
		int result = 0;
		String keyword = textIngreName.getText();
		
		List<FoodCost> list = dao.select(keyword);
		result = list.size();
		
		return result;
	}
	
	private void deleteIndex() {
		int row = table.getSelectedRow();
		if(row == -1) {
			return;
		}
		Integer ingreIndex = (Integer) model.getValueAt(row, 0);
		int confirm = JOptionPane.showConfirmDialog(contentPane, "삭제할까요?","삭제확인",JOptionPane.YES_NO_OPTION);
		if( confirm == JOptionPane.YES_OPTION) {
			int result = dao.delete(ingreIndex);
			if(result == 1) {
				initializeTable();
			} else {
				JOptionPane.showMessageDialog(contentPane, "삭제 실패", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
