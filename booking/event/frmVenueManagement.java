package com.booking.event;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.LabelUI;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;


import javax.swing.JSeparator;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
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

public class frmVenueManagement extends JFrame{
	
	//public static JFrame frame = new JFrame();
    JButton btnC ;
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
	private JButton btnInsert;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnClear;
	private JScrollPane scrollPane_1;
	private JLabel lblManagerid;
	private JTextField txtManagerID;
	private JTextField txtImage;
	private JTextField txtImage1;
	
    
    public frmVenueManagement(){
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
		//	lblVenueImage.setText(model.getValueAt(index,5).toString());
			
			
			try {
				java.sql.Statement s = connectionWithDatabase.getCON().createStatement();
				int row = table.getSelectedRow();
				String eve = (String) table.getModel().getValueAt(row, 0);
				String sql = "SELECT * FROM `eventsmanagementsystem`.`tbl_venuemanagement` WHERE VenueID = "+eve+" ";
			  ResultSet r = s.executeQuery(sql);
			  DefaultTableModel t =  (DefaultTableModel)table.getModel();
			  while(r.next())
				{
				  String EventManagerID= r.getString(7);
					txtManagerID.setText(EventManagerID);
				}
			  
			  
			} catch (Exception e2) {
				
			}
			
			
			
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
    setResizable(false);
    getContentPane().setBackground(Color.WHITE);
    addWindowListener(new WindowAdapter() {
    	@Override
    	public void windowOpened(WindowEvent e) {
    		 setLocationRelativeTo(null);
    			setVisible(true);

    			
    			
    			
    			
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
					//String sql="SELECT VenueID,VenueName,VenuePlace,VenueCost,VenueContact,VenueImage FROM `eventsmanagementsystem`.`tbl_venuemanagement`  where ManagerID = 5192";
					String sql="SELECT VenueID,VenueName,VenuePlace,VenueCost,VenueContact,VenueImage FROM `eventsmanagementsystem`.`tbl_venuemanagement`  ";

					ResultSet r = s.executeQuery(sql);
					while(r.next())
					{
						String venueID= r.getString(1);
						String venueName= r.getString(2);
						String venuePlace= r.getString(3);
						String venueCost= r.getString(4);
						String venueContact= r.getString(5);
						String venueImage= r.getString(6);
						
						
						 t.addRow(new Object[]{venueID,venueName,venuePlace,venueCost,venueContact,venueImage});
					}
				r.close();
				s.close();
					
				
					
				
				} catch (Exception e2) {

                 Component frame = null;
				JOptionPane.showMessageDialog(frame, e);
					
				}
    			
    	}
    });
    btnC = new JButton("Choose Image");
    btnC.setBackground(Color.GREEN);
    btnC.setFont(new Font("Arial", Font.BOLD, 20));
    btnC.setBounds(318,613,169,40);
    getContentPane().add(btnC);
    
    btnC.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
        
          JFileChooser file = new JFileChooser();
          file.setCurrentDirectory(new File(System.getProperty("user.home")));
          //filter the files
          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
          file.addChoosableFileFilter(filter);
          int result = file.showSaveDialog(null);
           //if the user click on save in Jfilechooser
          if(result == JFileChooser.APPROVE_OPTION){
              File selectedFile = file.getSelectedFile();
              String path = selectedFile.getAbsolutePath();
              lblVenueImage.setIcon(ResizeImage(path));
              txtImage.setText(path);
          }
           //if the user click on save in Jfilechooser


