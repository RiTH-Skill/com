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

public class frmBookingView extends JFrame{
    private JButton btnNewButton_2;
	private JLabel lblNewLabel;
	private JLabel lblVenueManagement;
	private JLabel lblNewLabel_1;
	private JTextField txtBookingID;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnSearch;
	private JLabel lblNewLabel_2;
	private JTextField txtSearch;
	private JTable table_1;
	private JScrollPane scrollPane_1;
	private JTextField txtStatus;
	
    
    public frmBookingView(){
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

    			
    			
    			DefaultTableModel t1 =  (DefaultTableModel)table_1.getModel();
    			
    			
    			
   			 t1.setColumnCount (0); 
					t1.addColumn("BookingID");
					t1.addColumn("EventManagerID");
					t1.addColumn("EventType");
					t1.addColumn("VeneuPlace");
					t1.addColumn("VeneuType");
					t1.addColumn("EventDate");
					t1.addColumn("FoodItems");
					t1.addColumn("Equipment");
					t1.addColumn("Guests");
					t1.addColumn("EventCost");
					t1.addColumn("PaymentStatus");
    			
    			
    			
    			
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
						String sql="SELECT * FROM `eventsmanagementsystem`.`tbl_bookingview` ";
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
					
				}
    			
    			

    	}
    });
    
    getContentPane().setLayout(null);
    
    btnNewButton_2 = new JButton("Back");
    btnNewButton_2.addActionListener(new ActionListener() {
    	
		public void actionPerformed(ActionEvent e) {
           frmAdminHome.main(null);
          dispose();
    	}
    });
    btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Saved Pictures\\left_arrow_50px.png"));
    btnNewButton_2.setForeground(Color.WHITE);
    btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 20));
    btnNewButton_2.setBackground(Color.RED);
    btnNewButton_2.setBounds(1150, 10, 130, 40);
    getContentPane().add(btnNewButton_2);
    
    lblNewLabel = new JLabel("Welcome to Admin");
    lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel.setBounds(10, 10, 193, 56);
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
    txtBookingID.setBounds(178, 117, 286, 26);
    getContentPane().add(txtBookingID);
    txtBookingID.setColumns(10);
    
    scrollPane = new JScrollPane();
    scrollPane.setBounds(10, 158, 1280, 383);
    getContentPane().add(scrollPane);
    
    table = new JTable();
    scrollPane.setViewportView(table);
    
    btnUpdate = new JButton("Update");
    btnUpdate.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		DefaultTableModel t = (DefaultTableModel)table.getModel();
	        int row = table.getSelectedRow();
	        String eve = (String) table.getModel().getValueAt(row, 0);
	        String sql = "UPDATE `eventsmanagementsystem`.`tbl_bookingview` SET `PaymentStatus` = '"+txtStatus.getText()+"' WHERE `BookingID` = "+eve+"";
	        try {
	        	connectionWithDatabase.connection();
	        	java.sql.Statement   s = connectionWithDatabase.getCON().prepareStatement(sql);
	            s.execute(sql);
	            JOptionPane.showMessageDialog(null, "Congratulation !!");
	            dispose();
	            frmBookingView.main(null);
	        } catch (Exception eee) {
	            JOptionPane.showMessageDialog(null,  eee.getMessage());
	        }
    		//UPDATE `eventsmanagementsystem`.`tbl_bookingview` SET `PaymentStatus` = 'pre-paid' WHERE `BookingID` = 46
    		
    		
    	}
    	
    });
    btnUpdate.setFont(new Font("Arial", Font.BOLD, 20));
    btnUpdate.setBackground(Color.GREEN);
    btnUpdate.setBounds(1111, 551, 169, 40);
    getContentPane().add(btnUpdate);
    
    btnDelete = new JButton("Delete");
    btnDelete.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		DefaultTableModel t = (DefaultTableModel)table.getModel();
	        int row = table.getSelectedRow();
	        String eve = (String) table.getModel().getValueAt(row, 0);
	        String sql = "DELETE FROM `eventsmanagementsystem`.`tbl_bookingview` WHERE `BookingID` = "+eve+"";
	        try {
	        	connectionWithDatabase.connection();
	        	java.sql.Statement   s = connectionWithDatabase.getCON().prepareStatement(sql);
	            s.execute(sql);
	            JOptionPane.showMessageDialog(null, "Congratulation !!");
	            dispose();
	            frmBookingView.main(null);
	        } catch (Exception eee) {
	            JOptionPane.showMessageDialog(null,  eee.getMessage());
	        }
    		
    	}
    });
    btnDelete.setFont(new Font("Arial", Font.BOLD, 20));
    btnDelete.setBackground(Color.GREEN);
    btnDelete.setBounds(1111, 110, 169, 40);
    getContentPane().add(btnDelete);
    
    btnSearch = new JButton("Search");
    btnSearch.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		int id = AssignPassword.getId();
    		
    		try {
    			DefaultTableModel t =  (DefaultTableModel)table_1.getModel();
    			
    			 connectionWithDatabase.connection();
				 // String get = assign_cardno.getCard();
				    java.sql.Statement s = connectionWithDatabase.getCON().createStatement();
					String sql="SELECT * FROM `eventsmanagementsystem`.`tbl_bookingview` WHERE EventManagerID  = "+txtSearch.getText()+ "";
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
						
						
							table.getTableHeader().setBackground(Color.green);	
						
						
					t.addRow(new Object[]{bookingID,eventManagerID,eventType ,venuePlace,venueType ,eventDate,foodItems,Equipments,Guests,eventCost,paymentStatus});
						
				
						
						 
					}
					

				r.close();
				s.close();
    			
    			
			} catch (Exception e2) {
				
			}
    		
    	}
    });
    btnSearch.setFont(new Font("Arial", Font.BOLD, 20));
    btnSearch.setBackground(Color.GREEN);
    btnSearch.setBounds(10, 551, 106, 40);
    getContentPane().add(btnSearch);
    
    lblNewLabel_2 = new JLabel("New label");
    lblNewLabel_2.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		dispose();
    		frmBookingView.main(null);
    	}
    });
    lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\MS\\refresh_70px.png"));
    lblNewLabel_2.setBounds(664, 87, 70, 56);
    getContentPane().add(lblNewLabel_2);
    
    txtSearch = new JTextField();
    txtSearch.setBounds(132, 562, 156, 26);
    getContentPane().add(txtSearch);
    txtSearch.setColumns(10);
    
    scrollPane_1 = new JScrollPane();
    scrollPane_1.setBounds(10, 598, 1280, 83);
    getContentPane().add(scrollPane_1);
    
    table_1 = new JTable();
    scrollPane_1.setViewportView(table_1);
    
    txtStatus = new JTextField();
    txtStatus.setColumns(10);
    txtStatus.setBounds(924, 562, 156, 26);
    getContentPane().add(txtStatus);
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
     new frmBookingView();
        
    }
   }