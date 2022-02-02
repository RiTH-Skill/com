package com.booking.event;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class frmHome {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		} catch (Exception e) {
			// TODO: handle exception
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmHome window = new frmHome();
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
	public frmHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Downloads\\icons8_management_64.png"));
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				
				
				try {
					connectionWithDatabase.connection();
					//JOptionPane.showMessageDialog(frame, "Connection Success");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(frame, e);
				}
				
			}
		});
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Event Management System");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 40));
		lblNewLabel.setBounds(422, -18, 546, 88);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHome.setFont(new Font("Arial", Font.BOLD, 20));
		btnHome.setBackground(Color.BLACK);
		btnHome.setForeground(Color.WHITE);
		btnHome.setBounds(48, 85, 210, 54);
		frame.getContentPane().add(btnHome);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRegister.main(null);
				frame.dispose();
			}
		});
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Arial", Font.BOLD, 20));
		btnRegister.setBackground(Color.BLACK);
		btnRegister.setBounds(377, 85, 210, 54);
		frame.getContentPane().add(btnRegister);
		
		JButton btnHome_1_1 = new JButton("Admin");
		btnHome_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdmin.main(null);
				frame.dispose();
			}
		});
		btnHome_1_1.setForeground(Color.WHITE);
		btnHome_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		btnHome_1_1.setBackground(Color.BLACK);
		btnHome_1_1.setBounds(1025, 85, 210, 54);
		frame.getContentPane().add(btnHome_1_1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.main(null);
				frame.dispose();
			}
		});
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Arial", Font.BOLD, 20));
		btnLogin.setBackground(Color.BLACK);
		btnLogin.setBounds(696, 85, 210, 54);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Screenshots\\Screenshot (284).png"));
		lblNewLabel_1.setBounds(10, 187, 1270, 386);
		frame.getContentPane().add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 175, 1270, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 583, 1270, 2);
		frame.getContentPane().add(separator_1);
		
		JLabel lblEventPlanningRequire = new JLabel("Event planning require foresight, follow through and attention to detail. You need to see the big picture as well as the tiniest of details. You need Vision. Which is why we \r\n");
		lblEventPlanningRequire.setFont(new Font("Arial", Font.BOLD, 15));
		lblEventPlanningRequire.setBounds(45, 598, 1245, 30);
		frame.getContentPane().add(lblEventPlanningRequire);
		
		JLabel lblDevelopEventManagement = new JLabel("develop Event Management System. No matter what stage of the planning you're in,this system welcome the opportunity to help you make your event the best it can be.  ");
		lblDevelopEventManagement.setFont(new Font("Arial", Font.BOLD, 15));
		lblDevelopEventManagement.setBounds(20, 627, 1260, 30);
		frame.getContentPane().add(lblDevelopEventManagement);
		frame.setBounds(100, 100, 1304, 721);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