          else if(result == JFileChooser.CANCEL_OPTION){
              System.out.println("No File Select");
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
    
    lblVenueManagement = new JLabel("Venue Management");
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
    
    scrollPane_1 = new JScrollPane();
    scrollPane_1.setBounds(0, 0, 286, 205);
    panel.add(scrollPane_1);
    lblVenueImage = new JLabel();
    scrollPane_1.setViewportView(lblVenueImage);
    lblVenueImage.setBackground(Color.WHITE);
    
    txtVenueID = new JTextField();
    txtVenueID.setFont(new Font("Arial", Font.BOLD, 20));
    txtVenueID.setEditable(false);
    txtVenueID.setBounds(250, 121, 286, 26);
    getContentPane().add(txtVenueID);
    txtVenueID.setColumns(10);
    
    txtVenueName = new JTextField();
    txtVenueName.setFont(new Font("Arial", Font.BOLD, 20));
    txtVenueName.setColumns(10);
    txtVenueName.setBounds(250, 169, 286, 26);
    getContentPane().add(txtVenueName);
    
    txtVenuePlace = new JTextField();
    txtVenuePlace.setFont(new Font("Arial", Font.BOLD, 20));
    txtVenuePlace.setColumns(10);
    txtVenuePlace.setBounds(250, 225, 286, 26);
    getContentPane().add(txtVenuePlace);
    
    txtVenueCost = new JTextField();
    txtVenueCost.setFont(new Font("Arial", Font.BOLD, 20));
    txtVenueCost.setColumns(10);
    txtVenueCost.setBounds(250, 278, 286, 26);
    getContentPane().add(txtVenueCost);
    
    txtVenueContact = new JTextField();
    txtVenueContact.setFont(new Font("Arial", Font.BOLD, 20));
    txtVenueContact.setColumns(10);
    txtVenueContact.setBounds(250, 337, 286, 26);
    getContentPane().add(txtVenueContact);
    
    btnInsert = new JButton("Insert");
    btnInsert.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    	}
    });
    btnInsert.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
         
    		String venuePlace = txtVenuePlace.getText();
    		String venueName = txtVenueName.getText();
    		String venueCost = txtVenueCost.getText();
    		String venueContact = txtVenueContact.getText();
    		JFrame frame = null;
 
			String venueImage = lblVenueImage.getText();
    	//	String venueImage = lblVenueImage.getUIClassID();
    	//	Icon venueImage = lblVenueImage.getDisabledIcon();
    	//	Icon venueImage = lblVenueImage.getIcon();
    	//	LabelUI venueImage = lblVenueImage.getUI();
		//	frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\OneDrive\\Pictures\\Screenshots\\Screenshot (288).png"));

    		
			String id = txtManagerID.getText();
			int ID = (int) Integer.parseInt(txtManagerID.getText());
			
