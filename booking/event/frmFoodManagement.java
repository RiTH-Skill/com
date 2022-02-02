package com.booking.event;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
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

public class frmFoodManagement extends JFrame{
	
	//public static JFrame frame = new JFrame();
    JButton btnC ;
    JLabel lblFoodItemImage;
    private JButton btnNewButton_2;
	private JLabel lblNewLabel;
	private JLabel lblVenueManagement;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_6;
	private JPanel panel;
	private JTextField txtFoodItemID;
	private JTextField txtFoodItemName;
	private JTextField txtFoodItemCost;
	private JButton btnInsert;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnClear;
	private JLabel lblManagerid;
	private JTextField txtManagerID;
	  JTextField txtImage = new JTextField();
    
    public frmFoodManagement(){
    super("Set Picture Into A JLabel Using JFileChooser In Java");
    setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Downloads\\icons8_management_64.png"));
    setTitle("");
    addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		
    		
    		DefaultTableModel model =  (DefaultTableModel)table.getModel();
        	int index = table.getSelectedRow();

			txtFoodItemID.setText(model.getValueAt(index,0).toString());
			txtFoodItemName.setText(model.getValueAt(index,1).toString());
			txtFoodItemCost.setText(model.getValueAt(index,2).toString());
			lblFoodItemImage.setText(model.getValueAt(index,3).toString());
			
			
			try {
				java.sql.Statement s = connectionWithDatabase.getCON().createStatement();
				int row = table.getSelectedRow();
				String eve = (String) table.getModel().getValueAt(row, 0);
				String sql = "SELECT * FROM `eventsmanagementsystem`.`tbl_foodmanagement` WHERE FoodItemID = "+eve+" ";
			  ResultSet r = s.executeQuery(sql);
			  DefaultTableModel t =  (DefaultTableModel)table.getModel();
			  while(r.next())
				{
				  String ManagerID= r.getString(5);
					txtManagerID.setText(ManagerID);
				}
			  
			  
			} catch (Exception e2) {
				
			}
			
			
			
			
			
			
			int row = table.getSelectedRow();
	        String eve = (String) table.getModel().getValueAt(row, 0);
		
		try{

			 connectionWithDatabase.connection();	               
				java.sql.Statement s = connectionWithDatabase.getCON().createStatement();
				String sql="SELECT * FROM `eventsmanagementsystem`.`tbl_foodmanagement` WHERE FoodItemID = "+eve+"";

				ResultSet r = s.executeQuery(sql);
                if(r.next()){
                byte[] img = r.getBytes("FoodItemImage");
                	// String img = r.getString("FoodItemImage");
                //Resize The ImageIcon
                ImageIcon image = new ImageIcon(img);
                java.awt.Image im = image.getImage();
                java.awt.Image myImg = im.getScaledInstance(lblFoodItemImage.getWidth(), lblFoodItemImage.getHeight(),java.awt.Image.SCALE_SMOOTH);
                ImageIcon newImage = new ImageIcon(myImg);
                lblFoodItemImage.setIcon(newImage);
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
					t.addColumn("FoodItemID");
					t.addColumn("FoodItemName");
					t.addColumn("FoodItemCost");
					t.addColumn("FoodItemImage");
					
					
					java.sql.Statement s = connectionWithDatabase.getCON().createStatement();
 					//String sql="SELECT VenueID,VenueName,VenuePlace,VenueCost,VenueContact,VenueImage FROM `eventsmanagementsystem`.`tbl_venuemanagement`  where ManagerID = 5192";
 					String sql="SELECT * FROM `eventsmanagementsystem`.`tbl_foodmanagement` ";

 					ResultSet r = s.executeQuery(sql);
 					while(r.next())
 					{
 						String foodItemsID= r.getString(1);
 						String foodItemsName= r.getString(2);
 						String foodItemCost= r.getString(3);
 						String foodItemImage= r.getString(4);
 						
 						 t.addRow(new Object[]{foodItemsID,foodItemsName,foodItemCost,foodItemImage});
 					}
 				r.close();
 				s.close();
					
					
				
				} catch (Exception e2) {
					
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
              lblFoodItemImage.setIcon(ResizeImage(path));
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
    
    lblVenueManagement = new JLabel("Food  Management");
    lblVenueManagement.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
    lblVenueManagement.setBounds(522, 10, 221, 56);
    getContentPane().add(lblVenueManagement);
    
    lblNewLabel_1 = new JLabel("FoodItemID\r :\r\n");
    lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_1.setBounds(10, 102, 193, 56);
    getContentPane().add(lblNewLabel_1);
    
    lblNewLabel_2 = new JLabel("FoodItemName :");
    lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_2.setBounds(10, 158, 193, 56);
    getContentPane().add(lblNewLabel_2);
    
    lblNewLabel_4 = new JLabel("FoodItemCost :");
    lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_4.setBounds(10, 224, 193, 56);
    getContentPane().add(lblNewLabel_4);
    
    lblNewLabel_6 = new JLabel("FoodItemImage :");
    lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_6.setBounds(10, 384, 193, 56);
    getContentPane().add(lblNewLabel_6);
    
    panel = new JPanel();
    panel.setBounds(254, 398, 286, 205);
    getContentPane().add(panel);
    panel.setLayout(null);
    lblFoodItemImage = new JLabel();
    lblFoodItemImage.setBounds(0, 0, 286, 205);
    panel.add(lblFoodItemImage);
    lblFoodItemImage.setBackground(Color.WHITE);
    
    txtFoodItemID = new JTextField();
    txtFoodItemID.setFont(new Font("Arial", Font.BOLD, 20));
    txtFoodItemID.setEditable(false);
    txtFoodItemID.setBounds(250, 121, 286, 26);
    getContentPane().add(txtFoodItemID);
    txtFoodItemID.setColumns(10);
    
    txtFoodItemName = new JTextField();
    txtFoodItemName.setFont(new Font("Arial", Font.BOLD, 20));
    txtFoodItemName.setColumns(10);
    txtFoodItemName.setBounds(250, 169, 286, 26);
    getContentPane().add(txtFoodItemName);
    
    txtFoodItemCost = new JTextField();
    txtFoodItemCost.setFont(new Font("Arial", Font.BOLD, 20));
    txtFoodItemCost.setColumns(10);
    txtFoodItemCost.setBounds(250, 230, 286, 26);
    getContentPane().add(txtFoodItemCost);
    
    btnInsert = new JButton("Insert");
    btnInsert.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		
    		String foodItemID = txtFoodItemID.getText();
    		String foodItemName = txtFoodItemName.getText();
    		String foodItemsCost  = txtFoodItemCost.getText();
    		String foodItemImage = lblFoodItemImage.getText();
    		JFrame frame = null;
    		 String id = txtManagerID.getText();

//    		try {
//    			connectionWithDatabase.connection();
//				java.sql.Statement s = connectionWithDatabase.getCON().createStatement();
//				String sql="INSERT INTO `eventsmanagementsystem`.`tbl_foodmanagement` (`FoodItemName`, `FoodItemCost`, `FoodItemImage`, `EventManagerID`) VALUES ('"+foodItemName+"', "+foodItemsCost+", '"+foodItemImage+"', "+id+")";
//				//INSERT INTO `eventsmanagementsystem`.`tbl_foodmanagement` (`FoodItemName`, `FoodItemCost`, `FoodItemImage`, `EventManagerID`) VALUES ('1', 1, '',)
//				s.execute(sql);     
//				
//				JOptionPane.showMessageDialog(frame,"Success");  
//
//	    		dispose();
//	    		frmFoodManagement.main(null);
//			} catch (Exception e2) {
//				
//			}
    		 
    		 
    		 
    		 
    		 String txtPicture = txtImage.getText();
 			
 			
 			try {
 				connectionWithDatabase.connection();

 				

 				java.sql.Statement s = connectionWithDatabase.getCON().createStatement();
 				String query = "INSERT INTO `eventsmanagementsystem`.`tbl_foodmanagement` (`FoodItemName`, `FoodItemCost`, `FoodItemImage`, `EventManagerID`) VALUES (?,?,?,?)";
 				PreparedStatement pstmt = connectionWithDatabase.getCON().prepareStatement(query);
 				FileInputStream fin = new FileInputStream(txtPicture);
 				
 			   // pstmt.setBinaryStream(1, fin);
 				
 				
 				
 				pstmt.setString(1,foodItemName);
 				pstmt.setString(2,foodItemsCost);
 				pstmt.setBlob(3, fin);
 				pstmt.setString(4,id);
 				
 			    pstmt.execute();
 			    JOptionPane.showMessageDialog(frame,"Sucess");
 				
 			   dispose();
	    		frmFoodManagement.main(null);
 				
 				
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
    		
    		
    		
    		
    		 
    		String foodItemID = txtFoodItemID.getText();
    		String foodItemName = txtFoodItemName.getText();
    		String foodItemsCost  = txtFoodItemCost.getText();
    		
//    		 JFileChooser file = new JFileChooser();
//    		 File selectedFile = file.getSelectedFile();
//                 String path = selectedFile.getAbsolutePath();
//                 lblFoodItemImage.setIcon(ResizeImage(path));
//                txtImage.setText(path);
    		
                String foodItemImage = lblFoodItemImage.getText();
                
                
    		JFrame frame = null;
 	
        	DefaultTableModel t = (DefaultTableModel)table.getModel();
	        int row = table.getSelectedRow();
	        String eve = (String) table.getModel().getValueAt(row, 0);
	        String sql = "UPDATE `eventsmanagementsystem`.`tbl_foodmanagement` SET `FoodItemName` = '"+foodItemName+"', `FoodItemCost` = "+foodItemsCost+", `FoodItemImage` = '"+foodItemImage+"' WHERE `FoodItemID` = "+eve+"";
	        try {

 				
 				
	        	
	        	connectionWithDatabase.connection();
	        	java.sql.Statement   s = connectionWithDatabase.getCON().prepareStatement(sql);
	            s.execute(sql);
	            JOptionPane.showMessageDialog(null, "Congratulation !!");
	            dispose();
	            frmFoodManagement.main(null);
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
	        String sql = "DELETE FROM `eventsmanagementsystem`.`tbl_foodmanagement` WHERE `FoodItemID` = "+eve+"";
	        try {
	        	connectionWithDatabase.connection();
	        	java.sql.Statement   s = connectionWithDatabase.getCON().prepareStatement(sql);
	            s.execute(sql);
	            JOptionPane.showMessageDialog(null, "Congratulation !!");
	            dispose();
	            frmFoodManagement.main(null);
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
				
//	               frmFoodManagement.main(null);
//	               dispose();
	               txtFoodItemCost.setText("");
	               txtFoodItemID.setText("");
	               txtFoodItemName.setText("");
	               txtManagerID.setText("");
	               lblFoodItemImage.setText("");
	               
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
    
  
    txtImage.setBounds(28, 525, -10, 19);
    getContentPane().add(txtImage);
    txtImage.setColumns(10);
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
        Image newImg = img.getScaledInstance(lblFoodItemImage.getWidth(), lblFoodItemImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    
    public static void main(String[] args){
    	try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		} catch (Exception e) {
			// TODO: handle exception
		}
        new frmFoodManagement();
        
    }
   }