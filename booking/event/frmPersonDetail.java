package com.booking.event;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.sql.ResultSet;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import events.booking.management.system.Client;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class frmPersonDetail {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPersonDetail window = new frmPersonDetail();
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
	public frmPersonDetail() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Downloads\\icons8_management_64.png"));
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		frame.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
			}
		});
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(133, 189, 267, 95);
				panel.add(scrollPane);
				
				JEditorPane edtAddress = new JEditorPane();
				edtAddress.setFont(new Font("Arial", Font.BOLD, 20));
				scrollPane.setViewportView(edtAddress);


		
		
		frame.addMouseListener(new MouseAdapter() {
	
				
				
				
			


		});

		JComboBox cboGender = new JComboBox();
		cboGender.setBounds(122, 92, 277, 29);
		cboGender.setFont(new Font("Arial", Font.BOLD, 20));
		cboGender.setBackground(Color.WHITE);
		cboGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		panel.add(cboGender);

		JLabel lblClient = new JLabel("Client");
		lblClient.setFont(new Font("Arial", Font.BOLD, 20));
		lblClient.setBounds(126, 10, 431, 56);
		frame.getContentPane().add(lblClient);

		frame.addWindowListener(new WindowAdapter() {
			
			
			@Override
			public void windowOpened(WindowEvent e) {
				
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				String getPassword = AssignPassword.getPassword();	
				int id = AssignPassword.getId();
				try {
					connectionWithDatabase.connection();
					
					String sql1 = "SELECT * FROM `eventsmanagementsystem`.`tbl_userregister`  WHERE `ManagerID` = "+id+"";
				   
					java.sql.Statement s = connectionWithDatabase.getCON().createStatement();
				    
				        ResultSet r1=s.executeQuery(sql1);

					
					if(r1.next()) {
						
						String name= r1.getString(2);
						String Address= r1.getString(3);
						//long Phone = Long.parseLong(3);
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

						
						txtName.setText(name);
						
						txtEmail.setText(Email);
						//txtPassword.setText(Password);
						//txtPassword.setText(AssignPassword.getPassword());
						txtPhone.setText(Phone);
						//txtComfirmPassword.setText(ConfirmPassword);
						edtAddress.setText(Address);
						lblClient.setText(name);
//						 String item = cboGender.getEditor().getItem().toString();
//						cboGender.getEditor().setItem(item);
						cboGender.setSelectedItem(Gender);
					}
					
				} catch (Exception e2) {
					
				}
				
				

				
				
				
				
				
				
			}
			

		});
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
	//	JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(48, 103, 1189, 485);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Name : ");
		lblNewLabel_1.setBounds(42, 23, 70, 33);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(lblNewLabel_1);
		
		txtName = new JTextField();
		txtName.setBounds(122, 24, 277, 29);
		txtName.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(806, 92, 277, 29);
		txtPhone.setFont(new Font("Arial", Font.BOLD, 20));
		txtPhone.setColumns(10);
		panel.add(txtPhone);
		
		JLabel lblNewLabel_1_1 = new JLabel("Phone :");
		lblNewLabel_1_1.setBounds(712, 92, 84, 33);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(lblNewLabel_1_1);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(805, 208, 277, 29);
		txtEmail.setFont(new Font("Arial", Font.BOLD, 20));
		txtEmail.setColumns(10);
		panel.add(txtEmail);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email : ");
		lblNewLabel_1_2.setBounds(725, 207, 70, 33);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Gender :");
		lblNewLabel_1_3.setBounds(28, 96, 84, 33);
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Address : ");
		lblNewLabel_1_4.setBounds(21, 179, 102, 33);
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(lblNewLabel_1_4);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(504, 377, 170, 40);
		btnUpdate.addMouseListener(new MouseAdapter() {

		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				
				String name = txtName.getText();
//				long phone = (long) Float.parseFloat(txtPhone.getText());
//				BigDecimal getPhone = BigDecimal.valueOf(phone);p
				String phone = txtPhone.getText();
				String Address = edtAddress.getText();
				String Gender;
				
				String Email = txtEmail.getText();
				String getPassword = AssignPassword.getPassword();
	            int getID = AssignPassword.getId();
	            
	            
				if(cboGender.getSelectedIndex()==0) {
					Gender = "Male";
				}else  
					Gender = "Female";
				
				String getPassword1 = AssignPassword.getPassword();	
				
				try {
					connectionWithDatabase.connection();
					if( !(name.isEmpty()) &&  !(Email.isEmpty()) && (Email.contains("@gmail.com") || Email.contains("@email.com")) && !(Address.isEmpty()) ) {
					java.sql.Statement s = connectionWithDatabase.getCON().createStatement();
					String sql = "UPDATE `eventsmanagementsystem`.`tbl_userregister` SET `Name` = '"+name+"', `Address` = '"+Address+"', `Phone` = "+phone+", `Gender` = '"+Gender+"', `Email` = '"+Email+"' WHERE ManagerID='"+getID+"'";

					
				   s.execute(sql);

				   JOptionPane.showMessageDialog(frame,"Updated Succues");

				   s.close();
					}
				
				} catch (Exception e2) {
					
				}
				
				
				
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				

				

			}
			
		});
		btnUpdate.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Saved Pictures\\update_left_rotation_50px.png"));
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setFont(new Font("Arial", Font.BOLD, 20));
		btnUpdate.setBackground(Color.GREEN);
		panel.add(btnUpdate);
		
		JLabel lblupdateYourPersonal = new JLabel("*Update Your Personal Information!!");
		lblupdateYourPersonal.setBounds(28, 419, 360, 56);
		lblupdateYourPersonal.setForeground(Color.WHITE);
		lblupdateYourPersonal.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(lblupdateYourPersonal);
		
		JLabel lblWelcomeTo = new JLabel("Welcome to ");
		lblWelcomeTo.setFont(new Font("Arial", Font.BOLD, 20));
		lblWelcomeTo.setBounds(10, 10, 123, 56);
		frame.getContentPane().add(lblWelcomeTo);
		
		
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Saved Pictures\\left_arrow_50px.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmUserDetail.main(null);
				frame.dispose();
				
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setBounds(1150, 10, 130, 40);
		frame.getContentPane().add(btnNewButton_2);
		frame.setBounds(100, 100, 1304, 721);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	

	
}



