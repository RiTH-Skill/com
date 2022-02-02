package com.booking.event;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.math.BigDecimal;
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

public class frmBookEvent extends JFrame{
    private JButton btnNewButton_2;
	private JLabel lblNewLabel;
	private JLabel lblVenueManagement;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JTextField txtVenueCost;
	private JTextField txtFoodItemCost;
	private JTextField txtEquipmentCost;
	private JLabel lblClient;
	private JTextField txtTotalCost;
	private JTextField txtNoOfGuest;
	
    
    public frmBookEvent(){
    super("Set Picture Into A JLabel Using JFileChooser In Java");
    setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Downloads\\icons8_management_64.png"));
    setTitle("");
    addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    	}
    });
    setResizable(false);
    getContentPane().setBackground(Color.WHITE);
    
    
    
    JPanel panel = new JPanel();
    panel.setBackground(Color.WHITE);
    panel.setBounds(746, 104, 510, 323);
    getContentPane().add(panel);
    panel.setLayout(null);
    
    JPanel panel_1 = new JPanel();
    panel_1.setBounds(192, 10, 150, 105);
    panel.add(panel_1);
    panel_1.setLayout(null);
    
    JLabel lblVenue = new JLabel("");
    lblVenue.setBackground(Color.WHITE);
    lblVenue.setBounds(0, 0, 150, 105);
    panel_1.add(lblVenue);
    
    JPanel panel_2 = new JPanel();
    panel_2.setBounds(29, 174, 150, 105);
    panel.add(panel_2);
    panel_2.setLayout(null);
    
    JLabel lblFoodItem = new JLabel("");
    lblFoodItem.setBackground(Color.WHITE);
    lblFoodItem.setBounds(0, 0, 150, 105);
    panel_2.add(lblFoodItem);
    
    JPanel panel_3 = new JPanel();
    panel_3.setBounds(335, 174, 150, 105);
    panel.add(panel_3);
    panel_3.setLayout(null);
    
    JLabel lblEquip = new JLabel("");
    lblEquip.setBackground(Color.WHITE);
    lblEquip.setBounds(0, 0, 150, 105);
    panel_3.add(lblEquip);
    
    
    
    
    
    
    
