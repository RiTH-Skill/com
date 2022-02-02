package com.booking.event;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.sql.ResultSet;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import com.mysql.cj.xdevapi.Statement;


import javax.swing.JSeparator;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JEditorPane;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import javax.swing.border.MatteBorder;
import java.awt.Toolkit;

public class frmLogin {

	private JFrame frame;
	private JTextField txtEventManagerID;
	private JPasswordField txtPasswordLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin window = new frmLogin();
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
	public frmLogin() {
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
				frmHome.main(null);
				frame.dispose();
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
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Arial", Font.BOLD, 20));
		btnLogin.setBackground(Color.BLACK);
		btnLogin.setBounds(696, 85, 210, 54);
		frame.getContentPane().add(btnLogin);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.BLACK);
		panel.setBounds(48, 169, 1187, 275);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Event ManagerID  : ");
		lblNewLabel_1_2.setBounds(97, 20, 198, 24);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(lblNewLabel_1_2);
		
		txtEventManagerID = new JTextField();
		txtEventManagerID.setForeground(Color.WHITE);
		txtEventManagerID.setBackground(Color.RED);
		txtEventManagerID.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		txtEventManagerID.setOpaque(false);
		txtEventManagerID.setMargin(new Insets(0, 0, 2, 0));
		txtEventManagerID.setBounds(97, 54, 270, 30);
		txtEventManagerID.setFont(new Font("Arial", Font.BOLD, 20));
		txtEventManagerID.setColumns(10);
		panel.add(txtEventManagerID);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Password : ");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1_2_1.setBounds(98, 105, 111, 24);
		panel.add(lblNewLabel_1_2_1);
		
		txtPasswordLogin = new JPasswordField();
		txtPasswordLogin.setForeground(Color.WHITE);
		txtPasswordLogin.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		txtPasswordLogin.setOpaque(false);
		txtPasswordLogin.setFont(new Font("Arial", Font.BOLD, 20));
		txtPasswordLogin.setBounds(97, 149, 270, 30);
		panel.add(txtPasswordLogin);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = txtEventManagerID.getText();
				int ID = (int) Integer.parseInt(txtEventManagerID.getText());
				String Password = String.valueOf(txtPasswordLogin.getPassword());
				
				
				try {
						java.sql.Statement s =  connectionWithDatabase.getCON().createStatement();
						String sql="SELECT * FROM `eventsmanagementsystem`.`tbl_userlogin` WHERE ID="+ID+" AND Password='"+Password+"'";
						ResultSet r = s.executeQuery(sql);
						
						if( r.next() && !Password.isEmpty() ) {
					
							AssignPassword.setPassword(Password);
							AssignPassword.setId(ID);
							

						JOptionPane.showMessageDialog(frame, "Your Login Successfully!!");
		            	frmUserDetail.main(null);
						frame.dispose();

						}
						else 
						JOptionPane.showMessageDialog(frame, "Try again");
						
					
					
					} catch (Exception e2) {
						
						JOptionPane.showMessageDialog(frame, e);
						
					}
				
				
				
				
				
			}
		});
		btnSubmit.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Saved Pictures\\hand_cursor_50px.png"));
		btnSubmit.setForeground(Color.BLACK);
		btnSubmit.setFont(new Font("Arial", Font.BOLD, 20));
		btnSubmit.setBackground(Color.WHITE);
		btnSubmit.setBounds(348, 198, 170, 40);
		panel.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// int show = JOptionPane.showConfirmDialog(frame,"Do u want to cancal?");
				
				int show = JOptionPane.showConfirmDialog(frame,"Do u want to cancal?","Please Select Yes or No!!!"
			               ,JOptionPane.YES_NO_CANCEL_OPTION,
			               JOptionPane.INFORMATION_MESSAGE);

				if(show == JOptionPane.YES_OPTION){
		              
		               frmLogin.main(null);
		               frame.dispose();
		            } else if(show == JOptionPane.NO_OPTION || show == JOptionPane.CANCEL_OPTION){
		               
		            }
			}
		});
		btnCancel.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Saved Pictures\\ca.png"));
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setFont(new Font("Arial", Font.BOLD, 20));
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(634, 198, 170, 40);
		panel.add(btnCancel);
		
		JLabel lblNewLabel_1 = new JLabel("Event operations and logistics is where all the time spent.");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(637, 20, 540, 40);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Planning the event comes together in the execution of the event.");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(637, 71, 540, 40);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Save your time by booking for any event using our system.");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(637, 121, 540, 40);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Saved Pictures\\images.jpg"));
		lblNewLabel_2.setBounds(50, 467, 227, 195);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Saved Pictures\\flat-golden-circle-balloons-birthday-background_52683-34659.jpg"));
		lblNewLabel_2_1.setBounds(287, 467, 227, 195);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("");
		lblNewLabel_2_2_1.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Saved Pictures\\Event-Management-Banner.jpg"));
		lblNewLabel_2_2_1.setBounds(524, 467, 227, 195);
		frame.getContentPane().add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("");
		lblNewLabel_2_2_1_1.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Saved Pictures\\download (2).jpg"));
		lblNewLabel_2_2_1_1.setBounds(766, 467, 227, 195);
		frame.getContentPane().add(lblNewLabel_2_2_1_1);
		
		JLabel lblNewLabel_2_2_1_2 = new JLabel("");
		lblNewLabel_2_2_1_2.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Saved Pictures\\images (1).jpg"));
		lblNewLabel_2_2_1_2.setBounds(1008, 467, 227, 195);
		frame.getContentPane().add(lblNewLabel_2_2_1_2);
		frame.setBounds(100, 100, 1304, 721);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
