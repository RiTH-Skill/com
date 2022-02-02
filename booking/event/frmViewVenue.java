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
import javax.swing.table.TableModel;

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

public class frmViewVenue extends JFrame{
    JLabel lblVenueImage;
    private JButton btnNewButton_2;
	private JLabel lblNewLabel;
	private JLabel lblVenueManagement;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JPanel panel;
	private JTextField txtVenueID;
	private JTextField txtVenueName;
	private JTextField txtVenuePlace;
	private JTextField txtVenueCost;
	private JTextField txtVenueContact;
	private JTable table;
	private JScrollPane scrollPane;
	
    
	
    public frmViewVenue(){
    super("Set Picture Into A JLabel Using JFileChooser In Java");
    setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Downloads\\icons8_management_64.png"));
    setTitle("");
    addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		DefaultTableModel model =  (DefaultTableModel)table.getModel();
        	int index = table.getSelectedRow();

			txtVenueID.setText(model.getValueAt(index,0).toString());
			txtVenueName.setText(model.getValueAt(index,1).toString());
			txtVenuePlace.setText(model.getValueAt(index,2).toString());
			txtVenueCost.setText(model.getValueAt(index,3).toString());
			txtVenueContact.setText(model.getValueAt(index,4).toString());
			//lblVenueImage.setText(model.getValueAt(index,5).toString());
			
			
			
			int row = table.getSelectedRow();
	        String eve = (String) table.getModel().getValueAt(row, 0);
		
		try{

			 connectionWithDatabase.connection();	               
				java.sql.Statement s = connectionWithDatabase.getCON().createStatement();
				String sql="SELECT * FROM `eventsmanagementsystem`.`tbl_venuemanagement` WHERE VenueID = "+eve+" ";

				ResultSet r = s.executeQuery(sql);
                if(r.next()){
                byte[] img = r.getBytes("VenueImage");
              
            
                //Resize The ImageIcon
                ImageIcon image = new ImageIcon(img);
                java.awt.Image im = image.getImage();
                java.awt.Image myImg = im.getScaledInstance(lblVenueImage.getWidth(), lblVenueImage.getHeight(),java.awt.Image.SCALE_SMOOTH);
                ImageIcon newImage = new ImageIcon(myImg);
                lblVenueImage.setIcon(newImage);
            }
            
            else{
                JOptionPane.showMessageDialog(null, "No Data");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
			
			
			
    	}
    });
    
    JLabel lblClient = new JLabel("Client");
    lblClient.setFont(new Font("Arial", Font.BOLD, 20));
    lblClient.setBounds(131, 10, 381, 56);
    getContentPane().add(lblClient);
    
