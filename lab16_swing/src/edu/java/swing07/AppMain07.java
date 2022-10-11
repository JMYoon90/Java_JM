package edu.java.swing07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain07 {

    private JFrame frame;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton rbPrivate;
    private JRadioButton rbProtected;
    private JRadioButton rbPackage;
    private JRadioButton rbPublic;
    private JCheckBox cbAbstract;
    private JCheckBox cbFinal;
    private JCheckBox cbStatic;
    private JComboBox comboBox;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain07 window = new AppMain07();
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
    public AppMain07() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 489, 605);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        rbPrivate = new JRadioButton("private");
        rbPrivate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printRadioButtonStatus(e);
            }
        });
        buttonGroup.add(rbPrivate);
        rbPrivate.setFont(new Font("D2Coding", Font.PLAIN, 18));
        rbPrivate.setBounds(8, 6, 111, 55);
        frame.getContentPane().add(rbPrivate);
        
        rbProtected = new JRadioButton("protected");
        rbProtected.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printRadioButtonStatus(e);
            }
        });
        buttonGroup.add(rbProtected);
        rbProtected.setFont(new Font("D2Coding", Font.PLAIN, 18));
        rbProtected.setBounds(238, 6, 111, 55);
        frame.getContentPane().add(rbProtected);
        
        rbPackage = new JRadioButton("package");
        rbPackage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printRadioButtonStatus(e);
            }
        });
        buttonGroup.add(rbPackage);
        rbPackage.setFont(new Font("D2Coding", Font.PLAIN, 18));
        rbPackage.setBounds(123, 6, 111, 55);
        frame.getContentPane().add(rbPackage);
        
        rbPublic = new JRadioButton("public");
        rbPublic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printRadioButtonStatus(e);

            }
        });
        buttonGroup.add(rbPublic);
        rbPublic.setFont(new Font("D2Coding", Font.PLAIN, 18));
        rbPublic.setBounds(353, 6, 111, 55);
        frame.getContentPane().add(rbPublic);
        
        cbAbstract = new JCheckBox("abstract");
        cbAbstract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printCheckboxStatus(e);
            }
        });
        cbAbstract.setFont(new Font("D2Coding", Font.PLAIN, 18));
        cbAbstract.setBounds(8, 75, 111, 40);
        frame.getContentPane().add(cbAbstract);
        
        cbFinal = new JCheckBox("final");
        cbFinal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printCheckboxStatus(e);
            }
        });
        cbFinal.setFont(new Font("D2Coding", Font.PLAIN, 18));
        cbFinal.setBounds(123, 75, 111, 40);
        frame.getContentPane().add(cbFinal);
        
        cbStatic = new JCheckBox("static");
        cbStatic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printCheckboxStatus(e);
            }
        });
        cbStatic.setFont(new Font("D2Coding", Font.PLAIN, 18));
        cbStatic.setBounds(238, 75, 111, 40);
        frame.getContentPane().add(cbStatic);
        
        comboBox = new JComboBox();
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) comboBox.getSelectedItem();
                        textArea.setText(selected + " 선택"); 
            }
        });
        comboBox.setFont(new Font("D2Coding", Font.PLAIN, 18));
        final String[] items = {"naver.com", "kakao.com", "gmail.com", "msn.com"};
        ComboBoxModel<String> model = new DefaultComboBoxModel<>(items);
        comboBox.setModel(model);
        comboBox.setBounds(8, 128, 226, 40);
        frame.getContentPane().add(comboBox);
        
        JButton btnshowinfo = new JButton("확인");
        btnshowinfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printInfo(e);
            }
        });
        btnshowinfo.setBounds(8, 178, 226, 40);
        frame.getContentPane().add(btnshowinfo);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(8, 228, 456, 328);
        frame.getContentPane().add(scrollPane);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("D2Coding", Font.PLAIN, 18));
        scrollPane.setViewportView(textArea);
    }


    protected void printInfo(ActionEvent e) {
        // RadioButton, CheckBox, ComboBox의 상태를 TextArea에 출력.
        StringBuilder buffer = new StringBuilder(); // TextArea에 출력할 문자열을 만들기 위한 객체
        
        // 라디오버튼들 중에서 어떤 버튼이 선택됐는지 
        if(rbPrivate.isSelected()) {
            buffer.append(rbPrivate.getText());
        } else if (rbPackage.isSelected()) {
            buffer.append(rbPackage.getText());
        } else if (rbProtected.isSelected()) {
            buffer.append(rbProtected.getText());
        } else if (rbPublic.isSelected()) {
            buffer.append(rbPublic.getText());
        }
        buffer.append(" 라디오 버튼 선택\n");
        
        
        // 체크박스들 중에서 어떤 체크박스들이 선택됐는 지
        if (cbAbstract.isSelected()) {
            buffer.append(cbAbstract.getText()).append(" ");
        }
        if (cbFinal.isSelected()) {
            buffer.append(cbFinal.getText()).append(" ");
        }
        if (cbStatic.isSelected()) {
            buffer.append(cbStatic.getText()).append(" ");
        }
        buffer.append("체크박스 선택.\n");
        
        // ComboBox의 아이템들 중에서 어떤 아이템이 선택됐는지
        String item = (String) comboBox.getSelectedItem();
        buffer.append(item).append(" 콤보박스 아이템 선택");
        
        // buffer의 내용을 TextArea에 출력
        textArea.setText(buffer.toString());
    }

    protected void printCheckboxStatus(ActionEvent e) {
        JCheckBox checkbox = (JCheckBox) e.getSource();
        String cbText = checkbox.getText();
        boolean selected = checkbox.isSelected();
        textArea.setText(cbText + " : " + selected);
        
    }

    protected void printRadioButtonStatus(ActionEvent e) {
        JRadioButton radioBtn = (JRadioButton) e.getSource(); // 이벤트가 발생한 라디오 버튼
        String btnText = radioBtn.getText(); // 라디오 버튼의 텍스트
        boolean selected = radioBtn.isSelected(); // 라디오버튼의 선택/해제 여부
        textArea.setText(btnText + " : " + selected);
    }
}
