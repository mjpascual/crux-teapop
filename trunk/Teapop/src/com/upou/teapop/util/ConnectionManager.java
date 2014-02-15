package com.upou.teapop.util;

//STEP 1. Import required packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private final String driverName = "com.mysql.jdbc.Driver";
	private final String connectionUrl = "jdbc:mysql://localhost:3306/student";
	private final String userName = "root";
	private final String userPass = "root";

	private Connection con = null;

	public ConnectionManager() {
		try {
			// Loading Driver for MySql
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}
	}

	public Connection createConnection() {
		try {
			con = DriverManager.getConnection(connectionUrl, userName, userPass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public void closeConnection() {
		try {
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		ConnectionManager con = new ConnectionManager();
		con.createConnection();
		con.closeConnection();
	}
}
