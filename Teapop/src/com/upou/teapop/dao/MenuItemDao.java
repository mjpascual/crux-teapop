package com.upou.teapop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.upou.teapop.data.MenuItem;


public class MenuItemDao extends BaseDao {

	public boolean createItem(MenuItem MenuItem) {
		boolean result = false;
		try {
			Connection conn = createConnection();
			Statement stmt = conn.createStatement();

			String query = "INSERT INTO menu (menu_id, price) "
					+ "VALUES ('"
					+ MenuItem.getItemCode()
					+ "')";

			stmt.executeUpdate(query);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
	

	public MenuItem retrieveItem(int itemId) {
		MenuItem item = new MenuItem();
		try {
			Connection conn = createConnection();

			// get category info
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM teapop.product";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				item.setDesc(rs.getString("description"));
				item.setItemId(rs.getInt("product_id"));
				item.setName(rs.getString("name"));
			}
			conn.close();
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}

	public boolean updateItem(MenuItem menuItem) {
		boolean result = false;
		try {
			Connection conn = createConnection();
			Statement stmt = conn.createStatement();

			String query = "INSERT VALUES() INTO menu";

			stmt.executeQuery(query);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean deleteItem(String id) {
		boolean result = false;
		try {
			Connection conn = createConnection();
			Statement stmt = conn.createStatement();

			String query = "DELETE FROM items WHERE id=" + id;

			stmt.executeQuery(query);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
}