//    		try {
//    			connectionWithDatabase.connection();
//				java.sql.Statement s = connectionWithDatabase.getCON().createStatement();
//				String sql="INSERT INTO `eventsmanagementsystem`.`tbl_venuemanagement` (`VenueName`, `VenuePlace`, `VenueCost`, `VenueContact`, `VenueImage`, `ManagerID`) VALUES ('"+venueName+"', '"+venuePlace+"', "+venueCost+", "+venueContact+", '"+venueImage+"', "+ID+")";
//				
//				//INSERT INTO `eventsmanagementsystem`.`tbl_venuemanagement` (`VenueName`, `VenuePlace`, `VenueCost`, `VenueContact`, `VenueImage`, `ManagerID`) VALUES ('11', '11', 11, 11,
//				
//				s.execute(sql);     
//				
//				JOptionPane.showMessageDialog(frame,"Success");  
//
//	    		dispose();
//	    		frmVenueManagement.main(null);
//			} catch (Exception e2) {
//				
//			}
    		

    		
    		
    		
    		
    		String txtPicture = txtImage.getText();
			
			
			try {
				connectionWithDatabase.connection();

				

				java.sql.Statement s = connectionWithDatabase.getCON().createStatement();
				String query = "INSERT INTO `eventsmanagementsystem`.`tbl_venuemanagement` (`VenueName`, `VenuePlace`, `VenueCost`, `VenueContact`, `VenueImage`, `ManagerID`) VALUES (?,?,?,?,?,?)";
				PreparedStatement pstmt = connectionWithDatabase.getCON().prepareStatement(query);
			
				FileInputStream fin = new FileInputStream(txtPicture);
			   // pstmt.setBinaryStream(1, fin);
				
				
				
				pstmt.setString(1,venueName);
				pstmt.setString(2,venuePlace);
				pstmt.setString(3,venueCost);
				pstmt.setString(4,venueContact);
				pstmt.setBlob(5, fin);
				pstmt.setString(6,id);				
			    pstmt.execute();
			    JOptionPane.showMessageDialog(frame,"Sucess");
				
			    dispose();
	    		frmVenueManagement.main(null);
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
    		
    		

    		
    		
    		
    		
    		
    		
    	}
    });
    btnInsert.setFont(new Font("Arial", Font.BOLD, 20));
    btnInsert.setBackground(Color.GREEN);
    btnInsert.setBounds(610, 613, 169, 40);
    getContentPane().add(btnInsert);
    
    btnUpdate = new JButton("Update");
    btnUpdate.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		
    		String venuePlace = txtVenuePlace.getText();
    		String venueName = txtVenueName.getText();
    		String venueCost = txtVenueCost.getText();
    		String venueContact = txtVenueContact.getText();
    		JFrame frame = null;
 
			String venueImage = txtImage.getText();

			
			
        	DefaultTableModel t = (DefaultTableModel)table.getModel();
	        int row = table.getSelectedRow();
	        String eve = (String) table.getModel().getValueAt(row, 0);
	        String sql = "UPDATE `eventsmanagementsystem`.`tbl_venuemanagement` SET `VenueName` = '"+venueName+"', `VenuePlace` = '"+venuePlace+"', `VenueCost` = "+venueCost+", `VenueContact` = "+venueContact+",`VenueImage` = '"+venueImage+"'   WHERE `VenueID` = "+eve+"";
	      
	        
	        
	        
	        //`VenueImage` 
	        
	        try {
	        	connectionWithDatabase.connection();
	        	java.sql.Statement   s = connectionWithDatabase.getCON().prepareStatement(sql);
	            s.execute(sql);

	            JOptionPane.showMessageDialog(null, "Congratulation !!");
	            dispose();
	            frmVenueManagement.main(null);
	        } catch (Exception eee) {
	            JOptionPane.showMessageDialog(null,  eee.getMessage());
	        }
			
			
	
			
	        
	      
			

    		
    	}
    });
    btnUpdate.setFont(new Font("Arial", Font.BOLD, 20));
    btnUpdate.setBackground(Color.GREEN);
    btnUpdate.setBounds(869, 613, 169, 40);
    getContentPane().add(btnUpdate);
    
    btnDelete = new JButton("Delete");
    btnDelete.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		
    		DefaultTableModel t = (DefaultTableModel)table.getModel();
	        int row = table.getSelectedRow();
	        String eve = (String) table.getModel().getValueAt(row, 0);
	        String sql = "DELETE FROM `eventsmanagementsystem`.`tbl_venuemanagement` WHERE `VenueID` = "+eve+"";
	        try {
	        	connectionWithDatabase.connection();
	        	java.sql.Statement   s = connectionWithDatabase.getCON().prepareStatement(sql);
	            s.execute(sql);
	            JOptionPane.showMessageDialog(null, "Congratulation !!");
	            dispose();
	            frmVenueManagement.main(null);
	        } catch (Exception eee) {
	            JOptionPane.showMessageDialog(null,  eee.getMessage());
	        }
    		
    		
    	}
    });
    btnDelete.setFont(new Font("Arial", Font.BOLD, 20));
    btnDelete.setBackground(Color.GREEN);
    btnDelete.setBounds(1111, 613, 169, 40);
    getContentPane().add(btnDelete);
    
    scrollPane = new JScrollPane();
    scrollPane.setBounds(607, 112, 673, 491);
    getContentPane().add(scrollPane);
    
    table = new JTable();
    scrollPane.setViewportView(table);
    
    btnClear = new JButton("Clear");
    btnClear.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
			Component frame = null;
			int show = JOptionPane.showConfirmDialog(frame,"Do u want to Clear?","Please Select Yes or No!!!"
		               ,JOptionPane.YES_NO_CANCEL_OPTION,
		               JOptionPane.INFORMATION_MESSAGE);

			if(show == JOptionPane.YES_OPTION){
	              
				txtManagerID.setText("");
				txtVenueContact.setText("");
				txtVenueCost.setText("");
				txtVenueID.setText("");
				txtVenueName.setText("");
				txtVenuePlace.setText("");
				lblVenueImage.setText("");
				
	            } else if(show == JOptionPane.NO_OPTION || show == JOptionPane.CANCEL_OPTION){
	               
	            }
			
		}
    	
    
    });
    btnClear.setFont(new Font("Arial", Font.BOLD, 20));
    btnClear.setBackground(Color.YELLOW);
    btnClear.setBounds(10, 613, 169, 40);
    getContentPane().add(btnClear);
    
    lblManagerid = new JLabel("ManagerID");
    lblManagerid.setFont(new Font("Arial", Font.BOLD, 20));
    lblManagerid.setBounds(606, 58, 112, 56);
    getContentPane().add(lblManagerid);
    
    txtManagerID = new JTextField();
    txtManagerID.setFont(new Font("Arial", Font.BOLD, 20));
    txtManagerID.setColumns(10);
    txtManagerID.setBounds(738, 68, 286, 26);
    getContentPane().add(txtManagerID);
    
    txtImage = new JTextField();
    txtImage.setBounds(10, 512, -8, 19);
    getContentPane().add(txtImage);
    txtImage.setColumns(10);
    
    txtImage1 = new JTextField();
    txtImage1.setBounds(10, 547, -8, 19);
    getContentPane().add(txtImage1);
    txtImage1.setColumns(10);
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
        new frmVenueManagement();
        
    }
   }