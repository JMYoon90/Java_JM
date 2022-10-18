package recipelist.view;

import static recipelist.model.RecipeIngre.Entity.*;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import recipelist.controller.RecipeIngreDaoImpl;
import recipelist.controller.RecipeMainDaoImpl;
import recipelist.model.RecipeIngre;
import recipelist.model.RecipeMain;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class ListCreateFrame extends JFrame {
	private static final String[] COLUMN_NAMES = {
			COL_INGRE_INDEX, COL_INGRE_NAME, COL_INGRE_WEIGHT
	};
	
	public interface OnListInsertListener {
		void OnListInserted();
	}

	private OnListInsertListener listener;
	private Component parent;
	private RecipeIngreDaoImpl dao;
	private RecipeMainDaoImpl mDao;
	
	private JPanel contentPane;
	private JTextField textProduct;
	private JTextField textModifiedDate;
	private JTextField textIngredient;
	private JTextField textWeight;
	private JTextArea textEtcIngre;
	private JScrollPane scrollPane_2;
	private JTable table;
	private DefaultTableModel model;
	private JComboBox comboBox;
	private JTextArea textContent;


	/**
	 * Launch the application.
	 */
	public static void newListCreateFrame(Component parent, OnListInsertListener listener) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListCreateFrame frame = new ListCreateFrame(parent, listener);
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
	
	public ListCreateFrame(Component parent, OnListInsertListener listener) {
		this.listener = listener;
		this.parent = parent;
		this.dao = RecipeIngreDaoImpl.getInstance();
		this.mDao = RecipeMainDaoImpl.getInstance();
		
		
		initialize();
		
		initializeTable();
		
	}
	private void initializeTable() {
		model = new DefaultTableModel(null, COLUMN_NAMES);
		table.setModel(model);
		
		List<RecipeIngre> list = dao.select();
		for(RecipeIngre r : list) {
			Object[] row = {
					r.getiIndex(), r.getIngreName(), r.getIngreWeight()
			};
			model.addRow(row);
		}
	}

	private void initialize() {
		setTitle("새 레시피 작성");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int x = parent.getX();
		int y = parent.getY();
		setBounds(x, y, 800, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProduct = new JLabel("제품명");
		lblProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblProduct.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblProduct.setBounds(12, 10, 100, 30);
		contentPane.add(lblProduct);
		
		textProduct = new JTextField();
		textProduct.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textProduct.setBounds(114, 10, 180, 30);
		contentPane.add(textProduct);
		textProduct.setColumns(10);
		
		JLabel lblGroup = new JLabel("분류");
		lblGroup.setHorizontalAlignment(SwingConstants.CENTER);
		lblGroup.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblGroup.setBounds(409, 10, 80, 30);
		contentPane.add(lblGroup);
		
		JLabel lblModifiedDate = new JLabel("작성일");
		lblModifiedDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifiedDate.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblModifiedDate.setBounds(634, 10, 80, 30);
		contentPane.add(lblModifiedDate);
		
		textModifiedDate = new JTextField();
		textModifiedDate.setEditable(false);
		textModifiedDate.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textModifiedDate.setColumns(10);
		textModifiedDate.setBounds(634, 50, 138, 30);
		contentPane.add(textModifiedDate);
		
		JLabel lblIngredient = new JLabel("재료명");
		lblIngredient.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngredient.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblIngredient.setBounds(12, 50, 100, 30);
		contentPane.add(lblIngredient);
		
		JLabel lblWeight = new JLabel("중량(g)");
		lblWeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeight.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblWeight.setBounds(12, 90, 100, 30);
		contentPane.add(lblWeight);
		
		textIngredient = new JTextField();
		textIngredient.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textIngredient.setColumns(10);
		textIngredient.setBounds(114, 50, 180, 30);
		contentPane.add(textIngredient);
		
		textWeight = new JTextField();
		textWeight.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		textWeight.setColumns(10);
		textWeight.setBounds(114, 90, 180, 30);
		contentPane.add(textWeight);
		
		JLabel lblEtc = new JLabel("etc.");
		lblEtc.setHorizontalAlignment(SwingConstants.CENTER);
		lblEtc.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblEtc.setBounds(12, 443, 50, 30);
		contentPane.add(lblEtc);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 444, 312, 111);
		contentPane.add(scrollPane);
		
		textEtcIngre = new JTextArea();
		textEtcIngre.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		scrollPane.setViewportView(textEtcIngre);
		
		JLabel lblEtc_1 = new JLabel("만드는법( 판서 )");
		lblEtc_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblEtc_1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblEtc_1.setBounds(398, 50, 374, 30);
		contentPane.add(lblEtc_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(398, 90, 374, 465);
		contentPane.add(scrollPane_1);
		
		textContent = new JTextArea();
		textContent.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		scrollPane_1.setViewportView(textContent);
		
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
		btnCancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancle.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnCancle.setBounds(672, 566, 100, 35);
		contentPane.add(btnCancle);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "제빵", "제과"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(501, 13, 86, 30);
		contentPane.add(comboBox);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 130, 374, 303);
		contentPane.add(scrollPane_2);
		
		table = new JTable();
		scrollPane_2.setViewportView(table);
		
		JButton btnCreate_1 = new JButton("추가");
		btnCreate_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addIngre();
			}
		});
		btnCreate_1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btnCreate_1.setBounds(306, 50, 80, 30);
		contentPane.add(btnCreate_1);
		
		JButton btnCreate_1_1 = new JButton("삭제");
		btnCreate_1_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteindex();
			}
		});
		btnCreate_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btnCreate_1_1.setBounds(306, 90, 80, 30);
		contentPane.add(btnCreate_1_1);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchIngreByKeyword();
			}
		});
		btnSearch.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btnSearch.setBounds(304, 10, 80, 30);
		contentPane.add(btnSearch);
	}

	private void searchIngreByKeyword() {
		String keyword = textProduct.getText();
		if(keyword.equals("")) {
			return;
		}
		List<RecipeIngre> list = dao.select(keyword);
		
		model = new DefaultTableModel(null, COLUMN_NAMES);
		table.setModel(model);
		for(RecipeIngre r : list) {
			Object[] row = {
					r.getiIndex(), r.getIngreName(),r.getIngreWeight()
			};
			model.addRow(row);
		}
	}

	protected void createNewRecipe() {
		String pname = textProduct.getText();
		String etcIngre = textEtcIngre.getText();
		String content = textContent.getText();
		String productClass = (String) comboBox.getSelectedItem();
		
		RecipeMain recipemain = new RecipeMain(null, pname, productClass, null, etcIngre, content);
		
		int result = mDao.insert(recipemain);
		if (result == 1) { // insert 성공
            JOptionPane.showMessageDialog(this, "새 레시피 작성 성공");
            dispose(); // 현재 창 닫기
            
            listener.OnListInserted();
            
		} else { // insert 실패
            JOptionPane.showMessageDialog(this, 
                    "새 레시피 작성 실패", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
		
	}

	protected void deleteindex() {
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

	private void addIngre() {
		String pname = textProduct.getText();
		String iname = textIngredient.getText();
		Integer iweight = Integer.parseInt(textWeight.getText());
		RecipeIngre recipeingre = new RecipeIngre(null, iname, iweight, pname);
		
		int result = dao.insert(recipeingre);
		
		initializeTable();

	}
}
