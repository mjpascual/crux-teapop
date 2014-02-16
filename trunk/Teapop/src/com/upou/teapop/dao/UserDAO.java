package com.upou.teapop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.upou.teapop.data.Category;
import com.upou.teapop.data.Item;
import com.upou.teapop.data.User;

public class UserDAO extends BaseDao{
	
	// CREATE
	public boolean createUser(User user) {
		boolean result = false;
		try {
			Connection conn = createConnection();
			Statement stmt = conn.createStatement();
			
			String query = "INSERT VALUES() INTO user";
			
			stmt.executeQuery(query);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// RETRIEVE
	public List<User> retrieveUsers(){
			
			List<User> users = new ArrayList<User>();
			try {
				Connection conn = createConnection();
				
				// get category info
				Statement stmt = conn.createStatement();
				String query = "SELECT * FROM user";
				ResultSet rs = stmt.executeQuery(query);

				while (rs.next()) {
					User user = new User();
					user.setUserId(rs.getInt("user_id"));
					user.setAccessLevel(rs.getInt("access_level"));
					user.setFirstName("firstName");
					user.setLastName("lastName");
					user.setPosition("positio");
					user.setUsername("username");
					user.setPassword("password");
					user.setEmail("email");
					users.add(user);
				}
				conn.close();
				stmt.close();
				rs.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return users;
		}
	
	// UPDATE
	public boolean updateUser(User user) {
		boolean result = false;
		try {
			Connection conn = createConnection();
			Statement stmt = conn.createStatement();
			
			String query = "UPDATE user SET password = '' WHERE user_id ="+ user.getUserId();
			
			stmt.executeQuery(query);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// DELETE
	public boolean deleteUser(String id) {
		boolean result = false;
		try {
			Connection conn = createConnection();
			Statement stmt = conn.createStatement();
			
			String query = "DELETE FROM user WHERE id=" + id;
			
			stmt.executeQuery(query);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
