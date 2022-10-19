package recipelist.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import recipelist.controller.RecipeMainDaoImpl;
import recipelist.model.RecipeMain;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import static recipelist.model.RecipeMain.Entity.*;
import javax.swing.JComboBox;

import recipelist.view.FoodCostFrame.OnCostlistInsertListener;
import recipelist.view.IpriceCal.OnIpriceCalListener;
import recipelist.view.ListCreateFrame.OnListInsertListener;
import recipelist.view.ListUpdateFrame.OnRecipeUpdateListener;
import javax.swing.DefaultComboBoxModel;

public class RelMain implements OnListInsertListener, OnRecipeUpdateListener, OnCostlistInsertListener, OnIpriceCalListener {
	private static final String[] COLUMN_NAMES = {
			COL_PRODUCT_NO, COL_PRODUCT_NAME, COL_PRODUCT_CLASS, COL_MODIFIED_DATE
	};

	private JFrame frame;
	private JTable table;
	private JTextField textKeyword;
	private RecipeMainDaoImpl dao;
	private DefaultTableModel model;
	private JComboBox<String> comboBox;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelMain window = new RelMain();
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
	public RelMain() {
		initialize();
		dao = RecipeMainDaoImpl.getInstance();
		initializeTable();
		
	}

	private void initializeTable() {
		model = new DefaultTableModel(null, COLUMN_NAMES);
		table.setModel(model);
		
		List<RecipeMain> list = dao.select();
		for (RecipeMain r : list) {
			Object[] row = {
					r.getProductNo(), r.getProductName(), r.getProductClass(), r.getModifiedDate()
			};
			model.addRow(row);
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCreateRecipe = new JButton("레시피작성");
		btnCreateRecipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListCreateFrame.newListCreateFrame(frame, RelMain.this);
			}
		});
		btnCreateRecipe.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnCreateRecipe.setBounds(12, 20, 140, 40);
		frame.getContentPane().add(btnCreateRecipe);
		
		JButton btnCostCreate = new JButton("가격표작성");
		btnCostCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FoodCostFrame.newCostlistCreateFrame(frame, RelMain.this);
			}
		});
		btnCostCreate.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnCostCreate.setBounds(322, 20, 140, 40);
		frame.getContentPane().add(btnCostCreate);
		
		JButton btnDetailRecipe = new JButton("상세보기");
		btnDetailRecipe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showDetailFrame();
			}
		});
		btnDetailRecipe.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnDetailRecipe.setBounds(167, 20, 140, 40);
		frame.getContentPane().add(btnDetailRecipe);
		
		JButton btnDelete = new JButton("삭  제");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteRecipe();
			}
		});
		btnDelete.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnDelete.setBounds(632, 20, 140, 40);
		frame.getContentPane().add(btnDelete);
		
		JButton btncalculate = new JButton("단가계산기");
		btncalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showIpriceFreme();
			}
		});
		btncalculate.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btncalculate.setBounds(477, 20, 140, 40);
		frame.getContentPane().add(btncalculate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 70, 760, 482);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 562, 760, 39);
		frame.getContentPane().add(panel);
		
		JButton btnSearch_1 = new JButton("초기화");
		btnSearch_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				initializeTable();
				textKeyword.setText(null);
				
			}
		});
		btnSearch_1.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		panel.add(btnSearch_1);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"이름", "분류"}));
		comboBox.setSelectedIndex(0);
		comboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		panel.add(comboBox);
		
		textKeyword = new JTextField();
		textKeyword.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		panel.add(textKeyword);
		textKeyword.setColumns(10);
		
		JButton btnSearch = new JButton("검  색");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchRecipeKeyword();
			}
		});
		btnSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		panel.add(btnSearch);
	}

	protected void searchRecipeKeyword() {
		String keyword = textKeyword.getText();
		if(keyword.equals("")) { // 검색어 JTextField가 비어 있으면
    		JOptionPane.showMessageDialog(frame, // parentComponent
    				"검색어를 입력하세요.", // message
    				"Warning", // title
    				JOptionPane.WARNING_MESSAGE); // messageType
    		return;
		}
		int type = comboBox.getSelectedIndex();
		List<RecipeMain> list = dao.select(type, keyword);
		
		model = new DefaultTableModel(null, COLUMN_NAMES);
		table.setModel(model);
		for (RecipeMain r : list) {
			Object[] row = {
					r.getProductNo(), r.getProductName(), r.getProductClass(), r.getModifiedDate()
			};
			model.addRow(row);
		}
		
	}

	protected void showIpriceFreme() {
		int row = table.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(frame,
					"계산할 레시피를 선택하세요.",
					"Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Integer listNo = (Integer) model.getValueAt(row, 0);
		
		IpriceCal.IpriceCalFrame(frame,listNo, RelMain.this);
		
		
	}

	private void showDetailFrame() {
		int row = table.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(frame,
					"수정할 레시피를 선택하세요.",
					"Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Integer listNo = (Integer) model.getValueAt(row, 0);
		
		ListUpdateFrame.newRecipeDetailFrame(frame, listNo, RelMain.this);
		
		
		
	}

	private void deleteRecipe() {
		int row = table.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(frame,
					"삭제할 행을 선택해 주세요.",
					"Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Integer recipeNo = (Integer) model.getValueAt(row, 0);
		
		int confirm = JOptionPane.showConfirmDialog(frame,
				 recipeNo + "번 레시피를 정말 삭제할까요?",
				"삭제 확인",
				JOptionPane.YES_NO_OPTION);
		
		if (confirm == JOptionPane.YES_OPTION) {
			int result = dao.delete(recipeNo);
			if (result == 1) {
				JOptionPane.showMessageDialog(frame, recipeNo + "번 레시피 삭제 성공");
				initializeTable();
			} else {
				JOptionPane.showMessageDialog(frame,
						"레시피 삭제 실패",
						"Error",
						JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}

	@Override
	public void OnListInserted() {
		initializeTable();
	}

	@Override
	public void OnRecipeUpdated() {
		initializeTable();
	}

	@Override
	public void OnCostlistInserted() {
	}

	@Override
	public void OnIpriceCal() {
	}
}
