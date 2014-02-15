package com.upou.teapop.dao;

//STEP 1. Import required packages
import java.sql.Connection;

import com.upou.teapop.util.ConnectionManager;

public abstract class BaseDao {
	
	private ConnectionManager conn;
	
	public Connection createConnection(){
		conn = new ConnectionManager();
		return conn.createConnection();
	}
	
	public void closeConnection(){
		conn.closeConnection();
	}

}
