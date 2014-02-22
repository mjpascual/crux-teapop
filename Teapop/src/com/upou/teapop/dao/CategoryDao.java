package com.upou.teapop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.upou.teapop.data.Category;

public class CategoryDao extends BaseDao {
	
	private static final String CATEGORY_CREATE   = "INSERT INTO teapop.category (category_id, main_category, name, description, image_name, show_sml) " +
												    "VALUES (?, ?, ?, ?, ?, ?) " +
												    "ON DUPLICATE KEY UPDATE category_id=VALUES(category_id), main_category=VALUES(main_category), name=VALUES(name),  description=VALUES(description), image_name=VALUES(image_name), show_sml=VALUES(show_sml)";

	private static final String CATEGORY_VIEW     = "SELECT * FROM teapop.category WHERE category_id = ?";
	
	private static final String CATEGORY_VIEW_ALL = "SELECT * FROM teapop.category";
	
	private static final String CATEGORY_DELETE   = "DELETE FROM teapop.category WHERE category_id = ?";
	
	public boolean createCategory(Category category) {
		boolean result = false;
		try {
			Connection conn = createConnection();
			PreparedStatement stmt = conn.prepareStatement(CATEGORY_CREATE);

			stmt.setInt(1, category.getCategoryId());
			stmt.setString(2, category.getMain());
			stmt.setString(3, category.getName());
			stmt.setString(4, category.getDesc());
			stmt.setString(5, category.getImage());
			stmt.setString(6, category.getShowSML());
	
			stmt.executeUpdate();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Category retrieveCategory(int categoryId) {
		Category category = new Category();
		try {
			
			Connection conn = createConnection();

			PreparedStatement stmt = conn.prepareStatement(CATEGORY_VIEW);
			stmt.setInt(1, categoryId);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				category.setDesc(rs.getString("description"));
				category.setName(rs.getString("name"));
				category.setMain(rs.getString("main_category"));
				category.setImage(rs.getString("image_name"));
				category.setShowSML(rs.getString("show_sml"));
			}
			conn.close();
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return category;
	}

	public List<Category> retrieveCategories() {

		List<Category> categories = new ArrayList<Category>();
		try {
			Connection conn = createConnection();
			
			PreparedStatement stmt = conn.prepareStatement(CATEGORY_VIEW_ALL);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Category category = new Category();
				category.setCategoryId(rs.getInt("category_id"));
				category.setDesc(rs.getString("description"));
				category.setName(rs.getString("name"));
				category.setMain(rs.getString("main_category"));
				category.setImage(rs.getString("image_name"));
				category.setShowSML(rs.getString("show_sml"));
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
	
	public boolean deleteCategory(int id) {
		boolean result = false;
		try {
			Connection conn = createConnection();
			
			PreparedStatement stmt = conn.prepareStatement(CATEGORY_DELETE);
			stmt.setInt(1, id);
			stmt.executeUpdate();

			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