JComboBox cboVenue = new JComboBox();
JList listEquipemt = new JList();
JList listFoodItems = new JList();
    cboVenue.setFont(new Font("Arial", Font.BOLD, 20));
    cboVenue.setModel(new DefaultComboBoxModel(new String[] {"", "Bar", "Pub", "Club", "Restaurant", "Hotel", "Conference Center", "Business Center", "Community Center", "Sport Club", "Art Gallery", "Academic Venue", "Stately Home", "Stadium And Arena", "Park and fields", "ect.."}));
    cboVenue.setBounds(194, 178, 234, 26);
    getContentPane().add(cboVenue);
    
    
    cboVenue.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mousePressed(MouseEvent e) {
    		
    		String venueCost="";
            
            if(cboVenue.getSelectedIndex()==0) {
            	venueCost="1500$";
        	}else if(cboVenue.getSelectedIndex()==1) {
        		venueCost="500$";
        	}else if(cboVenue.getSelectedIndex()==2) {
        		venueCost="2000$";
        	}else if(cboVenue.getSelectedIndex()==3) {
        		venueCost="1800$";
        	}else if(cboVenue.getSelectedIndex()==4) {
        		venueCost="3000$";
        	}else if(cboVenue.getSelectedIndex()==5) {
        		venueCost="700$";
        	}else if(cboVenue.getSelectedIndex()==6) {
        		venueCost="1200$";
        	}else if(cboVenue.getSelectedIndex()==7) {
        		venueCost="1300$";
        	}else if(cboVenue.getSelectedIndex()==8) {
        		venueCost="1900$";
        	}else if(cboVenue.getSelectedIndex()==9) {
        		venueCost="900$";
        	}else if(cboVenue.getSelectedIndex()==10) {
        		venueCost="600$";
        	}else if(cboVenue.getSelectedIndex()==11) {
        		venueCost="1350$";
        	}else if(cboVenue.getSelectedIndex()==12) {
        		venueCost="2300$";
        	}else if(cboVenue.getSelectedIndex()==13) {
        		venueCost="950$";
        	}else venueCost="Negotiate";
            txtVenueCost.setText(venueCost);
            System.out.println("VenueCost : "+venueCost);
            
    	}
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		
    		
    		
        	if(cboVenue.getSelectedIndex()==0) {
        		lblVenue.setIcon(new ImageIcon(""));
        	}
        	if(cboVenue.getSelectedIndex()==1) {
        		lblVenue.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Venue\\bar2.jpg"));
        	}else if(cboVenue.getSelectedIndex()==2) {
        		lblVenue.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Venue\\pub.jpg"));
        	}else if(cboVenue.getSelectedIndex()==3) {
        		lblVenue.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Venue\\club2.jpg"));
        	}else if(cboVenue.getSelectedIndex()==4) {
        		lblVenue.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Venue\\restaurant2.jpg"));
        	}else if(cboVenue.getSelectedIndex()==5) {
        		lblVenue.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Venue\\Hotel2.jpg"));
        	}else if(cboVenue.getSelectedIndex()==6) {
        		lblVenue.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Venue\\Conference Cente2.jpg"));
        	}else if(cboVenue.getSelectedIndex()==7) {
        		lblVenue.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Venue\\business event.jpg"));
        	}else if(cboVenue.getSelectedIndex()==8) {
        		lblVenue.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Venue\\Community Center.jpg"));
        	}else if(cboVenue.getSelectedIndex()==9) {
        		lblVenue.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Venue\\Sport Club2.jpg"));
        	}else if(cboVenue.getSelectedIndex()==10) {
        		lblVenue.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Venue\\Art Gallery2.jpg"));
        	}else if(cboVenue.getSelectedIndex()==11) {
        		lblVenue.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Venue\\Academic2 .jpg"));
        	}else if(cboVenue.getSelectedIndex()==12) {
        		lblVenue.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Venue\\Stately Home.jpg"));
        	}else if(cboVenue.getSelectedIndex()==13) {
        		lblVenue.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Venue\\Stadium And Arena2.jpg"));
        	}else if(cboVenue.getSelectedIndex()==14) {
        		lblVenue.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Venue\\Park and fields2.jpg"));
        	}else lblVenue.setIcon(new ImageIcon(""));


    		
    		
    	}
    });
   
    
    
    
    addWindowListener(new WindowAdapter() {
    	@Override
    	public void windowOpened(WindowEvent e) {
    		 setLocationRelativeTo(null);
    			setVisible(true);
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
    lblNewLabel.setBounds(10, 10, 130, 56);
    getContentPane().add(lblNewLabel);
    
    lblVenueManagement = new JLabel("Book An Event\r\n");
    lblVenueManagement.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
    lblVenueManagement.setBounds(522, 10, 257, 56);
    getContentPane().add(lblVenueManagement);
    
    lblNewLabel_1 = new JLabel("Venue Cost :");
    lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_1.setBounds(732, 428, 193, 56);
    getContentPane().add(lblNewLabel_1);
    
    lblNewLabel_2 = new JLabel("FoodItems Cost :");
    lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_2.setBounds(732, 484, 206, 56);
    getContentPane().add(lblNewLabel_2);
    
    lblNewLabel_4 = new JLabel("Equipment Cost :");
    lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_4.setBounds(732, 541, 193, 56);
    getContentPane().add(lblNewLabel_4);
    
    txtVenueCost = new JTextField();
    txtVenueCost.setFont(new Font("Arial", Font.BOLD, 20));
    txtVenueCost.setEditable(false);
    txtVenueCost.setBounds(972, 447, 286, 26);
    getContentPane().add(txtVenueCost);
    txtVenueCost.setColumns(10);
    
    txtFoodItemCost = new JTextField();
    txtFoodItemCost.setEditable(false);
    txtFoodItemCost.setFont(new Font("Arial", Font.BOLD, 20));
    txtFoodItemCost.setColumns(10);
    txtFoodItemCost.setBounds(972, 495, 286, 26);
    getContentPane().add(txtFoodItemCost);
    
    txtEquipmentCost = new JTextField();
    txtEquipmentCost.setEditable(false);
    txtEquipmentCost.setFont(new Font("Arial", Font.BOLD, 20));
    txtEquipmentCost.setColumns(10);
    txtEquipmentCost.setBounds(972, 556, 286, 26);
    getContentPane().add(txtEquipmentCost);
    
    lblClient = new JLabel("Client");
    lblClient.setFont(new Font("Arial", Font.BOLD, 20));
    lblClient.setBounds(140, 10, 372, 56);
    getContentPane().add(lblClient);
    
    JLabel lblNewLabel_4_1 = new JLabel("Total Cost :");
    lblNewLabel_4_1.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_4_1.setBounds(732, 592, 193, 56);
    getContentPane().add(lblNewLabel_4_1);
    
    txtTotalCost = new JTextField();
    txtTotalCost.setFont(new Font("Arial", Font.BOLD, 20));
    txtTotalCost.setEditable(false);
    txtTotalCost.setColumns(10);
    txtTotalCost.setBounds(972, 607, 286, 26);
    getContentPane().add(txtTotalCost);
    
    JLabel lblNewLabel_1_1 = new JLabel("Event Type :");
    lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_1_1.setBounds(29, 104, 150, 56);
    getContentPane().add(lblNewLabel_1_1);
    
    JLabel lblNewLabel_2_1 = new JLabel("Venue :");
    lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_2_1.setBounds(29, 160, 89, 56);
    getContentPane().add(lblNewLabel_2_1);
    
    JLabel lblNewLabel_4_2 = new JLabel("Venue Type :");
    lblNewLabel_4_2.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_4_2.setBounds(29, 217, 150, 56);
    getContentPane().add(lblNewLabel_4_2);
    
    JLabel lblNewLabel_4_1_1 = new JLabel("Event Date :");
    lblNewLabel_4_1_1.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_4_1_1.setBounds(29, 268, 193, 56);
    getContentPane().add(lblNewLabel_4_1_1);
    
    JLabel lblNewLabel_4_1_1_1 = new JLabel("Food Items :");
    lblNewLabel_4_1_1_1.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_4_1_1_1.setBounds(29, 326, 136, 56);
    getContentPane().add(lblNewLabel_4_1_1_1);
    
    JComboBox cboEventType = new JComboBox();
    cboEventType.setModel(new DefaultComboBoxModel(new String[] {"", "FamilyEvent", "FriendEvent", "MeetingEvent", "ForumEvent", "CultureEvent", "ForeignEvent", "BelieveEvent", "BirthdayEvent", "WeddingEvent", "PartyEvent", "HomeComingEvent", "etc..."}));
    cboEventType.setFont(new Font("Arial", Font.BOLD, 20));
    cboEventType.setBounds(194, 122, 234, 26);
    getContentPane().add(cboEventType);
    
   
    
    JComboBox cboVenueType = new JComboBox();
    cboVenueType.setFont(new Font("Arial", Font.BOLD, 20));
    cboVenueType.setModel(new DefaultComboBoxModel(new String[] {"", "Indoor", "Outdoor"}));
    cboVenueType.setBounds(194, 232, 234, 26);
    getContentPane().add(cboVenueType);
    
    JLabel lblNewLabel_4_1_1_1_1 = new JLabel("Equipment :");
    lblNewLabel_4_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_4_1_1_1_1.setBounds(29, 467, 136, 56);
    getContentPane().add(lblNewLabel_4_1_1_1_1);
    
    JScrollPane scrollPane_1 = new JScrollPane();
    scrollPane_1.setBounds(208, 484, 153, 110);
    getContentPane().add(scrollPane_1);
    
    //JList listEquipemt = new JList();
    listEquipemt.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mousePressed(MouseEvent e) {
    		String equipmentCost="";
        	if(listEquipemt.getSelectedIndex()==0) {
        		equipmentCost = "20$";
        	}else equipmentCost = "35$";
        	txtEquipmentCost.setText(equipmentCost);
    	}
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		
    	
        	
        	 if(listEquipemt.getSelectedIndex()==0) {
        		 lblEquip.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Equipment\\decoration2.jpg"));
        	}else         		 lblEquip.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Equipment\\lightening.jpg"));



    		
    		
    		
    	}
    });
    scrollPane_1.setViewportView(listEquipemt);
    listEquipemt.setModel(new AbstractListModel() {
    	String[] values = new String[] {"Decorations", "Lightening"};
    	public int getSize() {
    		return values.length;
    	}
    	public Object getElementAt(int index) {
    		return values[index];
    	}
    });
    listEquipemt.setFont(new Font("Arial", Font.BOLD, 20));
    
    JLabel lblNewLabel_4_1_1_1_1_1 = new JLabel("No of Guest :");
    lblNewLabel_4_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 20));
    lblNewLabel_4_1_1_1_1_1.setBounds(29, 615, 136, 56);
    getContentPane().add(lblNewLabel_4_1_1_1_1_1);
    
    txtNoOfGuest = new JTextField();
    txtNoOfGuest.setFont(new Font("Arial", Font.BOLD, 20));
    txtNoOfGuest.setBounds(194, 634, 214, 26);
    getContentPane().add(txtNoOfGuest);
    txtNoOfGuest.setColumns(10);
    
    JLabel lblDay = new JLabel("Day");
    lblDay.setForeground(Color.BLACK);
    lblDay.setFont(new Font("Arial", Font.BOLD, 20));
    lblDay.setBounds(169, 274, 58, 40);
    getContentPane().add(lblDay);
    
    JComboBox cboDay = new JComboBox();
    cboDay.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
    cboDay.setFont(new Font("Arial", Font.BOLD, 20));
    cboDay.setBounds(214, 282, 58, 20);
    getContentPane().add(cboDay);
    
    JLabel lblMonth = new JLabel("Month");
    lblMonth.setForeground(Color.BLACK);
    lblMonth.setFont(new Font("Arial", Font.BOLD, 20));
    lblMonth.setBounds(313, 268, 72, 40);
    getContentPane().add(lblMonth);
    
    JComboBox cboMonth = new JComboBox();
    cboMonth.setModel(new DefaultComboBoxModel(new String[] {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "Octorber", "November", "December"}));
    cboMonth.setFont(new Font("Arial", Font.BOLD, 20));
    cboMonth.setBounds(382, 278, 119, 20);
    getContentPane().add(cboMonth);
    
    JLabel lblYear = new JLabel("Year");
    lblYear.setForeground(Color.BLACK);
    lblYear.setFont(new Font("Arial", Font.BOLD, 20));
    lblYear.setBounds(540, 268, 72, 40);
    getContentPane().add(lblYear);
    
    JComboBox cboYear = new JComboBox();
    cboYear.setModel(new DefaultComboBoxModel(new String[] {"", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081", "2082", "2083", "2084", "2085", "2086", "2087", "2088", "2089", "2090", "2091", "2092", "2093", "2094"}));
    cboYear.setFont(new Font("Arial", Font.BOLD, 20));
    cboYear.setBounds(605, 278, 106, 20);
    getContentPane().add(cboYear);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(214, 334, 466, 112);
    getContentPane().add(scrollPane);
    
    //JList listFoodItems = new JList();
    listFoodItems.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mousePressed(MouseEvent e) {
    		
    	
    		
            if(listFoodItems.isSelectedIndex(0)) {
            lblFoodItem.setIcon(new ImageIcon("C:\\\\Users\\\\user\\\\OneDrive\\\\Pictures\\\\Fooditem\\\\Brunch2.jpg"));
        	}else if(listFoodItems.isSelectedIndex(1)) {
        		 lblFoodItem.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Fooditem\\Buffet2.jpg"));
            }else if(listFoodItems.isSelectedIndex(2)) {
            	 lblFoodItem.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Fooditem\\Puddings2.jpg"));
            }else if(listFoodItems.isSelectedIndex(3)) {
            	 lblFoodItem.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Fooditem\\Fine Dining2.jpg"));
            }else if(listFoodItems.isSelectedIndex(4)) {
            	 lblFoodItem.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Fooditem\\Casual Dining2.jpg"));
            }else if(listFoodItems.isSelectedIndex(5)) {
            	 lblFoodItem.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Fooditem\\Contemporary Casual2.jpg"));
            }else if(listFoodItems.isSelectedIndex(6)) {
            	 lblFoodItem.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Fooditem\\Family Style2.jpg"));
            }else if(listFoodItems.isSelectedIndex(7)) {
            	 lblFoodItem.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Fooditem\\Fast Casual2.jpg"));
            }else if(listFoodItems.isSelectedIndex(8)) {
            	 lblFoodItem.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Fooditem\\Fast Food2.jpg"));
            }else if(listFoodItems.isSelectedIndex(9)) {
            	 lblFoodItem.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Fooditem\\Cafe2.jpg"));
            }else if(listFoodItems.isSelectedIndex(10)) {
            	 lblFoodItem.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Fooditem\\Food Trucks and Concession Stands2.jpg"));
            }else lblFoodItem.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Fooditem\\Pop-Up Restaurant.jpg"));
           
    	}
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		
    		
    		String foodItems = "";
        	Component frame = null;
			if(listFoodItems.isSelectedIndex(-1)) {
        		JOptionPane.showMessageDialog(frame ,"Please Select FoodItems");
        	}   	
        	if(listFoodItems.isSelectedIndex(0)) {
        		foodItems = "Brunch";
        	}else if(listFoodItems.isSelectedIndex(1)) {
        		foodItems = "Buffet";
            }else if(listFoodItems.isSelectedIndex(2)) {
            	foodItems = "Puddings";
            }else if(listFoodItems.isSelectedIndex(3)) {
            	foodItems = "Fine Dining";
            }else if(listFoodItems.isSelectedIndex(4)) {
            	foodItems = "Casual Dining";
            }else if(listFoodItems.isSelectedIndex(5)) {
            	foodItems = "Contemporary Casual";
            }else if(listFoodItems.isSelectedIndex(6)) {
            	foodItems = "Family Style";
            }else if(listFoodItems.isSelectedIndex(7)) {
            	foodItems = "Fast Casual";
            }else if(listFoodItems.isSelectedIndex(8)) {
            	foodItems = "Fast Food";
            }else if(listFoodItems.isSelectedIndex(9)) {
            	foodItems = "Cafe";
            }else if(listFoodItems.isSelectedIndex(10)) {
            	foodItems = "Food Trucks and Concession Stands";
            }else foodItems="Pop-Up Restaurant";
        	
        	
        	
        	

    		
    	}
    });
    scrollPane.setViewportView(listFoodItems);
    listFoodItems.setFont(new Font("Arial", Font.BOLD, 20));
    listFoodItems.setModel(new AbstractListModel() {
    	String[] values = new String[] {"Brunch", "Buffet", "Puddings", "Fine Dining", "Casual Dining", "Contemporary Casual", "Family Style", "Fast Casual", "Fast Food", "Cafe", "Food Trucks and Concession Stands", "Pop-Up Restaurant"};
    	public int getSize() {
    		return values.length;
    	}
    	public Object getElementAt(int index) {
    		return values[index];
    	}
    });
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setSize(1304,718);
    setVisible(true);
    
    
    JButton btnNewSubmit = new JButton("Book");
    btnNewSubmit.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    	}
    });
    btnNewSubmit.addActionListener(new ActionListener() {
    	private Component frame;

		public void actionPerformed(ActionEvent e) {
    	//	frmPayment.main(null);
    		//dispose();
 
			
			
//			Component frame = null;
//    		if(listFoodItems.isSelectedIndex(-1)) {
//            	
//				JOptionPane.showMessageDialog(frame,"Please Select FoodItems");
//        	}
			
			
			
			
			String eventType ="";
			if(cboEventType.getSelectedIndex()==0) {
				JOptionPane.showMessageDialog(frame,"Please Select EventType");
			}
			if(cboEventType.getSelectedIndex()==1) {
				eventType ="FamilyEvent";
			}else if(cboEventType.getSelectedIndex()==2) {
				eventType ="FriendEvent";
			}else if(cboEventType.getSelectedIndex()==3) {
				eventType ="MeetingEvent";
			}else if(cboEventType.getSelectedIndex()==4) {
				eventType ="ForumEvent";
			}else if(cboEventType.getSelectedIndex()==5) {
				eventType ="CultureEvent";
			}else if(cboEventType.getSelectedIndex()==6) {
				eventType ="ForeignEvent";
			}else if(cboEventType.getSelectedIndex()==7) {
				eventType ="BelieveEvent";
			}else if(cboEventType.getSelectedIndex()==8) {
				eventType ="BirthdayEvent";
			}else if(cboEventType.getSelectedIndex()==9) {
				eventType ="WeddingEvent";
			}else if(cboEventType.getSelectedIndex()==10) {
				eventType ="PartyEvent";
			}else if(cboEventType.getSelectedIndex()==11) {
				eventType ="HomeComingEvent";
			}else {
				eventType ="etc...";
			}
    		
    		
    		
        	String venuePlace = "";
        	if(cboVenue.getSelectedIndex()==0) {
        		JOptionPane.showMessageDialog(frame,"Please Select VenuePlace");
        	}
        	if(cboVenue.getSelectedIndex()==1) {
        		venuePlace="Bar";
        	}else if(cboVenue.getSelectedIndex()==2) {
        		venuePlace="Pub";
        	}else if(cboVenue.getSelectedIndex()==3) {
        		venuePlace="Club";
        	}else if(cboVenue.getSelectedIndex()==4) {
        		venuePlace="Restaurant";
        	}else if(cboVenue.getSelectedIndex()==5) {
        		venuePlace="Hotel";
        	}else if(cboVenue.getSelectedIndex()==6) {
        		venuePlace="Conference Center";
        	}else if(cboVenue.getSelectedIndex()==7) {
        		venuePlace="Business Center";
        	}else if(cboVenue.getSelectedIndex()==8) {
        		venuePlace="Community Center";
        	}else if(cboVenue.getSelectedIndex()==9) {
        		venuePlace="Sport Club";
        	}else if(cboVenue.getSelectedIndex()==10) {
        		venuePlace="Art Gallery";
        	}else if(cboVenue.getSelectedIndex()==11) {
        		venuePlace="Academic Venue";
        	}else if(cboVenue.getSelectedIndex()==12) {
        		venuePlace="Stately Home";
        	}else if(cboVenue.getSelectedIndex()==13) {
        		venuePlace="Stadium And Arena";
        	}else if(cboVenue.getSelectedIndex()==14) {
        		venuePlace="Park and fields";
        	}else venuePlace="ect...";
        	
        	

        	
        	String venueType = "";
        	if(cboVenueType.getSelectedIndex()==0) {
        		JOptionPane.showMessageDialog(frame,"Please Select VenueType");
        	}
        	if(cboVenueType.getSelectedIndex()==1) {
        		venueType = "Indoor";
        	}else venueType = "Outdoor";
        	
        	
        	
        	String Day = "";
        	String Month = "";
        	String Year = "";
        	String Date;
        	
        	String foodItems = "";
        	if(listFoodItems.isSelectedIndex(-1)) {
        		JOptionPane.showMessageDialog(frame,"Please Select FoodItems");
        	}   	
        	if(listFoodItems.isSelectedIndex(0)) {
        		foodItems = "Brunch";
        	}else if(listFoodItems.isSelectedIndex(1)) {
        		foodItems = "Buffet";
            }else if(listFoodItems.isSelectedIndex(2)) {
            	foodItems = "Puddings";
            }else if(listFoodItems.isSelectedIndex(3)) {
            	foodItems = "Fine Dining";
            }else if(listFoodItems.isSelectedIndex(4)) {
            	foodItems = "Casual Dining";
            }else if(listFoodItems.isSelectedIndex(5)) {
            	foodItems = "Contemporary Casual";
            }else if(listFoodItems.isSelectedIndex(6)) {
            	foodItems = "Family Style";
            }else if(listFoodItems.isSelectedIndex(7)) {
            	foodItems = "Fast Casual";
            }else if(listFoodItems.isSelectedIndex(8)) {
            	foodItems = "Fast Food";
            }else if(listFoodItems.isSelectedIndex(9)) {
            	foodItems = "Cafe";
            }else if(listFoodItems.isSelectedIndex(10)) {
            	foodItems = "Food Trucks and Concession Stands";
            }else foodItems="Pop-Up Restaurant";
        	
        	
        	
        	String Equipments = "";
        	if(listEquipemt.getSelectedIndex()==-1) {
        		JOptionPane.showMessageDialog(frame, "Please Select Equipment");
        	}
        	else if(listEquipemt.getSelectedIndex()==0) {
        		Equipments = "Decorations";
        	}else Equipments = "Lightening";
        	
        	
        	String equipmentCost="";
    		int eCost;
    		
        	if(listEquipemt.getSelectedIndex()==0) {
        		equipmentCost = "20$";eCost=20;
        	}else {equipmentCost = "35$";eCost=35;
        		
        	}
        	txtEquipmentCost.setText(equipmentCost);


        	String foodItemsCost="";
        	int fCost = 0 ;
        	
            if(listFoodItems.isSelectedIndex(0)) {
            	foodItemsCost = "11$";fCost=11;
        	}else if(listFoodItems.isSelectedIndex(1)) {
        		foodItemsCost = "15$";fCost=15;
            }else if(listFoodItems.isSelectedIndex(2)) {
            	foodItemsCost = "15$";fCost=15;
            }else if(listFoodItems.isSelectedIndex(3)) {
            	foodItemsCost = "30$";fCost=30;
            }else if(listFoodItems.isSelectedIndex(4)) {
            	foodItemsCost = "12$";fCost=12;
            }else if(listFoodItems.isSelectedIndex(5)) {
            	foodItemsCost = "14$";fCost=14;
            }else if(listFoodItems.isSelectedIndex(6)) {
            	foodItemsCost = "15$";fCost=15;
            }else if(listFoodItems.isSelectedIndex(7)) {
            	foodItemsCost = "9$";fCost=9;
            }else if(listFoodItems.isSelectedIndex(8)) {
            	foodItemsCost = "10$";fCost=10;
            }else if(listFoodItems.isSelectedIndex(9)) {
            	foodItemsCost = "7$";fCost=7;
            }else if(listFoodItems.isSelectedIndex(10)) {
            	foodItemsCost = "8$";fCost=8;
            }else {
            	foodItemsCost="23$";fCost=23;
            }
            txtFoodItemCost.setText(foodItemsCost);


            String venueCost="";
            int vCost = 0;
            
            if(cboVenue.getSelectedIndex()==1) {
            	venueCost="1500$";vCost=1500;
        	}else if(cboVenue.getSelectedIndex()==2) {
        		venueCost="500$";vCost=500;
        	}else if(cboVenue.getSelectedIndex()==3) {
        		venueCost="2000$";vCost=2000;
        	}else if(cboVenue.getSelectedIndex()==4) {
        		venueCost="1800$";vCost=1800;
        	}else if(cboVenue.getSelectedIndex()==5) {
        		venueCost="3000$";vCost=3000;
        	}else if(cboVenue.getSelectedIndex()==6) {
        		venueCost="700$";vCost=700;
        	}else if(cboVenue.getSelectedIndex()==7) {
        		venueCost="1200$";vCost=1200;
        	}else if(cboVenue.getSelectedIndex()==8) {
        		venueCost="1300$";vCost=1300;
        	}else if(cboVenue.getSelectedIndex()==9) {
        		venueCost="1900$";vCost=1900;
        	}else if(cboVenue.getSelectedIndex()==10) {
        		venueCost="900$";vCost=900;
        	}else if(cboVenue.getSelectedIndex()==11) {
        		venueCost="600$";vCost=600;
        	}else if(cboVenue.getSelectedIndex()==12) {
        		venueCost="1350$";vCost=1350;
        	}else if(cboVenue.getSelectedIndex()==13) {
        		venueCost="2300$";vCost=2300;
        	}else if(cboVenue.getSelectedIndex()==14) {
        		venueCost="950$";vCost=950;
        	}else {
        		venueCost="Negotiate";
        	}
            txtVenueCost.setText(venueCost);
            System.out.println("VenueCost : "+venueCost);
            
            
            int Guests =(int)  Float.parseFloat(txtNoOfGuest.getText());
            
            
            int Total = (fCost*Guests)+(vCost+eCost); 
            txtTotalCost.setText("" + Total+"$");
        	
        	System.out.println(Total);
        	
        	AssignPassword.setTotal(Total);
           
           
    
        	if(cboDay.getSelectedIndex()==0) {
        		JOptionPane.showMessageDialog(frame,"Pleas Select Day");
    		}
        	if(cboDay.getSelectedIndex()==1) {
        		Day = "1";
    		}else if (cboDay.getSelectedIndex()==2) {
    			Day = "2";
    		}else if (cboDay.getSelectedIndex()==3) {
    			Day = "3";
    		}else if (cboDay.getSelectedIndex()==4) {
    			Day = "4";
    		}else if (cboDay.getSelectedIndex()==5) {
    			Day = "5";
    		}else if (cboDay.getSelectedIndex()==6) {
    			Day = "6";
    		}else if (cboDay.getSelectedIndex()==7) {
    			Day = "7";
    		}else if (cboDay.getSelectedIndex()==8) {
    			Day = "8";
    		}else if (cboDay.getSelectedIndex()==9) {
    			Day = "9";
    		}else if (cboDay.getSelectedIndex()==10) {
    			Day = "10";
    		}else if (cboDay.getSelectedIndex()==11) {
    			Day = "11";
    		}else if (cboDay.getSelectedIndex()==12) {
    			Day = "12";
    		}else if (cboDay.getSelectedIndex()==13) {
    			Day = "13";
    		}else if (cboDay.getSelectedIndex()==14) {
    			Day = "14";
    		}else if (cboDay.getSelectedIndex()==15) {
    			Day = "15";
    		}else if (cboDay.getSelectedIndex()==16) {
    			Day = "16";
    		}else if (cboDay.getSelectedIndex()==17) {
    			Day = "17";
    		}else if (cboDay.getSelectedIndex()==18) {
    			Day = "18";
    		}else if (cboDay.getSelectedIndex()==19) {
    			Day = "19";
    		}else if (cboDay.getSelectedIndex()==20) {
    			Day = "20";
    		}else if (cboDay.getSelectedIndex()==21) {
    			Day = "21";
    		}else if (cboDay.getSelectedIndex()==22) {
    			Day = "22";
    		}else if (cboDay.getSelectedIndex()==23) {
    			Day = "23";
    		}else if (cboDay.getSelectedIndex()==24) {
    			Day = "24";
    		}else if (cboDay.getSelectedIndex()==25) {
    			Day = "25";
    		}else if (cboDay.getSelectedIndex()==26) {
    			Day = "26";
    		}else if (cboDay.getSelectedIndex()==27) {
    			Day = "27";
    		}else if (cboDay.getSelectedIndex()==28) {
    			Day = "28";
    		}else if (cboDay.getSelectedIndex()==29) {
    			Day = "29";
    		}else if (cboDay.getSelectedIndex()==30)  {
    			Day = "30";
    		}else Day = "31";
    		
        	
        	if(cboMonth.getSelectedIndex()==0) {
    			JOptionPane.showMessageDialog(frame,"Please Select Month");
    		}
    		if(cboMonth.getSelectedIndex()==1) {
    			Month = "1"; 
    		}else if (cboMonth.getSelectedIndex()==2) {
    			Month = "2"; 
    		}else if (cboMonth.getSelectedIndex()==3) {
    			Month = "3"; 
    		}else if (cboMonth.getSelectedIndex()==4) {
    			Month = "4";
    		}else if (cboMonth.getSelectedIndex()==5) {
    			Month = "5"; 
    		}else if (cboMonth.getSelectedIndex()==6) {
    			Month = "6"; 
    		}else if (cboMonth.getSelectedIndex()==7) {
    			Month = "7"; 
    		}else if (cboMonth.getSelectedIndex()==8) {
    			Month = "8";
    		}else if (cboMonth.getSelectedIndex()==9) {
    			Month = "9";
    		}else if (cboMonth.getSelectedIndex()==10) {
    			Month = "10"; 
    		}else if (cboMonth.getSelectedIndex()==11) {
    			Month = "11"; 
    		}else {
    			Month = "12"; 
    		}
    		
    		
    		if(cboYear.getSelectedIndex()==0) {
    			JOptionPane.showMessageDialog(frame,"Pleas Select Year");
    		}
    		if(cboYear.getSelectedIndex()==1) {
    			Year= "2022";
    		}else if(cboYear.getSelectedIndex()==2) {
    			Year= "2023";
    		}else if(cboYear.getSelectedIndex()==3) {
    			Year= "2024";
    		}else if(cboYear.getSelectedIndex()==4) {
    			Year= "2025";
    		}else if(cboYear.getSelectedIndex()==5) {
    			Year= "2026";
    		}else if(cboYear.getSelectedIndex()==6) {
    			Year= "2027";
    		}else if(cboYear.getSelectedIndex()==7) {
    			Year= "2028";
    		}else if(cboYear.getSelectedIndex()==8) {
    			Year= "2029";
    		}else if(cboYear.getSelectedIndex()==9) {
    			Year= "2030";
    		}else if(cboYear.getSelectedIndex()==10) {
    			Year= "2031";
    		}else if(cboYear.getSelectedIndex()==11) {
    			Year= "2032";
    		}else if(cboYear.getSelectedIndex()==12) {
    			Year= "2033";
    		}else if(cboYear.getSelectedIndex()==13) {
    			Year= "2034";
    		}else if(cboYear.getSelectedIndex()==14) {
    			Year= "2035";
    		}else if(cboYear.getSelectedIndex()==15) {
    			Year= "2036";
    		}else if(cboYear.getSelectedIndex()==16) {
    			Year= "2037";
    		}else if(cboYear.getSelectedIndex()==17) {
    			Year= "2038";
    		}else if(cboYear.getSelectedIndex()==18) {
    			Year= "2039";
    		}else if(cboYear.getSelectedIndex()==19) {
    			Year= "2040";
    		}else if(cboYear.getSelectedIndex()==20) {
    			Year= "2041";
    		}else if(cboYear.getSelectedIndex()==21) {
    			Year= "2042";
    		}else if(cboYear.getSelectedIndex()==22) {
    			Year= "2043";
    		}else if(cboYear.getSelectedIndex()==23) {
    			Year= "2044";
    		}else if(cboYear.getSelectedIndex()==24) {
    			Year= "2045";
    		}else if(cboYear.getSelectedIndex()==25) {
    			Year= "2046";
    		}else if(cboYear.getSelectedIndex()==26) {
    			Year= "2047";
    		}else if(cboYear.getSelectedIndex()==27) {
    			Year= "2048";
    		}else if(cboYear.getSelectedIndex()==28) {
    			Year= "2049";
    		}else if(cboYear.getSelectedIndex()==29) {
    			Year= "2050";
    		}else if(cboYear.getSelectedIndex()==30) {
    			Year= "2051";
    		}else if(cboYear.getSelectedIndex()==31) {
    			Year= "2052";
    		}else if(cboYear.getSelectedIndex()==32) {
    			Year= "2053";
    		}else if(cboYear.getSelectedIndex()==33) {
    			Year= "2054";
    		}else if(cboYear.getSelectedIndex()==34) {
    			Year= "2055";
    		}else if(cboYear.getSelectedIndex()==35) {
    			Year= "2056";
    		}else if(cboYear.getSelectedIndex()==36) {
    			Year= "2057";
    		}else if(cboYear.getSelectedIndex()==37) {
    			Year= "2058";
    		}else if(cboYear.getSelectedIndex()==38) {
    			Year= "2059";
    		}else if(cboYear.getSelectedIndex()==39) {
    			Year= "2060";
    		}else if(cboYear.getSelectedIndex()==40) {
    			Year= "2061";
    		}else if(cboYear.getSelectedIndex()==41) {
    			Year= "2062";
    		}else if(cboYear.getSelectedIndex()==42) {
    			Year= "2063";
    		}else if(cboYear.getSelectedIndex()==43) {
    			Year= "2064";
    		}else if(cboYear.getSelectedIndex()==44) {
    			Year= "2065";
    		}else if(cboYear.getSelectedIndex()==45) {
    			Year= "2066";
    		}else if(cboYear.getSelectedIndex()==46) {
    			Year= "2067";
    		}else if(cboYear.getSelectedIndex()==47) {
    			Year= "2068";
    		}else if(cboYear.getSelectedIndex()==48) {
    			Year= "2069";
    		}else if(cboYear.getSelectedIndex()==49) {
    			Year= "2070";
    		}else if(cboYear.getSelectedIndex()==50) {
    			Year= "2071";
    		}else if(cboYear.getSelectedIndex()==51) {
    			Year= "2072";
    		}else if(cboYear.getSelectedIndex()==52) {
    			Year= "2073";
    		}else if(cboYear.getSelectedIndex()==53) {
    			Year= "2074";
    		}else if(cboYear.getSelectedIndex()==54) {
    			Year= "2075";
    		}else if(cboYear.getSelectedIndex()==55) {
    			Year= "2076";
    		}else if(cboYear.getSelectedIndex()==56) {
    			Year= "2077";
    		}else if(cboYear.getSelectedIndex()==57) {
    			Year= "2078";
    		}else if(cboYear.getSelectedIndex()==58) {
    			Year= "2079";
    		}else if(cboYear.getSelectedIndex()==59) {
    			Year= "2080";
    		}else if(cboYear.getSelectedIndex()==60) {
    			Year= "2081";
    		}else if(cboYear.getSelectedIndex()==61) {
    			Year= "2082";
    		}else if(cboYear.getSelectedIndex()==62) {
    			Year= "2083";
    		}else if(cboYear.getSelectedIndex()==63) {
    			Year= "2084";
    		}else if(cboYear.getSelectedIndex()==64) {
    			Year= "2085";
    		}else if(cboYear.getSelectedIndex()==65) {
    			Year= "2086";
    		}else if(cboYear.getSelectedIndex()==66) {
    			Year= "2087";
    		}else if(cboYear.getSelectedIndex()==67) {
    			Year= "2088";
    		}else if(cboYear.getSelectedIndex()==68) {
    			Year= "2089";
    		}else if(cboYear.getSelectedIndex()==69) {
    			Year= "2090";
    		}else if(cboYear.getSelectedIndex()==70) {
    			Year= "2091";
    		}else if(cboYear.getSelectedIndex()==71) {
    			Year= "2092";
    		}else if(cboYear.getSelectedIndex()==72) {
    			Year= "2093";
    		}else Year= "2094";
    		

        	
    		Date = Year +"-"+ Day +"-"+ Month;
            AssignPassword.setDate(Date);
    		
			System.out.println("Event Type : "+eventType);
    		System.out.println("VenuePlace : "+venuePlace);
    		System.out.println("VenueType  : "+venueType);
         	System.out.println("Date : "+Date);
         	System.out.println("FoodItem   : "+foodItems);
         	System.out.println("Equipment  : "+Equipments);
         	System.out.println("No of Guest: "+Guests);
         	
    		
    		int getID = AssignPassword.getId();
         	
    		try {
    			connectionWithDatabase.connection();
				java.sql.Statement s = connectionWithDatabase.getCON().createStatement();
	        	String sql = "INSERT INTO `eventsmanagementsystem`.`tbl_bookingview` (`EventManagerID`, `EventType`, `VenuePlace`, `VenueType`, `EventDate`, `FoodItems`, `Equipment`, `Guests`, `EventCost`, `PaymentStatus`)  VALUES ("+getID+", '"+eventType+"', '"+venuePlace+"', '"+venueType+"', '"+Date+"', '"+foodItems+"', '"+Equipments+"', "+Guests+", "+Total+", '')   ";
				//INSERT INTO `eventsmanagementsystem`.`tbl_bookingview` (`EventManagerID`, `EventType`, `VenuePlace`, `VenueType`, `EventDate`, `FoodItems`, `Equipment`, `Guests`, `EventCost`, `PaymentStatus`) VALUES (7879, '1', '1', '1', '1', '1', '1', 1, 1, '1')
	  
	        	s.execute(sql);      
	        	
	        	
	        	Component frame = null;
				int show = JOptionPane.showConfirmDialog(frame,"Do u want to Book?","Please Select Yes or No!!!"
			               ,JOptionPane.YES_NO_CANCEL_OPTION,
			               JOptionPane.INFORMATION_MESSAGE);

				if(show == JOptionPane.YES_OPTION){
		               //frmInvoice.main(null);
					frmPayment.main(null);
		               dispose();
		            } else if(show == JOptionPane.NO_OPTION ){
		               
		            }
		            else {
		            	frmUserDetail.main(null);
			               dispose();
		            }
	        	
	        	
    			//JOptionPane.showMessageDialog(frame,"Success");      
			} catch (Exception e2) {
				
			}
    		
    		
    		
    		
    		
    	}
    });
    btnNewSubmit.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Saved Pictures\\tick.png"));
    btnNewSubmit.setForeground(Color.WHITE);
    btnNewSubmit.setFont(new Font("Arial", Font.BOLD, 20));
    btnNewSubmit.setBackground(Color.GREEN);
    btnNewSubmit.setBounds(544, 631, 167, 40);
    getContentPane().add(btnNewSubmit);
    
   
    
    
    
   
    }
     
   
    public static void main(String[] args){
    	try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		} catch (Exception e) {
			// TODO: handle exception
		}
        new frmBookEvent();
        
    }
   }