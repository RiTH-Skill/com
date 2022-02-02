package com.booking.event;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class connectionWithDatabase {

private static Connection CON;

public static Connection getCON() {
	return CON;
}

public static void setCON(Connection cON) {
	CON = cON;
}

	public static void connection()  {
		 
	     try {
	    	 //driver class of mysql
	    	 Class.forName("com.mysql.jdbc.Driver");
	    	 //connect local db_name
		       CON=DriverManager.getConnection("jdbc:mysql://localhost:3306/eventsmanagementsystem","root",""); 
	     } catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public static PreparedStatement prepareStatement(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
