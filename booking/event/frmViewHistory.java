package com.booking.event;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.Color;
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

public class frmViewHistory extends JFrame{
    private JButton btnNewButton_2;
	private JLabel lblNewLabel;
	private JLabel lblVenueManagement;
	private JLabel lblNewLabel_1;
	private JTextField txtBookingID;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblClient;
	
    
    public frmViewHistory(){
    super("Set Picture Into A JLabel Using JFileChooser In Java");
    setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Downloads\\icons8_management_64.png"));
    setTitle("");
    addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		DefaultTableModel model =  (DefaultTableModel)table.getModel();
        	int index = table.getSelectedRow();
			txtBookingID.setText(model.getValueAt(index,0).toString());
    	}
    });
    setResizable(false);
    getContentPane().setBackground(Color.WHITE);
    addWindowListener(new WindowAdapter() {
    	@Override
    	public void windowOpened(WindowEvent e) {
    		 setLocationRelativeTo(null);
    			setVisible(true);
           int getID = AssignPassword.getId();
				try {
			
					
					//AbstractButton table = null;
					DefaultTableModel t =  (DefaultTableModel)table.getModel();
					 t.setColumnCount (0); 
					t.addColumn("BookingID");
					t.addColumn("EventManagerID");
					t.addColumn("EventType");
					t.addColumn("VeneuPlace");
					t.addColumn("VeneuType");
					t.addColumn("EventDate");
					t.addColumn("FoodItems");
					t.addColumn("Equipment");
					t.addColumn("Guests");
					t.addColumn("EventCost");
					t.addColumn("PaymentStatus");
					
				
					   connectionWithDatabase.connection();
					 // String get = assign_cardno.getCard();
					    java.sql.Statement s = connectionWithDatabase.getCON().createStatement();
						String sql="SELECT * FROM `eventsmanagementsystem`.`tbl_bookingview` WHERE EventManagerID = '"+getID+"'";
						ResultSet r = s.executeQuery(sql);
						while(r.next())
						{
							String bookingID= r.getString(1);
							String eventManagerID= r.getString(2);
							String eventType= r.getString(3);
							String venuePlace= r.getString(4);
							String venueType= r.getString(5);
							String eventDate= r.getString(6);
							String foodItems= r.getString(7);
							String Equipments= r.getString(8);
							String Guests = r.getString(9);
							String eventCost = r.getString(10);
							String paymentStatus = r.getString(11);
							
							 t.addRow(new Object[]{bookingID,eventManagerID,eventType ,venuePlace,venueType ,eventDate,foodItems,Equipments,Guests,eventCost,paymentStatus});
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
    
    lblVenueManagement = new JLabel("Booking History ");
    lblVenueManagement.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
    lblVenueManagement.setBounds(522, 10, 170, 56);
    getContentPane().add(lblVenueManagement);
    
    lblNewLabel_1 = new JLabel("BookingID\r :\r\n");
    lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_1.setBounds(10, 102, 193, 56);
    getContentPane().add(lblNewLabel_1);
    
    txtBookingID = new JTextField();
    txtBookingID.setFont(new Font("Arial", Font.BOLD, 20));
    txtBookingID.setEditable(false);
    txtBookingID.setBounds(250, 121, 286, 26);
    getContentPane().add(txtBookingID);
    txtBookingID.setColumns(10);
    
    scrollPane = new JScrollPane();
    scrollPane.setBounds(10, 158, 1280, 513);
    getContentPane().add(scrollPane);
    
    table = new JTable();
    scrollPane.setViewportView(table);
    
    lblClient = new JLabel("Client");
    lblClient.setFont(new Font("Arial", Font.BOLD, 20));
    lblClient.setBounds(127, 10, 365, 56);
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
     new frmViewHistory();
        
    }
   }