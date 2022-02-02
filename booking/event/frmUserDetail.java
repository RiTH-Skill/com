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
import javax.swing.UIManager;
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
import javax.swing.JProgressBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class frmUserDetail {

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
					frmUserDetail window = new frmUserDetail();
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
	public frmUserDetail() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Downloads\\icons8_management_64.png"));
		JLabel Client = new JLabel("Client");
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				int id = AssignPassword.getId();
	   			 try {
	   					connectionWithDatabase.connection();
	   					
	   					String sql1 = "SELECT * FROM `eventsmanagementsystem`.`tbl_userregister` WHERE ManagerID = "+id+"";
	   				   
	   					java.sql.Statement s = connectionWithDatabase.getCON().createStatement();    
	   				        ResultSet r1=s.executeQuery(sql1);

	   					if(r1.next()) {
	   						
	   						String name= r1.getString(2);
	   						Client.setText(name);
	   					}
	   					
	   					
	   				} catch (Exception e2) {
	   					
	   				}
			}
		});
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_2_1 = new JButton("Logout");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.main(null);
				frame.dispose();
			}
		});
		btnNewButton_2_1.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Saved Pictures\\logout_rounded_left_50px.png"));
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_2_1.setBackground(Color.RED);
		btnNewButton_2_1.setBounds(1111, 10, 169, 56);
		frame.getContentPane().add(btnNewButton_2_1);
		
		JButton btnNewButton_4 = new JButton("Update Personal Detail");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				
				String getPassword = AssignPassword.getPassword();	
				try {
					connectionWithDatabase.connection();
					
					String sql1 = "SELECT * FROM `eventsmanagementsystem`.`tbl_userregister` WHERE `Password` = "+getPassword+"";
				   
					java.sql.Statement s = connectionWithDatabase.getCON().createStatement();
				    
				        ResultSet r1=s.executeQuery(sql1);

					
					if(r1.next()) {
						
						String name= r1.getString(2);
						String Address= r1.getString(3);
						String Phone= r1.getString(4);						
						String Gender = r1.getString(5);
						String Email= r1.getString(6);
						String Password= r1.getString(7);
						String ConfirmPassword= r1.getString(7);
						
						
						
//						String FN= rs.getString("firstName");
//						    int GL = Integer.parseInt("GradeLevel");
//						    int RL= Integer.parseInt("ReadingLevel");  
//						    textField.setText(FN);
//						    System.out.println(""+FN);
//						    textField_3.setText(String.valueOf(GL));
//						    System.out.println(GL);
//						    textField_2.setText(String.valueOf(RL));

						
						
//						txtName.setText(name);
//						
//						txtEmail.setText(Email);
//						txtPassword.setText(Password);
//						txtPhone.setText(Phone);
//						txtComfirmPassword.setText(ConfirmPassword);
//						edtAddress.setText(Address);
						//cboGender.setText(Gender);
					}
					
				} catch (Exception e2) {
					
				}
				
			}
		});
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPersonDetail.main(null);
				frame.dispose();
			}
		});
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_4.setBackground(Color.BLACK);
		btnNewButton_4.setBounds(40, 87, 257, 546);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton = new JButton("View Venues");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmViewVenue.main(null);
				frame.dispose();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(360, 87, 257, 257);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View FoodItems ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmViewFoodItems.main(null);
				frame.dispose();
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setBounds(659, 87, 257, 257);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View Equipments ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmViewEquipment.main(null);
				frame.dispose();
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setBounds(961, 87, 257, 257);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Book Event");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBookEvent.main(null);
				frame.dispose();
			}
		});
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_3.setBackground(Color.BLACK);
		btnNewButton_3.setBounds(360, 376, 257, 257);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_1_1 = new JButton("Booking View");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmViewHistory.main(null);
				frame.dispose();
			}
		});
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_1_1.setBackground(Color.BLACK);
		btnNewButton_1_1.setBounds(659, 376, 257, 257);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_2_2 = new JButton("View Notification");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String getNotifications = AssignPassword.getNotifications();
//				String getNotifications2 = AssignPassword.getNotifications2();
//				try {
//					if(getNotifications.equals(getNotifications2)) {
//						frmNotificationView.main(null);
//						frame.dispose();
//						}
//					if(!getNotifications.equals(getNotifications2)) {
//					JOptionPane.showMessageDialog(frame,"Before You registration you not check yet");
//					}
//					
//				} catch (Exception e2) {
//				
//
//				}
				frmNotificationView.main(null);
				frame.dispose();
				
				
			}
		});
		btnNewButton_2_2.setForeground(Color.WHITE);
		btnNewButton_2_2.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_2_2.setBackground(Color.BLACK);
		btnNewButton_2_2.setBounds(961, 376, 257, 257);
		frame.getContentPane().add(btnNewButton_2_2);
		
		JLabel lblWelcomeTo = new JLabel("Welcome to ");
		lblWelcomeTo.setFont(new Font("Arial", Font.BOLD, 20));
		lblWelcomeTo.setBounds(10, 10, 123, 56);
		frame.getContentPane().add(lblWelcomeTo);
		
		
//		lblCilent.setFont(new Font("Arial", Font.BOLD, 20));
//		lblCilent.setBounds(132, 10, 123, 56);
//		frame.getContentPane().add(lblCilent);
		
		
		Client.setFont(new Font("Arial", Font.BOLD, 20));
		Client.setBounds(135, 10, 123, 56);
		frame.getContentPane().add(Client);
		frame.setBounds(100, 100, 1304, 721);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
