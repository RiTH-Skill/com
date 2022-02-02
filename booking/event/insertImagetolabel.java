package com.booking.event;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Vector;
import java.awt.Color;

public class insertImagetolabel {

	private JFrame frame;
	private JTextField txtImage;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insertImagetolabel window = new insertImagetolabel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	private  static byte[] pic;

	public ImageIcon getImage(){
	return new ImageIcon(pic);
	}
	
	
	
	public insertImagetolabel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	JLabel lblImage = new JLabel("\\");

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		
		
		frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

				
				
	        	 int row = table.getSelectedRow();
			        String eve = (String) table.getModel().getValueAt(row, 0);
				
				try{

					 connectionWithDatabase.connection();	               
						java.sql.Statement s = connectionWithDatabase.getCON().createStatement();
						String sql="SELECT * FROM `eventsmanagementsystem`.`tbl_test` WHERE `id` = "+eve+" ";

						ResultSet r = s.executeQuery(sql);
	                    if(r.next()){
	                    byte[] img = r.getBytes("Image");

	                    //Resize The ImageIcon
	                    ImageIcon image = new ImageIcon(img);
	                    java.awt.Image im = image.getImage();
	                    java.awt.Image myImg = im.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(),java.awt.Image.SCALE_SMOOTH);
	                    ImageIcon newImage = new ImageIcon(myImg);
	                    lblImage.setIcon(newImage);
	                }
	                
	                else{
	                    JOptionPane.showMessageDialog(null, "No Data");
	                }
	            }catch(Exception ex){
	                ex.printStackTrace();
	            }
				
				

				
			}
		});
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				
				
				
				
				
				
				try {
					
					 connectionWithDatabase.connection();
	 					//AbstractButton table = null;	
					DefaultTableModel t =  (DefaultTableModel)table.getModel();
					 t.setColumnCount (0); 
					t.addColumn("ID");
					t.addColumn("Image");
					
					
					
					java.sql.Statement s = connectionWithDatabase.getCON().createStatement();
					//String sql="SELECT VenueID,VenueName,VenuePlace,VenueCost,VenueContact,VenueImage FROM `eventsmanagementsystem`.`tbl_venuemanagement`  where ManagerID = 5192";
					String sql="SELECT * FROM `eventsmanagementsystem`.`tbl_test`";

					ResultSet r = s.executeQuery(sql);
					while(r.next())
					{
						String foodItemsID= r.getString(1);
						Blob foodItemsName= r.getBlob(2);
						
						
					
						 t.addRow(new Object[]{foodItemsID,foodItemsName});
					}
					
					
//					  byte[] image = null;
//				      while (r.next()) {
//				    	  String foodItemsID= r.getString(1);	
//				        image = r.getBytes(2);
//				        t.addRow(new Object[]{foodItemsID,image});
//				      }
//				      //create the image 
//				      
//				      java.awt.Image img = java.awt.Toolkit.getDefaultToolkit().createImage(image);
//				      ImageIcon icone = new ImageIcon(img);
//				      lblImage.setIcon(icone);
//				      lblImage.add(lblImage);
		
				r.close();
				s.close();
					
		
				
				} catch (Exception e2) {
					
				}
				
				
				
				
