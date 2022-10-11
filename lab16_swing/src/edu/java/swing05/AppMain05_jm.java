package edu.java.swing05;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain05_jm {
private int n;

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain05_jm window = new AppMain05_jm();
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
    public AppMain05_jm() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        
        ImageIcon[] images = {
                new ImageIcon("images/flower1.jpg"),
                new ImageIcon("images/flower2.jpg"),
                new ImageIcon("images/flower3.jpg"),
                new ImageIcon("images/flower4.jpg"),
                new ImageIcon("images/flower5.jpg"),
        };
        
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        n = 0;
        JLabel lblImage = new JLabel(images[n]);
        lblImage.setBounds(12, 10, 640, 640);
        frame.getContentPane().add(lblImage);
        
        JButton btnPrev = new JButton("이전");
        btnPrev.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                --n;
                if(n == -1) {
                    n = 4;
                } 
                lblImage.setIcon(images[n]);
                frame.getContentPane().add(lblImage);
            }
        });
        
        btnPrev.setFont(new Font("D2Coding", Font.PLAIN, 20));
        btnPrev.setBounds(12, 660, 150, 60);
        frame.getContentPane().add(btnPrev);
        
        JButton btnNext = new JButton("다음");
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ++n;
                if(n == 5) {
                    n = 0;
                }
                lblImage.setIcon(images[n]);
                frame.getContentPane().add(lblImage);
            }
        });
        
        btnNext.setFont(new Font("D2Coding", Font.PLAIN, 20));
        btnNext.setBounds(502, 660, 150, 60);
        frame.getContentPane().add(btnNext);
    }

}
