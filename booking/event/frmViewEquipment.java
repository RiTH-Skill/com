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

public class frmViewEquipment extends JFrame{
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
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblClient;
	
    
    public frmViewEquipment(){
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
		//	lblEquipmentImage.setText(model.getValueAt(index,3).toString());
			
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
           
    			String getPassword = AssignPassword.getPassword();   
    			int getID = AssignPassword.getId();
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
					String sql="SELECT * FROM `eventsmanagementsystem`.`tbl_equipmentmanagement` WHERE EventManagerID = "+getID+" ";
               
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
				
			}
            
            
            
            try {
				connectionWithDatabase.connection();
				
				String sql1 = "SELECT * FROM `eventsmanagementsystem`.`tbl_userregister` WHERE ManagerID = "+getID+"";
			   
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
    
    lblVenueManagement = new JLabel("View Equipments ");
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
    txtEquipmentName.setEditable(false);
    txtEquipmentName.setFont(new Font("Arial", Font.BOLD, 20));
    txtEquipmentName.setColumns(10);
    txtEquipmentName.setBounds(250, 169, 286, 26);
    getContentPane().add(txtEquipmentName);
    
    txtEquipmentCost = new JTextField();
    txtEquipmentCost.setEditable(false);
    txtEquipmentCost.setFont(new Font("Arial", Font.BOLD, 20));
    txtEquipmentCost.setColumns(10);
    txtEquipmentCost.setBounds(250, 230, 286, 26);
    getContentPane().add(txtEquipmentCost);
    
    scrollPane = new JScrollPane();
    scrollPane.setBounds(607, 112, 673, 491);
    getContentPane().add(scrollPane);
    
    table = new JTable();
    scrollPane.setViewportView(table);
    
    lblClient = new JLabel("Client");
    lblClient.setFont(new Font("Arial", Font.BOLD, 20));
    lblClient.setBounds(140, 10, 361, 56);
    getContentPane().add(lblClient);
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
        new frmViewEquipment();
        
    }
   }