//				 try
//				    {
//					 connectionWithDatabase.connection();
//					 java.sql.Statement s = connectionWithDatabase.getCON().createStatement();
//				        ResultSet rs = s.executeQuery("SELECT * FROM `eventsmanagementsystem`.`tbl_test`");
//
//				        ResultSetMetaData rsmetadata = (ResultSetMetaData) rs.getMetaData();
//				        int col = rsmetadata.getColumnCount();
//				        DefaultTableModel dtm = new DefaultTableModel();
//
//				        Vector<String> col_name = new Vector<String>();
//				        Vector<Object> row_data = new Vector<Object>();
//
//				        for(int i=1;i<=col;i++)
//				        {
//				            col_name.addElement(rsmetadata.getColumnName(i));
//				        }
//
//				        dtm.setColumnIdentifiers(col_name);
//
//				        while(rs.next())
//				        {
//				            row_data = new Vector<Object>();
//
//				            for(int i=1;i<=col;i++)
//				            {
//				                row_data.addElement(rs.getObject(i));
//				            }
//
//				            dtm.addRow(row_data);
//				        }
//
//				    table = new JTable( dtm )
//				    {
//				        public Class getColumnClass(int column)
//				        {
//				            return getValueAt(0, column).getClass();
//				        }
//				    };
//
//				    table.setModel(dtm);
//
//				   // add(table);
//
//				    }
//
//				    catch(SQLException e1)
//				    {
//				        System.out.println("Unknown Error");
//				    }
//
//				    catch(Exception eg)
//				    {
//				        System.out.println("Unknown Error");
//				    }
				
				
				
				
				
				
				
				
				
				
			}
		});
		frame.setBounds(100, 100, 992, 664);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setOpaque(false);
		scrollPane_1.setName("");
		scrollPane_1.setLocale(new Locale("km"));
		scrollPane_1.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent e) {
			}
		});
		scrollPane_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
//				 int i = table.getSelectedRow();
//			        if(table.getValueAt(i, 1) != null)
//			        {
//			        ImageIcon image1 = (ImageIcon)table.getValueAt(i, 1);
//			        java.awt.Image image2 = image1.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight()
//			                 , java.awt.Image.SCALE_SMOOTH);
//			        ImageIcon image3 = new ImageIcon(image2);
//			        lblImage.setIcon(image3);
//			        }
//			        else{
//			            System.out.println("No Image");
//			        }
//				
				
			        
			        
			    
			        
			        
			        
			        
			        
			        
				
			}
		});
		scrollPane_1.setBounds(50, 353, 412, 248);
		frame.getContentPane().add(scrollPane_1);
		
		table = new JTable();
		table.setAutoscrolls(false);
		scrollPane_1.setViewportView(table);
		
		txtImage = new JTextField();
		txtImage.setBounds(100, 93, 286, 73);
		frame.getContentPane().add(txtImage);
		txtImage.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(544, 47, 388, 399);
		frame.getContentPane().add(scrollPane);
		
	
		scrollPane.setViewportView(lblImage);
		
		JButton btnNewButton = new JButton("browse");
		btnNewButton.addActionListener(new ActionListener() {
			
			JFileChooser fc = new JFileChooser();
			public void actionPerformed(ActionEvent e) {
				
				
				int click = fc.showOpenDialog(frame);
				if(click==fc.APPROVE_OPTION){
				File f =fc.getSelectedFile();
				lblImage.setIcon(new ImageIcon(f.getPath()));
				txtImage.setText(f.getPath());
				}
				
			}
		});
		btnNewButton.setBounds(33, 202, 163, 46);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txtPicture = txtImage.getText();
				
				
				try {
					connectionWithDatabase.connection();
//					java.sql.Statement s = connectionWithDatabase.getCON().createStatement();
//					String sql ="INSERT INTO `eventsmanagementsystem`.`tbl_test` (`image`) VALUES ('"+txtPicture+"')";
//					s.execute(sql);
//	                
//					JOptionPane.showMessageDialog(frame,"Sucess");
					

					java.sql.Statement s = connectionWithDatabase.getCON().createStatement();
					String query = "INSERT INTO  `eventsmanagementsystem`.`tbl_test` (`image`) VALUES (?)";
					PreparedStatement pstmt = connectionWithDatabase.getCON().prepareStatement(query);
					FileInputStream fin = new FileInputStream(txtPicture);
				   // pstmt.setBinaryStream(1, fin);
					pstmt.setBlob(1, fin);
					
				    pstmt.execute();
				    JOptionPane.showMessageDialog(frame,"Sucess");
					
					
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
		
				
				
				
				
				
				
				
			}
		});
		btnSave.setBounds(271, 202, 163, 46);
		frame.getContentPane().add(btnSave);
	}
	
	
	


	
	
	
	
	
}
