package com.booking.event;

import javax.swing.ImageIcon;

public class AssignPassword {
	private static String password;
	private static String password1;
	private static String Date;
	private static String Notifications;
	private static String Notifications2;
	private static int Total;
	
	

	
	
	public static int getTotal() {
		return Total;
	}

	public static void setTotal(int total) {
		Total = total;
	}

	public static String getNotifications2() {
		return Notifications2;
	}

	public static void setNotifications2(String notifications2) {
		Notifications2 = notifications2;
	}

	public static String getNotifications() {
		return Notifications;
	}

	public static void setNotifications(String notifications) {
		Notifications = notifications;
	}

	public static String getDate() {
		return Date;
	}

	public static void setDate(String date) {
		Date = date;
	}

	public static String getPassword1() {
		return password1;
	}

	public static void setPassword1(String password1) {
		AssignPassword.password1 = password1;
	}

	private static int id;
	private static String name;

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		AssignPassword.name = name;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		AssignPassword.id = id;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		AssignPassword.password = password;
	}
}
