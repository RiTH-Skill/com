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

public class frmEquipmentManagement extends JFrame{
	
	//public static JFrame frame = new JFrame();
    JButton btnC ;
    JLabel lblEquipmentImage;
    private JButton btnNewButton_2;
	private JLabel lblNewLabel;
	private JLabel lblVenueManagement;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_6;
	private JPanel panel;
	private JTextField txtEquipmentID;
	private JTextField txtEquipmentName;
	private JTextField txtEquipmentCost;
	private JButton btnInsert;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnClear;
	private JLabel lblManagerid;
	private JTextField txtManagerID;
	private JTextField txtImage;
	
    
    public frmEquipmentManagement(){
    super("Set Picture Into A JLabel Using JFileChooser In Java");
    setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Downloads\\icons8_management_64.png"));
    setTitle("");
    addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		
    		
    		DefaultTableModel model =  (DefaultTableModel)table.getModel();
        	int index = table.getSelectedRow();

			txtEquipmentID.setText(model.getValueAt(index,0).toString());
			txtEquipmentName.setText(model.getValueAt(index,1).toString());
			txtEquipmentCost.setText(model.getValueAt(index,2).toString());
	//		lblEquipmentImage.setText(model.getValueAt(index,3).toString());
			
			try {
				java.sql.Statement s = connectionWithDatabase.getCON().createStatement();
				int row = table.getSelectedRow();
				String eve = (String) table.getModel().getValueAt(row, 0);
				String sql = "SELECT * FROM `eventsmanagementsystem`.`tbl_equipmentmanagement` WHERE EquipmeniID  = "+eve+" ";
			  ResultSet r = s.executeQuery(sql);
			  DefaultTableModel t =  (DefaultTableModel)table.getModel();
			  while(r.next())
				{
				  String ManagerID= r.getString(4);
					txtManagerID.setText(ManagerID);
				}
			  
			  
			} catch (Exception e2) {
				
			}
			
			
			
			
			int row = table.getSelectedRow();
	        String eve = (String) table.getModel().getValueAt(row, 0);
		
		try{

			 connectionWithDatabase.connection();	               
				java.sql.Statement s = connectionWithDatabase.getCON().createStatement();
				String sql="SELECT * FROM `eventsmanagementsystem`.`tbl_equipmentmanagement` WHERE EquipmeniID  = "+eve+" ";

				ResultSet r = s.executeQuery(sql);
                if(r.next()){
                byte[] img = r.getBytes("EquipmentImage");
               
                //Resize The ImageIcon
                ImageIcon image = new ImageIcon(img);
                java.awt.Image im = image.getImage();
                java.awt.Image myImg = im.getScaledInstance(lblEquipmentImage.getWidth(), lblEquipmentImage.getHeight(),java.awt.Image.SCALE_SMOOTH);
                ImageIcon newImage = new ImageIcon(myImg);
                lblEquipmentImage.setIcon(newImage);
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
					t.addColumn("EquipmentID");
					t.addColumn("EquipmentName");
					t.addColumn("EquipmentCost");
					t.addColumn("EquipmentImage");
					
					
					
					java.sql.Statement s = connectionWithDatabase.getCON().createStatement();
 					String sql="SELECT * FROM `eventsmanagementsystem`.`tbl_equipmentmanagement` ";

 					ResultSet r = s.executeQuery(sql);
 					while(r.next())
 					{
 						String equipmentID= r.getString(1);
 						String equipmentName= r.getString(2);
 						String equipmentCost= r.getString(3);
 						String equipmentImage= r.getString(5);
 						
 						 t.addRow(new Object[]{equipmentID,equipmentName,equipmentCost,equipmentImage});
 					}
 				r.close();
 				s.close();
					
					
					
					
					
				
				} catch (Exception e2) {
					// TODO: handle exception
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
              lblEquipmentImage.setIcon(ResizeImage(path));
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
    
    lblVenueManagement = new JLabel("Equipment Management");
    lblVenueManagement.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
    lblVenueManagement.setBounds(522, 10, 257, 56);
    getContentPane().add(lblVenueManagement);
    
    lblNewLabel_1 = new JLabel("EquipmentID\r :\r\n");
    lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_1.setBounds(10, 102, 193, 56);
    getContentPane().add(lblNewLabel_1);
    
    lblNewLabel_2 = new JLabel("EquipmentName :");
    lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_2.setBounds(10, 158, 206, 56);
    getContentPane().add(lblNewLabel_2);
    
    lblNewLabel_4 = new JLabel("EquipmentCost :");
    lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_4.setBounds(10, 224, 193, 56);
    getContentPane().add(lblNewLabel_4);
    
    lblNewLabel_6 = new JLabel("EquipmentImage :");
    lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_6.setBounds(10, 384, 193, 56);
    getContentPane().add(lblNewLabel_6);
    
    panel = new JPanel();
    panel.setBounds(254, 398, 286, 205);
    getContentPane().add(panel);
    panel.setLayout(null);
    lblEquipmentImage = new JLabel();
    lblEquipmentImage.setBounds(0, 0, 286, 205);
    panel.add(lblEquipmentImage);
    lblEquipmentImage.setBackground(Color.WHITE);
    
    txtEquipmentID = new JTextField();
    txtEquipmentID.setFont(new Font("Arial", Font.BOLD, 20));
    txtEquipmentID.setEditable(false);
    txtEquipmentID.setBounds(250, 121, 286, 26);
    getContentPane().add(txtEquipmentID);
    txtEquipmentID.setColumns(10);
    
    txtEquipmentName = new JTextField();
    txtEquipmentName.setFont(new Font("Arial", Font.BOLD, 20));
    txtEquipmentName.setColumns(10);
    txtEquipmentName.setBounds(250, 169, 286, 26);
    getContentPane().add(txtEquipmentName);
    
    txtEquipmentCost = new JTextField();
    txtEquipmentCost.setFont(new Font("Arial", Font.BOLD, 20));
    txtEquipmentCost.setColumns(10);
    txtEquipmentCost.setBounds(250, 230, 286, 26);
    getContentPane().add(txtEquipmentCost);
    
    btnInsert = new JButton("Insert");
    btnInsert.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		
    		
    		String equipmentImage = lblEquipmentImage.getText();
    		String equipmentID = txtEquipmentID.getText();
    		String equipmentName  = txtEquipmentName.getText();
    		String equipmentCost = txtEquipmentCost.getText();
    		JFrame frame = null;
            String id = txtManagerID.getText();

//    		try {
//    			connectionWithDatabase.connection();
//				java.sql.Statement s = connectionWithDatabase.getCON().createStatement();
//				String sql="INSERT INTO `eventsmanagementsystem`.`tbl_equipmentmanagement` (`EquipmentName`, `EquipmentCost`, `EventManagerID`, `EquipmentImage`) VALUES ('"+equipmentName+"', "+equipmentCost+", "+id+",'"+equipmentImage+"')";
//				s.execute(sql);     
//				
//				JOptionPane.showMessageDialog(frame,"Success");  
//
//	    		dispose();
//	    		frmEquipmentManagement.main(null);
//			} catch (Exception e2) {
//				
//			}
            
            
String txtPicture = txtImage.getText();
			
			
			try {
				connectionWithDatabase.connection();

				

				java.sql.Statement s = connectionWithDatabase.getCON().createStatement();
				String query = "INSERT INTO `eventsmanagementsystem`.`tbl_equipmentmanagement` (`EquipmentName`, `EquipmentCost`, `EventManagerID`, `EquipmentImage`) VALUES (?,?,?,?)";
				PreparedStatement pstmt = connectionWithDatabase.getCON().prepareStatement(query);
				FileInputStream fin = new FileInputStream(txtPicture);
			   // pstmt.setBinaryStream(1, fin);
				
				
				
				pstmt.setString(1,equipmentName);
				pstmt.setString(2,equipmentCost);
				pstmt.setString(3,id);
				pstmt.setBlob(4, fin);
				
			    pstmt.execute();
			    JOptionPane.showMessageDialog(frame,"Sucess");
				
				
			    dispose();
	    		frmEquipmentManagement.main(null);
				
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
    		
    		String equipmentImage = lblEquipmentImage.getText();
    		String equipmentID = txtEquipmentID.getText();
    		String equipmentName  = txtEquipmentName.getText();
    		String equipmentCost = txtEquipmentCost.getText();
    		JFrame frame = null;
 	
        	DefaultTableModel t = (DefaultTableModel)table.getModel();
	        int row = table.getSelectedRow();
	        String eve = (String) table.getModel().getValueAt(row, 0);
	        String sql = "UPDATE `eventsmanagementsystem`.`tbl_equipmentmanagement` SET `EquipmentName` = '"+equipmentName+"', `EquipmentCost` = "+equipmentCost+", `EquipmentImage` = '"+equipmentImage+"' WHERE `EquipmeniID` = "+eve+"";
	        try {
	        	connectionWithDatabase.connection();
	        	java.sql.Statement   s = connectionWithDatabase.getCON().prepareStatement(sql);
	            s.execute(sql);
	            JOptionPane.showMessageDialog(null, "Congratulation !!");
	            dispose();
	            frmEquipmentManagement.main(null);
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
	        String sql = "DELETE FROM `eventsmanagementsystem`.`tbl_equipmentmanagement` WHERE `EquipmeniID` = "+eve+"";
	        try {
	        	connectionWithDatabase.connection();
	        	java.sql.Statement   s = connectionWithDatabase.getCON().prepareStatement(sql);
	            s.execute(sql);
	            JOptionPane.showMessageDialog(null, "Congratulation !!");
	            dispose();
	            frmEquipmentManagement.main(null);
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
	              
				txtEquipmentCost.setText("");
				txtEquipmentID.setText("");
				txtEquipmentName.setText("");
				txtManagerID.setText("");
				lblEquipmentImage.setText("");
				
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
    lblManagerid.setBounds(607, 56, 112, 56);
    getContentPane().add(lblManagerid);
    
    txtManagerID = new JTextField();
    txtManagerID.setFont(new Font("Arial", Font.BOLD, 20));
    txtManagerID.setColumns(10);
    txtManagerID.setBounds(739, 66, 286, 26);
    getContentPane().add(txtManagerID);
    
    txtImage = new JTextField();
    txtImage.setBounds(31, 534, -11, 19);
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
        Image newImg = img.getScaledInstance(lblEquipmentImage.getWidth(), lblEquipmentImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    
    public static void main(String[] args){
    	try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		} catch (Exception e) {
			// TODO: handle exception
		}
        new frmEquipmentManagement();
        
    }
   }