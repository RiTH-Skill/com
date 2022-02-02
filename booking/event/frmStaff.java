package com.booking.event;

import java.awt.EventQueue;


import javax.swing.JFrame;


import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.System.Logger;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

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
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import java.awt.Toolkit;

public class frmStaff {

	private JFrame frame;
	private JTable table;
	private JTextField txtSearch;
	private JTable table_1;
	private JTextField txtID;
	private JTextField txtPosition;
	private JTextField txtStatus;

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
					frmStaff window = new frmStaff();
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
	public frmStaff() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Downloads\\icons8_management_64.png"));
		
		
		
		
		
		
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Admin");
		lblNewLabel.setBounds(10, 10, 193, 56);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_2_1 = new JButton("Back");
		btnNewButton_2_1.setBounds(1111, 10, 169, 43);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdminHome.main(null);
				frame.dispose();
			}
		});
		btnNewButton_2_1.setIcon(null);
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_2_1.setBackground(Color.RED);
		frame.getContentPane().add(btnNewButton_2_1);
		
		JLabel lblNewLabel_1 = new JLabel("Staff Information\r\n");
		lblNewLabel_1.setBounds(324, 10, 661, 67);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		lblNewLabel_1.setIcon(null);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 25));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(10, 71, 78, 32);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
		frame.getContentPane().add(lblNewLabel_2);
		
		JTextArea txtName = new JTextArea();
		txtName.setBounds(10, 101, 357, 32);
		txtName.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.BLACK));
		txtName.setOpaque(false);
		txtName.setFont(new Font("Monospaced", Font.BOLD, 20));
		txtName.setForeground(Color.BLACK);
		txtName.setBackground(Color.BLACK);
		frame.getContentPane().add(txtName);
		
		JLabel lblNewLabel_2_1 = new JLabel("Gender");
		lblNewLabel_2_1.setBounds(10, 159, 78, 32);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 20));
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JRadioButton rboMale = new JRadioButton("Male");
		rboMale.setBounds(10, 207, 103, 21);
		rboMale.setOpaque(false);
		rboMale.setFont(new Font("Arial", Font.BOLD, 15));
		frame.getContentPane().add(rboMale);
		
		JRadioButton rboFemale = new JRadioButton("Female");
		rboFemale.setBounds(115, 208, 103, 21);
		rboFemale.setOpaque(false);
		rboFemale.setFont(new Font("Arial", Font.BOLD, 15));
		frame.getContentPane().add(rboFemale);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Date of Birth");
		lblNewLabel_2_1_1.setBounds(10, 244, 137, 32);
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		frame.getContentPane().add(lblNewLabel_2_1_1);
		
		JDateChooser dateBirth = new JDateChooser();
		dateBirth.setBounds(10, 285, 357, 43);
		dateBirth.setFont(new Font("Arial", Font.BOLD, 20));
		frame.getContentPane().add(dateBirth);
		
		JTextArea txtPhone = new JTextArea();
		txtPhone.setBounds(10, 368, 357, 32);
		txtPhone.setOpaque(false);
		txtPhone.setForeground(Color.BLACK);
		txtPhone.setFont(new Font("Monospaced", Font.BOLD, 20));
		txtPhone.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.BLACK));
		txtPhone.setBackground(Color.BLACK);
		frame.getContentPane().add(txtPhone);
		
		JLabel lblNewLabel_2_2 = new JLabel("Phone");
		lblNewLabel_2_2.setBounds(10, 338, 78, 32);
		lblNewLabel_2_2.setFont(new Font("Arial", Font.BOLD, 20));
		frame.getContentPane().add(lblNewLabel_2_2);
		
		JTextArea txtGmail = new JTextArea();
		txtGmail.setBounds(10, 456, 357, 32);
		txtGmail.setOpaque(false);
		txtGmail.setForeground(Color.BLACK);
		txtGmail.setFont(new Font("Monospaced", Font.BOLD, 20));
		txtGmail.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.BLACK));
		txtGmail.setBackground(Color.BLACK);
		frame.getContentPane().add(txtGmail);
		
		JLabel lblNewLabel_2_3 = new JLabel("Gmail");
		lblNewLabel_2_3.setBounds(10, 426, 78, 32);
		lblNewLabel_2_3.setFont(new Font("Arial", Font.BOLD, 20));
		frame.getContentPane().add(lblNewLabel_2_3);
		
		JEditorPane edAddress = new JEditorPane();
		edAddress.setBounds(10, 560, 362, 92);
		edAddress.setFont(new Font("Arial", Font.BOLD, 20));
		edAddress.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLACK));
		frame.getContentPane().add(edAddress);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Address");
		lblNewLabel_2_3_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2_3_1.setBounds(10, 523, 97, 32);
		frame.getContentPane().add(lblNewLabel_2_3_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.BLACK);
		scrollPane.setBounds(398, 132, 882, 355);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2_1_1 = new JButton("Insert");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String name = txtName.getText();
				String gender = "";
				
				if(rboFemale.isSelected()) {
					gender="Female";
				}else gender="Male";
				
				
				
				int dateOfBirth ;
				String phone = txtPhone.getText();
				String gmail = txtGmail.getText();
				String address = edAddress.getText();
				
				SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		        String date = dFormat.format(dateBirth.getDate());    
		        
		    	String position = txtPosition.getText();
				String status = txtStatus.getText();
		        
		        
	    		try {
	    			connectionWithDatabase.connection();
					java.sql.Statement s = connectionWithDatabase.getCON().createStatement();
					String sql="INSERT INTO `eventsmanagementsystem`.`tbl_staffmanagement` (`Name`, `Gender`, `DateOfBirth`, `Phone`, `Gmail`, `Address`,`Position`,`Status`) VALUES ('"+name+"', '"+gender+"', '"+date+"', '"+phone+"', '"+gmail+"', '"+address+"', '"+position+"', '"+status+"')";
					s.execute(sql);     
					
					JOptionPane.showMessageDialog(frame,"Success");  

		    		frame.dispose();
		    		frmStaff.main(null);
				} catch (Exception e2) {
					
				}
				
				
			}
		});
		btnNewButton_2_1_1.setForeground(Color.WHITE);
		btnNewButton_2_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_2_1_1.setBackground(Color.GREEN);
		btnNewButton_2_1_1.setBounds(400, 87, 169, 33);
		frame.getContentPane().add(btnNewButton_2_1_1);
		
		JButton btnNewButton_2_1_1_1 = new JButton("Delete");
		btnNewButton_2_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				DefaultTableModel t = (DefaultTableModel)table.getModel();
		        int row = table.getSelectedRow();
		        String eve = (String) table.getModel().getValueAt(row, 0);
		        String sql = "DELETE FROM `eventsmanagementsystem`.`tbl_staffmanagement` WHERE `ID` = "+eve+"";
		        try {
		        	connectionWithDatabase.connection();
		        	java.sql.Statement   s = connectionWithDatabase.getCON().prepareStatement(sql);
		            s.execute(sql);
		            JOptionPane.showMessageDialog(null, "Congratulation !!");
		            frame.dispose();
		            frmStaff.main(null);
		        } catch (Exception eee) {
		            JOptionPane.showMessageDialog(null,  eee.getMessage());
		        }
				
				
				
			}
		});
		btnNewButton_2_1_1_1.setForeground(Color.WHITE);
		btnNewButton_2_1_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_2_1_1_1.setBackground(Color.GREEN);
		btnNewButton_2_1_1_1.setBounds(579, 89, 169, 33);
		frame.getContentPane().add(btnNewButton_2_1_1_1);
		
		JButton btnNewButton_2_1_1_1_1 = new JButton("Update");
		btnNewButton_2_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = txtName.getText();
				String phone = txtPhone.getText();
				String gmail = txtGmail.getText();
				String address = edAddress.getText();
				
				
				String position = txtPosition.getText();
				String status = txtStatus.getText();
				
				
				DefaultTableModel t = (DefaultTableModel)table.getModel();
		        int row = table.getSelectedRow();
		        String eve = (String) table.getModel().getValueAt(row, 0);
		        String sql = "UPDATE `eventsmanagementsystem`.`tbl_staffmanagement` SET `Name` = '"+name+"', `Phone` = '"+phone+"', `Gmail` = '"+gmail+"', `Address` = '"+address+"',`Position` = '"+position+"',`Status` = '"+status+"' WHERE `ID` = "+eve+"";
		        try {
		        	connectionWithDatabase.connection();
		        	java.sql.Statement   s = connectionWithDatabase.getCON().prepareStatement(sql);
		            s.execute(sql);
		            JOptionPane.showMessageDialog(null, "Congratulation !!");
		            frame.dispose();
		            frmStaff.main(null);
		        } catch (Exception eee) {
		            JOptionPane.showMessageDialog(null,  eee.getMessage());
		        }
				//UPDATE `eventsmanagementsystem`.`tbl_staffmanagement` SET `Name` = 'rith1', `Phone` = '0786734333', `Gmail` = 'rith01@gmail.com', `Address` = 'rupp1' WHERE `ID`
				
			}
		});
		btnNewButton_2_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_2_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_2_1_1_1_1.setBackground(Color.GREEN);
		btnNewButton_2_1_1_1_1.setBounds(758, 89, 169, 33);
		frame.getContentPane().add(btnNewButton_2_1_1_1_1);
		
		JButton btnNewButton_2_1_1_2 = new JButton("Search");
		btnNewButton_2_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				
				try {
	    			DefaultTableModel t =  (DefaultTableModel)table_1.getModel();
	    			
	    			 connectionWithDatabase.connection();
					    java.sql.Statement s = connectionWithDatabase.getCON().createStatement();
						String sql="SELECT * FROM `eventsmanagementsystem`.`tbl_staffmanagement` WHERE ID  = "+txtSearch.getText()+ "";
						ResultSet r = s.executeQuery(sql);
						
						while(r.next())
						{
							String ID= r.getString(1);
							String Name= r.getString(2);
							String Gender= r.getString(3);
							String DateOfBirth= r.getString(4);
							String Phone= r.getString(5);
							String Gmail= r.getString(6);
							String Address= r.getString(7);
							String Position= r.getString(8);
							String Status= r.getString(9);
							
							
							 t.addRow(new Object[]{ID,Name,Gender ,DateOfBirth,Phone ,Gmail,Address,Position,Status});
							
							 table.getTableHeader().setBackground(Color.green);	

						}
						
						
						 
					r.close();
					s.close();
	    			
	    			
				} catch (Exception e2) {
					
				}
				
				
				
			}
		});
		btnNewButton_2_1_1_2.setForeground(Color.WHITE);
		btnNewButton_2_1_1_2.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_2_1_1_2.setBackground(Color.GREEN);
		btnNewButton_2_1_1_2.setBounds(400, 505, 169, 33);
		frame.getContentPane().add(btnNewButton_2_1_1_2);
		
		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Arial", Font.BOLD, 20));
		txtSearch.setBounds(583, 505, 208, 33);
		frame.getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(400, 560, 880, 92);
		frame.getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton_2_1_1_2_1 = new JButton("Clear");
		btnNewButton_2_1_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				DefaultTableModel model =  (DefaultTableModel)table.getModel();
	        	int index = table.getSelectedRow();
				txtID.setText("");
				txtName.setText("");
				String sex =model.getValueAt(index,2).toString();
                if(sex.equals("Male")) {    	
                	rboMale.setSelected(false);
                }else {
                	rboFemale.setSelected(false);
                
                }
				
                try {

		            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(index, 3));
		            dateBirth.setDate(null);
		        } catch (ParseException ex) {
		          
		            
		        }
				
				txtPhone.setText("");
				txtGmail.setText("");
				edAddress.setText("");
				txtPosition.setText("");
				txtStatus.setText("");
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton_2_1_1_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1_1_2_1.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_2_1_1_2_1.setBackground(Color.YELLOW);
		btnNewButton_2_1_1_2_1.setBounds(1111, 505, 169, 33);
		frame.getContentPane().add(btnNewButton_2_1_1_2_1);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setFont(new Font("Arial", Font.BOLD, 20));
		txtID.setColumns(10);
		txtID.setBounds(213, 22, 103, 33);
		frame.getContentPane().add(txtID);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				frmStaff.main(null);
			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(1074, 26, 8, 21);
		frame.getContentPane().add(btnNewButton);
		
		txtPosition = new JTextField();
		txtPosition.setForeground(Color.LIGHT_GRAY);
		txtPosition.setFont(new Font("Arial", Font.BOLD, 20));
		txtPosition.setColumns(10);
		txtPosition.setBounds(979, 87, 103, 33);
		frame.getContentPane().add(txtPosition);
		
		txtStatus = new JTextField();
		txtStatus.setForeground(Color.LIGHT_GRAY);
		txtStatus.setFont(new Font("Arial", Font.BOLD, 20));
		txtStatus.setColumns(10);
		txtStatus.setBounds(1124, 87, 103, 33);
		frame.getContentPane().add(txtStatus);
		
		JLabel lblNewLabel_2_4 = new JLabel("Position");
		lblNewLabel_2_4.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2_4.setBounds(992, 58, 78, 32);
		frame.getContentPane().add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("Status");
		lblNewLabel_2_4_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2_4_1.setBounds(1149, 58, 78, 32);
		frame.getContentPane().add(lblNewLabel_2_4_1);
		frame.setBounds(100, 100, 1304, 721);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

		
		frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				DefaultTableModel model =  (DefaultTableModel)table.getModel();
	        	int index = table.getSelectedRow();
				txtID.setText(model.getValueAt(index,0).toString());
				txtName.setText(model.getValueAt(index,1).toString());
				String sex =model.getValueAt(index,2).toString();
                if(sex.equals("Male")) {
                	rboFemale.setSelected(false);
                	rboMale.setSelected(true);
                }else {
                	rboMale.setSelected(false);
                	rboFemale.setSelected(true);
                }
				
                try {

		            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(index, 3));
		            dateBirth.setDate(date);
		        } catch (ParseException ex) {
		          
		            
		        }
				
				txtPhone.setText(model.getValueAt(index,4).toString());
				txtGmail.setText(model.getValueAt(index,5).toString());
				edAddress.setText(model.getValueAt(index,6).toString());
				txtPosition.setText(model.getValueAt(index,7).toString());
				txtStatus.setText(model.getValueAt(index,8).toString());
				
				 
			
		        
				

				
				
			}
		});
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				
				
				
				
