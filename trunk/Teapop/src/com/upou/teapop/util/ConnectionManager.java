package com.upou.teapop.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.upou.teapop.constants.DBConstants;

public class ConnectionManager {

	private String driverName;
	private String connectionUrl;
	private String userName;
	private String userPass;

	public Connection con = null;
	
	public ConnectionManager() {
		try {
			loadPropertiesFile();
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}
	}

	public Connection createConnection() {
		try {
			if (con == null) {
				con = DriverManager.getConnection(connectionUrl, userName, userPass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public void closeConnection() {
		try {
			if (con != null) {
				this.con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void loadPropertiesFile(){
		try {
			Properties prop = new Properties();
			InputStream in = getClass().getClassLoader().getResourceAsStream(DBConstants.PROPERIES_JDBC);
			prop.load(in);
			driverName = prop.getProperty(DBConstants.DRIVER_PROP);
	        connectionUrl = prop.getProperty(DBConstants.CONN_URL_PROP);
	        userName = prop.getProperty(DBConstants.USERNAME_PROP);
	        userPass = prop.getProperty(DBConstants.PASSWORD_PROP);
		} catch (IOException e) {
			e.printStackTrace();
		}
       
	}

	public static void main(String args[]) {
		ConnectionManager con = new ConnectionManager();
		con.createConnection();
		con.closeConnection();
	}
}
