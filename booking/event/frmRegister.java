package com.booking.event;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.sql.Statement;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import javax.swing.border.MatteBorder;
import java.awt.Toolkit;

public class frmRegister {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JPasswordField txtComfirmPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmRegister window = new frmRegister();
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
	public frmRegister() {
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
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(48, 174, 1189, 452);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name : ");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setBounds(42, 23, 70, 33);
		panel.add(lblNewLabel_1);
		
		txtName = new JTextField();
		txtName.setOpaque(false);
		txtName.setForeground(Color.WHITE);
		txtName.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		txtName.setFont(new Font("Arial", Font.BOLD, 20));
		txtName.setBounds(122, 24, 277, 29);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		txtPhone.setForeground(Color.WHITE);
		txtPhone.setOpaque(false);
		txtPhone.setFont(new Font("Arial", Font.BOLD, 20));
		txtPhone.setColumns(10);
		txtPhone.setBounds(851, 24, 277, 29);
		panel.add(txtPhone);
		
		JLabel lblNewLabel_1_1 = new JLabel("Phone :");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(760, 23, 84, 33);
		panel.add(lblNewLabel_1_1);
		
		txtEmail = new JTextField();
		txtEmail.setOpaque(false);
		txtEmail.setForeground(Color.WHITE);
		txtEmail.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		txtEmail.setFont(new Font("Arial", Font.BOLD, 20));
		txtEmail.setColumns(10);
		txtEmail.setBounds(851, 100, 277, 29);
		panel.add(txtEmail);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email : ");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(771, 99, 70, 33);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Comfirm Password : ");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1_2_1.setBounds(644, 255, 197, 33);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Password : ");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(730, 179, 111, 33);
		panel.add(lblNewLabel_1_1_1);
		
		txtPassword = new JPasswordField();
		txtPassword.setOpaque(false);
		txtPassword.setForeground(Color.WHITE);
		txtPassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		txtPassword.setFont(new Font("Arial", Font.BOLD, 20));
		txtPassword.setBounds(851, 179, 293, 29);
		panel.add(txtPassword);
		
		txtComfirmPassword = new JPasswordField();
		txtComfirmPassword.setForeground(Color.WHITE);
		txtComfirmPassword.setOpaque(false);
		txtComfirmPassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		txtComfirmPassword.setFont(new Font("Arial", Font.BOLD, 20));
		txtComfirmPassword.setBounds(851, 255, 293, 29);
		panel.add(txtComfirmPassword);
		
		JLabel lblNewLabel_1_3 = new JLabel("Gender :");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(28, 96, 84, 33);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Address : ");
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1_4.setBounds(21, 179, 102, 33);
		panel.add(lblNewLabel_1_4);
		
		JComboBox cboGender = new JComboBox();
		cboGender.setFont(new Font("Arial", Font.BOLD, 20));
		cboGender.setBackground(Color.WHITE);
		cboGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		cboGender.setBounds(122, 92, 277, 29);
		panel.add(cboGender);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(133, 189, 267, 95);
		panel.add(scrollPane);
		
		JEditorPane edtAddress = new JEditorPane();
		edtAddress.setFont(new Font("Arial", Font.BOLD, 20));
		scrollPane.setViewportView(edtAddress);
		
		JButton btnRegisterUser = new JButton("Register");
		btnRegisterUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = txtName.getText();
				//long phone = (long) Float.parseFloat(txtPhone.getText());
				//BigDecimal getPhone = BigDecimal.valueOf(phone);
				String getPhone = txtPhone.getText();
				String Address = edtAddress.getText();
				String Gender;

