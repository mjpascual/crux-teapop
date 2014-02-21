package com.upou.teapop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.upou.teapop.data.Category;

public class CategoryDao extends BaseDao {

	public boolean createCategory(Category category) {
		boolean result = false;
		try {
			Connection conn = createConnection();
			Statement stmt = conn.createStatement();

			String query = "INSERT INTO teapop.category(name, description, image_name) VALUES "
					+ "('"
					+ category.getName()
					+ "', '"
					+ category.getDesc()
					+ "', '" + category.getImage() + "')";

			stmt.executeUpdate(query);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// RETRIEVE
	public List<Category> retrieveCategories() {

		List<Category> categories = new ArrayList<Category>();
		try {
			Connection conn = createConnection();

			// get category info
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM category";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Category category = new Category();
				category.setDesc(rs.getString("description"));
				category.setCategoryId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				categories.add(category);
			}
			conn.close();
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return categories;
	}
	
	public Category retrieveCategory(String categoryId) {
		Category category = new Category();
		try {
			Connection conn = createConnection();

			// get category info
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM category";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				category.setDesc(rs.getString("description"));
				category.setCategoryId(rs.getInt("id"));
				category.setName(rs.getString("name"));
			}
			conn.close();
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return category;
	}
	
	public boolean updateCategory(Category category) {
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
	
	public boolean deleteCategory(String id) {
		boolean result = false;
		try {
			Connection conn = createConnection();
			Statement stmt = conn.createStatement();

			String query = "DELETE FROM category WHERE id=" + id;

			stmt.executeQuery(query);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
