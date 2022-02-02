package com.booking.event;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

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
import javax.swing.AbstractButton;
import javax.swing.AbstractListModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import com.toedter.calendar.JDateChooser;

public class frmPayment extends JFrame{
    private JButton btnNewButton_2;
	private JLabel lblNewLabel;
	private JLabel lblVenueManagement;
	private JLabel lblNewLabel_1;
	private JTextField txtVenueCost;
	private JLabel lblClient;
	private JTextField txtBookingID;
	private JTextField txtCardNo;
	private JTextField txtNameOnCard;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JPasswordField txtCVV;
	private JLabel lblNewLabel_4_2_2;
	
    
    public frmPayment(){
    super("Set Picture Into A JLabel Using JFileChooser In Java");
    setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Downloads\\icons8_management_64.png"));
    setTitle("");
    setResizable(false);
    getContentPane().setBackground(Color.WHITE);
    addWindowListener(new WindowAdapter() {
    	@Override
    	public void windowOpened(WindowEvent e) {
    		 setLocationRelativeTo(null);
    			setVisible(true);
           txtVenueCost.setText(""+AssignPassword.getTotal()+".00$");
				
           
       	int id = AssignPassword.getId();
			 try {
					connectionWithDatabase.connection();
					
					String sql1 = "SELECT * FROM `eventsmanagementsystem`.`tbl_bookingview` WHERE EventManagerID = "+id+"   ORDER BY BookingID DESC LIMIT  1 ";
				   
					java.sql.Statement s = connectionWithDatabase.getCON().createStatement();    
				        ResultSet r1=s.executeQuery(sql1);

					if(r1.next()) {
						
						String Booking= r1.getString(1);
						txtBookingID.setText(Booking);
						
						
					}
					
					
				} catch (Exception e2) {
					
				}
           
           
           
			 
			 
		//	 int id = AssignPassword.getId();
			 try {
					connectionWithDatabase.connection();
					
					String sql1 = "SELECT * FROM `eventsmanagementsystem`.`tbl_userregister` WHERE ManagerID = "+id+"";
				   
					java.sql.Statement s = connectionWithDatabase.getCON().createStatement();    
				        ResultSet r1=s.executeQuery(sql1);

					if(r1.next()) {
						
						String name= r1.getString(2);
						lblClient.setText(name);
					}
					
					
				} catch (Exception e2) {
					
				}
			 
			 
			 
           
    	}
    });
    
    getContentPane().setLayout(null);
    
    btnNewButton_2 = new JButton("Back");
    btnNewButton_2.addActionListener(new ActionListener() {
    	
		public void actionPerformed(ActionEvent e) {
           frmUserDetail.main(null);
          dispose();
    	}
    });
    btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Saved Pictures\\left_arrow_50px.png"));
    btnNewButton_2.setForeground(Color.WHITE);
    btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 20));
    btnNewButton_2.setBackground(Color.RED);
    btnNewButton_2.setBounds(1150, 10, 130, 40);
    getContentPane().add(btnNewButton_2);
    
    lblNewLabel = new JLabel("Welcome to ");
    lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel.setBounds(10, 10, 130, 56);
    getContentPane().add(lblNewLabel);
    
    lblVenueManagement = new JLabel("Pay For Event\r\n");
    lblVenueManagement.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
    lblVenueManagement.setBounds(522, 10, 257, 56);
    getContentPane().add(lblVenueManagement);
    
    lblNewLabel_1 = new JLabel("Venue Cost :");
    lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_1.setBounds(732, 428, 193, 56);
    getContentPane().add(lblNewLabel_1);
    
    txtVenueCost = new JTextField();
    txtVenueCost.setFont(new Font("Arial", Font.BOLD, 20));
    txtVenueCost.setEditable(false);
    txtVenueCost.setBounds(972, 447, 286, 26);
    getContentPane().add(txtVenueCost);
    txtVenueCost.setColumns(10);
    
    lblClient = new JLabel("Client");
    lblClient.setFont(new Font("Arial", Font.BOLD, 20));
    lblClient.setBounds(140, 10, 130, 56);
    getContentPane().add(lblClient);
    
    JLabel lblNewLabel_1_1 = new JLabel("Booking ID :");
    lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_1_1.setBounds(59, 181, 150, 56);
    getContentPane().add(lblNewLabel_1_1);
    
    JLabel lblNewLabel_2_1 = new JLabel("Card No :");
    lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_2_1.setBounds(59, 237, 89, 56);
    getContentPane().add(lblNewLabel_2_1);
    
    JLabel lblNewLabel_4_2 = new JLabel("CVV No :");
    lblNewLabel_4_2.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_4_2.setBounds(59, 294, 150, 56);
    getContentPane().add(lblNewLabel_4_2);
    
    JScrollPane scrollPane_2 = new JScrollPane();
    scrollPane_2.setBounds(732, 89, 532, 316);
    getContentPane().add(scrollPane_2);
    
    JLabel lblPic = new JLabel("");
    lblPic.setHorizontalTextPosition(SwingConstants.CENTER);
    lblPic.setHorizontalAlignment(SwingConstants.CENTER);
    scrollPane_2.setViewportView(lblPic);
    
    JButton btnNewSubmit = new JButton("Clear");
    btnNewSubmit.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
         
    //	txtBookingID.setText("");	
    	txtCardNo.setText("");
    	txtCVV.setText("");
    	txtNameOnCard.setText("");
    //	txtVenueCost.setText("");
    	lblPic.setText("");
    	
    		
    	}
    });
    btnNewSubmit.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Saved Pictures\\erase_50px.png"));
    btnNewSubmit.setForeground(Color.WHITE);
    btnNewSubmit.setFont(new Font("Arial", Font.BOLD, 20));
    btnNewSubmit.setBackground(Color.GREEN);
    btnNewSubmit.setBounds(327, 514, 167, 40);
    getContentPane().add(btnNewSubmit);
    
    txtBookingID = new JTextField();
    txtBookingID.setFont(new Font("Arial", Font.BOLD, 20));
    txtBookingID.setEditable(false);
    txtBookingID.setColumns(10);
    txtBookingID.setBounds(225, 192, 286, 26);
    getContentPane().add(txtBookingID);
    
    txtCardNo = new JTextField();
    txtCardNo.addKeyListener(new KeyAdapter() {
    	@Override
    	public void keyTyped(KeyEvent e) {
    		String cardNO = txtCardNo.getText();
    	    if(cardNO.length()==16 && cardNO.charAt(0)=='4') {
    	    	lblPic.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\MS\\visa_100px.png"));
    	    }else if(cardNO.length()==16 && cardNO.charAt(0)=='5') {
    	    	lblPic.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\MS\\mastercard_logo_100px.png"));
    	    }else lblPic.setIcon(new ImageIcon(""));
    		
    	}
    });
    txtCardNo.setFont(new Font("Arial", Font.BOLD, 20));
    txtCardNo.setColumns(10);
    txtCardNo.setBounds(225, 246, 286, 26);
    getContentPane().add(txtCardNo);
    
    JLabel lblNewLabel_4_2_1 = new JLabel("Name On Card : ");
    lblNewLabel_4_2_1.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_4_2_1.setBounds(59, 349, 156, 56);
    getContentPane().add(lblNewLabel_4_2_1);
    
    txtNameOnCard = new JTextField();
    txtNameOnCard.setFont(new Font("Arial", Font.BOLD, 20));
    txtNameOnCard.setColumns(10);
    txtNameOnCard.setBounds(225, 359, 286, 26);
    getContentPane().add(txtNameOnCard);
    
    JButton btnPay = new JButton("Pay");
    btnPay.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		String cardNO = txtCardNo.getText();
    	    String  cvvNo = String.valueOf(txtCVV.getPassword());
    	    String name = txtNameOnCard.getText();
    	    
    	    
    	    
    	    Component frame =null;
			if(((cardNO.length()==16 && (cardNO.length()>=16 && cardNO.length()<=16) ) && (cardNO.charAt(0)=='5'||cardNO.charAt(0)=='4')) && ( (cvvNo.length()==3 && ((cvvNo.length()>=3 && cvvNo.length()<=3)) ) && cvvNo.charAt(0)!='0') && !name.isEmpty()) {
				JOptionPane.showMessageDialog(frame ,"Success");
				frmInvoice.main(null);
        		dispose();
    	    }else JOptionPane.showMessageDialog(frame ,"Try again");
    		
    		
    		
    		
    		
    	}
    });
    btnPay.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Saved Pictures\\pricing_50px.png"));
    btnPay.setForeground(Color.WHITE);
    btnPay.setFont(new Font("Arial", Font.BOLD, 20));
    btnPay.setBackground(Color.GREEN);
    btnPay.setBounds(104, 514, 167, 40);
    getContentPane().add(btnPay);
    
    lblNewLabel_2 = new JLabel("");
    lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\MS\\visa_100px.png"));
    lblNewLabel_2.setBounds(225, 89, 109, 61);
    getContentPane().add(lblNewLabel_2);
    
    lblNewLabel_4 = new JLabel("");
    lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\MS\\mastercard_logo_100px.png"));
    lblNewLabel_4.setBounds(402, 89, 109, 61);
    getContentPane().add(lblNewLabel_4);
    
    txtCVV = new JPasswordField();
    txtCVV.setFont(new Font("Arial", Font.BOLD, 20));
    txtCVV.setBounds(225, 302, 286, 26);
    getContentPane().add(txtCVV);
    
    lblNewLabel_4_2_2 = new JLabel("Expiration Date :");
    lblNewLabel_4_2_2.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_4_2_2.setBounds(59, 415, 167, 56);
    getContentPane().add(lblNewLabel_4_2_2);
    
    JDateChooser dateChooser = new JDateChooser();
    dateChooser.setFont(new Font("Dialog", Font.BOLD, 20));
    dateChooser.setBounds(225, 420, 286, 34);
    getContentPane().add(dateChooser);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setSize(1304,718);
    setVisible(true);
   
    }
     
   
    public static void main(String[] args){
    	try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		} catch (Exception e) {
			// TODO: handle exception
		}
        new frmPayment();
        
    }
   }