try {
			
					
					//AbstractButton table = null;
					DefaultTableModel t =  (DefaultTableModel)table.getModel();
					 t.setColumnCount (0); 
					t.addColumn("StaffID");
					t.addColumn("Name");
					t.addColumn("Gender");
					t.addColumn("DateOfBirth");
					t.addColumn("Phone");
					t.addColumn("Gmail");
					t.addColumn("Address");
					t.addColumn("Position");
					t.addColumn("Status");
					
					
				
					   connectionWithDatabase.connection();
					 // String get = assign_cardno.getCard();
					    java.sql.Statement s = connectionWithDatabase.getCON().createStatement();
						String sql="SELECT * FROM `eventsmanagementsystem`.`tbl_staffmanagement` ";
						ResultSet r = s.executeQuery(sql);
						while(r.next())
						{
							String ID= r.getString(1);
							String Name= r.getString(2);
							String Gender= r.getString(3);
							String DateOfBirth= r.getString(4);
							String Phone= r.getString(5);
							String Gmail= r.getString(6);
							String Address= r.getString(7);
							String Position=r.getString(8);
							String Status=r.getString(9);
							
							
							 t.addRow(new Object[]{ID,Name,Gender ,DateOfBirth,Phone ,Gmail,Address,Position,Status});
						}
					r.close();
					s.close();
					
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
				try {
					
					
					DefaultTableModel t =  (DefaultTableModel)table_1.getModel();
					 t.setColumnCount (0); 
					t.addColumn("StaffID");
					t.addColumn("Name");
					t.addColumn("Gender");
					t.addColumn("DateOfBirth");
					t.addColumn("Phone");
					t.addColumn("Gmail");
					t.addColumn("Address");
					t.addColumn("Position");
					t.addColumn("Status");
					
					
				} catch (Exception e2) {
					
				}
				
				
			}
		});
		
	}
}
