package recipelist.view;

import static recipelist.model.RecipeIngre.Entity.COL_INGRE_INDEX;
import static recipelist.model.RecipeIngre.Entity.COL_INGRE_NAME;
import static recipelist.model.RecipeIngre.Entity.COL_INGRE_WEIGHT;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import recipelist.controller.RecipeIngreDaoImpl;
import recipelist.controller.RecipeMainDaoImpl;
import recipelist.model.FoodCost;
import recipelist.model.RecipeIngre;
import recipelist.model.RecipeMain;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListUpdateFrame extends JFrame {
	private static final String[] COLUMN_NAMES = {
			COL_INGRE_INDEX, COL_INGRE_NAME, COL_INGRE_WEIGHT
	};
	
	public interface OnRecipeUpdateListener {
		void OnRecipeUpdated();
	}

	private JPanel contentPane;
	private JTextField textProduct;
	private JTextField textModifiedDate;
	private JTextField textIngredient;
	private JTextField textWeight;
	private JTable table;
	
	private RecipeIngreDaoImpl ingre_Dao;
	private RecipeMainDaoImpl main_Dao;
	
	private DefaultTableModel model;
	private Component parent;
	private Integer listNo;
	private OnRecipeUpdateListener listener;
	private JTextArea textEtcIngre;
	private JComboBox comboBox;
	private JTextArea textContent;

	/**
	 * Launch the application.
	 */
	public static void newRecipeDetailFrame(Component parent, Integer listNo, OnRecipeUpdateListener listener) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListUpdateFrame frame = new ListUpdateFrame(parent, listNo, listener);
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
	public ListUpdateFrame(Component parent, Integer listNo, OnRecipeUpdateListener listener) {
		this.ingre_Dao = RecipeIngreDaoImpl.getInstance();
		this.main_Dao = RecipeMainDaoImpl.getInstance();
		this.listNo = listNo;
		this.listener = listener;
		this.parent = parent;
		
		initialize();
		
		initializeListData();
		
		searchIngreByKeyword();
		
	}
	
	private void searchIngreByKeyword() {
		String keyword = textProduct.getText();
		if(keyword.equals("")) {
			return;
		}
		List<RecipeIngre> list = ingre_Dao.select(keyword);
		
		model = new DefaultTableModel(null, COLUMN_NAMES);
		table.setModel(model);
		for(RecipeIngre r : list) {
			Object[] row = {
					r.getiIndex(), r.getIngreName(),r.getIngreWeight()
			};
			model.addRow(row);
		}
	}
	
	
	
	private void initializeTable() {
		model = new DefaultTableModel(null, COLUMN_NAMES);
		table.setModel(model);
		
		List<RecipeIngre> list = ingre_Dao.select();
		for(RecipeIngre r : list) {
			Object[] row = {
					r.getiIndex(), r.getIngreName(), r.getIngreWeight()
			};
			model.addRow(row);
		}
		
	}

	private void initializeListData() {
		RecipeMain recipemain = main_Dao.select(listNo);
		if(recipemain != null) {
			textProduct.setText(recipemain.getProductName());
			textEtcIngre.setText(recipemain.getEctIngre());
			textContent.setText(recipemain.getMainContent());
			textModifiedDate.setText(recipemain.getModifiedDate().toString());
			comboBox.setSelectedItem(recipemain.getProductClass());
		}
		
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int x = parent.getX();
		int y = parent.getY();
		setBounds(x, y, 800, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEtc_1 = new JLabel("    만드는법");
		lblEtc_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblEtc_1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblEtc_1.setBounds(398, 90, 374, 30);
		contentPane.add(lblEtc_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(398, 130, 374, 425);
		contentPane.add(scrollPane_1);
		
		textContent = new JTextArea();
		textContent.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		scrollPane_1.setViewportView(textContent);
		
		JButton btnCreate = new JButton("저 장");
		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateNewRecipe();
			}
		});
		btnCreate.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnCreate.setBounds(560, 565, 100, 35);
		contentPane.add(btnCreate);
		
		JButton btnCancle = new JButton("취 소");
		btnCancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancle.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnCancle.setBounds(672, 566, 100, 35);
		contentPane.add(btnCancle);
		
		JLabel lblProduct = new JLabel("제품명");
		lblProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblProduct.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblProduct.setBounds(12, 10, 90, 30);
		contentPane.add(lblProduct);
		
		textProduct = new JTextField();
		textProduct.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textProduct.setColumns(10);
		textProduct.setBounds(103, 10, 150, 30);
		contentPane.add(textProduct);
		
		JButton btnSearch = new JButton("검색/초기화");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchBlogsByKeyword();
			}
		});
		btnSearch.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnSearch.setBounds(265, 11, 110, 30);
		contentPane.add(btnSearch);
		
		JLabel lblGroup = new JLabel("분류");
		lblGroup.setHorizontalAlignment(SwingConstants.CENTER);
		lblGroup.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblGroup.setBounds(409, 10, 80, 30);
		contentPane.add(lblGroup);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "제빵", "제과"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(501, 13, 86, 30);
		contentPane.add(comboBox);
		
		JLabel lblModifiedDate = new JLabel("작성일");
		lblModifiedDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifiedDate.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblModifiedDate.setBounds(409, 50, 80, 30);
		contentPane.add(lblModifiedDate);
		
		textModifiedDate = new JTextField();
		textModifiedDate.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textModifiedDate.setEditable(false);
		textModifiedDate.setColumns(10);
		textModifiedDate.setBounds(501, 50, 271, 30);
		contentPane.add(textModifiedDate);
		
		JButton btnCreate_1 = new JButton("추  가");
		btnCreate_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addIngre();
			}
		});
		btnCreate_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnCreate_1.setBounds(265, 50, 110, 30);
		contentPane.add(btnCreate_1);
		
		textIngredient = new JTextField();
		textIngredient.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textIngredient.setColumns(10);
		textIngredient.setBounds(103, 50, 150, 30);
		contentPane.add(textIngredient);
		
		JLabel lblIngredient = new JLabel("재료명");
		lblIngredient.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngredient.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblIngredient.setBounds(12, 50, 90, 30);
		contentPane.add(lblIngredient);
		
		JLabel lblWeight = new JLabel("중량(g)");
		lblWeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeight.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblWeight.setBounds(12, 90, 90, 30);
		contentPane.add(lblWeight);
		
		textWeight = new JTextField();
		textWeight.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textWeight.setColumns(10);
		textWeight.setBounds(103, 90, 150, 30);
		contentPane.add(textWeight);
		
		JButton btnCreate_1_1 = new JButton("삭  제");
		btnCreate_1_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteindex();
			}
		});
		btnCreate_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnCreate_1_1.setBounds(265, 90, 110, 30);
		contentPane.add(btnCreate_1_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 130, 374, 303);
		contentPane.add(scrollPane_2);
		
		table = new JTable();
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		scrollPane_2.setViewportView(table);
		
		JLabel lblEtc = new JLabel("etc.");
		lblEtc.setHorizontalAlignment(SwingConstants.CENTER);
		lblEtc.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblEtc.setBounds(12, 443, 50, 30);
		contentPane.add(lblEtc);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 444, 312, 111);
		contentPane.add(scrollPane);
		
		textEtcIngre = new JTextArea();
		textEtcIngre.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		scrollPane.setViewportView(textEtcIngre);
	}

	protected void updateNewRecipe() {
		String pname = textProduct.getText();
		String etcIngre = textEtcIngre.getText();
		String content = textContent.getText();
		String productClass = (String) comboBox.getSelectedItem();
		
		RecipeMain recipemain = new RecipeMain(listNo, pname, productClass, null, etcIngre, content);
		
		int result = main_Dao.update(recipemain);
		if (result == 1) {
            JOptionPane.showMessageDialog(this, " 레시피 수정 성공");
            dispose(); // 현재 창 닫기
            
            listener.OnRecipeUpdated();
		} else {
			JOptionPane.showMessageDialog(this, 
                    "새 레시피 작성 실패", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
	}

	private void deleteindex() {
		int row = table.getSelectedRow();
		if(row == -1) {
			return;
		}
		Integer ingreIndex = (Integer) model.getValueAt(row, 0);
		int confirm = JOptionPane.showConfirmDialog(contentPane, "삭제할까요?","삭제확인",JOptionPane.YES_NO_OPTION);
		if( confirm == JOptionPane.YES_OPTION) {
			int result = ingre_Dao.delete(ingreIndex);
			if(result == 1) {
				initializeTable();
			} else {
				JOptionPane.showMessageDialog(contentPane, "삭제 실패", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		searchIngreByKeyword();
	}

	private void addIngre() {
		if(countrow() == 0) {
		String pname = textProduct.getText();
		String iname = textIngredient.getText();
		Integer iweight = Integer.parseInt(textWeight.getText());
		RecipeIngre recipeingre = new RecipeIngre(null, iname, iweight, pname);
		
		int result = ingre_Dao.insert(recipeingre);
		
		textIngredient.setText(null);
		textWeight.setText(null);
		searchIngreByKeyword();
		} else {
			String pname = textProduct.getText();
			String iname = textIngredient.getText();
			Integer iweight = Integer.parseInt(textWeight.getText());
			RecipeIngre recipeingre = new RecipeIngre(null, iname, iweight, pname);
			
			ingre_Dao.update(recipeingre);
			
			textIngredient.setText(null);
			textWeight.setText(null);
			searchIngreByKeyword();
		}

	}
	private int countrow() {
		int result = 0;
		String pNameKeyword = textProduct.getText();
		String ingreKeyword = textIngredient.getText();
		
		List<RecipeIngre> list = ingre_Dao.select(pNameKeyword, ingreKeyword);
		result = list.size();
		
		return result;
	}
	
	protected void searchBlogsByKeyword() {
		String keyword = textProduct.getText();
		if(keyword.equals(null)) {
			initializeTable();
			return;
		}
		List<RecipeIngre> list = ingre_Dao.select(keyword);
		
		model = new DefaultTableModel(null, COLUMN_NAMES);
		table.setModel(model);
		for(RecipeIngre r : list) {
			Object[] row = {
					r.getiIndex(), r.getIngreName(),r.getIngreWeight()
			};
			model.addRow(row);
		}
		
	}
}
