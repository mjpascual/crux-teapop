package com.upou.teapop.dao;

//STEP 1. Import required packages
import java.sql.Connection;

import com.upou.teapop.util.ConnectionManager;

public abstract class BaseDao {
	
	private ConnectionManager connectionManager;
	
	public Connection createConnection(){
		connectionManager = new ConnectionManager();
		return connectionManager.createConnection();
	}
	
	public void closeConnection(){
		connectionManager.closeConnection();
	}

}
