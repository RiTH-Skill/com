package com.booking.event;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;


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
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.Toolkit;

public class frmAdmin {

	private JFrame frame;
	private JTextField txtAdminID;
	private JPasswordField txtPasswordLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmAdmin window = new frmAdmin();
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
	public frmAdmin() {
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
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(null, 2));
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(48, 212, 1187, 323);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_1_2 = new JLabel("AdminID : ");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(131, 29, 97, 24);
		panel.add(lblNewLabel_1_2);
		
		txtAdminID = new JTextField();
		txtAdminID.setForeground(Color.WHITE);
		txtAdminID.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		txtAdminID.setOpaque(false);
		txtAdminID.setFont(new Font("Arial", Font.BOLD, 20));
		txtAdminID.setColumns(10);
		txtAdminID.setBounds(131, 63, 270, 30);
		panel.add(txtAdminID);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Password : ");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1_2_1.setBounds(131, 128, 111, 24);
		panel.add(lblNewLabel_1_2_1);
		
		txtPasswordLogin = new JPasswordField();
		txtPasswordLogin.setForeground(Color.WHITE);
		txtPasswordLogin.setOpaque(false);
		txtPasswordLogin.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		txtPasswordLogin.setFont(new Font("Arial", Font.BOLD, 20));
		txtPasswordLogin.setBounds(131, 159, 270, 30);
		panel.add(txtPasswordLogin);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String AdminID = txtAdminID.getText();
				int ID = (int) Integer.parseInt(txtAdminID.getText());
				String Password = String.valueOf(txtPasswordLogin.getPassword());
				AssignPassword.setId(ID);
				try {				
					java.sql.Statement s = (java.sql.Statement) connectionWithDatabase.getCON().createStatement();	
					java.sql.Statement s1 = (java.sql.Statement) connectionWithDatabase.getCON().createStatement();	
					String sql="SELECT * FROM tbl_adminlogin WHERE Password='"+Password+"' AND AdminID="+AdminID+"";
					String sql1="SELECT * FROM tbl_adminlogin WHERE Password='"+Password+"' ";

					ResultSet r = s.executeQuery(sql);
					ResultSet r1 = s1.executeQuery(sql1);

					if( r.next() && !Password.isEmpty() &&  !(AdminID.isEmpty()) ) {
	
				            	JOptionPane.showMessageDialog(frame, "Your Login Successfully!!");
				            	frmAdminHome.main(null);
								frame.dispose();
					}else if( !Password.isEmpty() &&  AdminID.equals("")){
						JOptionPane.showMessageDialog(frame,"You forgot input Password!");
					}
					else if(  Password.isEmpty()   && AdminID.isEmpty()) {
						JOptionPane.showMessageDialog(frame,"Please input again!! ID and  Password not input yet!");
					}
					else if(  Password.isEmpty()   && !AdminID.isEmpty()) {
						JOptionPane.showMessageDialog(frame,"Please input again!! Password  not input yet!");
					}else if(  r1.next()  && !AdminID.isEmpty()) {
						JOptionPane.showMessageDialog(frame,"Please input again!! Password  not Correct!");
					}
					else JOptionPane.showMessageDialog(frame,"Please input again!! ID  and Password not Correct!");
				
				} catch (Exception e2) {
					
					JOptionPane.showMessageDialog(frame,"Please input ID and Password Before Login");
					
				}
			
				
			}
		});
		btnSubmit.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Saved Pictures\\hand_cursor_50px.png"));
		btnSubmit.setForeground(Color.BLACK);
		btnSubmit.setFont(new Font("Arial", Font.BOLD, 20));
		btnSubmit.setBackground(Color.WHITE);
		btnSubmit.setBounds(346, 242, 170, 40);
		panel.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int show = JOptionPane.showConfirmDialog(frame,"Do u want to cancal?","Please Select Yes or No!!!"
			               ,JOptionPane.YES_NO_CANCEL_OPTION,
			               JOptionPane.INFORMATION_MESSAGE);

				if(show == JOptionPane.YES_OPTION){
		               frmAdmin.main(null);
		               frame.dispose();
		            } else if(show == JOptionPane.NO_OPTION || show == JOptionPane.CANCEL_OPTION){
		               
		            }
			}
		});
		btnCancel.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Saved Pictures\\ca.png"));
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setFont(new Font("Arial", Font.BOLD, 20));
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(632, 242, 170, 40);
		panel.add(btnCancel);
		
		JLabel lblNewLabel_1 = new JLabel("Admin handles");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(634, 10, 111, 40);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Venue Management");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(634, 38, 170, 40);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Food Management");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(634, 71, 170, 40);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Equipment Management");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(632, 99, 170, 40);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Notifications");
		lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1.setBounds(632, 128, 170, 40);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("*Notifications can be sent to only subscribe Event Managers");
		lblNewLabel_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1_1.setBounds(632, 178, 477, 40);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHome.main(null);
				frame.dispose();
			}
		});
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Arial", Font.BOLD, 20));
		btnHome.setBackground(Color.BLACK);
		btnHome.setBounds(48, 85, 210, 54);
		frame.getContentPane().add(btnHome);
		frame.setBounds(100, 100, 1304, 721);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
