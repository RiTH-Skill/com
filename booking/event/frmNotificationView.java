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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class frmNotificationView extends JFrame{
    private JButton btnNewButton_2;
	private JLabel lblNewLabel;
	private JLabel lblVenueManagement;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnClear;
	private JEditorPane edMessage;
	private JScrollPane scrollPane_1;
	
    
    public frmNotificationView(){
    	
    super("Set Picture Into A JLabel Using JFileChooser In Java");
    setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Downloads\\icons8_management_64.png"));
    setTitle("");
    JLabel lblClient = new JLabel("Client");
    addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		DefaultTableModel model =  (DefaultTableModel)table.getModel();
        	int index = table.getSelectedRow();
			edMessage.setText(model.getValueAt(index,0).toString());
    	}
    });
    setResizable(false);
    getContentPane().setBackground(Color.WHITE);
    addWindowListener(new WindowAdapter() {
    	@Override
    	public void windowOpened(WindowEvent e) {
    		 setLocationRelativeTo(null);
    			setVisible(true);

				try {
			
					
					//AbstractButton table = null;
					DefaultTableModel t =  (DefaultTableModel)table.getModel();
					 t.setColumnCount (0); 
					t.addColumn("NotificationMessage");
					t.addColumn("SentOn");
					
				
					
					
					  connectionWithDatabase.connection();
						 // String get = assign_cardno.getCard();
						    java.sql.Statement s = connectionWithDatabase.getCON().createStatement();
							String sql="SELECT * FROM `eventsmanagementsystem`.`tbl_notificationmessage`";
							ResultSet r = s.executeQuery(sql);
							while(r.next())
							{
								String message= r.getString(1);
								String time= r.getString(2);
								
								
								 t.addRow(new Object[]{message,time});
							}
						r.close();
						s.close();
					
					
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
				
				
				int id = AssignPassword.getId();
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
    lblNewLabel.setBounds(10, 10, 116, 56);
    getContentPane().add(lblNewLabel);
    
    lblVenueManagement = new JLabel("View Notifications\r\n");
    lblVenueManagement.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
    lblVenueManagement.setBounds(546, 10, 215, 56);
    getContentPane().add(lblVenueManagement);
    
    scrollPane = new JScrollPane();
    scrollPane.setBounds(507, 112, 773, 491);
    getContentPane().add(scrollPane);
    
    table = new JTable();
    scrollPane.setViewportView(table);
    
    btnClear = new JButton("Clear");
    btnClear.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		
    		edMessage.setText("");
    		
    		
    		
    	}
    });
    btnClear.setFont(new Font("Arial", Font.BOLD, 20));
    btnClear.setBackground(Color.YELLOW);
    btnClear.setBounds(834, 613, 169, 40);
    getContentPane().add(btnClear);
    
    scrollPane_1 = new JScrollPane();
    scrollPane_1.setBounds(24, 178, 473, 313);
    getContentPane().add(scrollPane_1);
    
  
    edMessage = new JEditorPane();
    edMessage.setEditable(false);
    edMessage.setFont(new Font("Arial", Font.BOLD, 20));
    scrollPane_1.setViewportView(edMessage);
    
    
    lblClient.setFont(new Font("Arial", Font.BOLD, 20));
    lblClient.setBounds(124, 10, 347, 56);
    getContentPane().add(lblClient);
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
        new frmNotificationView();
        
    }
   }