    setResizable(false);
    getContentPane().setBackground(Color.WHITE);
    addWindowListener(new WindowAdapter() {
    	@Override
    	public void windowOpened(WindowEvent e) {
    		 setLocationRelativeTo(null);
    			setVisible(true);
    			
    			int id = AssignPassword.getId();
    		  // String getPassword = AssignPassword.getPassword();
				try {
			
					connectionWithDatabase.connection();
					//AbstractButton table = null;
					DefaultTableModel t =  (DefaultTableModel)table.getModel();
					 t.setColumnCount (0); 
					t.addColumn("VenueID");
					t.addColumn("VenueName");
					t.addColumn("VenuePlace");
					t.addColumn("VenueCost");
					t.addColumn("VenueContact");
					t.addColumn("VenueImage");
					
					
					java.sql.Statement s = connectionWithDatabase.getCON().createStatement();
					
                      String sql = "SELECT * FROM `eventsmanagementsystem`.`tbl_venuemanagement`  WHERE ManagerID = "+id+"";
					ResultSet r = s.executeQuery(sql);

					
					while(r.next())
					{
						String venueID= r.getString(1);
						String venueName= r.getString(2);
						String venuePlace= r.getString(3);
						String venueCost= r.getString(4);
						String venueContact= r.getString(5);
						String venueImage= r.getString(6);
						
						
					//	String name = AssignPassword.getName();
					//	lblClient.setText(name);
						
						 t.addRow(new Object[]{venueID,venueName,venuePlace,venueCost,venueContact,venueImage});
					}
				r.close();
				s.close();
		
				
				} catch (Exception e2) {

                 Component frame = null;
				JOptionPane.showMessageDialog(frame, e);
					
				}
				
				
				
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
    lblNewLabel.setBounds(10, 10, 121, 56);
    getContentPane().add(lblNewLabel);
    
    lblVenueManagement = new JLabel("View Venues ");
    lblVenueManagement.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
    lblVenueManagement.setBounds(522, 10, 221, 56);
    getContentPane().add(lblVenueManagement);
    
    lblNewLabel_1 = new JLabel("VenueID\r :\n");
    lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_1.setBounds(10, 102, 193, 56);
    getContentPane().add(lblNewLabel_1);
    
    lblNewLabel_2 = new JLabel("VenueName :");
    lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_2.setBounds(10, 158, 193, 56);
    getContentPane().add(lblNewLabel_2);
    
    lblNewLabel_3 = new JLabel("VenuePlace :");
    lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_3.setBounds(10, 215, 193, 56);
    getContentPane().add(lblNewLabel_3);
    
    lblNewLabel_4 = new JLabel("VenueCost :");
    lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_4.setBounds(10, 272, 193, 56);
    getContentPane().add(lblNewLabel_4);
    
    lblNewLabel_5 = new JLabel("VenueContact :");
    lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_5.setBounds(10, 329, 193, 56);
    getContentPane().add(lblNewLabel_5);
    
    lblNewLabel_6 = new JLabel("VenueImage :");
    lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_6.setBounds(10, 384, 193, 56);
    getContentPane().add(lblNewLabel_6);
    
    panel = new JPanel();
    panel.setBounds(254, 398, 286, 205);
    getContentPane().add(panel);
    panel.setLayout(null);
    lblVenueImage = new JLabel();
    lblVenueImage.setBounds(0, 0, 286, 205);
    panel.add(lblVenueImage);
    lblVenueImage.setBackground(Color.WHITE);
    
    txtVenueID = new JTextField();
    txtVenueID.setFont(new Font("Arial", Font.BOLD, 20));
    txtVenueID.setEditable(false);
    txtVenueID.setBounds(250, 121, 286, 26);
    getContentPane().add(txtVenueID);
    txtVenueID.setColumns(10);
    
    txtVenueName = new JTextField();
    txtVenueName.setEditable(false);
    txtVenueName.setFont(new Font("Arial", Font.BOLD, 20));
    txtVenueName.setColumns(10);
    txtVenueName.setBounds(250, 169, 286, 26);
    getContentPane().add(txtVenueName);
    
    txtVenuePlace = new JTextField();
    txtVenuePlace.setEditable(false);
    txtVenuePlace.setFont(new Font("Arial", Font.BOLD, 20));
    txtVenuePlace.setColumns(10);
    txtVenuePlace.setBounds(250, 225, 286, 26);
    getContentPane().add(txtVenuePlace);
    
    txtVenueCost = new JTextField();
    txtVenueCost.setEditable(false);
    txtVenueCost.setFont(new Font("Arial", Font.BOLD, 20));
    txtVenueCost.setColumns(10);
    txtVenueCost.setBounds(250, 278, 286, 26);
    getContentPane().add(txtVenueCost);
    
    txtVenueContact = new JTextField();
    txtVenueContact.setEditable(false);
    txtVenueContact.setFont(new Font("Arial", Font.BOLD, 20));
    txtVenueContact.setColumns(10);
    txtVenueContact.setBounds(250, 337, 286, 26);
    getContentPane().add(txtVenueContact);
    
    scrollPane = new JScrollPane();
    scrollPane.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		
        
    	
				
    			DefaultTableModel model =  (DefaultTableModel)table.getModel();
            	int index = table.getSelectedRow();

				txtVenueID.setText(model.getValueAt(index,0).toString());
				txtVenueName.setText(model.getValueAt(index,1).toString());
				txtVenuePlace.setText(model.getValueAt(index,2).toString());
				txtVenueCost.setText(model.getValueAt(index,3).toString());
				txtVenueContact.setText(model.getValueAt(index,4).toString());
				lblVenueImage.setText(model.getValueAt(index,5).toString());
    			

    		
    		
    	}
    });
    scrollPane.setBounds(607, 112, 673, 491);
    getContentPane().add(scrollPane);
    
    table = new JTable();
    scrollPane.setViewportView(table);
    
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setSize(1304,718);
    setVisible(true);
   
    }
     
     // Methode to resize imageIcon with the same size of a Jlabel
    public ImageIcon ResizeImage(String ImagePath)
    {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(lblVenueImage.getWidth(), lblVenueImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    
    public static void main(String[] args){
    	try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		} catch (Exception e) {
			// TODO: handle exception
		}
        new frmViewVenue();
        
    }
   }