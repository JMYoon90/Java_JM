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
		
		initailizeMenu();
		
	}
	private void initailizeMenu() {
		model = new DefaultTableModel(null, COLUMN_NAMES);
		table.setModel(model);
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
		setTitle("??? ????????? ??????");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int x = parent.getX();
		int y = parent.getY();
		setBounds(x, y, 800, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProduct = new JLabel("?????????");
		lblProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblProduct.setFont(new Font("?????? ??????", Font.BOLD, 16));
		lblProduct.setBounds(12, 10, 90, 30);
		contentPane.add(lblProduct);
		
		textProduct = new JTextField();
		textProduct.setFont(new Font("?????? ??????", Font.PLAIN, 16));
		textProduct.setBounds(112, 10, 150, 30);
		contentPane.add(textProduct);
		textProduct.setColumns(10);
		
		JLabel lblGroup = new JLabel("??????");
		lblGroup.setHorizontalAlignment(SwingConstants.CENTER);
		lblGroup.setFont(new Font("?????? ??????", Font.BOLD, 16));
		lblGroup.setBounds(409, 10, 80, 30);
		contentPane.add(lblGroup);
		
		JLabel lblIngredient = new JLabel("?????????");
		lblIngredient.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngredient.setFont(new Font("?????? ??????", Font.BOLD, 16));
		lblIngredient.setBounds(12, 50, 90, 30);
		contentPane.add(lblIngredient);
		
		JLabel lblWeight = new JLabel("??????(g)");
		lblWeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeight.setFont(new Font("?????? ??????", Font.BOLD, 16));
		lblWeight.setBounds(12, 90, 90, 30);
		contentPane.add(lblWeight);
		
		textIngredient = new JTextField();
		textIngredient.setFont(new Font("?????? ??????", Font.PLAIN, 16));
		textIngredient.setColumns(10);
		textIngredient.setBounds(112, 50, 150, 30);
		contentPane.add(textIngredient);
		
		textWeight = new JTextField();
		textWeight.setFont(new Font("?????? ??????", Font.PLAIN, 16));
		textWeight.setColumns(10);
		textWeight.setBounds(112, 90, 150, 30);
		contentPane.add(textWeight);
		
		JLabel lblEtc = new JLabel("etc.");
		lblEtc.setHorizontalAlignment(SwingConstants.CENTER);
		lblEtc.setFont(new Font("?????? ??????", Font.BOLD, 16));
		lblEtc.setBounds(12, 443, 50, 30);
		contentPane.add(lblEtc);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 444, 312, 111);
		contentPane.add(scrollPane);
		
		textEtcIngre = new JTextArea();
		textEtcIngre.setFont(new Font("?????? ??????", Font.BOLD, 16));
		scrollPane.setViewportView(textEtcIngre);
		
		JLabel lblEtc_1 = new JLabel("  ????????????");
		lblEtc_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblEtc_1.setFont(new Font("?????? ??????", Font.BOLD, 16));
		lblEtc_1.setBounds(398, 50, 374, 30);
		contentPane.add(lblEtc_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(398, 90, 374, 465);
		contentPane.add(scrollPane_1);
		
		textContent = new JTextArea();
		textContent.setFont(new Font("?????? ??????", Font.BOLD, 16));
		scrollPane_1.setViewportView(textContent);
		
		JButton btnCreate = new JButton("??? ???");
		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createNewRecipe();
			}
		});
		btnCreate.setFont(new Font("?????? ??????", Font.BOLD, 18));
		btnCreate.setBounds(560, 565, 100, 35);
		contentPane.add(btnCreate);
		
		JButton btnCancle = new JButton("??? ???");
		btnCancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancle.setFont(new Font("?????? ??????", Font.BOLD, 18));
		btnCancle.setBounds(672, 566, 100, 35);
		contentPane.add(btnCancle);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("?????? ??????", Font.BOLD, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "??????", "??????"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(501, 13, 86, 30);
		contentPane.add(comboBox);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setFont(new Font("?????? ??????", Font.PLAIN, 14));
		scrollPane_2.setBounds(12, 130, 374, 303);
		contentPane.add(scrollPane_2);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		scrollPane_2.setViewportView(table);
		
		JButton btnCreate_1 = new JButton("???  ???");
		btnCreate_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addIngre();
			}
		});
		btnCreate_1.setFont(new Font("?????? ??????", Font.BOLD, 14));
		btnCreate_1.setBounds(274, 50, 110, 30);
		contentPane.add(btnCreate_1);
		
		JButton btnCreate_1_1 = new JButton("???  ???");
		btnCreate_1_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteindex();
			}
		});
		btnCreate_1_1.setFont(new Font("?????? ??????", Font.BOLD, 14));
		btnCreate_1_1.setBounds(274, 91, 110, 30);
		contentPane.add(btnCreate_1_1);
		
		JButton btnSearch = new JButton("??????/?????????");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchIngreByKeyword();
			}
		});
		btnSearch.setFont(new Font("?????? ??????", Font.BOLD, 14));
		btnSearch.setBounds(274, 10, 110, 30);
		contentPane.add(btnSearch);
	}

	private void searchIngreByKeyword() {
		String keyword = textProduct.getText();
		if(keyword.equals(null)) {
			initializeTable();
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
		if (result == 1) { // insert ??????
            JOptionPane.showMessageDialog(this, "??? ????????? ?????? ??????");
            dispose(); // ?????? ??? ??????
            
            listener.OnListInserted();
            
		} else { // insert ??????
            JOptionPane.showMessageDialog(this, 
                    "??? ????????? ?????? ??????", 
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
		int confirm = JOptionPane.showConfirmDialog(contentPane, "????????????????","????????????",JOptionPane.YES_NO_OPTION);
		if( confirm == JOptionPane.YES_OPTION) {
			int result = dao.delete(ingreIndex);
			if(result == 1) {
				initializeTable();
			} else {
				JOptionPane.showMessageDialog(contentPane, "?????? ??????", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void addIngre() {
		String pname = textProduct.getText();
		String iname = textIngredient.getText();
		Integer iweight = Integer.parseInt(textWeight.getText());
		RecipeIngre recipeingre = new RecipeIngre(null, iname, iweight, pname);
		
		int result = dao.insert(recipeingre);
		
		textIngredient.setText(null);
		textWeight.setText(null);
		searchIngreByKeyword();

	}
}
