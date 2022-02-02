package com.booking.event;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Color;

public class frmIN {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmIN window = new frmIN();
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
	public frmIN() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1361, 751);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeTo = new JLabel("Event Manager Name :");
		lblWelcomeTo.setFont(new Font("Arial", Font.BOLD, 20));
		lblWelcomeTo.setBounds(41, 69, 214, 56);
		frame.getContentPane().add(lblWelcomeTo);
		
		JLabel lblNamemanager = new JLabel("RiTH");
		lblNamemanager.setFont(new Font("Arial", Font.BOLD, 20));
		lblNamemanager.setBounds(257, 69, 214, 56);
		frame.getContentPane().add(lblNamemanager);
		
		JLabel lblInvoice = new JLabel("Invoice");
		lblInvoice.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvoice.setFont(new Font("Baskerville Old Face", Font.BOLD, 40));
		lblInvoice.setBounds(549, 46, 214, 56);
		frame.getContentPane().add(lblInvoice);
		
		JLabel lblWelcomeTo_1 = new JLabel("***********************************************************************************************************\r\n**************************************************");
		lblWelcomeTo_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblWelcomeTo_1.setBounds(40, 120, 1260, 56);
		frame.getContentPane().add(lblWelcomeTo_1);
		
		JLabel lblEventBookingEvent = new JLabel("Event Booking ");
		lblEventBookingEvent.setFont(new Font("Arial", Font.BOLD, 20));
		lblEventBookingEvent.setBounds(574, 155, 156, 56);
		frame.getContentPane().add(lblEventBookingEvent);
		
		JLabel lblWelcomeTo_1_1 = new JLabel("***********************************************************************************************************\r\n**************************************************");
		lblWelcomeTo_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblWelcomeTo_1_1.setBounds(40, 191, 1260, 56);
		frame.getContentPane().add(lblWelcomeTo_1_1);
		
		JLabel lblEventManagerId = new JLabel("Event Manager ID :");
		lblEventManagerId.setFont(new Font("Arial", Font.BOLD, 20));
		lblEventManagerId.setBounds(40, 257, 193, 56);
		frame.getContentPane().add(lblEventManagerId);
		
		JLabel lblIdmanager = new JLabel("xxxxxx");
		lblIdmanager.setFont(new Font("Arial", Font.BOLD, 20));
		lblIdmanager.setBounds(230, 257, 132, 56);
		frame.getContentPane().add(lblIdmanager);
		
		JLabel lblB = new JLabel("Booking ID");
		lblB.setFont(new Font("Arial", Font.BOLD, 20));
		lblB.setBounds(40, 303, 122, 56);
		frame.getContentPane().add(lblB);
		
		JLabel lblE = new JLabel("Event Type");
		lblE.setFont(new Font("Arial", Font.BOLD, 20));
		lblE.setBounds(306, 303, 122, 56);
		frame.getContentPane().add(lblE);
		
		JLabel lblV = new JLabel("Venue");
		lblV.setFont(new Font("Arial", Font.BOLD, 20));
		lblV.setBounds(516, 303, 78, 56);
		frame.getContentPane().add(lblV);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(40, 311, 1260, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblG = new JLabel("Guest Count");
		lblG.setFont(new Font("Arial", Font.BOLD, 20));
		lblG.setBounds(691, 303, 132, 56);
		frame.getContentPane().add(lblG);
		
		JLabel Date = new JLabel(" Event Date :");
		Date.setFont(new Font("Arial", Font.BOLD, 20));
		Date.setBounds(979, 257, 244, 56);
		frame.getContentPane().add(Date);
		
		JLabel lblDate = new JLabel("xxxxxx");
		lblDate.setFont(new Font("Arial", Font.BOLD, 20));
		lblDate.setBounds(1209, 257, 91, 56);
		frame.getContentPane().add(lblDate);
		
		JLabel lblI = new JLabel("Items");
		lblI.setFont(new Font("Arial", Font.BOLD, 20));
		lblI.setBounds(947, 303, 64, 56);
		frame.getContentPane().add(lblI);
		
		JLabel lblC = new JLabel("Cost");
		lblC.setFont(new Font("Arial", Font.BOLD, 20));
		lblC.setBounds(1131, 303, 64, 56);
		frame.getContentPane().add(lblC);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(40, 359, 1260, 2);
		frame.getContentPane().add(separator_1);
		
		JLabel lblCost = new JLabel("xxxxx");
		lblCost.setFont(new Font("Arial", Font.BOLD, 20));
		lblCost.setBounds(1128, 358, 141, 56);
		frame.getContentPane().add(lblCost);
		
		JLabel lblItems = new JLabel("xxxxx");
		lblItems.setFont(new Font("Arial", Font.BOLD, 20));
		lblItems.setBounds(950, 358, 182, 56);
		frame.getContentPane().add(lblItems);
		
		JLabel lblGuest = new JLabel("xxxxxx");
		lblGuest.setFont(new Font("Arial", Font.BOLD, 20));
		lblGuest.setBounds(691, 358, 132, 56);
		frame.getContentPane().add(lblGuest);
		
		JLabel lblVenue = new JLabel("xxxxx");
		lblVenue.setFont(new Font("Arial", Font.BOLD, 20));
		lblVenue.setBounds(519, 358, 162, 56);
		frame.getContentPane().add(lblVenue);
		
		JLabel lblEventType = new JLabel("xxxxxx");
		lblEventType.setFont(new Font("Arial", Font.BOLD, 20));
		lblEventType.setBounds(306, 358, 198, 56);
		frame.getContentPane().add(lblEventType);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(40, 415, 1260, 2);
		frame.getContentPane().add(separator_2);
		
		JLabel lblBookingID = new JLabel("xxxxx");
		lblBookingID.setFont(new Font("Arial", Font.BOLD, 20));
		lblBookingID.setBounds(40, 358, 122, 56);
		frame.getContentPane().add(lblBookingID);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBounds(30, 466, 1260, 2);
		frame.getContentPane().add(separator_3);
		
		JLabel lblTotalCost = new JLabel("Total Cost\r\n");
		lblTotalCost.setFont(new Font("Arial", Font.BOLD, 20));
		lblTotalCost.setBounds(40, 412, 122, 56);
		frame.getContentPane().add(lblTotalCost);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(50, 500, 100, 82);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblmanagerSignature = new JLabel("(Manager Signature)");
		lblmanagerSignature.setFont(new Font("Arial", Font.BOLD, 20));
		lblmanagerSignature.setBounds(30, 560, 214, 56);
		frame.getContentPane().add(lblmanagerSignature);
		
		JLabel lblThanksYouFor = new JLabel("Thanks You For Your Business!!");
		lblThanksYouFor.setFont(new Font("Arial", Font.BOLD, 20));
		lblThanksYouFor.setBounds(979, 500, 321, 56);
		frame.getContentPane().add(lblThanksYouFor);
		
		JLabel lblTotal = new JLabel("xxxxx");
		lblTotal.setFont(new Font("Arial", Font.BOLD, 20));
		lblTotal.setBounds(1126, 415, 122, 56);
		frame.getContentPane().add(lblTotal);
	}

}
