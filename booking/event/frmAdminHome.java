package com.booking.event;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JEditorPane;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class frmAdminHome {

	private JFrame frame;

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
					frmAdminHome window = new frmAdminHome();
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
	public frmAdminHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Downloads\\icons8_management_64.png"));
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Admin");
		lblNewLabel.setBounds(10, 10, 193, 56);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Venue Management");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmVenueManagement.main(null);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(47, 219, 257, 154);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Food Management");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmFoodManagement.main(null);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(514, 219, 257, 154);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_1.setBackground(Color.BLACK);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Equipment Management");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEquipmentManagement.main(null);
				frame.dispose();
			}
		});
		btnNewButton_2.setBounds(978, 219, 257, 154);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_2.setBackground(Color.BLACK);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View Booking");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBookingView.main(null);
				frame.dispose();
			}
		});
		btnNewButton_3.setBounds(284, 492, 257, 154);
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_3.setBackground(Color.BLACK);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_1_1 = new JButton("Manage Notifications");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNotifications.main(null);
				frame.dispose();
			}
		});
		btnNewButton_1_1.setBounds(751, 492, 257, 154);
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_1_1.setBackground(Color.BLACK);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_2_1 = new JButton("Logout");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdmin.main(null);
				frame.dispose();
			}
		});
		btnNewButton_2_1.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\Saved Pictures\\logout_rounded_left_50px.png"));
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_2_1.setBackground(Color.RED);
		btnNewButton_2_1.setBounds(1111, 10, 169, 56);
		frame.getContentPane().add(btnNewButton_2_1);
		
		JLabel lblNewLabel_1 = new JLabel("Staff Management");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frmStaff.main(null);
				frame.dispose();
				
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\user\\OneDrive\\Pictures\\MS\\staff_50px.png"));
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_1.setBounds(323, 64, 661, 67);
		frame.getContentPane().add(lblNewLabel_1);
		frame.setBounds(100, 100, 1304, 721);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
