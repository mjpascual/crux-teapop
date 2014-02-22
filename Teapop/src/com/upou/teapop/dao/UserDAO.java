package com.upou.teapop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.upou.teapop.data.User;


public class UserDAO extends BaseDao{
	
	private static final String USER_VIEW     = "SELECT * FROM teapop.user WHERE username = ? AND password = ?";
	
	public User retrieveUser(String username, String password){
		User user = new User();
		try {
			
			Connection conn = createConnection();

			PreparedStatement stmt = conn.prepareStatement(USER_VIEW);
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				user.setUserId(rs.getInt("user_id"));
				user.setDisplayName(rs.getString("display_name"));
			}
			conn.close();
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