				String Password = String.valueOf(txtPassword.getPassword());
				String CPassword = String.valueOf(txtComfirmPassword.getPassword());
				String Email = txtEmail.getText();
				
//				if(Email.contains("@gmail.com") || Email.contains("@email.com")) {
//					
//				}else JOptionPane.showMessageDialog(frame,"Incorrect Email");
				
				
				
//				String notification = "";
//				
//				if(ckNotification.isSelected()) {
//					notification="follow";
//				}else notification="unfollow";
//				
//				AssignPassword.setNotifications("follow");
//				AssignPassword.setNotifications2(notification);
				
				
				
				
				
				
				AssignPassword.setPassword(Password);
				AssignPassword.setName(name);
				
				
				if(cboGender.getSelectedIndex()==-1) {
					JOptionPane.showConfirmDialog(frame,"Please Select Sex");
				}
				if(cboGender.getSelectedIndex()==0) {
					Gender = "Male";
				}else  
					Gender = "Female";
				
				
				try {

					if((Password.equals(CPassword) && (!Password.isEmpty() && !CPassword.isEmpty()) ) &&  !(name.isEmpty()) &&  !(Email.isEmpty()) && (Email.contains("@gmail.com") || Email.contains("@email.com")) && !(Address.isEmpty()) ) {
						
						
						Random r = new Random();
						int i =(int) (Math.random() * 9999);
						if(i>=0000 && i<=8999) {
						i=i+1000;
						
						String sql2 = "INSERT INTO `eventsmanagementsystem`.`tbl_userregister` (`Name`, `Address`, `Phone`, `Gender`, `Email`, `ManagerID`) VALUES ('"+name+"', '"+Address+"', "+getPhone+",'"+Gender+"', '"+Email+"', '"+i+"')";
						//INSERT INTO `eventsmanagementsystem`.`tbl_userregister` (`Name`, `Address`, `Phone`, `Gender`, `Email`, `ManagerID`) VALUES ('333', '333', 333, '333', '333@gmail.com', 3421)
						java.sql.Statement s =  connectionWithDatabase.getCON().createStatement();	
						java.sql.Statement s1 =  connectionWithDatabase.getCON().createStatement();		
						
						s1.execute(sql2);
						
						
						String sql = "INSERT INTO `eventsmanagementsystem`.`tbl_userlogin` (`ID`, `Password`) VALUES ("+i+", '"+Password+"')";
						s.execute(sql);
						JOptionPane.showMessageDialog(frame,"Your Created Successfully!!"+"\n"+"You ID : "+i+"\n"+"You Password : "+Password);
                        
						}
						frame.dispose();
		               frmLogin.main(null);
					}
					
					
					
					else if(!(Password.equals(CPassword) || (Password.isEmpty() || CPassword.isEmpty()) ) ||  (name.isEmpty()) ||  (Email.isEmpty()) || (Email.contains("@gmail.com") || Email.contains("@email.com")) || (Address.isEmpty()) ) {
						
						JOptionPane.showMessageDialog(frame,"Create again you forgot something!!");
						
					}
					
					
					//password
					else if(!(Password.equals(CPassword) && (!Password.isEmpty() && !CPassword.isEmpty()) ) &&  !(name.isEmpty()) &&  !(Email.isEmpty()) && (Email.contains("@gmail.com") || Email.contains("@email.com")) && !(Address.isEmpty()) ) {
				    	JOptionPane.showMessageDialog(frame,"Password and ComfirmPassword not Correct");	
					}
					
					
					
					
					//name
					else if((Password.equals(CPassword) && (!Password.isEmpty() && !CPassword.isEmpty()) ) &&  (name.isEmpty()) &&  !(Email.isEmpty()) && (Email.contains("@gmail.com") || Email.contains("@email.com")) && !(Address.isEmpty()) ) {
				    	JOptionPane.showMessageDialog(frame," Name not Input yet");	
					}
					
					
					
					//email
					else if((Password.equals(CPassword) && (!Password.isEmpty() && !CPassword.isEmpty()) ) &&  !(name.isEmpty()) &&  Email.isEmpty()  ) {
				    	JOptionPane.showMessageDialog(frame," Email not Input yet");	
					}
					
					
					
					//address
					else if((Password.equals(CPassword) && (!Password.isEmpty() && !CPassword.isEmpty()) ) &&  !(name.isEmpty()) &&  !(Email.isEmpty()) && (Email.contains("@gmail.com") || Email.contains("@email.com")) && (Address.isEmpty()) ) {
				    	JOptionPane.showMessageDialog(frame,"Please input your Address");	
					}
					
					
				
				
			      }catch (Exception e2) {
					
						JOptionPane.showMessageDialog(frame,"Phone Number can't greater than 16 digits");
				}
					
				
				
			}
		});
		btnRegisterUser.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Saved Pictures\\tick.png"));
		btnRegisterUser.setForeground(Color.BLACK);
		btnRegisterUser.setFont(new Font("Arial", Font.BOLD, 20));
		btnRegisterUser.setBackground(Color.WHITE);
		btnRegisterUser.setBounds(342, 377, 170, 40);
		panel.add(btnRegisterUser);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int show = JOptionPane.showConfirmDialog(frame,"Do u want to cancal?","Please Select Yes or No!!!"
			               ,JOptionPane.YES_NO_CANCEL_OPTION,
			               JOptionPane.INFORMATION_MESSAGE);

				if(show == JOptionPane.YES_OPTION){
		               frmRegister.main(null);
		               frame.dispose();
		            } else if(show == JOptionPane.NO_OPTION || show == JOptionPane.CANCEL_OPTION){
		               
		            }
				
			}
		});
		btnCancel.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Saved Pictures\\ca.png"));
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setFont(new Font("Arial", Font.BOLD, 20));
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(628, 377, 170, 40);
		panel.add(btnCancel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 1189, 452);
		panel.add(lblNewLabel_2);
		frame.setBounds(100, 100, 1304, 721);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
