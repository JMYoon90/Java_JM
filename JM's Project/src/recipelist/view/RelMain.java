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
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import static recipelist.model.RecipeMain.Entity.*;
import javax.swing.JComboBox;

import recipelist.view.ListCreateFrame.OnListInsertListener;
import recipelist.view.ListUpdateFrame.OnRecipeUpdateListener;

public class RelMain implements OnListInsertListener, OnRecipeUpdateListener {
	private static final String[] COLUMN_NAMES = {
			COL_PRODUCT_NO, COL_PRODUCT_NAME, COL_PRODUCT_CLASS, COL_MODIFIED_DATE
	};

	private JFrame frame;
	private JTable table;
	private JTextField textKeyword;
	private RecipeMainDaoImpl dao;
	private DefaultTableModel model;
	

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
		frame.setBounds(100, 100, 500, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCreateRecipe = new JButton("레시피작성");
		btnCreateRecipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListCreateFrame.newListCreateFrame(frame, RelMain.this);
			}
		});
		btnCreateRecipe.setFont(new Font("D2Coding", Font.PLAIN, 13));
		btnCreateRecipe.setBounds(32, 21, 130, 25);
		frame.getContentPane().add(btnCreateRecipe);
		
		JButton btnCostCreate = new JButton("가격표작성");
		btnCostCreate.setFont(new Font("D2Coding", Font.PLAIN, 13));
		btnCostCreate.setBounds(32, 56, 130, 25);
		frame.getContentPane().add(btnCostCreate);
		
		JButton btnDetailRecipe = new JButton("레시피 상세보기");
		btnDetailRecipe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showDetailFrame();
			}
		});
		btnDetailRecipe.setFont(new Font("D2Coding", Font.PLAIN, 13));
		btnDetailRecipe.setBounds(174, 21, 130, 25);
		frame.getContentPane().add(btnDetailRecipe);
		
		JButton btnDetailCost = new JButton("가격표 상세보기");
		btnDetailCost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDetailCost.setFont(new Font("D2Coding", Font.PLAIN, 13));
		btnDetailCost.setBounds(174, 56, 130, 25);
		frame.getContentPane().add(btnDetailCost);
		
		JButton btnDelete = new JButton("삭  제");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteRecipe();
			}
		});
		btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 13));
		btnDelete.setBounds(316, 56, 130, 25);
		frame.getContentPane().add(btnDelete);
		
		JButton btncalculate = new JButton("단가계산기");
		btncalculate.setFont(new Font("D2Coding", Font.PLAIN, 13));
		btncalculate.setBounds(316, 21, 130, 25);
		frame.getContentPane().add(btncalculate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 110, 440, 442);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 562, 440, 39);
		frame.getContentPane().add(panel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		panel.add(comboBox);
		
		textKeyword = new JTextField();
		textKeyword.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		panel.add(textKeyword);
		textKeyword.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		panel.add(btnNewButton);
	}

	protected void showDetailFrame() {
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
}
