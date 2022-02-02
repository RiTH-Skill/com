package com.booking.event;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.sql.ResultSet;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.swing.JSeparator;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Sides;
import javax.swing.AbstractListModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JEditorPane;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import java.awt.Toolkit;

public class frmInvoice {

	JFrame frame;
	private JTextField txtPrint;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		} catch (Exception e) {
			// TODO: handle exception
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmInvoice window = new frmInvoice();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frmInvoice() {
		initialize();
	}

	
	
	
	
	private void initialize() {
		
		
		

		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Downloads\\icons8_management_64.png"));

		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Home");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmUserDetail.main(null);
				frame.dispose();
			}
		});
		
		

		JPanel panelPDF = new JPanel();
		panelPDF.setBounds(0, 83, 1290, 601);
		frame.getContentPane().add(panelPDF);
		panelPDF.setLayout(null);
		
		JLabel lblWelcomeTo = new JLabel("Event Manager Name :");
		lblWelcomeTo.setFont(new Font("Arial", Font.BOLD, 20));
		lblWelcomeTo.setBounds(11, 23, 214, 56);
		panelPDF.add(lblWelcomeTo);
		
		JLabel lblNamemanager = new JLabel("RiTH");
		lblNamemanager.setFont(new Font("Arial", Font.BOLD, 20));
		lblNamemanager.setBounds(227, 23, 214, 56);
		panelPDF.add(lblNamemanager);
		
		JLabel lblInvoice = new JLabel("Invoice");
		lblInvoice.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvoice.setFont(new Font("Baskerville Old Face", Font.BOLD, 40));
		lblInvoice.setBounds(519, 0, 214, 56);
		panelPDF.add(lblInvoice);
		
		JLabel lblWelcomeTo_1 = new JLabel("***********************************************************************************************************\r\n**************************************************");
		lblWelcomeTo_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblWelcomeTo_1.setBounds(10, 74, 1260, 56);
		panelPDF.add(lblWelcomeTo_1);
		
		JLabel lblEventBookingEvent = new JLabel("Event Booking ");
		lblEventBookingEvent.setFont(new Font("Arial", Font.BOLD, 20));
		lblEventBookingEvent.setBounds(544, 109, 156, 56);
		panelPDF.add(lblEventBookingEvent);
		
		JLabel lblWelcomeTo_1_1 = new JLabel("***********************************************************************************************************\r\n**************************************************");
		lblWelcomeTo_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblWelcomeTo_1_1.setBounds(10, 145, 1260, 56);
		panelPDF.add(lblWelcomeTo_1_1);
		
		JLabel lblEventManagerId = new JLabel("Event Manager ID :");
		lblEventManagerId.setFont(new Font("Arial", Font.BOLD, 20));
		lblEventManagerId.setBounds(10, 175, 193, 56);
		panelPDF.add(lblEventManagerId);
		
		JLabel lblIdmanager = new JLabel("xxxxxx");
		lblIdmanager.setFont(new Font("Arial", Font.BOLD, 20));
		lblIdmanager.setBounds(200, 175, 132, 56);
		panelPDF.add(lblIdmanager);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(10, 229, 1260, 2);
		panelPDF.add(separator);
		
		JLabel lblE = new JLabel("Event Type");
		lblE.setFont(new Font("Arial", Font.BOLD, 20));
		lblE.setBounds(276, 221, 122, 56);
		panelPDF.add(lblE);
		
		JLabel lblV = new JLabel("Venue");
		lblV.setFont(new Font("Arial", Font.BOLD, 20));
		lblV.setBounds(486, 221, 78, 56);
		panelPDF.add(lblV);
		
		JLabel lblB = new JLabel("Booking ID");
		lblB.setFont(new Font("Arial", Font.BOLD, 20));
		lblB.setBounds(10, 221, 122, 56);
		panelPDF.add(lblB);
		
		JLabel lblBookingID = new JLabel("xxxxx");
		lblBookingID.setFont(new Font("Arial", Font.BOLD, 20));
		lblBookingID.setBounds(10, 276, 122, 56);
		panelPDF.add(lblBookingID);
		
		JLabel lblEventType = new JLabel("xxxxxx");
		lblEventType.setFont(new Font("Arial", Font.BOLD, 20));
		lblEventType.setBounds(276, 276, 198, 56);
		panelPDF.add(lblEventType);
		
		JLabel lblVenue = new JLabel("xxxxx");
		lblVenue.setFont(new Font("Arial", Font.BOLD, 20));
		lblVenue.setBounds(489, 276, 162, 56);
		panelPDF.add(lblVenue);
		
		JLabel lblG = new JLabel("Guest Count");
		lblG.setFont(new Font("Arial", Font.BOLD, 20));
		lblG.setBounds(661, 221, 132, 56);
		panelPDF.add(lblG);
		
		JLabel lblGuest = new JLabel("xxxxxx");
		lblGuest.setFont(new Font("Arial", Font.BOLD, 20));
		lblGuest.setBounds(661, 276, 132, 56);
		panelPDF.add(lblGuest);
		
		JLabel lblI = new JLabel("Items");
		lblI.setFont(new Font("Arial", Font.BOLD, 20));
		lblI.setBounds(917, 221, 64, 56);
		panelPDF.add(lblI);
		
		JLabel lblItems = new JLabel("xxxxx");
		lblItems.setFont(new Font("Arial", Font.BOLD, 20));
		lblItems.setBounds(920, 276, 182, 56);
		panelPDF.add(lblItems);
		
		JLabel lblCost = new JLabel("xxxxx");
		lblCost.setFont(new Font("Arial", Font.BOLD, 20));
		lblCost.setBounds(1098, 276, 141, 56);
		panelPDF.add(lblCost);
		
		JLabel lblC = new JLabel("Cost");
		lblC.setFont(new Font("Arial", Font.BOLD, 20));
		lblC.setBounds(1101, 221, 64, 56);
		panelPDF.add(lblC);
		
		JLabel Date = new JLabel(" Event Date :");
		Date.setFont(new Font("Arial", Font.BOLD, 20));
		Date.setBounds(945, 175, 132, 56);
		panelPDF.add(Date);
		
		JLabel lblTotalCost = new JLabel("Total Cost\r\n");
		lblTotalCost.setFont(new Font("Arial", Font.BOLD, 20));
		lblTotalCost.setBounds(10, 330, 122, 56);
		panelPDF.add(lblTotalCost);
		
		JLabel lblmanagerSignature = new JLabel("(Manager Signature)");
		lblmanagerSignature.setFont(new Font("Arial", Font.BOLD, 20));
		lblmanagerSignature.setBounds(11, 479, 214, 56);
		panelPDF.add(lblmanagerSignature);
		
		JLabel lblThanksYouFor = new JLabel("Thanks You For Your Business!!");
		lblThanksYouFor.setFont(new Font("Arial", Font.BOLD, 20));
		lblThanksYouFor.setBounds(854, 418, 321, 56);
		panelPDF.add(lblThanksYouFor);
		
		JLabel lblTotal = new JLabel("xxxxx");
		lblTotal.setFont(new Font("Arial", Font.BOLD, 20));
		lblTotal.setBounds(1096, 333, 122, 56);
		panelPDF.add(lblTotal);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBounds(11, 384, 1260, 2);
		panelPDF.add(separator_3);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(11, 330, 1260, 2);
		panelPDF.add(separator_2);
		
		JLabel lblDate = new JLabel("xxxxxx");
		lblDate.setFont(new Font("Arial", Font.BOLD, 20));
		lblDate.setBounds(1084, 175, 91, 56);
		panelPDF.add(lblDate);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\MS\\signature_100px.png"));
		lblNewLabel.setBounds(59, 418, 110, 80);
		panelPDF.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("EMS.Group");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\MS\\management_100px.png"));
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 30));
		lblNewLabel_1.setBounds(897, 10, 283, 74);
		panelPDF.add(lblNewLabel_1);
		frame.setBounds(100, 100, 1304, 721);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Saved Pictures\\home_50px.png"));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setBounds(1139, 10, 141, 42);
		frame.getContentPane().add(btnNewButton_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(769, 10, -7, 22);
		
		
		JButton btnNewButton_2_1 = new JButton("Print");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			

			

			public void actionPerformed(ActionEvent e) {
   
				 printRecord(panelPDF);
				
			}
		});
		btnNewButton_2_1.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Saved Pictures\\tick.png"));
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_2_1.setBackground(Color.GREEN);
		btnNewButton_2_1.setBounds(971, 10, 141, 42);
		frame.getContentPane().add(btnNewButton_2_1);
		
		txtPrint = new JTextField();
		txtPrint.setBounds(976, 10, -1, 35);
		frame.getContentPane().add(txtPrint);
		txtPrint.setColumns(10);
		
		
	
		
		
		
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				int id = AssignPassword.getId();
   			 try {
   					connectionWithDatabase.connection();
   					
   					//SELECT * FROM `eventsmanagementsystem`.`tbl_bookingview` WHERE EventManagerID = 3220  ORDER BY BookingID DESC LIMIT  1
   					String sql1 = "SELECT * FROM `eventsmanagementsystem`.`tbl_bookingview` WHERE EventManagerID = "+id+"   ORDER BY BookingID DESC LIMIT  1 ";
   				   
   					java.sql.Statement s = connectionWithDatabase.getCON().createStatement();    
   				        ResultSet r1=s.executeQuery(sql1);

   					if(r1.next()) {
   						String EventManagerID= r1.getString(2);
   						lblIdmanager.setText(EventManagerID);
   						String Booking= r1.getString(1);
   						lblBookingID.setText(Booking);
   						String EventType= r1.getString(3);
   						lblEventType.setText(EventType);
   						String VenuePlace= r1.getString(4);
   						lblVenue.setText(VenuePlace);
   						String Guest= r1.getString(9);
   						lblGuest.setText(Guest);
   						String FoodItem= r1.getString(7);
   						lblItems.setText(FoodItem);
   						String Cost= r1.getString(10);
   						lblCost.setText(Cost+"$");
   						String Total= r1.getString(10);
   						lblTotal.setText(Total+"$");
   						
   					}
   					
   					lblDate.setText(AssignPassword.getDate());
   				} catch (Exception e2) {
   					
   				}
   			 
   			 
   			 
   			
			 try {
					connectionWithDatabase.connection();
					
					String sql1 = "SELECT * FROM `eventsmanagementsystem`.`tbl_userregister` WHERE ManagerID = "+id+"";
				   
					java.sql.Statement s = connectionWithDatabase.getCON().createStatement();    
				        ResultSet r1=s.executeQuery(sql1);

					if(r1.next()) {
						
						String name= r1.getString(2);
						lblNamemanager.setText(name);
					}
					
					
				} catch (Exception e2) {
					
				}
   			 
   			 
   			 
   			 
			}
		});

	}
	

	
	private void printRecord(JPanel panel){

		//create PrinterJOb Here
		java.awt.print.PrinterJob printerJob = java.awt.print.PrinterJob.getPrinterJob();
		//set Printer JOb Name
		printerJob.setJobName("Print Record");

		//ser Printable
		printerJob.setPrintable(new Printable() {
		@Override
		public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		//check if No Printable Content
		if(pageIndex>0) {
		return Printable.NO_SUCH_PAGE;
		}
		// Make 2D Graphics to map content
		Graphics2D graphics2D = (Graphics2D)graphics;
		//set the Graphics Translations
		graphics2D.translate(pageFormat.getImageableX()*2,pageFormat.getImageableY()*2);
		//this is a page scale. Default should be 0.3 I am using 0.5
		graphics2D.scale(0.5,0.5);
		//now paint panel as graphics2D
		((JComponent) panel).paint(graphics2D);
		//return if page exits
		return Printable.PAGE_EXISTS;
		}
		}); 

		//store printerDialog as boolean 
		boolean returningResult = printerJob.printDialog();
		//check if dialog is showing

		if(returningResult){
		  
	   try {
		   printerJob.print();
	} catch (Exception e) {
		JOptionPane.showMessageDialog(frame,"fial");
	}

		}

}
}
