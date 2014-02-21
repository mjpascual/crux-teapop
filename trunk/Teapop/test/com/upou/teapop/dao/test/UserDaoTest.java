package com.upou.teapop.dao.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.upou.teapop.data.User;
import com.upou.teapop.util.ConnectionManager;

public class UserDaoTest {


	static ConnectionManager connectionManager;
	static Connection connection;

	@BeforeClass
	public static void start() {
		connectionManager = new ConnectionManager();
		connection = connectionManager.createConnection();
	}

	@AfterClass
	public static void end() {
		connectionManager.closeConnection();
	}
	
//	@Ignore
	@Test
	public void viewUser() {

		String username = "tim123";
		String password = "admin";
				
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM teapop.user WHERE username = ? AND password = ?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();

			User user = new User();
			while (rs.next()) {
				user.setUserId(rs.getInt("user_id"));
				user.setDisplayName(rs.getString("display_name"));
			}
			
			assertEquals(user.getDisplayName(), "Tim Josef Tan");

			stmt.close();
			rs.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
}
